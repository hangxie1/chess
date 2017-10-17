
package com.hang.chess.controllermodel;
import com.hang.chess.exception.ChessException.ErrorCode;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hang.chess.common.MoveValidateResult;

public class ServiceErrorResponse {
   
   
   @JsonProperty("user_message")
   private MoveValidateResult moveValidateResult;
   
   @JsonProperty("error_code")
   private ErrorCode  errorCode;
   
   public ServiceErrorResponse setErrorCode(ErrorCode errorCode){
       this.errorCode = errorCode;
       return this;
   }
   
   public ErrorCode getErrorCode(){
    return errorCode;   
   }
   
    public ServiceErrorResponse setMoveValidateResult(MoveValidateResult moveValidateResult){
       this.moveValidateResult = moveValidateResult;
       return this;
    }
   
    public MoveValidateResult getMoveValidateResult(){
       return moveValidateResult;   
   }

}
