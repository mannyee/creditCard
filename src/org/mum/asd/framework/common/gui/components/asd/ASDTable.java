/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mum.asd.framework.common.gui.components.asd;

import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author xtrememe
 */
public class ASDTable extends JTable {

    public ASDTable(TableModel dm) {
        super(dm);
        setModel(dm);
    }

}
