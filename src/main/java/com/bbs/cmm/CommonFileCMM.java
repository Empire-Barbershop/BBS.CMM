package com.bbs.cmm;

import com.bbs.cmm.exception.BBSFileException;
import com.bbs.cmm.util.ConstantCMM;
import com.bbs.cmm.util.ConstantSystemCMM;

import java.io.File;

/**
 * @name          ConstantCMM.
 * @description   Representa el manejo de archivos.
 * @creation      03/08/2022.
 * @user          @serbuitrago
 * @update        03/08/2022.
 * @user          @serbuitrago
 * @version       1.0.0.
 */
public class CommonFileCMM {

    /**
     * Metodo que permite abrir un archivo.
     * @param path representa la ruta.
     * @param fileName representa el nombre.
     * @return {@link File}
     * @throws BBSFileException representa la excepcion capturada del archivo.
     */
    public static File open(String path, String fileName) throws BBSFileException {
        return open(path, fileName, ConstantCMM.VALUE_BOOLEAN_FALSE, CommonFileCMM.class);
    }

    /**
     * Metodo que permite abrir un archivo mediante una instancia.
     * @param path representa la ruta.
     * @param fileName representa el nombre.
     * @param clazz representa la instancia.
     * @return {@link File}
     * @throws BBSFileException representa la excepcion capturada del archivo.
     */
    public static File open(String path, String fileName, Class<?> clazz) throws BBSFileException {
        return open(path, fileName, ConstantCMM.VALUE_BOOLEAN_TRUE, clazz);
    }

    /**
     * Metodo que permite abrir un archivo.
     * @param path representa la ruta.
     * @param fileName representa el nombre.
     * @param isClassLoader representa si es por medio de una instancia.
     * @param clazz representa la instancia.
     * @return {@link File}
     * @throws BBSFileException representa la excepcion capturada del archivo.
     */
    private static File open(String path, String fileName, boolean isClassLoader, Class<?> clazz) throws BBSFileException {
        if(!CommonValidateCMM.isValidString(path, fileName) || (isClassLoader && !CommonValidateCMM.isValidObject(clazz)))
            throw new BBSFileException(ConstantSystemCMM.CODE_ERROR_FILE_NOT_FOUND, ConstantSystemCMM.MESSAGE_ERROR_FILE_NOT_FOUND);
        String url = path.concat(fileName);
        File file = (isClassLoader) ?
                new File(clazz.getClassLoader().getResource(url).getFile()) :
                new File(url);
        if(!CommonValidateCMM.isValidObject(file))
            throw new BBSFileException(ConstantSystemCMM.CODE_ERROR_FILE_NOT_FOUND, ConstantSystemCMM.MESSAGE_ERROR_FILE_NOT_FOUND);
        return file;
    }
}
