package com.antoiovi.unicig.project.unicig10640;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.antoiovi.unicig.project.commons.APAmbiente;
import com.antoiovi.unicig.project.commons.APDati;
import com.antoiovi.unicig.project.commons.APanel_Unicig;
import com.antoiovi.unicig.project.commons.condotti.APCondottiSempl;
import com.antoiovi.unicig.project.commons.*;
import com.antoiovi.unicig.project.menu.IMenu;

public class APunicig10640 extends APanel_Unicig {
	
	/**
	 * protected JPanel apdati;
	protected JPanel apambiente;
	protected JPanel apedificio;
	protected JPanel apcondotti;
	protected JPanel apcondottiaria;
	protected JPanel apcanali;
	protected JPanel apcaldaie;
	protected JPanel apinputdata;
	protected JPanel apoutputdata;
	 */
	
	/**
	 * Create the panel.
	 */
public APunicig10640() {
	setLayout(new CardLayout(0, 0));
	apdati=new APDati();
	apambiente=new APAmbiente();
	apedificio=new APEdificio();
	
	
	APCondottiSempl apcondottis=new APCondottiSempl();
	APCondottiSempl apcondottica=new APCondottiSempl();
	apcondottica.fixSezione("Circolare");
	apcondotti=apcondottis;
	apcanali=apcondottica;
	
		
	add(apdati,IMenu.dati);
	add(apambiente,IMenu.ambiente);
	add(apedificio,IMenu.edificio);
	add(apcondotti,IMenu.condotti);
	add(apcanali,IMenu.canali);
	apcaldaie=new APCaldaie();
	add(apcaldaie,IMenu.caldaie);
	//apinputdata=new APinputdata();
	//add(apinputdata,IMenu.inputdata);
	//apoutputdata=new APoutputdata();
	//add(apoutputdata,IMenu.outputdata);
	
	
	}
	

}
