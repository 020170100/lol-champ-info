package org.acme.dao;

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

    public User registerUser(User user) {

        return null;
    }
}
