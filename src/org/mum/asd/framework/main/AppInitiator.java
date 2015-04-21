package org.mum.asd.framework.main;

import org.mum.asd.framework.AccountManager.AccountManager;
import org.mum.asd.framework.gui.CommonForm.AccountFrm;
import org.mum.asd.framework.mediator.Mediator;

public class AppInitiator {

    private static AccountFrm accForm = null;
    private static AccountManager accManager = null;
    private static Mediator mediator = null;

//    static {
//        accForm = new AccountFrm();
//        accManager = new AccountManager(getMediator());
//        mediator = new Mediator();
//
//    }

    public static AccountFrm getAccForm() {
		if(accForm == null){
            accForm = new AccountFrm();
        }
        return accForm;
    }

    public static void setAccForm(AccountFrm accF) {
        accForm = accF;
    }

    public static AccountManager getAccManger() {
        if (accManager == null) {
            accManager = new AccountManager(getMediator());
        }

        return accManager;
    }

    public static void setAccManger(AccountManager accManger) {
        AppInitiator.accManager = accManger;
    }

    public static Mediator getMediator() {
        if (mediator == null) {
            mediator = new Mediator();
        }
        return mediator;
    }

    public static void setMediator(Mediator mediator) {
        AppInitiator.mediator = mediator;
    }

}
