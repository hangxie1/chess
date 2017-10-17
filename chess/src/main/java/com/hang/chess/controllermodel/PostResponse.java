
package com.hang.chess.controllermodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostResponse {
    
    @JsonProperty("game_id")
    private int gameId;
    
    public PostResponse setGameId(int gameId){
       this.gameId = gameId;
       return this;
    }
   
    public int getGameId(){
       return gameId; 
    }
}
