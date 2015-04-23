package org.mum.asd.creditcard.model;

import org.mum.asd.creditcard.enums.CardAccountType;
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
