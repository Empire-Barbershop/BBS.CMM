package com.bbs.cmm.exception;

import com.bbs.cmm.data.BBSExceptionGenericTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @name          BBSDataBaseExceptionTest.
 * @description   Representa las pruebas unitarias de las excepciones de base datos.
 * @creation      03/08/2022.
 * @user          @serbuitrago
 * @update        03/08/2022.
 * @user          @serbuitrago
 * @version       1.0.0.
 */
public class BBSDataBaseExceptionTest extends BBSExceptionGenericTest<BBSDataBaseException> {

    @Test
    @DisplayName("Empty")
    public void empty(){
        exception = new BBSDataBaseException();
        test();
    }

    @Test
    @DisplayName("Message")
    public void message(){
        exception = new BBSDataBaseException(message);
        test();
    }

    @Test
    @DisplayName("Code and message")
    public void codeAndmessage(){
        exception = new BBSDataBaseException(code, message);
        test();
    }
}
