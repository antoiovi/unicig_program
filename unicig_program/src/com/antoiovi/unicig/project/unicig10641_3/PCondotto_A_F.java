package com.antoiovi.unicig.project.unicig10641_3;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import com.antoiovi.unicig.project.commons.condotti.PCondotto;

public class PCondotto_A_F extends JPanel {

	private PCondotto pFumol;
	private PCondotto pAria;

	/**
	 * Create the panel.
	 */
	public PCondotto_A_F() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		pFumol = new PCondotto();
		add(pFumol);
		
		pFumol.setSottotitolo("Condotto fumi");
		pAria = new PCondotto();
		pAria.setSottotitolo("Condotto aria");
		add(pAria);
	}

	public void setTitolo(String titolo){
		pFumol.setTitolo(titolo);
		pAria.setTitolo(titolo);
}
}
