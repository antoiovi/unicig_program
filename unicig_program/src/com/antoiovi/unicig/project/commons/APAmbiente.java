package com.antoiovi.unicig.project.commons;

import javax.swing.JPanel;

import com.antoiovi.unicig.project.tabelle.Localita;
import com.antoiovi.unicig.project.Ambiente;
import com.antoiovi.unicig.project.Project;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFormattedTextField;
import java.awt.FlowLayout;


public class APAmbiente extends JPanel implements ItemListener, ChangeListener,PropertyChangeListener {
	private JFormattedTextField txtFCitta;
	private JTextField textField_TCitVic;
	private JTextField txtfPatm;
	private JTextField txtTemperaturaEsternaEffettiva;
	private final ButtonGroup btgAmbest = new ButtonGroup();
	private JRadioButton rdbtnComUrb;
	private JRadioButton rdbtnPiccaggl;
	private JRadioButton rdbtnEdificiIsolati;
	private JSpinner sp_ed_isol;
	private JSpinner sp_pic_agg;
	private JSpinner sp_piano;
	private JSpinner sp_dtPianSup;

//	  private ValidationResultModel validationResultModel;
	   Project project;
	   private JSpinner sp_corr_temp;
	   private JComboBox cbxLocPiuVicina;
	   private JSpinner sp_quota_slm;
	

	/**
	 * Create the panel.
	 */
	public APAmbiente(Project _project) {
		this.project=_project;
       
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
				 }));
		
		/**
		 * SELEZIONE LKOCALITA' PIù VICINA
		 */
		JLabel lblLocalitPiVicina = new JLabel("Localit\u00E0 pi\u00F9 vicina");
		add(lblLocalitPiVicina, "2, 2, right, default");
		String cittavicine[]=Localita.getInstance().getlocalita();
		cbxLocPiuVicina = new JComboBox(cittavicine);
		cbxLocPiuVicina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 JComboBox cb = (JComboBox)arg0.getSource();
			        String citta = (String)cb.getSelectedItem();
			        double t=Localita.getInstance().getTemperatura(citta);
			        textField_TCitVic.setText(t+ "°C");
			        project.setLocalita_piu_vicina(citta);
			        impostTempEsterna();
			        
			       
			}
		});
		//comboBox.setSelectedIndex(1);
		cbxLocPiuVicina.setEditable(true);
		add(cbxLocPiuVicina, "4, 2, fill, default");
		
		JPanel panel_3 = new JPanel();
		add(panel_3, "6, 2, fill, fill");
		/**
		 * Temperatura minima località piu vicina (non editabile)
		 */
		JLabel lblNewLabel_3 = new JLabel("Temperatura minima");
		panel_3.add(lblNewLabel_3);
		
		textField_TCitVic = new JTextField();
		textField_TCitVic.setEnabled(false);
		textField_TCitVic.setEditable(false);
		textField_TCitVic.setDisabledTextColor(Color.BLACK);
		textField_TCitVic.setBackground(Color.WHITE);
		
		
		panel_3.add(textField_TCitVic);
		textField_TCitVic.setColumns(10);
		/**
		 * LOCALITà EFFETTIVA
		 */
		JLabel lblNewLabel = new JLabel("Localit\u00E0 :");
		add(lblNewLabel, "2, 4, right, default");
		
		txtFCitta = new JFormattedTextField();
		add(txtFCitta, "4, 4, fill, default");
		txtFCitta.setColumns(10);
		txtFCitta.addPropertyChangeListener(this);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_1, "2, 6, 3, 1, fill, fill");
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{119, 0, 47, 0};
		gbl_panel_1.rowHeights = new int[]{14, 23, 23, 23, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		/**
		 * CORREZIONE TEMPERATURA IN BASE AD AMBIENTE ESTERNO
		 */
		JLabel lblCorrezioneTemperatura = new JLabel("Correzione temperatura in base a ambiente esterno\r\n");
		GridBagConstraints gbc_lblCorrezioneTemperatura = new GridBagConstraints();
		gbc_lblCorrezioneTemperatura.gridwidth = 3;
		gbc_lblCorrezioneTemperatura.insets = new Insets(0, 0, 5, 0);
		gbc_lblCorrezioneTemperatura.gridx = 0;
		gbc_lblCorrezioneTemperatura.gridy = 0;
		panel_1.add(lblCorrezioneTemperatura, gbc_lblCorrezioneTemperatura);
		/**
		 * COMPLESSO URBANO
		 */
		rdbtnComUrb = new JRadioButton("Complesso urbano");
		rdbtnComUrb.addItemListener(this);
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
		rdbtnPiccaggl.addItemListener(this);
		
		btgAmbest.add(rdbtnPiccaggl);
		GridBagConstraints gbc_rdbtnPiccaggl = new GridBagConstraints();
		gbc_rdbtnPiccaggl.anchor = GridBagConstraints.WEST;
		gbc_rdbtnPiccaggl.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPiccaggl.gridx = 0;
		gbc_rdbtnPiccaggl.gridy = 2;
		panel_1.add(rdbtnPiccaggl, gbc_rdbtnPiccaggl);
		/**
		 * EDIFICI ISOLATI
		 */
		/**
		 * radioButton Edifici isolati
		 */
		rdbtnEdificiIsolati = new JRadioButton("Edifici isolati");
		rdbtnEdificiIsolati.addItemListener(this);
		// SPINNER PICCOLO AGGLOMERATO
		sp_pic_agg = new JSpinner();
		sp_pic_agg.setModel(new SpinnerNumberModel(0.0, -3.0, 0.0, 0.5));
		sp_pic_agg.addChangeListener(this);
		
		JLabel lblDeltaTc = new JLabel("Delta T [\u00B0C]");
		GridBagConstraints gbc_lblDeltaTc = new GridBagConstraints();
		gbc_lblDeltaTc.insets = new Insets(0, 0, 5, 5);
		gbc_lblDeltaTc.gridx = 1;
		gbc_lblDeltaTc.gridy = 2;
		panel_1.add(lblDeltaTc, gbc_lblDeltaTc);
		GridBagConstraints gbc_sp_pa = new GridBagConstraints();
		gbc_sp_pa.fill = GridBagConstraints.HORIZONTAL;
		gbc_sp_pa.insets = new Insets(0, 0, 5, 0);
		gbc_sp_pa.gridx = 2;
		gbc_sp_pa.gridy = 2;
		panel_1.add(sp_pic_agg, gbc_sp_pa);
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
		
		JLabel label = new JLabel("Delta T [\u00B0C]");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 3;
		panel_1.add(label, gbc_label);
		sp_ed_isol = new JSpinner();
		sp_ed_isol.addChangeListener(this);
		sp_ed_isol.setModel(new SpinnerNumberModel(0.0, -5.0, 0.0, 0.5));
		GridBagConstraints gbc_sp_ei = new GridBagConstraints();
		gbc_sp_ei.fill = GridBagConstraints.HORIZONTAL;
		gbc_sp_ei.insets = new Insets(0, 0, 5, 0);
		gbc_sp_ei.gridx = 2;
		gbc_sp_ei.gridy = 3;
		panel_1.add(sp_ed_isol, gbc_sp_ei);
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
		sp_piano = new JSpinner();
		sp_piano.addChangeListener(this);
		sp_piano.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		GridBagConstraints gbc_sp_p = new GridBagConstraints();
		gbc_sp_p.fill = GridBagConstraints.HORIZONTAL;
		gbc_sp_p.insets = new Insets(0, 0, 5, 0);
		gbc_sp_p.gridx = 1;
		gbc_sp_p.gridy = 2;
		panel_2.add(sp_piano, gbc_sp_p);
		
		JLabel lblDifferenzaTemperatura = new JLabel("Differenza temperatura  [\u00B0C ]");
		GridBagConstraints gbc_lblDifferenzaTemperatura = new GridBagConstraints();
		gbc_lblDifferenzaTemperatura.anchor = GridBagConstraints.WEST;
		gbc_lblDifferenzaTemperatura.insets = new Insets(0, 0, 0, 5);
		gbc_lblDifferenzaTemperatura.gridx = 0;
		gbc_lblDifferenzaTemperatura.gridy = 3;
		panel_2.add(lblDifferenzaTemperatura, gbc_lblDifferenzaTemperatura);
		/**
		 * Spinner per la differenza di temperatura dovuta ai piani superiori sporgenti dagli edifici adiacenti
		 */
		sp_dtPianSup = new JSpinner();
		sp_dtPianSup.addChangeListener(this);
		sp_dtPianSup.setModel(new SpinnerNumberModel(0, -2, 0, 0.5));
		GridBagConstraints gbc_sp_dt = new GridBagConstraints();
		gbc_sp_dt.fill = GridBagConstraints.HORIZONTAL;
		gbc_sp_dt.gridx = 1;
		gbc_sp_dt.gridy = 3;
		panel_2.add(sp_dtPianSup, gbc_sp_dt);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_4, "2, 8, 4, 1, fill, fill");
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblDifferenzaTemperatura_1 = new JLabel("Correzione temperatura [ \u00B0C ]  :");
		panel_4.add(lblDifferenzaTemperatura_1);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		sp_corr_temp = new JSpinner();
		sp_corr_temp.addChangeListener(this);
		sp_corr_temp.setModel(new SpinnerNumberModel(0.0, -10.0, 10.0, 0.5));
		panel_6.add(sp_corr_temp);
		
		JPanel panel_5 = new JPanel();
		add(panel_5, "2, 10, 5, 1, left, fill");
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel lblNewLabel_4 = new JLabel("Temperatura esterna effettiva usata per il calcolo [\u00B0C] :");
		lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
		panel_5.add(lblNewLabel_4);
		
		txtTemperaturaEsternaEffettiva = new JTextField();
		txtTemperaturaEsternaEffettiva.setBackground(Color.YELLOW);
		txtTemperaturaEsternaEffettiva.setEditable(false);
		panel_5.add(txtTemperaturaEsternaEffettiva);
		txtTemperaturaEsternaEffettiva.setColumns(5);
		
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
		JLabel lblQuotam = new JLabel("Quota slm [m ]");
		GridBagConstraints gbc_lblQuotam = new GridBagConstraints();
		gbc_lblQuotam.anchor = GridBagConstraints.WEST;
		gbc_lblQuotam.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuotam.gridx = 0;
		gbc_lblQuotam.gridy = 0;
		panel.add(lblQuotam, gbc_lblQuotam);
		
		sp_quota_slm = new JSpinner();
		sp_quota_slm.addChangeListener(this);
		sp_quota_slm.setModel(new SpinnerNumberModel(0, 0, 2000, 50));
		GridBagConstraints gbc_sp_quota_slm = new GridBagConstraints();
		gbc_sp_quota_slm.fill = GridBagConstraints.HORIZONTAL;
		gbc_sp_quota_slm.insets = new Insets(0, 0, 5, 0);
		gbc_sp_quota_slm.gridx = 1;
		gbc_sp_quota_slm.gridy = 0;
		panel.add(sp_quota_slm, gbc_sp_quota_slm);
		
		JLabel lblNewLabel_1 = new JLabel("Pressione atmosferica");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtfPatm = new JTextField();
		txtfPatm.setBackground(Color.YELLOW);
		txtfPatm.setEditable(false);
		txtfPatm.setDisabledTextColor(Color.BLACK);
		GridBagConstraints gbc_txtfPatm = new GridBagConstraints();
		gbc_txtfPatm.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfPatm.gridx = 1;
		gbc_txtfPatm.gridy = 1;
		panel.add(txtfPatm, gbc_txtfPatm);
		txtfPatm.setColumns(10);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblLocalitPiVicina, cbxLocPiuVicina, panel_3, lblNewLabel_3, textField_TCitVic, lblNewLabel, txtFCitta, panel_1, lblCorrezioneTemperatura, rdbtnComUrb, rdbtnPiccaggl, sp_pic_agg, rdbtnEdificiIsolati, panel_2, lblNewLabel_5, lblNewLabel_2, lblDalPiano, lblDifferenzaTemperatura, panel_4, lblDifferenzaTemperatura_1, panel_6, panel_5, lblNewLabel_4, panel, lblQuotam, sp_quota_slm, lblNewLabel_1}));

		init();
	}
/**
 * Imposta il  campo per visualizzare la temperatura effetiva di calcolo
 */
	protected void impostTempEsterna() {
		double T=project.TempEsterna();
        txtTemperaturaEsternaEffettiva.setText(String.valueOf(T));		
	}

	void init(){
		cbxLocPiuVicina.setSelectedItem(project.getLocalita_piu_vicina());
		txtFCitta.setText(project.getLocalita());
		sp_ed_isol.getModel().setValue(Double.valueOf(project.getCorrezEdifIsol()));
		sp_pic_agg.getModel().setValue(Double.valueOf(project.getCorrezPiccAgg()));
		rdbtnComUrb.setSelected(project.isComplUrb());
		rdbtnEdificiIsolati.setSelected(project.isEdifIsol());
		rdbtnPiccaggl.setSelected(project.isPiccAggl());
		
		sp_corr_temp.getModel().setValue(Double.valueOf(project.getCorrezTemp()));
		
		sp_dtPianSup.getModel().setValue(Double.valueOf(project.getDiff_temp_psup()));
		sp_piano.getModel().setValue(Integer.valueOf(project.getDal_piano()));
	}
	

/**
 * ChangeListener per JSpinner
 */

@Override
public void stateChanged(ChangeEvent e) {
	 if(e.getSource().equals(sp_ed_isol)) {
		 project.setCorrezEdifIsol((Double)sp_ed_isol.getModel().getValue());
		 impostTempEsterna();
	 }else if(e.getSource().equals(sp_pic_agg)){
		 project.setCorrezPiccAgg((Double)sp_pic_agg.getModel().getValue());
		 impostTempEsterna();
	 }else if(e.getSource().equals(sp_piano)){
		 project.setDal_piano( (Integer)sp_piano.getModel().getValue()  );
	 }else if(e.getSource().equals(sp_dtPianSup)){
		 project.setDiff_temp_psup( (Double)sp_dtPianSup.getModel().getValue()    );
	 }else if(e.getSource().equals(sp_corr_temp)){
		 project.setCorrezTemp(  (Double)sp_corr_temp.getModel().getValue()    );
		 impostTempEsterna();
	 }else if(e.getSource().equals(sp_quota_slm)){
		 project.setQuota_slm((Integer)sp_quota_slm.getModel().getValue() );
		 txtfPatm.setText(String.valueOf(project.PressAtm()));
		 
	 }
 	
}//StateChanged

/**
 * ItemListener per CheckBox,JRadioButton  e ComboBox
 */
@Override
public void itemStateChanged(ItemEvent e) {
	 
	 if(e.getSource().equals(rdbtnComUrb)) {
		 //COMPLESSO URBANO
		 if (e.getStateChange() == ItemEvent.SELECTED) {
		        sp_pic_agg.setEnabled(false); // spinner piccolo agglomerato
		        sp_ed_isol.setEnabled(false);// spinner edificio isolato
		        project.setComplUrb(true);
		        impostTempEsterna();
		       
		    }  else if (e.getStateChange() == ItemEvent.DESELECTED) {
		    	project.setComplUrb(false);
		    }
	}  else if(e.getSource().equals(rdbtnPiccaggl)){
			// PICCOLO AGGLOMERATO 
		 if (e.getStateChange() == ItemEvent.SELECTED) {
			 sp_pic_agg.setEnabled(true); // spinner piccolo agglomerato
			 project.setPiccAggl(true);
			 impostTempEsterna();
		    }
		    else if (e.getStateChange() == ItemEvent.DESELECTED) {
		    	sp_pic_agg.setEnabled(false); // spinner piccolo agglomerato
		    	 project.setPiccAggl(false);
		    } 
	}else if(e.getSource().equals(rdbtnEdificiIsolati)){
		//EDIFICIO ISOLATO
		if (e.getStateChange() == ItemEvent.SELECTED) {
			 sp_ed_isol.setEnabled(true);//SPINNER EDIFICIO ISOLATO
			 project.setEdifIsol(true);
			 impostTempEsterna();
			 }
		    else if (e.getStateChange() == ItemEvent.DESELECTED) {
		    	project.setEdifIsol(false);
		    	sp_ed_isol.setEnabled(false);//SPINNER EDIFICIO ISOLATO
		    }
	}
	
}// ItemStateChanged
/**Intercettazione FormattedTextField value changed*/
@Override
public void propertyChange(PropertyChangeEvent evt) {
	 Object source = evt.getSource();
     if (source == txtFCitta) {
    	 project.setLocalita(txtFCitta.getText());
     }
}


	
}
