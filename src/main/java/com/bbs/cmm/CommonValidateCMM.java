package com.bbs.cmm;

import com.bbs.cmm.util.ConstantCMM;

import java.util.List;

/**
 * @name          CommonValidateCMM.
 * @description   Representa las validaciones.
 * @creation      03/08/2022.
 * @user          @serbuitrago
 * @update        03/08/2022.
 * @user          @serbuitrago
 * @version       1.0.0.
 */
public class CommonValidateCMM {

    private CommonValidateCMM(){}

    /**
     * Metodo que permite validar varias cadenas.
     * @param values representa las cadenas.
     * @return {@link boolean}
     */
    public static boolean isValidString(String... values) {
        if (!isValidArray(values))
            return ConstantCMM.VALUE_BOOLEAN_FALSE;
        for (String value : values) {
            if (ConstantCMM.VALUE_OBJECT_DEFAULT == value || value.trim().isEmpty())
                return ConstantCMM.VALUE_BOOLEAN_FALSE;
        }
        return ConstantCMM.VALUE_BOOLEAN_TRUE;
    }

    /**
     * Metodo que permite validar varios objetos.
     * @param values representa los objetos.
     * @return {@link boolean}
     */
    public static boolean isValidObject(Object ... values){
        if (!isValidArray(values))
            return ConstantCMM.VALUE_BOOLEAN_FALSE;
        for(Object object : values)
            if (ConstantCMM.VALUE_OBJECT_DEFAULT == object)
                return ConstantCMM.VALUE_BOOLEAN_FALSE;
        return ConstantCMM.VALUE_BOOLEAN_TRUE;
    }

    /**
     * Metodo que permite validar que un array no este vacio.
     * @param array representa el array.
     * @return {@link boolean}
     * @param <T> representa tipo de dato del array.
     */
    public static <T> boolean isValidArray(T... array){
        return ConstantCMM.VALUE_OBJECT_DEFAULT !=  array &&  array.length > ConstantCMM.VALUE_INTEGER_ZERO;
    }

    /**
     * Metodo que permite valida que la lista no este vacia.
     * @param elments representa la lista.
     * @return {@link boolean}
     * @param <T> representa tipo de dato de la lista.
     */
    public static <T> boolean isValidList(List<T> elments){
        return ConstantCMM.VALUE_OBJECT_DEFAULT != elments && elments.size() > ConstantCMM.VALUE_INTEGER_ZERO;
    }
}
