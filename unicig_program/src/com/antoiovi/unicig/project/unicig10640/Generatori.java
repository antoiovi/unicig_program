package com.antoiovi.unicig.project.unicig10640;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.antoiovi.unicig.project.JPCards;
import com.antoiovi.unicig.project.commons.APGenereparia;;

public class Generatori extends JPCards {
	
private List<JPanel> apgeneratori;
	
	/**
	 * Create the panel.
	 */
	public Generatori() {
		super();
		//setLayout(new BorderLayout(0, 0));
		
		apgeneratori=new ArrayList<JPanel>();
		for(int x=0;x<maxpiani;x++){
			APGenereparia apgener=new APGenereparia();
			apgeneratori.add(apgener);
		}
		
		JPanel panel_img = new JPanel();
		//add(panel_img, BorderLayout.WEST);
		super.init(apgeneratori);
		super.setTitle("Generatori");
	}
}
