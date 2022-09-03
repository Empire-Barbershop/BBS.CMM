package com.bbs.cmm.exception;

import com.bbs.cmm.data.BBSExceptionGenericTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @name          BBSValidateExceptionTest.
 * @description   Representa las pruebas unitarias de las excepciones de validaciones.
 * @creation      03/08/2022.
 * @user          @serbuitrago
 * @update        03/08/2022.
 * @user          @serbuitrago
 * @version       1.0.0.
 */
public class BBSValidateExceptionTest extends BBSExceptionGenericTest<BBSValidateException> {

    @Test
    @DisplayName("Empty")
    public void empty(){
        exception = new BBSValidateException();
        test();
    }

    @Test
    @DisplayName("Message")
    public void message(){
        exception = new BBSValidateException(message);
        test();
    }

    @Test
    @DisplayName("Code and message")
    public void codeAndmessage(){
        exception = new BBSValidateException(code, message);
        test();
    }
}
