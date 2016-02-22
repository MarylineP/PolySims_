package homme;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import etudiant.Info;

public class HInfo extends Info implements VerifierH{

	public void seRaser(){
		if(this.verif_seRaser()){
			jauge_hygiene = jauge_hygiene +5 ;
			if(minute+10 >= 60)
				heure = (heure + 1)%24 ;
			minute = (minute + 10)%60 ;
			JOptionPane.showMessageDialog(f2,"Vous avez mis 10 minutes pour vous raser.", "Rasage", JOptionPane.INFORMATION_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(f2,"Vous n'avez pas besoin de vous raser.", "Rasage", JOptionPane.INFORMATION_MESSAGE);
	}	
	
	public boolean verif_seRaser(){
		if(lieu=="maison" && jauge_hygiene!=100)
			return true ;
		else return false ;
	}
	public boolean verif_impliquerClub() {
		return false;
	}


	
}
