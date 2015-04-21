package org.mum.asd.framework.factory;

import org.mum.asd.framework.AccountManager.IAccount;
import org.mum.asd.framework.partyPattern.IParty;

public abstract class AbstractFactory {
	public abstract IParty getParty(Enum type);

	public abstract IAccount getAccount(Enum type);

	//public abstract ITransaction getTransaction(Enum type);
}
