package org.hasith.ems.middleware;

import com.sun.net.httpserver.HttpsServer;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.glassfish.jersey.server.mvc.Viewable;
import org.hasith.ems.annotations.IsUser;
import org.hasith.ems.dto.UserDTO;
import org.hasith.ems.entity.User;
import org.hasith.ems.service.UserService;

import java.io.IOException;

//@Provider
@IsUser
public class IsUserImpl implements ContainerRequestFilter {

    @Context
    HttpServletRequest request;

    @Context
    HttpServletResponse response;


    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

//        HttpSession session = request.getSession();
//        if (session.getAttribute("user_auth") == null){
//            requestContext.abortWith(Response.status(Response.Status.FORBIDDEN).entity(new Viewable("/401")).build());
//        }

        HttpSession session = request.getSession();
        User user_data = (User) session.getAttribute("user_availability");

        if (user_data == null) {
            requestContext.abortWith(Response.status(Response.Status.FORBIDDEN).build());
        }else{
            UserService userService = new UserService();
            User user = userService.searchUser(user_data.getUsername().toString(), user_data.getPassword().toString());
            if (user == null){
                System.out.println("There is no such user");
                requestContext.abortWith(Response.status(Response.Status.FORBIDDEN).build());
            }else{
                requestContext.abortWith(Response.status(Response.Status.OK).entity(new Viewable("/user_main")).build());
            }
        }

        //System.out.println("IsUser Impl");
    }
}
