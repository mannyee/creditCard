package org.mum.asd.client.view.creditCard;

import java.awt.event.ActionEvent;
import org.mum.asd.client.controller.WithdrawController;
import org.mum.asd.framework.gui.CommonForm.AccountFrm;
import org.mum.asd.framework.gui.CommonForm.JDialog_Dialogview;

public class WithdrawDialog extends JDialog_Dialogview {

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
