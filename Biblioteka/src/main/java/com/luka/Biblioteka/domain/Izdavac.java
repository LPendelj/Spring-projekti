package com.luka.Biblioteka.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Izdavac {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String naziv;
	private String adresa;
	private String grad;
	private String drzava;
	private String postanskiKod;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name= "izdavac_id")
	private Set<Knjiga> knjige = new HashSet<>();

	
	
	
	public Izdavac() {
	}

	public Izdavac(Long id, String naziv, String adresa, String grad, String drzava, String postanskiKod) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.grad = grad;
		this.drzava = drzava;
		this.postanskiKod = postanskiKod;
	}
	
	
	
	

	public Set<Knjiga> getKnjige() {
		return knjige;
	}

	public void setKnjige(Set<Knjiga> knjige) {
		this.knjige = knjige;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getPostanskiKod() {
		return postanskiKod;
	}

	public void setPostanskiKod(String postanskiKod) {
		this.postanskiKod = postanskiKod;
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
		Izdavac other = (Izdavac) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Izdavac [id=" + id + ", naziv=" + naziv + ", adresa=" + adresa + ", grad=" + grad + ", drzava=" + drzava
				+ ", postanskiKod=" + postanskiKod + ", knjige=" + knjige + "]";
	}
	
	
	
	
	
	
	
	
}
