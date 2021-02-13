package com.luka.KlinikaLjubimci.services;

import java.util.Set;

import com.luka.KlinikaLjubimci.model.Veterinar;

public interface VeterinarService {
	
	
	Veterinar pronadjiPoId(Long id);
	
	Veterinar sacuvaj(Veterinar veterinar);
	
	Veterinar pronadjiPoPrezimenu(String prezime);
	
	Set<Veterinar> nadjiSve();
	
}
