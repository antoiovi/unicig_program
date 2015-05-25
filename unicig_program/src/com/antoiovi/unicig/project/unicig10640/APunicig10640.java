package com.antoiovi.unicig.project.unicig10640;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.antoiovi.unicig.project.commons.APAmbiente;
import com.antoiovi.unicig.project.commons.APDati;
import com.antoiovi.unicig.project.commons.*;
import com.antoiovi.unicig.project.menu.IMenu;
/**
 * Pannell principale del programma :
 * 
 *   ---- estende il pannello APanele_uniig
 *   Modifica: non estende più il pannello APanel_Unicig in quanto faccio estendere l'interfaccia 
 *   a questo pannello, per gestire meglio i comandi del menu, ed evitare una superflua
 *   prolissita
 *   
 * @author antoiovi
 *
 */
public class APunicig10640 extends JPanel implements com.antoiovi.unicig.project.menu.IMenu {
	//	protected Project project;
	protected JPanel apdati;
	protected JPanel apambiente;
	protected JPanel apedificio;
	protected JPanel apcondotti;
	// protected JPanel apcondottiaria; non serve in questo programma
	protected JPanel apcanali;
	protected JPanel apcaldaie;
	protected JPanel apinputdata;
	protected JPanel apoutputdata;
	//IAmbiente ambiente;
	//ICaldaie caldaie;extends APanel_Unicig {
	
	
	/**
	 * Create the panel.
	 */
public APunicig10640() {
	setLayout(new CardLayout(0, 0));
	apdati=new APDati();
	apambiente=new APAmbiente();
	apedificio=new APEdificio();
	
	/**
	 * Creazione pannello condotti fumari
	 */
	
	/*APCondottiSempl apcs_condottifumo=new APCondottiSempl();
	apcondotti=apcs_condottifumo;
	
	*13/05/2015 Il pannello condotti e stato sostituito con un nuovo tipo di pannello
	*/
	
	// APCondottiCCR appiano=new APCondottiCCR();
	apcondotti=new Condotti();
	
	
	/**
	 * Creazione pannello canali da fumo
	 */
	/**
	 * APCondottiSempl apcs_canalifumo=new APCondottiSempl();
		apcs_canalifumo.fixSezione("Circolare");
	13/05/2015 Il pannello caldaia e canali da fumo è unico
			
	**/
	
	
	apcaldaie=new Generatori();
	apcanali=new Canali();
	
	add(apdati,IMenu.dati);
	add(apambiente,IMenu.ambiente);
	add(apedificio,IMenu.edificio);
	add(apcondotti,IMenu.condotti);
	
	add(apcanali,IMenu.canali);
	
	
	add(apcaldaie,IMenu.caldaie);
	
	//apinputdata=new APinputdata();
	//add(apinputdata,IMenu.inputdata);
	//apoutputdata=new APoutputdata();
	//add(apoutputdata,IMenu.outputdata);
	
	
	}

/**
 * IMPLEMENTAZIONE DEI METODI DI IMENUBAR PER CONSENTIRE LO SCORRIMENTO DEI PANNELLI
 */
@Override
public void viewDati() {
	CardLayout cl=(CardLayout)this.getLayout();
	cl.show(this,IMenu.dati );
}

@Override
public void viewAmbiente() {
	CardLayout cl=(CardLayout)this.getLayout();
	cl.show(this,IMenu.ambiente );
}


@Override
public void viewCondotti() {
	CardLayout cl=(CardLayout)this.getLayout();
	cl.show(this,IMenu.condotti );
}
@Override
public void viewEdificio() {
	CardLayout cl=(CardLayout)this.getLayout();
	cl.show(this,IMenu.edificio );
}

@Override
public void viewCanali() {
	CardLayout cl=(CardLayout)this.getLayout();
	cl.show(this,IMenu.canali );
}
@Override
public void viewCaldaie() {
	CardLayout cl=(CardLayout)this.getLayout();
	cl.show(this,IMenu.caldaie);
}
@Override
public void viewInputdata() {
	CardLayout cl=(CardLayout)this.getLayout();
	cl.show(this,IMenu.inputdata );
}
@Override
public void viewOutputdata() {
	CardLayout cl=(CardLayout)this.getLayout();
	cl.show(this,IMenu.outputdata);
}

@Override
public void viewCondottiaria() {
	/**
	 * 	Non utilizzato in questo programma
	 */
	return;	
}

}
