package com.util;


import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
   

public class RendererCelula extends DefaultTableCellRenderer {  
    

	private static final long serialVersionUID = 820340524596810581L;

	private Map<Point, Color> _cores = new HashMap<Point, Color>();  
  
    private Point _tempCel = new Point(0, 0);  
  
    private Color _defaultBG;  
  
    public RendererCelula() {  
        this._defaultBG = getBackground();  
    }  
  
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,  
        boolean hasFocus, int row, int column) {  
  
        Component c = super.getTableCellRendererComponent(  
            table,  
            value,  
            isSelected,  
            hasFocus,  
            row,  
            column);  
  
        this._tempCel.x = row;  
        this._tempCel.y = column;  
        if (this._cores.containsKey(this._tempCel)) {  
            c.setBackground(this._cores.get(this._tempCel));  
        } else {  
            c.setBackground(this._defaultBG);  
        }  
  
        return c;  
    }  
   
	public void colorirCelula(int row, int col, Color cor) {  
        this._cores.put(new Point(row, col), cor);  
    }  
  
      
}
