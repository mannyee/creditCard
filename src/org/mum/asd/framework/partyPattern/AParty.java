package org.mum.asd.framework.partyPattern;

import java.util.ArrayList;
import java.util.List;

import org.mum.asd.framework.AccountManager.IAccount;

public abstract class AParty implements IParty {

    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String email;
    private String type;
    private List<IAccount> accountList;

    public AParty() {
        accountList = new ArrayList<IAccount>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void addAccount(IAccount account) {
        this.accountList.add(account);
        account.setParty(this);
    }

}
