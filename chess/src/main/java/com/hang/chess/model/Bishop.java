
package com.hang.chess.model;

import com.hang.chess.common.MoveValidateResult;
import com.hang.chess.common.Role;

public class Bishop extends Piece{

    public Bishop(Color color){
        super(color, Role.BISHOP);
    }

    @Override
    public MoveValidateResult isValid(Piece[][] pieces, int fromX, int fromY, int toX, int toY) {
        MoveValidateResult moveValidateResult = super.isValid(pieces, fromX, fromY, toX, toY);
        if ( moveValidateResult!= MoveValidateResult.OK)
            return moveValidateResult;

        if((toX - fromX) == (toY - fromY)){
            if (toX > fromX){
                for (int i=1; i< (toX-fromX);i++){
                    if (pieces[fromX+ i][fromY+i] !=null) {
                            return moveValidateResult.BLOCKED;
                    }
                }
            } else {
                for (int i=1; i< (fromX- toX);i++){
                    if (pieces[fromX-i][fromY-i] !=null) {
                            return moveValidateResult.BLOCKED;
                    }
                }
            }
            return MoveValidateResult.OK;
        }
        if((toX - fromX) == -(toY - fromY)){
            if (toX > fromX){
                for (int i=1; i< (toX-fromX);i++){
                    if (pieces[fromX+ i][fromY-i] !=null) {
                            return moveValidateResult.BLOCKED;
                    }
                }
            } else {
                for (int i=1; i< (fromX- toX);i--){
                    if (pieces[fromX-i][fromY+i] !=null) {
                            return moveValidateResult.BLOCKED;
                    }
                }
            }
            return MoveValidateResult.OK;
        }
        return MoveValidateResult.INVALID_MOVE;
    }    
}
