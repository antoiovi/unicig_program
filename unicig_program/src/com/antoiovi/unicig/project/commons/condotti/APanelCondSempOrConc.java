package com.antoiovi.unicig.project.commons.condotti;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class APanelCondSempOrConc extends JPanel {
	JPanel parentpanel;
	JPanel panel_sing_selectTipo;
	JPanel panel_conc_selectTipo;
	JPanel panel_conc_selectTipo_e;
	
	APanelCond panelCCint;
	APanelCond panelCCest;
	
	JComboBox comboBox_singolo;
	JComboBox comboBox_concentrico;
	
	public APanelCondSempOrConc() {
		parentpanel=this;
		setLayout(new CardLayout(0, 0));
		
		APanelCond apanelcond = new APanelCond();
		apanelcond.getComboBoxTipo().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tipo=(String )comboBox_singolo.getModel().getSelectedItem();
				CardLayout cl=(CardLayout)parentpanel.getLayout();
				System.out.println(arg0.getActionCommand());
				if(tipo.equals("Singolo")){
					comboBox_concentrico.setSelectedIndex(0);
					cl.first(parentpanel);
				}else if(tipo.equals("Concentrico")){
					comboBox_concentrico.setSelectedIndex(1);
					cl.last(parentpanel);
				}
			}
		});
		add(apanelcond, "name_9375290927662");
		panel_sing_selectTipo=apanelcond .getPanelSelectTipo();
		 	CardLayout cl=(CardLayout)panel_sing_selectTipo.getLayout();
			cl.first(panel_sing_selectTipo);// mostra il comboBoxTipo
			comboBox_singolo=apanelcond.getComboBoxTipo();
			comboBox_singolo.setEnabled(true);
			
		//panel_sing_selectTipo.getp
		
		APanelCondConc apanelcondconc = new APanelCondConc();
		apanelcondconc.getPanel_int().getComboBoxTipo().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl=(CardLayout)parentpanel.getLayout();
				System.out.println(e.getActionCommand());
				String tipo=(String )comboBox_concentrico.getModel().getSelectedItem();
				System.out.println(tipo);
				if(tipo.equals("Singolo")){
					comboBox_singolo.setSelectedIndex(0);
					cl.first(parentpanel);
				}else if(tipo.equals("Concentrico")){
					comboBox_singolo.setSelectedIndex(1);
					cl.last(parentpanel);
				}
				
			}
		});
		add(apanelcondconc, "name_9380801493032");

		panelCCint=apanelcondconc.getPanel_int();
		panelCCest=apanelcondconc.getPanel_est();
		
		panel_conc_selectTipo=panelCCint.getPanelSelectTipo();
		panel_conc_selectTipo_e=panelCCest.getPanelSelectTipo();
	 	CardLayout cl2=(CardLayout)panel_conc_selectTipo.getLayout();
		cl2.first(panel_conc_selectTipo);// mostra il comboBoxTipo
		comboBox_concentrico=panelCCint.getComboBoxTipo();
		comboBox_concentrico.setEnabled(true);
	
		
		
		
		
		//		apanelcondconc.get
		//panel_conc_selectTipo=apanelcondconc.getp
		
	}

}
