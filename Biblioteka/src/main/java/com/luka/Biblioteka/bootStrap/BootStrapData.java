package com.luka.Biblioteka.bootStrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.luka.Biblioteka.domain.Izdavac;
import com.luka.Biblioteka.domain.Knjiga;
import com.luka.Biblioteka.domain.Pisac;
import com.luka.Biblioteka.repository.IzdavacSkladiste;
import com.luka.Biblioteka.repository.KnjigaSkladiste;
import com.luka.Biblioteka.repository.PisacSkladiste;

@Component
public class BootStrapData implements CommandLineRunner {

	private final PisacSkladiste pisacS;
	private final KnjigaSkladiste knjigaS;
	private final IzdavacSkladiste izdavacS;

	public BootStrapData(PisacSkladiste pisacS, KnjigaSkladiste knjigaS, IzdavacSkladiste izdavacS) {
		super();
		this.pisacS = pisacS;
		this.knjigaS = knjigaS;
		this.izdavacS = izdavacS;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Pisac hoking = new Pisac("Stiven", "Hoking");
		Knjiga knjiga1 = new Knjiga("Kratka povest vremena", "677835");
		Pisac andric = new Pisac("Ivo", "Andric");
		Knjiga knjiga2 = new Knjiga("Na Drini cuprija", "4555765");

		
		  Izdavac izdavac1 = new Izdavac(); 
		  izdavac1.setNaziv("Laguna");
		  izdavac1.setDrzava("Srbija");
		  izdavac1.setGrad("Beograd");
		  
		  izdavacS.save(izdavac1);
		  
		  
		  
		  knjiga1.setIzdavac(izdavac1);
		  izdavac1.getKnjige().add(knjiga1);
		 

		hoking.getKnjige().add(knjiga1);
		knjiga1.getPisci().add(hoking);

		knjigaS.save(knjiga1);
		pisacS.save(hoking);

		andric.getKnjige().add(knjiga2);
		knjiga2.getPisci().add(andric);

		pisacS.save(andric);
		knjigaS.save(knjiga2);

		System.out.println("Broj pisaca je " + pisacS.count() + ", a broj knjiga " + knjigaS.count() + ", a broj izdavaca je " + izdavacS.count());

	}

}
