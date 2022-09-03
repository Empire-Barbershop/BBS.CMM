package com.bbs.cmm;

import com.bbs.cmm.util.ConstantCMM;
import org.junit.jupiter.api.*;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @name          CommonValidateCMMTest.
 * @description   Representa las pruebas unitarias de las generaciones.
 * @creation      03/08/2022.
 * @user          @serbuitrago
 * @update        03/08/2022.
 * @user          @serbuitrago
 * @version       1.0.0.
 */
public class CommonGenerateCMMTest {

    @Nested
    @DisplayName("UUID")
    class CommonGenerateCMMTestToUUID{

        @Test
        @DisplayName("Is valid")
        public void valid(){
            UUID actual = CommonGenerateCMM.uuid();
            assertNotNull(actual);
        }
    }

    @Nested
    @DisplayName("Date")
    class CommonGenerateCMMTestToDate{

        @Test
        @DisplayName("Is valid")
        public void valid(){
            String actual = CommonGenerateCMM.date();
            assertNotNull(actual);
        }
    }

    @Nested
    @DisplayName("Concat")
    class CommonGenerateCMMTestToConcat{
        private String name;
        private String  [] names;
        private String separator;

        @BeforeEach
        public void before(){
            name = "Sergio Stives Barrios Buitrago";
            names = name.split(ConstantCMM.VALUE_STRING_WHITE_SPACE);
            separator = ConstantCMM.VALUE_STRING_WHITE_SPACE;
        }

        @Test
        @DisplayName("Is valid")
        public void valid(){
            String actual = CommonGenerateCMM.concat(separator, names);
            String expected = name;
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("No valid")
        public void noValid(){
            names[ConstantCMM.VALUE_INTEGER_THREE] = (String) ConstantCMM.VALUE_OBJECT_DEFAULT;
            name = (String) ConstantCMM.VALUE_OBJECT_DEFAULT;
            String actual = CommonGenerateCMM.concat(separator, names);
            String expected = name;
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("No valid separator")
        public void noValidSeparator(){
            separator = (String) ConstantCMM.VALUE_OBJECT_DEFAULT;
            String actual = CommonGenerateCMM.concat(separator, names);
            String expected = "SergioStivesBarriosBuitrago";
            assertEquals(expected, actual);
        }
    }
}
