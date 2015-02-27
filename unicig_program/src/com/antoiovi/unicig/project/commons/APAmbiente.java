package com.antoiovi.unicig.project.commons;

import javax.swing.JPanel;

import com.antoiovi.unicig.project.tabelle.Localita;

import com.antoiovi.unicig.project.Ambiente;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class APAmbiente extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_TCitVic;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public APAmbiente() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(103dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblLocalitPiVicina = new JLabel("Localit\u00E0 pi\u00F9 vicina");
		add(lblLocalitPiVicina, "2, 2, right, default");
		String cittavicine[]=Localita.getInstance().getlocalita();
		JComboBox comboBox = new JComboBox(cittavicine);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 JComboBox cb = (JComboBox)arg0.getSource();
			        String citta = (String)cb.getSelectedItem();
			        double t=Localita.getInstance().getTemperatura(citta);
			        textField_TCitVic.setText(t+ "°C");
			}
		});
		//comboBox.setSelectedIndex(1);
		comboBox.setEditable(true);
		add(comboBox, "4, 2, fill, default");
		
		JLabel lblNewLabel_3 = new JLabel("Temperatura minima\r\n");
		add(lblNewLabel_3, "6, 2, right, default");
		
		textField_TCitVic = new JTextField();
		add(textField_TCitVic, "8, 2, fill, default");
		textField_TCitVic.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Localit\u00E0 :");
		add(lblNewLabel, "2, 4, right, default");
		
		textField = new JTextField();
		add(textField, "4, 4, fill, default");
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Temperatura minima\r\n");
		add(lblNewLabel_4, "6, 4, right, default");
		
		textField_4 = new JTextField();
		add(textField_4, "8, 4, fill, default");
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Quota slm [m]");
		add(lblNewLabel_1, "10, 4, right, default");
		
		textField_1 = new JTextField();
		add(textField_1, "12, 4, left, default");
		textField_1.setColumns(10);

	}

	
}
