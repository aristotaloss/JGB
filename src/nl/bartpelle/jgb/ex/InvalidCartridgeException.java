package nl.bartpelle.jgb.ex;

public class InvalidCartridgeException extends Exception {

	private static final long serialVersionUID = -5445027394258592373L;
	
	public InvalidCartridgeException() {
		
	}
	
	public InvalidCartridgeException(String message) {
		super(message);
	}

}
