package com.unicig.project;

 
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

	
public class APMenubar extends JPanel {

IMenu menu;
private JButton btnCondottiAria;
private JButton btnEdificio;
private JButton btnCondottiFumo;
private JButton btnCanali;
private JButton btnGeneratori;

public APMenubar(IMenu imenu) {
	super();
	menu=imenu;
	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[]{0, 0, 89, 0, 0, 0, 0, 0, 0, 0};
	gridBagLayout.rowHeights = new int[]{77, 0};
	gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
	setLayout(gridBagLayout);
	
	JButton btnNewButton_2 = new JButton("Dati");
	btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			menu.viewDati();
		}
	});
	btnNewButton_2.setVerticalTextPosition(SwingConstants.BOTTOM);
	btnNewButton_2.setHorizontalTextPosition(SwingConstants.CENTER);
	btnNewButton_2.setIcon(new ImageIcon(APMenubar.class.getResource("image/Dati.GIF")));
	GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
	gbc_btnNewButton_2.fill = GridBagConstraints.VERTICAL;
	gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
	gbc_btnNewButton_2.gridx = 0;
	gbc_btnNewButton_2.gridy = 0;
	add(btnNewButton_2, gbc_btnNewButton_2);
	
	JButton btnNewButton_1 = new JButton("Ambiente");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			menu.viewAmbiente();
		}
	});
	btnNewButton_1.setVerticalTextPosition(SwingConstants.BOTTOM);
	btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
	btnNewButton_1.setIcon(new ImageIcon(APMenubar.class.getResource("image/Ambiente.GIF")));
	GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
	gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
	gbc_btnNewButton_1.fill = GridBagConstraints.VERTICAL;
	gbc_btnNewButton_1.gridx = 1;
	gbc_btnNewButton_1.gridy = 0;
	add(btnNewButton_1, gbc_btnNewButton_1);
	
	btnEdificio = new JButton("Edificio");
	btnEdificio.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			menu.viewEdificio();
		}
	});
	GridBagConstraints gbc_btnEdificio = new GridBagConstraints();
	gbc_btnEdificio.fill = GridBagConstraints.VERTICAL;
	gbc_btnEdificio.insets = new Insets(0, 0, 0, 5);
	gbc_btnEdificio.anchor = GridBagConstraints.WEST;
	gbc_btnEdificio.gridx = 2;
	gbc_btnEdificio.gridy = 0;
	add(btnEdificio, gbc_btnEdificio);
	btnEdificio.setHorizontalTextPosition(SwingConstants.CENTER);
	btnEdificio.setVerticalTextPosition(SwingConstants.BOTTOM);
	btnEdificio.setIcon(new ImageIcon(APMenubar.class.getResource("image/Edificio.GIF")));
	
	btnCondottiFumo = new JButton("Condotti fumo");
	btnCondottiFumo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			menu.viewCondotti();
		}
	});
	btnCondottiFumo.setVerticalTextPosition(SwingConstants.BOTTOM);
	btnCondottiFumo.setHorizontalTextPosition(SwingConstants.CENTER);
	btnCondottiFumo.setIcon(new ImageIcon(APMenubar.class.getResource("image/condotti.GIF")));
	GridBagConstraints gbc_btnCondottiFumo = new GridBagConstraints();
	gbc_btnCondottiFumo.fill = GridBagConstraints.VERTICAL;
	gbc_btnCondottiFumo.insets = new Insets(0, 0, 0, 5);
	gbc_btnCondottiFumo.gridx = 3;
	gbc_btnCondottiFumo.gridy = 0;
	add(btnCondottiFumo, gbc_btnCondottiFumo);
	
	btnCanali = new JButton("Canali");
	btnCanali.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			menu.viewCanali();
		}
	});
	
	btnCondottiAria = new JButton("Condotti aria");
	btnCondottiAria.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			menu.viewCondottiaria();
		}
	});
	btnCondottiAria.setVerticalTextPosition(SwingConstants.BOTTOM);
	btnCondottiAria.setHorizontalTextPosition(SwingConstants.CENTER);
	btnCondottiAria.setIcon(new ImageIcon(APMenubar.class.getResource("image/condotti.GIF")));
	GridBagConstraints gbc_btnCondottiAria = new GridBagConstraints();
	gbc_btnCondottiAria.fill = GridBagConstraints.VERTICAL;
	gbc_btnCondottiAria.insets = new Insets(0, 0, 0, 5);
	gbc_btnCondottiAria.gridx = 4;
	gbc_btnCondottiAria.gridy = 0;
	add(btnCondottiAria, gbc_btnCondottiAria);
	btnCanali.setVerticalTextPosition(SwingConstants.BOTTOM);
	btnCanali.setHorizontalTextPosition(SwingConstants.CENTER);
	btnCanali.setIcon(new ImageIcon(APMenubar.class.getResource("image/canalef.GIF")));
	GridBagConstraints gbc_btnCanali = new GridBagConstraints();
	gbc_btnCanali.fill = GridBagConstraints.VERTICAL;
	gbc_btnCanali.insets = new Insets(0, 0, 0, 5);
	gbc_btnCanali.gridx = 5;
	gbc_btnCanali.gridy = 0;
	add(btnCanali, gbc_btnCanali);
	
	JButton btnInputdata = new JButton("Dati input");
	btnInputdata.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			menu.viewInputdata();
		}
	});
	
	btnGeneratori = new JButton("Caldaie");
	btnGeneratori.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			menu.viewCaldaie();
		}
	});
	btnGeneratori.setHorizontalTextPosition(SwingConstants.CENTER);
	btnGeneratori.setVerticalTextPosition(SwingConstants.BOTTOM);
	btnGeneratori.setIcon(new ImageIcon(APMenubar.class.getResource("image/Caldaia.GIF")));
	GridBagConstraints gbc_btnGeneratori = new GridBagConstraints();
	gbc_btnGeneratori.fill = GridBagConstraints.VERTICAL;
	gbc_btnGeneratori.insets = new Insets(0, 0, 0, 5);
	gbc_btnGeneratori.gridx = 6;
	gbc_btnGeneratori.gridy = 0;
	add(btnGeneratori, gbc_btnGeneratori);
	btnInputdata.setVerticalTextPosition(SwingConstants.BOTTOM);
	btnInputdata.setHorizontalTextPosition(SwingConstants.CENTER);
	btnInputdata.setIcon(new ImageIcon(APMenubar.class.getResource("image/input.GIF")));
	GridBagConstraints gbc_btnInputdata = new GridBagConstraints();
	gbc_btnInputdata.fill = GridBagConstraints.VERTICAL;
	gbc_btnInputdata.insets = new Insets(0, 0, 0, 5);
	gbc_btnInputdata.gridx = 7;
	gbc_btnInputdata.gridy = 0;
	add(btnInputdata, gbc_btnInputdata);
	
	JButton btnCalcola = new JButton("Calcola");
	btnCalcola.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			menu.viewOutputdata();
		}
	});
	btnCalcola.setVerticalTextPosition(SwingConstants.BOTTOM);
	btnCalcola.setHorizontalTextPosition(SwingConstants.CENTER);
	btnCalcola.setIcon(new ImageIcon(APMenubar.class.getResource("image/calcoli.GIF")));
	GridBagConstraints gbc_btnCalcola = new GridBagConstraints();
	gbc_btnCalcola.fill = GridBagConstraints.VERTICAL;
	gbc_btnCalcola.gridx = 8;
	gbc_btnCalcola.gridy = 0;
	add(btnCalcola, gbc_btnCalcola);

}

public JButton getBtnCondottiAria() {
	return btnCondottiAria;
}
public JButton getBtnEdificio() {
	return btnEdificio;
}
public JButton getBtnCondottiFumo() {
	return btnCondottiFumo;
}
public JButton getBtnCanali() {
	return btnCanali;
}
public JButton getBtnGeneratori() {
	return btnGeneratori;
}
}
