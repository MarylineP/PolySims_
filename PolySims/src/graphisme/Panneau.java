package graphisme;


import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import code_source.PolyProf;
import code_source.PolySims;
import code_source.PolyStud;


public class Panneau extends JPanel{
	private PolyProf polyprof ;
	private PolyStud polystud ;
	private PolySims polysim ;
	
	private JTextArea texte ;
	
	private String nom ;
	private String prenom ;
	private String genre ;
	private int age ;
	private String sexe ;
	
	private JButton bouton = new JButton ("Commencer") ;
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
			
	private JPopupMenu popUp ; 
	
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
		String fichier4 = "C:\\Users\\Maryline\\Documents\\Cours_IRM4\\POO\\Projet_Jeux\\Bravo.png";
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
			
			DocumentListener dl2 = new Mon2DocumentListener() ;
			jtfAge.getDocument().addDocumentListener(dl2) ;
		
			ActionListener alSexe = new SexeActionListener() ;
			Homme.addActionListener(alSexe);
			Femme.addActionListener(alSexe);
			
		}
		else if (clic == 2){
			try{
				BufferedImage image4 = ImageIO.read(new File(fichier4)) ;
				g.drawImage(image4, 400, 20, null) ;
			}catch (IOException e){
				e.printStackTrace();
			}
					
			texte = new JTextArea();
			texte.setBounds(300,200,500,200);
			Font fontTexte = new Font("Tahoma", Font.PLAIN, 20) ;
			texte.setFont(fontTexte);
			texte.append("Votre personnage a bien été créé. \n");
			texte.append("\nVous êtes " + genre ) ;
			texte.append("\nVous vous appellez " + nom +" "+ prenom) ;
			texte.append("\nVous avez " + age + " ans" );
			texte.append("\n\nAppuyez sur le bouton Jouer pour commencer la partie !");
			this.add(texte) ;
		}
		else if (clic == 3){
			
		}
	}
	
	/**
	 * 
	 *Classe JouerAction qui permet de définir le nouveau panneau une fois le bouton "Jouer" activé
	 *
	 */
	public class JouerAction implements ActionListener {
		public void actionPerformed(ActionEvent e){	
			if (e.getActionCommand() == "Commencer"){
			clic = 1 ;
			bouton.setText("Valider");
			repaint() ;		
			}
			else if (e.getActionCommand() == "Valider"){
				if (nom != "null" && prenom != "null" && age != 0 && sexe != "null" && genre != "null"){
					clic = 2 ;
					bouton.setText("Jouer");
					jtfNom.setVisible(false);
					jtfPrenom.setVisible(false);
					jtfAge.setVisible(false);
					jlPoly.setVisible(false);
					jlNom.setVisible(false);
					jlPrenom.setVisible(false);
					jlAge.setVisible(false);
					jlSexe.setVisible(false);
					GenreProf.setVisible(false);
					GenreStud.setVisible(false);
					Homme.setVisible(false);
					Femme.setVisible(false);		
					
					repaint() ;
				}
			}
			else if (e.getActionCommand() == "Jouer"){
				clic = 3 ;
				texte.setVisible(false) ;
				repaint () ;
			}
			
		}
	}
	
	
	// Champs Nom et Prenom
	public class MonDocumentListener implements DocumentListener{
	
		public void changedUpdate(DocumentEvent de) {}
		public void insertUpdate(DocumentEvent de) {
			
			polysim = new PolySims() ;
			nom = polysim.getNom(jtfNom.getText());
			prenom = polysim.getPrenom(jtfPrenom.getText());
		}
		public void removeUpdate(DocumentEvent de) {}
	}
	
	// Champ Age
	public class Mon2DocumentListener implements DocumentListener{
		
		public void changedUpdate(DocumentEvent de) {}
		public void insertUpdate(DocumentEvent de) {
			age = polysim.getAge(Integer.parseInt(jtfAge.getText())) ;
		}
		public void removeUpdate(DocumentEvent de) {}
	}
	
	// Bouton Radio genre
	public class PolyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			genre = ae.getActionCommand() ;
			if( genre == "PolyProf"){
				polyprof = new PolyProf() ;
			}
			else if (genre == "PolyStud"){
				polystud = new PolyStud() ;
			}
		}
	}
	
	// Bouton radio sexe
	public class SexeActionListener implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			sexe = ae.getActionCommand() ;
		}
	}
	
}
