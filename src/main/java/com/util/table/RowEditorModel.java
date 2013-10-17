package com.util.table;

 import javax.swing.table.*;

import java.util.*;

 
 public class RowEditorModel
 {
      private Hashtable<Integer, TableCellEditor> data;
      public RowEditorModel()
      {
          data = new Hashtable<Integer, TableCellEditor>();
      }
     public void addEditorForRow(int row, TableCellEditor e )
     {
         data.put(new Integer(row), e);
     }
     public void removeEditorForRow(int row)
     {
         data.remove(new Integer(row));
     }
     public TableCellEditor getEditor(int row)
     {
         return (TableCellEditor)data.get(new Integer(row));
     }
 }