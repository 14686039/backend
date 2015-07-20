package jxt.exception;

public class PermissionException extends Exception {

	private static final long serialVersionUID = 1L;

	public PermissionException() {
		
	}
	
	public PermissionException(String exception) {
		super(exception);
	}
	
}
