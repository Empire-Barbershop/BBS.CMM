package com.bbs.cmm.exception;

import com.bbs.cmm.data.BBSExceptionGenericTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @name          BBSParseExceptionTest.
 * @description   Representa las pruebas unitarias de las excepciones de parseos.
 * @creation      03/08/2022.
 * @user          @serbuitrago
 * @update        03/08/2022.
 * @user          @serbuitrago
 * @version       1.0.0.
 */
public class BBSParseExceptionTest extends BBSExceptionGenericTest<BBSParseException> {

    @Test
    @DisplayName("Empty")
    public void empty(){
        exception = new BBSParseException();
        test();
    }

    @Test
    @DisplayName("Message")
    public void message(){
        exception = new BBSParseException(message);
        test();
    }

    @Test
    @DisplayName("Code and message")
    public void codeAndmessage(){
        exception = new BBSParseException(code, message);
        test();
    }
}
