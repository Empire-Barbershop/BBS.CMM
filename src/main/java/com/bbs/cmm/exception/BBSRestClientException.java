package com.bbs.cmm.exception;

import lombok.Getter;

/**
 * @name          BBSRestClientException.
 * @description   Representa la exception de comunicacion.
 * @creation      03/08/2022.
 * @user          @serbuitrago
 * @update        03/08/2022.
 * @user          @serbuitrago
 * @version       1.0.0.
 */
@Getter
public class BBSRestClientException extends BBSException{

    public BBSRestClientException(){
        super();
    }

    public BBSRestClientException(String message){
        super(message);
    }

    public BBSRestClientException(String codeError, String message){
        super(codeError, message);
    }
}