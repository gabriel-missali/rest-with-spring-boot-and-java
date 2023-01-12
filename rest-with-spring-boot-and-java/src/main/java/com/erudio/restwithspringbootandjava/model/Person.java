package com.erudio.restwithspringbootandjava.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person  implements Serializable {

    private long id;
    private String firstName;
    private String lastName;
    private String Address;
    private String gender;

}
