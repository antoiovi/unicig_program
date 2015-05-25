package com.antoiovi.unicig.project.commons;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import java.awt.CardLayout;
import javax.swing.ButtonGroup;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.BoxLayout;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;

public class APGeneratore extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_4;
	private JLabel lblTitle;
	private final ButtonGroup buttonGroup_InsCalc = new ButtonGroup();
	private final ButtonGroup buttonGroup_EccCo2 = new ButtonGroup();
	private JRadioButton rdbtnInser;
	private JPanel panel_fumi;
	private JRadioButton rdbtnCalcola;

	/**
	 * Create the panel.
	 */
	public APGeneratore() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, null));
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 52, 87, 0};
		gbl_panel.rowHeights = new int[]{0, 26, 0, 0, 0, 0, 0, 229, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblTitle = new JLabel(" ");
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.anchor = GridBagConstraints.WEST;
		gbc_lblTitle.gridwidth = 4;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		panel.add(lblTitle, gbc_lblTitle);
		
		JLabel lblPotenzaMassima = new JLabel("Potenza massima");
		GridBagConstraints gbc_lblPotenzaMassima = new GridBagConstraints();
		gbc_lblPotenzaMassima.insets = new Insets(0, 0, 5, 5);
		gbc_lblPotenzaMassima.anchor = GridBagConstraints.WEST;
		gbc_lblPotenzaMassima.gridx = 0;
		gbc_lblPotenzaMassima.gridy = 1;
		panel.add(lblPotenzaMassima, gbc_lblPotenzaMassima);
		
		JSpinner spinner = new JSpinner();
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.BOTH;
		gbc_spinner.gridwidth = 2;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 1;
		gbc_spinner.gridy = 1;
		panel.add(spinner, gbc_spinner);
		
		JLabel lblPotenzaMinimakw = new JLabel("Potenza minima [kW]");
		GridBagConstraints gbc_lblPotenzaMinimakw = new GridBagConstraints();
		gbc_lblPotenzaMinimakw.anchor = GridBagConstraints.WEST;
		gbc_lblPotenzaMinimakw.insets = new Insets(0, 0, 5, 5);
		gbc_lblPotenzaMinimakw.gridx = 0;
		gbc_lblPotenzaMinimakw.gridy = 2;
		panel.add(lblPotenzaMinimakw, gbc_lblPotenzaMinimakw);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(35.0, 10.0, 35.0, 0.5));
		spinner_1.setPreferredSize(new Dimension(100, 20));
		GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
		gbc_spinner_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_1.gridwidth = 2;
		gbc_spinner_1.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_1.gridx = 1;
		gbc_spinner_1.gridy = 2;
		panel.add(spinner_1, gbc_spinner_1);
		
		JLabel lblRendimentoAP = new JLabel("Rendimento a P nominale");
		GridBagConstraints gbc_lblRendimentoAP = new GridBagConstraints();
		gbc_lblRendimentoAP.insets = new Insets(0, 0, 5, 5);
		gbc_lblRendimentoAP.gridx = 0;
		gbc_lblRendimentoAP.gridy = 3;
		panel.add(lblRendimentoAP, gbc_lblRendimentoAP);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setPreferredSize(new Dimension(40, 20));
		GridBagConstraints gbc_spinner_2 = new GridBagConstraints();
		gbc_spinner_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_2.gridwidth = 2;
		gbc_spinner_2.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_2.gridx = 1;
		gbc_spinner_2.gridy = 3;
		panel.add(spinner_2, gbc_spinner_2);
		
		JLabel lblNewLabel_2 = new JLabel("Rendimento a P minima");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JSpinner spinner_3 = new JSpinner();
		GridBagConstraints gbc_spinner_3 = new GridBagConstraints();
		gbc_spinner_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_3.gridwidth = 2;
		gbc_spinner_3.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_3.gridx = 1;
		gbc_spinner_3.gridy = 4;
		panel.add(spinner_3, gbc_spinner_3);
		
		JLabel lblFumi = new JLabel("FUMI:");
		lblFumi.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblFumi = new GridBagConstraints();
		gbc_lblFumi.anchor = GridBagConstraints.WEST;
		gbc_lblFumi.insets = new Insets(0, 0, 5, 0);
		gbc_lblFumi.gridx = 3;
		gbc_lblFumi.gridy = 5;
		panel.add(lblFumi, gbc_lblFumi);
		
		rdbtnInser = new JRadioButton("Inserisci valori");
		rdbtnInser.setSelected(true);
		rdbtnInser.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				CardLayout cl=(CardLayout) panel_fumi.getLayout();
				if(rdbtnInser.isSelected()){
					cl.first(panel_fumi);
				}else{
					cl.last(panel_fumi);
				}
			}
		});
		buttonGroup_InsCalc.add(rdbtnInser);
		GridBagConstraints gbc_rdbtnInser = new GridBagConstraints();
		gbc_rdbtnInser.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnInser.gridx = 0;
		gbc_rdbtnInser.gridy = 6;
		panel.add(rdbtnInser, gbc_rdbtnInser);
		
		rdbtnCalcola = new JRadioButton("Calcola valori");
		rdbtnCalcola.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				CardLayout cl=(CardLayout) panel_fumi.getLayout();
				if(rdbtnCalcola.isSelected()){
					cl.last(panel_fumi);
				}else{
					cl.first(panel_fumi);
				}
			}
		});
		buttonGroup_InsCalc.add(rdbtnCalcola);
		GridBagConstraints gbc_rdbtnCalcola = new GridBagConstraints();
		gbc_rdbtnCalcola.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnCalcola.gridx = 3;
		gbc_rdbtnCalcola.gridy = 6;
		panel.add(rdbtnCalcola, gbc_rdbtnCalcola);
		
		panel_fumi = new JPanel();
		GridBagConstraints gbc_panel_fumi = new GridBagConstraints();
		gbc_panel_fumi.anchor = GridBagConstraints.NORTH;
		gbc_panel_fumi.gridwidth = 4;
		gbc_panel_fumi.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_fumi.gridx = 0;
		gbc_panel_fumi.gridy = 7;
		panel.add(panel_fumi, gbc_panel_fumi);
		panel_fumi.setLayout(new CardLayout(0, 0));
		
		JPanel panel_inserfumi = new JPanel();
		panel_inserfumi.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_fumi.add(panel_inserfumi, "name_13368442881834");
		GridBagLayout gbl_panel_inserfumi = new GridBagLayout();
		gbl_panel_inserfumi.columnWidths = new int[]{205, 108, 0};
		gbl_panel_inserfumi.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_inserfumi.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_inserfumi.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_inserfumi.setLayout(gbl_panel_inserfumi);
		
		JLabel lblNewLabel_4 = new JLabel("Inserimento dati fumi");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 0;
		panel_inserfumi.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("Portata massica fumi [kg/s]");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel_inserfumi.add(lblNewLabel, gbc_lblNewLabel);
		
		JSpinner spinner_6 = new JSpinner();
		GridBagConstraints gbc_spinner_6 = new GridBagConstraints();
		gbc_spinner_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_6.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_6.gridx = 1;
		gbc_spinner_6.gridy = 1;
		panel_inserfumi.add(spinner_6, gbc_spinner_6);
		
		JLabel lblNewLabel_1 = new JLabel("Eccesso d'aria");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel_inserfumi.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JSpinner spinner_7 = new JSpinner();
		GridBagConstraints gbc_spinner_7 = new GridBagConstraints();
		gbc_spinner_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_7.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_7.gridx = 1;
		gbc_spinner_7.gridy = 2;
		panel_inserfumi.add(spinner_7, gbc_spinner_7);
		
		JLabel lblCoFumiSecchi = new JLabel("CO2% fumi secchi");
		GridBagConstraints gbc_lblCoFumiSecchi = new GridBagConstraints();
		gbc_lblCoFumiSecchi.anchor = GridBagConstraints.WEST;
		gbc_lblCoFumiSecchi.insets = new Insets(0, 0, 5, 5);
		gbc_lblCoFumiSecchi.gridx = 0;
		gbc_lblCoFumiSecchi.gridy = 3;
		panel_inserfumi.add(lblCoFumiSecchi, gbc_lblCoFumiSecchi);
		
		JSpinner spinner_8 = new JSpinner();
		GridBagConstraints gbc_spinner_8 = new GridBagConstraints();
		gbc_spinner_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_8.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_8.gridx = 1;
		gbc_spinner_8.gridy = 3;
		panel_inserfumi.add(spinner_8, gbc_spinner_8);
		
		JLabel lblOFumiSecchi = new JLabel("O2% fumi secchi");
		GridBagConstraints gbc_lblOFumiSecchi = new GridBagConstraints();
		gbc_lblOFumiSecchi.insets = new Insets(0, 0, 5, 5);
		gbc_lblOFumiSecchi.anchor = GridBagConstraints.WEST;
		gbc_lblOFumiSecchi.gridx = 0;
		gbc_lblOFumiSecchi.gridy = 4;
		panel_inserfumi.add(lblOFumiSecchi, gbc_lblOFumiSecchi);
		
		JSpinner spinner_9 = new JSpinner();
		GridBagConstraints gbc_spinner_9 = new GridBagConstraints();
		gbc_spinner_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_9.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_9.gridx = 1;
		gbc_spinner_9.gridy = 4;
		panel_inserfumi.add(spinner_9, gbc_spinner_9);
		
		JLabel lblTemperaturafumiAllaP = new JLabel("Temperaturafumi alla P nominale [\u00B0C]");
		GridBagConstraints gbc_lblTemperaturafumiAllaP = new GridBagConstraints();
		gbc_lblTemperaturafumiAllaP.anchor = GridBagConstraints.WEST;
		gbc_lblTemperaturafumiAllaP.insets = new Insets(0, 0, 5, 5);
		gbc_lblTemperaturafumiAllaP.gridx = 0;
		gbc_lblTemperaturafumiAllaP.gridy = 5;
		panel_inserfumi.add(lblTemperaturafumiAllaP, gbc_lblTemperaturafumiAllaP);
		
		JSpinner spinner_10 = new JSpinner();
		GridBagConstraints gbc_spinner_10 = new GridBagConstraints();
		gbc_spinner_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_10.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_10.gridx = 1;
		gbc_spinner_10.gridy = 5;
		panel_inserfumi.add(spinner_10, gbc_spinner_10);
		
		JLabel lblTemperaturaAllaP = new JLabel("Temperatura alla P minima [\u00B0C]");
		GridBagConstraints gbc_lblTemperaturaAllaP = new GridBagConstraints();
		gbc_lblTemperaturaAllaP.insets = new Insets(0, 0, 0, 5);
		gbc_lblTemperaturaAllaP.anchor = GridBagConstraints.WEST;
		gbc_lblTemperaturaAllaP.gridx = 0;
		gbc_lblTemperaturaAllaP.gridy = 6;
		panel_inserfumi.add(lblTemperaturaAllaP, gbc_lblTemperaturaAllaP);
		
		JSpinner spinner_11 = new JSpinner();
		GridBagConstraints gbc_spinner_11 = new GridBagConstraints();
		gbc_spinner_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_11.gridx = 1;
		gbc_spinner_11.gridy = 6;
		panel_inserfumi.add(spinner_11, gbc_spinner_11);
		
		JPanel panel_calcfumi = new JPanel();
		panel_calcfumi.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.RED, null));
		panel_fumi.add(panel_calcfumi, "name_13372797111764");
		GridBagLayout gbl_panel_calcfumi = new GridBagLayout();
		gbl_panel_calcfumi.columnWidths = new int[]{170, 80, 14, 0};
		gbl_panel_calcfumi.rowHeights = new int[]{14, 0, 0, 0, 0, 0, 0, 0, 14, 0, 0, 0};
		gbl_panel_calcfumi.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_calcfumi.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_calcfumi.setLayout(gbl_panel_calcfumi);
		
		JLabel lblNewLabel_3 = new JLabel("Calcolo dati fumi");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_calcfumi.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Inserire Eccesso d'aria Oppure CO2, e premere il pulsante desiderato;");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.gridwidth = 3;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 1;
		panel_calcfumi.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblPossibileCorreggere = new JLabel("\u00E8 possibile correggere i dati manualmente.");
		GridBagConstraints gbc_lblPossibileCorreggere = new GridBagConstraints();
		gbc_lblPossibileCorreggere.gridwidth = 2;
		gbc_lblPossibileCorreggere.anchor = GridBagConstraints.EAST;
		gbc_lblPossibileCorreggere.insets = new Insets(0, 0, 5, 5);
		gbc_lblPossibileCorreggere.gridx = 0;
		gbc_lblPossibileCorreggere.gridy = 2;
		panel_calcfumi.add(lblPossibileCorreggere, gbc_lblPossibileCorreggere);
		
		JLabel lblEccessoDaria = new JLabel("Eccesso d'aria");
		GridBagConstraints gbc_lblEccessoDaria = new GridBagConstraints();
		gbc_lblEccessoDaria.insets = new Insets(0, 0, 5, 5);
		gbc_lblEccessoDaria.gridx = 0;
		gbc_lblEccessoDaria.gridy = 3;
		panel_calcfumi.add(lblEccessoDaria, gbc_lblEccessoDaria);
		
		JSpinner spinner_4 = new JSpinner();
		GridBagConstraints gbc_spinner_4 = new GridBagConstraints();
		gbc_spinner_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_4.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_4.gridx = 1;
		gbc_spinner_4.gridy = 3;
		panel_calcfumi.add(spinner_4, gbc_spinner_4);
		
		JButton btnNewButton = new JButton("Calcola");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 3;
		panel_calcfumi.add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblCo = new JLabel("CO2%");
		GridBagConstraints gbc_lblCo = new GridBagConstraints();
		gbc_lblCo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCo.gridx = 0;
		gbc_lblCo.gridy = 4;
		panel_calcfumi.add(lblCo, gbc_lblCo);
		
		JSpinner spinner_5 = new JSpinner();
		GridBagConstraints gbc_spinner_5 = new GridBagConstraints();
		gbc_spinner_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_5.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_5.gridx = 1;
		gbc_spinner_5.gridy = 4;
		panel_calcfumi.add(spinner_5, gbc_spinner_5);
		
		JButton btnNewButton_1 = new JButton("Calcola");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 4;
		panel_calcfumi.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel label = new JLabel("Portata massica fumi [kg/s]");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.NORTHWEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 5;
		panel_calcfumi.add(label, gbc_label);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 5;
		panel_calcfumi.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("Eccesso d'aria");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 6;
		panel_calcfumi.add(label_1, gbc_label_1);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 6;
		panel_calcfumi.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("CO2% fumi secchi");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 7;
		panel_calcfumi.add(label_2, gbc_label_2);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 7;
		panel_calcfumi.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("O2% fumi secchi");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.NORTHWEST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 8;
		panel_calcfumi.add(label_3, gbc_label_3);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 8;
		panel_calcfumi.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblTemperaturaallaPNominale = new JLabel("Temperaturaalla P nominale [\u00B0C]");
		GridBagConstraints gbc_lblTemperaturaallaPNominale = new GridBagConstraints();
		gbc_lblTemperaturaallaPNominale.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTemperaturaallaPNominale.insets = new Insets(0, 0, 5, 5);
		gbc_lblTemperaturaallaPNominale.gridx = 0;
		gbc_lblTemperaturaallaPNominale.gridy = 9;
		panel_calcfumi.add(lblTemperaturaallaPNominale, gbc_lblTemperaturaallaPNominale);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 9;
		panel_calcfumi.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel label_6 = new JLabel("Temperatura alla P minima [\u00B0C]");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 0, 5);
		gbc_label_6.anchor = GridBagConstraints.NORTHWEST;
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 10;
		panel_calcfumi.add(label_6, gbc_label_6);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 0, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 10;
		panel_calcfumi.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);

	}

	public JLabel getLblTitle() {
		return lblTitle;
	}
}
