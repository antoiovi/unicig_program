package ui.commons;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.antoiovi.unicig.project.Dati;

public class APDati extends JPanel implements IDati{
	private JTextField textField;
Dati dati;
private JTextArea textArea;
	/**
	 * Create the panel.
	 */
	public APDati()  {
		
		JLabel lblDenominazione = new JLabel("Denominazione");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblDescrizione = new JLabel("Descrizione");
		
		textArea = new JTextArea();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblDenominazione)
					.addGap(5)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(9)
					.addComponent(lblDescrizione))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(77)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblDenominazione))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addComponent(lblDescrizione)
					.addGap(5)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);

	}

	@Override
	public Dati getDati() {
		if(dati==null)
			dati=new Dati();
		dati.setDenominazione(this.textField.getText());
		dati.setDescrizione(this.textArea.getText());
		return dati;
	}

	@Override
	public void setDati(Dati _dati_) {
dati=_dati_;
textField.setText(dati.getDenominazione());
textArea.setText(dati.getDescrizione());
		
	}

}
