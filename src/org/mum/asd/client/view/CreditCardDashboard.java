/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mum.asd.client.view;


import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import org.mum.asd.framework.gui.CommonForm.AccountFrm;
import org.mum.asd.framework.gui.components.ext.AccountEntryDataModel;
import org.mum.asd.framework.mediator.Mediator;
import org.mum.asd.framework.mediator.Message;
import org.mum.asd.framework.partyPattern.AParty;

/**
 *
 * @author naimi_000
 */
public class CreditCardDashboard extends AccountFrm {

    static {
//        FactoryProducer.addAbstractFactory(CreditAccountType.MYAC, new CreditCardFactory());
    }

    public static CreditCardDashboard creditCard;

    public static CreditCardDashboard getInstance() {
        if (creditCard == null) {
            creditCard = new CreditCardDashboard();
//            ClassicSingleton.setAccountFrm(creditCard);
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
//        JButton_PerAC.addActionListener(new AddCreditCardController());
//        JButton_Deposit.addActionListener(new DepositController());
//        JButton_Withdraw.addActionListener(new WithdrawController());
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
//        try {
//            model.setRowCount(0);
//            AccountManager accountManager = ClassicSingleton.getInstanceAccountManager();
//            for (Iterator<AAccount> it = accountManager.getAccountList().getSortedIterator(new AccountComparator(selectedColumn)); it.hasNext();) {
//                IAccount iAccount = it.next();
//                rowdata = new Object[8];
//                rowdata[1] = iAccount.getAcctNumber();
//                AParty aParty = (AParty) iAccount.getParty();
//                rowdata[0] = aParty.getName();
//                CreditCardAccount account = (CreditCardAccount) iAccount;
//                rowdata[2] = account.getExpiryDate();
//                rowdata[3] = iAccount.getType();
//                rowdata[4] = iAccount.getCurrentBalance();
//                model.addRow(rowdata);
//            }
//            model.send(new Message(accountManager.ACCOUNT_SELECTED, false));
//        } catch (Exception ex) {
//            Logger.getLogger(AccountFrm.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

}
