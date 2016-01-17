package graphisme;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import code_source.PolyProf;
import code_source.PolyStud;


public class Panneau extends JPanel{
	private JButton bouton = new JButton ("Jouer") ;
	private int clic ;
	
	//Boutons radios
	private JRadioButton GenreProf;
	private JRadioButton GenreStud ;
	private JRadioButton Homme ;
	private JRadioButton Femme ;	
	
	//Groupes boutons radios
	private ButtonGroup groupePoly;
	private ButtonGroup groupeSexe ;
	
	//Champs de texte
	private JTextField jtfNom  ;
	private JTextField jtfPrenom ;
	private JTextField jtfAge ;
	
	//Noms des champs de texte
	private JLabel jlNom ;
	private JLabel jlPrenom ;
	private JLabel jlAge ;
	private JLabel jlPoly ;
	private JLabel jlSexe ;
			
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
			jtfPrenom = new JTextField(10) ;
			jtfAge = new JTextField(2) ;
		
			jtfNom.setBounds(250, 240, 100, 22);
			jtfPrenom.setBounds(250, 280, 100, 22);
			jtfAge.setBounds(250, 320, 30, 22);
			
			//Initialisation des Labels
			jlPoly = new JLabel("Vous êtes :");
			jlNom = new JLabel("Nom :") ;
			jlPrenom = new JLabel("Prénom :") ;
			jlAge = new JLabel("Âge :") ;
			jlSexe = new JLabel("Sexe : ") ;
			
			jlPoly.setBounds(150, 200, 100, 22);
			jlNom.setBounds(150, 240, 40 ,22);
			jlPrenom.setBounds(150, 280, 80 ,22);
			jlAge.setBounds(150, 320, 40 ,22);
			jlSexe.setBounds(150, 360, 40, 22) ;
			
			//Initialisation bouton radio (un choix unique)
			GenreProf = new JRadioButton("un PolyProf");
			GenreStud = new JRadioButton("un PolyStud");
			Homme = new JRadioButton("H");
			Femme = new JRadioButton("F");
			
			GenreProf.setBounds(250, 200, 100 ,22);
			GenreStud.setBounds(350, 200, 100 ,22);
			Homme.setBounds(250, 360, 40, 22) ;
			Femme.setBounds(300, 360, 40, 22);
			
			//Initialisation groupe de bouton pour determiner le choix unique
			groupePoly = new ButtonGroup() ;
			groupeSexe = new ButtonGroup() ;
			
			//Ajout des boutons au groupe
			groupePoly.add(GenreProf);
			groupePoly.add(GenreStud);
			groupeSexe.add(Homme);
			groupeSexe.add(Femme);
			
			//Ajout au panneau
			this.add(jlPoly) ;
			this.add(jlNom) ;
			this.add(jlPrenom) ;
			this.add(jlAge) ;
			this.add(jlSexe) ;
			
			this.add(jtfNom) ;
			this.add(jtfPrenom) ;
			this.add(jtfAge) ;
			
			this.add(GenreProf) ;
			this.add(GenreStud) ;
			this.add(Homme) ;
			this.add(Femme) ;
			
			
			//Listener
			ActionListener alPoly = new PolyActionListener() ;
			GenreProf.addActionListener(alPoly);
			GenreStud.addActionListener(alPoly);
		
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
	
	public class PolyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		}
	}
}
