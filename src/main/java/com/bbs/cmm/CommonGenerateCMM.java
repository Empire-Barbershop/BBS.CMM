package com.bbs.cmm;

import com.bbs.cmm.util.ConstantCMM;

import java.util.Date;
import java.util.UUID;

/**
 * @name          ConstantCMM.
 * @description   Representa las generaciones.
 * @creation      03/08/2022.
 * @user          @serbuitrago
 * @update        03/08/2022.
 * @user          @serbuitrago
 * @version       1.0.0.
 */
public class CommonGenerateCMM {

    private CommonGenerateCMM(){}

    /**
     * Metodo que permite generar un identificador.
     * @return {@link UUID}
     */
    public static UUID uuid(){
        return UUID.randomUUID();
    }

    /**
     * Metodo que permite generar una fecha.
     * @return {@link String}
     */
    public static String date(){
        return new Date().toString();
    }

    /**
     * Metodo que permite concatenar una cadena nueva.
     * @param separator representa el separador.
     * @param values representa las cadenas.
     * @return {@link String}
     */
    public static String concat(String separator, String... values){
        if(!CommonValidateCMM.isString(values))
            return (String) ConstantCMM.VALUE_OBJECT_DEFAULT;
        if(!CommonValidateCMM.isString(separator))
            separator = ConstantCMM.VALUE_STRING_CONCAT;
        String result = ConstantCMM.VALUE_STRING_EMPTY;
        int size = values.length;
        int position = ConstantCMM.VALUE_INTEGER_ZERO;
        boolean addSeparator;
        for(String value : values){
            addSeparator = CommonValidateCMM.isString(value);
            if(!addSeparator)
                value = ConstantCMM.VALUE_STRING_EMPTY;
            else addSeparator = (position + ConstantCMM.VALUE_INTEGER_ONE) < size;
            result += value.concat(addSeparator ? separator : ConstantCMM.VALUE_STRING_EMPTY);
            position++;
        }
        return result;
    }
}
