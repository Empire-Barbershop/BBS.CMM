package com.bbs.cmm.exception;

import com.bbs.cmm.data.BBSExceptionGenericTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @name          BBSRestClientExceptionTest.
 * @description   Representa las pruebas unitarias de las excepciones de comunicacion.
 * @creation      03/08/2022.
 * @user          @serbuitrago
 * @update        03/08/2022.
 * @user          @serbuitrago
 * @version       1.0.0.
 */
public class BBSRestClientExceptionTest extends BBSExceptionGenericTest<BBSRestClientException> {

    @Test
    @DisplayName("Empty")
    public void empty(){
        exception = new BBSRestClientException();
        test();
    }

    @Test
    @DisplayName("Message")
    public void message(){
        exception = new BBSRestClientException(message);
        test();
    }

    @Test
    @DisplayName("Code and message")
    public void codeAndmessage(){
        exception = new BBSRestClientException(code, message);
        test();
    }
}
