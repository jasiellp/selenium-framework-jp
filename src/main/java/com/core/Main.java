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
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.core.panel.Editor;
import com.inter.ICombo;
import com.inter.IFrame;
import com.util.EditaArquivo;
import com.util.EditaTabela;
import com.util.propriedades.Propriedades;
import com.util.table.JTableX;

/*  JASIEL PEREIRA DE SANT ANA
 *  
 *  Classe revisada, com implementação de Interface e propriedades.
 * FAZE 001 - OK -- (Padronização das interfaces)
 * 
 * */


public class Main extends JDialog implements IFrame  {

	private int ev = 0;
	
	private static final long serialVersionUID = 1L;
 
	private Propriedades propriedades = new Propriedades (ARQUIVO);
	
	private EditaTabela edTabela = new EditaTabela();
	
	private EditaArquivo edArquivo = new EditaArquivo();
	 
	
	private static String[] vtor;
 	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
					frame.setTitle("FRAME");
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
	private JPanel panel_2;
	private JButton btnAdd;
	private JButton btnRenomear;
	private JPanel panel;
	private GroupLayout gl_contentPane ;
	private JPanel contentPane;
	private JTable table;
	private JPanel panel_1;
	private GroupLayout gl_panel_2;
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
	
	
 
	public Main() {
		
		this.setModal(true);
	 	this.setIconImage(new  ImageIcon((propriedades.leitor("iconeprincipal"))).getImage());
		this.setBounds(100, 100, 745, 664);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		 
		this.panel = new JPanel();
		this.panel_1 = new JPanel();
		this.panel_2 = new JPanel();
		this.panel_3 = new JPanel();
	 
		this.btnSair = new JButton(new ImageIcon((propriedades.leitor("iconesair"))));
		this.btnSair.setBackground(Color.WHITE);
		
		this.btnDelete = new JButton(new ImageIcon((propriedades.leitor("iconeeditar"))));
		this.btnDelete.setBackground(Color.WHITE);
		
		this.btnDelete_1 = new JButton(new ImageIcon((propriedades.leitor("iconelixeira"))));
		this.btnDelete_1.setBackground(Color.WHITE);
		
		this.btnAdd = new JButton(new ImageIcon((propriedades.leitor("iconeadd"))));
		this.btnAdd.setBackground(Color.WHITE);
		
		this.btnAdd_1 = new JButton(new ImageIcon((propriedades.leitor("iconeadd"))));
		this.btnAdd_1.setBackground(Color.WHITE);
		
		
		this.model = new DefaultTableModel(); 
		this.model_1 = edTabela.setValorTabela(TABELA,NULO,true);
		 
		this.table_1 = new JTableX(model_1);
		this.table_1.setRowHeight(20);
		this.model = edTabela.indice(INDICE);
		
		this.table = new JTable(model); 
		this.edTabela.ocultaColuna(table, 1);
		this.edTabela.ocultaColuna(table, 2);
		this.scrollPane_1 = new JScrollPane(table_1);
		
		
		this.panel.setBorder(new TitledBorder(null, NULO, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		this.gl_contentPane = new GroupLayout(contentPane);
		this.gl_contentPane.setHorizontalGroup(
				this.gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(this.gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(this.panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		this.gl_contentPane.setVerticalGroup(
				this.gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(this.gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 594, Short.MAX_VALUE)
					.addContainerGap())
		);
		
	    
		this.panel_1.setBorder(new TitledBorder(null, NULO, TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    this.panel_2.setBorder(new TitledBorder(null, NULO, TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    this.panel_3.setBorder(new TitledBorder(null, NULO, TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    
	    this.gl_panel = new GroupLayout(panel);
	    this.gl_panel.setHorizontalGroup(
	    		this.gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(this.gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(this.panel_3, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
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
						.addComponent(this.panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(this.panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(this.panel_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		
	    this.btnRenomear = new JButton(new ImageIcon((propriedades.leitor("iconesalve"))));
	    this.btnRenomear.setBackground(Color.WHITE);
	    
	    this.btnRenomear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					id = table.getSelectedRow();
					if (id == -1) {
						
						JOptionPane.showMessageDialog(new JFrame(),
								propriedades.leitor("msg00"),
							    propriedades.leitor("erro"),
							    JOptionPane.ERROR_MESSAGE);
					}else{
						
						edArquivo.NovoArquio(TABELA + INIT_ARQUIVO+ table.getModel().getValueAt(table.getSelectedRow(), 0).toString()+ EXTENCAO, table_1,3);

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
		
	
		this.gl_panel_3 = new GroupLayout(panel_3);
		this.gl_panel_3.setHorizontalGroup(
				this.gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(this.gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(this.gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(this.scrollPane_1, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
						.addGroup(this.gl_panel_3.createSequentialGroup()
							.addComponent(this.btnAdd_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(this.btnDelete_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(this.btnRenomear, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		this.gl_panel_3.setVerticalGroup(
				this.gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, this.gl_panel_3.createSequentialGroup()
					.addGap(12)
					.addComponent(this.scrollPane_1, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(this.gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(this.gl_panel_3.createParallelGroup(Alignment.BASELINE)
							.addComponent(this.btnAdd_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addComponent(this.btnDelete_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
						.addComponent(this.btnRenomear, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		this.panel_3.setLayout(this.gl_panel_3);
	  
		this.gl_panel_1 = new GroupLayout(this.panel_1);
		this.gl_panel_1.setHorizontalGroup(
				this.gl_panel_1.createParallelGroup(Alignment.LEADING)
	    		.addGroup(Alignment.TRAILING, this.gl_panel_1.createSequentialGroup()
	    			.addContainerGap(31, Short.MAX_VALUE)
	    			.addComponent(this.btnSair, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
	    			.addGap(28))
	    );
		this.gl_panel_1.setVerticalGroup(
				this.gl_panel_1.createParallelGroup(Alignment.LEADING)
	    		.addGroup(this.gl_panel_1.createSequentialGroup()
	    			.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 54, Short.MAX_VALUE)
	    			.addGap(1))
	    );
		
	  
		
		this.table.setShowHorizontalLines(false);
		this.scrollPane = new JScrollPane(this.table);
	     
		this.panel_1.setLayout(this.gl_panel_1);
	  
		
		this.gl_panel_2 = new GroupLayout(this.panel_2);
		this.gl_panel_2.setHorizontalGroup(
				this.gl_panel_2.createParallelGroup(Alignment.LEADING)
	    		.addGroup(this.gl_panel_2.createSequentialGroup()
	    			.addGap(34)
	    			.addGroup(this.gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
	    				.addComponent(this.btnDelete, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
	    				.addComponent(this.btnAdd, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 58, Short.MAX_VALUE))
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
	    			.addComponent(this.scrollPane, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
	    			.addGap(18)
	    			.addComponent(this.btnDelete, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
	    			.addGap(18)
	    			.addComponent(this.btnAdd, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
	    			.addContainerGap())
	    );
		this.panel_2.setLayout(this.gl_panel_2);
		this.panel.setLayout(this.gl_panel);
		this.contentPane.setLayout(this.gl_contentPane);
		
		  
		this.table.setDefaultEditor(Object.class, null);    
		this.table.addMouseListener(new MouseAdapter() {  
		 
			public void mouseClicked(MouseEvent e)  
		    {
				if (e.getClickCount() == 1) {
					model_1 = edTabela.setValorTabela(TABELA, table
							.getModel().getValueAt(table.getSelectedRow(), 0)
							.toString(), true);

					table_1.setModel(model_1);
					edTabela.setCombo(table_1.getColumnModel().getColumn(0), ICombo.Combo);

					int cot = edTabela.indice(VARIAVEL).getRowCount();

					Object[] indice = new Object[cot + 1];
					indice[0] = "Selecione";
			
					for (int i = 0; i < cot; i++)
						indice[i + 1] = edTabela.indice(VARIAVEL).getValueAt(i, 0);

				 
					String[] varia = table.getModel().getValueAt(table.getSelectedRow(), 2).toString().split(Pattern.quote(SEPARE0));
					ArrayList<String[]> listaCombo = new ArrayList<String[]>();
					ArrayList<String> listaCombo2 = new ArrayList<String>();
					
					for (int i = 0; i < varia.length; i++){
						  try {
							  listaCombo2.add(varia[i]);
							  listaCombo.add(edTabela.getTab((propriedades.leitor("arquivovariavel")),INIT_ARQUIVO+varia[i]+EXTENCAO,0));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					  
					
     			 
					edTabela.setComboAr(table_1.getColumnModel().getColumn(1), listaCombo,listaCombo2);
					  
				 
				}
			}
		}); 
		  
		
		  
		btnDelete.addActionListener(new ActionListener() {
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
				    
					setVetor(nome); 
					
				    Editor  edt = new Editor();
				
					edt.setLocationRelativeTo(null);
					edt.setTitle(propriedades.leitor("tmodal001"));
					
				 	
					edt.setNumCol(table.getModel().getValueAt(table.getSelectedRow(), 2).toString());
					edt.setCaminho(TABELA);
					edt.setArquivo(propriedades.leitor("arquivoindice"));
					edt.setID(getIDTabelas());
					edt.setNome(getNomeTabelas());
					edt.setVisible(true); 
					edt.setCaminho2(null);
					edt.setArquivo2(null);
					model = edTabela.indice(INDICE);
					table.setModel(model);
					edTabela.ocultaColuna(table, 1);
					edTabela.ocultaColuna(table, 2);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}finally{
							vtor = null;
						}
				}

			}
		});

		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {  
					setEvento(1);
					
					Editor edt = new Editor();
					edt.setVisivel(false);
					edt.setLocationRelativeTo(null);
					edt.setTitle("Nova SWITE");
					edt.setVisible(true);
					String lista = edt.getLista();
					String nome = getNome();
					
					if (nome != null) {
						if (edTabela.existe(nome,TABELA,propriedades.leitor("arquivoindice"))){
							model.addRow(new Object[] { nome ,NULO,lista});
							edArquivo.Grava(INDICE, table);
							model = edTabela.indice(INDICE);
							table.setModel(model);
							edTabela.ocultaColuna(table, 1);
							edTabela.ocultaColuna(table, 2);
							 
							model_1.addRow(new Object[] { "NOVO", "NOVO","NOVO" });

							edArquivo.NovoArquio(TABELA +INIT_ARQUIVO+ nome+ EXTENCAO, table_1,3);
						} else {
							 
						}
					}
				} catch (IOException e) {

					e.printStackTrace();
				}finally{
					vtor = null;
				}
			}
		});
		
	    btnSair.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		
	    		dispose();
	    	}
	    });
	    
		btnAdd_1.addActionListener(new ActionListener() {
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
	
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeSelectedFromTable(table_1);
			}
		});
				
	}
	
 
	public   String getNomeTabelas(){
	 	return this.table.getModel().getValueAt(this.table.getSelectedRow(), 0).toString();
	}
	
	public   String getIDTabelas(){
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
	
	public static void setVetor(String nome) throws IOException {

		String stg = nome.replace(SEPARE1, NULO);
		
		if (stg.split(Pattern.quote(SEPARE0)).length > 0)
			vtor = stg.split(Pattern.quote(SEPARE0));
		else
			vtor = null;

	}
	
	public static String[] getVetor() {
		return vtor ;
	}
	
	public  void setNome(String novonome ){
		this.novonome = novonome ;
	}
	 
	public void setEvento(int ev){
		this.ev = ev;
	}
	
	public  int getEvento(){
		return this.ev;
	}

}