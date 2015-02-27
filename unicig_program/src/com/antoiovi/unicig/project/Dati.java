package com.antoiovi.unicig.project;

import java.io.Serializable;

public class Dati implements Serializable{
private String denominazione;
private String descrizione;


public String getDenominazione() {
	return denominazione;
}
public void setDenominazione(String denominazione) {
	this.denominazione = denominazione;
}
public String getDescrizione() {
	return descrizione;
}
public void setDescrizione(String descrizione) {
	this.descrizione = descrizione;
}

}
