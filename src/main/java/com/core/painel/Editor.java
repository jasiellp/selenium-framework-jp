package com.core.painel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.core.Main;
import com.inter.IFrame;
import com.util.EditaTabela;

public class Editor extends JDialog implements IFrame  {

	 
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private Main main = new Main();
	private JButton cancelButton;
	private JButton btnExcluir;
	private JButton btnNewButton;
	private JButton  button_1; 
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private String ARQUIVO;
	private String CAMINHO;
	private String ARQUIVO2;
	private String CAMINHO2;
	private String NUMCOL;
	private JButton button2;
	private static Editor dialog;
	private JPanel panel_1;
	private JPanel panel;
	private GroupLayout gl_panel;
	private GroupLayout gl_panel_1; 
	private JPanel panel_2;
	private GroupLayout gl_contentPanel;
	private GroupLayout gl_panel_2;
	private JList<String> list;
	private JList<String> list_1; 
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private EditorExtencaoLayout extencao;
	
	private String vlor = NULO;
	
	private EditaTabela edTabela = new EditaTabela();

	private String[] list_j =  edTabela.getTab(propriedades.leitor("arquivovariavel"), propriedades.leitor("arquivoivariaveis"), 0 );
	private int evento;
	private String[] vtor;
	private Object[] indice;
	
	private DefaultListModel<String> model;
	private DefaultListModel<String> model_2;
	
	public static void main(String[] args) {
		try {
			
			dialog = new Editor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 	
	
	public Editor() throws IOException {
		
		this.extencao = new EditorExtencaoLayout();
		this.setResizable(false);
		this.setModal(true);
		this.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		this.setBounds(100, 100, 331, 370);
		this.getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().add(this.contentPanel, BorderLayout.CENTER);
		
		
		textField = new JTextField();
		panel = new JPanel();
		panel_1 = new JPanel();
		panel_2 = new JPanel();
		lblNewLabel_1 = new JLabel(NULO);
		lblNewLabel = new JLabel();
		btnExcluir = new JButton(new ImageIcon(propriedades.leitor("iconelixeira")));
		cancelButton = new JButton(new ImageIcon(propriedades.leitor("iconesair")));
		btnNewButton = new JButton(new ImageIcon(propriedades.leitor("iconeok")));
		button2 = new JButton(new ImageIcon(propriedades.leitor("iconenext")));
	    button_1 = new JButton(new ImageIcon(propriedades.leitor("iconeback")));
		panel_1.setBorder(new TitledBorder(null, NULO, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		textField.setColumns(10);
		
		panel.setBorder(new TitledBorder(null, NULO, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		{ 
			
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				dispose();
				main.setNome(null);
				}
			});
			cancelButton.setBackground(Color.WHITE);
			
		}
		
	    
	    btnExcluir.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		setMensagemLabel(0,NULO);	
	    		edTabela.deleta(CAMINHO,ARQUIVO,lblNewLabel.getText().replace(ID_TYPE, NULO),textField.getText(),CAMINHO2,ARQUIVO2 );
	    		dispose();
	    	}
	    });
	
	     
	   
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try {
					 
					setLista(model);
			 
					if(textField.getText().trim().equals(NULO))
			 		{
						setMensagemLabel(1,propriedades.leitor("msg04"));
			 		}
					else
					{
							if(getEvento() == 10)
							{
								edTabela.criar(CAMINHO, ARQUIVO, textField.getText(), getLista());
								dispose();
							}
					
							if(getEvento() == 1)
							{
					    
									if(igualNome(textField.getText()))
									{
										edTabela.alterar(CAMINHO,ARQUIVO,lblNewLabel.getText().replace(ID_TYPE, NULO),textField.getText(),NUMCOL, getLista());
										main.setNome(textField.getText()); 
										dispose();
					
									}
									else
										setMensagemLabel(1,propriedades.leitor("msg03"));
									
							}
					} 
				 
				/*
				if(getEvento() == 1){
					
					if(setLista(model) == 0)
					 	setMensagemLabel(1,"Selecione um Item");
					 
					if(textField.getText() == null || textField.getText().trim().equals(NULO))
						setMensagemLabel(1,"Digite o Nome");
					else 
					{
						main.setNome(textField.getText()); 
						selectionValues = list.getSelectedValues();
					 	dispose();
					}
					
					
				}else{
					
					setMensagemLabel(0,NULO);
					
					setLista(model);
				
					if(nomeVlr.equals(textField.getText()))
					    
					
					else
					{
						if(Variaveis.getEvento() == 2)
								edTabela.alt(CAMINHO,ARQUIVO,lblNewLabel.getText().replace("ID : ", NULO),textField.getText(),NUMCOL);
							
						else 
								edTabela.alterar(CAMINHO,ARQUIVO,lblNewLabel.getText().replace("ID : ", NULO),textField.getText(),NUMCOL,getLista());
							 
					}
				}*/
				
				} catch (IOException e) {
					 e.printStackTrace();
				}finally{
					vtor = null;
				}
			}
		});
	 
	  
		
		gl_panel = this.extencao.parte1(btnNewButton, btnExcluir, cancelButton, panel); 
		
		panel.setLayout(gl_panel);
		
		panel_2.setBorder(new TitledBorder(null, NULO, TitledBorder.LEADING, TitledBorder.TOP, null, null));

		gl_contentPanel =  extencao.parte2(contentPanel, panel_1, panel_2);
		
		gl_panel_2 =  extencao.parte3(panel_2, lblNewLabel, lblNewLabel_1);
		
		panel_2.setLayout(gl_panel_2);
		
		model = new DefaultListModel<String>();
		
		model_2 = new DefaultListModel<String>();
		
		for(int i = 0; i < list_j.length ; i++)
			model_2.addElement(list_j[i]);
		  
	
		for(int y = 0; y < model.size() ; y++)
		{
			for(int j = 0; j < list_j.length ; j++)
			{
				System.out.println("Modelo "+list_j[j]);
				if(model.get(y).equals(list_j[j]))
					model.remove(y);
			}
		}
		
		
		list = new JList<String>(model_2);
		
		scrollPane = new JScrollPane(list);
		
		list_1 = new JList<String>(model);
		
		scrollPane_1 = new JScrollPane(list_1);
		 
	
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.addElement(list.getSelectedValue());
				model_2.removeElement(list.getSelectedValue());
			 
			}
		});
		
		
	   
	    button_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		model_2.addElement(list_1.getSelectedValue());
				model.removeElement(list_1.getSelectedValue());
	    	}
	    });
	    
	 

	
		gl_panel_1 = extencao.parte4(panel_1, panel, scrollPane, scrollPane_1, button2, button_1, textField);
		
		panel_1.setLayout(gl_panel_1);
		contentPanel.setLayout(gl_contentPanel);
	}
	
	public void setMensagemLabel(int tipo,String mensagem){
		
		if(tipo == 1)
			this.lblNewLabel_1.setForeground(Color.RED);
		if(tipo == 0)
			this.lblNewLabel_1.setForeground(Color.BLACK);
		if(tipo == 2)
			this.lblNewLabel_1.setForeground(Color.GREEN);
		
		this.lblNewLabel_1.setText(mensagem);
		
	}


	public void setID(String id){
		this.lblNewLabel.setText(ID_TYPE+id);
	}
	
	public void setNome(String nome){
		this.textField.setText(nome);
	 }
	
	public   void setCaminho(String caminho){
		this.CAMINHO = caminho;
	}
	
	public   void setArquivo(String arquivo){
		this.ARQUIVO = arquivo;
	}
	
	public   void setCaminho2(String caminho){
		this.CAMINHO2 = caminho;
	}
	
	public   void setArquivo2(String arquivo){
		this.ARQUIVO2 = arquivo;
	}
	
	public   void setNumCol(String numCol){
		this.NUMCOL = numCol;
	}

	public  void setVisivel(boolean numCol){
		this.btnExcluir.setVisible(numCol);
	}
	public  void setVisivelList(boolean numCol){
		this.scrollPane.setVisible(numCol);
		this.scrollPane_1.setVisible(numCol);
		this.button_1.setVisible(numCol);
		this.button2.setVisible(numCol);
	}
 
	public void setEvento(int evento){
		this.evento = evento;
	}
	
	
	public void setIgualNome(Object[] indice){
		this.indice = indice;
	}

	public boolean igualNome(String nome) {
		boolean status = true;
		
		for (int i = 0; i < indice.length; i++) {
		
			if (indice[i].toString().equals(nome)) {
				status = false;
				break;
			}

		}
		return status;

	}
	
	public int getEvento(){
	 	return this.evento;
	}
	
	public int setLista(DefaultListModel<?> jp){ 
	  
		for(int i = 0; i < jp.size() ; i++)
		{
			if(!jp.get(i).toString().trim().equals(NULO))
				this.vlor = this.vlor+jp.get(i)+SEPARE0;
		}
		return jp.size();
	}
	
	
	public String getLista(){
		return vlor;
	}
	
	public String getNome(){
		return textField.getName();
	}
	
	
	public void setVetor(String nome) throws IOException {

		String stg = nome.replace(SEPARE1, NULO);
		
		if (stg.split(Pattern.quote(SEPARE0)).length > 0){
			this.vtor = stg.split(Pattern.quote(SEPARE0));
		
			if(getVetor() != null){
				
				for(int i = 0; i < getVetor().length ; i++){
					model.addElement(getVetor()[i]);
					model_2.removeElement(getVetor()[i]);
				
				}
			}
		}else
			this.vtor = null;

		
	
	}
	
	public void setlistas(){
		  
		for(int i = 0; i < list_j.length ; i++)
			model_2.addElement(list_j[i]);
		
		
		for(int j = 0; j < model.size() ; j++)
			model_2.removeElement(model.get(j));
		
	}
	
	public String[] getVetor() {
		return this.vtor ;
	}
	
}