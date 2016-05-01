package com.margin.game_guide_server.resource;

import com.margin.game_guide_server.model.UserModel;
import com.margin.game_guide_server.response.ErrorResponse;
import com.margin.game_guide_server.response.ResultResponse;
import com.margin.game_guide_server.service.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Martha on 4/30/2016.
 */
@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private static UserService userService = new UserService();

    @POST
    @Path("/sign_up")
    public Response signUp(UserModel userModel){
        if (userModel.getEmail() == null || userModel.getPassword() == null
                || userModel.getFirst_name() == null || userModel.getLast_name() == null){
            ErrorResponse errorResponse = new ErrorResponse(1, "Data missing");
            return Response.status(Response.Status.BAD_REQUEST).entity(errorResponse).build();
        }
        if(userService.userExists(userModel)){
            ErrorResponse errorResponse = new ErrorResponse(2, "User already exists");
            return Response.status(Response.Status.BAD_REQUEST).entity(errorResponse).build();
        }
        UserModel user = userService.createUser(userModel);
        return Response.ok().entity(user).build();
    }

    @POST
    @Path("/login")
    public Response login(UserModel userModel){
        if(userModel.getEmail() == null || userModel.getPassword() == null){
            ErrorResponse errorResponse = new ErrorResponse(1, "Data missing");
            return Response.status(Response.Status.BAD_REQUEST).entity(errorResponse).build();
        }
        UserModel currentUser =  userService.login(userModel);
        if (currentUser == null){
            ErrorResponse errorResponse = new ErrorResponse(3, "Wrong email or password!");
            return Response.status(Response.Status.BAD_REQUEST).entity(errorResponse).build();
        }
        return Response.ok().entity(currentUser).build();
    }

    @GET
    @Path("/all")
    public List<UserModel> getAllUsers(){
        return userService.getAllUsers();
    }

    @GET
    @Path("/user")
    public Response getUser(@HeaderParam("TOKEN") String token){
        UserModel currentUser = userService.getUserByToken(token);
        if (currentUser == null){
            ErrorResponse errorResponse = new ErrorResponse(3, "Wrong arguments");
            return Response.status(Response.Status.BAD_REQUEST).entity(errorResponse).build();
        }
        return Response.ok().entity(new ResultResponse<>(currentUser)).build();
    }





}
