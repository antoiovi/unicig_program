package com.antoiovi.unicig.project.commons;

import javax.swing.JPanel;


//import project.Project;
/*import ui.commons.APAmbiente;
import ui.commons.APDati;
*/
import com.antoiovi.unicig.project.commons.*;
import com.antoiovi.unicig.project.menu.IMenu;

//import unicig10641.commons.APCaldaie;


import java.awt.CardLayout;
/**
 * Classe base da cui derivano tutti i pannelli principali dei programmi
 * 	implementa l'interfaccia IMenu in cui sono esposti i metodi del menu
 * e implementa la logia dei comandi del menu
 * 
 * Le classi che estendono questa classe devono creare i JPAnel definiti qui,
 * 	e poi devono essere agiunti o tramite il metodo initPAnels() o tramite 
 *  il metodo di JPANEL  add
*	
*	public void add(Component comp, Object constraints)
*
*constraints è una stringa tratta da IMenu che viene utilizzata tramite 
*il layout CardLayout per visualizzare l'oppurtuno pannello
 *  
 *  
 *  
 * 
 */

public abstract class APanel_Unicig extends JPanel implements com.antoiovi.unicig.project.menu.IMenu {
	//	protected Project project;
	protected JPanel apdati;
	protected JPanel apambiente;
	protected JPanel apedificio;
	protected JPanel apcondotti;
	protected JPanel apcondottiaria;
	protected JPanel apcanali;
	protected JPanel apcaldaie;
	protected JPanel apinputdata;
	protected JPanel apoutputdata;
	//IAmbiente ambiente;
	//ICaldaie caldaie;
	/**
	 * Create the panel.
	 */
	public APanel_Unicig() {
	super();
	}
	
	protected void initPanels(){
		setLayout(new CardLayout(0, 0));

		add(apdati,IMenu.dati);

		add(apambiente,IMenu.ambiente);

		add(apedificio,IMenu.edificio);

		add(apcondotti,IMenu.condotti);
		
		add(apcondottiaria,IMenu.condottiaria);

		add(apcanali,IMenu.canali);

		add(apcaldaie,IMenu.caldaie);

		add(apinputdata,IMenu.inputdata);

		add(apoutputdata,IMenu.outputdata);
		
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
		CardLayout cl=(CardLayout)this.getLayout();
		cl.show(this,IMenu.condottiaria);
		
	}

}
