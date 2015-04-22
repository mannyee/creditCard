/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mum.asd.framework.partyPattern;

import org.mum.asd.framework.functors.IFunctor;
import org.mum.asd.framework.AccountManager.IAccount;
import org.mum.asd.framework.predicates.IPredicate;

/**
 *
 * @author dell
 */
public class Company extends AParty implements ICompany {

    private Integer employeeNumber;
    private final String type = "C";

    public double getBalance() {
        return 0d;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public void setNoOfEmployee(Integer parseInt) {
        this.employeeNumber = parseInt;
    }

    public AParty getParty() {
        return this;
    }

    @Override
    public void removeAccount(IAccount account) {
        // TODO Auto-generated method stub

    }

    public String getType() {
        return type;
    }

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

    @Override
    public IPredicate getDepositPredicate() {
        return null;
    }

    @Override
    public IPredicate getWithdrawPredicate() {
        return null;
    }

}
