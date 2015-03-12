package com.antoiovi.unicig.project.unicig10640;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.antoiovi.unicig.project.menu.APMenubar;
import com.antoiovi.unicig.project.menu.IMenu;
import com.antoiovi.unicig.project.unicig10641_1.APunicig10641_1;

public class Unicig10640_Frame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Unicig10640_Frame frame = new Unicig10640_Frame();
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
	public Unicig10640_Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		APunicig10640 panel = new APunicig10640();
		contentPane.add(panel);
		IMenu menu=(IMenu)panel ;
		APMenubar panel_1 = new APMenubar (menu);
		panel_1.getBtnCondottiAria().setVisible(false);
		contentPane.add(panel_1, BorderLayout.NORTH);
	}

}
