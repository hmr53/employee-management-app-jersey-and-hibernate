package org.hasith.ems.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.glassfish.jersey.server.mvc.Viewable;

@Path("/")
public class AllRequestController {
    @GET
    public Viewable home(){

        return new Viewable("/login");
    }
}
