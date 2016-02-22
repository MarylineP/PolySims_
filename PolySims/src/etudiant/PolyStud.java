package etudiant;

import javax.swing.JOptionPane;

import polysims.PolySims;

public abstract class PolyStud extends PolySims implements VerifierEtudiant{

	// Ce qui définit un PolyProf
	protected String filiere ;
	
	/** ASSISTER A UN COURS **/
	public void aller_travailler_spe(){ 
		jauge_travail = jauge_travail + 4 ;
		JOptionPane.showMessageDialog(f2,"Vous avez eu cours pendant 4h."+"\n"+"Vous avez augmenté votre jauge travail de 4.", "Cours", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/** FAIRE SES DEVOIRS **/
	public void travailler_spe(){ 
		heure = (heure + 1)%24 ;
		jauge_travail = jauge_travail + 4 ;	
		JOptionPane.showMessageDialog(f2,"Vous avez mis 1h pour faire vos devoirs."+"\n"+"Vous avez augmenté votre jauge travail de 4.", "Devoirs", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/** S'IMPLIQUER DANS UN CLUB **/
	public void implication_club(){
		if(verif_impliquerClub()){
			heure = (heure + 1)%24 ;
			implication_club_spe() ;
			if (jauge_sociale > 100)
				jauge_sociale = 100 ; //pour eviter que la jau&ge sociale soit superieure a 100
			JOptionPane.showMessageDialog(f2,"Vous avez êtes impliquer dans votre club pendant 1h.", "Implication Club", JOptionPane.INFORMATION_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(f2,"Vous êtes trop fatigué.", "Implication Club", JOptionPane.INFORMATION_MESSAGE);
	}
	public abstract void implication_club_spe() ;

	public boolean verif_impliquerClub() {
		if(jauge_energie >=20)  
			return true ;
		return false;
	}
}

