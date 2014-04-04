package nl.bartpelle.jgb;

/**
 * The set of instructions used by the {@link GBZ80} processor.
 * Note that there is absolutely no speed loss in using constant fields for this.
 * The compiler evaluates the final fields on runtime and replaces the references in the 
 * processor by the constant values (absolute integer values) as if they were written in that way.
 * This is simply a method to keep the code easier to read and to see how instructions are built up.
 * 
 * @author Bart Pelle
 *
 */
public class Instructions {
	
	private static final int REG_A = 0b111;
	private static final int REG_B = 0b000;
	private static final int REG_C = 0b001;
	private static final int REG_D = 0b010;
	private static final int REG_E = 0b011;
	private static final int REG_H = 0b100;
	private static final int REG_L = 0b101;
	
	private static final int LD_R_R = 0b1000000;
	public static final int LD_A_A = LD_R_R | (REG_A << 3) | REG_A; // You never know... we add this in case there's a game which uses this instruction for whatever reason.
	public static final int LD_B_A = LD_R_R | (REG_B << 3) | REG_A;
	public static final int LD_C_A = LD_R_R | (REG_C << 3) | REG_A;
	public static final int LD_D_A = LD_R_R | (REG_D << 3) | REG_A;
	public static final int LD_E_A = LD_R_R | (REG_E << 3) | REG_A;
	public static final int LD_H_A = LD_R_R | (REG_H << 3) | REG_A;
	public static final int LD_L_A = LD_R_R | (REG_L << 3) | REG_A;
	
	private static final int CP_R = 0b10111000;
	public static final int CP_A = CP_R | REG_A;
	public static final int CP_B = CP_R | REG_B;
	public static final int CP_C = CP_R | REG_C;
	public static final int CP_D = CP_R | REG_D;
	public static final int CP_E = CP_R | REG_E;
	public static final int CP_H = CP_R | REG_H;
	public static final int CP_L = CP_R | REG_L;

}
