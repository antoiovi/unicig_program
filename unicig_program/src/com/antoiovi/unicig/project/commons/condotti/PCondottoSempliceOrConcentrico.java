package com.antoiovi.unicig.project.commons.condotti;

import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.InputVerifier;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import java.awt.BorderLayout;

import javax.swing.JPopupMenu;

import com.antoiovi.unicig.condotti.Condotto;
import com.antoiovi.unicig.condotti.CondottoBase;
import com.antoiovi.unicig.project.commons.JIF_Rugosita;
import com.antoiovi.unicig.tubi.Tubo;
import com.antoiovi.unicig.tubi.TuboC;
import com.antoiovi.unicig.tubi.TuboFactory;
import com.antoiovi.unicig.tubi.TuboQ;
import com.antoiovi.unicig.tubi.TuboR;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;

import java.awt.Color;

import javax.swing.JSpinner;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.swing.JFormattedTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import java.awt.Font;
import java.awt.CardLayout;
import javax.swing.JTextArea;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class PCondottoSempliceOrConcentrico extends JPanel implements
		ActionListener {
	private PCondotto pc_sing;
	private PCondottoConcentrico pcc_conc;
	private String selecetd = APCondotto.SINGOLO;
	private JPanel panelcard;
	private JComboBox comboBoxTipo;
	String titolo="";
	
	public PCondottoSempliceOrConcentrico() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(152dlu;default)"), }, new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"), }));

		JLabel label = new JLabel("New label");
		add(label, "2, 2");

		comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {
				APCondotto.SINGOLO, APCondotto.CONCENTRICO }));

		add(comboBoxTipo, "2, 4, fill, default");
		comboBoxTipo.setActionCommand(APCondotto.TIPO);
		comboBoxTipo.addActionListener(this);

		panelcard = new JPanel();
		add(panelcard, "2, 6, fill, fill");
		panelcard.setLayout(new CardLayout(0, 0));

		pc_sing = new PCondotto();
		panelcard.add(pc_sing, APCondotto.SINGOLO);

		pcc_conc = new PCondottoConcentrico();
		panelcard.add(pcc_conc, APCondotto.CONCENTRICO);
		// Inizzializza
		CardLayout cl=(CardLayout)panelcard.getLayout();
		cl.show(panelcard, APCondotto.SINGOLO);
		selecetd = APCondotto.SINGOLO;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	if(arg0.getActionCommand().equals(APCondotto.TIPO)){
		String sel=(String)comboBoxTipo.getModel().getSelectedItem();
		if(sel.equals(APCondotto.SINGOLO)){
			CardLayout cl=(CardLayout)panelcard.getLayout();
			cl.show(panelcard, APCondotto.SINGOLO);
			selecetd = APCondotto.SINGOLO;
		}else if(sel.equals(APCondotto.CONCENTRICO)){
			
			CardLayout cl=(CardLayout)panelcard.getLayout();
			cl.show(panelcard, APCondotto.CONCENTRICO);
			selecetd = APCondotto.CONCENTRICO;
		}
	}
		
		
	}

	public PCondotto getPc_sing() {
		return pc_sing;
	}

	public PCondottoConcentrico getPcc_conc() {
		return pcc_conc;
	}
	
	/**
	 * Utilizzato per copiare tutti i dati uguali
	 * @param pcsoc
	 */
	public void Copia(PCondottoSempliceOrConcentrico pcsoc){
		
	}

	public void setTitolo(String t){
		this.titolo=t;
		pc_sing.setTitolo(t);
		pcc_conc.setTitolo(t);
	}
}// FINE CLASSE PANEL TUBO
