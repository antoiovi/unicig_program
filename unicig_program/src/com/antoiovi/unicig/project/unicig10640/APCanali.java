package com.antoiovi.unicig.project.unicig10640;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.antoiovi.unicig.project.commons.condotti.APCondotto;
import com.antoiovi.unicig.project.commons.condotti.APanelCond;
import com.antoiovi.unicig.project.commons.condotti.APanelCondLabel;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class APCanali extends JPanel{ 
List<APanelCond> panels_cond;
List<APCondotto> apcond;
int maxpanels=3;

APCanali(){
	setLayout(new FormLayout(new ColumnSpec[] {
			FormFactory.RELATED_GAP_COLSPEC,
			ColumnSpec.decode("default:grow"),
			FormFactory.RELATED_GAP_COLSPEC,
			FormFactory.DEFAULT_COLSPEC,
			FormFactory.RELATED_GAP_COLSPEC,
			FormFactory.DEFAULT_COLSPEC,
			FormFactory.RELATED_GAP_COLSPEC,
			FormFactory.DEFAULT_COLSPEC,
			FormFactory.RELATED_GAP_COLSPEC,
			FormFactory.DEFAULT_COLSPEC,
			FormFactory.RELATED_GAP_COLSPEC,
			FormFactory.DEFAULT_COLSPEC,
			FormFactory.RELATED_GAP_COLSPEC,
			FormFactory.DEFAULT_COLSPEC,
			FormFactory.RELATED_GAP_COLSPEC,
			FormFactory.DEFAULT_COLSPEC,
			FormFactory.RELATED_GAP_COLSPEC,
			FormFactory.DEFAULT_COLSPEC,
			FormFactory.RELATED_GAP_COLSPEC,
			FormFactory.DEFAULT_COLSPEC,
			FormFactory.RELATED_GAP_COLSPEC,
			FormFactory.DEFAULT_COLSPEC,},
		new RowSpec[] {
			FormFactory.RELATED_GAP_ROWSPEC,
			RowSpec.decode("fill:default:grow"),}));
	
	APanelCondLabel panel = new APanelCondLabel();
	add(panel, "2, 2, fill, fill");
	
panels_cond=new ArrayList<APanelCond>();
apcond=new ArrayList<APCondotto>();

for(int x=0;x<maxpanels;x++){
	APanelCond p=new APanelCond();
	panels_cond.add(p);
	p.setAPCondottiRealted(apcond);
	apcond.add(p);
}
	int p1=2;
	for(int x=0;x<maxpanels;x++){
		System.out.println(p1);
		APanelCond ap=panels_cond.get(x);
		String s=p1+1+",1, default, fill";
		p1+=2;
		add(ap, s);
	}
	
}


int npanels=maxpanels;
/**
 * imposta il numero di piani (numero di pannelli visibili)
 * @param n
 */
public void setNumberPanels(int n){
	if(n<1 || n>maxpanels)
		return;
	npanels=n;
	int x=0;
	for(JPanel p:panels_cond){
		x++;
		if(x<=npanels)
			p.setVisible(true);
		else
			p.setVisible(false);
	}
}	

}