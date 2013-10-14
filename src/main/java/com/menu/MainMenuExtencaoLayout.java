package com.menu;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

public class MainMenuExtencaoLayout {

	
	
	
	private GroupLayout groupLayout;
	private GroupLayout gl_paniel;
	private GroupLayout gl_painel1;
	
	public GroupLayout parte1(JFrame frame, JPanel painel){
		
		groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(painel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(painel, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
					.addContainerGap())
		);
		return groupLayout;
	}
	
	
	public GroupLayout parte2(JPanel painel,JPanel painel1){
	
	gl_paniel = new GroupLayout(painel);
	gl_paniel.setHorizontalGroup(
		gl_paniel.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_paniel.createSequentialGroup()
				.addContainerGap()
				.addComponent(painel1, GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
				.addContainerGap())
	);
	gl_paniel.setVerticalGroup(
		gl_paniel.createParallelGroup(Alignment.TRAILING)
			.addGroup(Alignment.LEADING, gl_paniel.createSequentialGroup()
				.addContainerGap()
				.addComponent(painel1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(254, Short.MAX_VALUE))
	);
	return gl_paniel;

}
	
	
	public GroupLayout parte3(JFrame frame,JPanel painel1,JPanel painel, JButton botaoCriaCenario,JButton botaoExecCenario,JButton botaoCriaVariaveis,JButton botaoSair){
		
	{
		
		
	    gl_painel1 = new GroupLayout(painel1);
		gl_painel1.setHorizontalGroup(
			gl_painel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel1.createSequentialGroup()
					.addGap(28)
					.addComponent(botaoCriaCenario, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(botaoExecCenario, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(botaoCriaVariaveis, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(botaoSair)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		gl_painel1.setVerticalGroup(
			gl_painel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_painel1.createParallelGroup(Alignment.LEADING)
						.addComponent(botaoCriaCenario, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addComponent(botaoExecCenario)
						.addComponent(botaoCriaVariaveis, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addComponent(botaoSair , GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		painel1.setLayout(gl_painel1);
		painel.setLayout(gl_paniel);
		frame.getContentPane().setLayout(groupLayout);
		
		return gl_painel1;
	}
	
	
	}
}
