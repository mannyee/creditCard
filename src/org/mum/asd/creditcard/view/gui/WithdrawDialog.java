package org.mum.asd.creditcard.view.gui;

import java.awt.event.ActionEvent;

import org.mum.asd.creditcard.controller.WithdrawController;
import org.mum.asd.framework.gui.CommonForm.AccountFrm;
import org.mum.asd.framework.gui.CommonForm.TransactionDialog;

public class WithdrawDialog extends TransactionDialog {

    public WithdrawDialog(AccountFrm parent, String aaccnr) {
        super(parent, aaccnr);
        setTitle("Withdraw Money");
    }

    @Override
    protected void JButtonOK_actionPerformed(ActionEvent event) {
        String name = JTextField_NAME.getText();
        String amount = JTextField_Deposit.getText();
        new WithdrawController().withdraw(this.getAccnr(), amount, name);
        dispose();
        setVisible(false);
    }
}
