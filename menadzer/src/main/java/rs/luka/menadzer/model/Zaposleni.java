package rs.luka.menadzer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Zaposleni implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	
	
	private String ime;
	private String email;
	private String posao;
	private String brojTel;
	private String slika;
	
	@Column(nullable = false, updatable = false)
	private String kod;
	
	
	public Zaposleni() {
		super();
	};
	

	public Zaposleni(Long id, String ime, String email, String posao, String brojTel, String slika, String kod) {
		super();
		this.id = id;
		this.ime = ime;
		this.email = email;
		this.posao = posao;
		this.brojTel = brojTel;
		this.slika = slika;
		this.kod = kod;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosao() {
		return posao;
	}

	public void setPosao(String posao) {
		this.posao = posao;
	}

	public String getBrojTel() {
		return brojTel;
	}

	public void setBrojTel(String brojTel) {
		this.brojTel = brojTel;
	}

	public String getSlika() {
		return slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}

	public String getKod() {
		return kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

	@Override
	public String toString() {
		return "Zaposleni [id=" + id + ", ime=" + ime + ", email=" + email + ", posao=" + posao + ", brojTel=" + brojTel
				+ ", slika=" + slika + ", kod=" + kod + "]";
	}
	
	
	
	
	
	
	
	
}
