
package com.hang.chess.common;

public enum Role {
    KING("King"),
    QUEEN("Queen"),
    BISHOP("Bishop"),
    KNIGHT("Knight"),
    ROOK("Rook"),
    PAWN("Pawn");
  
        
    private final String value;
    
    Role(final String value){
            this.value = value;
    }
    
    @Override
    public String toString(){
            return value;
    }
};