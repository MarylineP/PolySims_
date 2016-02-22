package polysims;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import graphisme.Fenetre2;

/**
 * 
 * @author Maryline
 *
 */

public abstract class PolySims implements Verifier {
	//Fenetre2 
	protected Fenetre2 f2 = new Fenetre2();
	
	//Ce que définit un PolySim
	protected String nom ;
	protected String prenom ;
	protected String sexe ;
	protected int age ; 
	protected String lieu ;
	
	//Les jauges
	protected int jauge_energie ;
	protected int jauge_hygiene ;
	protected int jauge_besoins ;
	protected int jauge_appetit ;
	protected int jauge_sociale ;
	protected int jauge_travail ;
	
	//Le temps
	protected int heure ;
	protected int minute ;
	
	//Si le Sim est en vie ou non 
	protected boolean enVie ;
	
	//Si le Sim a gagné ou non 
	protected boolean gagne ;
	
	/**
	 * Constructeur
	 */
	public PolySims(){
		jauge_energie = 100 ;
		jauge_hygiene = 100 ;
		jauge_besoins = 100 ;
		jauge_appetit = 100 ;
		jauge_sociale = 80 ;
		jauge_travail = 0 ;
		heure = 7 ;
		minute = 30 ;
		lieu = "maison" ;
		enVie = true ;
		gagne = false ;
	}
	
	//Setter
	public void setNom (String nom2){
		nom = nom2 ;
	}	 	
	public void setPrenom (String prenom2){
		prenom = prenom2 ;
 	}	 	
	public void setAge (int age2){
 		age = age2 ;
  	}
	public void setLieu (String lieu2){
		lieu=lieu2 ;
	}
	

	//Getter 
	public String getLieu(){
		return lieu ;
	}
	public int getHeure(){
		return heure ;
	}
	public int getMinute(){
		return minute ;
	}
	public boolean getGagne(){
		return gagne ;
	}
	public boolean getEnVie(){
		return enVie ;
	}
	
	
	//Getter jauges
	public int getAp(){
		return jauge_appetit ;
	}
	public int getEn(){
		return jauge_energie ;
	}
	public int getBe(){
		return jauge_besoins ;
	}
	public int getHy(){
		return jauge_hygiene ;
	}
	public int getSo(){
		return jauge_sociale ;
	}
	public int getTr(){
		return jauge_travail ;
	}
	
	
	/**
	 * Fonction dormir -> 6h  , -40 besoins  , -40 hygiene  , -30 appetit , 100 energie
	 */
	public void dormir(){
		if (this.verif_dormir()){
			jauge_energie = 100 ;
			heure =(heure + 6)%24 ;
			jauge_besoins = jauge_besoins - 40 ;
			jauge_hygiene = jauge_hygiene - 40 ;
			if(jauge_appetit>=30)
				jauge_appetit = jauge_appetit - 30 ;
			else if (jauge_appetit<30)
				jauge_appetit = 0 ;
			JOptionPane.showMessageDialog(f2,"Vous avez dormi 6h."+"\n"+"Vos jauges besoin et hygiène ont diminuées de 40%.","Bon réveil", JOptionPane.INFORMATION_MESSAGE);
		}	
		else 
			JOptionPane.showMessageDialog(f2,"Vous ne pouvez pas dormir."+"\n"+"Vous êtes déjà en forme ou vous avez besoin de vous douchez ou d'aller au toilette.", "Dormir", JOptionPane.INFORMATION_MESSAGE);
	}
			
	
	/**
	 * Fonction se doucher
	 */
	public void seDoucher(){
		if (this.verif_se_doucher()){
			if (minute + 20>=60)
				heure = (heure + 1)%24 ;
			minute = (minute + 20)%60 ;
			jauge_hygiene = 100 ;
			JOptionPane.showMessageDialog(f2,"Vous avez mis 20 minutes pour vous doucher.", "Bonne douche", JOptionPane.INFORMATION_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(f2,"Vous êtes déjà propre.", "Douche", JOptionPane.INFORMATION_MESSAGE);

	}
			
			
	/**
	 * Fonction aller aux toilettes -> 10 minutes  , jauge besoins au max 
	 */
	public void allerToilette(){
		if (this.verif_aller_toilettes()) {
			if (minute + 10>=60)
				heure = (heure + 1)%24 ;
			minute = (minute + 10)%60 ;
			jauge_besoins = 100 ;
			JOptionPane.showMessageDialog(f2,"Vous avez mis 10 minutes pour faire vos besoins.", "Soulagé", JOptionPane.INFORMATION_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(f2,"Vous n'avez pas besoin d'aller au toilette.", "Toilette", JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	
	/** MANGER BOISSON **/
	public void mangerBoisson(){
		if(this.verif_manger()){
			jauge_appetit = jauge_appetit + 10 ;
			if(minute+10 >= 60)
				heure = (heure + 1)%24 ;
			minute = (minute + 10)%60 ;
			if(jauge_appetit > 100)   //on ne veut pas que jauge_appetit > 100
				jauge_appetit = 100 ;
			JOptionPane.showMessageDialog(f2,"Vous avez mis 10 minutes pour boire de l'eau.", "Frigo", JOptionPane.INFORMATION_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(f2,"Vous n'avez pas besoin de boire.", "Frigo", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/** MANGER GOUTER **/
	public void mangerGouter(){
		if(this.verif_manger()){
			jauge_appetit = jauge_appetit + 20 ;
			if(minute+10 >= 60)
				heure = (heure + 1)%24;
			minute = (minute + 10)%60 ;
			if(jauge_appetit > 100)   //on ne veut pas que jauge_appetit > 100
				jauge_appetit = 100 ;
			JOptionPane.showMessageDialog(f2,"Vous avez mis 10 minutes pour goûter.", "Frigo", JOptionPane.INFORMATION_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(f2,"Vous n'avez pas besoin de manger.", "Frigo", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/** MANGER REPAS **/
	public void mangerRepas(){
		if(this.verif_manger()){
			jauge_appetit = jauge_appetit + 30 ;
			if(minute+20 >= 60)
				heure = (heure + 1)%24 ;
			minute = (minute + 20)%60 ;
			if(jauge_appetit > 100)   //on ne veut pas que jauge_appetit > 100
				jauge_appetit = 100 ;		
			JOptionPane.showMessageDialog(f2,"Vous avez mis 20 minutes pour manger.", "Frigo", JOptionPane.INFORMATION_MESSAGE);
		}	
		else
			JOptionPane.showMessageDialog(f2,"Vous n'avez pas besoin de manger.", "Frigo", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/** SE DEPLACER A LA MAISON **/
	public void seDeplacerMaison(){
		if(this.verif_se_deplacer()){ 
			lieu = "maison" ;
			jauge_energie = jauge_energie - 20 ;
			if(minute + 30>= 60)
				heure =(heure + 1)%24;
			minute = (minute + 30)%60 ;
			if(jauge_energie < 0)   
				jauge_energie = 0 ;
			JOptionPane.showMessageDialog(f2,"Vous avez mis 30 minutes pour rentrer chez vous."+"\n"+"Vous avez perdu 30% d'énergie.", "Maison", JOptionPane.INFORMATION_MESSAGE);
		}
		else 
			JOptionPane.showMessageDialog(f2,"Vous n'avez pas assez d'énergie pour vous déplacer.", "Se déplacer", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/** SE DEPLACER EN SOIREE **/
	public void seDeplacerSoiree(){
		if(this.verif_se_deplacer() && this.verif_se_deplacer_soiree()){ 
			lieu = "soiree" ;
			jauge_energie = jauge_energie - 20 ;
			if(minute + 30>= 60)
				heure = (heure + 1)%24 ;
			minute = (minute + 30)%60 ; 
			if(jauge_energie < 0)   
				jauge_energie = 0 ;
			JOptionPane.showMessageDialog(f2,"Vous avez mis 30 minutes pour aller en soirée."+"\n"+"Vous avez perdu 30% d'énergie.", "Soirée", JOptionPane.INFORMATION_MESSAGE);
		}
		else 
			JOptionPane.showMessageDialog(f2,"Vous ne pouvez vous rendre en soirée qu'à partir de 18h."+"\n"+"Reposez vous avant de partir.", "Déplacer", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/** SE DEPLACER A L'ECOLE **/
	public void seDeplacerEcole(){
		if(this.verif_se_deplacer() && this.verif_se_deplacer_ecole()){ 
			jauge_energie = jauge_energie - 20 ;
			if(minute + 30>= 60)
				heure = (heure + 1)%24 ;
			minute = (minute + 30)%60 ;
			lieu = "ecole" ;
			if(jauge_energie < 0)   
				jauge_energie = 0 ;
			JOptionPane.showMessageDialog(f2,"Vous avez mis 30 minutes pour aller à l'école."+"\n"+"Vous avez perdu 30% d'énergie.", "Ecole", JOptionPane.INFORMATION_MESSAGE);
		}
		else 
			JOptionPane.showMessageDialog(f2,"Vous ne pouvez vous rendre à l'école qu'à partir de 7h.", "Déplacer", JOptionPane.INFORMATION_MESSAGE);
	}	
	
	/** COMMUNIQUER PARLER **/
	public void communiquerParler(){ //pas de conditions de verif
		if(minute + 10 >= 60)
			heure = (heure + 1)%24 ;
		minute = (minute + 10)%60 ;
		jauge_sociale = jauge_sociale + 20 ;
		if(jauge_sociale > 100)   //on ne veut pas que jauge_sociale > 100
			jauge_sociale = 100 ;
		JOptionPane.showMessageDialog(f2,"Vous avez parlé à Fred pendant 10 minutes.", "Sociabiliser", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/** COMMUNIQUER RIGOLER **/
	public void communiquerRigoler(){ 
		if(minute + 10 >= 60)
			heure =(heure + 1)%24 ;
		minute = (minute + 10)%60 ;
		jauge_sociale = jauge_sociale + 30 ;
		
		if(jauge_sociale > 100)   //on ne veut pas que jauge_sociale > 100
			jauge_sociale = 100 ;
		JOptionPane.showMessageDialog(f2,"Vous avez rigolé avec Maxime pendant 10 minutes.", "Sociabiliser", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/** COMMUNIQUER CRITIQUER **/
	public void communiquerCritiquer(){ 
		if(minute + 10 >= 60)
			heure = (heure + 1)%24;
		minute = (minute + 10)%60 ;
		jauge_sociale = jauge_sociale - 10 ;
		
		if(jauge_sociale < 0) //on ne veut pas que jauge_sociale < 0
			jauge_sociale = 0 ;
		JOptionPane.showMessageDialog(f2,"Vous avez critiqué Lola pendant 10 minutes.", "Etre méchant", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/** COMMUNIQUER ENGUEULER **/
	public void communiquerEngueuler(){ 
		if(minute + 10 >= 60)
			heure = (heure + 1)%24 ;
		minute = (minute + 10)%60 ;
		jauge_sociale = jauge_sociale - 20 ;
		if(jauge_sociale < 0) //on ne veut pas que jauge_sociale < 0
			jauge_sociale = 0 ;
		JOptionPane.showMessageDialog(f2,"Vous avez engueuler Nicolas pendant 10 minutes.", "Etre méchant", JOptionPane.INFORMATION_MESSAGE);
	}

	
	/** SE REPRODUIRE **/
	public void communiquerReproduire(){
		if(this.verif_se_reproduire()){
			jauge_sociale = jauge_sociale + 50 ;
			jauge_energie = jauge_energie - 20 ;
			if (minute+20>= 60)
				heure = (heure + 1)%24 ;
			minute = (minute + 20)%60  ;
			if(jauge_sociale>100)
				jauge_sociale=100 ;
			JOptionPane.showMessageDialog(f2,"Vous avez fait des câlins avec votre ami pendant 20 minutes.", "Faire crac-crac", JOptionPane.INFORMATION_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(f2,"Vous êtes trop fatigué.", "Implication Club", JOptionPane.INFORMATION_MESSAGE);
		
	}

	public void travailler(){
		if( (this.verif_travailler()) ) {
			jauge_energie = jauge_energie - 10 ;
			travailler_spe();
			if ( this.verif_gagner()){
				jauge_travail = 100 ;
			}
			if (jauge_appetit==0)
				JOptionPane.showMessageDialog(f2,"Vous devez manger pour ne pas mourir.", "Vous avez faim", JOptionPane.WARNING_MESSAGE) ;
			if (jauge_energie==0)
				JOptionPane.showMessageDialog(f2,"Vous devez dormir pour ne pas mourir.", "Vous avez sommeil", JOptionPane.WARNING_MESSAGE) ;
			if ( this.verif_en_vie() == false){
				jauge_appetit =0 ;
				jauge_energie = 0 ;
			}
		}
		else 
			JOptionPane.showMessageDialog(f2,"Vous êtes trop fatigué pour travailler.", "Travailler", JOptionPane.INFORMATION_MESSAGE);
	}	
	public abstract void travailler_spe();

	public boolean allerTravailler(){
		if ( (this.verif_aller_travailler()) && this.verif_gagner()!= true){
			heure = (heure + 4)%24 ;
			jauge_energie = jauge_energie - 20 ;
			jauge_appetit = jauge_appetit - 40 ;
			aller_travailler_spe() ;
		}		
		else if (this.verif_gagner()){
			jauge_travail = 100 ;
			gagne = true ;
		}
		if (jauge_appetit==0)
			JOptionPane.showMessageDialog(f2,"Vous devez manger pour ne pas mourir.", "Vous avez faim", JOptionPane.WARNING_MESSAGE) ;
		if (jauge_energie==0)
			JOptionPane.showMessageDialog(f2,"Vous devez dormir pour ne pas mourir.", "Vous avez sommeil", JOptionPane.WARNING_MESSAGE) ;
		if ( this.verif_en_vie() == false){
			jauge_appetit =0 ;
			jauge_energie = 0 ;
		}
		return gagne ;
	}
	public abstract void aller_travailler_spe() ;

	
	public boolean verif_manger() {
		if(jauge_appetit != 100)  
			return true ;
		return false;
	}
	public boolean verif_dormir() {
		if((jauge_energie != 100) && (jauge_besoins >=40) && (jauge_hygiene >=40) )
			return true ;
		else return false ;	
	}
	public boolean verif_se_deplacer() {
		if(jauge_energie !=0)
			return true ;
		else return false ;
	}
	public boolean verif_se_deplacer_ecole(){
		if(heure>=7)
			return true ;
		else return false ;
	}
	public boolean verif_se_deplacer_soiree(){
		if(heure>=18)
			return true ;
		else 
			return false ;
	}
	public boolean verif_aller_toilettes() {
		if(jauge_besoins != 100)
			return true ;
		else return false;
	}
	public boolean verif_se_doucher() {
		if((jauge_hygiene != 100)&& (lieu == "maison"))
			return true ;
		else return false ;
	}
	public boolean verif_aller_travailler() {
		if((lieu == "ecole") && (jauge_energie>= 20) && (jauge_appetit>= 40))
			return true ;
		else return false ;
	}
	public boolean verif_travailler() {
		if((lieu == "maison" && jauge_energie>=10) )
			return true ;
		else return false ;
	}
	public boolean verif_se_reproduire() {
		if(jauge_energie >= 20)
			return true ;
		else return false ;
	}
	public boolean verif_gagner(){
		if (jauge_travail >= 100)
			gagne = true;
		return gagne;
	}
	public boolean verif_en_vie(){
		if((jauge_appetit == 0) && (jauge_energie == 0))
			enVie = false ;
		return enVie ;
	}
	
}