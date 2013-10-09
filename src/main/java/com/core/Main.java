package com.core;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.core.painel.Editor;
import com.inter.ICombo;
import com.inter.IFrame;
import com.util.EditaArquivo;
import com.util.EditaTabela;
import com.util.propriedades.Propriedades;
import com.util.table.JTableX;

/*  JASIEL PEREIRA DE SANT ANA
 *  
 *  Classe revisada, com implementação de Interface e propriedades.
 * FASE 001 - OK -- (Padronização das interfaces)
 * FASE 002 - OK -- (Limpeza e padronização do Layout)
 * FASE 003 (Padronização de Variaves is Objectos)
 * */


public class Main extends JDialog implements IFrame  {
 
	private static final long serialVersionUID = 1L;
 
	private Propriedades propriedades = new Propriedades (ARQUIVO);
	
	private EditaTabela editaTabela = new EditaTabela();
	
	private EditaArquivo editaArquivo = new EditaArquivo();
	   
	private static Main frame;
 
 	
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Main();
					frame.setVisible(true);
					frame.setTitle("");
					frame.setResizable(true);
				 	frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} 
  
 	
	private String novonome = null;
 	private int id = -2;
	private JPanel painel_2;
	private JButton botaoAddNovoArquivo;
	private JButton botaoEditarArquivo;
	private JPanel paniel;
	private GroupLayout gl_contentPane ;
	private JPanel contentPane;
	private JTable table;
	private JPanel panel_1;
	private GroupLayout gl_painel_2;
	private GroupLayout gl_panel_1;
	private GroupLayout gl_panel;
	private DefaultTableModel model;
	private DefaultTableModel model_1;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JButton btnDelete;
	private JButton btnSair;
	private JPanel panel_3;
	private JTableX table_1;
	private JButton btnAdd_1;
	private JButton btnDelete_1;
	private GroupLayout gl_panel_3;
	private MainExtencaoLayout extencao;
	
 
	public Main() {
		
		this.setModal(true);
	 	this.setIconImage(new  ImageIcon((propriedades.leitor("iconeprincipal"))).getImage());
		this.setBounds(100, 100, 745, 664);
		
		this.extencao = new MainExtencaoLayout();
		
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		 
		this.paniel = new JPanel();
		this.panel_1 = new JPanel();
		this.painel_2 = new JPanel();
		this.panel_3 = new JPanel();
	 
		this.btnSair = new JButton(new ImageIcon((propriedades.leitor("iconesair"))));
		this.btnSair.setBackground(Color.WHITE);
		
		this.btnDelete = new JButton(new ImageIcon((propriedades.leitor("iconeeditar"))));
		this.btnDelete.setBackground(Color.WHITE);
		
		this.btnDelete_1 = new JButton(new ImageIcon((propriedades.leitor("iconelixeira"))));
		this.btnDelete_1.setBackground(Color.WHITE);
		
		this.botaoAddNovoArquivo = new JButton(new ImageIcon((propriedades.leitor("iconeadd"))));
		this.botaoAddNovoArquivo.setBackground(Color.WHITE);
		
		this.btnAdd_1 = new JButton(new ImageIcon((propriedades.leitor("iconeadd"))));
		this.btnAdd_1.setBackground(Color.WHITE);
		 
	    this.botaoEditarArquivo = new JButton(new ImageIcon((propriedades.leitor("iconesalve"))));
	    this.botaoEditarArquivo.setBackground(Color.WHITE);
		
		this.model = new DefaultTableModel(); 
		this.model = editaTabela.indice(INDICE);
		
		this.model_1 = editaTabela.setValorTabela(TABELA,NULO,true);
		 
		this.table_1 = new JTableX(model_1);
		this.table_1.setRowHeight(20);
		 
		this.table = new JTable(model); 
		this.table.setShowHorizontalLines(false);
		this.table.setDefaultEditor(Object.class, null);
		
		this.editaTabela.ocultaColuna(table, 1);
		this.editaTabela.ocultaColuna(table, 2);
		 
		this.scrollPane = new JScrollPane(table);
		
		this.scrollPane_1 = new JScrollPane(table_1);
		
		this.paniel.setBorder(new TitledBorder(null, NULO, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_1.setBorder(new TitledBorder(null, NULO, TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    this.painel_2.setBorder(new TitledBorder(null, NULO, TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    this.panel_3.setBorder(new TitledBorder(null, NULO, TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    
	 
	    
	    this.botaoEditarArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					id = table.getSelectedRow();
					if (id == -1) {
						
						JOptionPane.showMessageDialog(new JFrame(),
								propriedades.leitor("msg00"),
							    propriedades.leitor("erro"),
							    JOptionPane.ERROR_MESSAGE);
					}else{
						
						editaArquivo.NovoArquio(TABELA + INIT_ARQUIVO+ table.getModel().getValueAt(table.getSelectedRow(), 0).toString()+ EXTENCAO, table_1,3);

					JOptionPane.showMessageDialog(new JFrame(),
							propriedades.leitor("msg01"),
							propriedades.leitor("sucesso"),
						    JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
	      
		this.gl_contentPane = extencao.parte1(contentPane, paniel);
		  
	    this.gl_panel = extencao.part2(paniel, panel_1, painel_2, panel_3);
	      
		this.gl_panel_1 = extencao.parte3(panel_1, btnSair);
	
		this.gl_panel_3 = extencao.parte4(panel_3, scrollPane_1, btnAdd_1, btnDelete_1, botaoEditarArquivo);
		
		this.gl_painel_2 = extencao.parte5(painel_2, scrollPane, botaoAddNovoArquivo, btnDelete, botaoEditarArquivo);
		
		   
		this.contentPane.setLayout(this.gl_contentPane);
		
		this.paniel.setLayout(this.gl_panel);
		
		this.panel_1.setLayout(this.gl_panel_1);
	  
		this.painel_2.setLayout(this.gl_painel_2);
		
		this.panel_3.setLayout(this.gl_panel_3);
		  
		this.table.addMouseListener(new MouseAdapter() {  
		 
			public void mouseClicked(MouseEvent e)  
		    {
				if (e.getClickCount() == 1) {
					model_1 = editaTabela.setValorTabela(TABELA, table
							.getModel().getValueAt(table.getSelectedRow(), 0)
							.toString(), true);

					table_1.setModel(model_1);
					editaTabela.setCombo(table_1.getColumnModel().getColumn(0), ICombo.Combo);

					int cot = editaTabela.indice(VARIAVEL).getRowCount();

					Object[] indice = new Object[cot + 1];
					indice[0] = "Selecione";
			
					for (int i = 0; i < cot; i++)
						indice[i + 1] = editaTabela.indice(VARIAVEL).getValueAt(i, 0);

				 
					String[] varia = table.getModel().getValueAt(table.getSelectedRow(), 2).toString().split(Pattern.quote(SEPARE0));
					ArrayList<String[]> listaCombo = new ArrayList<String[]>();
					ArrayList<String> listaCombo2 = new ArrayList<String>();
					
					for (int i = 0; i < varia.length; i++){
						  try {
							  listaCombo2.add(varia[i]);
							  listaCombo.add(editaTabela.getTab((propriedades.leitor("arquivovariavel")),INIT_ARQUIVO+varia[i]+EXTENCAO,0));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					  
					
     			 
					editaTabela.setComboAr(table_1.getColumnModel().getColumn(1), listaCombo,listaCombo2);
					  
				 
				}
			}
		}); 
		  
		this.btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){

				id = table.getSelectedRow();
				if (id == -1) {
					
					JOptionPane.showMessageDialog(new JFrame(),
							propriedades.leitor("msg02"),
						    propriedades.leitor("erro"),
						    JOptionPane.ERROR_MESSAGE);
				} else { 
					
					try {
					
					table.setModel(model);
					
				    String nome = table.getModel().getValueAt(table.getSelectedRow(), 2).toString();
				    String nome1 =table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
				 
					int cot = editaTabela.indice(INDICE).getRowCount();
					Object[] indice = new Object[cot];
					 
			
					for (int i = 0; i < cot; i++)
					{
						if(!editaTabela.indice(INDICE).getValueAt(i, 0).equals(nome1))
							indice[i] = editaTabela.indice(INDICE).getValueAt(i, 0);
						else
							indice[i] = "";
					} 
				  
				    Editor edt = new Editor();
				    edt.setVetor(nome);
				    edt.setEvento(1);
				    edt.setIgualNome(indice);
				    edt.setLocationRelativeTo(null);
					edt.setTitle(propriedades.leitor("tmodal001"));
					edt.setNumCol(table.getModel().getValueAt(table.getSelectedRow(), 2).toString());
					edt.setCaminho(TABELA);
					edt.setArquivo(propriedades.leitor("arquivoindice"));
					edt.setID(getIDTabelas());
					edt.setNome(getNomeTabelas());
					edt.setlistas();
					edt.setVisible(true); 
				
					model = editaTabela.indice(INDICE);
					table.setModel(model);
					editaTabela.ocultaColuna(table, 1);
					editaTabela.ocultaColuna(table, 2);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
				}

			}
		});
 
		this.botaoAddNovoArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {  
					
					Editor edt = new Editor();
					edt.setCaminho(TABELA);
					edt.setArquivo(propriedades.leitor("arquivoindice"));
					edt.setEvento(10); 
				 	edt.setLocationRelativeTo(null);
					edt.setTitle(propriedades.leitor("tmodal002"));
					edt.setVisible(true);
					String lista = edt.getLista();
					String nome = getNome();
					
					if (nome != null) 
					{
						
						if (editaTabela.existe(nome,INDICE))
						{
							model.addRow(new Object[] {nome ,NULO,lista});
							editaArquivo.Grava(INDICE, table);
						    model_1.addRow(new Object[] { "NOVO", "NOVO","NOVO" });
							editaArquivo.NovoArquio(TABELA +INIT_ARQUIVO+ nome+ EXTENCAO, table_1,3);
							 
						}  
					}
				} catch (IOException e) {
				
					e.printStackTrace();

				}finally{
					model = editaTabela.indice(INDICE);
					table.setModel(model);
					editaTabela.ocultaColuna(table, 1);
					editaTabela.ocultaColuna(table, 2);
				}
			}
		});
		
	    this.btnSair.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		dispose();
	    	}
	    });
	    
		this.btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
				id = table.getSelectedRow();
				if (id == -1) {
					
					JOptionPane.showMessageDialog(new JFrame(),
							propriedades.leitor("msg02"),
							propriedades.leitor("erro"),
						    JOptionPane.ERROR_MESSAGE);
				}else
					model_1.addRow(new Object[]{" --- "});
				 
			}
		});
	
		this.btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeSelectedFromTable(table_1);
			}
		});
				
	}
	 
	public String getNomeTabelas(){
	 	return this.table.getModel().getValueAt(this.table.getSelectedRow(), 0).toString();
	}
	
	public String getIDTabelas(){
	 	return this.table.getModel().getValueAt(this.table.getSelectedRow(), 1).toString();
	}
	
	private void removeSelectedFromTable(JTable from) {
		int[] rows = from.getSelectedRows();
		TableModel tm = from.getModel();

		while (rows.length > 0) {
			((DefaultTableModel) tm).removeRow(from.convertRowIndexToModel(rows[0]));
			rows = from.getSelectedRows();
		}
		from.clearSelection();
	}

	public String getNome(){
		return novonome;
	}
 
	public void setNome(String novonome ){
		this.novonome = novonome ;
	}
	 
}