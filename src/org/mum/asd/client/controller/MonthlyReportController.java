/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mum.asd.client.controller;

import java.awt.event.ActionEvent;

import org.mum.asd.client.view.ReportDialog;
import org.mum.asd.framework.controller.BaseController;
import org.mum.asd.framework.gui.CommonForm.AccountFrm;
import org.mum.asd.framework.main.AppInitiator;

/**
 *
 * @author dell
 */
public class MonthlyReportController implements BaseController {

	@Override
	public void actionPerformed(ActionEvent ae) {
		AccountFrm accountFrm = AppInitiator.getAccForm();
		ReportDialog dialog = new ReportDialog(accountFrm);
		String a = AppInitiator.getAccManger().generateReport().toString();
		dialog.setReport(a);
		dialog.setBounds(450, 20, 300, 330);
		dialog.show();
	}

}