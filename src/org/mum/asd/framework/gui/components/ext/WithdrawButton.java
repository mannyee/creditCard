/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mum.asd.framework.gui.components.ext;

import javax.swing.JButton;
import org.mum.asd.framework.AccountManager.AccountManager;
import org.mum.asd.framework.mediator.IReceiverColleague;
import org.mum.asd.framework.mediator.Mediator;
import org.mum.asd.framework.mediator.Message;

/**
 *
 * @author sudell
 */
public class WithdrawButton extends JButton implements IReceiverColleague {

    private static final String NAME = "WITHDRAW_BUTTON";
    private Mediator mediator;

    public static String getNAME() {
        return NAME;
    }

    public WithdrawButton(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void receive(Message message) {
        if (message.getAbout().equalsIgnoreCase(Message.ACCOUNT_SELECTED)) {
            this.setEnabled(message.isStatus());
        }
    }

}
