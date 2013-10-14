package com.inter;

import com.util.propriedades.Propriedades;

public class ICombo implements IFrame {
 
	
	private Propriedades propriedades = new Propriedades (COMANDOS);
	
	public  String[] Combo = new String[]{
			propriedades.leitor("Selec"),
			propriedades.leitor("AbraLink"),
			propriedades.leitor("aguard"),
			propriedades.leitor("print"),
			propriedades.leitor("clique"),
			propriedades.leitor("digite"),
			propriedades.leitor("sair"),
			propriedades.leitor("textoP")
			
	};
}
