package com.bbs.cmm.exception;

import lombok.Getter;

/**
 * @name          BBSValidateException.
 * @description   Representa la exception de validaciones.
 * @creation      03/08/2022.
 * @user          @serbuitrago
 * @update        03/08/2022.
 * @user          @serbuitrago
 * @version       1.0.0.
 */
@Getter
public class BBSValidateException extends BBSException{

    public BBSValidateException(){
        super();
    }

    public BBSValidateException(String message){
        super(message);
    }

    public BBSValidateException(String codeError, String message){
        super(codeError, message);
    }
}