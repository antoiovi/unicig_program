package com.unicig.project.typec1;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;

public class APCondotti extends JPanel {
	static final int NCOL=6;
	static final int NROWS=10;
	static final String titles[]= {"Diametro","Spessore","Perc.Esterna","D","E","F"};

JLabel headers[];
JLabel rownames[];

	public APCondotti() {
		headers=new JLabel[NCOL-2];
		rownames=new JLabel[NROWS-3];
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
		
		for(int ir=0;ir<(NCOL-2);ir++) {
			headers[ir]=new JLabel(titles[ir]);
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = ir+1;
			log("gridX= "+String.valueOf(ir+1));

			gbc_lblNewLabel.gridy = 0;
			panel_1.add(headers[ir], gbc_lblNewLabel);
		}
		

		for(int ir=0;ir<(NROWS-3);ir++) {
			rownames[ir]=new JLabel("Floor "+String.valueOf(ir));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = ir+1;
			log("gridY= "+String.valueOf(ir+1));
			panel_1.add(rownames[ir], gbc_lblNewLabel);
		}
		for(int ir=0;ir<(NCOL-3);ir++) {
			for(int fr=0;fr<(NROWS-3);fr++) {
				JSpinner spinner = new JSpinner();
				GridBagConstraints gbc_spinner = new GridBagConstraints();
				gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
				gbc_spinner.insets = new Insets(0, 0, 5, 5);
				gbc_spinner.gridx = ir+1;
				gbc_spinner.gridy = fr+1;
				panel_1.add(spinner, gbc_spinner);
				
				
			}
		}
		
	this.add(panel_1,BorderLayout.CENTER);
	JPanel panel_top=new JPanel();
	panel_top.setLayout(new BorderLayout(0,0));
	JLabel title=new JLabel("CONDOTTI");
	panel_top.add(title,BorderLayout.CENTER);
	this.add(panel_top,BorderLayout.NORTH);

	}

private void log(String s) {
	System.out.println(s);
}

}
