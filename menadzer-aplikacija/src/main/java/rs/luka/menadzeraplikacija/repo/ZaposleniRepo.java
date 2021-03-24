package rs.luka.menadzeraplikacija.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.luka.menadzeraplikacija.model.Zaposleni;

public interface ZaposleniRepo extends JpaRepository<Zaposleni, Long>{
	void obrisiPoId(Long id);
	Optional<Zaposleni> nadjiPoId(Long id);
}
