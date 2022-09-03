package com.bbs.cmm;

import com.bbs.cmm.util.ConstantCMM;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @name          CommonValidateCMMTest.
 * @description   Representa las pruebas unitarias de las validaciones.
 * @creation      03/08/2022.
 * @user          @serbuitrago
 * @update        03/08/2022.
 * @user          @serbuitrago
 * @version       1.0.0.
 */
public class CommonValidateCMMTest {

    private String name;
    private String [] names;

    @BeforeEach
    public void before(){
        name = "Sergio Stives Barrios Buitrago.";
        names = name.split(ConstantCMM.VALUE_STRING_WHITE_SPACE);
    }

    @Nested
    @DisplayName("Validate String")
    class CommonValidateCMMTestToString{

        @Test
        @DisplayName("Is valid")
        public void isValid(){
            boolean actual = CommonValidateCMM.isString(names);
            boolean expected = ConstantCMM.VALUE_BOOLEAN_TRUE;
            Assertions.assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Is empty")
        public void isEmpty(){
            names = null;
            boolean actual = CommonValidateCMM.isString(names);
            boolean expected = ConstantCMM.VALUE_BOOLEAN_FALSE;
            Assertions.assertEquals(expected, actual);
        }

        @Test
        @DisplayName("No valid")
        public void noValid(){
            name = "Sergio  Barrios";
            names = name.split(ConstantCMM.VALUE_STRING_WHITE_SPACE);
            boolean actual = CommonValidateCMM.isString(names);
            boolean expected = ConstantCMM.VALUE_BOOLEAN_FALSE;
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("Validate Object")
    class CommonValidateCMMTestToObject{
        @Test
        @DisplayName("Is valid")
        public void isValid(){
            boolean actual = CommonValidateCMM.isObject(name);
            boolean expected = ConstantCMM.VALUE_BOOLEAN_TRUE;
            Assertions.assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Is empty")
        public void isEmpty(){
            names = (String[]) ConstantCMM.VALUE_OBJECT_DEFAULT;
            boolean actual = CommonValidateCMM.isObject(names);
            boolean expected = ConstantCMM.VALUE_BOOLEAN_FALSE;
            Assertions.assertEquals(expected, actual);
        }

        @Test
        @DisplayName("No valid")
        public void noValid(){
            names = new String[ConstantCMM.VALUE_INTEGER_FIVE];
            boolean actual = CommonValidateCMM.isObject(names);
            boolean expected = ConstantCMM.VALUE_BOOLEAN_FALSE;
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("Validate List")
    class CommonValidateCMMTestToList{
        private List<String> namesList;

        @BeforeEach
        public void before(){
            namesList = Arrays.asList(names);
        }

        @Test
        @DisplayName("Is valid")
        public void isValid(){
            boolean actual = CommonValidateCMM.isList(namesList);
            boolean expected = ConstantCMM.VALUE_BOOLEAN_TRUE;
            Assertions.assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Is empty")
        public void isEmpty(){
            namesList =  new ArrayList<>();
            boolean actual = CommonValidateCMM.isList(namesList);
            boolean expected = ConstantCMM.VALUE_BOOLEAN_FALSE;
            Assertions.assertEquals(expected, actual);
        }
    }
}
