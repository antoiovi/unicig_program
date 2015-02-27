package com.antoiovi.unicig.project.unicig10641_1;

import javax.swing.JPanel;

import com.antoiovi.unicig.project.commons.APAmbiente;
import com.antoiovi.unicig.project.commons.APDati;
import com.antoiovi.unicig.project.commons.APanel_Unicig;
import com.antoiovi.unicig.project.menu.IMenu;




import com.antoiovi.unicig.project.unicig10640.APEdificio;

import java.awt.CardLayout;

public class APunicig10641_1 extends APanel_Unicig implements IMenu {
	
	/**
	 * Create the panel.
	 */
	public APunicig10641_1() {
		setLayout(new CardLayout(0, 0));
apdati=new APDati();

add(apdati,IMenu.dati);
apambiente=new APAmbiente();
add(apambiente,IMenu.ambiente);
apedificio=new APEdificio();;
add(apedificio,IMenu.edificio);
apcondotti=new APCondotti();
add(apcondotti,IMenu.condotti);
apcanali=new APCanali();
add(apcanali,IMenu.canali);
apcaldaie=new APCaldaie();
add(apcaldaie,IMenu.caldaie);
apinputdata=new APinputdata();
add(apinputdata,IMenu.inputdata);
apoutputdata=new APoutputdata();
add(apoutputdata,IMenu.outputdata);

	}

	
	
}
