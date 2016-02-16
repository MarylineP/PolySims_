package professeur;

import polysims.PolySims;

public abstract class PolyProf extends PolySims{

	/** DONNER UN COURS **/
	public void aller_travailler_spe(){
		System.out.println("Votre PolySim donne un cours");
		heure = heure + 4 ;
		jauge_travail = jauge_travail + 4 ; //diffère du polystud
		jauge_energie = jauge_energie - 20 ;
		jauge_appetit = jauge_appetit - 40 ;
	}
	
	/** CORRIGER DES COPIES **/
	public void travailler_spe(){
		System.out.println("Votre PolySim corrige des copies");
		heure = heure + 2 ; //diffère du polystud
		jauge_travail = jauge_travail + 3 ;
		jauge_energie = jauge_energie - 10 ;
	}
		
		
		
}
