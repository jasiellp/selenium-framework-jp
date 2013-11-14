package com.intulho;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.event.MouseInputAdapter;

import com.util.filtro.imagem.ImageFileView;
import com.util.filtro.imagem.ImageFilter;
import com.util.filtro.imagem.ImagePreview;
import com.util.fonte.FonteEditor;

public class EditorPDF {

	
	
	private static JPanel painel;
	private static JPanel painel1;
	private static JButton botao ;
	private static JButton botao1 ;
	private static JButton botao2 ;
	private static JFrame frame;
	private static JDesktopPane desktop; 
	private static JLabel labelpaleta = new JLabel("Cor de Fundo");
	private static ArrayList<JInternalFrame> frameInterno;
	 
	
	public static void main(final String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		
		frame = new JFrame();
		painel = new JPanel();
	    painel1 = new JPanel();
		botao = new JButton("ADD LOGO");
		botao1= new JButton("COR");
		botao2= new JButton("ADD TITULO");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		desktop = new JDesktopPane();
		frameInterno = new ArrayList<JInternalFrame>();
		desktop.setBackground(new Color(255,255,255));
	 
		desktop.setSize(312, 388);
		painel.add(labelpaleta);
		
		painel.add(botao1);
		painel.add(botao);
		painel.add(botao2);
		painel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,TitledBorder.TOP, null, null));
		painel1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,TitledBorder.TOP, null, null));
		painel.setSize(120, 100);
		painel1.setSize(320, 400);
		frame.add(desktop, BorderLayout.CENTER);
		
		frame.add(painel,BorderLayout.NORTH);
		
		frame.setSize(500, 600);
		frame.setVisible(true);
		
		
		
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				@SuppressWarnings("deprecation")
				int conte_componentes=desktop.countComponents()+1;
				
				frameInterno.add(new FrameInterno((conte_componentes)+"ª Logo", true, false, true, true, new ImageIcon("properties/ico/facebook-logo.jpg").getImage()));
				
				int quantidade = frameInterno.size()-1;
			
				desktop.add(frameInterno.get(quantidade));
				
				frameInterno.get(quantidade).setVisible(true);
				
			}
		});
		
		botao1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				
				JColorChooser jColorChooser1 = new JColorChooser();
				desktop.setBackground(JColorChooser.showDialog(jColorChooser1,"", new Color(222)));
			}
		});
		
		botao2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				
				@SuppressWarnings("deprecation")
				int conte_componentes=desktop.countComponents()+1;
			
				frameInterno.add(new FrameInternoText((conte_componentes)+" ª Titulo", true, false, true, true));
				
				int quantidade = frameInterno.size()-1;
			
				desktop.add(frameInterno.get(quantidade));
				
				frameInterno.get(quantidade).setVisible(true);
			}
		});
		
		
	}

}


class FrameInterno extends JInternalFrame{
	
 
	private static final long serialVersionUID = 2925999692445435324L;

	private JPanel painel = new JPanel(); 
	private JFileChooser fc;  
	private JLabel label1;
	private Image CapturedImage;
	
	
	public FrameInterno(String label, boolean a1,boolean a2,boolean a3,boolean a4, final Image screenCapturedImage){
		
		label1 = new JLabel();
		setResizable(a1);
		setMaximizable(a2);
		setClosable(a3); 
		setTitle(label);
		setBounds(2 * 25, 2 * 25, 200, 120);
		
		label1.setBounds(painel.getBounds());
		painel.setBounds(getBounds());
		painel.add(label1);
		setContentPane(painel);
    
	 
		CapturedImage = new ImageIcon("properties/ico/facebook-logo.jpg").getImage();
		CapturedImage = screenCapturedImage;
		label1.setIcon(new ImageIcon(CapturedImage.getScaledInstance(painel.getBounds().width-24, (painel.getBounds().height-39), painel.getBounds().width)));
		addMouseMotionListener(new MouseInputAdapter()
        {
        	   public void mouseDragged(MouseEvent e)
        	    {
        			 painel.setBounds(getBounds());
        			 label1.setIcon(new ImageIcon(CapturedImage.getScaledInstance(painel.getBounds().width-24, (painel.getBounds().height-39), painel.getBounds().width)));
        	        
        	    }
        });
		
   	 
		painel.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) {
				 
				
				if(e.getButton() == 3)
				{
				     
			        if (fc == null) 
			        {
			            fc = new JFileChooser();
			            fc.addChoosableFileFilter(new ImageFilter());
			            fc.setAcceptAllFileFilterUsed(false);
			            
			            fc.setAccessory(new ImagePreview(fc));
			            fc.checkImage(CapturedImage , null );
			        }


			        int returnVal = fc.showDialog(FrameInterno.this,"Selecione Imagem");

			      
			        if (returnVal == JFileChooser.APPROVE_OPTION) 
			        {
			        	CapturedImage = new ImageIcon( fc.getSelectedFile().getAbsolutePath()).getImage();
			        	label1.setIcon(new ImageIcon(CapturedImage.getScaledInstance(painel.getBounds().width-24, (painel.getBounds().height-39), painel.getBounds().width)));
			 
			        } 
			  
			        fc.setSelectedFile(null);
				}
				 
			}
		});
	
	
		
	}
 
 
} 



class FrameInternoText extends JInternalFrame{
	
 
	private static final long serialVersionUID = 2925999692445435324L;

	private JPanel painel = new JPanel(); 
	private JTextArea texto; 
	private JButton botao_editar; 
	
	
	public FrameInternoText(String titulo, boolean a1,boolean a2,boolean a3,boolean a4){
		
		
		botao_editar = new JButton("EDITAR");
		texto = new JTextArea();
		texto.setColumns(10);
		texto.setFont(new Font("SansSerif", Font.BOLD, 14));
		texto.setForeground(new Color(122));
		setResizable(a1);
		setMaximizable(a2);
		setClosable(a3); 
		setTitle(titulo);
		setBounds(2 * 25, 2 * 25, 200, 120);
		System.out.println(getBounds().height);
	 
		painel.setBounds(getBounds());
		painel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painel.add(texto);
	 
		painel.add(botao_editar,BorderLayout.SOUTH);
		add(painel,BorderLayout.CENTER);
    
		addMouseMotionListener(new MouseInputAdapter()
        {
        	   public void mouseDragged(MouseEvent e)
        	    {
        		   
        		   int l = (getBounds().width/10)/2;
        		   texto.setColumns(l+(l*10/46));
        		   int h = getBounds().height/40;
        		 
        		   texto.setRows(h-1); 
        	    }
        });
		
		botao_editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				FonteEditor fonteeditor = new FonteEditor();
				fonteeditor.setVisible(true);
				texto.setFont(fonteeditor.getFonte());
				texto.setForeground(fonteeditor.getCor());
			}
		});
		
   	}
 
 
} 