package nl.bartpelle.jgb.enums;

public enum CGBCompatibility {
	
	/**
	 * The game is not compatible with the Color GameBoy.
	 */
	INCOMPATIBLE(00), 
	
	/**
	 * The game is able to handle features from the Color GameBoy.
	 */
	COMPATIBLE(80), 
	
	/**
	 * The game is <i>only</i> able to run properly on a Color GameBoy.
	 */
	EXCLUSIVE(0xC0);
	
	public int code;
	
	private CGBCompatibility(int code) {
		this.code = code;
	}
	
	public static CGBCompatibility forCode(int code) {
		for (CGBCompatibility compat : values()) {
			if (compat.code == code) {
				return compat;
			}
		}
		
		return null;
	}
	
}