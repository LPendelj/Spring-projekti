package rs.luka.menadzer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.luka.menadzer.model.Zaposleni;
import rs.luka.menadzer.service.ZaposleniService;

@RestController
@RequestMapping("/zaposleni")
public class ZaposleniController {
	private final ZaposleniService zaposleniService;
	
	
	
	public ZaposleniController(ZaposleniService zaposleniService) {
		super();
		this.zaposleniService = zaposleniService;
	}
	
	@GetMapping
	public ResponseEntity<List<Zaposleni>> getSviZaposleni(){
			List<Zaposleni> zaposleni = zaposleniService.nadjiZaposleni();
			return new ResponseEntity<List<Zaposleni>>(zaposleni, HttpStatus.OK);
	}
	
	@GetMapping("/nadji/{id}")
	public ResponseEntity<Zaposleni> getZaposleniId(@PathVariable("id") Long id){
			Zaposleni zaposleni = zaposleniService.nadjiZaposleniId(id);
			return new ResponseEntity<>(zaposleni, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Zaposleni> dodajZaposleni(@RequestBody Zaposleni zaposleni){
		Zaposleni novZaposleni = zaposleniService.dodajZaposleni(zaposleni);
		return new ResponseEntity<>(novZaposleni, HttpStatus.CREATED);
	}
	
	@PutMapping("/add")
	public ResponseEntity<Zaposleni> izmeniZaposleni(@RequestBody Zaposleni zaposleni){
		Zaposleni izmenjenZaposleni = zaposleniService.izmeniZaposleni(zaposleni);
		return new ResponseEntity<>(izmenjenZaposleni, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> obrisiZaposleni(@PathVariable("id") Long id){
		zaposleniService.obrisiZaposleniId(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
	

}
