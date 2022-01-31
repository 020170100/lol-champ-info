package org.acme.dao;

import org.acme.NewUser;
import org.acme.PasswordManager;
import org.acme.model.User;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Named
@Dependent
public class UserDao {

    @Inject
    EntityManager em;

    public void registerUser(NewUser newUser) {
        byte[] salt = PasswordManager.getNextSalt();
        byte[] passwordHash = PasswordManager.hash(newUser.getPassword().toCharArray(), salt);
        User user = new User();
        user.setName(newUser.getUsername());
        user.setPasswordHash(passwordHash);
        user.setSalt(salt);
        em.persist(user);
    }

    public boolean login(NewUser newUser) {
        User user = em.find(User.class, newUser.getUsername());
        if(PasswordManager.isExpectedPassword(newUser.getPassword().toCharArray(), user.getSalt(), user.getPasswordHash())) {
            return true;
        }
        return false;
    }
}


