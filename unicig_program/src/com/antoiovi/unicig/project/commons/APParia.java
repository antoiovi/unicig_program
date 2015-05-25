package com.antoiovi.unicig.project.commons;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JSpinner;

public class APParia extends JPanel {

	/**
	 * Create the panel.
	 */
	public APParia() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("178px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("center:max(30dlu;default)"),},
			new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel_2 = new JLabel("Interruttore rompi tiraggio");
		add(lblNewLabel_2, "1, 1");
		
		JLabel lblNewLabel = new JLabel("Superficie netta [m2]");
		add(lblNewLabel, "1, 3");
		
		JSpinner spinner = new JSpinner();
		add(spinner, "3, 3, fill, default");
		
		JLabel lblNewLabel_1 = new JLabel("Coefficiente perdita localizzata");
		add(lblNewLabel_1, "1, 5");
		
		JSpinner spinner_1 = new JSpinner();
		add(spinner_1, "3, 5, fill, default");
		
		JLabel lblNewLabel_3 = new JLabel("Presa d'aria");
		add(lblNewLabel_3, "1, 9");
		
		JLabel lblNewLabel_4 = new JLabel("Superficie netta [m2]");
		add(lblNewLabel_4, "1, 11");
		
		JSpinner spinner_2 = new JSpinner();
		add(spinner_2, "3, 11, fill, default");
		
		JLabel lblNewLabel_5 = new JLabel("Coefficiente perdita localizzata");
		add(lblNewLabel_5, "1, 13");
		
		JSpinner spinner_3 = new JSpinner();
		add(spinner_3, "3, 13, fill, default");
		
		JLabel lblTemperaturaAmbiente = new JLabel("Temperatura ambiente");
		add(lblTemperaturaAmbiente, "1, 17");
		
		JLabel lblTemperaturaEsterna = new JLabel("Temperatura esterna [\u00B0C]\r\n");
		add(lblTemperaturaEsterna, "1, 19");
		
		JSpinner spinner_4 = new JSpinner();
		add(spinner_4, "3, 19, fill, default");
		
		JLabel lblTemperaturaLocaleCaldaia = new JLabel("Temperatura locale caldaia [\u00B0C]\r\n");
		add(lblTemperaturaLocaleCaldaia, "1, 21");
		
		JSpinner spinner_5 = new JSpinner();
		add(spinner_5, "3, 21, fill, default");

	}

}
