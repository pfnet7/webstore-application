/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webstoreapp.entity;

import java.math.BigInteger;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author Nomysz
 */
@Getter
@ToString
public class Offer {

    public enum condition {
        NEW, USED
    }

    private String title;
    private BigInteger price;
    private String description;
    private String img_path;

}
