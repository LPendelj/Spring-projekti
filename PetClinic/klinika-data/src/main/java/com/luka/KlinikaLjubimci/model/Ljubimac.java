package com.luka.KlinikaLjubimci.model;

import java.time.LocalDate;

public class Ljubimac extends BazicniEntitet{
	private Vrsta vrsta;
	private Vlasnik vlasnik;
	private LocalDate datumRodjenja;
	public Vrsta getVrsta() {
		return vrsta;
	}
	public void setVrsta(Vrsta vrsta) {
		this.vrsta = vrsta;
	}
	public Vlasnik getVlasnik() {
		return vlasnik;
	}
	public void setVlasnik(Vlasnik vlasnik) {
		this.vlasnik = vlasnik;
	}
	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	
	
	
}
