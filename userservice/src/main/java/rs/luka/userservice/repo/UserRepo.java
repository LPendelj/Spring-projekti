package rs.luka.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.luka.userservice.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
