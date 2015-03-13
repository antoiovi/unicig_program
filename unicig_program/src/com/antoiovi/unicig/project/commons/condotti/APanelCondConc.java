package com.antoiovi.unicig.project.commons.condotti;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import com.antoiovi.unicig.condotti.Condotto;
import com.antoiovi.unicig.project.menu.IMenu;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

//import com.antoiovi.calctermodin.panels.APanelTubo_2;

public class APanelCondConc extends JPanel implements APCondotto {
	APCondotto condotto_int;
	APCondotto condotto_est;
	JComboBox coboxsezest;

	/**
	 * 
	 * Lista di APconodtti collegati a cui fare seguire alcune azioni : 1-quando
	 * cambio la forma di questa entità,allora cambia la forma di tutti gli
	 * oggetti du questa lista
	 * 
	 */
	List<APCondotto> apcondotti;
	JComboBox cmbxTipo;
	private APanelCond panel_int;
	public APanelCond getPanel_int() {
		return panel_int;
	}

	public APanelCond getPanel_est() {
		return panel_est;
	}

	private APanelCond panel_est;

	/**
	 * Create the panel.
	 */
	public APanelCondConc() {
		setLayout(new GridLayout(0, 2, 0, 0));
		/**
		 * Condotto interno
		 */
		panel_int = new APanelCond();
		condotto_int = panel_int;
		add(panel_int);
		panel_int.getTxtSelectedTipo().setText("Condotto");
		CardLayout cl = (CardLayout) panel_int.getPanelSelectTipo().getLayout();
		cl.last(panel_int.getPanelSelectTipo());

		/**
		 * Condotto esterno
		 */
		panel_est = new APanelCond();
		condotto_est = panel_est;
		panel_est.getTxtSelectedTipo().setText(" concentrico");
		add(panel_est);
		CardLayout cle = (CardLayout) panel_est.getPanelSelectTipo()
				.getLayout();
		cle.last(panel_est.getPanelSelectTipo());

		condotto_int.setTipo("Interno");
		condotto_est.setTipo("Esterno");
		condotto_est.setTitolo("");

		cmbxTipo = panel_int.getComboBoxTipo();
		cmbxTipo.setModel(new DefaultComboBoxModel(new String[] {"Singolo", "Concentrico"}));
		panel_est.getComboBoxTipo().setVisible(false);

		/**
		 * CONDOTTO ESTERNO NON EDITABILE IL TIPO DISEZIONE
		 */
		coboxsezest = panel_est.getComboBoxSezione();
		coboxsezest.setEnabled(false);
		/**
		 * se cambio il tipo di sezione del condotto interno cambia anche il
		 * tipo del condotto esterno
		 */
		condotto_int.addAPCondottoRealted(condotto_est);
		// coboxsezinte.setVisible(false);
		/**
		 * 
		 */
		apcondotti = new ArrayList<APCondotto>();
	}

	/**
	 * IMPLEMENTAZIONE METODI APCondoitti
	 */
	@Override
	public void setTitolo(String arg0) {
		condotto_int.setTitolo(arg0);
	}

	@Override
	public void setTipo(String arg0) {
	}

	@Override
	public void quadrato() {
		// TODO Auto-generated method stub

	}

	@Override
	public void rettangolare() {
		// TODO Auto-generated method stub

	}

	@Override
	public void circolare() {
		condotto_int.circolare();

	}

	@Override
	public void setAPCondottiRealted(List<APCondotto> apcondotti) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAPCondottoRealted(APCondotto apcondotto) {
		// TODO Auto-generated method stub

	}

	@Override
	public Condotto getCondotto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void quadrato(List<APCondotto> apcondotti_temp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rettangolare(List<APCondotto> apcondotti_temp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void circolare(List<APCondotto> apcondotti_temp) {
		// TODO Auto-generated method stub

	}

}
