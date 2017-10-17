
package com.hang.chess.common;

public  enum MoveValidateResult {
        OK("OK"),
        NOPIECE("NOPIECE"),
        NOMOVE("NOMOVE"),
        OCCUPIED("OCCUPIED"),
        OUT_BORDER("OUT_BOARDER"),
        BLOCKED("BLOCKED"),
        INVALID_MOVE("INVALID_MOVE");
        
        
        private final String value;
    
        MoveValidateResult(final String value){
            this.value = value;
        }
    
        @Override
        public String toString(){
            return value;
        }
    };