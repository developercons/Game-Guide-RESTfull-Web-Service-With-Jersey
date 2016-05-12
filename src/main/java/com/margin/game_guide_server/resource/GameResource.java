package com.margin.game_guide_server.resource;

import com.margin.game_guide_server.model.GameModel;
import com.margin.game_guide_server.model.GameRequestModel;
import com.margin.game_guide_server.response.ResponseBundle;
import com.margin.game_guide_server.service.GameService;

import javax.ws.rs.*;
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

    private static GameService gameService = new GameService();

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
                requestModel.getGameId()));
        return Response.ok().entity(response).build();
    }

    @POST
    @Path("/game_picture")
    @Produces("image/png")
    public Response downloadGamePicture(GameRequestModel requestModel){
        return Response.ok().entity(gameService.getAGame(requestModel.getCategory(), requestModel.getGameId()).getAvatar()).build();
    }

}
