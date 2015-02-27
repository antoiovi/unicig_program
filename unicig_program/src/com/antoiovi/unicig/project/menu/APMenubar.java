package com.antoiovi.unicig.project.menu;

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
	
	/**
	 * Create the panel.
	 */
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
		btnNewButton_2.setIcon(new ImageIcon(APMenubar.class.getResource("/com/antoiovi/unicig/project/image/Dati.GIF")));
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
		btnNewButton_1.setIcon(new ImageIcon(APMenubar.class.getResource("/com/antoiovi/unicig/project/image/Ambiente.GIF")));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 0;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton = new JButton("Edificio");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.viewEdificio();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton.setIcon(new ImageIcon(APMenubar.class.getResource("/com/antoiovi/unicig/project/image/Edificio.GIF")));
		
		JButton btnCondottiFumo = new JButton("Condotti fumo");
		btnCondottiFumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.viewCondotti();
			}
		});
		btnCondottiFumo.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCondottiFumo.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCondottiFumo.setIcon(new ImageIcon(APMenubar.class.getResource("/com/antoiovi/unicig/project/image/condotti.GIF")));
		GridBagConstraints gbc_btnCondottiFumo = new GridBagConstraints();
		gbc_btnCondottiFumo.fill = GridBagConstraints.VERTICAL;
		gbc_btnCondottiFumo.insets = new Insets(0, 0, 0, 5);
		gbc_btnCondottiFumo.gridx = 3;
		gbc_btnCondottiFumo.gridy = 0;
		add(btnCondottiFumo, gbc_btnCondottiFumo);
		
		JButton btnNewButton_4 = new JButton("Canali");
		btnNewButton_4.addActionListener(new ActionListener() {
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
		btnCondottiAria.setIcon(new ImageIcon(APMenubar.class.getResource("/com/antoiovi/unicig/project/image/condotti.GIF")));
		GridBagConstraints gbc_btnCondottiAria = new GridBagConstraints();
		gbc_btnCondottiAria.fill = GridBagConstraints.VERTICAL;
		gbc_btnCondottiAria.insets = new Insets(0, 0, 0, 5);
		gbc_btnCondottiAria.gridx = 4;
		gbc_btnCondottiAria.gridy = 0;
		add(btnCondottiAria, gbc_btnCondottiAria);
		btnNewButton_4.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_4.setIcon(new ImageIcon(APMenubar.class.getResource("/com/antoiovi/unicig/project/image/canalef.GIF")));
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_4.gridx = 5;
		gbc_btnNewButton_4.gridy = 0;
		add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Dati input");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.viewInputdata();
			}
		});
		
		JButton btnNewButton_7 = new JButton("Caldaie");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.viewCaldaie();
			}
		});
		btnNewButton_7.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_7.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_7.setIcon(new ImageIcon(APMenubar.class.getResource("/com/antoiovi/unicig/project/image/Caldaia.GIF")));
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_7.gridx = 6;
		gbc_btnNewButton_7.gridy = 0;
		add(btnNewButton_7, gbc_btnNewButton_7);
		btnNewButton_5.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_5.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_5.setIcon(new ImageIcon(APMenubar.class.getResource("/com/antoiovi/unicig/project/image/input.GIF")));
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_5.gridx = 7;
		gbc_btnNewButton_5.gridy = 0;
		add(btnNewButton_5, gbc_btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Calcola");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.viewOutputdata();
			}
		});
		btnNewButton_6.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_6.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_6.setIcon(new ImageIcon(APMenubar.class.getResource("/com/antoiovi/unicig/project/image/calcoli.GIF")));
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.gridx = 8;
		gbc_btnNewButton_6.gridy = 0;
		add(btnNewButton_6, gbc_btnNewButton_6);

	}

	public JButton getBtnCondottiAria() {
		return btnCondottiAria;
	}
}
