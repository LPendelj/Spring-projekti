package rs.luka.userservice.service;

import java.util.List;

import rs.luka.userservice.model.Role;
import rs.luka.userservice.model.User;

public interface UserService {
	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);
	User getUser(String username);
	List<User> getUsers();
}
