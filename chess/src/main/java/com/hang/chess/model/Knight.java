package com.hang.chess.model;

import com.hang.chess.common.MoveValidateResult;
import com.hang.chess.common.Role;

public class Knight extends Piece{

    public Knight(Color color) {
        super(color, Role.KNIGHT);
    }
    
    @Override
    public MoveValidateResult isValid(Piece[][] pieces, int fromX, int fromY, int toX, int toY) {
        MoveValidateResult moveValidateResult = super.isValid(pieces, fromX, fromY, toX, toY);
        if ( moveValidateResult!= MoveValidateResult.OK)
            return moveValidateResult;
        
        if ( (  (Math.abs (toX-fromX) ==1)  && (Math.abs(toY-fromY)==2 ) ) 
                || ( (Math.abs (toX-fromX) ==2) && (Math.abs(toY-fromY)==1 )) ) {
            
            return MoveValidateResult.OK;
            
        } else 
            return MoveValidateResult.INVALID_MOVE;
        
    }

}