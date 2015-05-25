package com.antoiovi.unicig.project.unicig10640;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.antoiovi.unicig.project.JPCards;
import com.antoiovi.unicig.project.commons.condotti.PCondotto;
import com.antoiovi.unicig.project.commons.condotti.PCondottoPrimarioSecondario;

public class Condotti extends JPCards {
	List<JPanel> condotti;
	public Condotti (){
	
		super();
	//setLayout(new BorderLayout(0, 0));
	
		condotti=new ArrayList<JPanel>();
	for(int x=0;x<maxpiani-1;x++){
		PCondottoPrimarioSecondario pcondotto=new PCondottoPrimarioSecondario();
		pcondotto.setTitolo("Piano "+x);
		condotti.add(pcondotto);
	}
	PCondotto terminale=new PCondotto();
	terminale.setTitolo("Terminale");
	terminale.setSottotitolo("PRIMARIO");
	condotti.add(terminale);
	
	JPanel panel_img = new JPanel();
	//add(panel_img, BorderLayout.WEST);
	super.init(condotti);
	super.setTitle("Condotti fumo ");
	}
}
