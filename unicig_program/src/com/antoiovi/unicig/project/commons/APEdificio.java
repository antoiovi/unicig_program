package com.antoiovi.unicig.project.commons;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.antoiovi.unicig.project.Project;
import com.jgoodies.forms.factories.FormFactory;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JSpinner;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.SpinnerNumberModel;

import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import javax.swing.event.ChangeEvent;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class APEdificio extends JPanel implements PropertyChangeListener,ChangeListener,ActionListener,ItemListener{

	Project project;
	private JSpinner spinnerNPiani;
	private JComboBox comboBoxSezione;
	private JFormattedTextField ftxfPerdLocCom;
	private JSpinner spinnerNumeroDiTratti;
	private JLabel lblNumeroDiTratti;
	JSpinner.DefaultEditor npiani;
	private JCheckBox chckbxAperturaCompensazione;
	private JSpinner sp_SAComp;
	private JLabel lblSzApComp;
	/**
	 * Create the panel.
	 */
	public APEdificio(Project _project) {
		this.project=_project;
		  
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				},
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
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNumeroPiani = new JLabel("Numero piani");
		GridBagConstraints gbc_lblNumeroPiani = new GridBagConstraints();
		gbc_lblNumeroPiani.insets = new Insets(0, 2, 5, 5);
		gbc_lblNumeroPiani.gridx = 0;
		gbc_lblNumeroPiani.gridy = 0;
		panel_1.add(lblNumeroPiani, gbc_lblNumeroPiani);
		
		spinnerNPiani = new JSpinner();
				 
		spinnerNPiani.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		
		spinnerNPiani.addChangeListener(this);
		
		GridBagConstraints gbc_spinnerNPiani = new GridBagConstraints();
		gbc_spinnerNPiani.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerNPiani.ipadx = 5;
		gbc_spinnerNPiani.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerNPiani.gridx = 1;
		gbc_spinnerNPiani.gridy = 0;
		panel_1.add(spinnerNPiani, gbc_spinnerNPiani);
		
		lblNumeroDiTratti = new JLabel("Numero di tratti");
		GridBagConstraints gbc_lblNumeroDiTratti = new GridBagConstraints();
		gbc_lblNumeroDiTratti.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeroDiTratti.gridx = 0;
		gbc_lblNumeroDiTratti.gridy = 1;
		panel_1.add(lblNumeroDiTratti, gbc_lblNumeroDiTratti);
		
		spinnerNumeroDiTratti = new JSpinner();
		spinnerNumeroDiTratti.setModel(new SpinnerNumberModel(1, 1, 3, 1));
		spinnerNumeroDiTratti.addChangeListener(this);
		GridBagConstraints gbc_spinnerNumeroDiTratti = new GridBagConstraints();
		gbc_spinnerNumeroDiTratti.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerNumeroDiTratti.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerNumeroDiTratti.gridx = 1;
		gbc_spinnerNumeroDiTratti.gridy = 1;
		panel_1.add(spinnerNumeroDiTratti, gbc_spinnerNumeroDiTratti);
		
		JLabel lblSezioneCamino = new JLabel("Sezione camino");
		GridBagConstraints gbc_lblSezioneCamino = new GridBagConstraints();
		gbc_lblSezioneCamino.anchor = GridBagConstraints.EAST;
		gbc_lblSezioneCamino.insets = new Insets(0, 0, 5, 5);
		gbc_lblSezioneCamino.gridx = 0;
		gbc_lblSezioneCamino.gridy = 2;
		panel_1.add(lblSezioneCamino, gbc_lblSezioneCamino);
		
		comboBoxSezione = new JComboBox();
		comboBoxSezione.setModel(new DefaultComboBoxModel(Project.sezioni));
		GridBagConstraints gbc_comboBoxSezione = new GridBagConstraints();
		gbc_comboBoxSezione.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxSezione.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxSezione.gridx = 1;
		gbc_comboBoxSezione.gridy = 2;
		panel_1.add(comboBoxSezione, gbc_comboBoxSezione);
		comboBoxSezione.getModel().setSelectedItem(project.getSezioneCanna());
		
		JLabel lblComignolo = new JLabel("Comignolo");
		GridBagConstraints gbc_lblComignolo = new GridBagConstraints();
		gbc_lblComignolo.insets = new Insets(0, 0, 5, 5);
		gbc_lblComignolo.gridx = 0;
		gbc_lblComignolo.gridy = 3;
		panel_1.add(lblComignolo, gbc_lblComignolo);
		
		JLabel lblCoefficienteDiCarico = new JLabel("Coefficiente di perdita localizzata");
		GridBagConstraints gbc_lblCoefficienteDiCarico = new GridBagConstraints();
		gbc_lblCoefficienteDiCarico.insets = new Insets(0, 0, 5, 5);
		gbc_lblCoefficienteDiCarico.gridx = 1;
		gbc_lblCoefficienteDiCarico.gridy = 4;
		panel_1.add(lblCoefficienteDiCarico, gbc_lblCoefficienteDiCarico);
		
		
		   NumberFormat myFormat;
		   myFormat=NumberFormat.getInstance();
		   myFormat.setMaximumFractionDigits(3);
		 NumberFormatter formatter=  new NumberFormatter(myFormat);
		 formatter.setValueClass(Double.class);
		 formatter.setMinimum(Double.valueOf(0.0));
		 formatter.setMaximum(Double.valueOf(3.32));
		 formatter.setFormat(new DecimalFormat("#.###"));
		 /** Azione intrapresa quando value cambia ***/
 		PropertyChangeListener l = new PropertyChangeListener() {
 	        @Override
 	        public void propertyChange(PropertyChangeEvent evt) {
 	            String text = evt.getNewValue() != null ? evt.getNewValue().toString() : "null";
 	           
 	        }
 	    };
		ftxfPerdLocCom = new JFormattedTextField();
		ftxfPerdLocCom.setFormatterFactory(new DefaultFormatterFactory(formatter  ));
		ftxfPerdLocCom.addPropertyChangeListener("value", this);
		
 	   
 		
		
		
		GridBagConstraints gbc_ftxfPerdLocCom = new GridBagConstraints();
		gbc_ftxfPerdLocCom.gridwidth = 2;
		gbc_ftxfPerdLocCom.insets = new Insets(0, 0, 5, 0);
		gbc_ftxfPerdLocCom.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxfPerdLocCom.gridx = 2;
		gbc_ftxfPerdLocCom.gridy = 4;
		panel_1.add(ftxfPerdLocCom, gbc_ftxfPerdLocCom);
		
		chckbxAperturaCompensazione = new JCheckBox("Apertura compensazione");
		chckbxAperturaCompensazione.addItemListener(this);
		GridBagConstraints gbc_chckbxAperturaCompensazione = new GridBagConstraints();
		gbc_chckbxAperturaCompensazione.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxAperturaCompensazione.gridx = 0;
		gbc_chckbxAperturaCompensazione.gridy = 6;
		panel_1.add(chckbxAperturaCompensazione, gbc_chckbxAperturaCompensazione);
		
		lblSzApComp = new JLabel("Sezione apertura compensazone [ cmq]");
		GridBagConstraints gbc_lblSzApComp = new GridBagConstraints();
		gbc_lblSzApComp.insets = new Insets(0, 0, 0, 5);
		gbc_lblSzApComp.gridx = 1;
		gbc_lblSzApComp.gridy = 6;
		panel_1.add(lblSzApComp, gbc_lblSzApComp);
		
		sp_SAComp = new JSpinner();
		sp_SAComp.addChangeListener(this);
		sp_SAComp.setModel(new SpinnerNumberModel(100, 50, 400, 5));
		GridBagConstraints gbc_sp_SAComp = new GridBagConstraints();
		gbc_sp_SAComp.fill = GridBagConstraints.HORIZONTAL;
		gbc_sp_SAComp.gridwidth = 2;
		gbc_sp_SAComp.insets = new Insets(0, 0, 0, 5);
		gbc_sp_SAComp.gridx = 2;
		gbc_sp_SAComp.gridy = 6;
		panel_1.add(sp_SAComp, gbc_sp_SAComp);

	
	init();
	}
	
private void init(){
	spinnerNPiani.setValue(Integer.valueOf(project.getNpiani()));
	comboBoxSezione.getModel().setSelectedItem(project.getSezioneCanna());
	ftxfPerdLocCom.setValue(Double.valueOf(project.getPerdlocCam()));
	
	 spinnerNumeroDiTratti.setVisible(false);
	 lblNumeroDiTratti.setVisible(false);
	 
	 chckbxAperturaCompensazione.setSelected(project.isApcomp());
	 sp_SAComp.setValue(Integer.valueOf(project.getApcompSez()));
}
/*Per intercettare i JFormattedTextField  */
@Override
public void propertyChange(PropertyChangeEvent evt) {
	
	JComponent component=(JComponent)evt.getSource();
	
	 if(component.equals(ftxfPerdLocCom)){
		project.setPerdlocCam((Double)ftxfPerdLocCom.getValue());
		 
	 }
	  
	
}
/*  Per lo SPINNER bisogna implementare ChangeListener */

@Override
public void stateChanged(ChangeEvent arg0) {
	if(arg0.getSource().equals(spinnerNPiani)){
		Integer x=(Integer)spinnerNPiani.getModel().getValue();
		if(x==1){
			spinnerNumeroDiTratti.setVisible(true);
			lblNumeroDiTratti.setVisible(true);
		}else{
			spinnerNumeroDiTratti.setVisible(false);
			lblNumeroDiTratti.setVisible(false);
		}
		project.setNpiani((Integer)spinnerNPiani.getModel().getValue());
		APanel_Unicig parent=(APanel_Unicig)this.getParent();
		/*Bisogna fare il che per la prima chiaata è null */
		if(parent!=null){
			parent.changedNPiani();
		}
	 	 
	}else if (arg0.getSource().equals(spinnerNumeroDiTratti)){
		project.setNumtratti((Integer)spinnerNumeroDiTratti.getModel().getValue());
	}
}
/* Per intercettare il COMBOBOX bisogna implementare ActionListener OPPURE ItemListener
       */
@Override
public void actionPerformed(ActionEvent arg0) {
	if(arg0.getSource().equals(comboBoxSezione)){
		project.setSezioneCanna((String)comboBoxSezione.getModel().getSelectedItem());
		}
	}
/**
 * CHECKBOX
 * @param e
 */
@Override
public void itemStateChanged(ItemEvent e) {
	APanel_Unicig parent=(APanel_Unicig)this.getParent();
	  if(e.getSource().equals(chckbxAperturaCompensazione)){
			if(chckbxAperturaCompensazione.isSelected()){
				this.sp_SAComp.setEnabled(true);
				project.setApcomp(true);
				}else{
					this.sp_SAComp.setEnabled(false);
					project.setApcomp(false);
					
			}
			/*Bisogna fare il che per la prima chiaata è null */
			if(parent!=null){
				parent.changedApCompens();
			}
		}  
	}//Item state changed
	
}

