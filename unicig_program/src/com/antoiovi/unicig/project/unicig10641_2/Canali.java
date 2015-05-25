package com.antoiovi.unicig.project.unicig10641_2;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.antoiovi.unicig.project.JPCards;
import com.antoiovi.unicig.project.commons.APGeneratore;
import com.antoiovi.unicig.project.commons.condotti.PCondotto;
import com.antoiovi.unicig.project.commons.condotti.PCondottoConcentrico;

public class Canali extends JPCards {
	List<JPanel> condotti;
	public Canali (){
	
		super();
	//setLayout(new BorderLayout(0, 0));
	
		condotti=new ArrayList<JPanel>();
	for(int x=0;x<maxpiani;x++){
		PCondottoConcentrico pcondotto=new PCondottoConcentrico();
		pcondotto.fixSezione(PCondotto.CIRCOLARE);
		pcondotto.setTitolo("Piano "+x);
		condotti.add(pcondotto);
	}
	
	JPanel panel_img = new JPanel();
	//add(panel_img, BorderLayout.WEST);
	super.init(condotti);
	super.setTitle("Canali da fumo");
	}
}
