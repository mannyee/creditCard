package org.mum.asd.creditcard.model;

import org.mum.asd.framework.AccountManager.AAccount;
import org.mum.asd.framework.transaction.ITransaction;

public abstract class CreditCardAccount extends AAccount {

    String expiryDate;
    double lastMonthBalance;

    public CreditCardAccount() {
    }

    
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

   
    public abstract double getMi();

    public abstract double getMp();
}
