/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mum.asd.framework.transaction;

/**
 *
 * @author dell
 */
public class Deposite extends ATransaction {
	private final String TXNTYPE = "Deposit";

	public String getTxnType() {
		return TXNTYPE;
	}
}
