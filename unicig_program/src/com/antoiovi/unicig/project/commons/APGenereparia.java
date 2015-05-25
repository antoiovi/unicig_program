package com.antoiovi.unicig.project.commons;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.CardLayout;



import javax.swing.border.EtchedBorder;

import java.awt.Color;



public class APGenereparia extends JPanel {
	String title;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private APGeneratore ap_generatore;

	public APGenereparia() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(235dlu;default)"),
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default"),},
			new RowSpec[] {
				RowSpec.decode("max(297dlu;default)"),
				FormFactory.DEFAULT_ROWSPEC,}));
		
		
		// Pannello generatore
		
		JPanel panel_2 = new JPanel();
		add(panel_2, "3, 1, fill, fill");
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblGeneratoreDiCalore = new JLabel("Generatore di calore");
		panel_2.add(lblGeneratoreDiCalore, BorderLayout.NORTH);
		/**
		 * PANNELLO GENERATORE DI CALORE
		 */
		ap_generatore = new APGeneratore();
		panel_2.add(ap_generatore, BorderLayout.CENTER);
		ap_generatore.setLayout(new CardLayout(0, 0));
		
		// Pannello aria
		
		JPanel panel_3 = new JPanel();
		add(panel_3, "6, 1, fill, fill");
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPresaDaria = new JLabel("Presa d'aria");
		panel_3.add(lblPresaDaria, BorderLayout.NORTH);
		/**
		 * PANNELLO ARIA
		 */
		APParia ap_paria = new APParia();
		ap_paria.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, null));
		panel_3.add(ap_paria, BorderLayout.CENTER);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		ap_generatore.getLblTitle().setText(title);
		this.title = title;
	}

	
}
