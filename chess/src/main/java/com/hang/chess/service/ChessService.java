package com.hang.chess.service;

import com.hang.chess.model.Game;
import com.hang.chess.exception.ChessException;
import com.hang.chess.common.IsCheck;


public interface  ChessService {
    public int createGame() throws ChessException;;
    public void resetGame(Integer gameId) throws ChessException;
    public Game  getGame(Integer gameId) throws ChessException;
    public IsCheck move(Integer gameId, int fromX, int fromY, int toX, int toY)throws ChessException;    
    public void deleteGame (Integer gameId) throws ChessException;
}
