package com.luka.Biblioteka.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Knjiga {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	private String naslov;
	private String isbn;
	
	@ManyToOne
	private Izdavac izdavac;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="pisac_knjiga", joinColumns = @JoinColumn(name="knjiga_id"), inverseJoinColumns = @JoinColumn(name="pisac_id"))
	private Set<Pisac> pisci = new HashSet<Pisac>();
	
	public Knjiga() {
		
	}

	
	public Knjiga(String naslov, String isbn) {
		super();
		this.naslov = naslov;
		this.isbn = isbn;
		
	}

	

	public Izdavac getIzdavac() {
		return izdavac;
	}


	public void setIzdavac(Izdavac izdavac) {
		this.izdavac = izdavac;
	}


	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<Pisac> getPisci() {
		return pisci;
	}

	public void setPisci(Set<Pisac> pisci) {
		this.pisci = pisci;
	}
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Knjiga other = (Knjiga) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Knjiga [id=" + id + ",\nnaslov=" + naslov + ", isbn=" + isbn + ", pisci=" + pisci + "]";
	}

	
	
	
	
}
