package code_source;

public class Polyprof extends PolySims{
	
	// Ce qui d�finit un PolyProf
	private String matiere_enseign�e ;
		
	
	/**
	 * Fonction corrigerCopies-> 1h , -30 energie  ,  -10 besoin  , + 10 travail
	 */
	public void corrigerCopies(){
		if (jauge_energie>30) {
			jauge_energie = jauge_energie - 30 ;
			jauge_travail = jauge_travail + 10 ; 
			heure = heure + 1 ;
			System.out.println(" Vous avez corriger 15 copies. \n Votre jauge de Travail est � "+ jauge_travail + " et votre energie est de " + jauge_energie) ;
			System.out.println("Il est " + heure +"h"+minute) ;
		}
		else
			System.out.println("Vous n'avez pas assez d'�nergie pour corriger les copies. Votre jauge n'est qu'� " + jauge_energie + "\n Il faut dormir") ;
	}
		
		
		
}
