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
	
	private Main main = new Main();
	
	private JButton botaoCancelar;
	private JButton botaoExcluir;
	private JButton botaoOk;
	private JButton botaoRemove; 
	private JButton botaoAdd;
	
	private JLabel legenda1;
	private JLabel leganda2;
	private JTextField campoNome;
	
	private String ARQUIVO;
	private String CAMINHO;
	private String ARQUIVO2;
	private String CAMINHO2;
	private String NUMCOL;
	
	private static Editor dialog;
	
	private JPanel contentPane = new JPanel();
	private JPanel painel;
	private JPanel painel1;
	private JPanel painel_2;
	
	private GroupLayout gl_painel;
	private GroupLayout gl_painel1;
	private GroupLayout gl_painel_2;
	private GroupLayout gl_contentpainel;
	
	private JList<String> lista;
	private JList<String> lista1; 
	
	private JScrollPane scrollPaneLista;
	private JScrollPane scrollPaneLista1;
	
	private EditorExtencaoLayout extencao;
	
	private String valor = NULO;
	
	private EditaTabela edTabela = new EditaTabela();

	private String[] AlimentaLista =  edTabela.getTab(propriedades.leitor("arquivovariavel"), propriedades.leitor("arquivoivariaveis"), 0 );
	private String[] vetor;
	private Object[] indice;
	
	private int evento;
	
	private DefaultListModel<String> modelo;
	private DefaultListModel<String> modelo1;
	
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
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().add(this.contentPane, BorderLayout.CENTER);
		
		
		campoNome = new JTextField();
		painel = new JPanel();
		painel1 = new JPanel();
		painel_2 = new JPanel();
		leganda2 = new JLabel(NULO);
		legenda1 = new JLabel();
		botaoExcluir = new JButton(new ImageIcon(propriedades.leitor("iconelixeira")));
		botaoCancelar = new JButton(new ImageIcon(propriedades.leitor("iconesair")));
		botaoOk = new JButton(new ImageIcon(propriedades.leitor("iconeok")));
		botaoAdd = new JButton(new ImageIcon(propriedades.leitor("iconenext")));
		botaoRemove = new JButton(new ImageIcon(propriedades.leitor("iconeback")));
		painel1.setBorder(new TitledBorder(null, NULO, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		campoNome.setColumns(10);
		
		painel.setBorder(new TitledBorder(null, NULO, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		{ 
			
			botaoCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				dispose();
				main.setNome(null);
				}
			});
			botaoCancelar.setBackground(Color.WHITE);
			
		}
		
	    
	    botaoExcluir.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		setMensagemLabel(0,NULO);	
	    		edTabela.deleta(CAMINHO,ARQUIVO,legenda1.getText().replace(ID_TYPE, NULO),campoNome.getText(),CAMINHO2,ARQUIVO2 );
	    		dispose();
	    	}
	    });
	
	     
	   
	    botaoOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try {
					 
					setLista(modelo);
			 
					if(campoNome.getText().trim().equals(NULO))
			 		{
						setMensagemLabel(1,propriedades.leitor("msg04"));
			 		}
					else
					{
							if(getEvento() == 10)
							{
								edTabela.criar(CAMINHO, ARQUIVO, campoNome.getText(), getLista());
								dispose();
							}
					
							if(getEvento() == 1)
							{
					    
									if(igualNome(campoNome.getText()))
									{
										edTabela.alterar(CAMINHO,ARQUIVO,legenda1.getText().replace(ID_TYPE, NULO),campoNome.getText(),NUMCOL, getLista());
										main.setNome(campoNome.getText()); 
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
					 
					if(campoNome.getText() == null || campoNome.getText().trim().equals(NULO))
						setMensagemLabel(1,"Digite o Nome");
					else 
					{
						main.setNome(campoNome.getText()); 
						selectionValues = list.getSelectedValues();
					 	dispose();
					}
					
					
				}else{
					
					setMensagemLabel(0,NULO);
					
					setLista(model);
				
					if(nomeVlr.equals(campoNome.getText()))
					    
					
					else
					{
						if(Variaveis.getEvento() == 2)
								edTabela.alt(CAMINHO,ARQUIVO,lblNewLabel.getText().replace("ID : ", NULO),campoNome.getText(),NUMCOL);
							
						else 
								edTabela.alterar(CAMINHO,ARQUIVO,lblNewLabel.getText().replace("ID : ", NULO),campoNome.getText(),NUMCOL,getLista());
							 
					}
				}*/
				
				} catch (IOException e) {
					 e.printStackTrace();
				}finally{
					vetor = null;
				}
			}
		});
	 
	  
		
		gl_painel = this.extencao.parte1(botaoOk, botaoExcluir, botaoCancelar, painel); 
		
		painel.setLayout(gl_painel);
				
		painel_2.setBorder(new TitledBorder(null, NULO, TitledBorder.LEADING, TitledBorder.TOP, null, null));

		gl_contentpainel =  extencao.parte2(contentPane, painel1, painel_2);
		
		gl_painel_2 =  extencao.parte3(painel_2, legenda1, leganda2);
		
		painel_2.setLayout(gl_painel_2);
		
		modelo = new DefaultListModel<String>();
		
		modelo1 = new DefaultListModel<String>();
		
		for(int i = 0; i < AlimentaLista.length ; i++)
			modelo1.addElement(AlimentaLista[i]);
		  
	
		for(int y = 0; y < modelo.size() ; y++)
		{
			for(int j = 0; j < AlimentaLista.length ; j++)
			{
				 
				if(modelo.get(y).equals(AlimentaLista[j]))
					modelo.remove(y);
			}
		}
		
		
		lista = new JList<String>(modelo1);
		
		scrollPaneLista = new JScrollPane(lista);
		
		lista1 = new JList<String>(modelo);
		
		scrollPaneLista1 = new JScrollPane(lista1);
		 
	
		botaoAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelo.addElement(lista.getSelectedValue());
				modelo1.removeElement(lista.getSelectedValue());
			 
			}
		});
		
		
	   
		botaoRemove.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		modelo1.addElement(lista1.getSelectedValue());
	    		modelo.removeElement(lista1.getSelectedValue());
	    	}
	    });
	    
	 

	
		gl_painel1 = extencao.parte4(painel1, painel, scrollPaneLista, scrollPaneLista1, botaoAdd, botaoRemove, campoNome);
		
		painel1.setLayout(gl_painel1);
		contentPane.setLayout(gl_contentpainel);
	}
	
	public void setMensagemLabel(int tipo,String mensagem){
		
		if(tipo == 1)
			this.leganda2.setForeground(Color.RED);
		if(tipo == 0)
			this.leganda2.setForeground(Color.BLACK);
		if(tipo == 2)
			this.leganda2.setForeground(Color.GREEN);
		
		this.leganda2.setText(mensagem);
		
	}

	public void setID(String id){
		this.legenda1.setText(ID_TYPE+id);
	}
	
	public void setNome(String nome){
		this.campoNome.setText(nome);
	 }
	
	public void setCaminho(String caminho){
		this.CAMINHO = caminho;
	}
	 
	public void setArquivo(String arquivo){
		this.ARQUIVO = arquivo;
	}
	
	public void setCaminho2(String caminho){
		this.CAMINHO2 = caminho;
	}
	
	public void setArquivo2(String arquivo){
		this.ARQUIVO2 = arquivo;
	}
	
	public void setNumCol(String numCol){
		this.NUMCOL = numCol;
	}

	public void setVisivel(boolean numCol){
		this.botaoExcluir.setVisible(numCol);
	}
	
	public void setVisivelList(boolean numCol){
		this.scrollPaneLista.setVisible(numCol);
		this.scrollPaneLista1.setVisible(numCol);
		this.botaoRemove.setVisible(numCol);
		this.botaoAdd.setVisible(numCol);
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
				this.valor = this.valor+jp.get(i)+SEPARE0;
		}
		return jp.size();
	}
	
	public String getLista(){
		return valor;
	}
	
	public String getNome(){
		return campoNome.getName();
	}
	
	public void setVetor(String nome) throws IOException {

		String stg = nome.replace(SEPARE1, NULO);
		
		if (stg.split(Pattern.quote(SEPARE0)).length > 0){
			this.vetor = stg.split(Pattern.quote(SEPARE0));
		
			if(getVetor() != null){
				
				for(int i = 0; i < getVetor().length ; i++){
					modelo.addElement(getVetor()[i]);
					modelo1.removeElement(getVetor()[i]);
				
				}
			}
		}else
			this.vetor = null;

		
	
	}
	
	public void setlistas(){
		  
		for(int i = 0; i < AlimentaLista.length ; i++)
			modelo1.addElement(AlimentaLista[i]);
		
		
		for(int j = 0; j < modelo.size() ; j++)
			modelo1.removeElement(modelo.get(j));
		
	}
	
	public String[] getVetor() {
		return this.vetor ;
	}
	
}