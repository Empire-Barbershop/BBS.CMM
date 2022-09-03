package com.bbs.cmm.exception;

import lombok.Getter;

/**
 * @name          BBSDataBaseException.
 * @description   Representa la exception de base de datos.
 * @creation      03/08/2022.
 * @user          @serbuitrago
 * @update        03/08/2022.
 * @user          @serbuitrago
 * @version       1.0.0.
 */
@Getter
public class BBSDataBaseException extends BBSException{

    public BBSDataBaseException(){
        super();
    }

    public BBSDataBaseException(String message){
        super(message);
    }

    public BBSDataBaseException(String codeError, String message){
        super(codeError, message);
    }
}
