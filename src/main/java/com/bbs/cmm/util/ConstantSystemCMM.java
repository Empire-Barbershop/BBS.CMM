package com.bbs.cmm.util;

/**
 * @name          ConstantSystemCMM.
 * @description   Representa las constantes del sistema .
 * @creation      03/08/2022.
 * @user          @serbuitrago
 * @update        03/08/2022.
 * @user          @serbuitrago
 * @version       1.0.0.
 */
public class ConstantSystemCMM {

    /**
     * CODES
     */
    // CODE ERROR - FILE
    public static final String CODE_ERROR_FILE_NOT_FOUND = "5000";
    public static final String CODE_ERROR_FILE_NOT_CONTENT = "5001";
    public static final String CODE_ERROR_FILE_CONTENT_NOT_VALID = "5002";

    // CODE ERROR - PARSE
    public static final String CODE_ERROR_PARSE_OBJECT_TO_CLASS = "6000";

    // CODE ERROR - RESPONSE
    public static final String CODE_ERROR_RESPONSE_COMMUNICATION = "500";

    /**
     * MESSAGES
     */
    // MESSAGE ERROR - FILE
    public static final String MESSAGE_ERROR_FILE_NOT_FOUND = "El archivo no fue encontrado!";
    public static final String MESSAGE_ERROR_FILE_NOT_CONTENT = "El archivo no tiene contenido!";
    public static final String MESSAGE_ERROR_FILE_CONTENT_NOT_VALID = "El contenido del archivo no es el esperado!";

    // MESSAGE ERROR - PARSE
    public static final String MESSAGE_ERROR_PARSE_OBJECT_TO_CLASS = "No se ha podido analizar el objeto a la clase indicada.";

    // MESSAGE ERROR - RESPONSE
    public static final String MESSAGE_ERROR_RESPONSE_COMMUNICATION = "EXCEPTION";

    private ConstantSystemCMM(){}
}
