package org.mum.asd.client.controller;

import java.awt.event.ActionEvent;

import org.mum.asd.client.enums.CardAccountType;
import org.mum.asd.client.model.CreditCardAccount;
import org.mum.asd.client.view.CardAddDialog;
import org.mum.asd.framework.AccountManager.IAccount;
import org.mum.asd.framework.controller.BaseController;
import org.mum.asd.framework.enums.PartyType;
import org.mum.asd.framework.enums.Types;
import org.mum.asd.framework.factory.AppFactory;
import org.mum.asd.framework.gui.CommonForm.AccountFrm;
import org.mum.asd.framework.main.AppInitiator;
import org.mum.asd.framework.partyPattern.IParty;
import org.mum.asd.framework.partyPattern.Person;

public class CardAddController implements BaseController {

	@Override
    public void actionPerformed(ActionEvent ae) {
        AccountFrm accountFrm = AppInitiator.getAccForm();
        CardAddDialog dialog = new CardAddDialog(accountFrm);
        dialog.setBounds(450, 20, 300, 330);
        dialog.show();
    }

    public void createAccount(Enum accountType, String name, String city, String state, String street, String zip, String accNum, String expdate, String email) {
        IAccount account = AppFactory.getFactory(CardAccountType.MAINACC).getAccount(accountType);
        CreditCardAccount aAccount = (CreditCardAccount) account;
        aAccount.setAcctNumber(accNum);
        try {
            aAccount.setExpiryDate(expdate);
        } catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException in setDateOfBirth");
            aAccount.setExpiryDate("08/08/2014");
        }
        account = aAccount;

        IParty party = AppFactory.getFactory(Types.PARTY).getParty(PartyType.PERSONAL);
       
        Person c = (Person) party;
        c.setName(name);
        c.setCity(city);
        c.setState(state);
        c.setStreet(street);
        c.setZip(zip);
        c.setEmail(email);
        
        party = c;
        party.addAccount(account);
        
        AppInitiator.getAccManger().addAccountToList(account);

    }

}
