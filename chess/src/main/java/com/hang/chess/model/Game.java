package com.hang.chess.model;
import com.hang.chess.common.IsCheck;
import com.hang.chess.exception.ChessException;
import com.hang.chess.exception.ChessException.ErrorCode;   
import com.hang.chess.common.MoveValidateResult;
import com.hang.chess.common.Role;
import com.hang.chess.common.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Game {
    private final Logger logger = LoggerFactory.getLogger(Game.class.getName());
    int gameId;
    Piece[][] pieces = new Piece[Constant.BOARD_SIZE][Constant.BOARD_SIZE];
    
    public Game (int gameId){
        this.gameId = gameId;
        reset();
    }
    
    public int getGameId (){
        return gameId;
    }
    
    public Piece[][] getPieces(){
        return pieces;
    }
    public void reset (){
       for (int i=0;i<Constant.BOARD_SIZE;i++){
            for (int j=0;j<Constant.BOARD_SIZE;j++){
                pieces [i][j] = null;
            }
        } 
        pieces[0][0] = new Rook (Color.White);
        pieces[0][7] = new Rook (Color.White);
        pieces[0][1] = new Knight (Color.White);
        pieces[0][6] = new Knight (Color.White);
        pieces[0][2] = new Bishop (Color.White);
        pieces[0][5] = new Bishop (Color.White);
        pieces[0][3] = new Queen (Color.White);
        pieces[0][4] = new King (Color.White);
        
        for (int j=0;j<Constant.BOARD_SIZE;j++){
           pieces[1][j] = new Pawn (Color.White); 
        }
        pieces[7][0] = new Rook (Color.Black);
        pieces[7][7] = new Rook (Color.Black);
        pieces[7][1] = new Knight (Color.Black);
        pieces[7][6] = new Knight (Color.Black);
        pieces[7][2] = new Bishop (Color.Black);
        pieces[7][5] = new Bishop (Color.Black);
        pieces[7][3] = new Queen (Color.Black);
        pieces[7][4] = new King (Color.Black);
        
        for (int j=0;j<Constant.BOARD_SIZE;j++){
           pieces[6][j] = new Pawn (Color.Black); 
        } 
    }
    
    public IsCheck move(int fromX, int fromY, int toX, int toY) throws ChessException{
        
        if (pieces[fromX][fromY] == null) 
            throw new ChessException(ErrorCode.BAD_REQUEST,MoveValidateResult.NOPIECE);
        MoveValidateResult moveValidateResult =  pieces[fromX][fromY].isValid(pieces, fromX, fromY, toX, toY);
        if (moveValidateResult != MoveValidateResult.OK){
            throw new ChessException(ErrorCode.BAD_REQUEST, moveValidateResult);
        }
        pieces[toX][toY] = pieces[fromX][fromY];
        pieces[fromX][fromY] = null;
        
        int enemyKingX = 0;
        int enemyKingY = 0;
        
        for (int i=0;i<Constant.BOARD_SIZE;i++){
            for (int j=0;j<Constant.BOARD_SIZE;j++){
                if (pieces[i][j] !=null) {
                    if ( (pieces[i][j].getRole() == Role.KING) 
                            && (pieces[i][j].getColor() != pieces[toX][toY].getColor()))  {
                             logger.info ("I= " +i);
                             logger.info ("J= " + j);
                                enemyKingX = i;
                                enemyKingY = j;
                    }              
                }
            }
        }
        
        if ( pieces[toX][toY].isValid(pieces, toX, toY, enemyKingX, enemyKingY) == MoveValidateResult.OK )
            return IsCheck.YES;
        return IsCheck.NO;
    }
}
