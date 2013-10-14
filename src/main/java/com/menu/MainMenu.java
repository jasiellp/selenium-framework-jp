package com.menu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;

import com.core.Main;
import com.inter.IFrame;
import com.player.Player;
import com.variavel.Variaveis;

public class MainMenu implements IFrame{

	private JFrame frame;
	private JPanel painel; 
	private JPanel painel1;
	 
	private JButton botaoCriaCenario;
	private JButton botaoCriaVariaveis; 
	private JButton botaoExecCenario; 
	private JButton botaoSair;
	
	private MainMenuExtencaoLayout extencao;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
					window.frame.setTitle(propriedades.leitor("tdialog003"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 
	public MainMenu() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		initialize();
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	}

	 
	private void initialize() {
		
		this.extencao = new MainMenuExtencaoLayout();
		this.frame = new JFrame();
		this.frame.setIconImage(new  ImageIcon((propriedades.leitor("iconeprincipal"))).getImage());
		this.frame.setBounds(100, 100, 590, 475);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		this.frame.setJMenuBar(menuBar);
		
	    
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("New menu");
		menuBar.add(mnNewMenu_2);
		
		this.painel= new JPanel();
	
		this.painel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		this.painel1 = new JPanel();
		 
		this.botaoCriaCenario = new JButton(new  ImageIcon((propriedades.leitor("iconenovo"))));
		
		this.botaoExecCenario = new JButton(new  ImageIcon((propriedades.leitor("iconeselenium"))));
		
		this.botaoCriaVariaveis = new JButton(new  ImageIcon((propriedades.leitor("iconememoria"))));
			
		this.botaoSair = new JButton(new  ImageIcon((propriedades.leitor("iconesair"))));
		
		this.botaoCriaCenario.setBackground(Color.WHITE);

		this.botaoExecCenario.setBackground(Color.WHITE);

		this.botaoCriaVariaveis.setBackground(Color.WHITE);

		this.botaoSair.setBackground(Color.WHITE);
		 
		this.extencao.parte1(frame, painel);
		
		this.extencao.parte2(painel, painel1);
		
		this.extencao.parte3(frame, painel1, painel, botaoCriaCenario, botaoExecCenario, botaoCriaVariaveis, botaoSair);
		
		
		this.botaoCriaCenario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Main main = new Main();
			main.setTitle(propriedades.leitor("tmodal002"));
			main.setVisible(true);
			
			}
		});
		  
		this.botaoExecCenario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Player ply = new Player();
				ply.setTitle("EXECUTE");
				ply.setVisible(true);
			}
		});
		
		
		this.botaoCriaVariaveis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Variaveis vrv = new Variaveis();
				vrv.setTitle("CRIE VARIAVEIS");
				vrv.setVisible(true);
			}
		});
		
		
		this.botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(100);
			}
		});
		
		
		
	    
	}
}
