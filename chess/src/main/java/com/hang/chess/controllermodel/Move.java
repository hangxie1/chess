
package com.hang.chess.controllermodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Move {
    
    @JsonProperty("from_x")
    int fromX;
    
    @JsonProperty("from_y")
    int fromY;
    
    @JsonProperty("to_x")
    int toX;
    
    @JsonProperty("to_y")
    int toY;
    
    
    public int getFromX() {
        return fromX;
    }
    public void setFromX(int fromX) {
        this.fromX = fromX;
    }
    
    public int getFromY() {
        return fromY;
    }
    public void setFromY(int fromY) {
        this.fromY = fromY;
    }
    
    public int getToX() {
        return toX;
    }
    public void setToX(int toX) {
        this.toX = toX;
    }
    public int getToY() {
        return toY;
    }
    public void setToY(int toY) {
        this.toY = toY;
    }
    
}
