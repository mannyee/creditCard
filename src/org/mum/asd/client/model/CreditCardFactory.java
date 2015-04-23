package org.mum.asd.client.model;

import org.mum.asd.client.enums.CardAccountType;
import org.mum.asd.framework.AccountManager.IAccount;

public class CreditCardFactory{
	
	public CreditCardFactory() {
    }

    public static IAccount getAccount(Enum type) {
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
