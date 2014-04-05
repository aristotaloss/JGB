package nl.bartpelle.jgb;

public class Flag {
	
	/**
	 * Zero flag. Set if the result of an operation is zero, cleared if nonzero.
	 */
	public static final int Z = 1 << 7;
	public static final int N = 1 << 6;
	public static final int H = 1 << 5;
	public static final int CY = 1 << 4;

}
