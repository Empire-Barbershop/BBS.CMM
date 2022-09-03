package com.bbs.cmm;

import com.bbs.cmm.exception.BBSFileException;
import com.bbs.cmm.exception.BBSParseException;

import com.bbs.cmm.util.ConstantCMM;
import com.bbs.cmm.util.ConstantSystemCMM;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @name          CommonParseCMM.
 * @description   Representa los parseos.
 * @creation      03/08/2022.
 * @user          @serbuitrago
 * @update        03/08/2022.
 * @user          @serbuitrago
 * @version       1.0.0.
 */
public class CommonParseCMM {

    private CommonParseCMM(){}

    /**
     * Metodo que permite parsear un json a una clase.
     * @param path representa la ruta.
     * @param fileName representa el nombre.
     * @param clazz representa la instancia clase.
     * @return {@link T}
     * @param <T> representa el tipo de la clase.
     * @throws BBSParseException representa la excepcion capturada al parsear.
     * @throws BBSFileException representa la excepcion capturada del archivo.
     */
    public static <T> T JSONToClass(String path, String fileName, Class<?> clazz) throws BBSParseException, BBSFileException {
        return ObjectToClass(JSONToString(path, fileName), clazz);
    }

    /**
     * Metodo que permite parsear un json a una clase.
     * @param file representa el archivo.
     * @param clazz representa la instancia clase.
     * @return {@link T}
     * @param <T> representa el tipo de la clase.
     * @throws BBSParseException representa la excepcion capturada al parsear.
     */
    public static <T> T JSONToClass(File file, Class<?> clazz) throws BBSParseException {
        return ObjectToClass(JSONToString(file), clazz);
    }

    /**
     * Metodo que permite parsear un objeto a una clase.
     * @param object representa el objeto.
     * @param clazz representa la instancia clase.
     * @return {@link T}
     * @param <T> representa el tipo de la clase.
     * @throws BBSParseException representa la excepcion capturada al parsear.
     */
    public static <T> T ObjectToClass(Object object, Class<?> clazz) throws BBSParseException {
        if (!CommonValidateCMM.isObject(object, clazz))
            throw new BBSParseException(ConstantSystemCMM.CODE_ERROR_PARSE_OBJECT_TO_CLASS, ConstantSystemCMM.MESSAGE_ERROR_PARSE_OBJECT_TO_CLASS);
        Gson gson = new Gson();
        if (object instanceof String)
            return (T) gson.fromJson(object.toString(), clazz);
        if(object instanceof JsonElement)
            return (T) gson.fromJson((JsonElement)object, clazz);
        if(object instanceof Map) {
            JsonElement jsonElement = gson.toJsonTree(object);
            return ObjectToClass(jsonElement, clazz);
        }
        throw new BBSParseException(ConstantSystemCMM.CODE_ERROR_FILE_CONTENT_NOT_VALID, ConstantSystemCMM.MESSAGE_ERROR_FILE_CONTENT_NOT_VALID);
    }

    /**
     * Metodo que permite parsear un json a array.
     * @param path representa la ruta.
     * @param fileName representa el nombre.
     * @param clazz representa la instancia clase.
     * @return {@link List<T>}
     * @param <T> representa el tipo de la instancia.
     * @throws BBSParseException representa la excepcion capturada al parsear.
     * @throws BBSFileException representa la excepcion capturada del archivo.
     */
    public static <T> List<T> JSONToArray(String path, String fileName, Class<T[]> clazz) throws BBSParseException, BBSFileException {
        return JSONToArray(CommonFileCMM.open(path, fileName), clazz);
    }

    /**
     * Metodo que permite parsear un json a array.
     * @param file representa el archivo.
     * @param clazz representa la instancia clase.
     * @return {@link List<T>}
     * @param <T> representa el tipo de la instancia.
     * @throws BBSParseException representa la excepcion capturada al parsear.
     */
    public static <T> List<T> JSONToArray(File file, Class<T[]> clazz) throws BBSParseException {
        String content = JSONToString(file);
        T [] array = new Gson().fromJson(content, clazz);
        if(!CommonValidateCMM.isArray(array))
            throw new BBSParseException(ConstantSystemCMM.CODE_ERROR_FILE_CONTENT_NOT_VALID, ConstantSystemCMM.MESSAGE_ERROR_FILE_CONTENT_NOT_VALID);
        return new ArrayList<>(Arrays.asList(array));
    }

    /**
     * Metodo que permite parsear un objeto a un map.
     * @param path representa la ruta.
     * @param fileName representa el nombre.
     * @return {@link  Map}
     * @throws BBSParseException representa la excepcion capturada al parsear.
     * @throws BBSFileException representa la excepcion capturada del archivo.
     */
    public static Map JSONToMap(String path, String fileName) throws BBSParseException, BBSFileException {
        return JSONToMap(CommonFileCMM.open(path, fileName));
    }

    /**
     * Metodo que permite parsear un objeto a un map.
     * @param file representa el archivo.
     * @return {@link  Map}
     * @throws BBSParseException representa la excepcion capturada al parsear.
     */
    public static Map JSONToMap(File file) throws BBSParseException {
        return new Gson().fromJson(JSONToString(file), Map.class);
    }

    /**
     * Metodo que permite parsear un json a string.
     * @param path representa la ruta.
     * @param fileName representa el nombre.
     * @return {@link String}
     * @throws BBSParseException representa la excepcion capturada al parsear.
     * @throws BBSFileException representa la excepcion capturada del archivo.
     */
    public static String JSONToString(String path, String fileName) throws BBSParseException, BBSFileException {
        return JSONToString(CommonFileCMM.open(path, fileName));
    }

    /**
     * Metodo que permite parsear un json a string.
     * @param file representa el archivo.
     * @return {@link String}
     * @throws BBSParseException representa la excepcion capturada al parsear.
     */
    public static String JSONToString(File file) throws BBSParseException {
        Gson gson = new Gson();
        String content;
        try {
            Reader reader = new FileReader(file);
            JsonElement json = gson.fromJson(reader, JsonElement.class);
            content = gson.toJson(json);
        } catch (IOException | NullPointerException  exception) {
            throw new BBSParseException(ConstantSystemCMM.CODE_ERROR_FILE_CONTENT_NOT_VALID, ConstantSystemCMM.MESSAGE_ERROR_FILE_CONTENT_NOT_VALID);
        }
        if(!CommonValidateCMM.isString(content) || ConstantCMM.VALUE_STRING_JSON_EMPTY.equals(content))
            throw new BBSParseException(ConstantSystemCMM.CODE_ERROR_FILE_NOT_CONTENT, ConstantSystemCMM.MESSAGE_ERROR_FILE_NOT_CONTENT);
        return content;
    }

}
