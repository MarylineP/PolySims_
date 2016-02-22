package professeur;

import polysims.PolySims;

public abstract class PolyProf extends PolySims{
	
	/** DONNER UN COURS **/
	public void aller_travailler_spe(){
		jauge_travail = jauge_travail + 5 ;
	}
	
	/** CORRIGER DES COPIES **/
	public void travailler_spe(){
		heure = (heure + 2)%24 ;
		jauge_travail = jauge_travail + 3 ;	
	}
		
		
		
}
