
package com.hang.chess.controllermodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hang.chess.common.IsCheck;


public class MoveSuccessResponse {
    
    @JsonProperty("is_check")
    private IsCheck isCheck;
    
    public MoveSuccessResponse setIsCheck(IsCheck isCheck){
       this.isCheck = isCheck;
       return this;
    }
   
    public IsCheck getIsCheck(){
       return isCheck; 
    }
}
