package com.antoiovi.test.unicig_program;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.antoiovi.unicig.project.commons.condotti.APanelCondLabel;
import com.antoiovi.unicig.project.commons.condotti.APanelCondSempOrConc;
import java.awt.GridLayout;

public class JFAPcondsempOrConc extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAPcondsempOrConc frame = new JFAPcondsempOrConc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFAPcondsempOrConc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 616);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		APanelCondLabel panel_1 = new APanelCondLabel();
		panel.add(panel_1);
		
		APanelCondSempOrConc panel_2 = new APanelCondSempOrConc();
		panel.add(panel_2);
	}

}
