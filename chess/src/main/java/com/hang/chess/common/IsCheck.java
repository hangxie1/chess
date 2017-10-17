
package com.hang.chess.common;

public enum IsCheck {
    YES("Yes"),
    NO("No");
        
    private final String value;
    
    IsCheck(final String value){
            this.value = value;
    }
    
    @Override
    public String toString(){
            return value;
    }
};

    
