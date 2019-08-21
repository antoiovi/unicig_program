package com.unicig.project;
import javax.swing.JPanel;
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
apcondotti=new JPanel();
apcanali=new JPanel();



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
