/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mum.asd.framework.gui.components.ext;

import org.mum.asd.framework.common.gui.components.asd.ASDEntryDataModel;
import org.mum.asd.framework.mediator.Mediator;



/**
 *
 * @author sudell
 */
public class AccountEntryDataModel extends ASDEntryDataModel{

    private static final String NAME = "ACCOUNT_ENTRY_ROW";
    private Mediator mediator;

    public AccountEntryDataModel(Mediator mediator) {
        this.mediator = mediator;
    }

}
