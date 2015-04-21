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


public class DepositButton extends JButton implements IReceiverColleague {

    private static final String NAME = "DEPOSIT_BUTTON";
    private Mediator mediator;

    public DepositButton(Mediator mediator) {
        this.mediator = mediator;
    }

    public static String getNAME() {
        return NAME;
    }

    @Override
    public void receive(Message message) {
//        if (message.getAbout().equalsIgnoreCase(Message.ACCOUNT_SELECTED)) {
//            this.setEnabled(message.isStatus());
//        }
    }

}
