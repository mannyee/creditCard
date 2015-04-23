/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mum.asd.creditcard.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mum.asd.framework.AccountManager.AccountManager;
import org.mum.asd.framework.main.AppInitiator;

/**
 *
 * @author Raj
 */
public class InterestController implements ActionListener {

    private AccountManager accountManager = null;

    public InterestController() {
        accountManager = AppInitiator.getAccManger();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            accountManager.addInterest();
            //  JOptionPane.showMessageDialog(AppInitiator.getAccForm(), "Add interest to all accounts?", "Add interest to all accounts", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(InterestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
