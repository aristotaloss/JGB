package nl.bartpelle.jgb;

/**
 * 
 * The main engine behind the emulator: the central processing unit.
 * 
 * @author Bart Pelle
 *
 */
public class GBZ80 {

	/*
	 * REGISTERS
	 */
	
	/**
	 * Accumulator register, mainly used for results from arithmetic/logical operations.
	 */
	private byte A;
	
	/**
	 * Auxiliary register, high byte of combined 16-bit register 'BC'.
	 */
	private byte B;
	
	/**
	 * Auxiliary register, low byte of combined 16-bit register 'BC'.
	 */
	private byte C;
	
	/**
	 * Auxiliary register, high byte of combined 16-bit register 'DE'.
	 */
	private byte D;
	
	/**
	 * Auxiliary register, low byte of combined 16-bit register 'DE'.
	 */
	private byte E;
	
	/**
	 * Flags register, holds flags for arithmetic and logical operations (e.g. carry).
	 */
	private byte F;
	
	/**
	 * Auxiliary register mostly used in address storing. High byte of combined 16-bit register 'HL'.
	 */
	private byte H;
	
	/**
	 * Auxiliary register mostly used in address storing. Low byte of combined 16-bit register 'HL'.
	 */
	private byte L;
	
	
}
