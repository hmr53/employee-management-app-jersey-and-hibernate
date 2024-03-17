package org.hasith.ems.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.glassfish.jersey.server.mvc.Viewable;
import org.hasith.ems.annotations.IsUser;

@IsUser
@Path("/home")
public class HomeController {
    @GET
    public Viewable home(){
        return new Viewable("/index");
    }
}
