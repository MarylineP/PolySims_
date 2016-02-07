package graphisme;


import java.awt.BorderLayout;
import java.awt.Color;
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

import code_source.FGbma;
import code_source.FInfo;
import code_source.FProf;
import code_source.HGbma;
import code_source.HInfo;
import code_source.HProf;
import code_source.PolyProf;
import code_source.PolySims;
import code_source.PolyStud;


public class Panneau extends JPanel{
// Attibut pour la mise en route du jeu 
	
	//création des polysims
	private PolySims polysim ;
	private PolyProf prof ;
	private PolyStud stud ;
	private HProf hProf ;
	private FProf fProf ;
	private FInfo fInfo ;
	private HInfo hInfo ;
	private FGbma fGbma ;
	private HGbma hGbma ;

	//Champs de texte creation Sims
	private JTextArea texte ;
	
	//Récuperer valeur champs
	private String nomP ;
	private String prenomP ;
	private String genre ;
	private int ageP ;
	private String sexe ;
	private String filiere ;
	
	//Bouton 
	private JButton bouton = new JButton ("Commencer") ;
	private int clic ;
	
	//Boutons radios 
	private JRadioButton genreProf;
	private JRadioButton genreStud;
	private JRadioButton itemInfo ;
	private JRadioButton itemGbma ;
	private JRadioButton homme ;
	private JRadioButton femme ;
	
	//Groupes boutons radios
	private ButtonGroup groupePoly;
	private ButtonGroup groupeSexe ;
	private ButtonGroup groupeFiliere ;
	
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
	
	//PopUp pour choix filiere 
	private JPopupMenu popUpFiliere  ;	
	
// Attributs pour le jeu 
	
	// Texte 
	private JTextArea desc ;		//Description personnage sous image 
	private JTextArea question ;	//Question pour action

	
	// Objet Temps
	private boolean timeP = false ;
	private Temps chrono ;	
	
	//Bouton pour réaliser des actoins
	private JButton boutonDormir ;
	private JButton boutonManger ;
	private JButton boutonDoucher ;
	private JButton boutonBesoin ;
	private JButton boutonDeplacer ;
	
	
	
	public Panneau(){
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.add(bouton) ;
        JouerAction ja = new JouerAction() ;
		bouton.addActionListener(ja) ;
		bouton.setBounds(1000,320,140,50);
		clic = 0 ;		
	}
	
	
	public boolean getTime(){
		return timeP ;
	}
	public int getClicP(){
		return clic ;
	}
	
	
	
	public void paintComponent(Graphics g){		
		super.paintComponent(g);
	
		String fLogo = "C:\\Users\\Maryline\\Documents\\Cours_IRM4A\\POO\\Projet_Jeux\\Logo_PolySims2.png";
		String fSims = "C:\\Users\\Maryline\\Documents\\Cours_IRM4A\\POO\\Projet_Jeux\\Sims4.png";
		String fBienvenue = "C:\\Users\\Maryline\\Documents\\Cours_IRM4A\\POO\\Projet_Jeux\\Bienvenue.png";
		String fBravo = "C:\\Users\\Maryline\\Documents\\Cours_IRM4A\\POO\\Projet_Jeux\\Bravo.png";
		//System.out.println("dans paintComponent, clic = " + clic) ;
		if(clic == 0){
			try {
				BufferedImage iLogo = ImageIO.read(new File(fLogo)) ;
				BufferedImage iSims = ImageIO.read(new File(fSims)) ;
				g.drawImage(iLogo, 400, 50, null) ;
				g.drawImage(iSims, 50, 250, null) ;
			}catch (IOException e){
				e.printStackTrace();
			}
		}
		else if (clic == 1 ){
			try{
				BufferedImage iBienvenue = ImageIO.read(new File(fBienvenue)) ;
				g.drawImage(iBienvenue, 450, 20, null) ;
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
			jlPoly = new JLabel("Vous êtes un :");
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
			genreProf = new JRadioButton("PolyProf");
			genreStud = new JRadioButton ("PolyStud") ;
			itemInfo = new JRadioButton("Info");
			itemGbma = new JRadioButton("Gbma");
			homme = new JRadioButton("H");
			femme = new JRadioButton("F");
			
			genreProf.setBounds(250, 200, 100 ,22);
			genreStud.setBounds(350, 200, 100 ,22);
			homme.setBounds(250, 360, 40, 22) ;
			femme.setBounds(300, 360, 40, 22);
			
			//Initialisation de la popUp filiere
			popUpFiliere = new JPopupMenu();
			popUpFiliere.add(itemInfo);
			popUpFiliere.add(itemGbma) ;
			
			
			
			//Initialisation groupe de bouton pour determiner le choix unique
			groupePoly = new ButtonGroup() ;
			groupeFiliere = new ButtonGroup() ;
			groupeSexe = new ButtonGroup() ;
	
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
			
			//Listener
			ActionListener alPoly = new PolyActionListener() ;
			genreProf.addActionListener(alPoly);
			genreStud.addActionListener(alPoly) ;
			
			ActionListener alFiliere = new FiliereActionListener() ;
			itemInfo.addActionListener(alFiliere);
			itemGbma.addActionListener(alFiliere);
		
			DocumentListener dl = new MonDocumentListener() ;
			jtfNom.getDocument().addDocumentListener(dl) ;
			jtfPrenom.getDocument().addDocumentListener(dl) ;
			
			DocumentListener dl2 = new Mon2DocumentListener() ;
			jtfAge.getDocument().addDocumentListener(dl2) ;
		
			ActionListener alSexe = new SexeActionListener() ;
			homme.addActionListener(alSexe);
			femme.addActionListener(alSexe);
			
		}
		else if (clic == 2){
			try{
				BufferedImage iBravo = ImageIO.read(new File(fBravo)) ;
				g.drawImage(iBravo, 500, 20, null) ;
			}catch (IOException e){
				e.printStackTrace();
			}
					
			texte = new JTextArea();
			texte.setBounds(300,250,500,200);
			Font fontTexte = new Font("Tahoma", Font.PLAIN, 20) ;
			texte.setFont(fontTexte);
			texte.append("Votre personnage a bien été créé. \n");
			texte.append("\nVous êtes " + genre ) ;
			texte.append("\nVous vous appellez " + nomP +" "+ prenomP) ;
			texte.append("\nVous avez " + ageP + " ans" );
			texte.append("\n\nAppuyez sur le bouton Jouer pour commencer la partie !");
			this.add(texte) ;
			
			//Faire apparaitre l'heure dans la fenetre
			timeP = true ;
			this.getTime() ;
		}
		
		//Clic sur commencer
		else if (clic == 3){
			
			/*chrono = new Temps() ;
			JLabel labelTime = new JLabel() ;
			labelTime = chrono.getLabelTemps() ;
			this.add(labelTime) ;
			labelTime.setVisible(true);
			labelTime.setLocation(600, 500);
			*/
			
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
			
			//Affichage nom + Prénom + Age sous la photo
			desc = new JTextArea() ;
			desc.setBounds(100, 480, 200, 200) ;
			desc.append(nomP + " " + prenomP + "\n" ) ;
			desc.append(genre + " - " + ageP + " ans");
			this.add(desc) ;		
			
			//this.getClicP() ;
			
			// Phrase "Que voulez-vous faire ?"
			question = new JTextArea() ;
			Font fontTexteQ = new Font("Tahoma", Font.PLAIN, 25) ;
			question.setFont(fontTexteQ);
			question.setBounds(400, 180, 300, 50) ;
			question.append("Que voulez-vous faire ?") ;
			this.add(question) ;	
			
			//Affichage boutons actions commun
			boutonDormir = new JButton("Dormir") ;
			boutonManger = new JButton("Manger") ;
			boutonBesoin = new JButton("Aller au toilette") ;
			boutonDoucher = new JButton("Se doucher") ;
			boutonDeplacer = new JButton("Se déplacer") ;
			
			this.add(boutonDormir) ;
			this.add(boutonManger) ;
			this.add(boutonBesoin) ;
			this.add(boutonDoucher) ;
			this.add(boutonDeplacer) ;
			
	        dormirAction dormira = new dormirAction() ;
			boutonDormir.addActionListener(dormira) ;
			boutonDormir.setBounds(400,240,140,30);
			
			besoinAction besoina = new besoinAction() ;
			boutonBesoin.addActionListener(besoina) ;
			boutonBesoin.setBounds(400,280,140,30);
			
			doucherAction douchera = new doucherAction() ;
			boutonDoucher.addActionListener(douchera) ;
			boutonDoucher.setBounds(400,320,140,30);
			
			mangerAction mangera = new mangerAction() ;
			boutonManger.addActionListener(mangera) ;
			boutonManger.setBounds(550,240,140,30);
			
			deplacerAction deplacera = new deplacerAction() ;
			boutonDeplacer.addActionListener(deplacera) ;
			boutonDeplacer.setBounds(550,280,140,30);
	
			polysim = new PolySims() ;
			polysim.setNom(nomP) ;
			polysim.setPrenom(prenomP) ;
			polysim.setAge(ageP) ;
			
			if(genre == "PolyProf" ){
				prof = new PolyProf() ;
				if (sexe == "H" ){	
					String fichierProfH = "C:\\Users\\Maryline\\Documents\\Cours_IRM4A\\POO\\Projet_Jeux\\ProfH.png";
					try {
						BufferedImage imageProfH = ImageIO.read(new File(fichierProfH)) ;
						g.drawImage(imageProfH, 20, 150, null) ;
					}catch (IOException e){
						e.printStackTrace();
					}
					hProf = new HProf() ;
				}
				else if (sexe == "F"){
					String fichierProfF = "C:\\Users\\Maryline\\Documents\\Cours_IRM4A\\POO\\Projet_Jeux\\ProfF.jpg";
					try {
						BufferedImage imageProfF = ImageIO.read(new File(fichierProfF)) ;
						g.drawImage(imageProfF, 20, 150, null) ;
					}catch (IOException e){
						e.printStackTrace();
					}
					fProf = new FProf() ;
				}
			}
			else if (genre == "PolyStud"){
				stud = new PolyStud() ;
				if (filiere =="Info" ){
					if (sexe == "H"){
						String fichierInfoH = "C:\\Users\\Maryline\\Documents\\Cours_IRM4A\\POO\\Projet_Jeux\\StudInfoH.png";
						try {
							BufferedImage imageInfoH = ImageIO.read(new File(fichierInfoH)) ;
							g.drawImage(imageInfoH, 20, 150, null) ;
						}catch (IOException e){
							e.printStackTrace();
						}
						hInfo = new HInfo() ;
					}
					else if (sexe == "F"){
						String fichierInfoF = "C:\\Users\\Maryline\\Documents\\Cours_IRM4A\\POO\\Projet_Jeux\\StudInfoF.png";
						try {
							BufferedImage imageInfoF = ImageIO.read(new File(fichierInfoF)) ;
							g.drawImage(imageInfoF, 20, 150, null) ;
						}catch (IOException e){
							e.printStackTrace();
						}
						fInfo = new FInfo() ;
					}
				}
				else if (filiere =="Gbma"){
					if (sexe == "H"){
						String fichierGbmaH = "C:\\Users\\Maryline\\Documents\\Cours_IRM4A\\POO\\Projet_Jeux\\StudGbmaH.png";
						try {
							BufferedImage imageGbmaH = ImageIO.read(new File(fichierGbmaH)) ;
							g.drawImage(imageGbmaH, 20, 150, null) ;
						}catch (IOException e){
							e.printStackTrace();
						}
						hGbma = new HGbma() ;
					}
					else if (sexe == "F"){
						String fichierGbmaF = "C:\\Users\\Maryline\\Documents\\Cours_IRM4A\\POO\\Projet_Jeux\\StudGbmaF.png";
						try {
							BufferedImage imageGbmaF = ImageIO.read(new File(fichierGbmaF)) ;
							g.drawImage(imageGbmaF, 20, 150, null) ;
						}catch (IOException e){
							e.printStackTrace();
						}
						fGbma = new FGbma() ;
					}
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
			if (e.getActionCommand() == "Commencer"){
			clic = 1 ;
			bouton.setText("Valider");
			repaint() ;		
			}
			else if (e.getActionCommand() == "Valider"){
				if (nomP != "null" && prenomP != "null" && ageP != 0 && sexe != "null" && genre != "null"){
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
					genreProf.setVisible(false);
					genreStud.setVisible(false);
					popUpFiliere.setVisible(false);
					homme.setVisible(false);
					femme.setVisible(false);		
					
					repaint() ;
				}
			}
			else if (e.getActionCommand() == "Jouer"){
				clic = 3 ;
				texte.setVisible(false) ;
				bouton.setVisible(false);
				repaint () ;
			}	
		}
	}
	// Bouton dormir
	public class dormirAction implements ActionListener{
		public void actionPerformed(ActionEvent dorae) {
			if (dorae.getActionCommand() == "Dormir"){
				polysim.dormir();
				add( polysim.getJaugesDormir() ) ;
				polysim.getJaugesDormir().setBounds(450, 600, 600, 100);
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
					polysim.allerToilette();
					add( polysim.getJaugesBesoin() ) ;
					polysim.getJaugesBesoin().setBounds(450, 600, 600, 100);
				}
			}
		}
		
	// Bouton doucher
	public class doucherAction implements ActionListener{
		public void actionPerformed(ActionEvent douae) {
			if (douae.getActionCommand() == "Se doucher"){
				polysim.seDoucher();
				add( polysim.getJaugesDoucher() ) ;
				polysim.getJaugesDoucher().setBounds(450, 600, 600, 100);
			}
		}
	}
	
	// Bouton deplacer
		public class deplacerAction implements ActionListener{
			public void actionPerformed(ActionEvent depae) {
				
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
			else if (genre =="PolyProf")
				popUpFiliere.setVisible(false); ;
		}
	}
	
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
		
}
