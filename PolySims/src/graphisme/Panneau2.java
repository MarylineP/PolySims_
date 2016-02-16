package graphisme;
import polysims.* ;
import professeur.* ;
import etudiant.* ;
import femme.FGbma;
import femme.FInfo;
import femme.FProf;
import homme.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class Panneau2 extends JPanel{
// Attibut pour la mise en route du jeu 
	
	//Bouton 
	private JButton bouton = new JButton ("Valider") ;
	private int clic ;
	
	//Boutons radios 
	private JRadioButton genreProf = new JRadioButton("PolyProf");
	private JRadioButton genreStud = new JRadioButton ("PolyStud");
	private JRadioButton itemInfo  = new JRadioButton("Info") ;
	private JRadioButton itemGbma   = new JRadioButton("Gbma");
	private JRadioButton homme = new JRadioButton("H");
	private JRadioButton femme  = new JRadioButton("F");
		
	//Groupes boutons radios
	private ButtonGroup groupePoly = new ButtonGroup() ;
	private ButtonGroup groupeSexe = new ButtonGroup() ;
	private ButtonGroup groupeFiliere = new ButtonGroup() ;
	private ButtonGroup groupeDeplacer = new ButtonGroup () ;
		
	//Champs de texte
	private JTextField jtfNom  = new JTextField(10) ;
	private JTextField jtfPrenom  = new JTextField(10) ;
	private JTextField jtfAge  = new JTextField(2);
	
	//Noms des champs de texte
	private JLabel jlNom = new JLabel("Nom :") ;
	private JLabel jlPrenom = new JLabel("Prénom :") ;
	private JLabel jlAge = new JLabel("Âge :") ;
	private JLabel jlPoly = new JLabel("Vous êtes un :");
	private JLabel jlSexe = new JLabel("Sexe : ") ;
		
	
	//PopUp pour choix filiere 
	private JPopupMenu popUpFiliere= new JPopupMenu();  
	
	//Listener du formulaire
	private ActionListener alPoly = new PolyActionListener() ;
	private ActionListener alFiliere = new FiliereActionListener() ;
	private DocumentListener dl = new MonDocumentListener() ;
	private DocumentListener dl2 = new Mon2DocumentListener() ;
	private ActionListener alSexe = new SexeActionListener() ;
	
	//création des polysims
	private HProf hProf ;
	private FProf fProf ;
	private FInfo fInfo ;
	private HInfo hInfo ;
	private FGbma fGbma ;
	private HGbma hGbma ;

	//Champs de texte creation Sims
	private JTextArea texte = new JTextArea();
	private Font fontTexte = new Font("Tahoma", Font.PLAIN, 20) ;
	
	//Récuperer valeur champs
	private String nomP ;
	private String prenomP ;
	private String genre ;
	private int ageP ;
	private String sexe ;
	private String filiere ;
	
	
	
// Attributs pour le jeu 
	
	// Texte 
	private JTextArea desc = new JTextArea() ;		//Description personnage sous image 
	private JTextArea question = new JTextArea() ;
	private Font fontTexteQ = new Font("Tahoma", Font.PLAIN, 25) ;	//Question pour action
	
	//Bouton pour réaliser des actoins
	private JButton boutonDormir = new JButton("Dormir");
	private JButton boutonDoucher= new JButton("Se doucher")  ;
	private JButton boutonBesoin  = new JButton("Aller au toilette");
	private JButton boutonCommuniquer= new JButton("Communiquer") ; ;
	private JButton boutonCommuniquerRigoler ;
	private JButton boutonCommuniquerParler ;
	private JButton boutonCommuniquerCritiquer ;
	private JButton boutonCommuniquerEngueuler ;
	private JButton boutonCommuniquerReproduire ;
	private JButton boutonManger  = new JButton("Manger") ;
	private JButton boutonMangerBoisson ;
	private JButton boutonMangerGouter ;
	private JButton boutonMangerRepas ;
	private JButton boutonDeplacer = new JButton("Se déplacer");
	private JButton boutonDeplacerEcole = new JButton("Ecole");
	private JButton boutonDeplacerSoiree = new JButton("Soirée") ;
	private JButton boutonDeplacerMaison ;
	private JButton boutonAllerCours = new JButton ("Aller en cours") ;
	private JButton boutonAllerTravailler= new JButton("Donner des cours") ;
	private JButton boutonFaireDevoirs = new JButton ("Faire devoirs");
	private JButton boutonCorrigerCopies  = new JButton("Corriger copies");
	private JButton boutonImpliquerClubPolyHack = new JButton ("Aider PolyHack");
	private JButton boutonImpliquerClubPompom = new JButton ("S'impliquer au \n club Pompom ");
	private JButton boutonRaser = new JButton("Se raser") ; ;
	private JButton boutonMaquiller = new JButton ("Se maquiller") ;
	private JButton boutonTomberEnceinte = new JButton ("Tomber enceinte");

	//Listeners des boutons Actions
	private dormirAction dormira = new dormirAction() ;
	private besoinAction besoina = new besoinAction() ;
	private doucherAction douchera = new doucherAction() ;
	private mangerAction mangera = new mangerAction() ;
	private deplacerAction deplacera = new deplacerAction() ;
	
	private JTextArea jauge = new JTextArea () ;
	private String deplacerS ;
	private String lieu;
	
	
	public Panneau2(){
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.add(bouton) ;
        JouerAction ja = new JouerAction() ;
		bouton.addActionListener(ja) ;
		bouton.setBounds(1000,320,140,50);
		clic = 0 ;		
	}

	public int getClicP(){
		return clic ;
	}
	
	
	
	public void paintComponent(Graphics g){		
		super.paintComponent(g);

		String fBienvenue = "C:\\Users\\Maryline\\Documents\\Cours_IRM4A\\POO\\Projet_Jeux\\Bienvenue.png";
		String fBravo = "C:\\Users\\Maryline\\Documents\\Cours_IRM4A\\POO\\Projet_Jeux\\Bravo.png";
		if (clic == 0 ){
			try{
				BufferedImage iBienvenue = ImageIO.read(new File(fBienvenue)) ;
				g.drawImage(iBienvenue, 450, 20, null) ;
			}catch (IOException e){
				e.printStackTrace();
			}
			
			jtfNom.setBounds(250, 240, 100, 22);
			jtfPrenom.setBounds(250, 280, 100, 22);
			jtfAge.setBounds(250, 320, 30, 22);
			
			jlPoly.setBounds(150, 200, 100, 22);
			jlNom.setBounds(150, 240, 40 ,22);
			jlPrenom.setBounds(150, 280, 80 ,22);
			jlAge.setBounds(150, 320, 40 ,22);
			jlSexe.setBounds(150, 360, 40, 22) ;
			
			genreProf.setBounds(250, 200, 100 ,22);
			genreStud.setBounds(350, 200, 100 ,22);
			homme.setBounds(250, 360, 40, 22) ;
			femme.setBounds(300, 360, 40, 22);
			
			//Initialisation de la popUp filiere
			popUpFiliere.add(itemInfo, BorderLayout.EAST);
			popUpFiliere.add(itemGbma, BorderLayout.WEST) ;
	
			//Ajout des boutons au groupe
			groupePoly.add(genreProf);
			groupePoly.add(genreStud);
			groupeFiliere.add(itemInfo);
			groupeFiliere.add(itemGbma) ;
			groupeSexe.add(homme);
			groupeSexe.add(femme);
			
			//Ajout au panneau
			this.add(jlPoly) ;
			this.add(jlNom) ;
			this.add(jlPrenom) ;
			this.add(jlAge) ;
			this.add(jlSexe) ;
			this.add(jtfNom) ;
			this.add(jtfPrenom) ;
			this.add(jtfAge) ;
			this.add(genreProf) ;
			this.add(genreStud) ;
			this.add(homme) ;
			this.add(femme) ;
			this.add(popUpFiliere) ;
			
			//AJout des Listeners aux champs du formulaire
			genreProf.addActionListener(alPoly);
			genreStud.addActionListener(alPoly) ;
			itemInfo.addActionListener(alFiliere);
			itemGbma.addActionListener(alFiliere);
			jtfNom.getDocument().addDocumentListener(dl) ;
			jtfPrenom.getDocument().addDocumentListener(dl) ;
			jtfAge.getDocument().addDocumentListener(dl2) ;
			homme.addActionListener(alSexe);
			femme.addActionListener(alSexe);
			
		}
		else if (clic == 1){
			try{
				BufferedImage iBravo = ImageIO.read(new File(fBravo)) ;
				g.drawImage(iBravo, 500, 20, null) ;
			}catch (IOException e){
				e.printStackTrace();
			}
			texte.setBounds(300,250,500,200);
			texte.setFont(fontTexte);
			texte.append("Votre personnage a bien été créé. \n");
			texte.append("\nVous êtes " + genre ) ;
			texte.append("\nVous vous appellez " + nomP +" "+ prenomP) ;
			texte.append("\nVous avez " + ageP + " ans" );
			texte.append("\n\nAppuyez sur le bouton Jouer pour commencer la partie !");
			this.add(texte) ;	
		}
		
		//Clic sur commencer
		else if (clic == 2 ){
			//Affichage nom + Prénom + Age sous la photo
			desc.setBounds(100, 480, 200, 200) ;
			desc.setText(nomP + " " + prenomP + "\n" + genre + " - " + ageP + " ans");
			this.add(desc) ;		
			
			// Phrase "Que voulez-vous faire ?"
			question.setFont(fontTexteQ);
			question.setBounds(400, 180, 300, 50) ;
			question.setText("Que voulez-vous faire ?") ;
			this.add(question) ;
			
			boutonBesoin.setBounds(400,280,140,30);
			boutonManger.setBounds(550,240,140,30);
			boutonDeplacer.setBounds(550,280,140,30);
			
			add(boutonManger) ;
			add(boutonBesoin) ;
			add(boutonDeplacer) ;
			
			//Ajout des listeners aux boutons action dans Maison
			boutonManger.addActionListener(mangera) ;
			boutonManger.addActionListener(deplacera) ;
			boutonDeplacer.addActionListener(deplacera) ;
			boutonBesoin.addActionListener(besoina) ;
			boutonBesoin.addActionListener(deplacera) ;
			
			if( deplacerS !="Se déplacer") {
				boutonDeplacerSoiree.setVisible(false);
				boutonDeplacerEcole.setVisible(false);
			}
			else if (deplacerS == "Se déplacer"){
				boutonDeplacerSoiree.setVisible(true);
				boutonDeplacerEcole.setVisible(true);
			}
			
			if(genre == "PolyProf" ){	
				if (sexe == "H" ){	
					String fichierProfH = "C:\\Users\\Maryline\\Documents\\Cours_IRM4A\\POO\\Projet_Jeux\\ProfH.png";
					try {
						BufferedImage imageProfH = ImageIO.read(new File(fichierProfH)) ;
						g.drawImage(imageProfH, 20, 150, null) ;
					}catch (IOException e){
						e.printStackTrace();
					}
					jauge.setText("Energie : "+ hProf.getEn() +"    Hygiene :"+ hProf.getHy() +"    Besoins :"+ hProf.getBe()+
							"    Appetit :"+hProf.getAp()+"   Social: "+hProf.getSo()+"    Travail :"+hProf.getTr());	
				}
				else if (sexe == "F"){
					String fichierProfF = "C:\\Users\\Maryline\\Documents\\Cours_IRM4A\\POO\\Projet_Jeux\\ProfF.jpg";
					try {
						BufferedImage imageProfF = ImageIO.read(new File(fichierProfF)) ;
						g.drawImage(imageProfF, 20, 150, null) ;
					}catch (IOException e){
						e.printStackTrace();
					}
					jauge.setText("Energie : "+ fProf.getEn() +"    Hygiene :"+ fProf.getHy() +"    Besoins :"+ fProf.getBe()+
						"    Appetit :"+fProf.getAp()+"   Social: "+fProf.getSo()+"    Travail :"+fProf.getTr());					
				}
			}
			else if (genre == "PolyStud"){
					if (filiere =="Info" && sexe == "H"){
						String fichierInfoH = "C:\\Users\\Maryline\\Documents\\Cours_IRM4A\\POO\\Projet_Jeux\\StudInfoH.png";
						try {
							BufferedImage imageInfoH = ImageIO.read(new File(fichierInfoH)) ;
							g.drawImage(imageInfoH, 20, 150, null) ;
						}catch (IOException e){
							e.printStackTrace();
						}
						jauge.setText("Energie : "+ hInfo.getEn() +"    Hygiene :"+ hInfo.getHy() +"    Besoins :"+ hInfo.getBe()+
								"    Appetit :"+hInfo.getAp()+"   Social: "+hInfo.getSo()+"    Travail :"+hInfo.getTr());					
					}
					else if (filiere == "Info" &&sexe == "F"){
						String fichierInfoF = "C:\\Users\\Maryline\\Documents\\Cours_IRM4A\\POO\\Projet_Jeux\\StudInfoF.png";
						try {
						BufferedImage imageInfoF = ImageIO.read(new File(fichierInfoF)) ;
						g.drawImage(imageInfoF, 20, 150, null) ;
						}catch (IOException e){
							e.printStackTrace();
						}
						jauge.setText("Energie : "+ fInfo.getEn() +"    Hygiene :"+ fInfo.getHy() +"    Besoins :"+ fInfo.getBe()+
								"    Appetit :"+fInfo.getAp()+"   Social: "+fInfo.getSo()+"    Travail :"+fInfo.getTr());					
					}
					else if (filiere =="Gbma" && sexe =="H"){
						String fichierGbmaH = "C:\\Users\\Maryline\\Documents\\Cours_IRM4A\\POO\\Projet_Jeux\\StudGbmaH.png";
						try {
							BufferedImage imageGbmaH = ImageIO.read(new File(fichierGbmaH)) ;
							g.drawImage(imageGbmaH, 20, 150, null) ;
						}catch (IOException e){
							e.printStackTrace();
						}
						jauge.setText("Energie : "+ hGbma.getEn() +"    Hygiene :"+ hGbma.getHy() +"    Besoins :"+ hGbma.getBe()+
								"    Appetit :"+hGbma.getAp()+"   Social: "+hGbma.getSo()+"    Travail :"+hGbma.getTr());
					}
					else if (filiere=="Gbma" && sexe == "F"){
						String fichierGbmaF = "C:\\Users\\Maryline\\Documents\\Cours_IRM4A\\POO\\Projet_Jeux\\StudGbmaF.png";
						try {
							BufferedImage imageGbmaF = ImageIO.read(new File(fichierGbmaF)) ;
							g.drawImage(imageGbmaF, 20, 150, null) ;
						}catch (IOException e){
							e.printStackTrace();
						}
						jauge.setText("Energie : "+ fGbma.getEn() +"    Hygiene :"+ fGbma.getHy() +"    Besoins :"+ fGbma.getBe()+
								"    Appetit :"+fGbma.getAp()+"   Social: "+fGbma.getSo()+"    Travail :"+fGbma.getTr());
					}
			}
			jauge.setBounds(450, 600, 600, 100);
			add(jauge) ;
			
			if (lieu=="maison"){
				//Affichage titre 
				String maison = "C:\\Users\\Maryline\\Documents\\Cours_IRM4A\\POO\\Projet_Jeux\\maison.png";
				try {
					BufferedImage texteMaison = ImageIO.read(new File(maison)) ;
					g.drawImage(texteMaison, 500, 20, null) ;
				}catch (IOException e){
					e.printStackTrace();
				}
				//Affichage icone
				String iconeMaison = "C:\\Users\\Maryline\\Documents\\Cours_IRM4A\\POO\\Projet_Jeux\\icone_maison.png";
				try {
					BufferedImage iconeM = ImageIO.read(new File(iconeMaison)) ;
					g.drawImage(iconeM, 800, 25, null) ;
				}catch (IOException e){
					e.printStackTrace();
				}
			
				boutonDormir.setBounds(400,240,140,30);
				boutonDoucher.setBounds(400,320,140,30) ;
				boutonDeplacerEcole.setBounds(700,280,140,30);
				boutonDeplacerSoiree.setBounds(850,280,140,30);
			
				add(boutonDormir) ;
				add(boutonDoucher) ;
				add(boutonDeplacerEcole) ;
				add(boutonDeplacerSoiree) ;			
			
			//Listener pour action bouton
				boutonDormir.addActionListener(dormira) ;
				boutonDormir.addActionListener(deplacera) ;
				boutonDoucher.addActionListener(douchera) ;
				boutonDoucher.addActionListener(deplacera) ;
				
			 
				if(genre == "PolyProf" ){	
					boutonCorrigerCopies.setBounds(550,360,140,30);
					this.add(boutonCorrigerCopies);
				}
				else if (genre == "PolyStud"){
					boutonFaireDevoirs.setBounds(550,360,140,30);
					this.add(boutonFaireDevoirs);
				}	
				if (sexe == "H" ){	
					boutonRaser.setBounds(400,360,140,30);
					add(boutonRaser) ;
				}
				else if (sexe == "F"){
					boutonMaquiller.setBounds(400,360,140,30);
					add(boutonMaquiller) ;
				}
			}			
			else if (lieu=="Maison"){
				//Affichage titre 
				String ecole = "C:\\Users\\Maryline\\Documents\\Cours_IRM4A\\POO\\Projet_Jeux\\ecole.png";
				try {
					BufferedImage texteEcole = ImageIO.read(new File(ecole)) ;
					g.drawImage(texteEcole, 500, 20, null) ;
				}catch (IOException e){
					e.printStackTrace();
				}
				//Affichage icone
				String iconeEcole = "C:\\Users\\Maryline\\Documents\\Cours_IRM4A\\POO\\Projet_Jeux\\icone_ecole.jpg";
				try {
					BufferedImage iconeE = ImageIO.read(new File(iconeEcole)) ;
					g.drawImage(iconeE, 750, 25, null) ;
				}catch (IOException e){
					e.printStackTrace();
				}

				if(genre == "PolyProf" ){	
					boutonAllerTravailler.setBounds(400,240,140,30);
					add(boutonAllerTravailler) ;
				}
				else if (genre == "PolyStud"){
					boutonAllerCours.setBounds(400,240,140,30);
					add(boutonAllerCours) ;	
				}
			}
			else if (lieu=="Maion"){
				//Affichage titre 
				String soiree = "C:\\Users\\Maryline\\Documents\\Cours_IRM4A\\POO\\Projet_Jeux\\soiree.png";
				try {
					BufferedImage texteSoiree = ImageIO.read(new File(soiree)) ;
					g.drawImage(texteSoiree, 500, 20, null) ;
				}catch (IOException e){
					e.printStackTrace();
				}
				//Affichage icone
				String iconeSoiree = "C:\\Users\\Maryline\\Documents\\Cours_IRM4A\\POO\\Projet_Jeux\\icone_soiree.jpg";
				try {
					BufferedImage iconeS = ImageIO.read(new File(iconeSoiree)) ;
					g.drawImage(iconeS, 800, 25, null) ;
				}catch (IOException e){
					e.printStackTrace();
				}
			
				boutonCommuniquer.setBounds(400,240,140,30);
				add(boutonCommuniquer) ;
				if (filiere == "Info"){
					 boutonImpliquerClubPolyHack.setBounds(400,360,140,30);
					add(boutonImpliquerClubPolyHack) ;
				}
				else if (filiere == "Gbma"){
					 boutonImpliquerClubPompom.setBounds(400,360,140,30);
					add(boutonImpliquerClubPompom) ;
				}
				if (sexe == "F"){
					boutonTomberEnceinte.setBounds(400,320,140,30);
					add(boutonTomberEnceinte) ;
				}			
			
			}
		}	
}	

	
	/**
	 * 
	 *Classe JouerAction qui permet de définir le nouveau panneau une fois le bouton "Jouer" activé
	 *
	 */
	public class JouerAction implements ActionListener {
		public void actionPerformed(ActionEvent e){	
			if (e.getActionCommand() == "Valider"){
				if (nomP != "null" && prenomP != "null" && ageP != 0 && sexe != "null" && genre != "null"){
					clic = 1 ;
					bouton.setText("Jouer");
					jtfNom.setVisible(false);
					jtfPrenom.setVisible(false);
					jtfAge.setVisible(false);
					jlPoly.setVisible(false);
					jlNom.setVisible(false);
					jlPrenom.setVisible(false);
					jlAge.setVisible(false);
					jlSexe.setVisible(false);
					genreProf.setVisible(false);
					genreStud.setVisible(false);
					popUpFiliere.setVisible(false);
					homme.setVisible(false);
					femme.setVisible(false);		
					
					repaint() ;
				}
			}
			else if (e.getActionCommand() == "Jouer"){
				clic = 2 ;
				texte.setVisible(false) ;
				bouton.setVisible(false);	
				if (genre =="PolyProf" && sexe=="H"){
					hProf = new HProf() ;
					hProf.setNom(nomP) ;
					hProf.setPrenom(prenomP) ;
					hProf.setAge(ageP) ;
					lieu = hProf.get_lieu() ;
				}
				else if (genre =="PolyProf" && sexe=="F"){
					fProf = new FProf() ;
					fProf.setNom(nomP) ;
					fProf.setPrenom(prenomP) ;
					fProf.setAge(ageP) ;
					lieu = fProf.get_lieu() ;
				}
				else if (genre =="PolyStud" && filiere=="Info" && sexe=="H"){
					hInfo = new HInfo() ;
					hInfo.setNom(nomP) ;
					hInfo.setPrenom(prenomP) ;
					hInfo.setAge(ageP) ;
					lieu = hInfo.get_lieu() ;
				}
				else if (genre =="PolyStud" && filiere=="Info" && sexe=="F"){
					fInfo = new FInfo() ;
					fInfo.setNom(nomP) ;
					fInfo.setPrenom(prenomP) ;
					fInfo.setAge(ageP) ;
					lieu = fInfo.get_lieu() ;
				}
				else if (genre =="PolyStud" && filiere=="Gbma" && sexe=="H"){
					hGbma = new HGbma() ;
					hGbma.setNom(nomP) ;
					hGbma.setPrenom(prenomP) ;
					hGbma.setAge(ageP) ;
					lieu = hGbma.get_lieu() ;
				}
				else if (genre =="PolyStud" && filiere=="Gbma" && sexe=="F"){
					fGbma = new FGbma() ;
					fGbma.setNom(nomP) ;
					fGbma.setPrenom(prenomP) ;
					fGbma.setAge(ageP) ;
					lieu = fGbma.get_lieu() ;
				}
				repaint () ;	
			}	
		}
	}
	
	// Champs Nom et Prenom
	public class MonDocumentListener implements DocumentListener{
		public void changedUpdate(DocumentEvent de) {}
		public void insertUpdate(DocumentEvent de) {
			nomP = jtfNom.getText() ;
			prenomP =jtfPrenom.getText() ;
		}
		public void removeUpdate(DocumentEvent de) {}
	} 
	
	// Champ Age
	public class Mon2DocumentListener implements DocumentListener{
		public void changedUpdate(DocumentEvent de) {}
		public void insertUpdate(DocumentEvent de) {
			ageP = Integer.parseInt(jtfAge.getText()) ;
		}
		public void removeUpdate(DocumentEvent de) {}
	}
	
	// Bouton Radio genre
	public class PolyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			genre = ae.getActionCommand() ;
			if(genre == "PolyStud"){
				popUpFiliere.setVisible(true);
				popUpFiliere.setLocation(480, 240);
			}
			else 
				popUpFiliere.setVisible(false); ;
		}
	}
	
	//Bouton radio filiere
	public class FiliereActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			filiere = ae.getActionCommand();
			
		}
	}
		
	// Bouton radio sexe
	public class SexeActionListener implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			sexe = ae.getActionCommand() ;
			
		}
	}
	
//Listener Boutons Actions 	
	// Bouton dormir
		public class dormirAction implements ActionListener{
			public void actionPerformed(ActionEvent dorae) {
				if (dorae.getActionCommand() == "Dormir"){
					if (genre == "PolyProf" && sexe == "H"){
						hProf.dormir();
						repaint() ;
					}
					else if (genre == "PolyProf" && sexe == "F"){
						fProf.dormir();
						repaint() ;
					}
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "H"){
						hInfo.dormir();
						repaint() ;
					}
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "F"){
						fInfo.dormir();
						repaint() ;
					}
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "H"){
						hGbma.dormir();
						repaint() ;
					}
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "F"){
						fGbma.dormir();
						repaint() ;
					}
				}
			}
		}
		
		// Bouton manger
		public class mangerAction implements ActionListener{
			public void actionPerformed(ActionEvent manae) {		
			}
		}

		// Bouton besoin
		public class besoinAction implements ActionListener{
			public void actionPerformed(ActionEvent besae) {
				if (besae.getActionCommand() == "Aller au toilette"){
					if (genre == "PolyProf" && sexe == "H"){
						hProf.allerToilette();
						repaint() ;
					}
					else if (genre == "PolyProf" && sexe == "F"){
						fProf.allerToilette();
						repaint() ;
					}
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "H"){
						hInfo.allerToilette();
						repaint() ;
					}
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "F"){
						fInfo.allerToilette();
						repaint() ;
					}
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "H"){
						hGbma.allerToilette();
						repaint() ;
					}
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "F"){
						fGbma.allerToilette();
						repaint() ;
					}
				}
			}
		}
			
		// Bouton doucher
		public class doucherAction implements ActionListener{
			public void actionPerformed(ActionEvent douae) {
				if (douae.getActionCommand() == "Se doucher"){
					if (genre == "PolyProf" && sexe == "H"){
						hProf.seDoucher();
						repaint() ;
					}
					else if (genre == "PolyProf" && sexe == "F"){
						fProf.seDoucher();
						repaint() ;
					}
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "H"){
						hInfo.seDoucher();
						repaint() ;
					}
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "F"){
						fInfo.seDoucher();
						repaint() ;
					}
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "H"){
						hGbma.seDoucher();
						repaint() ;
					}
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "F"){
						fGbma.seDoucher();
						repaint() ;
					}
				}
			}
		}
		
		// Bouton deplacer
			public class deplacerAction implements ActionListener{
				public void actionPerformed(ActionEvent depae) {
					deplacerS = depae.getActionCommand() ;
					repaint() ;
				}
			}
			
		// Bouton raser
		public class raserAction implements ActionListener{
			public void actionPerformed(ActionEvent rasae) {
				if (rasae.getActionCommand() == "Se raser"){
					if(genre == "PolyProf" && sexe=="H"){
						hProf.seRaser();
						repaint() ;
					}
				else if (genre == "PolyStud" && filiere == "Info" && sexe == "H"){
						hInfo.seRaser();
						repaint() ;
					}
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "H"){
						hGbma.seRaser();
						repaint() ;
					}
				}
			}
		}
		
		// Bouton aller travailler
		public class allerTravaillerAction implements ActionListener{
			public void actionPerformed(ActionEvent travae) {
				if (travae.getActionCommand() == "Aller travailler"){
					if (genre == "PolyProf" && sexe == "H"){
						hProf.allerTravailler();
						repaint() ;
					}
					//else if (genre == "PolyStud" && filiere == "Info" && sexe == "H")
				}
			}
		}
		//Bouton courriger copies
		public class corrigerCopiesAction implements ActionListener{
			public void actionPerformed(ActionEvent corrigecopiesae){
				if(corrigecopiesae.getActionCommand() == "Corriger copies"){
				
				}
			}
			
		}
		
}
