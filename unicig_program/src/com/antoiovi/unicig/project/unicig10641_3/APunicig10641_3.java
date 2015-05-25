package com.antoiovi.unicig.project.unicig10641_3;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.antoiovi.unicig.project.commons.APAmbiente;
import com.antoiovi.unicig.project.commons.APDati;
import com.antoiovi.unicig.project.commons.APanel_Unicig;

import com.antoiovi.unicig.project.menu.IMenu;




import com.antoiovi.unicig.project.unicig10640.APEdificio;




import java.awt.BorderLayout;
import java.awt.CardLayout;

public class APunicig10641_3 extends APanel_Unicig implements IMenu {
	
	/**
	 * Create the panel.
	 */
	public APunicig10641_3() {
		setLayout(new CardLayout(0, 0));
		

apdati=new APDati();
apambiente=new APAmbiente();
apedificio=new APEdificio();;
apcaldaie=new Generatori();
apinputdata=new APinputdata();
apoutputdata=new APoutputdata();


apcondotti=new Condotti();
apcanali=new Canali();
apcondottiaria=new Condotti();


add(apdati,IMenu.dati);
add(apambiente,IMenu.ambiente);
add(apedificio,IMenu.edificio);
add(apcondotti,IMenu.condotti);
//add(apcondotti,IMenu.condotti);
add(apcanali,IMenu.canali);
add(apcaldaie,IMenu.caldaie);
add(apinputdata,IMenu.inputdata);
add(apoutputdata,IMenu.outputdata);
	}

}
