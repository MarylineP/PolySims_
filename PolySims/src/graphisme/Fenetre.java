package graphisme;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Fenetre extends JFrame {
	
	public Fenetre ( String titre, int x, int y , int l , int h){
		setTitle(titre) ;
		setBounds(x,y,l,h) ;
	
		Panneau1 p1 = new Panneau1 () ;
		add(p1) ;
		p1.commencer.addActionListener( 
			new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					p1.setVisible(false);
					Panneau2 p2 = new Panneau2() ;
					add(p2) ;
				} 
			} 
		);
		

	}

}
	
