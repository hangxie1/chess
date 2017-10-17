
package com.hang.chess.controller;
import com.hang.chess.exception.ChessException;
import com.hang.chess.model.Game;
import com.hang.chess.controllermodel.Move;
import com.hang.chess.controllermodel.PostResponse;
import com.hang.chess.service.ChessService;
import com.hang.chess.common.IsCheck;
import com.hang.chess.controllermodel.MoveSuccessResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/chess")
public class ChessController {
    
    private final Logger logger = LoggerFactory.getLogger(ChessController.class.getName());
    
    @Autowired
    ChessService chessService;
    
    @Autowired
    SvsErrRespBuilder svsErrRespBuilder;
    
    
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<?> getUser( 
            UriComponentsBuilder ucBuilder) {    
        HttpHeaders headers = new HttpHeaders();
        headers.set("content-type", "application/json");
        return new ResponseEntity<Object>( headers, HttpStatus.OK);
     
    }
    
    @RequestMapping(value = "/games/{game_id}", method = RequestMethod.GET)
    public ResponseEntity<?> getGame(@PathVariable("game_id") int game_id) {
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("content-type", "application/json");
        try{ 
            Game game = chessService.getGame(game_id);
        
            return new ResponseEntity<Game>(game, headers, HttpStatus.OK);
        } catch (ChessException chessException){
            return svsErrRespBuilder.builer(chessException);    
        } 
    } 
    
    @RequestMapping(value = "/games", method = RequestMethod.POST)
    public ResponseEntity<?> createGame(  
            UriComponentsBuilder ucBuilder) {
        logger.info("Creating game");
       
        HttpHeaders headers = new HttpHeaders();
        
        try{ 
            int gameId = chessService.createGame();
            PostResponse postResponse = new PostResponse();
            postResponse.setGameId(gameId);
            return new ResponseEntity<PostResponse>(postResponse, headers, HttpStatus.CREATED);
        } catch (ChessException chessException){
            return svsErrRespBuilder.builer(chessException);    
        }   
    }
    
    @RequestMapping(value = "/games/{game_id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteGame(
            @PathVariable("game_id") Integer game_id, 
            UriComponentsBuilder ucBuilder) { 
        
        logger.info("Deleting  Game");
        HttpHeaders headers = new HttpHeaders();
       
        try{ 
            chessService.deleteGame (game_id);
            return new ResponseEntity<Object>(headers, HttpStatus.OK);
            
        } catch (ChessException chessException){
            return svsErrRespBuilder.builer(chessException);
        }   
    }
    
    @RequestMapping(value = "/move/games/{game_id}", method = RequestMethod.PUT)
    public ResponseEntity<?> move(
            @PathVariable("game_id") Integer gameId,
            @RequestBody Move move,
            UriComponentsBuilder ucBuilder) {
        
        logger.info("Creating game");
        logger.info("game_id"+ gameId);
        logger.info("toX " + move.getToX());
        logger.info("toY " + move.getToY());
        logger.info("fromX " + move.getFromX());
        logger.info("fromY " + move.getFromY());
       
        HttpHeaders headers = new HttpHeaders();
        
        try{ 
            IsCheck isCheck = 
                chessService.move(gameId, move.getFromX(), move.getFromY(), move.getToX(),move.getToY());
            MoveSuccessResponse moveSuccessResponse  = new MoveSuccessResponse();
            moveSuccessResponse.setIsCheck(isCheck);
            return new ResponseEntity<MoveSuccessResponse>(moveSuccessResponse, headers, HttpStatus.OK);
        } catch (ChessException chessException){
            return svsErrRespBuilder.builer(chessException); 
            
        }   
    }
    
    @RequestMapping(value = "/reset/games/{game_id}", method = RequestMethod.PUT)
    public ResponseEntity<?> reset(
            @PathVariable("game_id") Integer gameId,
            @RequestBody Move move,
            UriComponentsBuilder ucBuilder) {
        
        
       
        HttpHeaders headers = new HttpHeaders();
        
        try{ 
            chessService.resetGame(gameId);
            return new ResponseEntity<Object>(headers, HttpStatus.OK);
        } catch (ChessException chessException){
            return svsErrRespBuilder.builer(chessException); 
            
        }   
    }
}
