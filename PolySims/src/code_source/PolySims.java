package code_source;

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
	
	//Le temps
	protected int heure ;
	protected int minute ;
	
	/**
	 * Constructeur
	 */
	public PolySims(){
		
		
		jauge_energie = 100 ;
		jauge_hygiene = 100 ;
		jauge_besoins = 100 ;
		jauge_appetit = 100 ;
		jauge_sociale = 80 ;
		jauge_travail = 0 ;
		heure = 7 ;
		minute = 40 ;
		lieu = "Maison" ;
	/*	System.out.println(" jauge_energie = " + jauge_energie + 
								"\n jauge_hygiene = " + jauge_hygiene + 
								"\n jauge_besoins = " + jauge_besoins +
								"\n jauge_appetit = " + jauge_appetit +
								"\n jauge_sociale = " + jauge_sociale +
								"\n jauge_travail = " + jauge_travail);
			System.out.println("il est " + heure+"h"+minute) ;
	*/
	}
	
	
	public String getNom (String nom2){
		nom = nom2 ;
		return nom ;
	}
	
	public String getPrenom (String prenom2){
		prenom = prenom2 ;
		return prenom ;
	}
	
	public int getAge (int age2){
		age = age2 ;
		return age ;
	}
	
	
	
	/**
	 * Fonction dormir -> 6h  , -40 besoins  , -40 hygiene  , -30 appetit , 100 energie
	 */
	public void dormir(){
		if (jauge_energie == 100) 
			System.out.println(" Votre énergie est déjà à " + jauge_energie + " , vous n'avez pas besoin de dormir") ;
		if( lieu != "Maison")
			System.out.println("Vous ne pouvez pas dormir, vous n'etes pas chez vous.") ;
		else if (jauge_energie != 100 && lieu == "Maison"){
			jauge_energie = 100 ;
			heure = heure + 6 ;
			jauge_besoins = jauge_besoins - 40 ;
			jauge_hygiene = jauge_hygiene - 40 ;
			jauge_appetit = jauge_appetit - 30 ;
			System.out.println(" Vous avez bien dormi et votre énergie est à " + jauge_energie +
				"\n Vos besoins sont de " + jauge_besoins + " , votre appetit est de " + jauge_appetit +
				" et votre hygiene est de " + jauge_hygiene ) ;
		}	
	}
			
	
	/**
	 * Fonction se doucher
	 */
	public void seDoucher(){
		if (jauge_hygiene == 100)
			System.out.println(" Votre hygiene est déjà à " + jauge_hygiene + " , vous n'avez pas besoin de vous doucher") ;
		if( lieu != "Maison")
			System.out.println("Vous ne pouvez pas vous doucher, vous n'etes pas chez vous.") ;
		else {
			if( minute < 40)
				minute = minute + 20 ;
			else if (minute == 50){
				heure = heure + 1 ;
				minute = 10 ;
			}
			jauge_hygiene = 100 ;
			System.out.println(" Vous avez terminé de prendre votre douche et votre jauge est à " + jauge_hygiene ) ;
		}
	}
			
			
	/**
	 * Fonction aller aux toilettes -> 10 minutes  , jauge besoins au max 
	 */
	public void allerToilette(){
		if (jauge_besoins == 100) 
			System.out.println(" Vous n'avez pas besoin d'aller aux toilettes") ;
		else {
			if(minute < 50)
				minute = minute + 10 ;	
			else if (minute == 50){
				heure = heure + 1 ;
				minute = 00 ;
			}
		jauge_besoins = 100 ;
		System.out.println(" Vous avez fait un bon pipi et votre jauge est à " + jauge_besoins) ;
		System.out.println("Il est " + heure+"h"+minute) ;
		}
	}
	
	
	
	/**
	 * Fonction se deplacer -> 20 minutes  , -20 energie 
	 * @param s
	 */
	public void seDeplacer(String s){
		lieu = s ;
		if (jauge_energie > 20){
			if (minute < 40)
				minute = minute + 20 ;
			else if (minute == 40){
				minute = 00 ;
				heure = heure + 1 ;
			}
			else if (minute == 50){
				minute = 10 ;
				heure = heure + 1 ;
			}
		jauge_energie = jauge_energie - 20 ;
		System.out.println("Vous etes à " + lieu + " il est " + heure + "h" + minute+ " et votre énergie est à " +jauge_energie) ;
		}	
	}
	
	
	public void allerTravailler(){
		if (jauge_energie > 20 && jauge_appetit > 40 && lieu == "Ecole"){
			heure = heure + 4 ;
			jauge_appetit = jauge_appetit - 40 ;
			jauge_energie = jauge_energie - 20 ;
			jauge_travail = jauge_travail + 1 ;
			System.out.println("Vous etes à " + lieu + " il est " + heure + "h" + minute+ " "
					+ " votre énergie est à " +jauge_energie + " votre appetit est à " + jauge_appetit
					+ " et votre jauge de travail est de " + jauge_travail ) ;
		}	
		else if( lieu != "Ecole")
			System.out.println("Vous devez vous rendre à l'école.") ;
		else if( jauge_appetit < 40)
			System.out.println("Vous devez d'abord manger.") ;
		else if( jauge_energie <20)
			System.out.println("Vous etes trop fatigué pour travailler") ;
			
	}
}
