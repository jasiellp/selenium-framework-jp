package com.variavel;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class VariavelExtencaoLayout {


	
	public void parte1(GroupLayout gl_contentPane,	  GroupLayout gl_panel,
			  GroupLayout gl_painel1,
			  GroupLayout gl_painel2,
			  GroupLayout gl_painel3,
			  JPanel panel,
			  JPanel painel1,
			  JPanel painel2,
			  JPanel painel3,
			  JButton botaoAddNovoArquivo,
			  JButton boraoAddLinha,
			  JButton botaoSalvar,
			  JButton botaoEditar,
			  JButton botaoDeletarLinha,
			  JButton botaoSair,JScrollPane scrollPaneTabelaIndice,JScrollPane scrollPaneTabelaVariavel
	){
		
		
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap())
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 594, Short.MAX_VALUE)
						.addContainerGap())
			);
			 
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(painel3, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(painel1, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
							.addComponent(painel2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
						.addContainerGap())
			);
			
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(painel2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(painel3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(painel1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(21, Short.MAX_VALUE))
			);
			
		
			
		
			
			gl_painel3.setHorizontalGroup(
				gl_painel3.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_painel3.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_painel3.createParallelGroup(Alignment.LEADING)
							.addComponent(scrollPaneTabelaVariavel, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
							.addGroup(gl_painel3.createSequentialGroup()
								.addComponent(boraoAddLinha, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addGap(29)
								.addComponent(botaoDeletarLinha, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addGap(35)
								.addComponent(botaoSalvar, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap())
			);
			
			gl_painel3.setVerticalGroup(
				gl_painel3.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_painel3.createSequentialGroup()
						.addGap(12)
						.addComponent(scrollPaneTabelaVariavel, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
						.addGap(18)
						.addGroup(gl_painel3.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_painel3.createParallelGroup(Alignment.BASELINE)
								.addComponent(boraoAddLinha, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(botaoDeletarLinha, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
							.addComponent(botaoSalvar, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
			);
			
			 
		    gl_painel1.setHorizontalGroup(
		    	gl_painel1.createParallelGroup(Alignment.LEADING)
		    		.addGroup(Alignment.TRAILING, gl_painel1.createSequentialGroup()
		    			.addContainerGap(31, Short.MAX_VALUE)
		    			.addComponent(botaoSair, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
		    			.addGap(28))
		    );
		    gl_painel1.setVerticalGroup(
		    	gl_painel1.createParallelGroup(Alignment.LEADING)
		    		.addGroup(gl_painel1.createSequentialGroup()
		    			.addComponent(botaoSair, GroupLayout.PREFERRED_SIZE, 54, Short.MAX_VALUE)
		    			.addGap(1))
		    );
			
		   
		    gl_painel2.setHorizontalGroup(
		    	gl_painel2.createParallelGroup(Alignment.LEADING)
		    		.addGroup(gl_painel2.createSequentialGroup()
		    			.addGap(34)
		    			.addGroup(gl_painel2.createParallelGroup(Alignment.TRAILING, false)
		    				.addComponent(botaoEditar, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
		    				.addComponent(botaoAddNovoArquivo, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 58, Short.MAX_VALUE))
		    			.addGap(24))
		    		.addGroup(gl_painel2.createSequentialGroup()
		    			.addContainerGap()
		    			.addComponent(scrollPaneTabelaIndice, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
		    			.addContainerGap())
		    );
		    gl_painel2.setVerticalGroup(
		    	gl_painel2.createParallelGroup(Alignment.TRAILING)
		    		.addGroup(gl_painel2.createSequentialGroup()
		    			.addContainerGap()
		    			.addComponent(scrollPaneTabelaIndice, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
		    			.addGap(18)
		    			.addComponent(botaoEditar, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
		    			.addGap(18)
		    			.addComponent(botaoAddNovoArquivo, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
		    			.addContainerGap())
		    );
			

	}
	
}
