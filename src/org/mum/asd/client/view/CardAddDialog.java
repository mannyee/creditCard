package org.mum.asd.client.view;

import java.awt.event.ActionEvent;

import org.mum.asd.client.controller.CardAddController;
import org.mum.asd.client.enums.CardAccountType;
import org.mum.asd.framework.gui.CommonForm.AccountFrm;
import org.mum.asd.framework.gui.CommonForm.JDialog_AddAccount;

public class CardAddDialog extends JDialog_AddAccount {

    protected javax.swing.JRadioButton JRadioButton_Bronze = new javax.swing.JRadioButton();
    
    public CardAddDialog(AccountFrm parent) {
        super(parent);
        setTitle("Add Credit Card Account");
        
        JRadioButton_Chk.setText("Gold");
        JRadioButton_Sav.setText("Silver");
        
        buttonGroup.add(JRadioButton_Bronze);
        
        JRadioButton_Bronze.setText("Bronze");
        JRadioButton_Bronze.setActionCommand("Bronze");
        getContentPane().add(JRadioButton_Bronze);
        JRadioButton_Bronze.setBounds(120, 24, 84, 24);
        //JRadioButton_Bronze.addMouseListener(aSymMouse);
        
        JLabel1.setText("Street");
        JLabel2.setText("City");
        JLabel3.setText("State");
        JLabel4.setText("Zip");
        JLabel5.setText("Email");
        JLabel7.setText("Exp. Date");
        JLabel8.setText("Name");
        
        JLabel6.setText("CC number");
        getContentPane().add(JLabel6);
        JLabel6.setForeground(java.awt.Color.black);
        JLabel6.setBounds(12, 204, 96, 24);

        repaint();
    }

    @Override
    protected void JButtonOK_actionPerformed(ActionEvent event) {
        String name, city, state, street, zip, accNum, expdate, email;
        
        name = JTextField_ACNR.getText();
        city = JTextField_STR.getText();
        state = JTextField_CT.getText();
        street = JTextField_NAME.getText();
        zip = JTextField_ST.getText();
        accNum = JTextField_BD.getText();
        expdate = JTextField_EM.getText();
        email = JTextField_ZIP.getText();
        
        if (JRadioButton_Chk.isSelected()) {
        	CardAccountType accountType = CardAccountType.GOLD;
            new CardAddController().createAccount(accountType, name, city, state, street, zip, accNum, expdate, email);
        } else if (JRadioButton_Sav.isSelected()) {
        	CardAccountType accountType = CardAccountType.SILVER;
            new CardAddController().createAccount(accountType, name, city, state, street, zip, accNum, expdate, email);
        } else if( JRadioButton_Bronze.isSelected()){
        	CardAccountType accountType = CardAccountType.BROZE;
            new CardAddController().createAccount(accountType, name, city, state, street, zip, accNum, expdate, email);
        }
        
        dispose();
    }

}