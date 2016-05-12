package com.margin.game_guide_server.resource;

import com.margin.game_guide_server.model.UserModel;
import com.margin.game_guide_server.response.ResponseBundle;
import com.margin.game_guide_server.service.UserService;
import org.glassfish.jersey.media.multipart.FormDataParam;

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
        ResponseBundle<UserModel> response;
        if (userModel.getEmail() == null || userModel.getPassword() == null
                || userModel.getFirst_name() == null || userModel.getLast_name() == null){
            response = new ResponseBundle<>(1, "Data missing");
            return Response.ok().entity(response).build();
        }
        if(userService.userExists(userModel)){
            response = new ResponseBundle<>(2, "User already exists");
            return Response.ok().entity(response).build();
        }
        response = new ResponseBundle<>(userService.createUser(userModel));
        return Response.ok().entity(response).build();
    }

    @POST
    @Path("/login")
    public Response login(UserModel userModel){
        ResponseBundle<UserModel> response;
        if(userModel.getEmail() == null || userModel.getPassword() == null){
            response = new ResponseBundle<>(1, "Data missing");
            return Response.ok().entity(response).build();
        }
        UserModel currentUser =  userService.login(userModel);
        if (currentUser == null){
            response = new ResponseBundle<>(3, "Wrong email or password!");
            return Response.ok().entity(response).build();
        }
        response = new ResponseBundle<UserModel>(currentUser);
        return Response.ok().entity(response).build();
    }

    @GET
    @Path("/all")
    public List<UserModel> getAllUsers(){
        return userService.getAllUsers();
    }

    @GET
    @Path("/user")
    public Response getUser(@HeaderParam("TOKEN") String token){
        ResponseBundle<UserModel> response;
        UserModel currentUser = userService.getUserByToken(token);
        if (currentUser == null){
            response = new ResponseBundle<>(3, "Wrong arguments");
            return Response.ok().entity(response).build();
        }
        return Response.ok().entity(new ResponseBundle<>(currentUser)).build();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response update(@HeaderParam("TOKEN") String token,
                           @FormDataParam("user") UserModel userModel,
                           @FormDataParam("picture") byte[] picture){
        ResponseBundle<String> response;
        userModel.setAvatarBytes(picture);
        if(userService.updateUser(userModel, token)){
            response = new ResponseBundle<>("User updated");
            return Response.ok().entity(response).build();
        }
        response = new ResponseBundle<>(3, "No such user");
        return Response.ok().entity(response).build();

    }

    @POST
    @Path("/logout")
    public Response logout(@HeaderParam("TOKEN") String token){
        ResponseBundle<String> response;
        if(userService.logout(token)){
            response = new ResponseBundle<>("Logged out");
            return Response.ok().entity(response).build();
        }
        response = new ResponseBundle<>(3, "Logout failed");
        return Response.ok().entity(response).build();
    }

    @GET
    @Path("/profile_picture")
    @Produces("image/png")
    public Response downloadProfPic(@HeaderParam("TOKEN") String token){
        if(token != null){
            UserModel currentUser =  userService.getUserByToken(token);
            if(currentUser != null){
                return Response.ok().entity(userService.getUserByToken(token).getAvatarBytes()).build();}
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("No such user").build();
    }



}
