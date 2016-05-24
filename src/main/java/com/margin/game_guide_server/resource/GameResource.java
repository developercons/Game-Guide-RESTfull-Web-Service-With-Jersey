package com.margin.game_guide_server.resource;

import com.margin.game_guide_server.model.GameModel;
import com.margin.game_guide_server.model.GameRequestModel;
import com.margin.game_guide_server.response.ResponseBundle;
import com.margin.game_guide_server.service.GameService;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;

/**
 * Created by Martha on 5/11/2016.
 */

@Path("/games")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GameResource {

    public static final String RES_REL_PATH = "/WEB-INF/images/";
    private static GameService gameService = new GameService();

    @Context
    private ServletContext context;

    @GET
    @Path("/category_list")
    public Response getCategoryList(){
        ResponseBundle<Set<String>> response = new ResponseBundle<>(gameService.getCategoryList());
        return Response.ok().entity(response).build();
    }

    @POST
    @Path("/game_ids")
    public Response getGameIdList(GameRequestModel requestModel){
        ResponseBundle<Set<Long>> response = new ResponseBundle<>(gameService.getGameIdListByCategory(requestModel.getCategory()));
        return Response.ok().entity(response).build();
    }

    @POST
    @Path("/game")
    public Response getGame(GameRequestModel requestModel){
        ResponseBundle<GameModel> response = new ResponseBundle<>(gameService.getAGame(requestModel.getCategory(),
                requestModel.getId()));
        return Response.ok().entity(response).build();
    }

    @POST
    @Path("/game_picture")
    @Produces("image/png")
    public Response downloadGamePicture(GameRequestModel requestModel){
        String imagePath = RES_REL_PATH +  "/" + requestModel.getCategory() + "/" + requestModel.getId() +requestModel.getCategory() +  ".png";
        System.out.println("**********************" + imagePath + "******************************");
        return Response.ok().entity(context.getResourceAsStream(imagePath)).build();
    }
}
