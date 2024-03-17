package org.hasith.ems.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.Null;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.server.mvc.Viewable;
import org.hasith.ems.dto.UserDTO;
import org.hasith.ems.entity.User;
import org.hasith.ems.service.UserService;

import java.io.IOException;

@Path("/demo-auth")
public class DemoAuth {

    @Context
    HttpServletRequest request;

    @Context
    HttpServletResponse response;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response demo_auth_post(UserDTO user_data) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (!user_data.getUsername().equals("") && !user_data.getPassword().equals("")) {
            UserService userService = new UserService();
            User user = userService.searchUser(user_data.getUsername(), user_data.getPassword());
            if (user != null){
                session.setAttribute("user_availability", user);
                System.out.println(user.getUsername());
                return Response.ok().entity("User found").build();
            }else {
                session.setAttribute("user_availability", null);
                return Response.status(Response.Status.BAD_REQUEST).entity("No User Found").build();
            }
        } else {
            session.setAttribute("user_availability", null);
            return Response.status(Response.Status.BAD_REQUEST).entity("No User Found").build();
        }

    }


}
