package femme;

import etudiant.Info;

public class FInfo extends Info implements VerifierF{

	public void seMaquiller(){
		//if (this.verif_seMaquiller()){
			jauge_sociale = jauge_sociale + 10 ;
			heure = (heure + 1)%24 ;   // bon c'est vrai que ca fait bcp, c'est que javais la flemme de toucher aux minutes :p
			if(jauge_sociale > 100) //pour éviter que la jauge sociale soit superieure à 100
				jauge_sociale = 100 ;
		//}
	}


	public void tomberEnceinte() {		
	}

	public void implication_club_spe() {		
	}

	@Override
	public void verif_seMaquiller() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void verif_tomberEnceinte() {
		// TODO Auto-generated method stub
		
	}
}
