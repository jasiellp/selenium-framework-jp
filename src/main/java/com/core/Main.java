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
	private ICombo comandos = new ICombo();
 	
 	
	private JButton botaoAddNovoArquivo;
	private JButton botaoSalvarArquivo;

	private JButton botaoEditarArquivo;
	private JButton botaoSair;
	private JButton botaoAddNovaLinha;
	private JButton botaoDeletarLinha;
	
	
	private JPanel paniel;
	private JPanel painel1;
	private JPanel painel2;
	private JPanel painel3;
	private JPanel contentPane;

	private JTable  tabelaIndice;
	private JTableX tabelaItemteste;
	
	private DefaultTableModel modeloTabelaIndice;
	private DefaultTableModel modeloTabelaItemteste;
	
	private GroupLayout gl_painel;
	private GroupLayout gl_painel1;
	private GroupLayout gl_painel2;
	private GroupLayout gl_painel3;
	private GroupLayout gl_contentPane;
	
	
	private JScrollPane scrollPaneTabelaIndice;
	private JScrollPane scrollPaneTabelaItemteste;
  
	private MainExtencaoLayout extencao;
	private ArrayList<JButton> botoes;
 
	public Main() {
		
		this.setModal(true);

		this.setIconImage(new  ImageIcon(propriedades.leitor("iconeprincipal")).getImage());
		
		this.setBounds(100, 100, 745, 664);
		
		this.extencao = new MainExtencaoLayout();
		
		this.contentPane = new JPanel();
		
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		this.setContentPane(contentPane);
		 
		this.paniel  = new JPanel();
		
		this.painel1 = new JPanel();
		
		this.painel2 = new JPanel();
		
		this.painel3 = new JPanel();
	 
		this.botaoSair = new JButton(new ImageIcon((propriedades.leitor("iconesair"))));
		
		this.botaoEditarArquivo = new JButton(new ImageIcon((propriedades.leitor("iconeeditar"))));
		
		this.botaoDeletarLinha = new JButton(new ImageIcon((propriedades.leitor("iconelixeira"))));
		
		this.botaoAddNovoArquivo = new JButton(new ImageIcon((propriedades.leitor("iconeadd"))));
		
		this.botaoAddNovaLinha = new JButton(new ImageIcon((propriedades.leitor("iconeadd"))));
		 
	    this.botaoSalvarArquivo = new JButton(new ImageIcon((propriedades.leitor("iconesalve"))));
	  
	    this.botoes = new ArrayList<JButton>();
		
	    this.botoes.add(botaoAddNovaLinha);
		
	    this.botoes.add(botaoAddNovoArquivo);
		
	    this.botoes.add(botaoDeletarLinha);
		
	    this.botoes.add(botaoEditarArquivo);
		
	    this.botoes.add(botaoSair);
		
	    this.botoes.add(botaoSalvarArquivo);
		
	    this.extencao.setCorBotao(botoes, Color.WHITE);
	    
	    
		
		
		this.modeloTabelaItemteste = editaTabela.setValorTabela(TABELA,NULO,true);
		 
		this.tabelaItemteste = new JTableX(modeloTabelaItemteste);
		this.tabelaItemteste.setRowHeight(20);
		this.modeloTabelaIndice = new DefaultTableModel(); 
		this.modeloTabelaIndice = editaTabela.indice(INDICE);
		this.tabelaIndice = new JTable(modeloTabelaIndice); 
		this.tabelaIndice.setShowHorizontalLines(false);
		this.tabelaIndice.setDefaultEditor(Object.class, null);
		this.editaTabela.ocultaColuna(tabelaIndice, 1);
		this.editaTabela.ocultaColuna(tabelaIndice, 2);
		this.scrollPaneTabelaIndice = new JScrollPane(tabelaIndice);
		this.scrollPaneTabelaItemteste = new JScrollPane(tabelaItemteste);
		
		this.paniel.setBorder(new TitledBorder(null, NULO, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.painel1.setBorder(new TitledBorder(null, NULO, TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    this.painel2.setBorder(new TitledBorder(null, NULO, TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    this.painel3.setBorder(new TitledBorder(null, NULO, TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    
	 
	    
	    this.botaoSalvarArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					id = tabelaIndice.getSelectedRow();
					if (id == -1) 
					{
						extencao.mensagemDialogo(propriedades.leitor("msg00"), propriedades.leitor("erro"), JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						editaArquivo.NovoArquio(TABELA + INIT_ARQUIVO+ tabelaIndice.getModel().getValueAt(tabelaIndice.getSelectedRow(), 0).toString()+ EXTENCAO, tabelaItemteste,3);
						extencao.mensagemDialogo(propriedades.leitor("msg01"),propriedades.leitor("sucesso"),JOptionPane.INFORMATION_MESSAGE);
					}
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
	      
		this.gl_contentPane = extencao.parte1(contentPane, paniel);
		  
	    this.gl_painel = extencao.part2(paniel, painel1, painel2, painel3);
	      
		this.gl_painel1 = extencao.parte3(painel1, botaoSair);
	
		this.gl_painel3 = extencao.parte4(painel3, scrollPaneTabelaItemteste, botaoAddNovaLinha, botaoDeletarLinha, botaoSalvarArquivo);
		
		this.gl_painel2 = extencao.parte5(painel2, scrollPaneTabelaIndice, botaoAddNovoArquivo, botaoEditarArquivo, botaoSalvarArquivo);
		
		   
		this.contentPane.setLayout(this.gl_contentPane);
		
		this.paniel.setLayout(this.gl_painel);
		
		this.painel1.setLayout(this.gl_painel1);
	  
		this.painel2.setLayout(this.gl_painel2);
		
		this.painel3.setLayout(this.gl_painel3);
		  
		this.tabelaIndice.addMouseListener(new MouseAdapter() {  
		 
			public void mouseClicked(MouseEvent e)  
		    {
				if (e.getClickCount() == 1) {
					modeloTabelaItemteste = editaTabela.setValorTabela(TABELA, tabelaIndice
							.getModel().getValueAt(tabelaIndice.getSelectedRow(), 0)
							.toString(), true);

					tabelaItemteste.setModel(modeloTabelaItemteste);
					editaTabela.setCombo(tabelaItemteste.getColumnModel().getColumn(0), comandos.Combo);

					int cot = editaTabela.indice(VARIAVEL).getRowCount();

					Object[] indice = new Object[cot + 1];
					indice[0] = "Selecione";
			
					for (int i = 0; i < cot; i++)
						indice[i + 1] = editaTabela.indice(VARIAVEL).getValueAt(i, 0);

				 
					String[] varia = tabelaIndice.getModel().getValueAt(tabelaIndice.getSelectedRow(), 2).toString().split(Pattern.quote(SEPARE0));
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
					  
					
     			 
					editaTabela.setComboAr(tabelaItemteste.getColumnModel().getColumn(1), listaCombo,listaCombo2);
					  
				 
				}
			}
		}); 
		  
		this.botaoEditarArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){

				id = tabelaIndice.getSelectedRow();
				if (id == -1) {
					
					JOptionPane.showMessageDialog(new JFrame(),
							propriedades.leitor("msg02"),
						    propriedades.leitor("erro"),
						    JOptionPane.ERROR_MESSAGE);
				} else { 
					
					try {
					
						tabelaIndice.setModel(modeloTabelaIndice);
					
				    String nome = tabelaIndice.getModel().getValueAt(tabelaIndice.getSelectedRow(), 2).toString();
				    String nome1 =tabelaIndice.getModel().getValueAt(tabelaIndice.getSelectedRow(), 0).toString();
				 
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
					edt.setNumCol(tabelaIndice.getModel().getValueAt(tabelaIndice.getSelectedRow(), 2).toString());
					edt.setCaminho(TABELA);
					edt.setArquivo(propriedades.leitor("arquivoindice"));
					edt.setID(getIDTabelas());
					edt.setNome(getNomeTabelas());
					edt.setlistas();
					edt.setVisible(true); 
				
					modeloTabelaIndice = editaTabela.indice(INDICE);
					tabelaIndice.setModel(modeloTabelaIndice);
					editaTabela.ocultaColuna(tabelaIndice, 1);
					editaTabela.ocultaColuna(tabelaIndice, 2);
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
							modeloTabelaIndice.addRow(new Object[] {nome ,NULO,lista});
							editaArquivo.Grava(INDICE, tabelaIndice);
						    modeloTabelaItemteste.addRow(new Object[] { "NOVO", "NOVO","NOVO" });
							editaArquivo.NovoArquio(TABELA +INIT_ARQUIVO+ nome+ EXTENCAO, tabelaItemteste,3);
							 
						}  
					}
				} catch (IOException e) {
				
					e.printStackTrace();

				}finally{
					modeloTabelaIndice = editaTabela.indice(INDICE);
					tabelaIndice.setModel(modeloTabelaIndice);
					editaTabela.ocultaColuna(tabelaIndice, 1);
					editaTabela.ocultaColuna(tabelaIndice, 2);
				}
			}
		});
		
	    this.botaoSair.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		dispose();
	    	}
	    });
	    
		this.botaoAddNovaLinha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
				id = tabelaIndice.getSelectedRow();
				if (id == -1) {
					
					JOptionPane.showMessageDialog(new JFrame(),
							propriedades.leitor("msg02"),
							propriedades.leitor("erro"),
						    JOptionPane.ERROR_MESSAGE);
				}else
					modeloTabelaItemteste.addRow(new Object[]{" --- "});
				 
			}
		});
	
		this.botaoDeletarLinha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeSelectedFromTable(tabelaItemteste);
			}
		});
				
	}
	 
	public String getNomeTabelas(){
	 	return this.tabelaIndice.getModel().getValueAt(this.tabelaIndice.getSelectedRow(), 0).toString();
	}
	
	public String getIDTabelas(){
	 	return this.tabelaIndice.getModel().getValueAt(this.tabelaIndice.getSelectedRow(), 1).toString();
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