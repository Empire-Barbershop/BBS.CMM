package com.bbs.cmm.exception;

import lombok.Getter;

/**
 * @name          BBSFileException.
 * @description   Representa la exception de archivos.
 * @creation      03/08/2022.
 * @user          @serbuitrago
 * @update        03/08/2022.
 * @user          @serbuitrago
 * @version       1.0.0.
 */
@Getter
public class BBSFileException extends BBSException{

    public BBSFileException(){
        super();
    }

    public BBSFileException(String message){
        super(message);
    }

    public BBSFileException(String codeError, String message){
        super(codeError, message);
    }
}
