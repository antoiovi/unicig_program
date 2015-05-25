package com.antoiovi.unicig.project.commons.condotti;

import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.InputVerifier;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import java.awt.BorderLayout;

import javax.swing.JPopupMenu;

import com.antoiovi.unicig.condotti.Condotto;
import com.antoiovi.unicig.condotti.CondottoBase;
import com.antoiovi.unicig.project.commons.JIF_Rugosita;
import com.antoiovi.unicig.tubi.Tubo;
import com.antoiovi.unicig.tubi.TuboC;
import com.antoiovi.unicig.tubi.TuboFactory;
import com.antoiovi.unicig.tubi.TuboQ;
import com.antoiovi.unicig.tubi.TuboR;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;

import java.awt.Color;

import javax.swing.JSpinner;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.swing.JFormattedTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import java.awt.Font;
import java.awt.CardLayout;
import javax.swing.JTextArea;

public class PCondottoConcentrico extends JPanel implements ActionListener,APCondotto,ICondotto{
	
	/**
	 * Inizzializato a this: per accedere ai metodi dell'interfaccia
	 */
	APCondotto apcondotto;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox comboBoxSezione;
	private JSpinner diam_int;
	private JSpinner latoA_i;
	private JSpinner latoB_i;
	private JSpinner spess_i;
	private JFormattedTextField rug_i;
	private JSpinner rester_i;
	private JSpinner spCoefflimest;
	String strfloat = "%1.2f";
	Tubo tubo;
	TuboFactory factoryTubo;
/* 
 * Parametri per il tubo
 * 
 */
	String forma;
	double sviluppo;// Lunghezza totale
	double diametro;
	double spessore;
	double latoa;
	double latob;
	double rug;
	double rter;
	/* 
	 * Parametri per il condotto
	 * 
	 */
	double altezza; // deve essere minore di lunghezza totale
	double coefflimest;
	
	
	/**
	 * 
	 */
	private JSpinner spSviluppo;
	AVerifier verifier;
	private JTextField txtTitolo;
	/**
	 * Lista di APconodtti collegati a cui fare seguire alcune azioni :
	 * 		1-quando cambio la forma di questa entità,allora cambia la forma di tutti gli	oggetti du questa lista
	 * 
	 */
	List<APCondotto> apcondotti;
	private JSpinner spPerdite;
	// Nome utilizzato nel CardLayout
	public final String name_comboboxselecttipo="name_comboboxselecttipo";
	// Nome utilizzato nel CardLayout
	public final String  name_textselectedtipo= "name_textselectedtipo";
	
	
	/**
	 * Create the panel.
	 */
	public PCondottoConcentrico() {
		DecimalFormatSymbols dot_decimal = new DecimalFormatSymbols();
		dot_decimal.setDecimalSeparator('.');
		dot_decimal.setGroupingSeparator(',');

		Locale.setDefault(Locale.US);
		setLayout(new BorderLayout(0, 0));
		verifier = new AVerifier();
		JPanel panel_1 = new JPanel();

		this.add(panel_1);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(49dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("77px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(37dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(67dlu;default):grow"),},
			new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		/**
		 * Forma di defoult
		 */
		forma =APCondotto.CIRCOLARE;
		/**
		 * Sceglie la forma della sezione
		 */
		comboBoxSezione = new JComboBox();
		comboBoxSezione.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBoxSezione.setModel(new DefaultComboBoxModel(new String[] {
				APCondotto.CIRCOLARE,APCondotto.RETTANGOLARE, APCondotto.QUADRATO }));
		comboBoxSezione.setSelectedIndex(0);
		comboBoxSezione.setActionCommand("Sezione");
		comboBoxSezione.addActionListener(this);
		/**
		 * Titolo
		 */
		txtTitolo = new JTextField();
		txtTitolo.setEditable(false);
		txtTitolo.setText("Titolo");
		panel_1.add(txtTitolo, "3, 1, 3, 1, fill, default");
		txtTitolo.setColumns(10);
		
		/**
		 * SEZIONE
		 */
		
		lblInterno = new JLabel("INTERNO");
		panel_1.add(lblInterno, "3, 3");
		
		lblEsterno = new JLabel("ESTERNO");
		panel_1.add(lblEsterno, "5, 3");
		
		lblNewLabel = new JLabel("Forma sezione");
		panel_1.add(lblNewLabel, "1, 5, left, default");
		panel_1.add(comboBoxSezione, "3, 5, 3, 1, fill, fill");
			/**
			 * DIAMETRO: sezione circolare
			 */
				diam_int = new JSpinner();
				diam_int.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
						//CreaTubo();
					}
				});
				
				lblNewLabel_1 = new JLabel("Diametro [mm]");
				panel_1.add(lblNewLabel_1, "1, 7");
				diam_int.setModel(new SpinnerNumberModel(100.0, 100.0,600.0, 10.0));
				
				panel_1.add(diam_int, "3, 7, fill, fill");
				diam_int.setInputVerifier(verifier);
		/**
		 * LATO A E LATO B SEZIONE RETTANGOLARE
		 * LATO A QUADRATO
		 */
				latoA_i = new JSpinner();
				latoA_i.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
						//CreaTubo();
					}
				});
				
				diam_est = new JSpinner();
				diam_est.setEnabled(true);
				panel_1.add(diam_est, "5, 7, default, top");
				
				msgDiam = new JLabel("-");
				panel_1.add(msgDiam, "7, 7, default, center");
				
				lblNewLabel_2 = new JLabel("Lato A [mm]");
				panel_1.add(lblNewLabel_2, "1, 9");
				latoA_i.setModel(new SpinnerNumberModel(150.0,150.0,600.0, 10.0));
				panel_1.add(latoA_i, "3, 9, fill, top");
		
				latoB_i = new JSpinner();
				latoB_i.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
					//	CreaTubo();
					}
				});
				
				latoA_e = new JSpinner();
				latoA_e.setEnabled(false);
				panel_1.add(latoA_e, "5, 9");
				
				msgLatoA = new JLabel("-");
				panel_1.add(msgLatoA, "7, 9");
				
				lblNewLabel_3 = new JLabel("Lato B [mm]");
				panel_1.add(lblNewLabel_3, "1, 11");
				latoB_i.setModel(new SpinnerNumberModel(150.0,150.0,600.0, 10.0));
				panel_1.add(latoB_i, "3, 11, fill, fill");
		/**
		 * SPESSORE
		 */
				
				latoB_e = new JSpinner();
				latoB_e.setEnabled(false);
				panel_1.add(latoB_e, "5, 11, fill, top");
				
				msgLatoB = new JLabel("-");
				panel_1.add(msgLatoB, "7, 11");
				
				lblNewLabel_4 = new JLabel("Spessore [mm]");
				panel_1.add(lblNewLabel_4, "1, 13");
				spess_i = new JSpinner();
				spess_i.setModel(new SpinnerNumberModel(0.0,0.0,50.0, 1.0));
				panel_1.add(spess_i, "3, 13, fill, fill");
		/**
		 * RUGOSITA'
		 */
				
				spess_e = new JSpinner();
				panel_1.add(spess_e, "5, 13");
				
				lblNewLabel_5 = new JLabel("Rugosit\u00E0");
				panel_1.add(lblNewLabel_5, "1, 15, left, default");
				rug_i = new JFormattedTextField();
				rug_i.setToolTipText("Click dx per help\r\n");
				panel_1.add(rug_i, "3, 15, right, fill");
				rug_i.setColumns(10);
				
				rug_i.setInputVerifier(verifier);
				
						JPopupMenu popupMenu = new JPopupMenu();
						addPopup(rug_i, popupMenu);
						
								JMenuItem mntmHelprugosita = new JMenuItem("HelpRugosita");
								mntmHelprugosita.addActionListener(this);
								popupMenu.add(mntmHelprugosita);
		/**
		 * RESISTENZA TERMICA PARETE
		 */
				rester_i = new JSpinner();
				rester_i.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent arg0) {
				//		CreaTubo();
					}
				});
				
				rug_e = new JFormattedTextField();
				rug_e.setToolTipText("Click dx per help\r\n");
				rug_e.setColumns(10);
				panel_1.add(rug_e, "5, 15, fill, default");
				
				lblResistenzaTermica = new JLabel("Resistenza termica");
				panel_1.add(lblResistenzaTermica, "1, 17");
				rester_i .setModel(new SpinnerNumberModel(0, 0, 1.0, 0.01));
				panel_1.add(rester_i, "3, 17, fill, top");
				
				JPopupMenu popupMenu_1 = new JPopupMenu();
				addPopup(rester_i, popupMenu_1);
				
				JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
				popupMenu_1.add(mntmNewMenuItem);
		
				/**
				 * 	SVILUPPO (Lunghezza massima)				
				 */
		
		rester_e = new JSpinner();
		panel_1.add(rester_e, "5, 17");
		
		lblSviluppo = new JLabel("Sviluppo [m]");
		panel_1.add(lblSviluppo, "1, 19");
		spSviluppo = new JSpinner();
		spSviluppo .setModel(new SpinnerNumberModel(1.0, 1.0, 5.0, 0.1));
		JSpinner.NumberEditor ne_spSviluppo=new JSpinner.NumberEditor(spSviluppo , "##0.#");
		//DecimalFormat df=ne_spSviluppo.getFormat();
		spSviluppo .setEditor(ne_spSviluppo);
		
		panel_1.add(spSviluppo, "3, 19, 3, 1, fill, fill");
		/**
		 * ALTEZZA
		 */
		
		lblAltezzam = new JLabel("Altezza [m]");
		panel_1.add(lblAltezzam, "1, 21");
		JSpinner spAltezza = new JSpinner();
		spAltezza.setModel(new SpinnerNumberModel(1.0, 1.0, 5.0, 0.1));
		JSpinner.NumberEditor ne_spAltezza=new JSpinner.NumberEditor(spAltezza , "##0.#");
		panel_1.add(spAltezza, "3, 21, 3, 1, fill, default");
		/**
		 * Coefficiente liminare esterno
		 */
		
		lblCoefficienteLiminareEsterno = new JLabel("Coefficiente liminare esterno");
		panel_1.add(lblCoefficienteLiminareEsterno, "1, 23");
		spCoefflimest = new JSpinner();
		spCoefflimest.setModel(new SpinnerNumberModel(8.0, 8.0, 23.0, 0.5));
		JSpinner.NumberEditor ne_spCoefflimest=new JSpinner.NumberEditor(spCoefflimest , "##0.#");
		panel_1.add(spCoefflimest, "3, 23, 3, 1, fill, default");
		/**
		 * PERDITE LOCALIZZATE
		 */
		
		lblPerditeLocalizzate = new JLabel("Perdite localizzate");
		panel_1.add(lblPerditeLocalizzate, "1, 25");
		spPerdite = new JSpinner();
		spPerdite.setModel(new SpinnerNumberModel(new Double(0), null, null, new Double(1)));
		panel_1.add(spPerdite, "3, 25, 3, 1");
		
		lblTemperaturaEsternac = new JLabel("Temperatura esterna [\u00B0C]");
		panel_1.add(lblTemperaturaEsternac, "1, 27, left, default");
		
		temp_aria_est = new JTextField();
		panel_1.add(temp_aria_est, "3, 27, 3, 1, fill, default");
		temp_aria_est.setColumns(10);
		
		out = new JTextArea();
		panel_1.add(out, "1, 29, 7, 1, fill, fill");
		/**
		 * INIZZIALIZZO una lista di condotti a cui collegare il compoinente: 
		 */
		apcondotti=new ArrayList<APCondotto>();
		/**
		 * Default imposta la forma circolare
		 */
		circolare();
		//tubo = TuboFactory.getInstace().TuboC(100,105, 100, 0.001, 1);
	//this.setTubo(tubo);
	
		/**
		 * Puntatore per acceder all'interfaccia APCondotto più agevolmente
		 */
		apcondotto=this;	
		
	}
	/***
	 ***	FINE COSTRUTTORE
	 ****/

	/*************************************************************
	 * AGGIUNGE IL POPUPMENU
	 * @param component
	 * @param popup
	 */
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
/************************************************
 *  	ACTION PERFORMED
 *****************************************/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String COMMAND = arg0.getActionCommand();
		if (COMMAND.equals("HelpRugosita")) {
			JIF_Rugosita j = new JIF_Rugosita();
			j.setVisible(true);
			if (j.getValue().equals("ok")) {
				this.rug_i.setText(String.valueOf(j.getDoblevalue()));
			}
			j.dispose();
		} else if (COMMAND.equals("Sezione")) {
			forma = (String) comboBoxSezione.getModel().getSelectedItem();
			if (forma.equals("Circolare"))
				circolare();
			else if (forma.equals("Rettangolare"))
				rettangolare();
			else if (forma.equals("Quadrato"))
				quadrato();
			//CreaTubo();
		}

	}
/**
 *  INTERFACCIA APCondotto
 */
	
	
	@Override
	public void circolare() {
		List<APCondotto> apcondotti_temp=new ArrayList<APCondotto>(apcondotti);
		circolare(apcondotti_temp);
	}

	@Override
	public void circolare(List<APCondotto> apcondotti_temp) {
		this.diam_int.setEnabled(true);
		this.latoA_i.setEnabled(false);
		this.latoB_i.setEnabled(false);
		this.comboBoxSezione.setSelectedIndex(0);
		apcondotti_temp.remove(this);
		Iterator i=apcondotti_temp.iterator();
		if(i.hasNext()){
			APCondotto apc=(APCondotto )i.next();
			apc.circolare(apcondotti_temp);
		}
	}

	@Override
	public void rettangolare() {
		List<APCondotto> apcondotti_temp=new ArrayList<APCondotto>(apcondotti);
		rettangolare(apcondotti_temp);
	}
	@Override
	public void rettangolare(List<APCondotto> apcondotti_temp) {
		this.diam_int.setEnabled(false);
		this.latoA_i.setEnabled(true);
		this.latoB_i.setEnabled(true);
		this.comboBoxSezione.setSelectedIndex(1);
		apcondotti_temp.remove(this);
		Iterator i=apcondotti_temp.iterator();
		if(i.hasNext()){
			APCondotto apc=(APCondotto )i.next();
			apc.rettangolare(apcondotti_temp);
		}
	}

	@Override
	public void quadrato() {
		List<APCondotto> apcondotti_temp=new ArrayList<APCondotto>(apcondotti);
		quadrato(apcondotti_temp);
	}
	@Override
	public void quadrato(List<APCondotto> apcondotti_temp) {
		this.diam_int.setEnabled(false);
		this.latoA_i.setEnabled(true);
		this.latoB_i.setEnabled(false);
		this.comboBoxSezione.setSelectedIndex(2);
		apcondotti_temp.remove(this);
		Iterator i=apcondotti_temp.iterator();
		if(i.hasNext()){
			APCondotto apc=(APCondotto )i.next();
			apc.quadrato(apcondotti_temp);
		}
	}
	
	private void setValues() {
		rug_i.setText(String.format("%1.6f", rug));
		
	}

	
	/**
	 * vERIFICA EI DATI E INIZZIALIZZA LE VARIABILI
	 * @return
	 */
private boolean verifica(){
	try{
		rter =(Double)rester_i.getModel().getValue();
		rug = Double.parseDouble(rug_i.getText());
		diametro =(Double)diam_int.getModel().getValue()/100;
		latoa = (Double)latoA_i.getModel().getValue()/100;
		latob = (Double)latoB_i.getModel().getValue()/100;
		spessore = (Double)spess_i.getModel().getValue();
		spessore/=1000;
		sviluppo=(Double)spSviluppo.getModel().getValue();
		if(forma.equals("Circolare")){
			tubo = factoryTubo.TuboC(diametro, diametro+2*spessore, sviluppo, rter, rug);
		}else if(forma.equals("Rettangolare")){
			tubo=factoryTubo.TuboR(latob, latob,spessore, sviluppo, rter, rug);
		}else if(forma.equals("Quadrato")){
			tubo=factoryTubo.TuboQ(latoa, spessore, sviluppo, rter, rug);
		}

		/**
		 *  DA FARE : INIZZIALIZZARE ALTEZZA E COEFFICIENTE LIMINARE ESTERNO
		 */
		
return true;
}catch(Exception e){
	return false;
}
}

	class AVerifier extends InputVerifier {
		public boolean shouldYieldFocus(JComponent input) {
			boolean inputOK = verify(input);
			// makeItPretty(input);
			if (inputOK) {
				input.setBackground(Color.white);
				//CreaTubo();
				return false;
			} else {
				input.setBackground(Color.red);
				Toolkit.getDefaultToolkit().beep();
				return true;
			}
		}
		
		@Override
		public boolean verify(JComponent input) {
			// if (input == textResterm) {
			/*
			 * 
			 * try { rter = Double.parseDouble(textResterm.getText()); return
			 * true; } catch (Exception e) { // textResterm.setText("Errore");
			 * return false; } } else
			 */

			if (input == rug_i) {
				try {
					rug = Double.parseDouble(rug_i.getText());
					// textRugosita.setText(String.format("%1.6f", rug));
					return true;
				} catch (Exception e) {
					// textRugosita.setText("Errore");
					return false;
				}
			}/* else if (input == textDiametro) {
				try {
					diametro = Double.parseDouble(textDiametro.getText());
					// txtLungh.setText(String.format(strfloat, sviluppo));
					return true;
				} catch (Exception e) {
					return false;
				}
			} else if (input == textLatoA) {
				try {
					latoa = Double.parseDouble(textLatoA.getText());
					// txtLungh.setText(String.format(strfloat, sviluppo));
					return true;
				} catch (Exception e) {
					return false;
				}
			} else if (input == textLatoB) {
				try {
					latob = Double.parseDouble(textLatoB.getText());
					// txtLungh.setText(String.format(strfloat, sviluppo));
					return true;
				} catch (Exception e) {
					return false;
				}
			} else if (input == textSpessore) {
				try {
					spessore = Double.parseDouble(textSpessore.getText());
					spessore/=1000;
					// txtLungh.setText(String.format(strfloat, sviluppo));
					return true;
				} catch (Exception e) {
					return false;
				}
				*/
			
			return true;
		}			
		
				
			
	}// Fine classe inputVerifier
/**
 * IMPLEMENTAZIONE METODI INTERFACCIA APCondotto
 */
	/**
	 * 
	 * @param arg0
	 */
	@Override
	public void setTitolo(String arg0) {
		txtTitolo.setText(arg0);
	}
	@Override
	public void setTipo(String arg0){
		
	}
	
	
	
	 
	

	@Override
	public void setAPCondottiRelated(List<APCondotto> apcondotti) {
		this.apcondotti=apcondotti;		
	}

	@Override
	public void addAPCondottoRelated(APCondotto apcondotto) {
		this.apcondotti.add(apcondotto);
		
	}

	@Override
	public Condotto getCondotto() {
		if(verifica()==false)
			return null;
		return new CondottoBase( tubo,coefflimest,altezza);
	}
	
	/**
	 * Pannello che contiene i due componenti:
	 *  1 - JComboBox comboBoxTipo;
	 *   2- JTextField txtSelectedTipo;
	 *   Esso ha un Layout di tipo CardLayout;  Viene utilizzato per impostare se visibile il campo testo
	 *   o il campo combo box; Se viene visualizzato il campo testo si mette il testo desiderato 
	 *   (di solito Semplice o Concentrico) se viene visualizzato il combo si estrae il combo e si definiscono
	 *   nella classe che lo utilizza le azioni specifiche
	 *   ESEMPIO :
	 *  	 APanelCond panel_int = new APanelCond();
			condotto_int=panel_int;
			add(panel_int);
			panel_int.getTxtSelectedTipo().setText("Concentrico");
			CardLayout cl=(CardLayout)panel_int.getPanelSelectTipo().getLayout();
			cl.first(panel_int.getPanelSelectTipo());// mostra il comboBoxTipo
			cl.last(panel_int.getPanelSelectTipo());// mostra il  txtSelectedTipo
	 * @return
	 */
	public JPanel getPanelSelectTipo() {
		return null;
	}
	
	
	
	public JTextField getTxtSelectedTipo() {
		return null;
	}
	
	/******************************************************************************************************
	 * Utilizzo della proprieta DatiCondotto per scambiare dati con l'esterno
	 ********************************************************************************************************/
	
	DatiCondotto daticondotto;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblResistenzaTermica;
	private JLabel lblSviluppo;
	private JLabel lblAltezzam;
	private JLabel lblCoefficienteLiminareEsterno;
	private JLabel lblPerditeLocalizzate;
	private JLabel lblTemperaturaEsternac;
	private JTextArea out;
	private JTextField temp_aria_est;
	private JSpinner diam_est;
	private JSpinner latoA_e;
	private JSpinner latoB_e;
	private JSpinner spess_e;
	private JFormattedTextField rug_e;
	private JSpinner rester_e;
	private JLabel lblInterno;
	private JLabel lblEsterno;
	private JLabel msgDiam;
	private JLabel msgLatoA;
	private JLabel msgLatoB;
	
	
	
	
/**
 * IMPLEMENTAZIONE INTERFACCIA ICondotto
 * 
 */
	@Override
	public String getSezione() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getDiam() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getLatoa() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getLatob() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getAltezza() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getLunghezza() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPerditeloc() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getRterm() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getCoefLimEst() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getSpessore() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getRugosita() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
public void fixSezione(String sezione){

	if(sezione.equals(APCondotto.CIRCOLARE)){
			
		comboBoxSezione.setSelectedIndex(0);
		comboBoxSezione.setEnabled(false);
			diam_int.setEnabled(true);
			latoA_i.setEnabled(false);
			latoB_i.setEnabled(false);

		
	}else if(sezione.equals(APCondotto.RETTANGOLARE)){
		comboBoxSezione.setSelectedIndex(1);
		comboBoxSezione.setEnabled(false);
		diam_int.setEnabled(false);
		latoA_i.setEnabled(true);
		latoB_i.setEnabled(true);
	
	}else if(sezione.equals(APCondotto.QUADRATO)){
		comboBoxSezione.setSelectedIndex(2);
		comboBoxSezione.setEnabled(false);
		diam_int.setEnabled(false);
		latoA_i.setEnabled(true);
		latoB_i.setEnabled(false);
		
	}
	}

	
	
}// FINE CLASSE PANEL TUBO
