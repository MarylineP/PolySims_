package graphisme;

import java.awt.BorderLayout;

import javax.swing.JFrame;



public class Fenetre extends JFrame {
	Panneau panneau = new Panneau () ;

	
	public Fenetre ( String titre, int x, int y , int l , int h){
	
		setTitle(titre) ;
		setBounds(x,y,l,h) ;
		add(panneau) ;
		
	
		
		
	}
}
