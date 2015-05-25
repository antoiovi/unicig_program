package com.antoiovi.unicig.project.unicig10641_1;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.antoiovi.unicig.project.JPCards;
import com.antoiovi.unicig.project.commons.condotti.APCondotto;
import com.antoiovi.unicig.project.commons.condotti.PCondotto;
import com.antoiovi.unicig.project.commons.condotti.PCondottoConcentrico;
import com.antoiovi.unicig.project.commons.condotti.PCondottoSempliceOrConcentrico;

public class Canali extends JPCards {
	List<JPanel> condotti;
	PCondotto cond_sing;
	PCondottoConcentrico cond_conc;
	
	public Canali (){
	
		super();
	//setLayout(new BorderLayout(0, 0));
	
		condotti=new ArrayList<JPanel>();
	for(int x=0;x<maxpiani;x++){
		PCondottoSempliceOrConcentrico pcondotto=new PCondottoSempliceOrConcentrico();
		cond_sing=pcondotto.getPc_sing();
		cond_conc=pcondotto.getPcc_conc();
		pcondotto.setTitolo("Piano "+x);
		cond_sing.fixSezione(PCondotto.CIRCOLARE);
		cond_conc.fixSezione(PCondotto.CIRCOLARE);
		condotti.add(pcondotto);
	}
	
	JPanel panel_img = new JPanel();
	//add(panel_img, BorderLayout.WEST);
	super.init(condotti);
	super.setTitle("Canali da fumo (semplice o concentrico");
	}
}
