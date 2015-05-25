package com.antoiovi.unicig.project.unicig10641_1;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.antoiovi.unicig.project.JPCards;
import com.antoiovi.unicig.project.commons.condotti.PCondotto;


public class Condotti extends JPCards {
	List<JPanel> condotti;
	public Condotti (){
	
		super();
	//setLayout(new BorderLayout(0, 0));
	
		condotti=new ArrayList<JPanel>();
	for(int x=0;x<maxpiani;x++){
		PCondotto pcondotto=new PCondotto();
		pcondotto.setTitolo("Piano "+x);
		condotti.add(pcondotto);
	}
	
	JPanel panel_img = new JPanel();
	//add(panel_img, BorderLayout.WEST);
	super.init(condotti);
	super.setTitle("Condotti fumo ");
	}
}
