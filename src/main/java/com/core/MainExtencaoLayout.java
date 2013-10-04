package com.core;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainExtencaoLayout {
	
	
	private GroupLayout gl_contentPane ;
	private GroupLayout gl_panel;
	private GroupLayout gl_panel_1;
	private GroupLayout gl_panel_2;
	private GroupLayout gl_panel_3;
	 
	
	public GroupLayout parte1(JPanel contentPane, JPanel panel){
		
		this.gl_contentPane = new GroupLayout(contentPane);
		this.gl_contentPane.setHorizontalGroup(
				this.gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(this.gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		this.gl_contentPane.setVerticalGroup(
				this.gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(this.gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 594, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		return gl_contentPane;
	}
	
	public GroupLayout part2(JPanel panel, JPanel panel_1, JPanel panel_2, JPanel panel_3){
		
		  this.gl_panel = new GroupLayout(panel);
		    this.gl_panel.setHorizontalGroup(
		    		this.gl_panel.createParallelGroup(Alignment.TRAILING)
					.addGroup(this.gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(this.gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(panel_1, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
							.addComponent(panel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
						.addContainerGap())
			);
		    this.gl_panel.setVerticalGroup(
		    		this.gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(this.gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(this.gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(21, Short.MAX_VALUE))
			);
		    return this.gl_panel;
	}
 
	public GroupLayout parte3(JPanel panel_1, JButton btnSair){
		
		this.gl_panel_1 = new GroupLayout(panel_1);
		this.gl_panel_1.setHorizontalGroup(
				this.gl_panel_1.createParallelGroup(Alignment.LEADING)
	    		.addGroup(Alignment.TRAILING, this.gl_panel_1.createSequentialGroup()
	    			.addContainerGap(31, Short.MAX_VALUE)
	    			.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
	    			.addGap(28))
	    );
		this.gl_panel_1.setVerticalGroup(
				this.gl_panel_1.createParallelGroup(Alignment.LEADING)
	    		.addGroup(this.gl_panel_1.createSequentialGroup()
	    			.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 54, Short.MAX_VALUE)
	    			.addGap(1))
	    );
		return this.gl_panel_1 ;		
	}

	public GroupLayout parte4(JPanel panel_3, JScrollPane scrollPane_1, JButton btnAdd_1, JButton btnDelete_1, JButton btnRenomear){
		
		this.gl_panel_3 = new GroupLayout(panel_3);
		this.gl_panel_3.setHorizontalGroup(
				this.gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(this.gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(this.gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
						.addGroup(this.gl_panel_3.createSequentialGroup()
							.addComponent(btnAdd_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(btnDelete_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(btnRenomear, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		this.gl_panel_3.setVerticalGroup(
				this.gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, this.gl_panel_3.createSequentialGroup()
					.addGap(12)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(this.gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(this.gl_panel_3.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnAdd_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnDelete_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnRenomear, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		return this.gl_panel_3;
	}
	
	public GroupLayout parte5(JPanel panel_2, JScrollPane scrollPane, JButton btnAdd, JButton btnDelete, JButton btnRenomear){
		this.gl_panel_2 = new GroupLayout( panel_2);
		this.gl_panel_2.setHorizontalGroup(
				this.gl_panel_2.createParallelGroup(Alignment.LEADING)
	    		.addGroup(this.gl_panel_2.createSequentialGroup()
	    			.addGap(34)
	    			.addGroup(this.gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
	    				.addComponent(btnDelete, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
	    				.addComponent(btnAdd, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 58, Short.MAX_VALUE))
	    			.addGap(24))
	    		.addGroup(this.gl_panel_2.createSequentialGroup()
	    			.addContainerGap()
	    			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
	    			.addContainerGap())
	    );
		this.gl_panel_2.setVerticalGroup(
				this.gl_panel_2.createParallelGroup(Alignment.TRAILING)
	    		.addGroup(this.gl_panel_2.createSequentialGroup()
	    			.addContainerGap()
	    			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
	    			.addGap(18)
	    			.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
	    			.addGap(18)
	    			.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
	    			.addContainerGap())
	    );
		return this.gl_panel_2;
	}

}
