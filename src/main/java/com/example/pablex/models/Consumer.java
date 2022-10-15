package com.example.pablex.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Consumer {

    private int id;
    private String key;
    private String firstName;
    private String lastName;
    private boolean check;

}