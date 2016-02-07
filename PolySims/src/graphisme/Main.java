package graphisme;

import java.awt.Frame;
import javax.swing.JFrame;

public class Main {
	public static void main (String[] args){
		int i = 0 ;
		Fenetre fenetre = new Fenetre("Les PolySims (TM) ", 10, 10, 1300, 700) ;
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
		
		
		//Rafistollage à modif !!!!!
		/*	while(fenetre.getClickF() != 3){
				System.out.println("boucle") ;
			}
			fenetre.AfficheTemps() ;
		*/
		
	}
}
