package org.mum.asd.framework.AccountManager;

import org.mum.asd.framework.functors.IFunctor;
import org.mum.asd.framework.functors.NegativeBalanceFunctor;
import org.mum.asd.framework.functors.NewBalanceFunctor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.mum.asd.framework.enums.Types;
import org.mum.asd.framework.mediator.IColleague;
import org.mum.asd.framework.mediator.ISenderColleague;
import org.mum.asd.framework.mediator.Mediator;
import org.mum.asd.framework.mediator.Message;
import org.mum.asd.framework.transaction.ATransaction;
import org.mum.asd.framework.transaction.ITransaction;
import org.mum.asd.framework.transaction.WithDrawl;
import org.mum.asd.framework.partyPattern.AParty;
import org.mum.asd.framework.partyPattern.IParty;
import org.mum.asd.framework.predicates.IPredicate;
import org.mum.asd.framework.predicates.NegativeBalancePredicate;
import org.mum.asd.framework.predicates.Person500DepositPredicate;
import org.mum.asd.framework.transaction.Deposite;

public class AccountManager implements ISenderColleague {

    private static final String NAME = "ACCOUNT_MANAGER";
    private Mediator mediator;

    public List<IAccount> listOfAccount;

    public AccountManager(Mediator md) {
        listOfAccount = new ArrayList<IAccount>();
        mediator = md;
    }

    public List<IAccount> getAccountList() {
        return listOfAccount;
    }

    public void addAccountToList(IAccount account) {
        AParty a = (AParty) account.getParty();
        IParty c = account.getParty();
        this.listOfAccount.add(account);
        this.send(new Message(Message.UPDATE_ACCOUNT_TABLE, true));
    }

    public AAccount getAccountById(String id) {
        for (IAccount a : listOfAccount) {
            if (a.getAcctNumber().equalsIgnoreCase(id)) {
                return (AAccount) a;
            }
        }
        return null;
    }

	public void withDraw(IAccount account, ATransaction transaction) {
        double balance = account.getBalance() - transaction.getAmount();
        account.setBalance(balance);

        IPredicate p = account.getParty().getWithdrawPredicate();
        IFunctor f = new NewBalanceFunctor();
        if(balance<1){
            f = new NegativeBalanceFunctor();
        }
        account.getParty().sendEmail(f, p, account.getBalance());

        
        ITransaction deposit = new WithDrawl();//FactoryProducer.getFactory(Types.TRANSACTION).getTransaction(TransactionType.DEPOSIT);
       
        deposit.setName(transaction.getName());
        deposit.setAccount(account);
         deposit.setAmount(transaction.getAmount());
        account.addEntry(deposit);
        

        this.send(new Message(Message.UPDATE_ACCOUNT_TABLE, true));
        
    }

    public void deposite(AAccount account, ATransaction transaction) {
        double balance = account.getBalance() + transaction.getAmount();
        account.setBalance(balance);

        IPredicate p = account.getParty().getDepositPredicate();
        IFunctor f = new NewBalanceFunctor();
        account.getParty().sendEmail(f, p, account.getBalance());

        ITransaction withdraw = new Deposite();//FactoryProducer.getFactory(Types.TRANSACTION).getTransaction(TransactionType.DEPOSIT);
        
        withdraw.setName(transaction.getName());
        withdraw.setAccount(account);
        withdraw.setAmount(transaction.getAmount());
        account.addEntry(withdraw);
        

        this.send(new Message(Message.UPDATE_ACCOUNT_TABLE, true));
    }

    public void addInterest() {
        for (IAccount account : listOfAccount) {
            double interestRate = account.getInterest();
            ITransaction deposit = new Deposite();//FactoryProducer.getFactory(Types.TRANSACTION).getTransaction(TransactionType.DEPOSIT);
            //deposit.setupTransaction(this, account);
            //deposit.setName(Deposite.DEPOSIT_INTEREST);
            //deposit.setName("Deposit_Interest");
            // deposit.setAmount(interestAmount);
            // transactionManager.execute(deposit);
            double newBalance = account.getBalance() + account.getBalance() * interestRate * 0.01;
            account.setBalance(newBalance);
            this.send(new Message(Message.UPDATE_ACCOUNT_TABLE, true));
        }
        //  this.updateAccountTable();
    }

    @Override
    public void send(Message message) {
        mediator.send(message);
    }

    @Override
    public String getName() {
        return NAME;
    }

    public void updateAccountTable() {
        this.send(new Message(Message.UPDATE_ACCOUNT_TABLE, true));
    }
    

    
    public StringBuilder generateReport() {
        StringBuilder myBuilder = new StringBuilder();
        
        for(IAccount account : listOfAccount){
        	myBuilder.append("\n" + account.generateReport().toString());
        }
        
        return myBuilder;
    }
    
}
