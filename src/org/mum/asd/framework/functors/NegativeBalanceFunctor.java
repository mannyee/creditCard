/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mum.asd.framework.functors;

import javax.swing.JOptionPane;
import org.mum.asd.framework.main.AppInitiator;
import org.mum.asd.framework.partyPattern.IParty;


/**
 *
 * @author dell
 */
public class NegativeBalanceFunctor implements IFunctor<IParty> {

    @Override
    public void compute(IParty p) {
//        System.out.println("Your balance is negative: " + p.getBalance());
                JOptionPane.showMessageDialog(AppInitiator.getAccForm(), "Your balance is negative: " + p.getBalance(), "Email ALert", JOptionPane.WARNING_MESSAGE);

    }
}
