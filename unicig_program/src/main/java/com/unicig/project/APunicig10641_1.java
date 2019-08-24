package com.unicig.project;
import javax.security.auth.login.AppConfigurationEntry;
import javax.swing.JPanel;

import com.unicig.project.typec1.APCanals;
import com.unicig.project.typec1.APCondotti;
import com.unicig.project.typec1.APInputData;
import com.unicig.project.typec1.ProjectC1;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;

public class APunicig10641_1 extends APanel_Unicig implements IMenu,IPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProjectC1 projectc1;
	
List<IPanel>	ipanels=new ArrayList<IPanel>();
	public APunicig10641_1() {
		setLayout(new CardLayout(0, 0));
		 projectc1=new ProjectC1();	
		
/*apdati=new APDati();
apambiente=new APAmbiente();
apedificio=new APEdificio();;
apcaldaie=new Generatori();
apinputdata=new APinputdata();
apoutputdata=new APoutputdata();
apdati=new APDati();*/

apedificio=new APBuilding(this);
ipanels.add(((IPanel)apedificio));

//apcondotti=new Condotti();
apcondotti=new APCondotti(this);
((IPanel)apcondotti).setNFloors(projectc1.N_Floors);
ipanels.add(((IPanel)apcondotti));

apcanali=new APCanals(this);
((IPanel)apcanali).setNFloors(projectc1.N_Floors);
ipanels.add(((IPanel)apcanali));

apinputdata=new APInputData(projectc1);
((IPanel)apcanali).setNFloors(projectc1.N_Floors);
ipanels.add(((IPanel)apinputdata));

apdati=new JPanel();
apambiente=new JPanel();
apcaldaie=new JPanel();
apoutputdata=new JPanel();


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
	@Override
	public void panelHidden(String name){
		

		if(name.equals(IMenu.canali)) {
			boolean changed=((IPanel)apcanali).project_Data(projectc1);
			if (changed) projectChanged();			
		}else if(name.equals(IMenu.condotti)) {
			
			boolean changed=((IPanel)apcondotti).project_Data(projectc1);
			if (changed) projectChanged();			

			//log(String.format("conduct.lenght: %d \tconduct[0].lenght : %d",m,n));
			/*for(int ir=0;ir<conduct.length;ir++) {
				for(int am=0;am<conduct[ir].length;am++) {
					log(String.format("conduct[%d][%d]= %f",ir,am,projectc1.conduct[ir][am]));
				}
			}*/
			
		}else if(name.equals(IMenu.edificio)) {
			int oldNfloors=projectc1.N_Floors;
			String oldSection=projectc1.chimneySection;
			APBuilding ap=(APBuilding)apedificio;
			
			boolean changed=ap.project_Data(projectc1);
			if (changed) projectChanged();			
			
			if(oldNfloors!=projectc1.N_Floors) {
				projectChanged();
				setNFloors(projectc1.N_Floors);
			}
			if(!projectc1.chimneySection.equals(oldSection)) {
				if(projectc1.chimneySection.equals(ProjectC1.CIRCULAR)) 
					setSectionC();
				else 
					setSectionR();
			}
			
		}
	}
	
	

	public void projectChanged() {
		// TODO
		log("Project CHANGED");
	}
	
	private void log(String s) {
		System.out.println(s);
	}
	public boolean project_Data(ProjectC1 project) {
		return false;
	}
	public void setNFloors(int nFloors) {
		for(IPanel ip:ipanels)
			ip.setNFloors(nFloors);
	}
	public void setSectionR() {
		for(IPanel ip:ipanels)
			ip.setSectionR();		
	}
	public void setSectionC() {
		for(IPanel ip:ipanels)
			ip.setSectionC();			
	}

}
