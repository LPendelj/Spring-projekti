package com.luka.Biblioteka.repository;

import org.springframework.data.repository.CrudRepository;

import com.luka.Biblioteka.domain.Knjiga;

public interface KnjigaSkladiste extends CrudRepository<Knjiga, Long> {
	

}
