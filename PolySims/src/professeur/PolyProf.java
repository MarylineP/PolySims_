package professeur;

import javax.swing.JOptionPane;

import polysims.PolySims;

public abstract class PolyProf extends PolySims{
	
	/** DONNER UN COURS **/
	public void aller_travailler_spe(){
		jauge_travail = jauge_travail + 5 ;
		JOptionPane.showMessageDialog(f2,"Vous avez donné des cours pendant 4h."+"\n"+"Vous avez augmenté votre jauge travail de 5.", "Cours", JOptionPane.INFORMATION_MESSAGE);

	}
	
	/** CORRIGER DES COPIES **/
	public void travailler_spe(){
		heure = (heure + 2)%24 ;
		jauge_travail = jauge_travail + 3 ;	
		JOptionPane.showMessageDialog(f2,"Vous avez mis 2h pour faire vos devoirs."+"\n"+"Vous avez augmenté votre jauge travail de 3.", "Devoirs", JOptionPane.INFORMATION_MESSAGE);
	}
		
		
		
}
