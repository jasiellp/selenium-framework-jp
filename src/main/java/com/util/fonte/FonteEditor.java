package com.util.fonte;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class FonteEditor extends JDialog {

 
	private static final long serialVersionUID = -7513639104775892517L;
	private final JPanel contentPanel = new JPanel();
	private JButton botaoOk;
	private JButton botaoCancela;
	private JPanel painelBotoes;
	private JLabel labelFonte;
	private JLabel labelTamanho;
	private	JLabel labelTipo;
	private JLabel labelExemplo;
	private JComboBox<String> comboBoxFonte;
	private JComboBox<String> comboBoxTamanho;
	private JComboBox<String> comboBoxTipo; 
	private JPanel painel; 
	
	private Color cor;
	private Font fonte;
	
	private GroupLayout gl_painelBotoes;
	private GroupLayout gl_contentPanel;
	private GroupLayout gl_painel; 
	
	private String[] families = {"Monospaced","SansSerif","Serif"};
	
	private String[] fontes = {"Courier" , "Helvetica","TimesRoman" };
		  
    private int[] styles = { Font.ITALIC, Font.BOLD, (Font.ITALIC + Font.BOLD), Font.PLAIN};

    private String[] stylenames = { "Italico", "Negrito", "Negrito Italico", "Simples" };
	
    private String[] tamanho = {"09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25"};
   
	public static void main(String[] args) {
		try {	
			FonteEditor dialog = new FonteEditor();
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setResizable(false);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	 
	public FonteEditor() {
		
		this.setModal(true);
		//this.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		
		setBounds(100, 100, 534, 224);
		
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		  painel = new JPanel();
		{
			painelBotoes = new JPanel();
			{
				botaoOk = new JButton("OK");
				botaoOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setFonte();
						dispose();
					}
				});
				botaoOk.setActionCommand("OK");
				getRootPane().setDefaultButton(botaoOk);
				
			}
			painelBotoes.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,TitledBorder.TOP, null, null));
			
			{
				botaoCancela = new JButton("Cancel");
				botaoCancela.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				botaoCancela.setActionCommand("Cancel");
			}
		   gl_painelBotoes = new GroupLayout(painelBotoes);
		   gl_painelBotoes.setHorizontalGroup(
		   	gl_painelBotoes.createParallelGroup(Alignment.TRAILING)
		   		.addGroup(gl_painelBotoes.createSequentialGroup()
		   			.addContainerGap(270, Short.MAX_VALUE)
		   			.addComponent(botaoOk)
		   			.addGap(5)
		   			.addComponent(botaoCancela)
		   			.addContainerGap())
		   );
		   gl_painelBotoes.setVerticalGroup(
		   	gl_painelBotoes.createParallelGroup(Alignment.LEADING)
		   		.addGroup(gl_painelBotoes.createSequentialGroup()
		   			.addGroup(gl_painelBotoes.createParallelGroup(Alignment.LEADING)
		   				.addComponent(botaoOk)
		   				.addComponent(botaoCancela))
		   			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		   );
			painelBotoes.setLayout(gl_painelBotoes);
		}
		painel.setBorder(new TitledBorder(null, "Editor Fonte", TitledBorder.LEADING,TitledBorder.TOP, null, null));
		gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(painelBotoes, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
						.addComponent(painel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(painel, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(painelBotoes, GroupLayout.PREFERRED_SIZE, 37, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		labelFonte = new JLabel("Fonte:");
		
		labelTamanho = new JLabel("Tamanho:");
		
		labelTipo = new JLabel("Tipo:");
		
		labelExemplo = new JLabel("Exemplo de texto");
		
		comboBoxFonte = new JComboBox<String>(fontes);
		comboBoxFonte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setFonte();
			}
		});
		
		comboBoxTamanho = new JComboBox<String>(tamanho);
		comboBoxTamanho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setFonte();
			}
		});
		 
		comboBoxTipo = new JComboBox<String>(stylenames);
		comboBoxTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setFonte();
				
			}
		});
		
		JButton btnCor = new JButton("Cor");
		btnCor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JColorChooser jColorChooser1 = new JColorChooser();
				Color cor1 = JColorChooser.showDialog(jColorChooser1,"", new Color(222));
				 labelExemplo.setForeground(cor1);
				 setCor(cor1);
			}
		});
		
		JButton btnCorFundo = new JButton("Cor Fundo");
		btnCorFundo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JColorChooser jColorChooser1 = new JColorChooser();
				Color cor1 = JColorChooser.showDialog(jColorChooser1,"", new Color(222));
				 labelExemplo.setBackground(new Color(222));
			}
		});
		
		gl_painel = new GroupLayout(painel);
		gl_painel.setHorizontalGroup(
			gl_painel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelFonte)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_painel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_painel.createSequentialGroup()
							.addComponent(comboBoxFonte, 0, 181, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(labelTamanho)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBoxTamanho, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(labelTipo)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBoxTipo, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_painel.createSequentialGroup()
							.addComponent(labelExemplo, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_painel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnCor, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnCorFundo, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_painel.setVerticalGroup(
			gl_painel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel.createSequentialGroup()
					.addGroup(gl_painel.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelFonte)
						.addComponent(comboBoxFonte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelTipo)
						.addComponent(comboBoxTamanho, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelTamanho))
					.addGroup(gl_painel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painel.createSequentialGroup()
							.addGap(18)
							.addComponent(labelExemplo, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_painel.createSequentialGroup()
							.addGap(6)
							.addComponent(btnCor)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCorFundo)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		painel.setLayout(gl_painel);
		contentPanel.setLayout(gl_contentPanel);
		setFonte();
	}
	
	public void setFonte(){
		int f = comboBoxFonte.getSelectedIndex();
		int s = comboBoxTipo.getSelectedIndex();
	 	labelExemplo.setFont(new Font(families[f], styles[s], Integer.parseInt(comboBoxTamanho.getSelectedItem().toString())));
	 	this.setFonte(new Font(families[f], styles[s], Integer.parseInt(comboBoxTamanho.getSelectedItem().toString())));
	}
	
	public void setFonteDefalt(){
		int f = comboBoxFonte.getSelectedIndex();
		int s = comboBoxTipo.getSelectedIndex();
	 	labelExemplo.setFont(new Font(families[f], styles[s], Integer.parseInt(comboBoxTamanho.getSelectedItem().toString())));
	 	this.setFonte(new Font(families[f], styles[s], Integer.parseInt(comboBoxTamanho.getSelectedItem().toString())));
	}
	
	
	private void setFonte(Font fonte){
		this.fonte = fonte;
	}
	
	private void setCor(Color cor){
		this.cor = cor;
	} 
	
	public Font getFonte(){
		return this.fonte;
	}
	
	public  Color getCor(){
		return this.cor;
	}
	
	
}
