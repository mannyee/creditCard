/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mum.asd.framework.mediator;

import java.util.ArrayList;
import java.util.List;
import org.mum.asd.framework.mediator.IColleague;
import org.mum.asd.framework.mediator.IMediator;

/**
 *
 * @author xtrememe
 */
public class Mediator implements IMediator {

    public List<IColleague> colleagueList;

    public Mediator() {
        colleagueList = new ArrayList<IColleague>();
    }

    @Override
    public void addColleague(IColleague colleague) {
        if(!colleagueList.contains(colleague))
        colleagueList.add(colleague);
    }

    @Override
    public void send( Message message) {
    	
        for (IColleague c : colleagueList) {
            if (c != colleagueList) {
                if (c instanceof IReceiverColleague) {
                     ((IReceiverColleague) c).receive(message);
                }
            }
        }
    }
}
