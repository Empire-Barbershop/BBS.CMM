package com.bbs.cmm.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @name          ClientDataTest.
 * @description   Representa la data para las pruebas unitarias.
 * @creation      03/08/2022.
 * @user          @serbuitrago
 * @update        03/08/2022.
 * @user          @serbuitrago
 * @version       1.0.0.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClientDataTest {

    private String name;
    private String lastName;
    private String email;
}
