package ui.commons;

import javax.swing.JPanel;

import project.Project;
import ui.commons.APAmbiente;
import ui.commons.APDati;
import ui.commons.IMenu;
import unicig10641.commons.APCaldaie;
import java.awt.CardLayout;

public abstract class APanel_Unicig extends JPanel implements IMenu {
	protected Project project;
	protected JPanel apdati;
	protected JPanel apambiente;
	protected JPanel apedificio;
	protected JPanel apcondotti;
	protected JPanel apcanali;
	protected JPanel apcaldaie;
	protected JPanel apinputdata;
	protected JPanel apoutputdata;
	IAmbiente ambiente;
	ICaldaie caldaie;
	/**
	 * Create the panel.
	 */
	public APanel_Unicig() {
	super();
	}
	
	protected void initPanels(){
		setLayout(new CardLayout(0, 0));
//dati=new APDati();
		add(apdati,IMenu.dati);
//ambiente=new APAmbiente();
		add(apambiente,IMenu.ambiente);
//apedificio=new APEdificio();;
		add(apedificio,IMenu.edificio);

		//apcondotti=new APCondotti();
		add(apcondotti,IMenu.condotti);
		//apcanali=new APCanali();
		add(apcanali,IMenu.canali);
		//apcaldaie=new APCaldaie();
		add(apcaldaie,IMenu.caldaie);
		//apinputdata=new APinputdata();
		add(apinputdata,IMenu.inputdata);
		//apoutputdata=new APoutputdata();
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

}
