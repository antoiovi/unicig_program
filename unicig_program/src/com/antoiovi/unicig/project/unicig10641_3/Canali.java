package com.antoiovi.unicig.project.unicig10641_3;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.antoiovi.unicig.project.JPCards;
import com.antoiovi.unicig.project.commons.condotti.APCondotto;
import com.antoiovi.unicig.project.commons.condotti.PCondotto;

public class Canali extends JPCards {
	List<JPanel> condotti;
	public Canali (){
	
		super();
	//setLayout(new BorderLayout(0, 0));
	
		condotti=new ArrayList<JPanel>();
	for(int x=0;x<maxpiani;x++){
		PCondotto pcondotto=new PCondotto();
		pcondotto.fixSezione(PCondotto.CIRCOLARE);
		condotti.add(pcondotto);
		pcondotto.setTitolo("Piano "+x);
		pcondotto.fixSezione(APCondotto.CIRCOLARE);
	}
	
	JPanel panel_img = new JPanel();
	//add(panel_img, BorderLayout.WEST);
	super.init(condotti);
	super.setTitle("Canali da fumo");
	}
}
