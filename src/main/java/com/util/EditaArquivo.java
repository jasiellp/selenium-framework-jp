package com.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.swing.JTable;

import com.inter.IFrame;
import com.inter.ISelenium;


public class EditaArquivo extends ISelenium implements IFrame{
	
	 private BufferedWriter writer;
	
	 private File file; 
	 
	
	 public void Grava(String path, JTable table) throws IOException 
	 {
	  
        this.file = new File(path);
        this.writer = new BufferedWriter(new FileWriter(file));
		
		StringBuffer stb = new StringBuffer();
	
		for(int i = 0; i < table.getModel().getRowCount();  i++ )
		{
			stb.append(table.getModel().getValueAt(i, 0));
			stb.append(SEPARADOR).append(i);
			stb.append(SEPARADOR).append(table.getModel().getValueAt(i, 2)).append(N);
			this.writer.write(stb.toString());
			stb.delete(0, stb.length());
		}
		
		this.writer.close();
		 
	}
	 
	 public void getID(String path,String id, String novoNome){
		 
		   
		    try {
		    
		    		Renomear(TABELA, novoNome);
		    			
		    		this.file = new File(path);
		    		
		    		StringBuffer stb = new StringBuffer();
			
		    		BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

		        
		    		String linha = NULO;
		  
		        while ((linha = bufferedReader.readLine() ) != null) 
		        {
		        	String dias[] = linha.split(Pattern.quote(SEPARADOR)); 
		         
		        	if(dias[1].equals(id))
		        	{ 
		        	stb.append(novoNome);
					stb.append(SEPARADOR).append(id).append(N);
					
		        	}else
		        	{
		        		stb.append(dias[0]);
						stb.append(SEPARADOR).append(dias[1]).append(N);
		        	}
		        }
		        
		    	this.writer = new BufferedWriter(new FileWriter(file));
		    	this.writer.write(stb.toString());
		    	this.writer.close();
		        bufferedReader.close();
		        
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
			 
	 }

	 public void Renomear(String path, String NovoNome) throws IOException {

		File[] f = new File(path).listFiles();

		for (int i = 0; i < f.length; i++) 
		{
			String jp = f[i].toString();
			 
			 
			if (jp.replace(path, NULO).equals(INIT_ARQUIVO + NovoNome + EXTENCAO))
			      f[i].renameTo(new File(path,INIT_ARQUIVO + NovoNome + EXTENCAO));
		    
		}

	}
	 
	 public void NovoArquio(String path, JTable table, int colunas) throws IOException {
		   
			this.writer = new BufferedWriter(new FileWriter( new File(path)));
			
			StringBuffer stb = new StringBuffer();
		
			for(int i = 0; i < table.getModel().getRowCount();  i++ )
			{
				for(int j = 0; j < colunas;  j++)
					  stb.append(table.getModel().getValueAt(i, j)).append(SEPARADOR);
					 
				 
				this.writer.write(stb.toString().substring(0, stb.toString().length()-3)+N);
				stb.delete(0, stb.length());
			}
			
			this.writer.close();
			 
		}

	 
}