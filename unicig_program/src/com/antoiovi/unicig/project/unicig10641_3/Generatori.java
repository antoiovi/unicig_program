package com.antoiovi.unicig.project.unicig10641_3;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;

import com.antoiovi.unicig.project.JPCards;
import com.antoiovi.unicig.project.commons.APGeneratore;

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
			APGeneratore apgener=new APGeneratore();
			apgeneratori.add(apgener);
		}
		
		JPanel panel_img = new JPanel();
		//add(panel_img, BorderLayout.WEST);
		super.init(apgeneratori);
		super.setTitle("Generatori");
	}

}
