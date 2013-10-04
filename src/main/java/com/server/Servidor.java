package com.server;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.core.Main;
import com.util.EditaTabela;

public class Servidor extends JDialog {

	 
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static JTextField text_nome;
	private Main main = new Main();
	private JButton cancelButton;
	private static JButton btnExcluir;
	private JButton btnNewButton; 
	private static Servidor dialog;
	private JPanel panel_1;
	private JPanel panel;
	private GroupLayout gl_panel;
	private GroupLayout gl_panel_1; 
	private JPanel panel_2;
	private GroupLayout gl_contentPanel;
	private GroupLayout gl_panel_2;
	@SuppressWarnings("unused")
	private Object[] selectionValues; 
	private EditaTabela edTabela = new EditaTabela(); 
	private String[] list_j =  edTabela.getTab("properties\\value\\Server\\", "Server.deb", 0);
	private String[] IP =  edTabela.getTab("properties\\value\\Server\\", "Server.deb", 1);
	private final String CAMINHO = "properties\\value\\Server\\";
	private final String  ARQUIVO = "Server.deb";
	private DefaultListModel model;
	private DefaultListModel model_2;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	
	
	public static void main(String[] args) {
		try {
			
			dialog = new Servidor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setTitle("EDITOR");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	private final String ICONE = "properties\\ico\\";
 
	
	
	public Servidor() throws IOException {
	
		this.setResizable(false);
		this.setModal(true);
		this.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		this.setBounds(100, 100, 331, 370);
		this.getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().add(this.contentPanel, BorderLayout.CENTER);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		text_nome = new JTextField();
		text_nome.setColumns(10);
		 
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		{
			cancelButton = new JButton("");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				dispose(); 
				}
			});
			cancelButton.setBackground(Color.WHITE);
			cancelButton.setForeground(UIManager.getColor("Button.disabledShadow"));
			cancelButton.setIcon(new ImageIcon(Servidor.class.getResource("/com/image/sair.png")));
			cancelButton.setActionCommand("Cancel");
		}
		
	    btnExcluir = new JButton("");
	    btnExcluir.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		
	    	}
	    });
		btnExcluir.setIcon(new ImageIcon(Servidor.class.getResource("/com/image/lixeira.png")));
		
	    btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				try {
					edTabela.alt(CAMINHO,ARQUIVO,text_nome.getText() ,textField.getText(),"1");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(Servidor.class.getResource("/com/image/ok.png")));
	    gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(59)
					.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 43, Short.MAX_VALUE)
						.addComponent(cancelButton, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 43, Short.MAX_VALUE)
						.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 43, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_2, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 292, Short.MAX_VALUE))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		 comboBox = new JComboBox(list_j);
		 comboBox.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		
		 		
		 		if(!comboBox.getSelectedItem().toString().endsWith("Novo")){
		 		text_nome.setText(comboBox.getSelectedItem().toString());
		 		textField.setText(IP[comboBox.getSelectedIndex()]);//IP
		 		}
		 	}
		 });
		
		JLabel lblServidores = new JLabel("Servidores: ");
		
		lblNewLabel = new JLabel("");
		gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addComponent(lblServidores)
							.addGap(18)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
							.addGap(53))))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblServidores))
					.addGap(18)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		model = new DefaultListModel();
		model_2 = new DefaultListModel();
		
		for(int i = 0; i < list_j.length ; i++)
		model_2.addElement(list_j[i]);
		 
		
/*		if (main.getVetor() != null) {

			for (int i = 0; i < main.getVetor().length; i++) {
				model.addElement(main.getVetor()[i]);
				model_2.removeElement(main.getVetor()[i]);
			}
		}*/
		
		JLabel lblNomeDoServidor = new JLabel("Nome do Servidor:");
		
		JLabel lblIp = new JLabel("IP:");
		
		textField = new JTextField();
		textField.setColumns(10);
		gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNomeDoServidor)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(text_nome, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
							.addGap(8))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(lblIp)
							.addGap(18)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeDoServidor)
						.addComponent(text_nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIp)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addGap(29))
		);
		panel_1.setLayout(gl_panel_1);
		contentPanel.setLayout(gl_contentPanel);
	}
	
 
}