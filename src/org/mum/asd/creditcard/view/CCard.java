/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mum.asd.creditcard.view;

import java.awt.event.ActionListener;

import org.mum.asd.creditcard.controller.MonthlyReportController;
import org.mum.asd.creditcard.controller.CardAddController;
import org.mum.asd.creditcard.controller.DepositeController;
import org.mum.asd.creditcard.controller.WithdrawController;
import org.mum.asd.creditcard.enums.CardAccountType;
import org.mum.asd.creditcard.model.CreditCardAccount;
import org.mum.asd.creditcard.model.CreditCardFactory;
import org.mum.asd.framework.AccountManager.AccountManager;
import org.mum.asd.framework.AccountManager.IAccount;
import org.mum.asd.framework.gui.CommonForm.AccountFrm;
import org.mum.asd.framework.gui.components.ext.AccountEntryDataModel;
import org.mum.asd.framework.main.AppInitiator;
import org.mum.asd.framework.main.FinCo;
import org.mum.asd.framework.mediator.Mediator;
import org.mum.asd.framework.mediator.Message;
import org.mum.asd.framework.partyPattern.AParty;

public class CCard extends AccountFrm {

    private Mediator mediator;
    public static CCard creditCard;

    static {
        creditCard = new CCard();
    }
    
    public static void main(String[] args) {
        AppInitiator.setAccForm(creditCard);
        FinCo.initializeApp();
    }

    public CCard() {
        mediator = AppInitiator.getMediator();
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

        JButton_CompAC.addActionListener(new MonthlyReportController());
        JButton_PerAC.addActionListener(new CardAddController());
        JButton_Deposit.addActionListener(new DepositeController());
        // JButton_Deposit.addActionListener(new DepositeController());
        JButton_Withdraw.addActionListener(new WithdrawController());
    }

    @Override
    public String getAccountNo() {
        int selection = table1.getSelectionModel().getMinSelectionIndex();
        String accnr = "0";
        try {
            accnr = (String) model.getValueAt(selection, 1);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return accnr;
    }

    @Override
    protected AccountEntryDataModel setTableModel(Mediator mediator) {
        AccountEntryDataModel model = new AccountEntryDataModel(mediator);

        model.addColumn("Name");
        model.addColumn("CC number");
        model.addColumn("Exp date");
        model.addColumn("Type");
        model.addColumn("Balance");

        return model;
    }

    @Override
    public void loadTableWithData() {
        model.setRowCount(0);
        AccountManager ac = AppInitiator.getAccManger();
        for (IAccount acc : ac.getAccountList()) {
            rowdata = new Object[8];
            AParty aParty = (AParty) acc.getParty();
            rowdata[0] = aParty.getName();

            rowdata[1] = acc.getAcctNumber();

            rowdata[2] = ((CreditCardAccount) acc).getExpiryDate();
            rowdata[3] = acc.getType();
            rowdata[4] = acc.getBalance();
            model.addRow(rowdata);
        }
        mediator.send(new Message(Message.ACCOUNT_SELECTED, false));
    }

}
