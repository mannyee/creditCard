package org.mum.asd.client.view;

import java.awt.Frame;

public class ReportDialog extends javax.swing.JDialog {

    public ReportDialog(Frame parent) {
        super(parent);

        getContentPane().setLayout(null);
        setSize(600, 367);
        setVisible(false);
        getContentPane().add(JScrollPane1);
        JScrollPane1.setBounds(24, 24, 500, 240);
        JScrollPane1.getViewport().add(JTextField1);
        JTextField1.setBounds(0, 0, 500, 240);
        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        getContentPane().add(JButton_OK);
        JButton_OK.setBounds(156, 276, 96, 24);


        SymAction lSymAction = new SymAction();
        JButton_OK.addActionListener(lSymAction);
    }

    public ReportDialog() {
        this((Frame) null);
    }
    
    public void setReport(String s){
        JTextField1.setText(s);
    }

    javax.swing.JScrollPane JScrollPane1 = new javax.swing.JScrollPane();
    javax.swing.JTextArea JTextField1 = new javax.swing.JTextArea();
    javax.swing.JButton JButton_OK = new javax.swing.JButton();

    class SymAction implements java.awt.event.ActionListener {

        public void actionPerformed(java.awt.event.ActionEvent event) {
            Object object = event.getSource();
            if (object == JButton_OK) {
                JButtonOK_actionPerformed(event);
            }
        }
    }

    void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
        dispose();

    }

}