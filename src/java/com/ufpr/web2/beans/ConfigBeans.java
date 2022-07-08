/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.web2.beans;

import java.io.Serializable;

/**
 *
 * @author jussarasimoesdecarvalho
 */
public class ConfigBeans implements Serializable{
    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }  
}
