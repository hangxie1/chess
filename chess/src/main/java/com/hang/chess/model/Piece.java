package com.hang.chess.model;

import com.hang.chess.common.MoveValidateResult;
import com.hang.chess.common.Role;

public abstract class Piece {
    protected Color color;
    private Role role = null;
    
    public Piece(Color color, Role role){
        super();
        this.color = color;
        this.role  = role;
    }

    public Role getRole(){
        return role;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public MoveValidateResult isValid(Piece[][] pieces, int fromX, int fromY, int toX, int toY){
        if( (toX == fromX) && (toY == fromY) )
            return MoveValidateResult.NOMOVE; 
        if( (toX < 0) || (toX > 7) || (fromX < 0) || (fromX > 7) || (toY < 0) || (toY > 7) || (fromY <0) || fromY > 7)
            return MoveValidateResult.OUT_BORDER;
        if (pieces[toX][toY] != null ){
            if (color == pieces[toX][toY].getColor())
                return MoveValidateResult.OCCUPIED;
        }
        return MoveValidateResult.OK;
    }
    
}
