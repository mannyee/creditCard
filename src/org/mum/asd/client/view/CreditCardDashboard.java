/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mum.asd.client.view;


import java.awt.event.ActionListener;

import org.mum.asd.client.controller.CardAddController;
import org.mum.asd.client.enums.CardAccountType;
import org.mum.asd.client.model.CreditCardFactory;
import org.mum.asd.framework.factory.AppFactory;
import org.mum.asd.framework.gui.CommonForm.AccountFrm;
import org.mum.asd.framework.gui.components.ext.AccountEntryDataModel;
import org.mum.asd.framework.main.AppInitiator;
import org.mum.asd.framework.mediator.Mediator;


public class CreditCardDashboard extends AccountFrm {

    static {
        AppFactory.addAbstractFactory(CardAccountType.MAINACC, new CreditCardFactory());
    }

    public static CreditCardDashboard creditCard;

    public static CreditCardDashboard getInstance() {
        if (creditCard == null) {
            creditCard = new CreditCardDashboard();
            AppInitiator.setAccForm(creditCard);
        }
        return creditCard;
    }

    public CreditCardDashboard() {
        setTitle("Credit Card Application");

        JButton_PerAC.setText("Add Credit-card account");
        JButton_Withdraw.setText("Charge");
        JButton_CompAC.setText("Generate Monthly bills");

        //remove all listener that we have first
        for (ActionListener al : JButton_PerAC.getActionListeners()) {
            JButton_PerAC.removeActionListener(al);
        }
        for (ActionListener al : JButton_CompAC.getActionListeners()) {
            JButton_CompAC.removeActionListener(al);
        }
        for (ActionListener al : JButton_Deposit.getActionListeners()) {
            JButton_Deposit.removeActionListener(al);
        }
        for (ActionListener al : JButton_Withdraw.getActionListeners()) {
            JButton_Withdraw.removeActionListener(al);
        }

//        JButton_CompAC.addActionListener(new BillController());
        JButton_PerAC.addActionListener(new CardAddController());
//        JButton_Deposit.addActionListener(new DepositController());
//        JButton_Withdraw.addActionListener(new WithdrawController());
    }

}
