package rs.luka.menadzer.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import rs.luka.menadzer.model.Zaposleni;

public interface ZaposleniRepo extends JpaRepository<Zaposleni, Long>{
	void deleteZaposleniById(Long id);
	Zaposleni findZaposleniById(Long id);

}
