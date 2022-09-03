package com.bbs.cmm.exception;

import lombok.Getter;

/**
 * @name          BBSParseException.
 * @description   Representa la exception de parseos.
 * @creation      03/08/2022.
 * @user          @serbuitrago
 * @update        03/08/2022.
 * @user          @serbuitrago
 * @version       1.0.0.
 */
@Getter
public class BBSParseException extends BBSException{

    public BBSParseException(){
        super();
    }

    public BBSParseException(String message){
        super(message);
    }

    public BBSParseException(String codeError, String message){
        super(codeError, message);
    }
}