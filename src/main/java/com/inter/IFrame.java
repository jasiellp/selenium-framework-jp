package com.inter;

import com.util.propriedades.Propriedades;

public interface IFrame {

	 
	public final String ARQUIVO = "config";
	
	public final String COMANDOS = "comandos";
	
	public Propriedades propriedades = new Propriedades (ARQUIVO);
	
	public final String ID_TYPE = "ID : ";
	
	public final String EXTENCAO = propriedades.leitor("extencao");	
	
	public final String INIT_ARQUIVO =  propriedades.leitor("init_arquivo");
	
	public final String SEPARE0 = propriedades.leitor("separe000");
	
	public final String SEPARE1 =  propriedades.leitor("separe001");
	
	public final String SEPARE2 = propriedades.leitor("separe002");
	
	public final String ARQUIVO_VARIAVEL = propriedades.leitor("arquivoivariaveis");
	
	public final String CAMINHO_VARIAVEL = propriedades.leitor("caminhovariavel");
	
	public final String VARIAVEL = propriedades.leitor("variavel");
	
	public final String ARQUIVOVARIAVEL = propriedades.leitor("arquivovariavel");
	
	
	
	public final String ARQUIVO_INDICE = propriedades.leitor("arquivoindice");
	
	public final String INDICE = propriedades.leitor("indice");
	
	public final String TABELA =  propriedades.leitor("tela");
	
	public final String N = "\n";
	
	public final String NULO = "";
	
	public final String ERRO = "Erro";
	
	public final String TEARDOWN = "tearDown";
	
	public final String COMANDO = "COMANDO";
	
	public final String ALVO = "ALVO"; 
			
	public final String VALOR = "VALOR";
	
	public final String VARIAVEL1 = "VARIAVEL";
	
	public final String STATUS = "STATUS";
	
	public final String SWITCH = "SWITCH";
	
	public final String ID = "ID";
	
	public final String NUM = "NUM";
}
