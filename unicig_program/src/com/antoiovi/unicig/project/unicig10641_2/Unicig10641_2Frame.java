package com.antoiovi.unicig.project.unicig10641_2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.antoiovi.unicig.project.menu.APMenubar;
import com.antoiovi.unicig.project.menu.IMenu;
/**
 * Unicig10641_2 Condotti fumari concentrici
 * @author antoiovi
 *
 */
public class Unicig10641_2Frame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Unicig10641_2Frame frame = new Unicig10641_2Frame();
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
	public Unicig10641_2Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		this.setSize(1000,800);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		APunicig10641_2 panel = new APunicig10641_2();
		contentPane.add(panel);
		IMenu menu=(IMenu)panel ;
		APMenubar panel_menu = new APMenubar (menu);
		panel_menu.getBtnCondottiAria().setVisible(false);
		contentPane.add(panel_menu, BorderLayout.NORTH);
		
	}

}
