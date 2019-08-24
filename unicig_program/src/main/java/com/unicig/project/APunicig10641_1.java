package com.unicig.project;
import javax.security.auth.login.AppConfigurationEntry;
import javax.swing.JPanel;

import com.unicig.project.typec1.APCanals;
import com.unicig.project.typec1.APCondotti;
import com.unicig.project.typec1.ProjectC1;

import java.awt.CardLayout;

public class APunicig10641_1 extends APanel_Unicig implements IMenu {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProjectC1 projectc1;
	
	
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
apdati=new JPanel();
apambiente=new JPanel();
apedificio=new APBuilding(this);
apcaldaie=new JPanel();
apinputdata=new JPanel();
apoutputdata=new JPanel();
//apcondotti=new Condotti();
apcondotti=new APCondotti(this);
((IPanel)apcondotti).setNFloors(projectc1.N_Floors);
apcanali=new APCanals(this);


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
		int oldNfloors=projectc1.N_Floors;
		String oldSection=projectc1.chimneySection;

		if(name.equals(IMenu.canali)) {
			APCanals ap=(APCanals)apcanali;
			ap.project_Data(projectc1);
			double canals[][]=projectc1.canal;
			int n=projectc1.conduct[0].length;
			int m=projectc1.conduct.length;
		}else if(name.equals(IMenu.condotti)) {
			APCondotti ap=(APCondotti)apcondotti;
			ap.project_Data(projectc1);
			double conduct[][]=projectc1.conduct;
			int n=projectc1.conduct[0].length;
			int m=projectc1.conduct.length;
			//log(String.format("conduct.lenght: %d \tconduct[0].lenght : %d",m,n));
			/*for(int ir=0;ir<conduct.length;ir++) {
				for(int am=0;am<conduct[ir].length;am++) {
					log(String.format("conduct[%d][%d]= %f",ir,am,projectc1.conduct[ir][am]));
				}
			}*/
			
		}else if(name.equals(IMenu.edificio)) {
			APBuilding ap=(APBuilding)apedificio;
			ap.project_Data(projectc1);
			IPanel apc=(IPanel)apcanali;
			IPanel apco=(IPanel)apcondotti;
			if(oldNfloors!=projectc1.N_Floors) projectChanged();
			apc.setNFloors(projectc1.N_Floors);
			apco.setNFloors(projectc1.N_Floors);
			if(!projectc1.chimneySection.equals(oldSection)) projectChanged();
			if(projectc1.chimneySection.equals(ProjectC1.CIRCULAR))
				apco.setSectionC();
			else
				apco.setSectionR();
			
			
		}
	}

	public void projectChanged() {
		// TODO
		log("Project CHANGED");
	}
	
	private void log(String s) {
		System.out.println(s);
	}

}
