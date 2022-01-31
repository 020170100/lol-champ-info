package org.acme.resources;

import org.acme.dao.UserDao;
import org.acme.model.User;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Transactional
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserRes {

    @Inject
    UserDao dao;

    @POST
    @Path("/register")
    public Response registerUser(User user) {
        return Response.ok(dao.registerUser(user)).build();
    }
}
