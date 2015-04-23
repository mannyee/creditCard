package org.mum.asd.framework.factory;

import org.mum.asd.framework.AccountManager.BasicAccount;
import org.mum.asd.framework.AccountManager.IAccount;
import org.mum.asd.framework.enums.AccountType;
import org.mum.asd.framework.partyPattern.IParty;

public class AccountFactory {

	

    public IAccount getAccount(Enum type) {
        if (type == AccountType.BASIC_ACCOUNT) {
            return new BasicAccount();
        }
        return null;
    }

}
