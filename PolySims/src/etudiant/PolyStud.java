package etudiant;

import polysims.PolySims;

public abstract class PolyStud extends PolySims{

	// Ce qui définit un PolyProf
	protected String filiere ;
	
	/** ASSISTER A UN COURS **/
	public void aller_travailler_spe(){ 
		jauge_travail = jauge_travail + 4 ;
	}
	
	/** FAIRE SES DEVOIRS **/
	public void travailler_spe(){ 
		heure = (heure + 1)%24 ;
		jauge_travail = jauge_travail + 4 ;					
	}
	
	/** S'IMPLIQUER DANS UN CLUB **/
	public void implication_club(){
		if(this.verif_implication_club()) {
			if(verif_implication_club()){
				heure = (heure + 1)%24 ;
				implication_club_spe() ;
				if (jauge_sociale > 100)
					jauge_sociale = 100 ; //pour eviter que la jau&ge sociale soit superieure a 100
			}
		}
	}
	public abstract void implication_club_spe() ;
}
