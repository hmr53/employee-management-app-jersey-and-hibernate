package org.hasith.ems.controller;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import org.glassfish.jersey.server.mvc.Viewable;
import org.hasith.ems.annotations.IsUser;

@IsUser
@Path("/user-home")
public class UserAccessController {

    @Context
    HttpServletRequest request;

    @GET
    public Viewable user_panel_get(){
        return new Viewable("/user_main");

    }

    @POST
    public Viewable user_panel_post(){
        return new Viewable("/user_main");
    }


}
