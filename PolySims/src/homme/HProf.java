package homme;

import javax.swing.JTextArea;

import professeur.PolyProf;

public class HProf extends PolyProf{
	
	public void seRaser(){
		if(jauge_hygiene != 100){
		jauge_hygiene = jauge_hygiene +5 ;
		}
	}
}
