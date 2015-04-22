/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mum.asd.framework.gui.components.ext;


import javax.swing.table.TableModel;
import org.mum.asd.framework.AccountManager.AccountManager;
import org.mum.asd.framework.common.gui.components.asd.ASDTable;
import org.mum.asd.framework.main.AppInitiator;
import org.mum.asd.framework.mediator.IReceiverColleague;
import org.mum.asd.framework.mediator.Message;

/**
 *
 * @author xtrememe
 */
public class AccountListTable extends ASDTable implements IReceiverColleague{

    private static final String NAME = "ACCOUNT_LIST_TABLE";

    public AccountListTable(TableModel dm) {
        super(dm);
    }

    @Override
    public void receive(Message message) {
        if (message.getAbout().equalsIgnoreCase(Message.UPDATE_ACCOUNT_TABLE)) {
            AppInitiator.getAccForm().loadTableWithData();
        }
    }


}
