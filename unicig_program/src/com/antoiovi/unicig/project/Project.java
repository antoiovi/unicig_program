package com.antoiovi.unicig.project;

public class Project {
public static final String[] sezioni=new String[] {"Circolare", "Rettangolare", "Quadrato"};
public static final int CIRCOLARE=0;
public static final int RETTANGOLARE=1;
public static final int QUADRATA=2;

	/*Dati */
	  String denominazione="";
	  String descrizione="";
	 
	  /* Ambiente */
  	String localita="";
	String localita_piu_vicina="";
	double temp_esterna_C;
	double diff_temp_psup=0.0;
	int dal_piano=1;
	double quota_slm=0.0;
	
	/* Edificio */
	  int npiani=3;
	  int numtratti=1;
	  int maxNpiani=10;
	  String sezioneCanna=sezioni[QUADRATA];
	  double perdlocCam=0.1;

	public double getPerdlocCam() {
		return perdlocCam;
	}

	public void setPerdlocCam(double perdlocCam) {
		this.perdlocCam = perdlocCam;
	}

	public Project() {
		super();
		
		
		
	}

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

	public String getLocalita() {
		return localita;
	}

	public void setLocalita(String localita) {
		this.localita = localita;
	}

	public String getLocalita_piu_vicina() {
		return localita_piu_vicina;
	}

	public void setLocalita_piu_vicina(String localita_piu_vicina) {
		this.localita_piu_vicina = localita_piu_vicina;
	}

	public double getTemp_esterna_C() {
		return temp_esterna_C;
	}

	public void setTemp_esterna_C(double temp_esterna_C) {
		this.temp_esterna_C = temp_esterna_C;
	}

	public double getDiff_temp_psup() {
		return diff_temp_psup;
	}

	public void setDiff_temp_psup(double diff_temp_psup) {
		this.diff_temp_psup = diff_temp_psup;
	}

	public int getDal_piano() {
		return dal_piano;
	}

	public void setDal_piano(int dal_piano) {
		this.dal_piano = dal_piano;
	}

	public double getQuota_slm() {
		return quota_slm;
	}

	public void setQuota_slm(double quota_slm) {
		this.quota_slm = quota_slm;
	}

	public int getNpiani() {
		return npiani;
	}

	public void setNpiani(int npiani) {
		this.npiani = npiani;
	}

	public int getMaxNpiani() {
		return maxNpiani;
	}

	public void setMaxNpiani(int maxNpiani) {
		this.maxNpiani = maxNpiani;
	}

	public String getSezioneCanna() {
		return sezioneCanna;
	}

	public void setSezioneCanna(String sezioneCanna) {
		this.sezioneCanna = sezioneCanna;
	}

	public int getNumtratti() {
		return numtratti;
	}

	public void setNumtratti(int numtratti) {
		this.numtratti = numtratti;
	}

	
	
	
	
 
}
