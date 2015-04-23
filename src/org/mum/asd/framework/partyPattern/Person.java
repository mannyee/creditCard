package org.mum.asd.framework.partyPattern;

import org.mum.asd.framework.functors.IFunctor;
import java.util.Date;

import org.mum.asd.framework.AccountManager.IAccount;
import org.mum.asd.framework.predicates.IPredicate;
import org.mum.asd.framework.predicates.NegativeBalancePredicate;
import org.mum.asd.framework.predicates.Person500DepositPredicate;

public class Person extends AParty implements IPerson{
	private Date dateOfBirth;
    private final String type = "P";

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

	@Override
	public void addAccount(IAccount account) {
		super.addAccount(account);
		
	}

   

    @Override
    public void removeAccount(IAccount account) {
       // super.removeAccount(account);
    }

    
    @Override
    public String getType() {
        return type;
    }

    
    
	
	
    @Override
    public void sendEmail(IFunctor f, IPredicate p, double amount) {
        if (p != null) {
            if (p.check(amount)) {
                if (f != null) {
                    f.compute(this);
                }
            }
        } else {
            f.compute(this);
        }
    }

  

    /*public IPredicate getDepositPredicate() {
        return new Person500DepositPredicate();
    }

    public IPredicate getWithdrawPredicate() {
        return new NegativeBalancePredicate();
    }*/

    @Override
    public IPredicate getDepositPredicate() {
        return new Person500DepositPredicate();
    }

    @Override
    public IPredicate getWithdrawPredicate() {
        return new NegativeBalancePredicate();
    }
}
