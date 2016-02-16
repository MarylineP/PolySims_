package graphisme;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Temps extends JPanel{
	private int heure=7,minute=40,seconde=0;
	private int delais=130;
 
	private JLabel labelTemps=new JLabel(""+heure+":"+minute+":"+seconde);
	private ActionListener tache_timer;
	private Timer timer1;
	
	public Temps(){
		//Positionnement de merde !!!!!!
		
		//Ajout de notre Jlabel au composant fenetre
		this.add(labelTemps, BorderLayout.EAST);
		//this.setLayout(null) ;
		this.setBackground(Color.WHITE);
		
		chrono();
	}
	
 

	public void chrono(){
			tache_timer= new ActionListener()  {
			  public void actionPerformed(ActionEvent e1)  {
			    seconde++;
			    if(seconde==60)  {
			    	seconde = 0 ;
			         minute++;
			     }
			    if(minute==60) {
			    	minute=0;
			    	heure++;
			    }
			  //Afficher le chrono dans un JLabel
			  labelTemps.setText(heure+":"+minute+":"+seconde);
			  //labelTemps.setLayout(null) ;
			  //labelTemps.setLayout(new FlowLayout(FlowLayout.RIGHT));
			 }
	     };
	     //Action et temps execution de la tache
	     timer1=new Timer(delais,tache_timer);
	     
	     //Demarrer le chrono
	     timer1.start();
		
	}
}
