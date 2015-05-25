package com.antoiovi.unicig.project;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPCards extends JPanel {
protected int maxpiani=10;
protected int n_paini=10;
protected int current=0;
protected List<JPanel> panels;
private JPanel cardpanel;
private JButton btnNext;
private JButton btnPrev;
private JLabel lblPiano;
private JLabel lblTitle;
	/**
	 * Create the panel.
	 */
	public JPCards() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel btnpanel = new JPanel();
		add(btnpanel, BorderLayout.SOUTH);
		
		btnPrev = new JButton("<<");
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Prev();
			}
		});
		btnpanel.add(btnPrev);
		
		lblPiano = new JLabel("New label");
		btnpanel.add(lblPiano);
		
		btnNext = new JButton(">>");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Next();
			}
		});
		btnpanel.add(btnNext);
		
		JPanel imgpanel = new JPanel();
		add(imgpanel, BorderLayout.WEST);
		
		cardpanel = new JPanel();
		add(cardpanel, BorderLayout.CENTER);
		cardpanel.setLayout(new CardLayout(0, 0));
		
		JPanel eastpanel = new JPanel();
		add(eastpanel, BorderLayout.EAST);
		
		JPanel northpanel = new JPanel();
		add(northpanel, BorderLayout.NORTH);
		
		lblTitle = new JLabel("Title");
		northpanel.add(lblTitle);

	}
	
	
	public void init(List<JPanel> panel_s){
		current=0;
		panels=panel_s;
		for(JPanel panel:panels){
			cardpanel.add(panel,panels.indexOf(panel));
		}
		CardLayout cl=(CardLayout) cardpanel.getLayout();
		cl.first(cardpanel);
		lblPiano.setText(String.valueOf(current));
	}
	
	protected void Prev(){
		current--;
		btnNext.setEnabled(true);
		
		if(current<0){
			current=0;
		}else{
		CardLayout cl=(CardLayout) cardpanel.getLayout();
		cl.previous(cardpanel);
		}
		lblPiano.setText(String.valueOf(current));
		if(current==0){
			btnPrev.setEnabled(false);
		}
	
	}
	
	protected void Next(){
		current++;
		btnPrev.setEnabled(true);
		
		if(current==maxpiani){
			current--;
		}else{
		CardLayout cl=(CardLayout) cardpanel.getLayout();
		cl.next(cardpanel);
		}
		lblPiano.setText(String.valueOf(current));
		if(current==maxpiani-1){
			btnNext.setEnabled(false);
		}
	}
	
	public void setTitle(String title){
		lblTitle.setText(title);
	}

}
