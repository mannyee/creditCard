/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mum.asd.framework.transaction;

import java.util.Date;
import org.mum.asd.framework.AccountManager.IAccount;

/**
 *
 * @author dell
 */
public class ATransaction implements ITransaction{

    private Double amount;
    private String name;
    private Date date;
    private IAccount account;

    @Override
    public Double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public IAccount getAccount() {
        return account;
    }

    @Override
    public void setAccount(IAccount account) {
        this.account = account;
        account.addEntry(this);
    }


    
    
}
