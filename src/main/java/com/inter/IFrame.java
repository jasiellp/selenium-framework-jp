package com.inter;

import com.util.propriedades.Propriedades;

public interface IFrame {

	 
	public final String ARQUIVO = "config";
	
	public Propriedades propriedades = new Propriedades (ARQUIVO);
	
	public final String EXTENCAO = propriedades.leitor("extencao");	
	
	public final String INIT_ARQUIVO =  propriedades.leitor("init_arquivo");
	
	public final String SEPARE0  =  propriedades.leitor("separe000");
	
	public final String SEPARE1  =  propriedades.leitor("separe001");
	
	public final String VARIAVEL = propriedades.leitor("variavel");		
	
	public final String INDICE =  propriedades.leitor("indice");	
	
	public final String TABELA =  propriedades.leitor("tela");	
	
	public final String NULO = "";
	
}
