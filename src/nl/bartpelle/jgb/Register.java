package nl.bartpelle.jgb;

public class Register {
	
	/**
	 * Accumulator register, mainly used for results from arithmetic/logical operations.
	 */
	public static final int A = 0b111;
	
	/**
	 * Auxiliary register, high byte of combined 16-bit register 'BC'.
	 */
	public static final int B = 0b000;
	
	/**
	 * Auxiliary register, low byte of combined 16-bit register 'BC'.
	 */
	public static final int C = 0b001;
	
	/**
	 * Auxiliary register, high byte of combined 16-bit register 'DE'.
	 */
	public static final int D = 0b010;
	
	/**
	 * Auxiliary register, low byte of combined 16-bit register 'DE'.
	 */
	public static final int E = 0b011;
	
	/**
	 * Auxiliary register mostly used in address storing. High byte of combined 16-bit register 'HL'.
	 */
	public static final int H = 0b100;
	
	/**
	 * Auxiliary register mostly used in address storing. Low byte of combined 16-bit register 'HL'.
	 */
	public static final int L = 0b101;
	
	/**
	 * HL register combination only used in instruction opcodes.
	 */
	public static final int HL = 0b110;

}
