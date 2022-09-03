package com.bbs.cmm.exception;

import com.bbs.cmm.data.BBSExceptionGenericTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @name          BBSFileExceptionTest.
 * @description   Representa las pruebas unitarias de las excepciones de archivos.
 * @creation      03/08/2022.
 * @user          @serbuitrago
 * @update        03/08/2022.
 * @user          @serbuitrago
 * @version       1.0.0.
 */
public class BBSFileExceptionTest extends BBSExceptionGenericTest<BBSFileException> {

    @Test
    @DisplayName("Empty")
    public void empty(){
        exception = new BBSFileException();
        test();
    }

    @Test
    @DisplayName("Message")
    public void message(){
        exception = new BBSFileException(message);
        test();
    }

    @Test
    @DisplayName("Code and message")
    public void codeAndmessage(){
        exception = new BBSFileException(code, message);
        test();
    }
}
