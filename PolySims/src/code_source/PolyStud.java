package code_source;

public class PolyStud extends PolySims{

	// Ce qui définit un PolyProf
	private String filiere ;
	
	public PolyStud(){
	
	}
	
	/**
	 * Faire ses devoirs ->  1h , -10 energie  , +5 travail
	 */
	public void FaireDevoirs(){
		if (jauge_energie>10 && lieu == "Maison") {
			jauge_energie = jauge_energie - 10 ;
			jauge_travail = jauge_travail + 5 ; 
			heure = heure + 1 ;
			System.out.println(" Vous avez fait vos devoirs. \n Votre jauge de Travail est à "+ jauge_travail + " et votre energie est de " + jauge_energie) ;
			System.out.println("Il est " + heure +"h"+minute) ;
		}
		else
			System.out.println("Vous n'avez pas assez d'énergie pour faire vos devoirs. Votre jauge n'est qu'à " + jauge_energie + "\n Il faut dormir") ;
	}
}
