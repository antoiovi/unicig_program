package com.antoiovi.unicig.project.unicig10640;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import com.jgoodies.forms.factories.FormFactory;
import com.antoiovi.unicig.project.commons.condotti.APanelCondLabel;
import com.antoiovi.unicig.project.commons.condotti.APanelCond;
import com.antoiovi.unicig.project.commons.condotti.APanelCondPrimSec;
import com.antoiovi.unicig.project.commons.condotti.DatiCondotto;

import java.awt.CardLayout;

public class APPiano extends JPanel {
int max_piani=10;
int npiani=10;
int pianocorrente=0;
private JPanel panel_1;
private JPanel panel_2;
private APanelCondLabel panel_label;
  
private List<APanelCondPrimSec> apcps_condotti;

private JPanel panel_condotti;
private JPanel panel;
private JButton btnBack;
private JLabel lbl_piano;
private JButton btnForward;
	/**
	 * Create the panel.
	 */
	public APPiano() {
		setLayout(new BorderLayout(0, 0));
		
		apcps_condotti=new ArrayList<APanelCondPrimSec>();
		
		for(int x=0;x<max_piani;x++){
			APanelCondPrimSec pannello=new APanelCondPrimSec ();
			apcps_condotti.add(pannello);
		}
		
		panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(75dlu;default)"),
				ColumnSpec.decode("right:max(123dlu;default)"),
				ColumnSpec.decode("left:max(125dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(280dlu;default)"),
				RowSpec.decode("top:default"),}));
		
		panel_2 = new JPanel();
		panel_1.add(panel_2, "2, 2, fill, fill");
		
		panel_label = new APanelCondLabel();
		panel_1.add(panel_label, "3, 2, fill, fill");

		panel_condotti = new JPanel();
		panel_1.add(panel_condotti, "4, 2, fill, fill");
		panel_condotti.setLayout(new CardLayout(0, 0));
		
		panel = new JPanel();
		panel_1.add(panel, "3, 3, 2, 1, center, center");
		
		btnBack = new JButton("<<");
		btnBack .setEnabled(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pianoBack();
			}
		});
		panel.add(btnBack);
		
		lbl_piano = new JLabel("0");
		panel.add(lbl_piano);
		
		btnForward = new JButton(">>");
		btnForward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			pianoForward();
			}
		});
		panel.add(btnForward);
		
		for(int x=0;x<max_piani;x++){
			APanelCondPrimSec pannello=new APanelCondPrimSec ();
			apcps_condotti.add(pannello);
			panel_condotti.add(pannello,x);
		}

	}
private void pianoBack(){
		
		
		pianocorrente--;
		btnForward.setEnabled(true);
		if(pianocorrente<0){
			pianocorrente=0;
			btnBack.setEnabled(false);
		}else{
		CardLayout cl=(CardLayout) panel_condotti.getLayout();
		cl.previous(panel_condotti);
		}
		lbl_piano.setText(String.valueOf(pianocorrente));
	}
	
	
	
	private void pianoForward(){
		pianocorrente++;
		btnBack.setEnabled(true);
		if(pianocorrente==npiani){
			pianocorrente=npiani-1;
			btnForward.setEnabled(false);
		}else{
			CardLayout cl=(CardLayout) panel_condotti.getLayout();
			cl.next(panel_condotti);
			}
		lbl_piano.setText(String.valueOf(pianocorrente));
	}
	public void setNpiani(int n_piani) {
		if(n_piani>max_piani || n_piani<1)
			return;
		this.npiani = n_piani;
	}
	
}
