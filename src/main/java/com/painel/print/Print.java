package com.painel.print;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class Print extends JDialog {

 
	private static final long serialVersionUID = -9008047926869982552L;
	private final JPanel contentPanel = new JPanel();
	private static Print dialog;
	private JButton cancelButton;
	private JPanel buttonPane;
	private GroupLayout gl_contentPanel;
	private JLabel lblNewLabel ;
	
	public static void main(String[] args) {
		try {
		    dialog = new Print();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setImagem(Image image){
		
		ImageIcon img = new ImageIcon(image);
		img.setImage(img.getImage().getScaledInstance(675, 527, 100));
		lblNewLabel.setIcon(img);
	}
	
	public Print() {
		this.setResizable(false);
		this.setModal(true);
		this.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		this.setBounds(100, 100, 675, 527);
		this.getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().add(this.contentPanel, BorderLayout.CENTER);
		
		lblNewLabel = new JLabel();
		gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		 
	    this.cancelButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		dispose();
	    	}
	    });
		
	}
}
