package com.antoiovi.unicig.project.unicig10640;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.CardLayout;
import com.antoiovi.unicig.project.commons.condotti.APCondottiSempl;
import com.antoiovi.unicig.project.commons.condotti.APanelCond;

public class APGenereparia extends JPanel {
	String title;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private APGeneratore ap_generatore;

	public APGenereparia() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(136dlu;default)"),
				ColumnSpec.decode("max(235dlu;default)"),
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("default:grow"),
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JPanel jp_canale = new JPanel();
		add(jp_canale, "1, 1, fill, fill");
		jp_canale.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCanaleDaFumo = new JLabel("Canale da fumo");
		jp_canale.add(lblCanaleDaFumo, BorderLayout.NORTH);
		
		JPanel panel_canale = new JPanel();
		jp_canale.add(panel_canale, BorderLayout.CENTER);
		panel_canale.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("right:170px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:max(75dlu;default)"),},
			new RowSpec[] {
				RowSpec.decode("475px"),}));
		
		APCondottiSempl ap_lblcondotti = new APCondottiSempl();
		panel_canale.add(ap_lblcondotti, "1, 1, fill, top");
		ap_lblcondotti.setLayout(new CardLayout(0, 0));
		
		APanelCond apc_canale = new APanelCond();
		panel_canale.add(apc_canale, "3, 1, fill, fill");
		
		JPanel panel_2 = new JPanel();
		add(panel_2, "2, 1, fill, fill");
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblGeneratoreDiCalore = new JLabel("Generatore di calore");
		panel_2.add(lblGeneratoreDiCalore, BorderLayout.NORTH);
		
		ap_generatore = new APGeneratore();
		panel_2.add(ap_generatore, BorderLayout.CENTER);
		ap_generatore.setLayout(new CardLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		add(panel_3, "3, 1, fill, fill");
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPresaDaria = new JLabel("Presa d'aria");
		panel_3.add(lblPresaDaria, BorderLayout.NORTH);
		
		APParia ap_paria = new APParia();
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
