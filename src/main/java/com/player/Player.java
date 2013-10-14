package com.player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.inter.ICombo;
import com.selenium.JpSelenium;
import com.util.CabecalhoCheckBox;
import com.util.Chronometer;
import com.util.EditaTabela;
import com.util.ImagemUtil;
import com.util.ItemCabecalho;
import com.util.RendererCelula;
import com.util.SeleniumUtil;

@SuppressWarnings("serial")
public class Player extends JDialog {

	private ICombo combo = new ICombo();
	private final JPanel contentPanel = new JPanel();
	private static Player dialog;
	private JPanel panel;
	private GroupLayout gl_contentPanel;
	private GroupLayout gl_panel;
	private GroupLayout gl_panel_1;
	private GroupLayout gl_panel_2;
	private GroupLayout gl_panel_3;
	private GroupLayout gl_panel_4;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JButton button;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTable table;
	private JTable table_1;
	private DefaultTableModel model;
	private DefaultTableModel model_1;
	private JPanel panel_4;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private final String TABELA = "properties\\value\\";
	private final String VARIAVEL = "properties\\value\\Variavel";
	private EditaTabela edTabela = new EditaTabela();
	private final String caminho = "C:\\Base\\teste";
	private String valor;
	private int tempo;
	private RendererCelula rendere;
	private RendererCelula rendere_1;
	private boolean pause = false;
	private boolean pare = false;
	private int indicador = 0;
	private Thread t;
	private ImagemUtil image = new ImagemUtil();
	private List<Image> evidence = new ArrayList<Image>();;
	private JpSelenium jpselenium = new JpSelenium();
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

		this.rendere = new RendererCelula();
		this.rendere_1 = new RendererCelula();
		this.setModal(true);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(
				Player.class.getResource("/com/image/cpqi.png")));
		this.setBounds(100, 100, 744, 651);
		this.getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);

		this.model = new DefaultTableModel();
		this.model = edTabela.indiceBoolean();
		this.model_1 = new DefaultTableModel();
		this.model_1 = edTabela.setValorTabela(TABELA, "", false);
		this.table = new JTable(this.model);
		this.table.setDefaultRenderer(Object.class, this.rendere_1);

		this.table.getColumnModel().getColumn(2).setMinWidth(0);
		this.table.getColumnModel().getColumn(2).setPreferredWidth(0);
		this.table.getColumnModel().getColumn(2).setMaxWidth(0);

		this.table_1 = new JTable(this.model_1);
		this.table_1.setEnabled(false);
		this.table_1.setDefaultRenderer(Object.class, this.rendere);

		this.scrollPane_1 = new JScrollPane(this.table);

		this.tc = this.table.getColumnModel().getColumn(0);
		this.tc.setCellEditor(this.table.getDefaultEditor(Boolean.class));
		this.tc.setCellRenderer(this.table.getDefaultRenderer(Boolean.class));
		this.tc.setHeaderRenderer(new CabecalhoCheckBox(new ItemCabecalho(
				this.table)));

		this.scrollPane = new JScrollPane(this.table_1);

		this.panel = new JPanel();
		this.panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		this.gl_contentPanel = new GroupLayout(contentPanel);
		this.gl_contentPanel.setHorizontalGroup(this.gl_contentPanel
				.createParallelGroup(Alignment.LEADING).addGroup(
						this.gl_contentPanel
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(this.panel,
										GroupLayout.DEFAULT_SIZE, 698,
										Short.MAX_VALUE).addContainerGap()));
		this.gl_contentPanel.setVerticalGroup(this.gl_contentPanel
				.createParallelGroup(Alignment.LEADING).addGroup(
						Alignment.TRAILING,
						gl_contentPanel
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(this.panel,
										GroupLayout.DEFAULT_SIZE, 581,
										Short.MAX_VALUE).addContainerGap()));

		this.panel_1 = new JPanel();
		this.panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		this.panel_2 = new JPanel();
		this.panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		this.panel_3 = new JPanel();
		this.panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		this.button = new JButton("");
		this.button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		this.button.setIcon(new ImageIcon(Player.class
				.getResource("/com/image/sair.png")));
		this.button.setBackground(Color.WHITE);
		this.gl_panel_3 = new GroupLayout(panel_3);
		this.gl_panel_3.setHorizontalGroup(this.gl_panel_3.createParallelGroup(
				Alignment.TRAILING).addGroup(
				this.gl_panel_3
						.createSequentialGroup()
						.addContainerGap(43, Short.MAX_VALUE)
						.addComponent(this.button, GroupLayout.PREFERRED_SIZE,
								73, GroupLayout.PREFERRED_SIZE).addGap(27)));
		this.gl_panel_3.setVerticalGroup(this.gl_panel_3.createParallelGroup(
				Alignment.LEADING).addGroup(
				this.gl_panel_3
						.createSequentialGroup()
						.addComponent(this.button, GroupLayout.PREFERRED_SIZE,
								54, Short.MAX_VALUE).addGap(1)));
		this.panel_3.setLayout(this.gl_panel_3);

		this.panel_4 = new JPanel();
		this.gl_panel = new GroupLayout(panel);
		this.gl_panel
				.setHorizontalGroup(this.gl_panel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								this.gl_panel
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												this.gl_panel
														.createParallelGroup(
																Alignment.LEADING,
																false)
														.addComponent(
																this.panel_4,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																this.panel_1,
																GroupLayout.DEFAULT_SIZE,
																501,
																Short.MAX_VALUE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												this.gl_panel
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																this.panel_3,
																GroupLayout.DEFAULT_SIZE,
																155,
																Short.MAX_VALUE)
														.addComponent(
																this.panel_2,
																GroupLayout.DEFAULT_SIZE,
																155,
																Short.MAX_VALUE))
										.addContainerGap()));
		this.gl_panel
				.setVerticalGroup(this.gl_panel
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								this.gl_panel
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												this.gl_panel
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																this.panel_1,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																460,
																Short.MAX_VALUE)
														.addComponent(
																this.panel_2,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																460,
																Short.MAX_VALUE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												this.gl_panel
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																this.panel_4,
																GroupLayout.DEFAULT_SIZE,
																80,
																Short.MAX_VALUE)
														.addComponent(
																this.panel_3,
																Alignment.LEADING,
																GroupLayout.PREFERRED_SIZE,
																80,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));

		this.button_2 = new JButton();
		button_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				setPause(false);
				t = new Thread(threadsss);
				t.start();
				button_2.setEnabled(false);
				button_4.setEnabled(true);
				button_3.setEnabled(true);

			}
		});

		this.button_2.setBackground(Color.WHITE);
		this.button_2.setIcon(new ImageIcon(Player.class
				.getResource("/com/image/play_Icon.png")));

		this.button_3 = new JButton();
		this.button_3.setEnabled(false);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (indicador == 0) {
					setPause(true);

					button_2.setEnabled(false);
					button_4.setEnabled(false);
					button_5.setEnabled(true);

					indicador = 1;
				} else {
					setPause(false);

					button_4.setEnabled(true);
					button_3.setEnabled(true);
					button_5.setEnabled(false);
					indicador = 0;
				}

			}
		});
		this.button_3.setBackground(Color.WHITE);
		this.button_3.setIcon(new ImageIcon(Player.class
				.getResource("/com/image/Pause.png")));

		this.button_4 = new JButton();
		this.button_4.setEnabled(false);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setPare(true);
			}
		});
		this.button_4.setBackground(Color.WHITE);
		this.button_4.setIcon(new ImageIcon(Player.class
				.getResource("/com/image/Stop.png")));

		this.button_5 = new JButton();
		this.button_5.setEnabled(false);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (indicador == 1)
					setPause(false);
			}
		});
		this.button_5.setBackground(Color.WHITE);
		this.button_5.setIcon(new ImageIcon(Player.class
				.getResource("/com/image/Avanca.png")));

		this.button_6 = new JButton();
		this.button_6.setIcon(new ImageIcon(Player.class
				.getResource("/com/image/Print.jpg")));
		this.button_6.setBackground(Color.WHITE);
		this.gl_panel_4 = new GroupLayout(this.panel_4);
		gl_panel_4.setHorizontalGroup(gl_panel_4.createParallelGroup(
				Alignment.TRAILING).addGroup(
				gl_panel_4
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 60,
								GroupLayout.PREFERRED_SIZE)
						.addGap(37)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 60,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 37,
								Short.MAX_VALUE)
						.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 60,
								GroupLayout.PREFERRED_SIZE)
						.addGap(33)
						.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 60,
								GroupLayout.PREFERRED_SIZE)
						.addGap(72)
						.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 62,
								GroupLayout.PREFERRED_SIZE).addContainerGap()));
		gl_panel_4
				.setVerticalGroup(gl_panel_4
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_panel_4
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_panel_4
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																button_3,
																GroupLayout.PREFERRED_SIZE,
																58,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																button_4,
																GroupLayout.PREFERRED_SIZE,
																58,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																button_5,
																GroupLayout.PREFERRED_SIZE,
																58,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																button_6,
																GroupLayout.PREFERRED_SIZE,
																50,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																button_2,
																GroupLayout.PREFERRED_SIZE,
																58,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
		this.panel_4.setLayout(this.gl_panel_4);

		this.gl_panel_1 = new GroupLayout(this.panel_1);
		this.gl_panel_1.setHorizontalGroup(this.gl_panel_1.createParallelGroup(
				Alignment.LEADING).addGroup(
				this.gl_panel_1
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(this.scrollPane,
								GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
						.addContainerGap()));
		this.gl_panel_1.setVerticalGroup(this.gl_panel_1.createParallelGroup(
				Alignment.LEADING).addGroup(
				this.gl_panel_1
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(this.scrollPane,
								GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
						.addContainerGap()));
		this.panel_1.setLayout(this.gl_panel_1);

		this.gl_panel_2 = new GroupLayout(panel_2);
		this.gl_panel_2.setHorizontalGroup(this.gl_panel_2.createParallelGroup(
				Alignment.LEADING).addGroup(
				this.gl_panel_2
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(this.scrollPane_1,
								GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
						.addContainerGap()));

		this.gl_panel_2.setVerticalGroup(this.gl_panel_2.createParallelGroup(
				Alignment.LEADING).addGroup(
				this.gl_panel_2
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(this.scrollPane_1,
								GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
						.addContainerGap()));

		this.panel_2.setLayout(this.gl_panel_2);
		this.panel.setLayout(this.gl_panel);
		this.contentPanel.setLayout(this.gl_contentPanel);

		this.table.setDefaultEditor(Object.class, null);
		this.table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					model_1 = edTabela.setValorTabela(TABELA, table.getModel()
							.getValueAt(table.getSelectedRow(), 1).toString(),
							false);
					table_1.setModel(model_1);

					for (int i = 0; i < model_1.getRowCount(); i++) {
						for (int j = 0; j < table.getColumnCount(); j++) {
							rendere.colorirCelula(i, j,
									new Color(255, 255, 255));
						}
					}

				}
			}
		});

	}

	private void setLinha(int linha) {

		this.rendere.colorirCelula(linha, 1, new Color(202, 225, 255));
		this.rendere.colorirCelula(linha, 0, new Color(202, 225, 255));
		this.table_1.validate();
		this.model_1.fireTableDataChanged();

	}

	public Color aCor(String txt) {
		Color nomesCor = null;

		if (txt != null) {
			if (txt.contains("OK")) {
				nomesCor = new Color(51, 204, 0);
			} else if (txt.contains("Erro")) {
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
		return this.table;
	}

	Thread threadsss = new Thread(new Runnable() {

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public void run() {
			try {

				

				for (int j = 0; j < table.getRowCount(); j++) {

					if (table.getValueAt(j, 0).toString().equals("true")) {

						model_1 = edTabela.setValorTabela(TABELA, table
								.getModel().getValueAt(j, 1).toString(), false);

						table_1.setModel(model_1);

						for (int i = 0; i < model_1.getRowCount(); i++)
							for (int c = 0; c < table.getColumnCount(); c++)
								rendere.colorirCelula(i, c, new Color(255, 255,
										255));

						String arquivo = table.getModel().getValueAt(j, 1)
								.toString();

						String[] comandos = edTabela.getTab(TABELA, "User_"
								+ arquivo + ".deb", 0);

						ArrayList[] alvo = edTabela.getAlvo(TABELA, "User_"
								+ arquivo + ".deb", 1, VARIAVEL, 0);

						String[] alvo2 = edTabela.getTab(TABELA, "User_"
								+ arquivo + ".deb", 1);
						
						
						String[] massaDados = edTabela.getTab(TABELA, "User_"
								+ arquivo + ".deb", 2);

						cls = Class.forName("com.selenium.JpSelenium");

						obj = cls.newInstance();

						int tamanho = comandos.length;

						for (int i = 0; i < tamanho; i++) {

							if (getPare()) {
								cls.getDeclaredMethod("tearDown").invoke(obj);
								execucao.stop();
								i = tamanho++;
								break;
							}

							while (getPause())
								Thread.sleep(100);

							if (comandos[i].equals(combo.Combo[1])) {
								cls.getDeclaredMethod("setUp", String.class,String.class).invoke(obj, alvo[i].get(1).toString(),massaDados[i]);
								execucao.start();
							}

							if (comandos[i].equals(combo.Combo[2]))
								Thread.sleep(Integer.parseInt(massaDados[i]));

							if (comandos[i].equals(combo.Combo[3])) {
								Object screen = cls.getDeclaredMethod("testCapture").invoke(obj);
								evidence.add(image.decodeAndWriteScreenshot(screen.toString()));
							}
							
							if(comandos[i].equals(combo.Combo[4])){
								Object valor = cls.getDeclaredMethod("testElemento", ArrayList.class).invoke(obj, alvo[i]);
								setExption(i, valor, alvo2[i]);
								
								if (!valor.toString().equals("Erro"))
									cls.getDeclaredMethod("testClique",String.class).invoke(obj,valor.toString());
								else {
									setExption(i, valor, alvo2[i]);
									cls.getDeclaredMethod("tearDown").invoke(obj);
									execucao.stop();
									break;
								}
							}

							if (comandos[i].equals(combo.Combo[5])) {
								Object valor = cls.getDeclaredMethod("testElemento", ArrayList.class).invoke(obj, alvo[i]);
								setExption(i,valor,alvo2[i]);

								if (!valor.toString().equals("Erro"))
									cls.getDeclaredMethod("testDigite",String.class, String.class).invoke(obj, valor.toString(), massaDados[i]);
								else {
									cls.getDeclaredMethod("tearDown").invoke(obj);
									execucao.stop();
									break;
								}

							}

							if (comandos[i].equals(combo.Combo[6])) {
								cls.getDeclaredMethod("tearDown").invoke(obj);
								execucao.stop();
							}
							
							if (comandos[i].equals(combo.Combo[7])) {
								Object valor = cls.getDeclaredMethod("testTexto", ArrayList.class).invoke(obj , alvo[i]);
								setExption1(i, valor);
									
							}
							
							if (indicador == 1)
								setPause(true);

							setLinha(i);

						}

						if(getExeption().contains("Erro")){
							rendere_1.colorirCelula(j, 0, new Color(255, 60, 21));
							rendere_1.colorirCelula(j, 1, new Color(255, 60, 21));	
							table.validate();
							model.fireTableDataChanged();
						}else{
							rendere_1.colorirCelula(j, 0, new Color(0, 255, 51));
							rendere_1.colorirCelula(j, 1, new Color(0, 255, 51));
							table.validate();
							model.fireTableDataChanged();
						}
						
						table.setValueAt(false, j, 0);
						
						String tempoExecucao = ":"+(int)(execucao.elapsedTime() % 60);

						sUtil.gerarPDF(evidence, arquivo, "", getExeption(), "GoogleChrome",caminho, tempoExecucao);

					}
				}

				button_2.setEnabled(true);
				button_4.setEnabled(false);
				button_3.setEnabled(false);
				button_5.setEnabled(false);

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

		if (valor.toString().equals("Erro")) {
			this.rendere.colorirCelula(linha, 2, new Color(255, 60, 21));
			this.rendere.colorirCelula(linha, 1, new Color(202, 225, 255));
			this.rendere.colorirCelula(linha, 0, new Color(202, 225, 255));
			this.table_1.validate();
			this.model_1.fireTableDataChanged();
			this.execao = "Erro - "+elemento+" nao encontrado...";
		} else {
			this.rendere.colorirCelula(linha, 2, new Color(0, 255, 51));
			this.rendere.colorirCelula(linha, 1, new Color(202, 225, 255));
			this.rendere.colorirCelula(linha, 0, new Color(202, 225, 255));
			this.table_1.validate();
			this.model_1.fireTableDataChanged();
			this.execao = "Teste Realizado com sucesso...";
		}
	}
	private void setExption1(int linha, Object valor) {

		if (!valor.toString().equals("OK")) {
			this.rendere.colorirCelula(linha, 2, new Color(255, 60, 21));
			this.rendere.colorirCelula(linha, 1, new Color(202, 225, 255));
			this.rendere.colorirCelula(linha, 0, new Color(202, 225, 255));
			this.table_1.validate();
			this.model_1.fireTableDataChanged();
			this.execao = "Erro - Item "+valor+" nao encontrado...";
		} else {
			this.rendere.colorirCelula(linha, 2, new Color(0, 255, 51));
			this.rendere.colorirCelula(linha, 1, new Color(202, 225, 255));
			this.rendere.colorirCelula(linha, 0, new Color(202, 225, 255));
			this.table_1.validate();
			this.model_1.fireTableDataChanged();
			this.execao = "Teste Realizado com sucesso...";
		}
	}
}
