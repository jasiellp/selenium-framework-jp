package com.core.panel;

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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.core.Main;
import com.util.EditaArquivo;
import com.util.EditaTabela;
import com.variavel.Variaveis;

public class Editor extends JDialog {

	 
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static JTextField textField;

	private JButton cancelButton;
	private static JButton btnExcluir;
	private JButton btnNewButton;
	private JButton  button_1; 
	private static JLabel lblNewLabel;
	private static JLabel lblNewLabel_1;
	private static String ARQUIVO;
	private static String CAMINHO;
	private static String ARQUIVO2;
	private static String CAMINHO2;
	private static String NUMCOL;
	private JButton button;
	private static Editor dialog;
	private JPanel panel_1;
	private JPanel panel;
	private GroupLayout gl_panel;
	private GroupLayout gl_panel_1; 
	private JPanel panel_2;
	private GroupLayout gl_contentPanel;
	private GroupLayout gl_panel_2;
	private JList list;
	private JList list_1; 
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	@SuppressWarnings("unused")
	private Object[] selectionValues;
	private String vlor = "";
	private static String nomeVlr = "";
	private EditaTabela edTabela = new EditaTabela();
	private EditaArquivo edArquivo = new EditaArquivo();
	private String[] list_j =  edTabela.getTab("properties\\value\\Variavel\\", "IVariavel.deb", 0 );
	
	private DefaultListModel model;
	private DefaultListModel model_2;
	
	public static void main(String[] args) {
		try {
			
			dialog = new Editor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setTitle("EDITOR");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	private final String ICONE = "properties\\ico\\";
 
	
	
	public Editor() throws IOException {
	
		this.setResizable(false);
		this.setModal(true);
		this.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		this.setBounds(100, 100, 331, 370);
		this.getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().add(this.contentPanel, BorderLayout.CENTER);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		textField = new JTextField();
		textField.setColumns(10);
		 
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		{
			cancelButton = new JButton("");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				dispose();
				Main.setNome(null);
				}
			});
			cancelButton.setBackground(Color.WHITE);
			cancelButton.setForeground(UIManager.getColor("Button.disabledShadow"));
			cancelButton.setIcon(new ImageIcon(Editor.class.getResource("/com/image/sair.png")));
			cancelButton.setActionCommand("Cancel");
		}
		
	    btnExcluir = new JButton("");
	    btnExcluir.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		setMensagemLabel(0,"");	
	    		edTabela.deleta(CAMINHO,ARQUIVO,lblNewLabel.getText().replace("ID : ", ""),textField.getText(),CAMINHO2,ARQUIVO2 );
	    		dispose();
	    	}
	    });
		btnExcluir.setIcon(new ImageIcon(Editor.class.getResource("/com/image/lixeira.png")));
		
	    btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if(Main.getEvento() == 1){
					
					if(setLista(model) == 0)
						setMensagemLabel(1,"Selecione um Item");
					else{ 
					if(textField.getText() == null || textField.getText().trim().equals(""))
						setMensagemLabel(1,"Digite o Nome");
					else{
					
						Main.setNome(textField.getText()); 
						selectionValues = list.getSelectedValues();
					 	dispose();
					}  }
				}else{
					setMensagemLabel(0,"");
					setLista(model);
				
					if(nomeVlr.equals(textField.getText())){
						edTabela.alterara(CAMINHO,ARQUIVO,lblNewLabel.getText().replace("ID : ", ""),textField.getText(),NUMCOL,getLista());
					}else{
						if(Variaveis.getEvento() == 2)
							edTabela.alt(CAMINHO,ARQUIVO,lblNewLabel.getText().replace("ID : ", ""),textField.getText(),NUMCOL);
						else
							edTabela.alterar(CAMINHO,ARQUIVO,lblNewLabel.getText().replace("ID : ", ""),textField.getText(),NUMCOL,getLista());
					}
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(Editor.class.getResource("/com/image/ok.png")));
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
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		lblNewLabel_1 = new JLabel("");
		
		lblNewLabel = new JLabel();
		gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(71, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		model = new DefaultListModel();
		model_2 = new DefaultListModel();
		
		for(int i = 0; i < list_j.length ; i++)
		model_2.addElement(list_j[i]);
		 
		
		if(Main.getVetor() != null){
			System.out.println(Main.getVetor().length);	
			for(int i = 0; i < Main.getVetor().length ; i++){
			model.addElement(Main.getVetor()[i]);
			model_2.removeElement(Main.getVetor()[i]);
			}
		}
		
		
		list = new JList(model_2);
		scrollPane = new JScrollPane(list);
		list_1 = new JList(model);
		scrollPane_1 = new JScrollPane(list_1);
		
		
		
		button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.addElement(list.getSelectedValue());
				model_2.removeElement(list.getSelectedValue());
			 
			}
		});
		button.setIcon(new ImageIcon(Editor.class.getResource("/com/image/next.png")));
		
	    button_1 = new JButton("");
	    button_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		model_2.addElement(list_1.getSelectedValue());
				model.removeElement(list_1.getSelectedValue());
	    	}
	    });
	    
		button_1.setIcon(new ImageIcon(Editor.class.getResource("/com/image/back.png")));
		gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
										.addComponent(button, 0, 0, Short.MAX_VALUE)
										.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)))
					.addGap(6))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		contentPanel.setLayout(gl_contentPanel);
	}
	
	public static void setMensagemLabel(int tipo,String mensagem){
		
		if(tipo == 1)
		lblNewLabel_1.setForeground(Color.RED);
		if(tipo == 0)
		lblNewLabel_1.setForeground(Color.BLACK);
		if(tipo == 2)
			lblNewLabel_1.setForeground(Color.GREEN);
		
		lblNewLabel_1.setText(mensagem);
		
	}


	public static void setID(String id){
		lblNewLabel.setText( "ID : "+id);
	}
	
	public static void setNome(String nome){
		textField.setText(nome);
		nomeVlr=nome;
	}
	
	public static void setCaminho(String caminho){
		CAMINHO = caminho;
	}
	
	public static void setArquivo(String arquivo){
		ARQUIVO = arquivo;
	}
	
	public static void setCaminho2(String caminho){
		CAMINHO2 = caminho;
	}
	
	public static void setArquivo2(String arquivo){
		ARQUIVO2 = arquivo;
	}
	
	public static void setNumCol(String numCol){
		NUMCOL = numCol;
	}

	public  void setVisivel(boolean numCol){
		btnExcluir.setVisible(numCol);
	}
	public  void setVisivelList(boolean numCol){
		scrollPane.setVisible(numCol);
		scrollPane_1.setVisible(numCol);
		button_1.setVisible(numCol);
		button.setVisible(numCol);
	}
 
	
	public int setLista(DefaultListModel jp){ 
	 
	 
		for(int i = 0; i < jp.size() ; i++)
			vlor = vlor+jp.get(i)+"|||";
		 
		return jp.size();
	}
	
	
	public String getLista(){
		return vlor;
	}
	
	public String getNome(){
		return textField.getName();
	}
	
	
}