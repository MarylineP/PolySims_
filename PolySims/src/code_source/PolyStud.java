package code_source;

public class PolyStud extends PolySimsAbstract{

	// Ce qui définit un PolyProf
	private String filiere ;
	
	/** ASSISTER A UN COURS **/
	public void aller_travailler_spe(){ 
		System.out.println("Votre PolySim va en cours");
		heure = heure + 4 ;
		jauge_travail = jauge_travail + 2 ;
		jauge_energie = jauge_energie - 20 ;
		jauge_appetit = jauge_appetit - 40 ;
	}
	
	/** FAIRE SES DEVOIRS **/
	public void travailler_spe(){ 
		System.out.println("Votre PolySim fait ses devoirs");
		heure = heure + 1 ;
		jauge_travail = jauge_travail + 5 ;
		jauge_energie = jauge_energie - 10 ;
	}
	
	/** S'IMPLIQUER DANS UN CLUB **/
	public void implication_club(){
		if(verifier.verif_implication_club()){
			System.out.println("Votre PolySim va à son club");
			heure = heure + 1 ;
			jauge_sociale = jauge_sociale + 30 ;
		}
	}
}
