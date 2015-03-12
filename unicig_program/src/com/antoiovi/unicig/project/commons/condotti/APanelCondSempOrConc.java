package com.antoiovi.unicig.project.commons.condotti;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class APanelCondSempOrConc extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private CardLayout cardlayout;
	JPanel parentpanel;
	public APanelCondSempOrConc() {
		setLayout(new BorderLayout(0, 0));
		parentpanel=this;
		JPanel panel_2 = new JPanel();
		add(panel_2);
		cardlayout=new CardLayout(0, 0);
		panel_2.setLayout(cardlayout);
		
		APanelCond panel_1 = new APanelCond();
		panel_2.add(panel_1, "condottosemplice");
		
		APanelCondConc panel = new APanelCondConc();
		panel_2.add(panel, "condottoconcentrico");
		
		JPanel panel_3 = new JPanel();
		add(panel_3, BorderLayout.NORTH);
		
		rdbtnNewRadioButton = new JRadioButton("Semplice");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(true);
		panel_3.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Concentrico");
		rdbtnNewRadioButton_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(rdbtnNewRadioButton_1.isSelected()){
					cardlayout.show(parentpanel, "condottosemplice");	
				}else{
					cardlayout.show(parentpanel, "condottoconcentrico");
				}
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_1);
		panel_3.add(rdbtnNewRadioButton_1);
	}

}
