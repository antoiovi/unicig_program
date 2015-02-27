package unicig10641.unicig10641_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;


import javax.swing.JTabbedPane;

import project.Project;
import ui.commons.APDati;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import com.antoiovi.unicig.project.menu.APMenubar;

public class Unicig10641_1_Frame extends JFrame {

	private JPanel contentPane;
	private Project project;
	private APunicig10641_1 apunicig10641_1;
	private APMenubar apmenubar; 
	private JTextArea textArea;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Unicig10641_1_Frame frame = new Unicig10641_1_Frame();
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
	public Unicig10641_1_Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		 apunicig10641_1 = new APunicig10641_1();
		contentPane.add(apunicig10641_1, BorderLayout.CENTER);
		apmenubar = new APMenubar(apunicig10641_1 );
		contentPane.add(apmenubar, BorderLayout.NORTH);
		
		textArea = new JTextArea();
		textArea.setRows(5);
		
		scrollPane = new JScrollPane(textArea);
		contentPane.add(scrollPane, BorderLayout.SOUTH);
		
		
	}

}
