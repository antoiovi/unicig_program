package com.unicig.project.typec1;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import com.unicig.project.APMenubar;

import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;

public class APCondotti extends JPanel {
	//static final int NCOL=6;
	//static final int NROWS=10;
	int NCOL;
	int NROWS;
	int NLABELS;
	static final int NFLOORS=6;
	static final String titles[]= {"Height [m]","Diameter[mm]","Side A[mm]","Side B[mm]","Thickness[mm]","Curve red. fact.","% Contact Extern"};
	static final int HEIGHT=0;
	static final int DIAM=1;
	static final int SIDEA=2;
	static final int SIDEB=3;
	static final int TICK=4;
	static final int CURVRED=5;
	static final int CONTACT=6;
	JLabel headers[];
	JLabel rownames[];
	private JSpinner[][] spinners;
	private int nFloors;
	static final  int MAX_FLOORS=6;
	public APCondotti() {
		NLABELS=titles.length;
		
		headers=new JLabel[NLABELS];
		rownames=new JLabel[NFLOORS];
		NCOL=NLABELS+2;
		NROWS=NFLOORS+2;
		
		spinners=new JSpinner[NFLOORS][NLABELS];
		
		
		setLayout(new BorderLayout(0, 0));
		JPanel panel_1=new JPanel();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[NCOL];
		gridBagLayout.columnWeights = new double[NCOL];		//{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};

		for(int x =0;x<NCOL;x++) {
			gridBagLayout.columnWidths[x]=0;
			gridBagLayout.columnWeights[x]=0.0;
		}
		gridBagLayout.columnWeights[NCOL-1]=Double.MIN_VALUE;

		gridBagLayout.rowHeights = new int[NROWS];
		gridBagLayout.rowWeights = new double[NROWS];//{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		for(int x =0;x<NROWS;x++) {
			gridBagLayout.rowHeights[x]=0;
			gridBagLayout.rowWeights[x]=0.0;

		}
		gridBagLayout.rowWeights[NROWS-1]=Double.MIN_VALUE;

		panel_1.setLayout(gridBagLayout);
		
		for(int ir=0;ir<(NLABELS);ir++) {
			headers[ir]=new JLabel(titles[ir]);
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = ir+1;
			log("gridX= "+String.valueOf(ir+1));

			gbc_lblNewLabel.gridy = 0;
			panel_1.add(headers[ir], gbc_lblNewLabel);
		}
		

		for(int ir=0;ir<(NFLOORS);ir++) {
			rownames[ir]=new JLabel("Floor "+String.valueOf(ir));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = ir+1;
			log("gridY= "+String.valueOf(ir+1));
			panel_1.add(rownames[ir], gbc_lblNewLabel);
		}
		for(int ir=0;ir<(NLABELS);ir++) {
			for(int fr=0;fr<(NFLOORS);fr++) {
				SpinnerNumberModel spinnerModel=new SpinnerNumberModel(100.0,80.0,300.0,10.0);

				switch (ir){
					case HEIGHT:
						spinnerModel=new SpinnerNumberModel(3.0,2.0,5.0,0.5);
						break;
					case TICK:
						spinnerModel=new SpinnerNumberModel(30.0,10.0,200.0,10.0);
						break;
					case CURVRED:
						spinnerModel=new SpinnerNumberModel(0.0,0.0,3.0,0.1);
						break;
					case DIAM:
					case SIDEA:
					case SIDEB:
						spinnerModel=new SpinnerNumberModel(100.0,80.0,300.0,10.0);
						break;
					case CONTACT:
						spinnerModel=new SpinnerNumberModel(50.0,0.0,100.0,5.0);
						break;
				}
				JSpinner spinner = new JSpinner(spinnerModel);
				spinners[fr][ir]=spinner;
				GridBagConstraints gbc_spinner = new GridBagConstraints();
				gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
				gbc_spinner.insets = new Insets(0, 0, 5, 5);
				gbc_spinner.gridx = ir+1;
				gbc_spinner.gridy = fr+1;
				panel_1.add(spinner, gbc_spinner);
			
			}
		}
		// Button Copy
		JButton btnCopy = new JButton("Copy to all floors");
		btnCopy.addActionListener(new ActionCopy());
		GridBagConstraints gbc_btnCopy = new GridBagConstraints();
		gbc_btnCopy.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCopy.insets = new Insets(0, 0, 5, 5);
		gbc_btnCopy.gridx = NCOL-1;
		gbc_btnCopy.gridy = 1;
		panel_1.add(btnCopy, gbc_btnCopy);
		
		// Roghness 
		JPanel panel2 = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 5;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = NROWS-1;
		panel_1.add(panel2, gbc_panel);
		JLabel lblRough=new JLabel("Rougness [mm ]");
		JSpinner spinnerR = new JSpinner(new SpinnerNumberModel(0.2,0.01,2.0,0.01));
		panel2.add(lblRough);
		panel2.add(spinnerR);
//THERMAL Conductivity
		// Roghness 
		JLabel lblTherm=new JLabel("Thermal conductivity");
		JSpinner spinnerT = new JSpinner(new SpinnerNumberModel(0.5,0.0,10.0,0.1));
		panel2.add(lblTherm);
		panel2.add(spinnerT);

		
	// Add INPUT PANEL
	this.add(panel_1,BorderLayout.CENTER);
	JPanel panel_top=new JPanel();
	panel_top.setLayout(new BorderLayout(0,0));
	
	// Set Title
	JLabel title=new JLabel("CONDOTTI");
	panel_top.add(title,BorderLayout.CENTER);
	this.add(panel_top,BorderLayout.NORTH);

	// PANEL LABEL
	JPanel panelLable=new JPanel();
	panelLable.setLayout(new BorderLayout(0,0));
	JLabel imageLabel=new JLabel();
	try {
		ImageIcon image = new ImageIcon(APMenubar.class.getResource("image/InputCondotti.gif"));
			 imageLabel.setIcon(image);
			 imageLabel.setText("");
	}catch(NullPointerException e) {
		 imageLabel.setText("NULL IMAGE");
	}
	panelLable.add(imageLabel,BorderLayout.WEST);
	this.add(panelLable,BorderLayout.SOUTH);

	// Set section Circular
	this.setSectionR();
	this.setNFloors(3);
	}

	
	/**
	 * Set Section to Circular
	 */
	private void setSectionC() {
		for(int ir=0;ir<(NLABELS);ir++) {
			
			for(int fr=0;fr<(NFLOORS);fr++) {
				if(ir==SIDEA ||ir==SIDEB)
					spinners[fr][ir].setEnabled(false);
				if(ir==DIAM)
					spinners[fr][ir].setEnabled(true);
				}
			}
			
	}
	/**
	 * Set section to Rectangular
	 */
	private void setSectionR() {
		for(int ir=0;ir<(NLABELS);ir++) {
			
			for(int fr=0;fr<(NFLOORS);fr++) {
				if(ir==SIDEA ||ir==SIDEB)
					spinners[fr][ir].setEnabled(true);
				if(ir==DIAM)
					spinners[fr][ir].setEnabled(false);
				}
			}
			
	}
	
private void setNFloors(int nFloors) {
	if(nFloors<1 || nFloors>MAX_FLOORS) return;
	this.nFloors=nFloors;
		for(int ir=0;ir<(NLABELS);ir++) {
			for(int fr=0;fr<(NFLOORS);fr++) {
				if(fr>=nFloors)
					spinners[fr][ir].setEnabled(false);
				else
					spinners[fr][ir].setEnabled(true);
			}
			
	}
}	
		
	
	
private class ActionCopy implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		for(int ir=0;ir<(NLABELS);ir++) {
			for(int fr=1;fr<(NFLOORS);fr++) {
				spinners[fr][ir].getModel().setValue(spinners[0][ir].getValue());
			}
				
				
			}
	}
	
}
	
private void log(String s) {
	System.out.println(s);
}

}
