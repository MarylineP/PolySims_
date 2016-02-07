package graphisme;

import java.awt.BorderLayout;

import javax.swing.JFrame;



public class Fenetre extends JFrame {
	Panneau panneau = new Panneau () ;
	Temps temps = new Temps() ;
	
	public Fenetre ( String titre, int x, int y , int l , int h){
		setTitle(titre) ;
		setBounds(x,y,l,h) ;
		//Panneau avec Timer
		//add(temps, BorderLayout.EAST) ;
		//Panneau Jeu
		add(panneau, BorderLayout.CENTER) ;	
		
		//Timer invisible 
		//temps.setVisible(false);
	}
		
	public int getClickF(){
		return panneau.getClicP() ;
	}
	
	
	/*public void AfficheTemps(){
	//Apparition Timer pour le jeu
		if(panneau.getTime()==true){
			System.out.println(true) ;
			temps.setVisible(true);
		}
	}*/
}
	
