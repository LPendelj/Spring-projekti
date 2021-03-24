package rs.luka.menadzeraplikacija.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import rs.luka.menadzeraplikacija.exception.UserNotFoundException;
import rs.luka.menadzeraplikacija.model.Zaposleni;
import rs.luka.menadzeraplikacija.repo.ZaposleniRepo;

public class ZaposleniService {
	private final ZaposleniRepo zaposleniRepo;
	
	@Autowired
	public ZaposleniService(ZaposleniRepo zaposleniRepo) {
		this.zaposleniRepo = zaposleniRepo;
		
	}
	
	public Zaposleni dodajZaposlenog(Zaposleni zaposleni) {
		zaposleni.setSifraZaposlenog(UUID.randomUUID().toString());
		return zaposleniRepo.save(zaposleni);
	}
	
	public List<Zaposleni> nadjiSve(){
		return zaposleniRepo.findAll();
	}
	
	public Zaposleni izmeniZaposlenog(Zaposleni zaposleni) {
		return zaposleniRepo.save(zaposleni);
	}
	
	public void obrisiZaposlenog(Long id) {
		zaposleniRepo.obrisiPoId(id);
	}
	
	public Zaposleni nadjiPoId(Long id) {
		return  (Zaposleni) zaposleniRepo.nadjiPoId(id).orElseThrow(() -> new UserNotFoundException("blabal"));
	}
}
