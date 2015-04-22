/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mum.asd.framework.transaction;

import org.mum.asd.framework.AccountManager.IAccount;

/**
 *
 * @author dell
 */
public interface ITransaction {

    public void setAmount(Double amt);
    
    public Double getAmount();

    public void setName(String name);

    public void setAccount(IAccount account);
    
    public String getTxnType();
}
