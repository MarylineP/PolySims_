package code_source;

import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * 
 * @author Maryline
 *
 */

public class PolySims {
	//Ce que définit un PolySim
	protected String nom ;
	protected String prenom ;
	protected String sexe ;
	protected int age ; 
	protected String lieu ;
	
	//Les jauges
	protected int jauge_energie ;
	protected int jauge_hygiene ;
	protected int jauge_besoins ;
	protected int jauge_appetit ;
	protected int jauge_sociale ;
	protected int jauge_travail ;
	
	protected JTextArea jaugesDormir ;
	protected JTextArea jaugesManger ;
	protected JTextArea jaugesDoucher ;
	protected JTextArea jaugesBesoin ;
	protected JTextArea jaugesDeplacer ;
	protected JTextArea jaugesSocial ;
	protected JTextArea jaugesTravail ;
	
	
	//Attribut pour Verifier
	protected Verifier verifier ;
	
	//Le temps
	protected int heure ;
	protected int minute ;
	
	/**
	 * Constructeur
	 */
	public PolySims(){
		jauge_energie = 30 ;
		jauge_hygiene = 100 ;
		jauge_besoins = 100 ;
		jauge_appetit = 100 ;
		jauge_sociale = 80 ;
		jauge_travail = 0 ;
		heure = 7 ;
		minute = 40 ;
		lieu = "Maison" ;
		verifier = new Verifier(this) ;
	}
	
	
	public String setNom (String nom2){
		nom = nom2 ;
		return nom ;
	}	 	
	public String setPrenom (String prenom2){
		prenom = prenom2 ;
		return prenom ;
 	}	 	
	public int setAge (int age2){
 		age = age2 ;
 		return age ;
  	}
	

	//Getter lieu
	public String get_lieu(){
		return lieu ;
	}
	
	//Getter temps
	public int get_heure(){
		return heure ;
	}
	public int get_minute(){
		return minute ;
	}
	
	//Getter jauges
	public int getAp(){
		return jauge_appetit ;
	}
	public int getEn(){
		return jauge_energie ;
	}
	public int getBe(){
		return jauge_besoins ;
	}
	public int getHy(){
		return jauge_hygiene ;
	}
	public int getSo(){
		return jauge_sociale ;
	}
	public int getTr(){
		return jauge_travail ;
	}
	
	//Getter toutes les jauges apres avoir dormit
	public JTextArea getJaugesDormir(){
		return jaugesDormir ;
	}
	public JTextArea getJaugesManger(){
		return jaugesManger ;
	}
	public JTextArea getJaugesDoucher(){
		return jaugesDoucher ;
	}
	public JTextArea getJaugesBesoin(){
		return jaugesBesoin ;
	}
	public JTextArea getJaugesDeplacer(){
		return jaugesDeplacer ;
	}
	
	
	
	/**
	 * Fonction dormir -> 6h  , -40 besoins  , -40 hygiene  , -30 appetit , 100 energie
	 */
	public JTextArea dormir(){
		if (jauge_energie == 100) 
			System.out.println(" Votre énergie est déjà à " + jauge_energie + " , vous n'avez pas besoin de dormir") ;
		if( lieu != "Maison")
			System.out.println("Vous ne pouvez pas dormir, vous n'etes pas chez vous.") ;
		else if (verifier.verif_dormir()){
			System.out.println("Votre Sim est en train de dormir.") ;
			jauge_energie = 100 ;
			heure = heure + 6 ;
			jauge_besoins = jauge_besoins - 40 ;
			jauge_hygiene = jauge_hygiene - 40 ;
			jauge_appetit = jauge_appetit - 30 ;
			jaugesDormir = new JTextArea() ;
			jaugesDormir.setText("Energie : "+jauge_energie+"    Hygiene :"+jauge_hygiene+"    Besoins :"+jauge_besoins+
					"    Appetit :"+jauge_appetit+"   Social: "+jauge_sociale+"    Travail :"+jauge_travail);
			jaugesDormir.setVisible(true);
		}	
		return jaugesDormir ;
	}
			
	
	/**
	 * Fonction se doucher
	 */
	public JTextArea seDoucher(){
		if (jauge_hygiene == 100)
			System.out.println(" Votre hygiene est déjà à " + jauge_hygiene + " , vous n'avez pas besoin de vous doucher") ;
		if( lieu != "Maison")
			System.out.println("Vous ne pouvez pas vous doucher, vous n'etes pas chez vous.") ;
		else if (verifier.verif_se_doucher())
				{
		/*	if (minute + 20>=60)
				heure = heure + 1 ;
			minute = (minute + 20)%60 ;
		*/
			System.out.println("Vous vous douchez") ;
			jauge_hygiene = 100 ;
			jaugesDoucher = new JTextArea() ;
			jaugesDoucher.setText("Energie : "+jauge_energie+"    Hygiene :"+jauge_hygiene+"    Besoins :"+jauge_besoins+
					"    Appetit :"+jauge_appetit+"   Social: "+jauge_sociale+"    Travail :"+jauge_travail);
			jaugesDoucher.setVisible(true);
		}
		return jaugesDoucher ;
	}
			
			
	/**
	 * Fonction aller aux toilettes -> 10 minutes  , jauge besoins au max 
	 */
	public JTextArea allerToilette(){
		if (verifier.verif_aller_toilettes()) {
			System.out.println(" Votre Sim est au toilette.") ;
			if (minute + 10>=60)
				heure = heure + 1 ;
			minute = (minute + 10)%60 ;
			jauge_besoins = 100 ;
			jaugesBesoin = new JTextArea() ;
			jaugesBesoin.setText("Energie : "+jauge_energie+"    Hygiene :"+jauge_hygiene+"    Besoins :"+jauge_besoins+
					"    Appetit :"+jauge_appetit+"   Social: "+jauge_sociale+"    Travail :"+jauge_travail);
			jaugesBesoin.setVisible(true);
		}
		else System.out.println(" Vous n'avez pas besoin d'aller aux toilettes") ;
		return jaugesBesoin ;
	}
	
	
	
	
	/**
	 * Fonction se deplacer -> 20 minutes  , -20 energie 
	 * @param s
	 */
	public void seDeplacer(String s){
		if (verifier.verif_se_deplacer()){
			if (lieu == s)
				System.out.println(" Vous êtes déjà à : " + lieu  ) ;
			else {
				System.out.println(" Votre sims est en train de se deplacer.") ;
				lieu = s ;
				jauge_energie = jauge_energie - 20 ;
		
				if (minute +30>= 60)
					heure = heure + 1 ;
				minute = (minute + 30)%60  ;
				affichage() ;
			}
		}
		else 
			System.out.println("Vous etes à " + lieu + " il est " + heure + "h" + minute+ " et votre énergie est à " +jauge_energie) ;
	}
			
	/** MANGER **/
	public void manger(String type_nourriture){
		if(verifier.verif_manger()){
			System.out.println("Votre PolySim est en train de manger");
			if(type_nourriture == "boisson"){
				jauge_appetit = jauge_appetit + 10 ;
				if (minute+10>= 60)
					heure = heure + 1 ;
				minute = (minute + 10)%60  ;
			}
			else if(type_nourriture == "gouter"){
				jauge_appetit = jauge_appetit + 20 ;
				if (minute+10>= 60)
					heure = heure + 1 ;
				minute = (minute + 10)%60  ;
			}
			else if(type_nourriture == "repas"){
				jauge_appetit = jauge_appetit + 30 ;
				if (minute+20>= 60)
					heure = heure + 1 ;
				minute = (minute + 20)%60  ;
			}
			affichage();
		}
		else System.out.println("Vous n'avez pas besoin de manger: votre jauge d'appétit est déjà pleine");		
	}

	/** SE REPRODUIRE **/
	public void se_reproduire(){
		if(verifier.verif_se_reproduire()){
			System.out.println("Votre PolySim est en train de se reproduire");
			jauge_sociale = jauge_sociale + 50 ;
			jauge_energie = jauge_energie - 20 ;
			if (minute+20>= 60)
				heure = heure + 1 ;
			minute = (minute + 20)%60  ;					
			affichage();
		}
		else System.out.println("Vous êtes trop fatigué pour vous reproduire");
	}

	/** COMMUNIQUER **/
	public void communiquer(String type_comm){ //pas de conditions de verif ici
		System.out.println("Votre PolySim est en train de communiquer");
		if (minute+10>= 60)
			heure = heure + 1 ;
		minute = (minute + 10)%60  ;
		if(type_comm == "parler")
			jauge_sociale = jauge_sociale + 20 ;
		else if(type_comm == "rigoler")
			jauge_sociale = jauge_sociale + 30 ;
		else if(type_comm == "critiquer")
			jauge_sociale = jauge_sociale - 10 ;
		else if(type_comm == "engueuler")
			jauge_sociale = jauge_sociale - 20 ;	
		affichage();
	}

	
	/** AFFICHAGE JAUGES **/
	public void affichage(){
		System.out.println("=================================");
		System.out.println("*      jauge énergie: " + jauge_energie + "	*");
		System.out.println("*      jauge appetit: " + jauge_appetit + "	*");
		System.out.println("*      jauge hygiène: " + jauge_hygiene + "	*");
		System.out.println("*      jauge besoins: " + jauge_besoins + "	*");
		System.out.println("*      jauge sociale: " + jauge_sociale + "	*");
		System.out.println("*      jauge travail: " + jauge_travail + "		*");
		System.out.println("=================================");
		System.out.println("Il est " + heure + ":" + minute);
		System.out.println("\n");
	}
}