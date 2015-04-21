package org.mum.asd.client.model;

import org.mum.asd.framework.AccountManager.AAccount;
import org.mum.asd.framework.transaction.ITransaction;

public class CreditCardAccount extends AAccount{

    String expiryDate;
    double lastMonthBalance;

    public CreditCardAccount() {
    }
    
    @Override
    public double getInterestAmount() {
        return 10;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public double getLastMonthBalance() {
        return lastMonthBalance;
    }

    public void setLastMonthBalance(double lastMonthBalance) {
        this.lastMonthBalance = lastMonthBalance;
    }

	@Override
	public void addEntry(ITransaction transaction) {
		// TODO Auto-generated method stub
		
	}
    
    
}