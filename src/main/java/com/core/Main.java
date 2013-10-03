package com.core;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
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
import com.tableUtil.JTableX;
import com.util.EditaArquivo;
import com.util.EditaTabela;


public class Main extends JDialog  {

	private static int ev = 0;
	private static final long serialVersionUID = 1L;
	final String VARIAVEL = "properties\\value\\Variavel\\IVariavel.deb";		
	final String INDICE = "properties\\value\\Idate.deb";
	final String TABELA = "properties\\value\\";
	
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
					//frame.setResizable(false);
				 	frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} 
  
 	
 	static String novonome = null;
 	private int id = -2;
	private JPanel panel_2;
	private JButton btnAdd;
	private JButton btnRenomear;
	private JPanel panel;
	private GroupLayout gl_contentPane ;
	private JPanel contentPane;
	private static JTable table;
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
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/com/image/cpqi.png")));
		
		this.setBounds(100, 100, 745, 664);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		 
		this.panel = new JPanel();
		this.panel_1 = new JPanel();
		this.panel_2 = new JPanel();
		this.panel_3 = new JPanel();
	 
		this.btnSair = new JButton("");
		this.btnSair.setBackground(Color.WHITE);
		this.btnSair.setIcon(new ImageIcon(Main.class.getResource("/com/image/sair.png")));
		this.btnDelete = new JButton("");
		this.btnDelete.setBackground(Color.WHITE);
		this.btnDelete.setIcon(new ImageIcon(Main.class.getResource("/com/image/editar.png")));
		this.btnDelete_1 = new JButton("");
		this.btnDelete_1.setBackground(Color.WHITE);
		this.btnDelete_1.setIcon(new ImageIcon(Main.class.getResource("/com/image/lixeira.png")));
		this.btnAdd = new JButton("");
		this.btnAdd.setBackground(Color.WHITE);
		this.btnAdd.setIcon(new ImageIcon(Main.class.getResource("/com/image/add.png")));
		this.btnAdd_1 = new JButton("");
		this.btnAdd_1.setBackground(Color.WHITE);
		this.btnAdd_1.setIcon(new ImageIcon(Main.class.getResource("/com/image/add.png")));
		this.model = new DefaultTableModel(); 
		this.model_1 = edTabela.setValorTabela(TABELA,"",true);
		
		
		
		 
		this.table_1 = new JTableX(model_1);
		this.table_1.setRowHeight(20);
		this.model = edTabela.indice(INDICE);
		table = new JTable(model); 
		edTabela.ocultaColuna(table, 1);
		edTabela.ocultaColuna(table, 2);
		scrollPane_1 = new JScrollPane(table_1);
		
		
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 594, Short.MAX_VALUE)
					.addContainerGap())
		);
		
	    
	    panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    
		gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_1, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
						.addComponent(panel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		
		btnRenomear = new JButton("");
		btnRenomear.setBackground(Color.WHITE);
		btnRenomear.setIcon(new ImageIcon(Main.class.getResource("/com/image/Save.png")));
		btnRenomear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					id = table.getSelectedRow();
					if (id == -1) {
						
						JOptionPane.showMessageDialog(new JFrame(),
							    "Não há Item para ser Salvo !!!",
							    "Erro",
							    JOptionPane.ERROR_MESSAGE);
					}else{
						
						edArquivo.NovoArquio(TABELA + "User_" + table.getModel().getValueAt(table.getSelectedRow(), 0).toString()+ ".deb", table_1,3);

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
		
	
		gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(btnAdd_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(btnDelete_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(btnRenomear, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addGap(12)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnAdd_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnDelete_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnRenomear, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		panel_3.setLayout(gl_panel_3);
	  
	    gl_panel_1 = new GroupLayout(panel_1);
	    gl_panel_1.setHorizontalGroup(
	    	gl_panel_1.createParallelGroup(Alignment.LEADING)
	    		.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
	    			.addContainerGap(31, Short.MAX_VALUE)
	    			.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
	    			.addGap(28))
	    );
	    gl_panel_1.setVerticalGroup(
	    	gl_panel_1.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_panel_1.createSequentialGroup()
	    			.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 54, Short.MAX_VALUE)
	    			.addGap(1))
	    );
		
	  
		
		table.setShowHorizontalLines(false);
	    scrollPane = new JScrollPane(table);
	     
		panel_1.setLayout(gl_panel_1);
	  
		
	    gl_panel_2 = new GroupLayout(panel_2);
	    gl_panel_2.setHorizontalGroup(
	    	gl_panel_2.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_panel_2.createSequentialGroup()
	    			.addGap(34)
	    			.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
	    				.addComponent(btnDelete, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
	    				.addComponent(btnAdd, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 58, Short.MAX_VALUE))
	    			.addGap(24))
	    		.addGroup(gl_panel_2.createSequentialGroup()
	    			.addContainerGap()
	    			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
	    			.addContainerGap())
	    );
	    gl_panel_2.setVerticalGroup(
	    	gl_panel_2.createParallelGroup(Alignment.TRAILING)
	    		.addGroup(gl_panel_2.createSequentialGroup()
	    			.addContainerGap()
	    			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
	    			.addGap(18)
	    			.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
	    			.addGap(18)
	    			.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
	    			.addContainerGap())
	    );
		panel_2.setLayout(gl_panel_2);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		  
		table.setDefaultEditor(Object.class, null);    
		table.addMouseListener(new MouseAdapter() {  
		 
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

				 
					String[] varia=table.getModel().getValueAt(table.getSelectedRow(), 2).toString().split(Pattern.quote("|||"));
					ArrayList<String[]> ss = new ArrayList<String[]>();
					ArrayList<String> s = new ArrayList<String>();
					
					for (int i = 0; i < varia.length; i++){
						  try {
							  s.add(varia[i]);
							ss.add(edTabela.getTab("properties\\value\\Variavel\\","User_"+varia[i]+".deb",0));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					  
					
     			 
					edTabela.setComboAr(table_1.getColumnModel().getColumn(1), ss,s);
					  
				 
				}
			}
		}); 
		  
		
		  
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){

				id = table.getSelectedRow();
				if (id == -1) {
					
					JOptionPane.showMessageDialog(new JFrame(),
						    "Selecione um Item.",
						    "Erro",
						    JOptionPane.ERROR_MESSAGE);
				} else { 
					
					  try {
					table.setModel(model);
					String n = table.getModel().getValueAt(table.getSelectedRow(), 2).toString(); 
				    
					setVetor(n); 
					
				    Editor  edt = new Editor();
				
					edt.setLocationRelativeTo(null);
					edt.setTitle("EDITOR");
					Editor.setNumCol(table.getModel().getValueAt(table.getSelectedRow(), 2).toString());
					Editor.setCaminho(TABELA);
					Editor.setArquivo("Idate.deb");
					Editor.setID(getIDTabelas());
					Editor.setNome(getNomeTabelas());
					edt.setVisible(true); 
					Editor.setCaminho2(null);
					Editor.setArquivo2(null);
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
						if (edTabela.existe(nome,TABELA,"Idate.deb")){
							model.addRow(new Object[] { nome ,"",lista});
							edArquivo.Grava(INDICE, table);
							model = edTabela.indice(INDICE);
							table.setModel(model);
							edTabela.ocultaColuna(table, 1);
							edTabela.ocultaColuna(table, 2);
							 
							model_1.addRow(new Object[] { "NOVO", "NOVO","NOVO" });

							edArquivo.NovoArquio(TABELA + "User_" + nome+ ".deb", table_1,3);
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
						    "Selecione um Item.",
						    "Erro",
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
	
 
	public static String getNomeTabelas(){
	 	return table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
	}
	
	public static String getIDTabelas(){
	 	return table.getModel().getValueAt(table.getSelectedRow(), 1).toString();
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
	
	public static void setVetor(String nome) throws IOException{
		  
		String ss = nome.replace("k1k1k1|||", "");
		if(ss.split(Pattern.quote("|||")).length > 0)
		vtor = ss.split(Pattern.quote("|||"));
		else
			vtor = null;
		
	}
	
	public static String[] getVetor() {
		return vtor ;
	}
	
	public static void setNome(String nome){
		novonome = nome;
	}
	
	@SuppressWarnings("static-access")
	public void setEvento(int ev){
		this.ev = ev;
	}
	
	public static int getEvento(){
		return ev;
	}

}