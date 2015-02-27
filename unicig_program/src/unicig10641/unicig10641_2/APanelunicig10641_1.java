package unicig10641.unicig10641_2;

import javax.swing.JPanel;

import project.Project;
import ui.commons.APAmbiente;
import ui.commons.APDati;
import ui.commons.APanel_Unicig;
import ui.commons.IMenu;
import unicig10641.commons.APCaldaie;

import java.awt.CardLayout;

public class APanelunicig10641_1 extends APanel_Unicig {
	
	/**
	 * Create the panel.
	 */
	public APanelunicig10641_1() {

apdati=new APDati();

apambiente=new APAmbiente();

apedificio=new APEdificio();;

apcondotti=new APCondotti();

apcanali=new APCanali();

apcaldaie=new APCaldaie();

apinputdata=new APinputdata();

apoutputdata=new APoutputdata();
initPanels();

	}
	

}
