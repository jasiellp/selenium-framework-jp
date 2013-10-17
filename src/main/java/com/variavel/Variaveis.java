package com.variavel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import com.core.painel.Editor;
import com.inter.IFrame;
import com.util.EditaArquivo;
import com.util.EditaTabela;
import com.util.JPBotao;

public class Variaveis extends JDialog  implements IFrame{

	private  int evente = 0;
	
	private static final long serialVersionUID = 1L;
	private EditaTabela edTabela = new EditaTabela();
	private EditaArquivo edArquivo = new EditaArquivo();
	 
	 
 
 	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Variaveis frame = new Variaveis();
					frame.setVisible(true);
					frame.setTitle("FRAME");
					//frame.setResizable(false);
				 	frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} 

 
 	
 	private int id = -2;
 	
 	private JPanel contentPane;
 	private JPanel panel;
 	private JPanel painel1;
 	private JPanel painel2;
 	private JPanel painel3;
 	
	private JButton botaoAddNovoArquivo;
	private JButton boraoAddLinha;
	private JButton botaoSalvar;
	private JButton botaoEditar;
	private JButton botaoDeletarLinha;
	private JButton botaoSair;
	
	
	private GroupLayout gl_contentPane ;
	private GroupLayout gl_panel;
	private GroupLayout gl_painel1;
	private GroupLayout gl_painel2;
	private GroupLayout gl_painel3;
	
	private JTable tabelaIndice;
	private JTable tabelaVariavel;
	
	private DefaultTableModel modeloTabelaIndice;
	private DefaultTableModel modeloTabelaVariavel;
	
	private JScrollPane scrollPaneTabelaIndice;
	private JScrollPane scrollPaneTabelaVariavel;
	
	private VariavelExtencaoLayout extencao;
	
	
	public Variaveis() {
		
		setModal(true);
		setIconImage(new  ImageIcon(propriedades.leitor("iconeprincipal")).getImage());
		
		this.setBounds(100, 100, 745, 664);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		 
		this.panel = new JPanel();
		this.painel1 = new JPanel();
		this.painel2 = new JPanel();
		this.painel3 = new JPanel();
	 
		this.panel.setBorder(new TitledBorder(null, NULO, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.painel1.setBorder(new TitledBorder(null, NULO, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.painel2.setBorder(new TitledBorder(null, NULO, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.painel3.setBorder(new TitledBorder(null, NULO, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		
		this.botaoSair = new JPBotao(Color.WHITE, propriedades.leitor("iconesair"));
		this.botaoEditar = new JPBotao(Color.WHITE, propriedades.leitor("iconeeditar"));
		this.botaoDeletarLinha = new JPBotao(Color.WHITE, propriedades.leitor("iconelixeira"));
		this.botaoAddNovoArquivo = new JPBotao(Color.WHITE, propriedades.leitor("iconeadd"));
		this.boraoAddLinha = new JPBotao(Color.WHITE, propriedades.leitor("iconeadd"));
		this.botaoSalvar= new JPBotao(Color.WHITE, propriedades.leitor("iconesalve"));
	
		 
		this.modeloTabelaIndice = new DefaultTableModel(); 
		 
		this.tabelaVariavel = new JTable();
		this.tabelaVariavel.setRowHeight(20);
		this.modeloTabelaIndice = edTabela.indice(VARIAVEL);
		this.tabelaIndice = new JTable(modeloTabelaIndice); 
		
		this.edTabela.ocultaColuna(tabelaIndice,1);
		this.edTabela.ocultaColuna(tabelaIndice,2);
		this.scrollPaneTabelaVariavel = new JScrollPane(tabelaVariavel);
		
		this.tabelaIndice.setShowHorizontalLines(false);
		this.scrollPaneTabelaIndice = new JScrollPane(tabelaIndice);
		
		this.gl_contentPane = new GroupLayout(contentPane);
		this.gl_panel = new GroupLayout(panel);
		this.gl_painel1 = new GroupLayout(painel1);
		this.gl_painel2 = new GroupLayout(painel2);
		this.gl_painel3 = new GroupLayout(painel3);
		
		this.extencao = new VariavelExtencaoLayout();
		
		this.extencao.parte1(gl_contentPane, gl_panel, gl_painel1, gl_painel2,
				gl_painel3, panel, painel1, painel2, painel3,
				botaoAddNovoArquivo, boraoAddLinha, botaoSalvar, botaoEditar,
				botaoDeletarLinha, botaoSair, scrollPaneTabelaIndice,
				scrollPaneTabelaVariavel);
	    
		
		  
		
		    contentPane.setLayout(gl_contentPane);
		    panel.setLayout(gl_panel);
			painel1.setLayout(gl_painel1);
			painel2.setLayout(gl_painel2);
			painel3.setLayout(gl_painel3);
		 
			tabelaIndice.setDefaultEditor(Object.class, null);    
			tabelaIndice.addMouseListener(new MouseAdapter() {  
			    public void mouseClicked(MouseEvent e)  
			    {  
			        if (e.getClickCount() == 1 )  
			        {  

			        	  int coluna = Integer.parseInt(tabelaIndice.getModel().getValueAt(tabelaIndice.getSelectedRow(), 2).toString());
			        	  String id = tabelaIndice.getModel().getValueAt(tabelaIndice.getSelectedRow(), 0).toString();
			        	  modeloTabelaVariavel = edTabela.setValorTabelaVariavel(CAMINHO_VARIAVEL , id,true, coluna);
			              tabelaVariavel.setModel(modeloTabelaVariavel);
			    	      
			        }      
			    }  
			}); 
			
			botaoSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						
						id = tabelaIndice.getSelectedRow();
						
						if (id == -1) 
						{
							
							JOptionPane.showMessageDialog(new JFrame(),
								    "Não há Item para ser Salvo !!!",
								    "Erro",
								    JOptionPane.ERROR_MESSAGE);
						}
						else
						{
						 int coluna = Integer.parseInt(tabelaIndice.getModel().getValueAt(tabelaIndice.getSelectedRow(), 2).toString());
						 edArquivo.NovoArquio(CAMINHO_VARIAVEL  + INIT_ARQUIVO + tabelaIndice.getModel().getValueAt(tabelaIndice.getSelectedRow(), 0).toString()+ EXTENCAO, tabelaVariavel,coluna);

						JOptionPane.showMessageDialog(new JFrame(),
							    "Tabela Salva com Sucesso ...",
							    "Sucesso",
							    JOptionPane.INFORMATION_MESSAGE);
						}
						
						} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}
			});
			
		  
		botaoEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				id = tabelaIndice.getSelectedRow();
				if (id == -1) {
					
					JOptionPane.showMessageDialog(new JFrame(),
						    "Selecione um Item.",
						    propriedades.leitor("erro"),
						    JOptionPane.ERROR_MESSAGE);
				}
				else 
				{ 
				try {
					setEvento(2);
					Editor edt = new Editor();
					edt.setVisivelList(false);
					edt.setLocationRelativeTo(null);
					edt.setNumCol(tabelaIndice.getModel().getValueAt(tabelaIndice.getSelectedRow(), 2).toString());
					edt.setCaminho(CAMINHO_VARIAVEL );
					edt.setArquivo(ARQUIVO_VARIAVEL);
					edt.setCaminho2(TABELA);
					edt.setArquivo2(ARQUIVO_INDICE);
					edt.setID(getIDTabelas());
					edt.setNome(getNomeTabelas());
					edt.setTitle(propriedades.leitor("tmodal001"));
					edt.setVisible(true);
					modeloTabelaIndice = edTabela.indice(VARIAVEL);
					tabelaIndice.setModel(modeloTabelaIndice);
					edTabela.ocultaColuna(tabelaIndice, 1);
					edTabela.ocultaColuna(tabelaIndice, 2);
					
				} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}

		 
		});
 
		botaoAddNovoArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {  
						JTextField name = new JTextField();
		               
						JComboBox<String> vorname = new JComboBox<String>(
								new String[]{
		                		"1","2","3","4","5","6"});
		            
		                Object[] message = {"Digite o Nome: ", name, 
		                        "Digite o Numero de Colunas:", vorname};
		 
		                JOptionPane pane = new JOptionPane( message, 
		                                                JOptionPane.PLAIN_MESSAGE, 
		                                                JOptionPane.OK_CANCEL_OPTION);
		                pane.createDialog(null, "Cancela").setVisible(true);
		                
		                String nome = name.getText().trim();
		                
		                StringBuffer numeroColuna = new StringBuffer();
		                
		                numeroColuna.append(Integer.parseInt(vorname.getSelectedItem().toString())+1);
		                
		                String numCol = numeroColuna.toString(); 
				
					if (nome.trim().equals(NULO) || nome == null) {
					
				
					}else{
						if (edTabela.existe(nome,VARIAVEL)) 
						{
							
							modeloTabelaIndice.addRow(new Object[] { nome,NULO,numCol});
							edArquivo.Grava(VARIAVEL, tabelaIndice);
							modeloTabelaIndice = edTabela.indice(VARIAVEL);
							tabelaIndice.setModel(modeloTabelaIndice);
							edTabela.ocultaColuna(tabelaIndice, 1);
							edTabela.ocultaColuna(tabelaIndice, 2);

							modeloTabelaVariavel = edTabela.setValorTabelaVariavel(TABELA, nome, true, Integer.parseInt(numCol));
							modeloTabelaVariavel.addRow(new Object[]{});
							tabelaVariavel.setModel(modeloTabelaVariavel);
							edArquivo.NovoArquio(CAMINHO_VARIAVEL  + INIT_ARQUIVO + nome+ EXTENCAO, tabelaVariavel,Integer.parseInt(numCol));
						 
							
						}
					}
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		});
		
	    botaoSair.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    	dispose();
	    	}
	    });
	    
		boraoAddLinha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
				id = tabelaIndice.getSelectedRow();
				if (id == -1) 
				{
					
					JOptionPane.showMessageDialog(new JFrame(),
						    "Selecione um Item.",
						    "Erro",
						    JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					modeloTabelaVariavel.addRow(new Object[]{" --- "," --- "," --- "});
				}
			}
		});
	
		botaoDeletarLinha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeSelectedFromTable(tabelaVariavel);
			}
		});
				
	}
	
 
	public String getNomeTabelas(){
	 	return tabelaIndice.getModel().getValueAt(tabelaIndice.getSelectedRow(), 0).toString();
	}
	
	public String getIDTabelas(){
	 	return tabelaIndice.getModel().getValueAt(tabelaIndice.getSelectedRow(), 1).toString();
	}
	
	private void removeSelectedFromTable(JTable from) {
		int[] rows = from.getSelectedRows();
		TableModel tm = from.getModel();

		while (rows.length > 0) 
		{
			((DefaultTableModel) tm).removeRow(from.convertRowIndexToModel(rows[0]));
			rows = from.getSelectedRows();
		}
		from.clearSelection();
	}
  
	public void deleteAllColumn (JTable table, int p)
	{
		for(int i = 0; i <= p; i++ )
		{
			TableColumn TableColumn1 = table.getColumnModel().getColumn(i);
			TableColumnModel TableColumnModel1 = table.getColumnModel();
			TableColumnModel1.removeColumn(TableColumn1);
		}
	
	}
	
	public void setEvento(int ev){
		this.evente = ev;
	}
	
	public int getEvento(){
		return evente;
	}

}
