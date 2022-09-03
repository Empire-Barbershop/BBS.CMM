package com.bbs.cmm;

import com.bbs.cmm.data.ClientDataTest;
import com.bbs.cmm.exception.BBSException;
import com.bbs.cmm.exception.BBSFileException;
import com.bbs.cmm.exception.BBSParseException;
import com.bbs.cmm.util.ConstantCMM;
import com.bbs.cmm.util.ConstantSystemCMM;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @name          CommonParseCMMTest.
 * @description   Representa las pruebas unitarias de los parseos.
 * @creation      03/08/2022.
 * @user          @serbuitrago
 * @update        03/08/2022.
 * @user          @serbuitrago
 * @version       1.0.0.
 */
public class CommonParseCMMTest {

    private String path;
    private String fileName;
    private File file;

    @BeforeEach
    public void before() throws BBSException {
        path = "data/json/";
        fileName = "payload.json";
        file = CommonFileCMM.open(path, fileName, CommonFileCMM.class);
    }

    @Nested
    @DisplayName("JSONToClass")
    class CommonParseCMMTestToJSONToClass {

        @Test
        @DisplayName("Content class success")
        public void contentSuccess() throws BBSException {
            ClientDataTest client = CommonParseCMM.JSONToClass(file, ClientDataTest.class);
            assertNotNull(client);
        }

        @Test
        @DisplayName("Content path success")
        public void contentWithPathSuccess()  throws BBSException {
            path = file.getParent().concat("/");
            ClientDataTest client = CommonParseCMM.JSONToClass(path, fileName, ClientDataTest.class);
            assertNotNull(client);
        }
    }

    @Nested
    @DisplayName("ObjectToClass")
    class CommonParseCMMTestToObjectToClass {

        @Test
        @DisplayName("Success")
        public void contentSuccess() throws BBSException {
            ClientDataTest client = CommonParseCMM.ObjectToClass(CommonParseCMM.JSONToMap(file), ClientDataTest.class);
            assertNotNull(client);
        }

        @Test
        @DisplayName("Error not valid class")
        public void notValidClass(){
            BBSParseException parseException = assertThrows(BBSParseException.class, () ->
                    CommonParseCMM.ObjectToClass(new ArrayList<>(), (Class<?>) ConstantCMM.VALUE_OBJECT_DEFAULT)
            );
            String expectedMessage = ConstantSystemCMM.MESSAGE_ERROR_PARSE_OBJECT_TO_CLASS;
            String actualMessage = parseException.getMessage();
            assertEquals(expectedMessage, actualMessage);
        }

        @Test
        @DisplayName("Error not valid type object")
        public void notValidTypeObject(){
            BBSParseException parseException = assertThrows(BBSParseException.class, () ->
                    CommonParseCMM.ObjectToClass(new ArrayList<>(), ClientDataTest.class)
            );
            String expectedMessage = ConstantSystemCMM.MESSAGE_ERROR_FILE_CONTENT_NOT_VALID;
            String actualMessage = parseException.getMessage();
            assertEquals(expectedMessage, actualMessage);
        }
    }

    @Nested
    @DisplayName("JSONToArray")
    class CommonParseCMMTestToJSONToArray{

        private List<ClientDataTest> list;

        @BeforeEach
        public void before() throws BBSFileException {
            fileName = "payloadList.json";
            file = CommonFileCMM.open(path, fileName, CommonFileCMM.class);
        }

        @Test
        @DisplayName("Success to class")
        public void contentSuccess() throws BBSException {
            list = CommonParseCMM.JSONToArray(file, ClientDataTest[].class);
            assertNotNull(list);
            assertFalse(list.isEmpty());
        }

        @Test
        @DisplayName("Success to path")
        public void contentWithPathSuccess() throws BBSException {
            path = file.getParent().concat("/");
            list = CommonParseCMM.JSONToArray(path, fileName, ClientDataTest[].class);
            assertNotNull(list);
            assertFalse(list.isEmpty());
        }

        @Test
        @DisplayName("Error empty array")
        public void emptyArray() throws BBSException {
            fileName = "payloadListEmpty.json";
            file = CommonFileCMM.open(path, fileName, CommonFileCMM.class);
            BBSException btpException = assertThrows(BBSException.class, () ->
                    CommonParseCMM.JSONToArray(file, ClientDataTest[].class)
            );
            String expectedMessage = ConstantSystemCMM.MESSAGE_ERROR_FILE_CONTENT_NOT_VALID;
            String actualMessage = btpException.getMessage();
            assertEquals(expectedMessage, actualMessage);
        }
    }

    @Nested
    @DisplayName("JSONToMap")
    class CommonParseCMMTestToJSONToMap{
        private Map map;

        @Test
        @DisplayName("Success to class")
        public void contentSuccess() throws BBSException {
            map = CommonParseCMM.JSONToMap(file);
            assertNotNull(map);
            assertFalse(map.isEmpty());
        }

        @Test
        @DisplayName("Success to path")
        public void contentWithPathSuccess() throws BBSException {
            path = file.getParent().concat("/");
            map = CommonParseCMM.JSONToMap(path, fileName);
            assertNotNull(map);
            assertFalse(map.isEmpty());
        }
    }

    @Nested
    @DisplayName("JSONToString")
    class CommonParseCMMTestToJSONToString{
        @Test
        @DisplayName("Success to class")
        public void contentSuccess() throws BBSException {
            String content = CommonParseCMM.JSONToString(file);
            assertNotNull(content);
        }

        @Test
        @DisplayName("Success to path")
        public void contentWithPathSuccess() throws BBSException {
            path = file.getParent().concat("/");
            String content = CommonParseCMM.JSONToString(path, fileName);
            assertNotNull(content);
        }

        @Test
        @DisplayName("Error file is null")
        public void contentErrorFile() {
            file = (File) ConstantCMM.VALUE_OBJECT_DEFAULT;
            BBSException btpException = assertThrows(BBSException.class, () ->
                    CommonParseCMM.JSONToString(file)
            );
            String expectedMessage = ConstantSystemCMM.MESSAGE_ERROR_FILE_CONTENT_NOT_VALID;
            String actualMessage = btpException.getMessage();
            assertEquals(expectedMessage, actualMessage);
        }

        @Test
        @DisplayName("Error payload is empty")
        public void payloadEmpty() {
            path = file.getParent().concat("/");
            fileName = "payloadEmpty.json";
            BBSException btpException = assertThrows(BBSException.class, () ->
                    CommonParseCMM.JSONToString(path, fileName)
            );
            String expectedMessage = ConstantSystemCMM.MESSAGE_ERROR_FILE_NOT_CONTENT;
            String actualMessage = btpException.getMessage();
            assertEquals(expectedMessage, actualMessage);
        }
    }
}
