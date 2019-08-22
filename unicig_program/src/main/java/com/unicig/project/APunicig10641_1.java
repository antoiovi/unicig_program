package com.unicig.project;
import javax.swing.JPanel;

import com.unicig.project.typec1.APCanals;
import com.unicig.project.typec1.APCondotti;

import java.awt.CardLayout;

public class APunicig10641_1 extends APanel_Unicig implements IMenu {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public APunicig10641_1() {
		setLayout(new CardLayout(0, 0));
		
		
/*apdati=new APDati();
apambiente=new APAmbiente();
apedificio=new APEdificio();;
apcaldaie=new Generatori();
apinputdata=new APinputdata();
apoutputdata=new APoutputdata();
apdati=new APDati();*/
apdati=new JPanel();
apambiente=new JPanel();
apedificio=new JPanel();
apcaldaie=new JPanel();
apinputdata=new JPanel();
apoutputdata=new JPanel();
//apcondotti=new Condotti();
apcondotti=new APCondotti();

apcanali=new APCanals();


//Add to CardLayout the panel and its name
// with its name it will be called in APanel_Unicig
add(apdati,IMenu.dati);
add(apambiente,IMenu.ambiente);
add(apedificio,IMenu.edificio);
add(apcondotti,IMenu.condotti);
add(apcanali,IMenu.canali);
add(apcaldaie,IMenu.caldaie);
add(apinputdata,IMenu.inputdata);
add(apoutputdata,IMenu.outputdata);

	}

}
