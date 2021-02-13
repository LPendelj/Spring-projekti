package com.luka.Biblioteka.repository;

import org.springframework.data.repository.CrudRepository;

import com.luka.Biblioteka.domain.Izdavac;

public interface IzdavacSkladiste extends CrudRepository<Izdavac, Long> {

}
