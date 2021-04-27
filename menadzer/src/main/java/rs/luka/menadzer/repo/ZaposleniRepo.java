package rs.luka.menadzer.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.luka.menadzer.model.Zaposleni;

public interface ZaposleniRepo extends JpaRepository<Zaposleni, Long>{
	void obrisiZaposleniId(Long id);
	Optional nadjiZaposleniId(Long id);

}
