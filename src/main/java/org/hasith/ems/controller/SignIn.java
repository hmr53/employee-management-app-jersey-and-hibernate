package org.hasith.ems.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.glassfish.jersey.server.mvc.Viewable;

@Path("/sign-in")
public class SignIn {
    @GET
    public Viewable signin(){
        return new Viewable("/login");
    }

}
