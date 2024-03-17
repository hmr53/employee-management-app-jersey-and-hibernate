package org.hasith.ems.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.glassfish.jersey.server.mvc.Viewable;
import org.hasith.ems.annotations.IsUser;

@IsUser
@Path("/employee-view")
public class EmployeeView {
    @GET
    public Viewable employee_add(){
        return new Viewable("/employee-view");
    }
}
