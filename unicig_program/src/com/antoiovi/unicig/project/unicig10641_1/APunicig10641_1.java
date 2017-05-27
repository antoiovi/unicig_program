package com.antoiovi.unicig.project.unicig10641_1;

import javax.swing.JPanel;

import com.antoiovi.unicig.project.commons.APAmbiente;
import com.antoiovi.unicig.project.commons.APDati;

import com.antoiovi.unicig.project.commons.APanel_Unicig;

import com.antoiovi.unicig.project.menu.IMenu;
import com.antoiovi.unicig.project.Project;
import com.antoiovi.unicig.project.commons.*;

import java.awt.CardLayout;

public class APunicig10641_1 extends APanel_Unicig {
	Project project;
	/**
	 * Create the panel.
	 */
	public APunicig10641_1(Project _project) {
		this.project=_project;
		setLayout(new CardLayout(0, 0));
		
		
apdati=new APDati();
apambiente=new APAmbiente();
apedificio=new APEdificio(project);
apcaldaie=new Generatori();
apinputdata=new APinputdata();
apoutputdata=new APoutputdata();


apcondotti=new Condotti();
apcanali=new Canali();



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
	public void changedNPiani() {
		System.out.println("changed numero piani");
		
	}

	
	
}
