package org.mum.asd.framework.AccountManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.mum.asd.framework.partyPattern.AParty;
import org.mum.asd.framework.partyPattern.IParty;
import org.mum.asd.framework.transaction.ITransaction;

/**
 *
 * @author dell
 */
public abstract class AAccount implements IAccount {

    private String acctNumber;
    private List<ITransaction> transactions = new ArrayList();
    private Double balance = 0.0;
    private IParty iParty;
    private String type;

    public String getAcctNumber() {
        return acctNumber;
    }

    public void setAcctNumber(String acctNumber) {
        this.acctNumber = acctNumber;
    }

    public List<ITransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<ITransaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public Double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public IParty getParty() {
        return iParty;
    }

    public void setParty(IParty iParty) {
        this.iParty = iParty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    @Override
    public void addEntry(ITransaction transaction) {
    	transactions.add(transaction);
    	
    }
    
    
    public StringBuilder generateReport() {

        StringBuilder myBuilder = new StringBuilder();
        myBuilder.append("\n------------- Account No: " + acctNumber + " -------------\n");
        myBuilder.append(this.toString() + "\n");
        myBuilder.append("::: Transaction(s) History :::\n");
        
        
        System.out.println("size: " + this.transactions.size());
        
        for(ITransaction txn : this.transactions){
        	myBuilder.append(txn.getTxnType() + " => " + txn.getAmount() + "\n");
        }
        
        return myBuilder;
    }

    @Override
    public String toString() {
        return "AAccount{" + "acctNumber=" + acctNumber + ", balance=" + balance + '}';
    }
}
