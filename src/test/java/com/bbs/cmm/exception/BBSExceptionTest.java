package com.bbs.cmm.exception;

import com.bbs.cmm.data.BBSExceptionGenericTest;

import com.bbs.cmm.util.ConstantCMM;
import com.bbs.cmm.util.ConstantSystemCMM;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @name          BBSExceptionTest.
 * @description   Representa las pruebas unitarias de las excepciones genericas.
 * @creation      03/08/2022.
 * @user          @serbuitrago
 * @update        03/08/2022.
 * @user          @serbuitrago
 * @version       1.0.0.
 */
public class BBSExceptionTest extends BBSExceptionGenericTest<BBSException> {

    @Test
    @DisplayName("Empty")
    public void empty(){
        exception = new BBSException();
        test();
    }

    @Test
    @DisplayName("Message")
    public void message(){
        exception = new BBSException(message);
        test();
    }

    @Test
    @DisplayName("Code and message")
    public void codeAndmessage(){
        exception = new BBSException(code, message);
        test();
    }

    @Test
    @DisplayName("Code empty and message")
    public void codeEmptyAndmessage(){
        exception = new BBSException(ConstantCMM.VALUE_STRING_EMPTY, message);
        code = ConstantSystemCMM.CODE_ERROR_RESPONSE_COMMUNICATION;
        test();
    }

    @Test
    @DisplayName("toString")
    public void toStringCodeAndmessage(){
        exception = new BBSException(code, message);
        String codeMessageExpected = code
                .concat(ConstantCMM.VALUE_STRING_WHITE_SPACE)
                .concat(ConstantCMM.VALUE_STRING_SEPARATOR_HYPHEN)
                .concat(ConstantCMM.VALUE_STRING_WHITE_SPACE)
                .concat(message);
        String codeMessageActual = exception.toString();
        assertEquals(codeMessageExpected, codeMessageActual);
    }
}
