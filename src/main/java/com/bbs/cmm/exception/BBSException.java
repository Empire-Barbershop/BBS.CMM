package com.bbs.cmm.exception;

import com.bbs.cmm.CommonValidateCMM;
import com.bbs.cmm.util.ConstantCMM;
import com.bbs.cmm.util.ConstantSystemCMM;

import lombok.Getter;

/**
 * @name          BBSException.
 * @description   Representa la exception generica.
 * @creation      03/08/2022.
 * @user          @serbuitrago
 * @update        03/08/2022.
 * @user          @serbuitrago
 * @version       1.0.0.
 */
@Getter
public class BBSException extends Exception {
    protected String codeError;

    public BBSException(){
        this(ConstantSystemCMM.CODE_ERROR_RESPONSE_COMMUNICATION, ConstantSystemCMM.MESSAGE_ERROR_RESPONSE_COMMUNICATION);
    }

    public BBSException(String message){
        this(ConstantSystemCMM.CODE_ERROR_RESPONSE_COMMUNICATION, message);
    }

    public BBSException(String codeError, String message){
        super(message);
        if(!CommonValidateCMM.isValidString(codeError))
            this.codeError = ConstantSystemCMM.CODE_ERROR_RESPONSE_COMMUNICATION;
        else
            this.codeError = codeError;
    }

    @Override
    public String toString(){
        return codeError
                .concat(ConstantCMM.VALUE_STRING_WHITE_SPACE)
                .concat(ConstantCMM.VALUE_STRING_SEPARATOR_HYPHEN)
                .concat(ConstantCMM.VALUE_STRING_WHITE_SPACE)
                .concat(getMessage());
    }
}
