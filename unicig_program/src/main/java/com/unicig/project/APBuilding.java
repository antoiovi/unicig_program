package com.unicig.project;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JSpinner;
import java.awt.Insets;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import com.unicig.project.typec1.ProjectC1;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class APBuilding extends JPanel implements IPanel{
	private JSpinner spinNumFloors;
	private JSpinner spinHeightSea;
	private JSpinner spinMinTemp;
	APanel_Unicig panelProject;
	private JComboBox comboBoxSection;

	/**
	 * Create the panel.
	 */
	public APBuilding(APanel_Unicig _panelProject) {
		this.panelProject=_panelProject;

		addComponentListener(new ComponentAdapter() {

			@Override
			public void componentHidden(ComponentEvent e) {
				panelProject.panelHidden(IMenu.edificio);
				
			}
		});
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNumberOfFlors = new JLabel("Number of flors");
		GridBagConstraints gbc_lblNumberOfFlors = new GridBagConstraints();
		gbc_lblNumberOfFlors.anchor = GridBagConstraints.WEST;
		gbc_lblNumberOfFlors.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumberOfFlors.gridx = 0;
		gbc_lblNumberOfFlors.gridy = 0;
		panel.add(lblNumberOfFlors, gbc_lblNumberOfFlors);
		
		spinNumFloors = new JSpinner();
		spinNumFloors.setModel(new SpinnerNumberModel(3, 1, 6, 1));
		GridBagConstraints gbc_spinNumFloors = new GridBagConstraints();
		gbc_spinNumFloors.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinNumFloors.insets = new Insets(0, 0, 5, 0);
		gbc_spinNumFloors.gridx = 1;
		gbc_spinNumFloors.gridy = 0;
		panel.add(spinNumFloors, gbc_spinNumFloors);
		
		JLabel lblHeightAboveSea = new JLabel("Height above sea level [ m ]");
		GridBagConstraints gbc_lblHeightAboveSea = new GridBagConstraints();
		gbc_lblHeightAboveSea.anchor = GridBagConstraints.WEST;
		gbc_lblHeightAboveSea.insets = new Insets(0, 0, 5, 5);
		gbc_lblHeightAboveSea.gridx = 0;
		gbc_lblHeightAboveSea.gridy = 1;
		panel.add(lblHeightAboveSea, gbc_lblHeightAboveSea);
		
		spinHeightSea = new JSpinner();
		spinHeightSea.setModel(new SpinnerNumberModel(0.0, 0.0,2000.0,50.0));
		GridBagConstraints gbc_spinHeightSea = new GridBagConstraints();
		gbc_spinHeightSea.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinHeightSea.insets = new Insets(0, 0, 5, 0);
		gbc_spinHeightSea.gridx = 1;
		gbc_spinHeightSea.gridy = 1;
		panel.add(spinHeightSea, gbc_spinHeightSea);
		
		JLabel lblMinumumOutsideTemperature = new JLabel("Minimum outside temperature [ C ]");
		GridBagConstraints gbc_lblMinumumOutsideTemperature = new GridBagConstraints();
		gbc_lblMinumumOutsideTemperature.insets = new Insets(0, 0, 5, 5);
		gbc_lblMinumumOutsideTemperature.gridx = 0;
		gbc_lblMinumumOutsideTemperature.gridy = 2;
		panel.add(lblMinumumOutsideTemperature, gbc_lblMinumumOutsideTemperature);
		
		spinMinTemp = new JSpinner();
		spinMinTemp.setModel(new SpinnerNumberModel(5.0, -10.0, 20.0, 0.5));
		GridBagConstraints gbc_spinMinTemp = new GridBagConstraints();
		gbc_spinMinTemp.insets = new Insets(0, 0, 5, 0);
		gbc_spinMinTemp.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinMinTemp.gridx = 1;
		gbc_spinMinTemp.gridy = 2;
		panel.add(spinMinTemp, gbc_spinMinTemp);
		
		JLabel lblChimneySection = new JLabel("Chimney section");
		GridBagConstraints gbc_lblChimneySection = new GridBagConstraints();
		gbc_lblChimneySection.anchor = GridBagConstraints.WEST;
		gbc_lblChimneySection.insets = new Insets(0, 0, 0, 5);
		gbc_lblChimneySection.gridx = 0;
		gbc_lblChimneySection.gridy = 3;
		panel.add(lblChimneySection, gbc_lblChimneySection);
		
		comboBoxSection = new JComboBox();
		comboBoxSection.setModel(new DefaultComboBoxModel(new String[] {ProjectC1.CIRCULAR, ProjectC1.RECTANGULAR}));
		GridBagConstraints gbc_comboBoxSection = new GridBagConstraints();
		gbc_comboBoxSection.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxSection.gridx = 1;
		gbc_comboBoxSection.gridy = 3;
		panel.add(comboBoxSection, gbc_comboBoxSection);
		
		JLabel lblBuildngAndEvnvoirnmant = new JLabel("Buildng and evnvironmant");
		lblBuildngAndEvnvoirnmant.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblBuildngAndEvnvoirnmant, BorderLayout.NORTH);

	}
	public boolean project_Data(ProjectC1 project) {
		boolean changed=false;
				double oldval=project.minOutTemp;
				Double value = (Double) spinMinTemp.getValue();
				changed=testChanged(oldval, value, changed);
				
				oldval=project.minOutTemp ;
				project.minOutTemp = value.doubleValue();
				changed=testChanged(oldval, project.minOutTemp , changed);
				
				oldval=project.heightSeaLevel;
				project.heightSeaLevel=(Double) spinHeightSea.getValue();
				changed=testChanged(oldval, project.heightSeaLevel , changed);
				
				int oldint=project.N_Floors;
				project.N_Floors=(Integer)spinNumFloors.getValue();
				changed =(changed==true)?changed:(!(oldint==project.N_Floors));
				String oldstring=project.chimneySection;
				project.chimneySection=(String)comboBoxSection.getSelectedItem();
				changed =(changed==true)?changed:(!(oldstring.equals(project.chimneySection)));
				return changed;
	}
	
	boolean testChanged(double oldval,double value,boolean changed) {
		return (changed==true)?changed:(!(oldval==value));
	}
	public void setNFloors(int nFloors) {
		// Do Nothing
		
	}
	public void setSectionR() {
		// TODO Auto-generated method stub
		
	}
	public void setSectionC() {
		// TODO Auto-generated method stub
		
	}


}
