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

import javax.swing.JSpinner;
import javax.swing.BoxLayout;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Locale;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ButtonGroup;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.Color;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;


public class APAmbiente extends JPanel {
	private JTextField textField;
	private JTextField textField_TCitVic;
	private JTextField txtDTperquota;
	private JTextField textField_1;
	private JTextField txtTemperaturaEsternaEffettiva;
	private final ButtonGroup btgAmbest = new ButtonGroup();
	private JRadioButton rdbtnComUrb;
	private JRadioButton rdbtnPiccaggl;
	private JRadioButton rdbtnEdificiIsolati;
	private JSpinner sp_ei;
	private JSpinner sp_pa;
	private JSpinner sp_p;
	private JSpinner sp_dt;

//	  private ValidationResultModel validationResultModel;
	   
	

	/**
	 * Create the panel.
	 */
	public APAmbiente() {

      //  this.validationResultModel = new DefaultValidationResultModel();
      //  this.validationResultModel.addPropertyChangeListener(new ValidationListener());
        
		Locale.setDefault(Locale.US);
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(143dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(137dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
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
		
		/**
		 * SELEZIONE LKOCALITA' PIù VICINA
		 */
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
			        calcola();
			}
		});
		//comboBox.setSelectedIndex(1);
		comboBox.setEditable(true);
		add(comboBox, "4, 2, fill, default");
		
		JPanel panel_3 = new JPanel();
		add(panel_3, "6, 2, fill, fill");
		/**
		 * Temperatura minima località piu vicina (non editabile)
		 */
		JLabel lblNewLabel_3 = new JLabel("Temperatura minima");
		panel_3.add(lblNewLabel_3);
		
		textField_TCitVic = new JTextField();
		textField_TCitVic.setDisabledTextColor(Color.BLACK);
		textField_TCitVic.setBackground(Color.WHITE);
		textField_TCitVic.setEditable(false);
		textField_TCitVic.setEnabled(false);
		
		
		panel_3.add(textField_TCitVic);
		textField_TCitVic.setColumns(10);
		/**
		 * LOCALITà EFFETTIVA
		 */
		JLabel lblNewLabel = new JLabel("Localit\u00E0 :");
		add(lblNewLabel, "2, 4, right, default");
		
		textField = new JTextField();
		add(textField, "4, 4, fill, default");
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_1, "2, 6, 3, 1, fill, fill");
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{119, 47, 0};
		gbl_panel_1.rowHeights = new int[]{14, 23, 23, 23, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		/**
		 * CORREZIONE TEMPERATURA IN BASE AD AMBIENTE ESTERNO
		 */
		JLabel lblCorrezioneTemperatura = new JLabel("Correzione temperatura in base a ambiente esterno\r\n");
		GridBagConstraints gbc_lblCorrezioneTemperatura = new GridBagConstraints();
		gbc_lblCorrezioneTemperatura.gridwidth = 2;
		gbc_lblCorrezioneTemperatura.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorrezioneTemperatura.gridx = 0;
		gbc_lblCorrezioneTemperatura.gridy = 0;
		panel_1.add(lblCorrezioneTemperatura, gbc_lblCorrezioneTemperatura);
		/**
		 * COMPLESSO URBANO
		 */
		rdbtnComUrb = new JRadioButton("Complesso urbano");
		rdbtnComUrb.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				 if (e.getStateChange() == ItemEvent.SELECTED) {
				        sp_pa.setEnabled(false); // spinner piccolo agglomerato
				        sp_ei.setEnabled(false);// spinner edificio isolato
				        calcola();
				    }
				    else if (e.getStateChange() == ItemEvent.DESELECTED) {

				    }
				
			}
		});
		btgAmbest.add(rdbtnComUrb);
		GridBagConstraints gbc_rdbtnComUrb = new GridBagConstraints();
		gbc_rdbtnComUrb.anchor = GridBagConstraints.WEST;
		gbc_rdbtnComUrb.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnComUrb.gridx = 0;
		gbc_rdbtnComUrb.gridy = 1;
		panel_1.add(rdbtnComUrb, gbc_rdbtnComUrb);
		/**
		 * PICCOLO AGGLOMERATO
		 */
		rdbtnPiccaggl = new JRadioButton("Piccolo agglomerato");
		rdbtnPiccaggl.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				 if (e.getStateChange() == ItemEvent.SELECTED) {
					 sp_pa.setEnabled(true); // spinner piccolo agglomerato
					 calcola();
				    }
				    else if (e.getStateChange() == ItemEvent.DESELECTED) {
				    	sp_pa.setEnabled(false); // spinner piccolo agglomerato
				    }
			}
		});
		btgAmbest.add(rdbtnPiccaggl);
		GridBagConstraints gbc_rdbtnPiccaggl = new GridBagConstraints();
		gbc_rdbtnPiccaggl.anchor = GridBagConstraints.WEST;
		gbc_rdbtnPiccaggl.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPiccaggl.gridx = 0;
		gbc_rdbtnPiccaggl.gridy = 2;
		panel_1.add(rdbtnPiccaggl, gbc_rdbtnPiccaggl);
		// SPINNER PICCOLO AGGLOMERATO
		sp_pa = new JSpinner();
		sp_pa.setModel(new SpinnerNumberModel(0.0, -1.0, 0.0, 0.5));
		GridBagConstraints gbc_sp_pa = new GridBagConstraints();
		gbc_sp_pa.fill = GridBagConstraints.HORIZONTAL;
		gbc_sp_pa.insets = new Insets(0, 0, 5, 0);
		gbc_sp_pa.gridx = 1;
		gbc_sp_pa.gridy = 2;
		panel_1.add(sp_pa, gbc_sp_pa);
		/**
		 * EDIFICI ISOLATI
		 */
		/**
		 * radioButton Edifici isolati
		 */
		rdbtnEdificiIsolati = new JRadioButton("Edifici isolati");
		rdbtnEdificiIsolati.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				 if (e.getStateChange() == ItemEvent.SELECTED) {
					 sp_ei.setEnabled(true);//SPINNER EDIFICIO ISOLATO
					 calcola();
				    }
				    else if (e.getStateChange() == ItemEvent.DESELECTED) {
				    	sp_ei.setEnabled(false);//SPINNER EDIFICIO ISOLATO
				    }
				
			}
		});
		btgAmbest.add(rdbtnEdificiIsolati);
		GridBagConstraints gbc_rdbtnEdificiIsolati = new GridBagConstraints();
		gbc_rdbtnEdificiIsolati.fill = GridBagConstraints.BOTH;
		gbc_rdbtnEdificiIsolati.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnEdificiIsolati.gridx = 0;
		gbc_rdbtnEdificiIsolati.gridy = 3;
		panel_1.add(rdbtnEdificiIsolati, gbc_rdbtnEdificiIsolati);
		/**
		 * SPINNER EDIFICIO ISOLATO
		 */
		sp_ei = new JSpinner();
		sp_ei.setModel(new SpinnerNumberModel(0.0, -2.0, 0.0, 0.5));
		GridBagConstraints gbc_sp_ei = new GridBagConstraints();
		gbc_sp_ei.fill = GridBagConstraints.HORIZONTAL;
		gbc_sp_ei.insets = new Insets(0, 0, 5, 0);
		gbc_sp_ei.gridx = 1;
		gbc_sp_ei.gridy = 3;
		panel_1.add(sp_ei, gbc_sp_ei);
		/**
		 * CORREZZIONE TEMPERATURA PER I PIANI DI AKTEZZA SUPERIORE AGLI EDIFICI CIRCOSTANTI
		 */
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_2, "6, 6, left, fill");
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{210, 57, 0};
		gbl_panel_2.rowHeights = new int[]{29, 25, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel_5 = new JLabel("Correzione temperatura per per i piani di altezza");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.gridwidth = 2;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 0;
		panel_2.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblNewLabel_2 = new JLabel("superiore a quella degli edifici vicini:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblDalPiano = new JLabel("Dal piano");
		GridBagConstraints gbc_lblDalPiano = new GridBagConstraints();
		gbc_lblDalPiano.anchor = GridBagConstraints.WEST;
		gbc_lblDalPiano.insets = new Insets(0, 0, 5, 5);
		gbc_lblDalPiano.gridx = 0;
		gbc_lblDalPiano.gridy = 2;
		panel_2.add(lblDalPiano, gbc_lblDalPiano);
		/**
		 * spinner indicante il piano dal quale si consoidera una diminuzione di temperatura
		 */
		sp_p = new JSpinner();
		sp_p.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		GridBagConstraints gbc_sp_p = new GridBagConstraints();
		gbc_sp_p.fill = GridBagConstraints.HORIZONTAL;
		gbc_sp_p.insets = new Insets(0, 0, 5, 0);
		gbc_sp_p.gridx = 1;
		gbc_sp_p.gridy = 2;
		panel_2.add(sp_p, gbc_sp_p);
		
		JLabel lblDifferenzaTemperatura = new JLabel("Differenza temperatura ");
		GridBagConstraints gbc_lblDifferenzaTemperatura = new GridBagConstraints();
		gbc_lblDifferenzaTemperatura.anchor = GridBagConstraints.WEST;
		gbc_lblDifferenzaTemperatura.insets = new Insets(0, 0, 0, 5);
		gbc_lblDifferenzaTemperatura.gridx = 0;
		gbc_lblDifferenzaTemperatura.gridy = 3;
		panel_2.add(lblDifferenzaTemperatura, gbc_lblDifferenzaTemperatura);
		/**
		 * Spinner per la differenza di temperatura dovuta ai piani superiori sporgenti dagli edifici adiacenti
		 */
		sp_dt = new JSpinner();
		sp_dt.setModel(new SpinnerNumberModel(0, -2, 0, 0.5));
		GridBagConstraints gbc_sp_dt = new GridBagConstraints();
		gbc_sp_dt.fill = GridBagConstraints.HORIZONTAL;
		gbc_sp_dt.gridx = 1;
		gbc_sp_dt.gridy = 3;
		panel_2.add(sp_dt, gbc_sp_dt);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_4, "2, 8, 5, 1, left, fill");
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		JLabel lblDifferenzaDiQuota = new JLabel("Differenza di quota rispetto a localt\u00E0 piu vicina  :");
		panel_4.add(lblDifferenzaDiQuota);
		/**
		 * Spinner differenza di quota
		 */
		JSpinner spinner_5 = new JSpinner();
		spinner_5.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				   JSpinner s = (JSpinner) e.getSource();
				   int i=(Integer)s.getValue();
				   /**
				    * due gradi ogni 200 metri
				    */
				txtDTperquota.setText(String.valueOf(-2*i/200));
				calcola();
			}
		});
		spinner_5.setModel(new SpinnerNumberModel(0, -600, 1000, 200));
		panel_4.add(spinner_5);
		
		JLabel lblDifferenzaTemperatura_1 = new JLabel("Differenza temperatura  : \r\n");
		panel_4.add(lblDifferenzaTemperatura_1);
		/**
		 * Differenza di temperatura dovutoa a differenza di quota
		 */
		txtDTperquota = new JTextField();
		txtDTperquota.setDisabledTextColor(Color.BLACK);
		txtDTperquota.setEditable(false);
		txtDTperquota.setBackground(Color.WHITE);
		txtDTperquota.setEnabled(false);
		panel_4.add(txtDTperquota);
		txtDTperquota.setColumns(5);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		
		JPanel panel_5 = new JPanel();
		add(panel_5, "2, 10, 3, 1, fill, fill");
		/**
		 * TEMPERATURA ESTERNA EFFETTIVA CACOLATA
		 */
		JLabel lblNewLabel_4 = new JLabel("Temperatura esterna effettiva :");
		panel_5.add(lblNewLabel_4);
		
		txtTemperaturaEsternaEffettiva = new JTextField();
		panel_5.add(txtTemperaturaEsternaEffettiva);
		txtTemperaturaEsternaEffettiva.setColumns(5);
		
		JLabel lblTermperaturaEsternaUtilizzata = new JLabel("Termperatura esterna utilizzata per il calcolo .");
		add(lblTermperaturaEsternaUtilizzata, "6, 10");
		
		JPanel panel = new JPanel();
		add(panel, "4, 12, fill, fill");
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{91, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		/**
		 * QUOTA SUL LIVELLO DEL MARE PER IL CALCOLO DELLA PRESSONE ATMOSFERICA
		 */
		JLabel lblQuotam = new JLabel("Quota [m ]");
		GridBagConstraints gbc_lblQuotam = new GridBagConstraints();
		gbc_lblQuotam.anchor = GridBagConstraints.WEST;
		gbc_lblQuotam.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuotam.gridx = 0;
		gbc_lblQuotam.gridy = 0;
		panel.add(lblQuotam, gbc_lblQuotam);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 1000, 50));
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner.insets = new Insets(0, 0, 5, 0);
		gbc_spinner.gridx = 1;
		gbc_spinner.gridy = 0;
		panel.add(spinner, gbc_spinner);
		
		JLabel lblNewLabel_1 = new JLabel("Pressione atmosferica");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.WHITE);
		textField_1.setEditable(false);
		textField_1.setEnabled(false);
		textField_1.setDisabledTextColor(Color.BLACK);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMsg = new JLabel("New label");
		add(lblMsg, "2, 14, 5, 1");
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblTermperaturaEsternaUtilizzata, lblLocalitPiVicina, comboBox, panel_3, lblNewLabel_3, textField_TCitVic, lblNewLabel, textField, panel_1, lblCorrezioneTemperatura, rdbtnComUrb, rdbtnPiccaggl, sp_pa, rdbtnEdificiIsolati, sp_ei, panel_2, lblNewLabel_5, lblNewLabel_2, lblDalPiano, sp_p, lblDifferenzaTemperatura, sp_dt, panel_4, lblDifferenzaDiQuota, spinner_5, lblDifferenzaTemperatura_1, txtDTperquota, panel_6, panel_5, lblNewLabel_4, txtTemperaturaEsternaEffettiva, panel, lblQuotam, spinner, lblNewLabel_1, textField_1, lblMsg}));

	}

	
private void calcola(){
	boolean checked=true;
	String t1=textField_TCitVic.getText();
	double d_t1=0;
	try{
		 d_t1=Double.valueOf(t1);
	}catch(Exception e){
		checked=false;
	}
	
	double d_t_ubicazione;
	if(rdbtnPiccaggl.isSelected()){
		JSpinner js=this.sp_pa;
		d_t_ubicazione=(Double)js.getValue();
		
	}else if(rdbtnEdificiIsolati.isSelected()){
		JSpinner js=this.sp_ei;
		d_t_ubicazione=(Double)js.getValue();
	}else{
		d_t_ubicazione=0;
	}
	String t2=this.txtDTperquota.getText();
	double d_t2=0;
	try{
		d_t2=Double.valueOf(t2);
	}catch(Exception e){
		checked=false;
	}
	
	if(checked=false){
		
		this.txtTemperaturaEsternaEffettiva.setText("ERRORE");
	}else{
		this.txtTemperaturaEsternaEffettiva.setText(String.valueOf(d_t1+d_t2+d_t_ubicazione));
	}
}
	
}
