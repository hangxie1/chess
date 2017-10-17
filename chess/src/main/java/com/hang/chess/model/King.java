
package com.hang.chess.model;

import com.hang.chess.common.MoveValidateResult;
import com.hang.chess.common.Role;

public class King extends Piece{

    public King(Color color) {
        super(color, Role.KING);
        
    }
    
    @Override
    public MoveValidateResult isValid(Piece[][] pieces, int fromX, int fromY, int toX, int toY) {
        MoveValidateResult moveValidateResult = super.isValid(pieces, fromX, fromY, toX, toY);
        if ( moveValidateResult!= MoveValidateResult.OK)
            return moveValidateResult;
        if ( ( Math.abs((toX - fromX)) > 1) || ( Math.abs((toY - fromY)) > 1) ) {
            return MoveValidateResult.INVALID_MOVE;
        }
        
        return MoveValidateResult.OK;
    }

}
