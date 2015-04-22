package org.mum.asd.framework.AccountManager;

import org.mum.asd.framework.partyPattern.IParty;
import org.mum.asd.framework.transaction.ITransaction;

public class BasicAccount extends AAccount {


    public double getCurrentBalance() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setParty(IParty iParty) {
        // TODO Auto-generated method stub

    }

    @Override
    public Double getInterest() {
        return 5d;
    }
//
//    @Override
//    public AParty getParty() {
//        // TODO Auto-generated method stub
//        return (AParty) this;
//    }
}
