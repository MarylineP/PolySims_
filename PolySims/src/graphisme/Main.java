package graphisme;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main {
	public static void main (String[] args){

		Fenetre fenetre = new Fenetre("Les PolySims (TM) ", 10, 10, 1300, 700) ;
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		fenetre.setLocation(dim.width/2 - fenetre.getWidth()/2, dim.height/2 - fenetre.getHeight()/2);
		fenetre.setVisible(true);		
	}
}
