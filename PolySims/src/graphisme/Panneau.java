package graphisme;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;






public class Panneau extends JPanel{
	private JButton bouton = new JButton ("Jouer") ;
	private int clic ;
	//Champs de texte
			private JTextField jtfNom  ;
			private JTextField jtfPrenom ;
			private JTextField jtfAge ;
			//Nom des champs de texte
			private JLabel jlNom ;
			private JLabel jlPrenom ;
			private JLabel jlAge ;
			//private JLabel jlSexe ;
	
	public Panneau(){
	  		
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.add(bouton) ;
		
        JouerAction ja = new JouerAction() ;
		bouton.addActionListener(ja) ;
		bouton.setBounds(1000,320,140,50);
		
		clic = 0 ;
		
		
	}
	
	
	public void paintComponent(Graphics g){		
		super.paintComponent(g);
	
		String fichier = "C:\\Users\\Maryline\\Documents\\Cours_IRM4\\POO\\Projet_Jeux\\Logo_PolySims2.png";
		String fichier2 = "C:\\Users\\Maryline\\Documents\\Cours_IRM4\\POO\\Projet_Jeux\\Sims4.png";
		String fichier3 = "C:\\Users\\Maryline\\Documents\\Cours_IRM4\\POO\\Projet_Jeux\\Bienvenue.png";
		//System.out.println("dans paintComponent, clic = " + clic) ;
		if(clic == 0){
			try {
				BufferedImage image = ImageIO.read(new File(fichier)) ;
				BufferedImage image2 = ImageIO.read(new File(fichier2)) ;
				g.drawImage(image, 400, 50, null) ;
				g.drawImage(image2, 50, 250, null) ;
			}catch (IOException e){
				e.printStackTrace();
			}
		}
		else if (clic == 1 ){
			try{
				BufferedImage image3 = ImageIO.read(new File(fichier3)) ;
				g.drawImage(image3, 400, 20, null) ;
			}catch (IOException e){
				e.printStackTrace();
			}
			bouton.setText("Valider");
			//Initialisation des champs de texte
			jtfNom = new JTextField(10) ;
			jtfNom.setBounds(220, 200, 100, 22);
			jtfPrenom = new JTextField(10) ;
			jtfPrenom.setBounds(220, 240, 100, 22);
			jtfAge = new JTextField(2) ;
			jtfAge.setBounds(220, 280, 30, 22);
			//Initialisation des Labels
			jlNom = new JLabel("Nom :") ;
			jlNom.setBounds(150, 200, 40 ,22);
			jlPrenom = new JLabel("Prénom :") ;
			jlPrenom.setBounds(150, 240, 80 ,22);
			jlAge = new JLabel("Âge :") ;
			jlAge.setBounds(150, 280, 40 ,22);
			
			
			this.add(jlNom) ;
			this.add(jtfNom) ;
			this.add(jlPrenom) ;
			this.add(jtfPrenom) ;
			this.add(jlAge) ;
			this.add(jtfAge) ;
			
			DocumentListener dl = new MonDocumentListener() ;
			jtfNom.getDocument().addDocumentListener(dl) ;
			jtfPrenom.getDocument().addDocumentListener(dl) ;
			jtfAge.getDocument().addDocumentListener(dl) ;
		}
	}
	
	/**
	 * 
	 *Classe JouerAction qui permet de définir le nouveau panneau une fois le bouton "Jouer" activé
	 *
	 */
	public class JouerAction implements ActionListener {
		public void actionPerformed(ActionEvent e){	
			//System.out.println("bouton activé") ;
			clic = 1 ;
			//System.out.println("dans Listener, clic = " + clic) ;
			repaint() ;			
			
		}
	}

	public class MonDocumentListener implements DocumentListener{
	
		public void changedUpdate(DocumentEvent e) {}
		public void insertUpdate(DocumentEvent e) {
		System.out.println("Mise à jour") ;
		}
		public void removeUpdate(DocumentEvent e) {}
	}

}
