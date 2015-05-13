package com.antoiovi.unicig.project.unicig10640;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JSpinner;
import java.awt.Insets;
import javax.swing.SpinnerNumberModel;

public class APEdificio extends JPanel  {

	/**
	 * Create the panel.
	 */
	public APEdificio() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JPanel panel = new JPanel();
		add(panel, "2, 2, fill, fill");
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "3, 2, fill, fill");
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNumeroPiani = new JLabel("Numero piani");
		GridBagConstraints gbc_lblNumeroPiani = new GridBagConstraints();
		gbc_lblNumeroPiani.insets = new Insets(0, 2, 5, 5);
		gbc_lblNumeroPiani.gridx = 0;
		gbc_lblNumeroPiani.gridy = 0;
		panel_1.add(lblNumeroPiani, gbc_lblNumeroPiani);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 1;
		gbc_spinner.gridy = 0;
		panel_1.add(spinner, gbc_spinner);
		
		JLabel lblComignolo = new JLabel("Comignolo");
		GridBagConstraints gbc_lblComignolo = new GridBagConstraints();
		gbc_lblComignolo.insets = new Insets(0, 0, 5, 5);
		gbc_lblComignolo.gridx = 0;
		gbc_lblComignolo.gridy = 1;
		panel_1.add(lblComignolo, gbc_lblComignolo);
		
		JLabel lblCoefficienteDiCarico = new JLabel("Coefficiente di carico");
		GridBagConstraints gbc_lblCoefficienteDiCarico = new GridBagConstraints();
		gbc_lblCoefficienteDiCarico.insets = new Insets(0, 0, 0, 5);
		gbc_lblCoefficienteDiCarico.gridx = 1;
		gbc_lblCoefficienteDiCarico.gridy = 2;
		panel_1.add(lblCoefficienteDiCarico, gbc_lblCoefficienteDiCarico);
		
		JSpinner spinner_1 = new JSpinner();
		GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
		gbc_spinner_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_1.gridwidth = 2;
		gbc_spinner_1.gridx = 2;
		gbc_spinner_1.gridy = 2;
		panel_1.add(spinner_1, gbc_spinner_1);

	}

}
