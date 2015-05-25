package com.antoiovi.unicig.project.commons.condotti;

import java.util.List;

import javax.swing.JComboBox;

import com.antoiovi.unicig.condotti.Condotto;

public interface APCondotto {
	
	/**
	 * Action commands
	 */
	public final String SEZIONE="Sezione";// command sezione
	public final String TIPO="Tipo";// command sezione

	/**
 * SEZIONE
 */


public final String CIRCOLARE="Circolare";
public final String RETTANGOLARE="Rettangolare";
public final String QUADRATO="Quadrato";
/**
 * TIPO
 */
public final String SINGOLO="Singolo";
public final String CONCENTRICO =  "Concentrico";

/**
 * Imposta il testo della prima riga
 * @param arg0
 */
public void setTitolo(String arg0);
/**
 * Utilizzato per mettere condotto sempliec, oppure interno o esterno
 * imposta solo il testo della cella
 * @param arg0
 */
public void setTipo(String arg0);
/**
 * Imposta una lista di condotti collegati a cui fare seguire le stesse modifiche di 
 * 	- tipo sezione
 * @param apcondotti
 */
public void setAPCondottiRelated(List<APCondotto> apcondotti);
public void addAPCondottoRelated(APCondotto apcondotto);


/**
 * Abilita i campi in funzione del tipo di sezione
 */
public void quadrato();
public void quadrato(List<APCondotto> apcondotti_temp);
public void rettangolare();
public void rettangolare(List<APCondotto> apcondotti_temp);
public void circolare();
public void circolare(List<APCondotto> apcondotti_temp);
public Condotto getCondotto();

/**
 * Fissa il combo box sezione
 */
public void fixSezione(String sezione);


}
