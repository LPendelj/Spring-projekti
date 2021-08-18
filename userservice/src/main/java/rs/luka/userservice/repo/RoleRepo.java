package rs.luka.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.luka.userservice.model.Role;
import rs.luka.userservice.model.User;

public interface RoleRepo extends JpaRepository<User, Long> {
	Role findByName(String name);

	Role save(Role role);
}
