package org.acme.resources;

import org.acme.dao.ChampDao;
import org.acme.model.Champion;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Transactional
@Produces(MediaType.APPLICATION_JSON)
@Path("/champ")
public class ChampRes {
    @Inject
    ChampDao dao;

    @GET
    public List<Champion> getAll(){
        return dao.getAll();
    }

    @GET
    @Path("/{id}")
    public Champion getById(@PathParam int id ){
        return dao.getById(id);
    }

    @POST
    public Response create(Champion c){
        return Response.ok(dao.createChampion(c)).status(Response.Status.CREATED).build();
    }

    @PUT
    public Response update(Champion c){
        return Response.ok(dao.updateChampion(c)).status(Response.Status.ACCEPTED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam int id){
        return Response.ok(dao.deleteChampion(id)).status(Response.Status.ACCEPTED).build();
    }

}
