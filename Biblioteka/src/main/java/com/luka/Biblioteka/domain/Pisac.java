package com.luka.Biblioteka.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Pisac {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
		
	private String ime;
	private String prezime;
	
	
	@ManyToMany(mappedBy = "pisci", cascade = {CascadeType.ALL})
	private Set<Knjiga> knjige = new HashSet<Knjiga>();
		
		public Pisac () {
			
		}
		
		

		public Pisac(String ime, String prezime) {
			super();
			this.ime = ime;
			this.prezime = prezime;
		}



		public String getIme() {
			return ime;
		}

		public void setIme(String ime) {
			this.ime = ime;
		}

		public String getPrezime() {
			return prezime;
		}

		public void setPrezime(String prezime) {
			this.prezime = prezime;
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
			Pisac other = (Pisac) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}



		@Override
		public String toString() {
			return "Pisac [id=" + id + ",\nime=" + ime + ", prezime=" + prezime + ", knjige=" + knjige + "]";
		};
		
		
		
}
