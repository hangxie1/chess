package com.hang.chess.model;

import com.hang.chess.common.MoveValidateResult;
import com.hang.chess.common.Role;

public class Queen extends Piece{

    public Queen(Color color) {
        super(color, Role.QUEEN);
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
                for (int i=1; i< (fromX- toX);i++){
                    if (pieces[fromX-i][fromY+i] !=null) {
                            return moveValidateResult.BLOCKED;
                    }
                }
            }
            return MoveValidateResult.OK;
        }   
        if(toX == fromX){
            if (toY > fromY){
                for (int i=1; i< (toY-fromY);i++){
                    if (pieces[toX][fromY+i] !=null) {
                            return moveValidateResult.BLOCKED;
                    }
                }
            } else {
                for (int i=1; i< (fromY-toY);i++){
                    if (pieces[toX][fromY-i] !=null) {
                            return moveValidateResult.BLOCKED;
                    }
                }
            }
            return MoveValidateResult.OK;
        }
        if(toY == fromY){
            if (toX > fromX){
                for (int i=1; i< (toX-fromX);i++){
                    if (pieces[fromX+i][toY] !=null) {
                            return moveValidateResult.BLOCKED;
                    }
                }
            } else {
                for (int i=1; i< (fromX - toX);i++){
                    if (pieces[fromX-i][toY] !=null) {
                            return moveValidateResult.BLOCKED;
                    }
                }
            }
            return MoveValidateResult.OK;
        }
        return MoveValidateResult.INVALID_MOVE;
    }

}
