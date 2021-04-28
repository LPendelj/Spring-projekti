package rs.luka.menadzer.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.luka.menadzer.model.Zaposleni;
import rs.luka.menadzer.repo.ZaposleniRepo;

@Component
public class ZaposleniService {
	private final ZaposleniRepo zaposleniRepo;
	
	
	
	@Autowired
	public ZaposleniService(ZaposleniRepo zaposleniRepo) {
		this.zaposleniRepo=zaposleniRepo;
	}
	
	public Zaposleni dodajZaposleni(Zaposleni zaposleni) {
		zaposleni.setKod(UUID.randomUUID().toString());
		return zaposleniRepo.save(zaposleni);
		
	}
	
	public List<Zaposleni> nadjiZaposleni(){
		return zaposleniRepo.findAll();
	}
	
	public Zaposleni izmeniZaposleni(Zaposleni zaposleni) {
		return zaposleniRepo.save(zaposleni);
	}
	
	public void  obrisiZaposleniId(Long id) {
		zaposleniRepo.deleteZaposleniById(id);
		
	}
	
	public Zaposleni nadjiZaposleniId(Long id) {
		return zaposleniRepo.findZaposleniById(id);
	}
}
