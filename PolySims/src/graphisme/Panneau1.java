package graphisme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import graphisme.Panneau2.JouerAction;

public class Panneau1 extends JPanel{
	public JButton commencer = new JButton("Démarrer");
	
	public Panneau1(){
		this.setBackground(Color.WHITE);
		this.add(commencer) ;
		this.setLayout(null);
		commencer.setBounds(1000,320,140,50);
	}
	
	public void paintComponent(Graphics g){		
		super.paintComponent(g);
	
		String fLogo = "C:\\Users\\Maryline\\git\\LocalGame\\PolySims\\src\\Logo_PolySims2.png";
		String fSims = "C:\\Users\\Maryline\\git\\LocalGame\\PolySims\\src\\Sims4.png";
		try {
			BufferedImage iLogo = ImageIO.read(new File(fLogo)) ;
			BufferedImage iSims = ImageIO.read(new File(fSims)) ;
			g.drawImage(iLogo, 400, 50, null) ;
			g.drawImage(iSims, 50, 250, null) ;
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
