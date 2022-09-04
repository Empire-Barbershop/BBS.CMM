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
    public static final String CODE_ERROR_RESPONSE_STRUCTURE_FORMAT = "7000";
    public static final String CODE_ERROR_RESPONSE_STRUCTURE_PAYLOAD = "7010";
    public static final String CODE_ERROR_RESPONSE_STRUCTURE_PAYLOAD_FORMAT = "7011";
    public static final String CODE_ERROR_RESPONSE_STRUCTURE_STATUS = "7020";
    public static final String CODE_ERROR_RESPONSE_STRUCTURE_STATUS_NOT_VALID = "7021";
    public static final String CODE_ERROR_RESPONSE_STRUCTURE_STATUS_NOT_EXPECTED = "7022";
    public static final String CODE_ERROR_RESPONSE_STRUCTURE_PROPERTIES = "8000";
    public static final String CODE_ERROR_RESPONSE_STRUCTURE_PROPERTY_FORMAT = "8001";
    public static final String CODE_ERROR_RESPONSE_STRUCTURE_PROPERTY_KEY = "8002";
    public static final String CODE_ERROR_RESPONSE_STRUCTURE_PROPERTY_VALUE = "8003";
    public static final String CODE_ERROR_RESPONSE_UUID_EQUALS = "9000";
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
    public static final String MESSAGE_ERROR_RESPONSE_STRUCTURE_FORMAT = "No se recibieron todos datos.";
    public static final String MESSAGE_ERROR_RESPONSE_STRUCTURE_PAYLOAD = "El cuerpo no es valido.";
    public static final String MESSAGE_ERROR_RESPONSE_STRUCTURE_PAYLOAD_FORMAT = "El cuerpo no es el esperado.";
    public static final String MESSAGE_ERROR_RESPONSE_STRUCTURE_STATUS = "El estado de la respuesta no cuadra.";
    public static final String MESSAGE_ERROR_RESPONSE_STRUCTURE_STATUS_NOT_VALID = "El estado de la respuesta no es valido";
    public static final String MESSAGE_ERROR_RESPONSE_STRUCTURE_STATUS_NOT_EXPECTED = "El estado de la respuesta no es el esperado.";
    public static final String MESSAGE_ERROR_RESPONSE_STRUCTURE_PROPERTIES = "No se recibieron todos datos, fallo al validar las propiedades.";
    public static final String MESSAGE_ERROR_RESPONSE_STRUCTURE_PROPERTY_FORMAT = "Posible ataque... se encontraron propiedades no esperadas.";
    public static final String MESSAGE_ERROR_RESPONSE_STRUCTURE_PROPERTY_KEY = "Posible ataque... faltaron propiedades.";
    public static final String MESSAGE_ERROR_RESPONSE_STRUCTURE_PROPERTY_VALUE = "El valor de la propiedad no es el esperado.";
    public static final String MESSAGE_ERROR_RESPONSE_UUID_EQUALS = "Los identificadores no pueden ser los mismos.";
    public static final String MESSAGE_ERROR_RESPONSE_COMMUNICATION = "EXCEPTION";

    private ConstantSystemCMM(){}
}
