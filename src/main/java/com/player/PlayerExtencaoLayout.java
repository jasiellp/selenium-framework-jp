package com.player;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PlayerExtencaoLayout {
	
	
	private GroupLayout gl_contentpainel ;
	private GroupLayout gl_painel3;
	private GroupLayout gl_painel2;
	private GroupLayout gl_painel1;
	private GroupLayout gl_painel;
	private GroupLayout gl_painel4; 
	 
	
	public GroupLayout parte1(JPanel contentpainel, JPanel painel){
		
		this.gl_contentpainel = new GroupLayout(contentpainel);
		this.gl_contentpainel.setHorizontalGroup(this.gl_contentpainel
				.createParallelGroup(Alignment.LEADING).addGroup(
						this.gl_contentpainel
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(painel,
										GroupLayout.DEFAULT_SIZE, 698,
										Short.MAX_VALUE).addContainerGap()));
		this.gl_contentpainel.setVerticalGroup(this.gl_contentpainel
				.createParallelGroup(Alignment.LEADING).addGroup(
						Alignment.TRAILING,
						gl_contentpainel
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(painel,
										GroupLayout.DEFAULT_SIZE, 581,
										Short.MAX_VALUE).addContainerGap()));
		return gl_contentpainel;
	}
	 
	public GroupLayout parte2(JPanel painel3,JButton botaoSair){
		
		this.gl_painel3 = new GroupLayout(painel3);
		this.gl_painel3.setHorizontalGroup(this.gl_painel3.createParallelGroup(
				Alignment.TRAILING).addGroup(
				this.gl_painel3
						.createSequentialGroup()
						.addContainerGap(43, Short.MAX_VALUE)
						.addComponent(botaoSair, GroupLayout.PREFERRED_SIZE,
								73, GroupLayout.PREFERRED_SIZE).addGap(27)));
		this.gl_painel3.setVerticalGroup(this.gl_painel3.createParallelGroup(
				Alignment.LEADING).addGroup(
				this.gl_painel3
						.createSequentialGroup()
						.addComponent(botaoSair, GroupLayout.PREFERRED_SIZE,
								54, Short.MAX_VALUE).addGap(1)));
		painel3.setLayout(this.gl_painel3);

		    return this.gl_painel3;
	}
  
	public GroupLayout parte3(JPanel painel, JPanel painel4,JPanel painel1, JPanel painel2,JPanel painel3){
		
		this.gl_painel = new GroupLayout(painel);
		this.gl_painel
				.setHorizontalGroup(this.gl_painel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								this.gl_painel
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												this.gl_painel
														.createParallelGroup(
																Alignment.LEADING,
																false)
														.addComponent(
																painel4,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																painel1,
																GroupLayout.DEFAULT_SIZE,
																501,
																Short.MAX_VALUE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												this.gl_painel
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																painel3,
																GroupLayout.DEFAULT_SIZE,
																155,
																Short.MAX_VALUE)
														.addComponent(
																painel2,
																GroupLayout.DEFAULT_SIZE,
																155,
																Short.MAX_VALUE))
										.addContainerGap()));
		this.gl_painel
				.setVerticalGroup(this.gl_painel
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								this.gl_painel
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												this.gl_painel
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																painel1,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																460,
																Short.MAX_VALUE)
														.addComponent(
																painel2,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																460,
																Short.MAX_VALUE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												this.gl_painel
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																painel4,
																GroupLayout.DEFAULT_SIZE,
																80,
																Short.MAX_VALUE)
														.addComponent(
																painel3,
																Alignment.LEADING,
																GroupLayout.PREFERRED_SIZE,
																80,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
		return this.gl_painel ;		
	}

	public GroupLayout parte4(JPanel painel4, JButton botaoPlay, JButton botaoPause, JButton botaoStop, JButton botaoAvancar, JButton botaoPrint, JButton botaoLimpar ){
		this.gl_painel4 = new GroupLayout(painel4);
		gl_painel4.setHorizontalGroup(gl_painel4.createParallelGroup(
				Alignment.TRAILING).addGroup(
				gl_painel4
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(botaoPlay, GroupLayout.PREFERRED_SIZE, 60,
								GroupLayout.PREFERRED_SIZE)
						.addGap(37)
						.addComponent(botaoPause, GroupLayout.PREFERRED_SIZE, 60,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 37,
								Short.MAX_VALUE)
						.addComponent(botaoStop, GroupLayout.PREFERRED_SIZE, 60,
								GroupLayout.PREFERRED_SIZE)
						.addGap(33)
						.addComponent(botaoAvancar, GroupLayout.PREFERRED_SIZE, 60,
								GroupLayout.PREFERRED_SIZE)
						.addGap(72)
						.addComponent(botaoLimpar, GroupLayout.PREFERRED_SIZE, 60,
								GroupLayout.PREFERRED_SIZE)
						.addGap(66)
						.addComponent(botaoPrint, GroupLayout.PREFERRED_SIZE, 62,
								GroupLayout.PREFERRED_SIZE).addContainerGap()));
		gl_painel4
				.setVerticalGroup(gl_painel4
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_painel4
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_painel4
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																botaoPause,
																GroupLayout.PREFERRED_SIZE,
																58,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																botaoStop,
																GroupLayout.PREFERRED_SIZE,
																58,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																botaoAvancar,
																GroupLayout.PREFERRED_SIZE,
																58,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																botaoPrint,
																GroupLayout.PREFERRED_SIZE,
																50,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																botaoLimpar,
																GroupLayout.PREFERRED_SIZE,
																50,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																botaoPlay,
																GroupLayout.PREFERRED_SIZE,
																58,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
		
		
		return gl_painel4;
	}
	
	
	public GroupLayout parte5(JScrollPane scrollPaneTabelaItemteste, JPanel painel2){
		
		this.gl_painel2 = new GroupLayout(painel2);
		this.gl_painel2.setHorizontalGroup(this.gl_painel2.createParallelGroup(
				Alignment.LEADING).addGroup(
				this.gl_painel2
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPaneTabelaItemteste,
								GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
						.addContainerGap()));

		this.gl_painel2.setVerticalGroup(this.gl_painel2.createParallelGroup(
				Alignment.LEADING).addGroup(
				this.gl_painel2
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPaneTabelaItemteste,
								GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
						.addContainerGap()));
		return this.gl_painel2;

	}
 
	public GroupLayout parte6(JPanel painel1,JScrollPane scrollPaneTabelaIndice){

		this.gl_painel1 = new GroupLayout(painel1);
		this.gl_painel1.setHorizontalGroup(this.gl_painel1.createParallelGroup(
				Alignment.LEADING).addGroup(
				this.gl_painel1
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPaneTabelaIndice,
								GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
						.addContainerGap()));
		this.gl_painel1.setVerticalGroup(this.gl_painel1.createParallelGroup(
				Alignment.LEADING).addGroup(
				this.gl_painel1
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPaneTabelaIndice,
								GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
						.addContainerGap()));
		
		return this.gl_painel1;
	}
	 
}
