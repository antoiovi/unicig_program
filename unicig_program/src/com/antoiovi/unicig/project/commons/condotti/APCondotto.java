package com.antoiovi.unicig.project.commons.condotti;

import java.util.List;

import com.antoiovi.unicig.condotti.Condotto;

public interface APCondotto {
public void setTitolo(String arg0);
/**
 * Utilizzato per mettere condotto sempliec, oppure interno o esterno
 * @param arg0
 */
public void setTipo(String arg0);
/**
 * Imposta una lista di condotti collegati a cui fare seguire le stesse modifiche di 
 * 	- tipo sezione
 * @param apcondotti
 */
public void setAPCondottiRealted(List<APCondotto> apcondotti);
public void addAPCondottoRealted(APCondotto apcondotto);


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
}
