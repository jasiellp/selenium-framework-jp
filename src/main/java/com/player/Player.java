package com.player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.inter.ICombo;
import com.inter.IFrame;
import com.painel.print.Print;
import com.util.CabecalhoCheckBox;
import com.util.Chronometer;
import com.util.EditaTabela;
import com.util.ImagemUtil;
import com.util.ItemCabecalho;
import com.util.JPBotao;
import com.util.RendererCelula;
import com.util.SeleniumUtil;


public class Player extends JDialog implements IFrame{

	
	private static final long serialVersionUID = 8972926567211235479L;
	
	private ICombo combo = new ICombo();
	private JPanel contentpainel = new JPanel();
	private static Player dialog;
	
	private GroupLayout gl_contentpainel;
	private GroupLayout gl_painel;
	private GroupLayout gl_painel1;
	private GroupLayout gl_painel2;
	@SuppressWarnings("unused")
	private GroupLayout gl_painel3;
	private GroupLayout gl_painel4;
	
	private JPanel painel;
	private JPanel painel1;
	private JPanel painel2;
	private JPanel painel3;
	private JPanel painel4;
	
	private JScrollPane scrollPaneTabelaIndice;
	private JScrollPane scrollPaneTabelaItemteste;
	
	private JTable tabelaItemteste;
	private JTable tabelaIndice;
	
	private DefaultTableModel modeloTabelaItemteste;
	private DefaultTableModel modeloTabelaIndice;
	
	private JButton botaoSair;
	private JButton botaoPlay;
	private JButton botaoPause;
	private JButton botaoStop;
	private JButton botaoAvancar;
	private JButton botaoPrint;
	private JButton botaoLimpar;
	 
	private EditaTabela editaTabela = new EditaTabela();
	private String caminho = "C:\\Base\\teste\\teste";
	private String valor;
	
	private int tempo;
	
	private RendererCelula colorirTabelaIndice;
	private RendererCelula colorirTabelaItemteste;
	private PlayerExtencaoLayout extencao;
	
	
	private boolean pause = false;
	private boolean pare = false;
	private int indicador = 0;
	
	private Thread thread;
	
	private ImagemUtil image = new ImagemUtil();
	
	private ArrayList<Image> evidence = new ArrayList<Image>();
	private ArrayList<String> comentario = new ArrayList<String>();
	
	private SeleniumUtil sUtil = new SeleniumUtil();
	
	private TableColumn tc;

	@SuppressWarnings("rawtypes")
	private Class cls;
	private Object obj;
	private String execao;
	
	private Chronometer execucao = new Chronometer();

	public static void main(String[] args) {
		try {
			dialog = new Player();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Player() {

		this.extencao = new PlayerExtencaoLayout();
		this.colorirTabelaIndice = new RendererCelula();
		this.colorirTabelaItemteste = new RendererCelula();
		this.setModal(true);
		
		this.setIconImage(new  ImageIcon(propriedades.leitor("iconeprincipal")).getImage());
		
		this.setBounds(100, 100, 744, 651);
		this.getContentPane().setLayout(new BorderLayout());
		this.contentpainel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().add(contentpainel, BorderLayout.CENTER);

		this.modeloTabelaItemteste = new DefaultTableModel();
		this.modeloTabelaItemteste = editaTabela.indiceBoolean();
		this.modeloTabelaIndice = new DefaultTableModel();
		this.modeloTabelaIndice = editaTabela.setValorTabela(TABELA, NULO, false);
		
		this.tabelaItemteste = new JTable(this.modeloTabelaItemteste);
		this.tabelaItemteste.setDefaultRenderer(Object.class, this.colorirTabelaItemteste);
		this.tabelaItemteste.getColumnModel().getColumn(2).setMinWidth(0);
		this.tabelaItemteste.getColumnModel().getColumn(2).setPreferredWidth(0);
		this.tabelaItemteste.getColumnModel().getColumn(2).setMaxWidth(0);

		this.tabelaIndice = new JTable(this.modeloTabelaIndice);
		this.tabelaIndice.setEnabled(false);
		this.tabelaIndice.setDefaultRenderer(Object.class, this.colorirTabelaIndice);

		this.scrollPaneTabelaItemteste = new JScrollPane(this.tabelaItemteste);

		this.tc = this.tabelaItemteste.getColumnModel().getColumn(0);
		this.tc.setCellEditor(this.tabelaItemteste.getDefaultEditor(Boolean.class));
		this.tc.setCellRenderer(this.tabelaItemteste.getDefaultRenderer(Boolean.class));
		this.tc.setHeaderRenderer(new CabecalhoCheckBox(new ItemCabecalho(this.tabelaItemteste)));

		this.scrollPaneTabelaIndice = new JScrollPane(this.tabelaIndice);

		this.painel = new JPanel();
		this.painel.setBorder(new TitledBorder(null, NULO, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		this.painel1 = new JPanel();
		this.painel1.setBorder(new TitledBorder(null, NULO, TitledBorder.LEADING,TitledBorder.TOP, null, null));

		this.painel2 = new JPanel();
		this.painel2.setBorder(new TitledBorder(null, NULO, TitledBorder.LEADING,TitledBorder.TOP, null, null));

		this.painel3 = new JPanel();
		this.painel3.setBorder(new TitledBorder(null, NULO, TitledBorder.LEADING,TitledBorder.TOP, null, null));
		
		this.painel4 = new JPanel();
		 
		
		this.botaoSair = new JPBotao(Color.WHITE, propriedades.leitor("iconesair"));
		this.botaoPlay = new JPBotao(Color.WHITE, propriedades.leitor("iconeplay"));
		this.botaoPause = new JPBotao(Color.WHITE, propriedades.leitor("iconepause"));
		this.botaoStop = new JPBotao(Color.WHITE, propriedades.leitor("iconestop"));
		this.botaoAvancar = new JPBotao(Color.WHITE,propriedades.leitor("iconeavanca"));
		this.botaoPrint = new JPBotao(Color.WHITE, propriedades.leitor("iconeprint"));
		this.botaoLimpar =  new JPBotao(Color.WHITE, propriedades.leitor("iconelimpar"));
		
		this.gl_contentpainel = extencao.parte1(contentpainel, painel);
		
		this.gl_painel3 = extencao.parte2(painel3, botaoSair);
		
		this.gl_painel = extencao.parte3(painel, painel4, painel1, painel2, painel3);
		

		
		botaoPlay.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				setPause(false);
				thread = new Thread(threads);
				thread.start();
				botaoPlay.setEnabled(false);
				botaoStop.setEnabled(true);
				botaoPause.setEnabled(true);
				botaoPrint.setEnabled(false);

			}
		});
		
		this.botaoPrint.setEnabled(false);
		botaoPrint.addActionListener(new ActionListener() {

			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent arg0) {
				try {
				
				Object screen = cls.getDeclaredMethod("testCapture").invoke(obj);
			 
				Print print = new Print(image.decodeAndWriteScreenshot(screen.toString()));
				print.setSize(600,400);
				print.setLocation(200,200);
				print.setVisible(true);
				
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException
						| SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		this.botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
 
		
		this.botaoPause.setEnabled(false);
		botaoPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (indicador == 0) 
				{
					setPause(true);

					botaoPlay.setEnabled(false);
					botaoStop.setEnabled(false);
					botaoAvancar.setEnabled(true);
					botaoPrint.setEnabled(true);
					indicador = 1;
				}
				else 
				{
					setPause(false);
					
					botaoPrint.setEnabled(false);
					botaoStop.setEnabled(true);
					botaoPause.setEnabled(true);
					botaoAvancar.setEnabled(false);
					indicador = 0;
				}

			}
		});
		 
		
		this.botaoStop.setEnabled(false);
		botaoStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setPare(true);
			}
		});
		
	
		this.botaoAvancar.setEnabled(false);
		botaoAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (indicador == 1)
					setPause(false);
			}
		});
		
		
		botaoLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				for (int i = 0; i < modeloTabelaIndice.getRowCount(); i++) {
					for (int j = 0; j < tabelaItemteste.getColumnCount(); j++) {
						colorirTabelaIndice.colorirCelula(i, j,
								new Color(255, 255, 255));
					}
				}
				
			}
		});
		

		
		this.gl_painel4 = extencao.parte4(painel4, botaoPlay, botaoPause, botaoStop, botaoAvancar, botaoPrint, botaoLimpar );
	 
		this.gl_painel1 = extencao.parte6(painel1, scrollPaneTabelaIndice);
	
		this.gl_painel2 = extencao.parte5(scrollPaneTabelaItemteste, painel2);
		
		this.contentpainel.setLayout(this.gl_contentpainel);
		this.painel.setLayout(this.gl_painel);
		this.painel1.setLayout(this.gl_painel1);
		this.painel2.setLayout(this.gl_painel2);
		
		this.painel4.setLayout(this.gl_painel4);

		this.tabelaItemteste.setDefaultEditor(Object.class, null);
		this.tabelaItemteste.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					modeloTabelaIndice = editaTabela.setValorTabela(TABELA, tabelaItemteste.getModel()
							.getValueAt(tabelaItemteste.getSelectedRow(), 1).toString(),
							false);
					tabelaIndice.setModel(modeloTabelaIndice);


				}
			}
		});

	}

	private void setLinha(int linha) {

		this.colorirTabelaIndice.colorirCelula(linha, 1, new Color(202, 225, 255));
		this.colorirTabelaIndice.colorirCelula(linha, 0, new Color(202, 225, 255));
		this.tabelaIndice.validate();
		this.modeloTabelaIndice.fireTableDataChanged();

	}

	public Color aCor(String txt) {
		Color nomesCor = null;

		if (txt != null) {
			if (txt.contains("OK")) {
				nomesCor = new Color(51, 204, 0);
			} else if (txt.contains(ERRO)) {
				nomesCor = new Color(255, 0, 0);
			} else {
				nomesCor = new Color(0, 153, 255);

			}
		}

		return nomesCor;

	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return this.valor;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public int getTempo() {
		return this.tempo;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public boolean getPause() {
		return this.pause;
	}

	public void setPare(boolean pare) {
		this.pare = pare;
	}

	public boolean getPare() {
		return this.pare;
	}

	public JTable getTable() {
		return this.tabelaItemteste;
	}

	Thread threads = new Thread(new Runnable() {

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public void run() {
			try {

				

				for (int j = 0; j < tabelaItemteste.getRowCount(); j++) {

					if (tabelaItemteste.getValueAt(j, 0).toString().equals("true")) {

						modeloTabelaIndice = editaTabela.setValorTabela(TABELA, tabelaItemteste
								.getModel().getValueAt(j, 1).toString(), false);

						tabelaIndice.setModel(modeloTabelaIndice);

						for (int i = 0; i < modeloTabelaIndice.getRowCount(); i++)
						{
							for (int c = 0; c < tabelaItemteste.getColumnCount(); c++)
							{
								colorirTabelaIndice.colorirCelula(i, c, new Color(255, 255,255));
							}
						}
						
						String arquivo = tabelaItemteste.getModel().getValueAt(j, 1).toString();

						String[] comandos = editaTabela.getTab(TABELA, INIT_ARQUIVO + arquivo + EXTENCAO, 0);

						ArrayList[] alvo = editaTabela.getAlvo(TABELA, INIT_ARQUIVO + arquivo + EXTENCAO, 1, ARQUIVOVARIAVEL, 0);

						String[] alvo2 = editaTabela.getTab(TABELA, INIT_ARQUIVO + arquivo + EXTENCAO, 1);
						
						String[] massaDados = editaTabela.getTab(TABELA, INIT_ARQUIVO + arquivo + EXTENCAO, 2);

						cls = Class.forName("com.selenium.JpSelenium");

						obj = cls.newInstance();

						int tamanho = comandos.length;

						for (int i = 0; i < tamanho; i++) {

							if (getPare()) {
								cls.getDeclaredMethod(TEARDOWN).invoke(obj);
								execucao.stop();
								i = tamanho++;
								break;
							}

							while (getPause())
								Thread.sleep(100);

							if (comandos[i].equals(combo.Combo[1])) 
							{
								cls.getDeclaredMethod("setUp", String.class,String.class).invoke(obj, alvo[i].get(1).toString(),massaDados[i]);
								execucao.start();
							}

							if (comandos[i].equals(combo.Combo[2]))
								Thread.sleep(Integer.parseInt(massaDados[i]));

							if (comandos[i].equals(combo.Combo[3])) 
							{
								Object screen = cls.getDeclaredMethod("testCapture").invoke(obj);
								evidence.add(image.decodeAndWriteScreenshot(screen.toString()));
								comentario.add(massaDados[i]);
							}
							
							if(comandos[i].equals(combo.Combo[4]))
							{
								Object valor = cls.getDeclaredMethod("testElemento", ArrayList.class).invoke(obj, alvo[i]);
								setExption(i, valor, alvo2[i]);
								
								if (!valor.toString().equals(ERRO))
								{
									cls.getDeclaredMethod("testClique",String.class).invoke(obj,valor.toString());
								}
								else 
								{
									setExption(i, valor, alvo2[i]);
									cls.getDeclaredMethod(TEARDOWN).invoke(obj);
									execucao.stop();
									break;
								}
							}

							if (comandos[i].equals(combo.Combo[5])) 
							{
								Object valor = cls.getDeclaredMethod("testElemento", ArrayList.class).invoke(obj, alvo[i]);
								setExption(i,valor,alvo2[i]);

								if (!valor.toString().equals(ERRO))
								{
									cls.getDeclaredMethod("testDigite",String.class, String.class).invoke(obj, valor.toString(), massaDados[i]);
								}
								else 
								{
									cls.getDeclaredMethod(TEARDOWN).invoke(obj);
									execucao.stop();
									break;
								}

							}

							if (comandos[i].equals(combo.Combo[6])) 
							{
								cls.getDeclaredMethod(TEARDOWN).invoke(obj);
								execucao.stop();
							}
							
							if (comandos[i].equals(combo.Combo[7])) 
							{
								Object valor = cls.getDeclaredMethod("testTexto", ArrayList.class).invoke(obj , alvo[i]);
								setExption1(i, valor);
									
							}
							
							if (indicador == 1)
								setPause(true);

							setLinha(i);

						}

						if(getExeption().contains(ERRO))
						{
							colorirTabelaItemteste.colorirCelula(j, 0, new Color(255, 60, 21));
							colorirTabelaItemteste.colorirCelula(j, 1, new Color(255, 60, 21));	
							tabelaItemteste.validate();
							modeloTabelaItemteste.fireTableDataChanged();
						}
						else
						{
							colorirTabelaItemteste.colorirCelula(j, 0, new Color(0, 255, 51));
							colorirTabelaItemteste.colorirCelula(j, 1, new Color(0, 255, 51));
							tabelaItemteste.validate();
							modeloTabelaItemteste.fireTableDataChanged();
						}
						
						tabelaItemteste.setValueAt(false, j, 0);
						
						String tempoExecucao = ":"+(int)(execucao.elapsedTime() % 60);
 
						sUtil.gerarPDF(evidence,comentario, arquivo, NULO, getExeption(), "GoogleChrome",caminho, tempoExecucao);

					}
				}

				botaoPlay.setEnabled(true);
				botaoStop.setEnabled(false);
				botaoPause.setEnabled(false);
				botaoAvancar.setEnabled(false);
				botaoPrint.setEnabled(false);

			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	});
	
	private String getExeption(){
		return this.execao;
	}

	private void setExption(int linha, Object valor, String elemento) {

		if (valor.toString().equals(ERRO)) {
			this.colorirTabelaIndice.colorirCelula(linha, 2, new Color(255, 60, 21));
			this.colorirTabelaIndice.colorirCelula(linha, 1, new Color(202, 225, 255));
			this.colorirTabelaIndice.colorirCelula(linha, 0, new Color(202, 225, 255));
			this.tabelaIndice.validate();
			this.modeloTabelaIndice.fireTableDataChanged();
			this.execao = "Erro - "+elemento+" nao encontrado...";
		} else {
			this.colorirTabelaIndice.colorirCelula(linha, 2, new Color(0, 255, 51));
			this.colorirTabelaIndice.colorirCelula(linha, 1, new Color(202, 225, 255));
			this.colorirTabelaIndice.colorirCelula(linha, 0, new Color(202, 225, 255));
			this.tabelaIndice.validate();
			this.modeloTabelaIndice.fireTableDataChanged();
			this.execao = "Teste Realizado com sucesso...";
		}
	}
	private void setExption1(int linha, Object valor) {

		if (!valor.toString().equals("OK")) {
			this.colorirTabelaIndice.colorirCelula(linha, 2, new Color(255, 60, 21));
			this.colorirTabelaIndice.colorirCelula(linha, 1, new Color(202, 225, 255));
			this.colorirTabelaIndice.colorirCelula(linha, 0, new Color(202, 225, 255));
			this.tabelaIndice.validate();
			this.modeloTabelaIndice.fireTableDataChanged();
			this.execao = "Erro - Item "+valor+" nao encontrado...";
		} else {
			this.colorirTabelaIndice.colorirCelula(linha, 2, new Color(0, 255, 51));
			this.colorirTabelaIndice.colorirCelula(linha, 1, new Color(202, 225, 255));
			this.colorirTabelaIndice.colorirCelula(linha, 0, new Color(202, 225, 255));
			this.tabelaIndice.validate();
			this.modeloTabelaIndice.fireTableDataChanged();
			this.execao = "Teste Realizado com sucesso...";
		}
	}
}
