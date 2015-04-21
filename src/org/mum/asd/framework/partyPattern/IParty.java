package org.mum.asd.framework.partyPattern;

import org.mum.asd.framework.AccountManager.IAccount;

public interface IParty {
	public void addAccount(IAccount account);

	public void removeAccount(IAccount account);

	//public void sendEmail(IFunctor f, IPredicate p, double amount);

	public String getType();

	public String getName();

	public void setName(String name);

	//public IPredicate getDepositPredicate();

	//public IPredicate getWithdrawPredicate();

	public double getBalance();
}
