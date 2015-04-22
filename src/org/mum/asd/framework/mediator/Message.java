/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mum.asd.framework.mediator;

/**
 *
 * @author xtrememe
 */
public class Message {

    public static final String ACCOUNT_SELECTED = "ACCOUNT_SELECTED";
    public static final String ACCOUNT_LIST_NOT_EMPTY = "ACCOUNT_LIST_NOT_EMPTY";
    public static final String UPDATE_ACCOUNT_TABLE = "UPDATE_ACCOUNT_TABLE";
    
    private String about;
    private boolean status;

    public Message(String about, boolean status) {
        this.about = about;
        this.status = status;
    }

    public String getAbout() {
        return about;
    }

    public boolean isStatus() {
        return status;
    }
}
