package com.hang.chess.model;

public enum Color {
    Black("Black"),
    White("White");
    
    private final String value;
    Color (final String value){
        this.value = value;
    }
    
    @Override
    public String toString(){
        return value;
    }  
}
