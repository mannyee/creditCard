package org.mum.asd.framework.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface BaseController extends ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae);
}
