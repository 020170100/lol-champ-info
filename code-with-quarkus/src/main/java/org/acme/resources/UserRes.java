package org.acme.resources;

import org.acme.NewUser;
import org.acme.dao.UserDao;
import org.acme.model.User;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.NoSuchAlgorithmException;

@Transactional
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserRes {

    @Inject
    UserDao dao;

    @POST
    @Path("/register")
    public Response registerUser(NewUser newUser) {
        dao.registerUser(newUser);
        return Response.ok().build();
    }

    @POST
    @Path("/login")
    public Response login(NewUser user) {
        if(dao.login(user)) {
            return Response.ok().build();
        }
        else {
            return Response.status(400, "Login not correct").build();
        }
    }
}
