package com.unicig.project;

import javax.swing.JPanel;
import java.awt.CardLayout;

public class APanel_Unicig extends JPanel implements com.unicig.project.IMenu{
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
	
	public void viewDati() {
		CardLayout cl=(CardLayout)this.getLayout();
		cl.show(this,IMenu.dati );
	}
	
	public void viewAmbiente() {
		CardLayout cl=(CardLayout)this.getLayout();
		cl.show(this,IMenu.ambiente );

		
	}
	
	public void viewCondotti() {
		CardLayout cl=(CardLayout)this.getLayout();
		cl.show(this,IMenu.condotti );
	}
	
	public void viewEdificio() {
		CardLayout cl=(CardLayout)this.getLayout();
		cl.show(this,IMenu.edificio );
	}
	
	public void viewCanali() {
		CardLayout cl=(CardLayout)this.getLayout();
		cl.show(this,IMenu.canali );
	}
	
	public void viewCaldaie() {
		CardLayout cl=(CardLayout)this.getLayout();
		cl.show(this,IMenu.caldaie);
	}
	
	public void viewInputdata() {
		CardLayout cl=(CardLayout)this.getLayout();
		cl.show(this,IMenu.inputdata );
	}
	
	public void viewOutputdata() {
		CardLayout cl=(CardLayout)this.getLayout();
		cl.show(this,IMenu.outputdata);
	}
	
	public void viewCondottiaria() {
		CardLayout cl=(CardLayout)this.getLayout();
		cl.show(this,IMenu.condottiaria);
		
	}
	
	/**
	 * Eventi da pannelli sottostanti
	 */
	
	public void panelHidden(String name) {
		
	}

}
