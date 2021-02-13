package com.luka.KlinikaLjubimci.services;

import java.util.Set;

import com.luka.KlinikaLjubimci.model.Ljubimac;

public interface LjubimacService {
	
	Ljubimac pronadjiPoId(Long id);
	
	Ljubimac sacuvaj(Ljubimac ljubimac);
	
	
	Set<Ljubimac> nadjiSve();
	
}
