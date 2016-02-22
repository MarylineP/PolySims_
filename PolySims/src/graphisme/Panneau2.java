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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class Panneau2 extends JPanel{
// Attibut pour la mise en route du jeu 
	private Fenetre2 f2 = new Fenetre2();
	
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
	private JLabel prenom = new JLabel() ;	
	private JLabel description = new JLabel () ;	//Description personnage sous image 
	private JLabel question = new JLabel() ;
	private Font fontTexteQ = new Font("Tahoma", Font.PLAIN, 25) ;	//Question pour action
	
	//Bouton pour réaliser des actoins
	private JButton btDormir = new JButton("Dormir");
	private JButton btDoucher= new JButton("Se doucher")  ;
	private JButton btBesoin  = new JButton("Aller au toilette");
	private JButton btCommuniquer= new JButton("Communiquer") ; ;
	private JButton btCommuniquerRigoler = new JButton ("Rigoler");
	private JButton btCommuniquerParler = new JButton ("Parler");
	private JButton btCommuniquerCritiquer = new JButton ("Critiquer");
	private JButton btCommuniquerEngueuler = new JButton ("Engueuler");
	private JButton btCommuniquerReproduire = new JButton ("Se reproduire");
	private JButton btManger  = new JButton("Manger") ;
	private JButton btMangerBoisson = new JButton ("Boisson") ;
	private JButton btMangerGouter = new JButton("Goûter") ;
	private JButton btMangerRepas = new JButton("Repas") ;
	private JButton btDeplacer = new JButton("Se déplacer");
	private JButton btDeplacerEcole = new JButton("Ecole");
	private JButton btDeplacerSoiree = new JButton("Soirée") ;
	private JButton btDeplacerMaison = new JButton ("Maison") ;
	private JButton btAllerTravailler= new JButton() ;
	private JButton btTravailler = new JButton ();
	private JButton btImpliquerClubPolyHack = new JButton ("Aider PolyHack");
	private JButton btImpliquerClubPompom = new JButton ("Aider Pompom");
	private JButton btRaser = new JButton("Se raser") ; ;
	private JButton btMaquiller = new JButton ("Se maquiller") ;
	private JButton btTomberEnceinte = new JButton ("Tomber enceinte");
	
	//Listeners des boutons Actions
	private dormirAction dormira = new dormirAction() ;
	private besoinAction besoina = new besoinAction() ;
	private doucherAction douchera = new doucherAction() ;
	private deplacerAction deplacera = new deplacerAction() ;
	private deplacerLieuAction deplacerLieua = new deplacerLieuAction() ;
	private mangerAction mangera = new mangerAction() ;
	private mangerDiversAction mangerDiversa= new mangerDiversAction() ;
	private raserAction rasera = new raserAction() ;
	private travaillerAction travaillera = new travaillerAction() ;
	private allerTravaillerAction allerTravaillera = new allerTravaillerAction() ;
	private communiquerDiversAction communiquerDiversa = new communiquerDiversAction () ;
	private communiquerAction communiquera = new communiquerAction() ; 
	private enceinteAction enceintea = new enceinteAction() ;
	private integrerClubAction integreCluba = new integrerClubAction() ;
	private maquillerAction maquillera = new maquillerAction() ;
	
	//Jauge du bas
	private JLabel jauge = new JLabel () ;
	
	//initialiser l'appartition des boutons pour manger et se déplacer
	private int nbClicBtDeplacer = 0 ;
	private int nbClicBtManger = 0 ;
	private int nbClicBtCommuniquer = 0 ; 
	
	//Récupérer le lieu
	private String lieu;
	
	//Afficher l'heure
	private JLabel horloge = new JLabel() ;
	private Font fontHorloge = new Font("Arial", Font.PLAIN, 30) ;
	
	public Panneau2(){
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.add(bouton) ;
        JouerAction ja = new JouerAction() ;
		bouton.addActionListener(ja) ;
		bouton.setBounds(1000,320,140,50);
		clic = 0 ;		
	

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
		
		//Ajout des listeners aux boutons action
		btManger.addActionListener(mangera);
		btMangerBoisson.addActionListener(mangerDiversa);
		btMangerGouter.addActionListener(mangerDiversa);
		btMangerRepas.addActionListener(mangerDiversa);
		btBesoin.addActionListener(besoina) ;
		btDormir.addActionListener(dormira) ;
		btDoucher.addActionListener(douchera) ;
		btDeplacer.addActionListener(deplacera);
		btDeplacerEcole.addActionListener(deplacerLieua) ;
		btDeplacerSoiree.addActionListener(deplacerLieua) ;
		btDeplacerMaison.addActionListener(deplacerLieua);
		btRaser.addActionListener(rasera);
		btTravailler.addActionListener(travaillera);
		btAllerTravailler.addActionListener(allerTravaillera);
		btCommuniquer.addActionListener(communiquera);
		btCommuniquerParler.addActionListener(communiquerDiversa);
		btCommuniquerRigoler.addActionListener(communiquerDiversa);
		btCommuniquerCritiquer.addActionListener(communiquerDiversa);
		btCommuniquerEngueuler.addActionListener(communiquerDiversa);
		btCommuniquerReproduire.addActionListener(communiquerDiversa);
		btImpliquerClubPolyHack.addActionListener(integreCluba) ;
		btImpliquerClubPompom.addActionListener(integreCluba);
		btTomberEnceinte.addActionListener(enceintea);
		btMaquiller.addActionListener(maquillera) ;
	}
	
	public void paintComponent(Graphics g){		
		super.paintComponent(g);

		String fBienvenue = "C:\\Users\\Maryline\\git\\LocalGame\\PolySims\\src\\Bienvenue.png";
		String fBravo = "C:\\Users\\Maryline\\git\\LocalGame\\PolySims\\src\\Bravo.png";
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
			add(jlPoly) ;
			add(jlNom) ;
			add(jlPrenom) ;
			add(jlAge) ;
			add(jlSexe) ;
			add(jtfNom) ;
			add(jtfPrenom) ;
			add(jtfAge) ;
			add(genreProf) ;
			add(genreStud) ;
			add(homme) ;
			add(femme) ;
			add(popUpFiliere) ;
			
			
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
			prenom.setBounds(100, 480, 200, 20) ;
			description.setBounds(100, 500,100,20);
			prenom.setText(nomP + " " + prenomP );
			description.setText(genre + " - " + ageP + " ans");
			add(prenom) ;		
			add(description) ;
			
			// Phrase "Que voulez-vous faire ?"
			question.setFont(fontTexteQ);
			question.setBounds(400, 180, 300, 50) ;
			question.setText("Que voulez-vous faire ?") ;
			this.add(question) ;
			
			//Bouton pour tous et partout
			btManger.setBounds(550,240,140,30);
			btMangerBoisson.setBounds(700,240,140,30);
			btMangerGouter.setBounds(850,240,140,30);
			btMangerRepas.setBounds(1000,240,140,30);
			btBesoin.setBounds(400,240,140,30);
			btDeplacerEcole.setBounds(700,280,140,30);
			btDeplacerSoiree.setBounds(850,280,140,30);
			btDeplacerMaison.setBounds(1000, 280, 140, 30);
			btDeplacer.setBounds(550, 280, 140, 30);
			//Bouton Maison
				//Pour tous
			btDormir.setBounds(400,280,140,30);
			btDoucher.setBounds(400,320,140,30) ;
			btTravailler.setBounds(550,360,140,30);
				//Pour Homme
			btRaser.setBounds(400,360,140,30);
				//Pour Femme
			btMaquiller.setBounds(400,360,140,30);
			//Bouton Ecole
				//Pour tous
			btAllerTravailler.setBounds(400,280,140,30);
			//Pour Soiree
				//Pour tous
			btCommuniquer.setBounds(550,320,140,30);
			btCommuniquerParler.setBounds(700,320,140,30);
			btCommuniquerRigoler.setBounds(850,320,140,30);
			btCommuniquerEngueuler.setBounds(700,360,140,30);	
			btCommuniquerCritiquer.setBounds(850,360,140,30);
			btCommuniquerReproduire.setBounds(775,400,140,30);
				//Pour Info
			btImpliquerClubPolyHack.setBounds(400,360,140,30);
				//Pour Gbma
			btImpliquerClubPompom.setBounds(400,360,140,30);
				//Pour Femme
			btTomberEnceinte.setBounds(400,280,140,30);
			
			add(btManger) ;
			add(btMangerBoisson) ;
			add(btMangerGouter) ;
			add(btMangerRepas) ;
			add(btBesoin) ;
			add(btDeplacer) ;
			add(btDeplacerEcole) ;
			add(btDeplacerSoiree) ;	
			add(btDeplacerMaison) ;
			add(btDormir) ;
			add(btDoucher) ;
			add(btTravailler);
			add(btRaser) ;
			add(btMaquiller) ;
			add(btAllerTravailler) ;	
			add(btCommuniquer) ;
			add(btCommuniquerParler) ;
			add(btCommuniquerRigoler) ;
			add(btCommuniquerCritiquer) ;
			add(btCommuniquerEngueuler) ;
			add(btCommuniquerReproduire) ;
			add(btImpliquerClubPolyHack) ;
			add(btImpliquerClubPompom) ;
			add(btTomberEnceinte) ;
			
			
			if((nbClicBtManger % 2) == 0) {
				btMangerBoisson.setVisible(false);
				btMangerGouter.setVisible(false);
				btMangerRepas.setVisible(false);
			}
			else {
				btMangerBoisson.setVisible(true);
				btMangerGouter.setVisible(true);
				btMangerRepas.setVisible(true);
			}
			btBesoin.setVisible(true);
			btDeplacer.setVisible(true);
			
			if(genre == "PolyProf" ){	
				if (sexe == "H" ){	
					String fichierProfH = "C:\\Users\\Maryline\\git\\LocalGame\\PolySims\\src\\ProfH.png";
					try {
						BufferedImage imageProfH = ImageIO.read(new File(fichierProfH)) ;
						g.drawImage(imageProfH, 20, 150, null) ;
					}catch (IOException e){
						e.printStackTrace();
					}
					jauge.setText("Energie : "+ hProf.getEn() +"    Hygiene :"+ hProf.getHy() +"    Besoins :"+ hProf.getBe()+
							"    Appetit :"+hProf.getAp()+"   Social: "+hProf.getSo()+"    Travail :"+hProf.getTr());	
					if(hProf.getHeure()<10)
						horloge.setText("0"+hProf.getHeure()+":"+hProf.getMinute()) ;
					else if (hProf.getHeure()<10 && hProf.getMinute()<10)
						horloge.setText("0"+hProf.getHeure()+":0"+hProf.getMinute()) ;
					else if (hProf.getMinute()<10)
						horloge.setText(hProf.getHeure()+":0"+hProf.getMinute()) ;
					else 
						horloge.setText(hProf.getHeure()+":"+hProf.getMinute()) ;
				}
				else if (sexe == "F"){
					String fichierProfF = "C:\\Users\\Maryline\\git\\LocalGame\\PolySims\\src\\ProfF.jpg";
					try {
						BufferedImage imageProfF = ImageIO.read(new File(fichierProfF)) ;
						g.drawImage(imageProfF, 20, 150, null) ;
					}catch (IOException e){
						e.printStackTrace();
					}
					jauge.setText("Energie : "+ fProf.getEn() +"    Hygiene :"+ fProf.getHy() +"    Besoins :"+ fProf.getBe()+
						"    Appetit :"+fProf.getAp()+"   Social: "+fProf.getSo()+"    Travail :"+fProf.getTr());					
					if(fProf.getHeure()<10)
						horloge.setText("0"+fProf.getHeure()+":"+fProf.getMinute()) ;
					else if (fProf.getHeure()<10 && fProf.getMinute()<10)
						horloge.setText("0"+fProf.getHeure()+":0"+fProf.getMinute()) ;
					else if (fProf.getMinute()<10)
						horloge.setText(fProf.getHeure()+":0"+fProf.getMinute()) ;
					else 
						horloge.setText(fProf.getHeure()+":"+fProf.getMinute()) ;
				}
			}
			else if (genre == "PolyStud"){
					if (filiere =="Info" && sexe == "H"){
						String fichierInfoH = "C:\\Users\\Maryline\\git\\LocalGame\\PolySims\\src\\StudInfoH.png";
						try {
							BufferedImage imageInfoH = ImageIO.read(new File(fichierInfoH)) ;
							g.drawImage(imageInfoH, 20, 150, null) ;
						}catch (IOException e){
							e.printStackTrace();
						}
						jauge.setText("Energie : "+ hInfo.getEn() +"    Hygiene :"+ hInfo.getHy() +"    Besoins :"+ hInfo.getBe()+
								"    Appetit :"+hInfo.getAp()+"   Social: "+hInfo.getSo()+"    Travail :"+hInfo.getTr());					
						if(hInfo.getHeure()<10)
							horloge.setText("0"+hInfo.getHeure()+":"+hInfo.getMinute()) ;
						else if (hInfo.getHeure()<10 && hInfo.getMinute()<10)
							horloge.setText("0"+hInfo.getHeure()+":0"+hInfo.getMinute()) ;
						else if (hInfo.getMinute()<10)
							horloge.setText(hInfo.getHeure()+":0"+hInfo.getMinute()) ;
						else 
							horloge.setText(hInfo.getHeure()+":"+hInfo.getMinute()) ;
					}
					else if (filiere == "Info" &&sexe == "F"){
						String fichierInfoF = "C:\\Users\\Maryline\\git\\LocalGame\\PolySims\\src\\StudInfoF.png";
						try {
						BufferedImage imageInfoF = ImageIO.read(new File(fichierInfoF)) ;
						g.drawImage(imageInfoF, 20, 150, null) ;
						}catch (IOException e){
							e.printStackTrace();
						}
						jauge.setText("Energie : "+ fInfo.getEn() +"    Hygiene :"+ fInfo.getHy() +"    Besoins :"+ fInfo.getBe()+
								"    Appetit :"+fInfo.getAp()+"   Social: "+fInfo.getSo()+"    Travail :"+fInfo.getTr());					
						if(fInfo.getHeure()<10)
							horloge.setText("0"+fInfo.getHeure()+":"+fInfo.getMinute()) ;
						else if (fInfo.getHeure()<10 && fInfo.getMinute()<10)
							horloge.setText("0"+fInfo.getHeure()+":0"+fInfo.getMinute()) ;
						else if (fInfo.getMinute()<10)
							horloge.setText(fInfo.getHeure()+":0"+fInfo.getMinute()) ;
						else 
							horloge.setText(fInfo.getHeure()+":"+fInfo.getMinute()) ;
					}
					else if (filiere =="Gbma" && sexe =="H"){
						String fichierGbmaH = "C:\\Users\\Maryline\\git\\LocalGame\\PolySims\\src\\StudGbmaH.png";
						try {
							BufferedImage imageGbmaH = ImageIO.read(new File(fichierGbmaH)) ;
							g.drawImage(imageGbmaH, 20, 150, null) ;
						}catch (IOException e){
							e.printStackTrace();
						}
						jauge.setText("Energie : "+ hGbma.getEn() +"    Hygiene :"+ hGbma.getHy() +"    Besoins :"+ hGbma.getBe()+
								"    Appetit :"+hGbma.getAp()+"   Social: "+hGbma.getSo()+"    Travail :"+hGbma.getTr());
						if(hGbma.getHeure()<10)
							horloge.setText("0"+hGbma.getHeure()+":"+hGbma.getMinute()) ;
						else if (hGbma.getHeure()<10 && hGbma.getMinute()<10)
							horloge.setText("0"+hGbma.getHeure()+":0"+hGbma.getMinute()) ;
						else if (hGbma.getMinute()<10)
							horloge.setText(hGbma.getHeure()+":0"+hGbma.getMinute()) ;
						else 
							horloge.setText(hGbma.getHeure()+":"+hGbma.getMinute()) ;
					}
					else if (filiere=="Gbma" && sexe == "F"){
						String fichierGbmaF = "C:\\Users\\Maryline\\git\\LocalGame\\PolySims\\src\\StudGbmaF.png";
						try {
							BufferedImage imageGbmaF = ImageIO.read(new File(fichierGbmaF)) ;
							g.drawImage(imageGbmaF, 20, 150, null) ;
						}catch (IOException e){
							e.printStackTrace();
						}
						jauge.setText("Energie : "+ fGbma.getEn() +"    Hygiene :"+ fGbma.getHy() +"    Besoins :"+ fGbma.getBe()+
								"    Appetit :"+fGbma.getAp()+"   Social: "+fGbma.getSo()+"    Travail :"+fGbma.getTr());
						if(fGbma.getHeure()<10)
							horloge.setText("0"+fGbma.getHeure()+":"+fGbma.getMinute()) ;
						else if (fGbma.getHeure()<10 && fGbma.getMinute()<10)
							horloge.setText("0"+fGbma.getHeure()+":0"+fGbma.getMinute()) ;
						else if (fGbma.getMinute()<10)
							horloge.setText(fGbma.getHeure()+":0"+fGbma.getMinute()) ;
						else 
							horloge.setText(fGbma.getHeure()+":"+fGbma.getMinute()) ;
					}
			}
			jauge.setBounds(400, 570, 600, 100);
			horloge.setBounds(1080, 550, 100, 50);
			horloge.setFont(fontHorloge);
			horloge.setBorder(BorderFactory.createRaisedSoftBevelBorder());
			add(jauge) ;
			add(horloge) ;
			
			if (lieu=="maison"){
				//Affichage titre 
				String maison = "C:\\Users\\Maryline\\git\\LocalGame\\PolySims\\src\\maison.png";
				try {
					BufferedImage texteMaison = ImageIO.read(new File(maison)) ;
					g.drawImage(texteMaison, 500, 20, null) ;
				}catch (IOException e){
					e.printStackTrace();
				}
				//Affichage icone
				String iconeMaison = "C:\\Users\\Maryline\\git\\LocalGame\\PolySims\\src\\icone_maison.png";
				try {
					BufferedImage iconeM = ImageIO.read(new File(iconeMaison)) ;
					g.drawImage(iconeM, 800, 25, null) ;
				}catch (IOException e){
					e.printStackTrace();
				}
				
				if((nbClicBtDeplacer % 2) == 0) {
					btDeplacerSoiree.setVisible(false);
					btDeplacerEcole.setVisible(false);
				}
				else {
					 btDeplacerSoiree.setVisible(true);
					 btDeplacerEcole.setVisible(true);
				}
				btDeplacerMaison.setVisible(false);
				btAllerTravailler.setVisible(false);
				btTravailler.setVisible(false);
				btCommuniquer.setVisible(false);
				btImpliquerClubPolyHack.setVisible(false);
				btImpliquerClubPompom.setVisible(false);
				btTomberEnceinte.setVisible(false);
				btCommuniquerParler.setVisible(false);
				btCommuniquerRigoler.setVisible(false);
				btCommuniquerEngueuler.setVisible(false);
				btCommuniquerCritiquer.setVisible(false);
				btCommuniquerReproduire.setVisible(false);
				btDormir.setVisible(true);
				btDoucher.setVisible(true);
				btTravailler.setVisible(true);
				
				if(genre == "PolyProf" )	
					btTravailler.setText("Corriger copies") ;
				else if (genre == "PolyStud")
					btTravailler.setText("Faire devoirs") ;	
				
				if (sexe == "H" ){
					btRaser.setVisible(true);
					btMaquiller.setVisible(false);
				}
				else if (sexe == "F"){
					btMaquiller.setVisible(true);				
					btRaser.setVisible(false);
				}
			}			
			else if (lieu=="ecole"){
				//Affichage titre 
				String ecole = "C:\\Users\\Maryline\\git\\LocalGame\\PolySims\\src\\ecole.png";
				try {
					BufferedImage texteEcole = ImageIO.read(new File(ecole)) ;
					g.drawImage(texteEcole, 500, 20, null) ;
				}catch (IOException e){
					e.printStackTrace();
				}
				//Affichage icone
				String iconeEcole = "C:\\Users\\Maryline\\git\\LocalGame\\PolySims\\src\\icone_ecole.jpg";
				try {
					BufferedImage iconeE = ImageIO.read(new File(iconeEcole)) ;
					g.drawImage(iconeE, 750, 25, null) ;
				}catch (IOException e){
					e.printStackTrace();
				}
				btDeplacerMaison.setBounds(700,280,140,30) ;
				
				if((nbClicBtDeplacer % 2) == 0){
					btDeplacerSoiree.setVisible(false);
					btDeplacerMaison.setVisible(false);
				}
				else {
					 btDeplacerSoiree.setVisible(true);
					 btDeplacerMaison.setVisible(true);
				}
				btDeplacerEcole.setVisible(false);
				btDormir.setVisible(false);
				btDoucher.setVisible(false);
				btRaser.setVisible(false);
				btMaquiller.setVisible(false);
				btTravailler.setVisible(false);
				btCommuniquer.setVisible(false);
				btImpliquerClubPolyHack.setVisible(false);
				btImpliquerClubPompom.setVisible(false);
				btTomberEnceinte.setVisible(false);
				btCommuniquerParler.setVisible(false);
				btCommuniquerRigoler.setVisible(false);
				btCommuniquerEngueuler.setVisible(false);
				btCommuniquerCritiquer.setVisible(false);
				btCommuniquerReproduire.setVisible(false);
				btAllerTravailler.setVisible(true);
				
				if(genre == "PolyProf" )
					btAllerTravailler.setText("Donner des cours");
				else if (genre == "PolyStud")
					btAllerTravailler.setText("Aller en cours");
			}
			else if (lieu=="soiree"){
				//Affichage titre 
				String soiree = "C:\\Users\\Maryline\\git\\LocalGame\\PolySims\\src\\soiree.png";
				try {
					BufferedImage texteSoiree = ImageIO.read(new File(soiree)) ;
					g.drawImage(texteSoiree, 500, 20, null) ;
				}catch (IOException e){
					e.printStackTrace();
				}
				//Affichage icone
				String iconeSoiree = "C:\\Users\\Maryline\\git\\LocalGame\\PolySims\\src\\icone_soiree.jpg";
				try {
					BufferedImage iconeS = ImageIO.read(new File(iconeSoiree)) ;
					g.drawImage(iconeS, 800, 25, null) ;
				}catch (IOException e){
					e.printStackTrace();
				}
				
				if((nbClicBtCommuniquer % 2) == 0) {
					btCommuniquerParler.setVisible(false);
					btCommuniquerRigoler.setVisible(false);
					btCommuniquerEngueuler.setVisible(false);
					btCommuniquerCritiquer.setVisible(false);
					btCommuniquerReproduire.setVisible(false);
				}
				else{
					btCommuniquerParler.setVisible(true);
					btCommuniquerRigoler.setVisible(true);
					btCommuniquerEngueuler.setVisible(true);
					btCommuniquerCritiquer.setVisible(true);
					btCommuniquerReproduire.setVisible(true);
				}
				
				btDeplacerMaison.setBounds(850,280,140,30) ;				
				if((nbClicBtDeplacer % 2) == 0) {
					btDeplacerMaison.setVisible(false);
					btDeplacerEcole.setVisible(false);
				}
				else{
					 btDeplacerMaison.setVisible(true);
					 btDeplacerEcole.setVisible(true);
				}
				btDeplacerSoiree.setVisible(false);
				
				btDormir.setVisible(false);
				btDoucher.setVisible(false);
				btRaser.setVisible(false);
				btMaquiller.setVisible(false);
				btTravailler.setVisible(false);
				btAllerTravailler.setVisible(false) ;
				btCommuniquer.setVisible(true);
				
				if (filiere == "Info")
					btImpliquerClubPolyHack.setVisible(true); 
				else if (filiere == "Gbma")
					btImpliquerClubPompom.setVisible(true); 
				if (genre =="PolyProf" && sexe == "F")
					btTomberEnceinte.setVisible(true);
			}
		}
		else if (clic == 3){
			if(genre =="PolyProf"){
				//Affichage titre 
				String fRetraite = "C:\\Users\\Maryline\\git\\LocalGame\\PolySims\\src\\texteRetraite.png";
				try{
					BufferedImage iRetraite = ImageIO.read(new File(fRetraite)) ;
					g.drawImage(iRetraite, 450, 10, null) ;
				}catch (IOException e){
					e.printStackTrace();
				}
				//Affichage image
				String retraite = "C:\\Users\\Maryline\\git\\LocalGame\\PolySims\\src\\retraite.jpg";
				try {
					BufferedImage imageRetraite = ImageIO.read(new File(retraite)) ;
					g.drawImage(imageRetraite, 450, 130, null) ;
				}catch (IOException e){
					e.printStackTrace();
				}
			}
			else if (genre =="PolyStud"){
				//Affichage titre 
				String fDiplome = "C:\\Users\\Maryline\\git\\LocalGame\\PolySims\\src\\texteDiplome.png";
					try{
						BufferedImage iDiplome = ImageIO.read(new File(fDiplome)) ;
						g.drawImage(iDiplome, 450, 20, null) ;
					}catch (IOException e){
						e.printStackTrace();
					}
				//Affichage image
				String diplome = "C:\\Users\\Maryline\\git\\LocalGame\\PolySims\\src\\diplome.jpg";
				try {
					BufferedImage imageDiplome = ImageIO.read(new File(diplome)) ;
					g.drawImage(imageDiplome, 400, 200, null) ;
				}catch (IOException e){
					e.printStackTrace();
				}
			}
		}
		else if (clic==4){
			//Affichage titre 
			String fMort = "C:\\Users\\Maryline\\git\\LocalGame\\PolySims\\src\\texteMort.png";
				try{
					BufferedImage iMort = ImageIO.read(new File(fMort)) ;
					g.drawImage(iMort, 450, 20, null) ;
				}catch (IOException e){
					e.printStackTrace();
				}
			//Affichage image
			String mort = "C:\\Users\\Maryline\\git\\LocalGame\\PolySims\\src\\mort.jpg";
			try {
				BufferedImage imageMort = ImageIO.read(new File(mort)) ;
				g.drawImage(imageMort, 350, 200, null) ;
			}catch (IOException e){
				e.printStackTrace();
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
					lieu = hProf.getLieu() ;
				}
				else if (genre =="PolyProf" && sexe=="F"){
					fProf = new FProf() ;
					fProf.setNom(nomP) ;
					fProf.setPrenom(prenomP) ;
					fProf.setAge(ageP) ;
					lieu = fProf.getLieu() ;
				}
				else if (genre =="PolyStud" && filiere=="Info" && sexe=="H"){
					hInfo = new HInfo() ;
					hInfo.setNom(nomP) ;
					hInfo.setPrenom(prenomP) ;
					hInfo.setAge(ageP) ;
					lieu = hInfo.getLieu() ;
				}
				else if (genre =="PolyStud" && filiere=="Info" && sexe=="F"){
					fInfo = new FInfo() ;
					fInfo.setNom(nomP) ;
					fInfo.setPrenom(prenomP) ;
					fInfo.setAge(ageP) ;
					lieu = fInfo.getLieu() ;
				}
				else if (genre =="PolyStud" && filiere=="Gbma" && sexe=="H"){
					hGbma = new HGbma() ;
					hGbma.setNom(nomP) ;
					hGbma.setPrenom(prenomP) ;
					hGbma.setAge(ageP) ;
					lieu = hGbma.getLieu() ;
				}
				else if (genre =="PolyStud" && filiere=="Gbma" && sexe=="F"){
					fGbma = new FGbma() ;
					fGbma.setNom(nomP) ;
					fGbma.setPrenom(prenomP) ;
					fGbma.setAge(ageP) ;
					lieu = fGbma.getLieu() ;
				}
				repaint () ;	
				JOptionPane.showMessageDialog(f2,"Vous êtes chez vous."+"\n"+"Il est 7h30."+"\n"+"Passez un bonne journée !", "Bienvenue", JOptionPane.INFORMATION_MESSAGE);
			}	
			if (clic == 4 || clic ==3){
				System.exit(0); 
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
					if (genre == "PolyProf" && sexe == "H")
						hProf.dormir();
					else if (genre == "PolyProf" && sexe == "F")
						fProf.dormir();
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "H")
						hInfo.dormir();
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "F")
						fInfo.dormir();
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "H")
						hGbma.dormir();
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "F")
						fGbma.dormir();
					repaint() ;
			}
		}
		
		// Bouton manger
		public class mangerAction implements ActionListener{
			public void actionPerformed(ActionEvent ae) {		
				nbClicBtManger ++ ;
				repaint() ;
			}
		}
		
		// Boutons Manger Divers
		public class mangerDiversAction implements ActionListener{
			public void actionPerformed(ActionEvent ae){
				if(ae.getActionCommand()=="Boisson"){
					if (genre == "PolyProf" && sexe == "H")
						hProf.mangerBoisson();
					else if (genre == "PolyProf" && sexe == "F")
						fProf.mangerBoisson();
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "H")
						hInfo.mangerBoisson();
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "F")
						fInfo.mangerBoisson();
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "H")
						hGbma.mangerBoisson();
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "F")
						fGbma.mangerBoisson();
				}
				else if (ae.getActionCommand()=="Goûter"){
					if (genre == "PolyProf" && sexe == "H")
						hProf.mangerGouter();
					else if (genre == "PolyProf" && sexe == "F")
						fProf.mangerGouter();
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "H")
						hInfo.mangerGouter();
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "F")
						fInfo.mangerGouter();
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "H")
						hGbma.mangerGouter();
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "F")
						fGbma.mangerGouter();
				}
				else if (ae.getActionCommand()=="Repas"){
					if (genre == "PolyProf" && sexe == "H")
						hProf.mangerRepas();
					else if (genre == "PolyProf" && sexe == "F")
						fProf.mangerRepas();
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "H")
						hInfo.mangerRepas();
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "F")
						fInfo.mangerRepas();
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "H")
						hGbma.mangerRepas();
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "F")
						fGbma.mangerRepas();
				}
				nbClicBtManger  = 0 ;
				repaint() ;
			}
		}
	
		// Bouton besoin
		public class besoinAction implements ActionListener{
			public void actionPerformed(ActionEvent besae) {
					if (genre == "PolyProf" && sexe == "H")
						hProf.allerToilette();
					else if (genre == "PolyProf" && sexe == "F")
						fProf.allerToilette();
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "H")
						hInfo.allerToilette();
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "F")
						fInfo.allerToilette();
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "H")
						hGbma.allerToilette();
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "F")
						fGbma.allerToilette();
					repaint() ;
			}
		}
			
		// Bouton doucher
		public class doucherAction implements ActionListener{
			public void actionPerformed(ActionEvent douae) {
					if (genre == "PolyProf" && sexe == "H")
						hProf.seDoucher();
					else if (genre == "PolyProf" && sexe == "F")
						fProf.seDoucher();
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "H")
						hInfo.seDoucher();
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "F")
						fInfo.seDoucher();
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "H")
						hGbma.seDoucher();
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "F")
						fGbma.seDoucher();
					repaint() ;
			}
		}
		
		//Se deplacer
		public class deplacerAction implements ActionListener{
			public void actionPerformed(ActionEvent ae){
				nbClicBtDeplacer ++ ;
				repaint() ;
			}
		}
		
		//Se deplacer lieu
		public class deplacerLieuAction implements ActionListener{
			public void actionPerformed(ActionEvent ae){
				if(ae.getActionCommand()=="Ecole"){
					if (genre == "PolyProf" && sexe == "H"){
						hProf.seDeplacerEcole();
						lieu = hProf.getLieu() ;
					}
					else if (genre == "PolyProf" && sexe == "F"){
						fProf.seDeplacerEcole();
						lieu = fProf.getLieu() ;
					}
					else if (genre == "PolyStud" && filiere=="Info" && sexe == "H"){
						hInfo.seDeplacerEcole();
						lieu = hInfo.getLieu() ;
					}
					else if (genre == "PolyStud" && filiere=="Info" && sexe == "F"){
						fInfo.seDeplacerEcole();
						lieu = fInfo.getLieu() ;
					}
					else if (genre == "PolyStud" && filiere=="Gbma" && sexe == "H"){
						hGbma.seDeplacerEcole();
						lieu = hGbma.getLieu() ;
					}
					else if (genre == "PolyStud" && filiere=="Gbma" && sexe == "F"){
						fGbma.seDeplacerEcole();
						lieu = fGbma.getLieu() ;
					}
				}
				else if (ae.getActionCommand()=="Maison"){
					if (genre == "PolyProf" && sexe == "H"){
						hProf.seDeplacerMaison();
						lieu = hProf.getLieu() ;
					}
					else if (genre == "PolyProf" && sexe == "F"){
						fProf.seDeplacerMaison();
						lieu = fProf.getLieu() ;
					}
					else if (genre == "PolyStud" && filiere=="Info" && sexe == "H"){
						hInfo.seDeplacerMaison();
						lieu = hInfo.getLieu() ;
					}
					else if (genre == "PolyStud" && filiere=="Info" && sexe == "F"){
						fInfo.seDeplacerMaison();
						lieu = fInfo.getLieu() ;
					}
					else if (genre == "PolyStud" && filiere=="Gbma" && sexe == "H"){
						hGbma.seDeplacerMaison();
						lieu = hGbma.getLieu() ;
					}
					else if (genre == "PolyStud" && filiere=="Gbma" && sexe == "F"){
						fGbma.seDeplacerMaison();
						lieu = fGbma.getLieu() ;
					}
				}
				else if (ae.getActionCommand()=="Soirée"){
					if (genre == "PolyProf" && sexe == "H"){
						hProf.seDeplacerSoiree();
						lieu = hProf.getLieu();
					}
					else if (genre == "PolyProf" && sexe == "F"){
						fProf.seDeplacerSoiree();
						lieu = fProf.getLieu() ;
					}
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "H"){
						hInfo.seDeplacerSoiree();
						lieu = hInfo.getLieu() ;
					}
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "F"){
						fInfo.seDeplacerSoiree();
						lieu = fInfo.getLieu() ;
					}
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "H"){
						hGbma.seDeplacerSoiree();
						lieu = hGbma.getLieu() ;
					}
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "F"){
						fGbma.seDeplacerSoiree();
						lieu = fGbma.getLieu() ;
					}
				}
				nbClicBtDeplacer=0 ;
				repaint() ;
			}
		}
		
		// Bouton raser
		public class raserAction implements ActionListener{
			public void actionPerformed(ActionEvent rasae) {
					if(genre == "PolyProf" && sexe=="H")
						hProf.seRaser();
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "H")
						hInfo.seRaser();
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "H")
						hGbma.seRaser();
					repaint() ;
			}
		}
		
		// Bouton aller travailler
		public class allerTravaillerAction implements ActionListener{
			public void actionPerformed(ActionEvent travae) {
					if (genre == "PolyProf" && sexe == "H"){
						hProf.allerTravailler();
						if (hProf.getGagne())
							clic = 3 ;
						if(hProf.getEnVie()==false)
							clic=4 ;
					}
					else if (genre == "PolyProf" && sexe == "F"){
						fProf.allerTravailler();
						if (fProf.getGagne())
							clic = 3 ;
						if (fProf.getEnVie()==false)
							clic=4 ;
					}
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "H"){
						hInfo.allerTravailler();
						if (hInfo.getGagne())
							clic = 3 ;
						if (hInfo.getEnVie()==false)
							clic=4 ;
					}
					else if (genre =="PolyStud" && filiere=="Info" && sexe=="F"){
						fInfo.allerTravailler();
						if (fInfo.getGagne())
							clic = 3 ;
						if (fInfo.getEnVie()==false)
							clic=4 ;
					}
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "H"){
						hGbma.allerTravailler();
						if (hGbma.getGagne())
							clic = 3 ;
						if (hGbma.getEnVie()==false)
							clic=4 ;
					}
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "F"){
						fGbma.allerTravailler();
						if (fGbma.getGagne())
							clic = 3 ;
						if (fGbma.getEnVie()==false)
							clic=4 ;
					}
					if (clic == 3 || clic ==4 ){
						prenom.setVisible(false);
						description.setVisible(false);
						question.setVisible(false);
						jauge.setVisible(false);
						btManger.setVisible(false) ;
						btBesoin.setVisible(false) ;
						btDeplacer.setVisible(false) ;
						btDormir.setVisible(false) ;
						btDoucher.setVisible(false) ;
						btTravailler.setVisible(false) ;
						btRaser.setVisible(false) ;
						btMaquiller.setVisible(false) ;
						btAllerTravailler.setVisible(false) ;
						btCommuniquer.setVisible(false) ;
						btImpliquerClubPolyHack.setVisible(false) ;
						btImpliquerClubPompom.setVisible(false) ;
						btTomberEnceinte.setVisible(false) ;
						horloge.setVisible(false);
						bouton.setText("Quitter");
						bouton.setVisible(true);
					}
					repaint() ;
					if(clic ==3 && genre =="PolyProf")
						JOptionPane.showMessageDialog(f2,"Vous êtes arrivé à la retraite."+"\n"+"Appuyer sur Quiter pour quitter la partie", "Félicitations", JOptionPane.INFORMATION_MESSAGE);
					else if (clic ==3 && genre =="PolyStud")
						JOptionPane.showMessageDialog(f2,"Vous êtes diplomé"+"\n"+"Appuyer sur Quiter pour quitter la partie","Félicitations",JOptionPane.INFORMATION_MESSAGE) ;
					if(clic==4)
						JOptionPane.showMessageDialog(f2,"Vous êtes mort."+"\n"+"Appuyer sur Quiter pour quitter la partie.", "Déces", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		//Bouton courriger copies
		public class travaillerAction implements ActionListener{
			public void actionPerformed(ActionEvent corrigecopiesae){
				if (genre == "PolyProf" && sexe == "H"){
					hProf.travailler();
					if (hProf.getGagne())
						clic = 3 ;
					if(hProf.getEnVie()==false)
						clic=4 ;
					//if(hProf.getEn()<=20 && hProf.getAp()<=20 && (hProf.getAp()!=0 || hProf.getEn()!=0))
						//JOptionPane.showMessageDialog(f2,"Vous risquez de mourir."+"\n"+"Vous devez dormir et manger", "Attention", JOptionPane.WARNING_MESSAGE);
				}
				else if (genre == "PolyProf" && sexe == "F"){
					fProf.travailler();
					if (fProf.getGagne())
						clic = 3 ;
					if(fProf.getEnVie()==false)
						clic=4 ;
				}
				else if (genre == "PolyStud" && filiere == "Info" && sexe == "H"){
					hInfo.travailler();
					if (hInfo.getGagne())
						clic = 3 ;
					if(hInfo.getEnVie()==false)
						clic=4 ;
				}
				else if (genre =="PolyStud" && filiere=="Info" && sexe=="F"){
					fInfo.travailler();
					if (fInfo.getGagne())
						clic = 3 ;
					if(fInfo.getEnVie()==false)
						clic=4 ;
				}
				else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "H"){
					hGbma.travailler();
					if (hGbma.getGagne())
						clic = 3 ;
					if(hGbma.getEnVie()==false)
						clic=4 ;
				}
				else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "F"){
					fGbma.travailler();
					if (fGbma.getGagne())
						clic = 3 ;
					if(fGbma.getEnVie()==false)
						clic=4 ;
				}
				if (clic == 3 || clic ==4 ){
					prenom.setVisible(false);
					description.setVisible(false);
					question.setVisible(false);
					jauge.setVisible(false);
					btManger.setVisible(false) ;
					btBesoin.setVisible(false) ;
					btDeplacer.setVisible(false) ;
					btDormir.setVisible(false) ;
					btDoucher.setVisible(false) ;
					btTravailler.setVisible(false) ;
					btRaser.setVisible(false) ;
					btMaquiller.setVisible(false) ;
					btAllerTravailler.setVisible(false) ;
					btCommuniquer.setVisible(false) ;
					btImpliquerClubPolyHack.setVisible(false) ;
					btImpliquerClubPompom.setVisible(false) ;
					btTomberEnceinte.setVisible(false) ;
					horloge.setVisible(false);
					bouton.setText("Quitter");
					bouton.setVisible(true);
				}
				repaint() ;
				if(clic ==3 && genre =="PolyProf")
					JOptionPane.showMessageDialog(f2,"Vous êtes arrivé à la retraite."+"\n"+"Appuyer sur Quiter pour quitter la partie", "Félicitations", JOptionPane.INFORMATION_MESSAGE);
				else if (clic ==3 && genre =="PolyStud")
					JOptionPane.showMessageDialog(f2,"Vous êtes diplomé"+"\n"+"Appuyer sur Quiter pour quitter la partie","Félicitations",JOptionPane.INFORMATION_MESSAGE) ;
				if(clic==4)
					JOptionPane.showMessageDialog(f2,"Vous êtes mort."+"\n"+"Appuyer sur Quiter pour quitter la partie.", "Déces", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		//Bouton Communiquer
		public class communiquerAction implements ActionListener{
			public void actionPerformed(ActionEvent ae){
				nbClicBtCommuniquer ++ ;
				repaint() ;
			}
		}
		
		//Boutons Communiquer Divers
		public class communiquerDiversAction implements ActionListener{
			public void actionPerformed(ActionEvent ae){
				if(ae.getActionCommand()=="Parler"){
					if (genre == "PolyProf" && sexe == "H")
						hProf.communiquerParler();
					else if (genre == "PolyProf" && sexe == "F")
						fProf.communiquerParler();
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "H")
						hInfo.communiquerParler();
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "F")
						fInfo.communiquerParler();
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "H")
						hGbma.communiquerParler();
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "F")
						fGbma.communiquerParler();
				}
				else if (ae.getActionCommand()=="Rigoler"){
					if (genre == "PolyProf" && sexe == "H")
						hProf.communiquerRigoler();
					else if (genre == "PolyProf" && sexe == "F")
						fProf.communiquerRigoler();
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "H")
						hInfo.communiquerRigoler();
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "F")
						fInfo.communiquerRigoler();
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "H")
						hGbma.communiquerRigoler();
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "F")
						fGbma.communiquerRigoler();
				}
				else if (ae.getActionCommand()=="Critiquer"){
					if (genre == "PolyProf" && sexe == "H")
						hProf.communiquerCritiquer();
					else if (genre == "PolyProf" && sexe == "F")
						fProf.communiquerCritiquer();
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "H")
						hInfo.communiquerCritiquer();
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "F")
						fInfo.communiquerCritiquer();
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "H")
						hGbma.communiquerCritiquer();
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "F")
						fGbma.communiquerCritiquer();
				}
				else if (ae.getActionCommand()=="Engueuler"){
					if (genre == "PolyProf" && sexe == "H")
						hProf.communiquerEngueuler();
					else if (genre == "PolyProf" && sexe == "F")
						fProf.communiquerEngueuler();
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "H")
						hInfo.communiquerEngueuler();
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "F")
						fInfo.communiquerEngueuler();
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "H")
						hGbma.communiquerEngueuler();
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "F")
						fGbma.communiquerEngueuler();
				}
				else if (ae.getActionCommand()=="Se reproduire"){
					if (genre == "PolyProf" && sexe == "H")
						hProf.communiquerReproduire();
					else if (genre == "PolyProf" && sexe == "F")
						fProf.communiquerReproduire();
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "H")
						hInfo.communiquerReproduire();
					else if (genre == "PolyStud" && filiere == "Info" && sexe == "F")
						fInfo.communiquerReproduire();
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "H")
						hGbma.communiquerReproduire();
					else if (genre == "PolyStud" && filiere == "Gbma" && sexe == "F")
						fGbma.communiquerReproduire();
				}
				nbClicBtCommuniquer = 0 ;
				repaint() ;
			}
		}
		
		public class integrerClubAction implements ActionListener{
			public void actionPerformed(ActionEvent ae){
				if(ae.getActionCommand()=="Aider PolyHack"){
					if (sexe =="H")
						hInfo.implication_club();
					if (sexe =="F")
						fInfo.implication_club();
				}
				else if(ae.getActionCommand()=="Aider Pompom"){
					if (sexe =="H")
						hGbma.implication_club();
					if (sexe =="F")
						fGbma.implication_club();
				}
			}
		}
		
		public class enceinteAction implements ActionListener{
			public void actionPerformed(ActionEvent ae){
					fProf.tomberEnceinte();
			}
		}
		
		public class maquillerAction implements ActionListener{
			public void actionPerformed(ActionEvent ae){
				if(genre=="PolyProf")
					fProf.seMaquiller();
				else if (filiere =="Info")
					fInfo.seMaquiller();
				else if(filiere =="Gbma")
					fGbma.seMaquiller();
			}
		}
}
