package com.hang.chess.model;

import com.hang.chess.common.MoveValidateResult;
import com.hang.chess.common.Role;

public class Pawn extends Piece{
 
    public Pawn(Color color){
        super(color, Role.PAWN);
    }

    @Override
    public MoveValidateResult isValid(Piece[][] pieces, int fromX, int fromY, int toX, int toY) {
        MoveValidateResult moveValidateResult = super.isValid(pieces, fromX, fromY, toX, toY);
        if ( moveValidateResult!= MoveValidateResult.OK)
            return moveValidateResult;
        
        if (toY != fromY) return MoveValidateResult.INVALID_MOVE;
        
        if  (color == Color.White) {
            if (fromX ==1) {
                if ( ((toX - fromX) > 2) || ( (toX - fromX) < 0 )) 
                    return MoveValidateResult.INVALID_MOVE; 
            } else {
                if ( ( (toX - fromX) > 1) || ( (toX - fromX) < 0 )) 
                    return MoveValidateResult.INVALID_MOVE;
            }
            for (int i=fromX+1; i<toX;i++){
                    if (pieces[i][toY] !=null){
                           return MoveValidateResult.BLOCKED; 
                }
            }
            
        }  else {
            if (fromX ==6){
                if ( ((fromX -toX) > 2) || ((fromX -toX) < 0) ) 
                    return MoveValidateResult.INVALID_MOVE;
                
            } else {
                if ( ((fromX-toX) > 1) || ((fromX-toX) < 0) ) 
                    return MoveValidateResult.INVALID_MOVE;
            } 
            for (int i=fromX-1; i> toX;i--){
                if (pieces[i][toY] !=null){
                           return MoveValidateResult.BLOCKED; 
                }
            }  
        }
        return MoveValidateResult.OK;
    }

}

