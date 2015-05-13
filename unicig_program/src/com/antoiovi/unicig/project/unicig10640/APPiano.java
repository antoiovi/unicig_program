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
int pianocorrente=1;
private JButton btnBack;
private JButton btnForward;
private JLabel lbl_piano;
private JPanel panel_1;
private JPanel panel_2;
private APanelCondLabel panel_label;
private APanelCond apc_primario;
private APanelCond apc_secondario;
private APanelCondPrimSec apc_primsec;
private List<APanelCondPrimSec> apcps_condotti;
private List<DatiCondotto> datiCondotti;
private JPanel panel_condotti;
	/**
	 * Create the panel.
	 */
	public APPiano() {
		datiCondotti =new ArrayList<DatiCondotto>();
		apcps_condotti=new ArrayList<APanelCondPrimSec>();
		
		
		for(int x=0;x<max_piani;x++){
			APanelCondPrimSec pannello=new APanelCondPrimSec ();
			apcps_condotti.add(pannello);
			DatiCondotto piano=new DatiCondotto();
			datiCondotti.add(piano);
		}
		setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		btnBack = new JButton("<<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pianoBack();
			}
		});
		panel.add(btnBack);
		
		lbl_piano = new JLabel("New label");
		panel.add(lbl_piano);
		
		btnForward = new JButton(">>");
		btnForward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pianoForward();
			}
		});
		panel.add(btnForward);
		
		panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(75dlu;default)"),
				ColumnSpec.decode("left:max(123dlu;default)"),
				ColumnSpec.decode("max(89dlu;default)"),
				ColumnSpec.decode("right:max(71dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(280dlu;default):grow"),
				FormFactory.DEFAULT_ROWSPEC,}));
		
		panel_2 = new JPanel();
		panel_1.add(panel_2, "2, 2, fill, fill");
		
		panel_label = new APanelCondLabel();
		panel_1.add(panel_label, "3, 2, fill, fill");
		
		apc_secondario = new APanelCond();
		panel_1.add(apc_secondario, "4, 2, default, top");
		
		apc_primario = new APanelCond();
		panel_1.add(apc_primario, "5, 2, fill, fill");
		
		panel_condotti = new JPanel();
		panel_1.add(panel_condotti, "7, 2, fill, fill");
		panel_condotti.setLayout(new CardLayout(0, 0));
		
		for(int x=0;x<max_piani;x++){
			APanelCondPrimSec pannello=new APanelCondPrimSec ();
			apcps_condotti.add(pannello);
			panel_condotti.add(pannello,x);
			DatiCondotto piano=new DatiCondotto();
			datiCondotti.add(piano);
		}

	}

	
	private void pianoBack(){
		
		
		pianocorrente--;
		btnForward.setEnabled(true);
		if(pianocorrente==0){
			pianocorrente=1;
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
		if(pianocorrente>max_piani){
			pianocorrente=max_piani;
			btnForward.setEnabled(false);
		}else{
			CardLayout cl=(CardLayout) panel_condotti.getLayout();
			cl.next(panel_condotti);
			}
		lbl_piano.setText(String.valueOf(pianocorrente));
	}
	
	/*private class DatiCondotto{
	
	String sezione;
	double diam; 
	double latoa;
	double latob;
	double spess;
	double ruog;
	double reter;
	double alt;
	double sviluppo;
	double perdite;
	
	}*/
}
