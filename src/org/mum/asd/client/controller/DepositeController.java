/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mum.asd.client.controller;

import java.awt.event.ActionEvent;
import org.mum.asd.client.view.DepositeDialog;
import org.mum.asd.framework.AccountManager.AccountManager;
import org.mum.asd.framework.AccountManager.BasicAccount;
import org.mum.asd.framework.AccountManager.IAccount;
import org.mum.asd.framework.controller.BaseController;
import org.mum.asd.framework.gui.CommonForm.AccountDialog;
import org.mum.asd.framework.gui.CommonForm.AccountFrm;
import org.mum.asd.framework.main.AppInitiator;
import org.mum.asd.framework.transaction.ITransaction;
import org.mum.asd.framework.transaction.WithDrawl;

/**
 *
 * @author dell
 */
public class DepositeController implements BaseController {

    private AccountManager accountManager;

    public DepositeController() {
        accountManager = AppInitiator.getAccManger();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        AccountFrm accountFrm = AppInitiator.getAccForm();
         String accnr = accountFrm.getAccountNo();
        AccountDialog dialog = new DepositeDialog(accountFrm, accnr);
        dialog.setBounds(430, 15, 275, 140);
        dialog.show();
    }

    public void deposite(String accNo, String name, String amount) {
        IAccount account = accountManager.getAccountById(accNo);
        ITransaction iTransaction = new WithDrawl();
        iTransaction.setAmount(Double.parseDouble(amount));
        iTransaction.setName(name);
        accountManager.deposite(account, iTransaction);
    }

}
