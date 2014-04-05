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
	 * Flags register, holds flags for arithmetic and logical operations (e.g. carry).
	 */
	private byte F;
	
	/**
	 * The CPU's registers. Represent the values in {@link Register}.
	 */
	private int[] registers = new int[8];
	
	/**
	 * The currently used ROM bank. A value of 0 or 1 indicates bank 1, values 2 to 7 indicate bank 2 to 7.
	 */
	private byte romBank;
	
	/**
	 * The actual game ROM bytes that contain the instructions.
	 */
	private byte[] rom;
	
	/**
	 * The stack of the processor. Consists of 65535 bytes.
	 */
	private byte[] stack = new byte[0xFFFF];
	
	/**
	 * The cartridge that is currently running.
	 */
	private GameCartridge cartridge;
	
	/**
	 * The 'program counter', which resembles the offset on the ROM where we will execute our instruction.
	 */
	private int pc;
	
	/**
	 * The 'stack pointer', which resembles the position in the stack. Initially set to the top of the stack.
	 * Decreases when something is pushed and increases when something is popped.
	 */
	private int sp = 0xFFFE;
	
	/**
	 * Create a new Z80 processor emulator from the specified {@link GameCartridge}.
	 * @param cartridge the cartridge which contains the game ROM and various other information.
	 */
	public GBZ80(GameCartridge cartridge) {
		this.cartridge = cartridge;
		rom = cartridge.rom;
		pc = cartridge.startAddress;
	}
	
	/**
	 * Process a specified amount of instructions to let the processor interpret.
	 * @param amount the number of instructions to execute, or <code>-1</code> to run indefinitely.
	 */
	public void processInstructions(int amount) {
		int instr = 0;
		int cycles = 0; // Amount of consumed cycles (afaik this is used internally somewhere)
		int opcode;
		
		while (instr++ != amount) {
			opcode = rom[pc] & 0xFF;
			
			if ((opcode & 0xC0) == Instructions.LD_R_R) {
				int dst = (opcode >> 3) & 7;
				int src = opcode & 7;
				registers[dst] = registers[src];
				cycles = 1;
				pc++;
			} else if (((opcode & 0xF8) == Instructions.CP_R) || opcode == Instructions.CP_N) {
				if (opcode == Instructions.CP_N) {
					pc++;
					int operand = rom[pc++];
					int a = registers[Register.A];
					setFlag(Flag.N, true);
					setFlag(Flag.Z, a == operand);
					setFlag(Flag.CY, a < operand);
					setFlag(Flag.H, (a & 0xF) < (operand & 0xF));
				}
			} else {
				System.err.println("Unknown Z80 instruction: $" + Integer.toHexString(opcode).toUpperCase() + ".");
				break;
			}
		}
	}
	
	private void setFlag(int flag, boolean set) {
		if (set)
			F |= flag;
		else
			F &= ~flag;
	}
	
}
