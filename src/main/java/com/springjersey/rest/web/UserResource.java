package com.springjersey.rest.web;

import com.springjersey.rest.usermanagement.entity.User;
import com.springjersey.rest.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/users")
@Produces("application/json")
@Controller
public class UserResource {

    @Autowired
    private UserService userService;

    @GET
    @Path("/")
    public Response getUsers() {
        List<User> userList = userService.readAll();
        return Response.status(200).entity(userList).build();
    }

    @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id") long id) {
        User u = userService.read(id);
        return Response.status(200).entity(u).build();
    }

    @GET
    @Path("/name/{name}")
    public Response findUser(@PathParam("name") String name) {
        User u = userService.readUser(name);
        return Response.ok().entity(u).build();
    }
    
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(User u) {
        User user = userService.saveUser(u);
        return Response.ok().entity(user).build();
    }

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(User u) {
        User user = userService.saveUser(u);
        return Response.ok().entity(user).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") long id) {
        userService.deleteUserById(id);
        return Response.ok().build();
    }

}
