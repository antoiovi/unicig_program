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
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.unicig.project.APMenubar;
import com.unicig.project.APanel_Unicig;
import com.unicig.project.IMenu;
import com.unicig.project.Project;

import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class APCanals extends JPanel {
	// static final int NCOL=6;
	// static final int NROWS=10;
	int NCOL;
	int NROWS;
	int NLABELS;
	static final int MAX_FLOORS = 6;
	static final String titles[] = { "Height [m]", "Total lenght[m]", "Diameter[mm]", "Thickness[mm]",
			"Curve red. fact.", "% Contact Extern" };
	static final int HEIGHT = 0;
	static final int TOTALLENGHT = 1;
	static final int DIAM = 2;
	static final int TICK = 3;
	static final int CURVRED = 4;
	static final int CONTACT = 5;
	JLabel headers[];
	JLabel rownames[];
	private JSpinner[][] spinners;
	private int nFloors;
	private JSpinner spinnerT;
	private JSpinner spinnerR;
	String helpString =Project.helpPipeString;
	APanel_Unicig panelProject;
	// static final int MAX_FLOORS=6;
	public APCanals(APanel_Unicig _panelProject) {
		this.panelProject=_panelProject;
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				panelProject.panelHidden(IMenu.canali);
				log("HIDDEN");
			}
		});
		
		
		NLABELS = titles.length;

		headers = new JLabel[NLABELS];
		rownames = new JLabel[MAX_FLOORS];
		NCOL = NLABELS + 2;
		NROWS = MAX_FLOORS + 2;

		spinners = new JSpinner[MAX_FLOORS][NLABELS];

		setLayout(new BorderLayout(0, 0));
		JPanel panel_1 = new JPanel();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[NCOL];
		gridBagLayout.columnWeights = new double[NCOL]; // {0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};

		for (int x = 0; x < NCOL; x++) {
			gridBagLayout.columnWidths[x] = 0;
			gridBagLayout.columnWeights[x] = 0.0;
		}
		gridBagLayout.columnWeights[NCOL - 1] = Double.MIN_VALUE;

		gridBagLayout.rowHeights = new int[NROWS];
		gridBagLayout.rowWeights = new double[NROWS];// {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		for (int x = 0; x < NROWS; x++) {
			gridBagLayout.rowHeights[x] = 0;
			gridBagLayout.rowWeights[x] = 0.0;

		}
		gridBagLayout.rowWeights[NROWS - 1] = Double.MIN_VALUE;

		panel_1.setLayout(gridBagLayout);

		for (int ir = 0; ir < (NLABELS); ir++) {
			headers[ir] = new JLabel(titles[ir]);
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = ir + 1;
			gbc_lblNewLabel.gridy = 0;
			panel_1.add(headers[ir], gbc_lblNewLabel);
		}

		for (int ir = 0; ir < (MAX_FLOORS); ir++) {
			rownames[ir] = new JLabel("Floor " + String.valueOf(ir));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = ir + 1;
			panel_1.add(rownames[ir], gbc_lblNewLabel);
		}
		ChangeListener listenerH = new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
					for (int fr = 0; fr < (MAX_FLOORS); fr++) {
						Double H = (Double) spinners[fr][0].getValue();
						Double L = (Double) spinners[fr][1].getValue();
						if(H>L)  spinners[fr][0].setValue(L);
					}
				}

				
		};
		for (int ir = 0; ir < (NLABELS); ir++) {
			for (int fr = 0; fr < (MAX_FLOORS); fr++) {
				SpinnerNumberModel spinnerModel = new SpinnerNumberModel(100.0, 80.0, 300.0, 10.0);

				switch (ir) {
				case HEIGHT:
					spinnerModel = new SpinnerNumberModel(3.0, 2.0, 5.0, 0.5);
					break;
				case TOTALLENGHT:
					spinnerModel = new SpinnerNumberModel(3.0, 2.0, 5.0, 0.5);
					break;
				case TICK:
					spinnerModel = new SpinnerNumberModel(2.0, 1.0, 10.0, 1.0);
					break;
				case CURVRED:
					spinnerModel = new SpinnerNumberModel(0.0, 0.0, 3.0, 0.1);
					break;
				case DIAM:
					spinnerModel = new SpinnerNumberModel(80.0, 60.0, 150.0, 10.0);
					break;
				case CONTACT:
					spinnerModel = new SpinnerNumberModel(50.0, 0.0, 100.0, 5.0);
					break;
				}
				JSpinner spinner = new JSpinner(spinnerModel);
				spinners[fr][ir] = spinner;
				if (ir==HEIGHT || ir==TOTALLENGHT) spinner.addChangeListener(listenerH);
					
				GridBagConstraints gbc_spinner = new GridBagConstraints();
				gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
				gbc_spinner.insets = new Insets(0, 0, 5, 5);
				gbc_spinner.gridx = ir + 1;
				gbc_spinner.gridy = fr + 1;
				panel_1.add(spinner, gbc_spinner);

			}
		}
		// Button Copy
		JButton btnCopy = new JButton("Copy to all floors");
		btnCopy.addActionListener(new ActionCopy());
		GridBagConstraints gbc_btnCopy = new GridBagConstraints();
		gbc_btnCopy.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCopy.insets = new Insets(0, 0, 5, 5);
		gbc_btnCopy.gridx = NCOL - 1;
		gbc_btnCopy.gridy = 1;
		panel_1.add(btnCopy, gbc_btnCopy);

		// Roghness and THERMAL Conductivity
		JPanel panel2 = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 5;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = NROWS - 1;
		panel_1.add(panel2, gbc_panel);
		// Roghness
		JLabel lblRough = new JLabel("Rougness [mm ]");
		spinnerR = new JSpinner(new SpinnerNumberModel(2.0, 1.0, 7.0, 1.0));
		panel2.add(lblRough);
		panel2.add(spinnerR);

		//THERMAL Conductivity
		JLabel lblTherm = new JLabel("Coeff. heat transmission [W/(m2 K)]");
		spinnerT = new JSpinner(new SpinnerNumberModel(0.5, 0.1, 160.0, 0.1));		panel2.add(lblTherm);
		panel2.add(spinnerT);

		// Add INPUT PANEL
		JScrollPane scrollpane = new JScrollPane(panel_1);
		this.add(scrollpane, BorderLayout.CENTER);

		// Set Title
		JLabel title = new JLabel("CANALI DA FUMO");
		JPanel panel_top = new JPanel();
		panel_top.setLayout(new BorderLayout(0, 0));
		panel_top.add(title, BorderLayout.CENTER);
		this.add(panel_top, BorderLayout.NORTH);

		// PANEL LABEL
		JPanel panelLable = new JPanel();
		panelLable.setLayout(new BorderLayout(0, 0));
		JLabel imageLabel = new JLabel();
		try {
			ImageIcon image = new ImageIcon(APMenubar.class.getResource("image/InputCanals.gif"));
			imageLabel.setIcon(image);
			imageLabel.setText("");
		} catch (NullPointerException e) {
			imageLabel.setText("NULL IMAGE");
		}
		panelLable.add(imageLabel, BorderLayout.WEST);

		int WIDIMG = 3;
		int XIMG = 1;
		GridBagConstraints gbc_panel_lbl = new GridBagConstraints();
		gbc_panel_lbl.gridheight = 1;
		gbc_panel_lbl.gridwidth = WIDIMG;
		gbc_panel_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_panel_lbl.fill = GridBagConstraints.VERTICAL;
		gbc_panel_lbl.gridx = XIMG;
		gbc_panel_lbl.gridy = NROWS;
		panel_1.add(panelLable, gbc_panel_lbl);

		// PANEL HELP
		JPanel panelHelp = new JPanel();
		panelHelp.setLayout(new BorderLayout(0, 0));
		GridBagConstraints gbc_panel_help = new GridBagConstraints();
		gbc_panel_help.gridheight = 1;
		gbc_panel_help.gridwidth = 5;
		gbc_panel_help.insets = new Insets(0, 0, 5, 5);
		gbc_panel_help.fill = GridBagConstraints.VERTICAL;
		gbc_panel_help.gridx = XIMG + WIDIMG;
		gbc_panel_help.gridy = NROWS;
		panel_1.add(panelHelp, gbc_panel_help);
		JTextArea helpArea = new JTextArea();
		helpArea.setText(helpString);
		helpArea.setEditable(false);
		panelHelp.add(helpArea, BorderLayout.NORTH);

		this.setNFloors(3);
	}

	private void setNFloors(int nFloors) {
		if (nFloors < 1 || nFloors > MAX_FLOORS)
			return;
		this.nFloors = nFloors;
		for (int ir = 0; ir < (NLABELS); ir++) {
			for (int fr = 0; fr < (MAX_FLOORS); fr++) {
				if (fr >= nFloors)
					spinners[fr][ir].setEnabled(false);
				else
					spinners[fr][ir].setEnabled(true);
			}

		}
	}

	public void project_Data(ProjectC1 project) {
		for (int ir = 0; ir < (NLABELS); ir++) {
			for (int fr = 0; fr < (MAX_FLOORS); fr++) {
				Double value = (Double) spinners[fr][ir].getValue();
				project.canal[fr][ir] = value.doubleValue();
			}
			Double value = (Double) spinnerT.getValue();
			project.canalCondTerm = value.doubleValue();
			value = (Double) spinnerR.getValue();
			project.canalRoug = value.doubleValue();
		}

	}

	private class ActionCopy implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			for (int ir = 0; ir < (NLABELS); ir++) {
				for (int fr = 1; fr < (MAX_FLOORS); fr++) {
					spinners[fr][ir].getModel().setValue(spinners[0][ir].getValue());
				}

			}
		}

	}

	private void log(String s) {
		System.out.println(s);
	}

}
