package com.bbs.cmm.data;

import com.bbs.cmm.exception.BBSException;
import com.bbs.cmm.util.ConstantSystemCMM;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @name          BBSExceptionGenericTest.
 * @description   Representa la data para las pruebas unitarias.
 * @creation      03/08/2022.
 * @user          @serbuitrago
 * @update        03/08/2022.
 * @user          @serbuitrago
 * @version       1.0.0.
 */
public class BBSExceptionGenericTest <T extends BBSException> {

    protected T exception;
    protected String code;
    protected String message;

    @BeforeEach
    public void before(){
        code = ConstantSystemCMM.CODE_ERROR_RESPONSE_COMMUNICATION;
        message = ConstantSystemCMM.MESSAGE_ERROR_RESPONSE_COMMUNICATION;
    }

    /**
     * Metodo que tiene la prueba generica de las excepciones.
     */
    public void test(){
        String codeExpected = code;
        String codeActual = exception.getCodeError();
        assertEquals(codeExpected, codeActual);
    }
}
