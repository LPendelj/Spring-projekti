package rs.luka.menadzeraplikacija.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Zaposleni implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	
	private String ime;
	private String email;
	private String nazivPozicije;
	private String brTelefona;
	private String urlSlike;
	
	@Column(nullable = false, updatable = false)
	private String sifraZaposlenog;

	
	public Zaposleni(){}
	
	
	public Zaposleni(Long id, String ime, String email, String nazivPozicije, String brTelefona, String urlSlike,
			String sifraZaposlenog) {
		super();
		this.id = id;
		this.ime = ime;
		this.email = email;
		this.nazivPozicije = nazivPozicije;
		this.brTelefona = brTelefona;
		this.urlSlike = urlSlike;
		this.sifraZaposlenog = sifraZaposlenog;
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

	public String getNazivPozicije() {
		return nazivPozicije;
	}

	public void setNazivPozicije(String nazivPozicije) {
		this.nazivPozicije = nazivPozicije;
	}

	public String getBrTelefona() {
		return brTelefona;
	}

	public void setBrTelefona(String brTelefona) {
		this.brTelefona = brTelefona;
	}

	public String getUrlSlike() {
		return urlSlike;
	}

	public void setUrlSlike(String urlSlike) {
		this.urlSlike = urlSlike;
	}

	public String getSifraZaposlenog() {
		return sifraZaposlenog;
	}

	public void setSifraZaposlenog(String sifraZaposlenog) {
		this.sifraZaposlenog = sifraZaposlenog;
	}


	@Override
	public String toString() {
		return "Zaposleni [id=" + id + ", ime=" + ime + ", email=" + email + ", nazivPozicije=" + nazivPozicije
				+ ", brTelefona=" + brTelefona + ", urlSlike=" + urlSlike + ", sifraZaposlenog=" + sifraZaposlenog
				+ "]";
	}
	
	
	
	
	
}
