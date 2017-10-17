
package com.hang.chess.exception;
import com.hang.chess.common.MoveValidateResult;
public class ChessException extends Exception {
   
public static enum ErrorCode {
        SUCCESS("SUCCESS"),
        BAD_REQUEST("BAD_REQUEST"),
        NOT_FOUND ("NOT_FOUND");
        
        private final String value;
    
        ErrorCode(final String value){
            this.value = value;
        }
    
        @Override
        public String toString(){
            return value;
        }
    };
            
    private ErrorCode errorCode;
    private MoveValidateResult moveValidateResult = null;
    
    public ChessException (ErrorCode errorCode){
        this.errorCode =  errorCode;
    }
    
    public ChessException (ErrorCode errorCode, MoveValidateResult moveValidateResult){
        this.moveValidateResult = moveValidateResult;
        this.errorCode =  errorCode;
    }
    public ErrorCode getErrorCode (){
        return errorCode;
    }
    public MoveValidateResult getMoveValidateResult(){
        return moveValidateResult;
    }
}