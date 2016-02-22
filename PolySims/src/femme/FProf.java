package femme;

import javax.swing.JOptionPane;

import professeur.PolyProf;

public class FProf extends PolyProf implements VerifierF {

	private boolean enceinte ;
	
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
	
	public void tomberEnceinte(){
		if(this.verif_tomberEnceinte()){
			jauge_sociale=100 ;
			enceinte = true ;
			if(minute+10 >= 60)
				heure = (heure + 1)%24 ;
			minute = (minute + 10)%60 ;
			JOptionPane.showMessageDialog(f2,"Vous êtes enceinte.", "Félicitations", JOptionPane.INFORMATION_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(f2,"Vous ne connaissez pas assez votre partenaire pour tomber enceinte.", "Tomber enceinte", JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	
	public boolean verif_seMaquiller() {
		if(jauge_hygiene<100)
			return true;
		else return false ;	
	}
	public boolean verif_tomberEnceinte() {
		if(jauge_sociale>=80)
			return true;
		else return false ;
	}
}
