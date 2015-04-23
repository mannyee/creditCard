/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mum.asd.creditcard.view;

import org.mum.asd.creditcard.controller.DepositeController;
import org.mum.asd.framework.gui.CommonForm.AccountFrm;
import org.mum.asd.framework.gui.CommonForm.TransactionDialog;

/**
 *
 * @author dell
 */
public class DepositeDialog extends TransactionDialog {

    public DepositeDialog(AccountFrm parent, String aaccnr) {
        super(parent, aaccnr);
    }

    @Override
    protected void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
        String name = JTextField_NAME.getText();
        String amount = JTextField_Deposit.getText();
        new DepositeController().deposite(this.getAccnr(), name, amount);
        dispose();
        setVisible(false);
    }
}
