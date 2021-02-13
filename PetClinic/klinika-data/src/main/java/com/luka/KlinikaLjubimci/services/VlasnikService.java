package com.luka.KlinikaLjubimci.services;

import java.util.Set;

import com.luka.KlinikaLjubimci.model.Vlasnik;

public interface VlasnikService {
	
	Vlasnik pronadjiPoId(Long id);
	
	Vlasnik sacuvaj(Vlasnik vlasnik);
	
	Vlasnik pronadjiPoPrezimenu(String prezime);
	
	Set<Vlasnik> nadjiSve();
	
	
}
