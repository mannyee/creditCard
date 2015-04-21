package org.mum.asd.client.model;

import org.mum.asd.client.enums.CardAccountType;
import org.mum.asd.framework.AccountManager.IAccount;
import org.mum.asd.framework.factory.AccountFactory;

public class CreditCardFactory extends AccountFactory{
	
	public CreditCardFactory() {
    }

    @Override
    public IAccount getAccount(Enum type) {
       if (type == CardAccountType.GOLD) {
            return new Gold();
        } else if (type == CardAccountType.SILVER) {
            return new Silver();
        } else if (type == CardAccountType.BROZE) {
            return new Bronze();
        }
        return null;
    }

}
