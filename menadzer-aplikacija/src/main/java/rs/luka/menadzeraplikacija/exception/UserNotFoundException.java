package rs.luka.menadzeraplikacija.exception;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String poruka) {
		super(poruka);
	}
}
