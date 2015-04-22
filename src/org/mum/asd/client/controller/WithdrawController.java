package org.mum.asd.client.controller;

import com.sun.xml.internal.ws.wsdl.writer.document.Types;
import java.awt.event.ActionEvent;
import org.mum.asd.client.view.creditCard.WithdrawDialog;
import org.mum.asd.framework.AccountManager.AccountManager;
import org.mum.asd.framework.AccountManager.IAccount;

import org.mum.asd.framework.controller.BaseController;
import org.mum.asd.framework.gui.CommonForm.AccountFrm;
import org.mum.asd.framework.main.AppInitiator;
import org.mum.asd.framework.transaction.ATransaction;
import org.mum.asd.framework.transaction.ITransaction;
import org.mum.asd.framework.transaction.WithDrawl;

public class WithdrawController implements BaseController {

    private AccountManager accountManager;

    public WithdrawController() {
        accountManager = AppInitiator.getAccManger();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // TODO Auto-generated method stub
        AccountFrm accountFrm = AppInitiator.getAccForm();
        String accnr = accountFrm.getAccountNo();
        WithdrawDialog dep = new WithdrawDialog(accountFrm, accnr);
        dep.setBounds(430, 15, 275, 140);
        dep.show();
    }

    public void withdraw(String accrno, String amount, String name) {
        try {
            IAccount account = accountManager.getAccountById(accrno);
            ITransaction iTransaction = new WithDrawl();
            iTransaction.setAmount(Double.parseDouble(amount));
            iTransaction.setName(name);
            accountManager.withDraw(account, iTransaction);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
