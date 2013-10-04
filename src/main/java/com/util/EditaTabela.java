package com.util;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.core.panel.Editor;
import com.inter.ISelenium;

public class EditaTabela extends ISelenium {

	private  DefaultTableModel model;
	private  Editor editor;
	
	
	public  DefaultTableModel setValorTabela(String caminho,String id, final boolean editable) {
 	
		model = new DefaultTableModel(new Object [][] {},    
			     new String [] {"COMANDO","ALVO","VALOR"}){
			     
					@SuppressWarnings("unused")
					boolean[] canEdit = new boolean []{
			             false, false
			         };    
			      
					   public boolean isCellEditable(int r, int c) {
					        return editable;
					 }


			            public static final long serialVersionUID = 1L;

			 
			            public Class<?> getColumnClass(int column) {
			                switch (column) {
			                    case 0:
			                        return String.class;
			                    case 1:
			                        return String.class;
			                   
			                    default:
			                        return String.class;
			                }
			            }  
			         
			 };
	 
		
		File dir = new File(caminho);
		File arq = new File(dir, "User_" + id + ".deb");

		try {
			if (arq.exists()) {
				BufferedReader bufferedReader = new BufferedReader(
						new FileReader(arq));

				String linha = "";

				while ((linha = bufferedReader.readLine()) != null) {
					String dias[] = linha.split(Pattern.quote(SEPARADOR));
					model.addRow(dias);
				}

				bufferedReader.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		

		return model;

	}
	
 
	public  String[] getTab(String caminho,String arquivo,int coluna) throws IOException {
  
		String[] vet = null;
		File dir = new File(caminho);
		File arq = new File(dir,  arquivo);
		if(arq.exists()){
		ArrayList<String> lista = new ArrayList<String>();
		  
				BufferedReader bufferedReader = new BufferedReader(new FileReader(arq));

				String linha = "";

				while ((linha = bufferedReader.readLine()) != null) {
					String dias[] = linha.split(Pattern.quote(SEPARADOR));
					lista.add(dias[coluna]);
				} 
				bufferedReader.close();
				
				vet = new String[lista.size()];
		 
				for(int i = 0; i < lista.size(); i++)
				vet[i]=lista.get(i);
				 
				return vet;
		}else{
			return  new String[]{""};
		} 

	}
	
	public  ArrayList<String> getElemento(String caminho,String arquivo,int coluna, String elemento) throws IOException {
	
		ArrayList<String> vet = new ArrayList<String> ();
		File dir = new File(caminho);
		File arq = new File(dir,  arquivo);
		if(arq.exists()){ 
		  
				BufferedReader bufferedReader = new BufferedReader(new FileReader(arq));

				String linha = "";

				while ((linha = bufferedReader.readLine()) != null) {
					String dias[] = linha.split(Pattern.quote(SEPARADOR));
					if(dias[coluna].equals(elemento)){
						 
					for(int i = 0; i < dias.length; i++)
						vet.add(dias[i]);
					
					break;
					}
					
				} 
				bufferedReader.close();
				  
				return vet;
		}else{
			return  new ArrayList<String>();
		} 
	}
	
	
	public  ArrayList<String>[] getAlvo(String caminho,String arquivo,int coluna,String caminho2,int coluna2) throws IOException {
		  
		ArrayList[] vet = null;
		File dir = new File(caminho);
		File arq = new File(dir,  arquivo);
		if(arq.exists()){
		ArrayList<String> lista = new ArrayList<String>();
		  
				BufferedReader bufferedReader = new BufferedReader(new FileReader(arq));

				String linha = "";

				while ((linha = bufferedReader.readLine()) != null) {
					String dias[] = linha.split(Pattern.quote(SEPARADOR));
					lista.add(dias[coluna]);
				} 
				bufferedReader.close();
				
				vet = new ArrayList[lista.size()];
		 
				for(int i = 0; i < lista.size(); i++){
				  
				String dias[] = lista.get(i).split(Pattern.quote("-->"));
				vet[i]=getElemento(caminho2, "User_"+dias[0]+".deb", coluna2, dias[1]);
				 
				}
				return vet;
		}else{
			return  new ArrayList[]{};
		} 

	}
	
	@SuppressWarnings("serial")
	public  DefaultTableModel setValorTabelaVariavel(String caminho, String id, final boolean editable, int coluna) {
	 
		//coluna++;
		String [] s = new String[coluna];
		s[0] = "NOME VARIAVEL";
		
		for(int i = 1; i < s.length ; i++)
			s[i] = "VARIAVEL";
		
		
		model = new DefaultTableModel(new Object [][] {},s){
			     
					@SuppressWarnings("unused")
					boolean[] canEdit = new boolean []{
			             false, false
			         };    
			      
					   public boolean isCellEditable(int r, int c) {
					        return editable;
					 }
			         
		};
	 
		
		File dir = new File(caminho);
		File arq = new File(dir, "User_" + id + ".deb");

		try {
			if (arq.exists()) {
				BufferedReader bufferedReader = new BufferedReader(
						new FileReader(arq));

				String linha = "";

				while ((linha = bufferedReader.readLine()) != null) {
					String dias[] = linha.split(Pattern.quote(SEPARADOR));
					model.addRow(dias);
				}

				bufferedReader.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return model;

	}
	  
	@SuppressWarnings("serial")
	public  DefaultTableModel indiceBoolean() {

		model = new DefaultTableModel(   
	     new Object [][] { },    
	     new String [] {"STATUS","SWITCH","ID"}){
	   
	        @SuppressWarnings("unused")
			boolean[] canEdit = new boolean []{
	             false, false
	         };    
	      
	         @Override  
	         public boolean isCellEditable(int rowIndex, int columnIndex) {
	             return (columnIndex == 0);  
	         }  
	         
			@Override
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Boolean.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				}
				return null;
			}
	 };
		 

		File dir = new File("properties\\value\\");
		File arq = new File(dir, "Idate.deb");

		try {
			if (arq.exists()) {
				BufferedReader bufferedReader = new BufferedReader(
						new FileReader(arq));

				String linha = "";

				while ((linha = bufferedReader.readLine()) != null) {

					model.addRow(new Object[] {
							false,
							linha.split(Pattern.quote(SEPARADOR))[0],linha.split(Pattern.quote(SEPARADOR))[1] });
				}

				bufferedReader.close();
			} else
				new FileWriter(arq, true);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return model;

	}
	 
	@SuppressWarnings("serial")
	public  DefaultTableModel indice(String arquivo) {

		model = new DefaultTableModel(
	     new Object [][] { },    
	     new String [] {"SWITCH", "ID","NUM"}){
	   
	         boolean[] canEdit = new boolean []{    
	             false, false, false, false, false
	         };    
	      
	         @Override    
	         public boolean isCellEditable(int rowIndex, int columnIndex) {    
	             return canEdit [columnIndex];    
	         }  
	 };
		  
		 
		File arq = new File(arquivo);

		try {
			if (arq.exists()) {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(arq));

				String linha = "";

				while ((linha = bufferedReader.readLine()) != null) {

					model.addRow(linha.split(Pattern.quote(SEPARADOR)));
				}

				bufferedReader.close();
			} else
				new FileWriter(arq, true);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return model;

	}

	public  void alterar(String caminho,String arquivo,String id, String nome,String NumCol,String list) throws IOException {
 
		
		this.editor = new Editor();
		File arq = new File(new File(caminho), arquivo);
		StringBuffer novo = new StringBuffer();
		try {
			if (arq.exists()) {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(arq));
				

				String linha = "";
				String linha1 = "";
				boolean test = true;
				
				
				ArrayList<String> lista = new ArrayList<String>();

				while ((linha = bufferedReader.readLine()) != null){
					lista.add(linha);
				if(linha.split(Pattern.quote(SEPARADOR))[0].equals(nome))
					test = false;
				}
				bufferedReader.close();
				  
				
	           if(test){
	        	   PrintWriter printWriter = new PrintWriter(new FileWriter(arq, false));
	            for (int i = 0; i < lista.size(); i++) {
	            	
					linha1 = lista.get(i);
				  	
					if (linha1.split(Pattern.quote(SEPARADOR))[1].equals(id)){
						novo.append(nome).append(SEPARADOR).append(id).append(SEPARADOR).append(list).append("\n");
						 
						printWriter.print(novo.toString());
						  
						if(new File(caminho+"User_"+linha1.split(Pattern.quote(SEPARADOR))[0]+".deb").exists()){
							copyFile(new File(caminho+"User_"+linha1.split(Pattern.quote(SEPARADOR))[0]+".deb"), new File(caminho+"User_"+nome+".deb"));
						}
						
					} else
						printWriter.print(linha1+"\n");
				}

				 printWriter.flush();
		         printWriter.close();
		         editor.setMensagemLabel(2,nome+" Alterado Com sucesso");	
	           }
	           else{
	        	   editor.setMensagemLabel(1,"Nome "+nome+" Já existe !!!");	
	           }
				
			} else
				new FileWriter(arq, true).close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public  void alt(String caminho,String arquivo,String id, String nome,String NumCol) throws IOException {
		this.editor = new Editor();
		File arq = new File(new File(caminho), arquivo);
		StringBuffer novo = new StringBuffer();
		try {
			if (arq.exists()) {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(arq));
				

				String linha = "";
				String linha1 = "";
				boolean test = true;
				
				
				ArrayList<String> lista = new ArrayList<String>();

				while ((linha = bufferedReader.readLine()) != null){
					lista.add(linha);
				if(linha.split(Pattern.quote(SEPARADOR))[0].equals(nome))
					test = false;
				}
				bufferedReader.close();
				  
				
	           if(test){
	        	   PrintWriter printWriter = new PrintWriter(new FileWriter(arq, false));
	            for (int i = 0; i < lista.size(); i++) {
	            	
					linha1 = lista.get(i);
				  	
					if (linha1.split(Pattern.quote(SEPARADOR))[1].equals(id)){
						novo.append(nome).append(SEPARADOR).append(id).append(SEPARADOR).append(NumCol).append("\n");
						 
						printWriter.print(novo.toString());
						  
						if(new File(caminho+"User_"+linha1.split(Pattern.quote(SEPARADOR))[0]+".deb").exists()){
							copyFile(new File(caminho+"User_"+linha1.split(Pattern.quote(SEPARADOR))[0]+".deb"), new File(caminho+"User_"+nome+".deb"));
						}
						
					} else
						printWriter.print(linha1+"\n");
				}

				 printWriter.flush();
		         printWriter.close();
		         editor.setMensagemLabel(2,nome+" Alterado Com sucesso");	
	           }
	           else{
	        		editor.setMensagemLabel(1,"Nome "+nome+" Já existe !!!");	
	           }
				
			} else
				new FileWriter(arq, true).close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public  void alterara(String caminho,String arquivo,String id, String nome,String NumCol,String list) throws IOException {
		this.editor = new Editor();
		File arq = new File(new File(caminho), arquivo);
		StringBuffer novo = new StringBuffer();
		try {
			 System.out.println("list -->> "+list);
			if (arq.exists()) {
				
				BufferedReader bufferedReader = new BufferedReader(new FileReader(arq));
				

				String linha = "";
				String linha1 = "";
			 
				
				
				ArrayList<String> lista = new ArrayList<String>();

				while ((linha = bufferedReader.readLine()) != null){
					lista.add(linha); 
				}
				bufferedReader.close();
			 	 
				
				PrintWriter printWriter = new PrintWriter(new FileWriter(arq, false));
	            
				for (int i = 0; i < lista.size(); i++) {
	            	
					linha1 = lista.get(i);
				  	System.out.println(linha1.split(Pattern.quote(SEPARADOR))[i]+" NOME->"+nome);
				  	
					if (linha1.split(Pattern.quote(SEPARADOR))[i].equals(nome)){
						novo.append(nome).append(SEPARADOR).append(id).append(SEPARADOR).append(list).append("\n");
						System.out.println("Aqui "+novo.toString());
						printWriter.print(novo.toString());
												
					} else
						printWriter.print(linha1+"\n");
				}

				 printWriter.flush();
		         printWriter.close();
		         editor.setMensagemLabel(2,nome+" Alterado Com sucesso");	
	           
				
			} else
				new FileWriter(arq, true).close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
    public  void copyFile(File source, File destination) throws IOException {
      

        FileChannel sourceChannel = null;
        FileChannel destinationChannel = null;

        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destinationChannel = new FileOutputStream(destination).getChannel();
            sourceChannel.transferTo(0, sourceChannel.size(),destinationChannel);
    
        } finally {
            if (sourceChannel != null && sourceChannel.isOpen())
                sourceChannel.close();
            if (destinationChannel != null && destinationChannel.isOpen())
                destinationChannel.close();
            source.delete();
       }
   }

	public  boolean existe(String nome,String caminho, String arquivo) throws IOException {

		File arq = new File(new File(caminho), arquivo);
		BufferedReader bufferedReader = new BufferedReader(new FileReader(arq));

		String linha = "";

		boolean test = true;

		while ((linha = bufferedReader.readLine()) != null) {

			if (linha.split(Pattern.quote(SEPARADOR))[0].equals(nome))
				test = false;
		}
		bufferedReader.close();

		return test;
	}
    
	public  void deleta(String caminho,String arquivo, String id, String nome, String caminho2,String arquivo2) {

		File arq = new File(new File(caminho), arquivo);
		StringBuffer novo = new StringBuffer();
		try {
			if (arq.exists()) {
				if(caminho2 == null && arquivo2 == null){
					BufferedReader bufferedReader = new BufferedReader(new FileReader(arq));

					String linha = "";
					String linha1 = "";

					 
					ArrayList<String> lista = new ArrayList<String>();

					while ((linha = bufferedReader.readLine()) != null)
							lista.add(linha);

					bufferedReader.close();

					PrintWriter printWriter = new PrintWriter(new FileWriter(arq,false));
					
					for (int i = 0; i < lista.size(); i++) {

						linha1 = lista.get(i);

						if (linha1.split(Pattern.quote(SEPARADOR))[1].equals(id)) {
	  
							if (new File(caminho+"User_"
									+ linha1.split(Pattern.quote(SEPARADOR))[0]
									+ ".deb").exists())
								new File(caminho+"User_"
										+ linha1.split(Pattern.quote(SEPARADOR))[0]
										+ ".deb").delete();

						} else
							printWriter.print(linha1 + "\n");

						 
						novo.delete(0, novo.length());
					}

					printWriter.flush();
					printWriter.close();
					 
				}else{
					BufferedReader buff = new BufferedReader(new FileReader(new File(new File(caminho2), arquivo2)));
					
					String linh = "";
					ArrayList<String> li = new ArrayList<String>();

					while ((linh = buff.readLine()) != null){
							li.add(linh.replace(nome+"|||", "k1k1k1|||"));
					}
					buff.close();
					
					PrintWriter pw = new PrintWriter(new FileWriter(new File(new File(caminho2), arquivo2)),false);
					for (int i = 0; i < li.size(); i++) 
						pw.print(li.get(i) + "\n");
					
					pw.flush();
					pw.close();
					
					BufferedReader bufferedReader = new BufferedReader(new FileReader(arq));

					String linha = "";
					String linha1 = "";

					 
					ArrayList<String> lista = new ArrayList<String>();

					while ((linha = bufferedReader.readLine()) != null)
							lista.add(linha);

					bufferedReader.close();

					PrintWriter printWriter = new PrintWriter(new FileWriter(arq,false));
					
					for (int i = 0; i < lista.size(); i++) {

						linha1 = lista.get(i);

						if (linha1.split(Pattern.quote(SEPARADOR))[1].equals(id)) {
	  
							if (new File(caminho+"User_"
									+ linha1.split(Pattern.quote(SEPARADOR))[0]
									+ ".deb").exists())
								new File(caminho+"User_"
										+ linha1.split(Pattern.quote(SEPARADOR))[0]
										+ ".deb").delete();

						} else
							printWriter.print(linha1 + "\n");

						 
						novo.delete(0, novo.length());
					}

					printWriter.flush();
					printWriter.close();
				}

			} else
				new FileWriter(arq, true);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public  void setCombo( TableColumn sportColumn, Object[] vet) {

		final JComboBox comboBox = new JComboBox(vet);

		sportColumn.setCellEditor(new DefaultCellEditor(comboBox));

		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setToolTipText("Click for combo box");
		sportColumn.setCellRenderer(renderer);
		comboBox.addItemListener(new ItemListener() {
		        public void itemStateChanged(ItemEvent arg0) {
		            System.out.println("comboBox--> "+comboBox.getSelectedItem());
		             
		        }
		    });
		
	}

	public  void setComboAr(TableColumn sportColumn, ArrayList<String[]> ss,ArrayList<String> s) {
		ArrayList<String> aa = new ArrayList<String>();
		 
		aa.add("");
		for (int i = 0; i < ss.size(); i++){
			
			for (int j = 0; j < ss.get(i).length; j++){
				aa.add(s.get(i)+"-->"+ss.get(i)[j]);
			}
		}
		
		
		final JComboBox comboBox = new JComboBox(aa.toArray());

		sportColumn.setCellEditor(new DefaultCellEditor(comboBox));

		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setToolTipText("Click for combo box");
		sportColumn.setCellRenderer(renderer);
		comboBox.addItemListener(new ItemListener() {
		        public void itemStateChanged(ItemEvent arg0) {
		            System.out.println("comboBox--> "+comboBox.getSelectedItem());
		             
		        }
		    });
		
	}
	
	public  void ocultaColuna(JTable tablej, int coluna) {
			tablej.getColumnModel().getColumn(coluna).setMinWidth(0);
			tablej.getColumnModel().getColumn(coluna).setPreferredWidth(0);
			tablej.getColumnModel().getColumn(coluna).setMaxWidth(0);
		}

}