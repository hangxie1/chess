package com.hang.chess.service;

import com.hang.chess.common.IsCheck;
import com.hang.chess.dao.ChessDao;
import com.hang.chess.exception.ChessException;
import com.hang.chess.model.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


@org.springframework.stereotype.Service("chessService")
public class ChessServiceImpl implements ChessService{
    private final Logger logger = LoggerFactory.getLogger(ChessServiceImpl.class.getName());
    
    @Autowired
    ChessDao chessDao;
    
    public int createGame() throws ChessException {
        int gameId;
        gameId = chessDao.createGame();
        return gameId;
    }
    public void resetGame(Integer gameId) throws ChessException{
        chessDao.resetGame(gameId);
        
    }
    public Game getGame(Integer gameId) throws ChessException{
        return chessDao.getGame(gameId);
    }
    
    public IsCheck move(Integer gameId, int fromX, int fromY, int toX, int toY)throws ChessException{
        return chessDao.move(gameId,fromX, fromY, toX, toY);
    }    
    public void deleteGame (Integer gameId) throws ChessException{
        chessDao.deleteGame(gameId);
    }
}
