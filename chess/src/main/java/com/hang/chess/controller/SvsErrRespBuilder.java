
package com.hang.chess.controller;

import com.hang.chess.controllermodel.ServiceErrorResponse;
import com.hang.chess.exception.ChessException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component("svsErrRespBuilder")
public class SvsErrRespBuilder {
    private final Logger logger = LoggerFactory.getLogger(SvsErrRespBuilder.class.getName());
    public  ResponseEntity<ServiceErrorResponse> builer(ChessException chessException){
        
  
        HttpHeaders headers = new HttpHeaders();
        
        ServiceErrorResponse serviceErrorResponse = new ServiceErrorResponse() ;
        serviceErrorResponse.setErrorCode(chessException.getErrorCode())
                    .setMoveValidateResult(chessException.getMoveValidateResult());
        switch (chessException.getErrorCode()) {            
            case NOT_FOUND:
                return new ResponseEntity<ServiceErrorResponse>(serviceErrorResponse, headers, HttpStatus.NOT_FOUND);
            case BAD_REQUEST:     
            default:
                return new ResponseEntity<ServiceErrorResponse>(serviceErrorResponse,headers, HttpStatus.BAD_REQUEST);     
        }   
    }
}     