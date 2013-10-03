package com.util;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
import javax.swing.JTable;

public class ItemCabecalho implements ItemListener {

	private JTable table;
	private boolean checked;
	private Object source;
	
	public ItemCabecalho(JTable table) {
		this.table = table;
	}

	public void itemStateChanged(ItemEvent e) {

		this.source = e.getSource();
		
		if (this.source instanceof AbstractButton == false)
			return;
		
		this.checked = e.getStateChange() == ItemEvent.SELECTED;
		
		for (int x = 0, y = this.table.getRowCount(); x < y; x++) 
			this.table.setValueAt(new Boolean(this.checked), x, 0);

		
	}
}