package org.mum.asd.framework.factory;

import org.mum.asd.framework.AccountManager.IAccount;
import org.mum.asd.framework.enums.PartyType;
import org.mum.asd.framework.partyPattern.Company;
import org.mum.asd.framework.partyPattern.IParty;
import org.mum.asd.framework.partyPattern.Person;

public class PartyFactory extends AbstractFactory {

    @Override
    public IParty getParty(Enum type) {
        if (type == PartyType.COMPANY) {
            return new Company();
        } else if (type == PartyType.PERSONAL) {
            return new Person();
        }
        return null;
    }

    @Override
    public IAccount getAccount(Enum type) {
        // TODO Auto-generated method stub
        return null;
    }

}
