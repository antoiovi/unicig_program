package com.antoiovi.unicig.project.commons;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSpinner;

public class JPAmbiente extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public JPAmbiente() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 11, 46, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(66, 8, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(178, 11, 46, 14);
		add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(249, 8, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 70, 214, 141);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		buttonGroup.add(rdbtnNewRadioButton);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		buttonGroup.add(rdbtnNewRadioButton_1);
		panel_1.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		buttonGroup.add(rdbtnNewRadioButton_2);
		panel_1.add(rdbtnNewRadioButton_2);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(249, 70, 167, 132);
		add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		panel_4.add(lblNewLabel_3);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(10, 11, 46, 14);
		panel_5.add(lblNewLabel_4);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(89, 8, 29, 20);
		panel_5.add(spinner);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(10, 36, 46, 14);
		panel_5.add(lblNewLabel_5);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(89, 33, 29, 20);
		panel_5.add(spinner_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(38, 222, 260, 39);
		add(panel_6);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		panel_6.add(lblNewLabel_6);
		
		JSpinner spinner_2 = new JSpinner();
		panel_6.add(spinner_2);

	}
}
