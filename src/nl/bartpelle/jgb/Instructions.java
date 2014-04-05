package nl.bartpelle.jgb;

/**
 * The set of instructions used by the {@link GBZ80} processor.
 * 
 * @author Bart Pelle
 *
 */
public class Instructions {
	
	
	public static final int LD_R_R = 0b0100_0000;
	public static final int CP_R   = 0b1011_1000;
	public static final int CP_N   = 0b1111_1110;

}
