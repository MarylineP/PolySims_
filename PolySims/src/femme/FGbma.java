package femme;

import javax.swing.JOptionPane;

import etudiant.Gbma;

public class FGbma extends Gbma implements VerifierF {

	public void seMaquiller(){
		if (this.verif_seMaquiller()){
			jauge_sociale = jauge_sociale + 10 ;
			if(minute+20 >= 60)
				heure = (heure + 1)%24 ;
			minute = (minute + 20)%60 ;
			if(jauge_sociale > 100) //pour éviter que la jauge sociale soit superieure à 100
				jauge_sociale = 100 ;
			JOptionPane.showMessageDialog(f2,"Vous avez mis 20 minutes pour vous maquiller.", "Maquillage", JOptionPane.INFORMATION_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(f2,"Vous n'avez pas besoin de vous maquiller.", "Maquillage", JOptionPane.INFORMATION_MESSAGE);
	}


	public boolean verif_seMaquiller() {
		if(jauge_hygiene<100)
			return true;
		else return false ;
	}
	public boolean verif_tomberEnceinte() {
		return false;
	}

	
}
