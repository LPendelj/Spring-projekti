package rs.luka.userservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import rs.luka.userservice.model.Role;
import rs.luka.userservice.model.User;
import rs.luka.userservice.repo.RoleRepo;
import rs.luka.userservice.repo.UserRepo;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

	private final UserRepo userRepo = null;
	private final RoleRepo roleRepo = null;
	Logger log = null;
	
	@Override
	public User saveUser(User user) {
		
		log.info("Saving new user");
		return userRepo.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		
		log.info("Saving new role");
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
			
		log.info("Adding new role to user");

			User user = userRepo.findByUsername(username);
			Role role = roleRepo.findByName(roleName);
			user.getRoles().add(role);
	}

	@Override
	public User getUser(String username) {
		
		log.info("Fetching an user");

		// TODO Auto-generated method stub
		return userRepo.findByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		
		log.info("Fetching all users");
		return userRepo.findAll();
	}

}
