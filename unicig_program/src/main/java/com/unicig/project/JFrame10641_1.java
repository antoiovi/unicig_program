package com.unicig.project;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class JFrame10641_1 extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame10641_1 frame = new JFrame10641_1();
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
	public JFrame10641_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		this.setSize(1000,800);
		this.setResizable(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		APunicig10641_1 panel = new APunicig10641_1();
		contentPane.add(panel);
		IMenu menu=(IMenu)panel ;
		APMenubar panel_1 = new APMenubar (menu);
		panel_1.getBtnCondottiAria().setVisible(false);
		contentPane.add(panel_1, BorderLayout.NORTH);
		
	}
}
