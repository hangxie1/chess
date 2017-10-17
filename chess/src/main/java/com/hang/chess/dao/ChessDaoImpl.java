
package com.hang.chess.dao;

import com.hang.chess.common.IsCheck;
import java.util.ArrayList;
import java.util.List;
import com.hang.chess.exception.ChessException;
import com.hang.chess.exception.ChessException.ErrorCode;
import com.hang.chess.model.Game;
import org.springframework.stereotype.Component;



@Component("chessDao")
public class ChessDaoImpl implements ChessDao{
    
    private List<Game> games = new ArrayList<Game>();
    private int latestGameId = 0;
    
    public int createGame() throws ChessException{
        latestGameId++;
        Game newGame = new Game (latestGameId);
        games.add(newGame);
        return latestGameId;
    }
    
    public void resetGame(Integer gameId) throws ChessException{
        for (int i=0;i< games.size();i++ ){
            if (games.get(i).getGameId()== gameId){
                games.get(i).reset();
                return;
            }
        }
        throw new ChessException( ErrorCode.NOT_FOUND);
    }
    public Game  getGame(Integer gameId) throws ChessException{
        for (int i=0;i< games.size();i++ ){
            if (games.get(i).getGameId()== gameId){
                 return games.get(i);                
            }
        }
        throw new ChessException(ErrorCode.NOT_FOUND);
    }
    
    public IsCheck move(Integer gameId, int fromX, int fromY, int toX, int toY)throws ChessException{
        for (int i=0;i< games.size();i++ ){
            if (games.get(i).getGameId()== gameId){
                
                return games.get(i).move(fromX,  fromY,  toX,  toY);
                                
            }
        }
        throw new ChessException( ErrorCode.NOT_FOUND);
    }    
    public void deleteGame (Integer gameId) throws ChessException{
        for (int i=0;i< games.size();i++ ){
            if (games.get(i).getGameId()== gameId){
                games.remove(i);
                return;                
            }
        }
        throw new ChessException( ErrorCode.NOT_FOUND);
    }
    
}
