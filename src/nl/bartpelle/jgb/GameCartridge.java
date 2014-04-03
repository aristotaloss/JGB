package nl.bartpelle.jgb;

import java.util.zip.CRC32;

import nl.bartpelle.jgb.enums.CGBCompatibility;
import nl.bartpelle.jgb.ex.InvalidCartridgeException;

public class GameCartridge {
	
	private static final long NINTENDO_GRAPHIC_CRC32 = 0x46195417L;
	
	public int startAddress;
	public String title;
	public String makerCode;
	public CGBCompatibility cgbCompatibility;
	public boolean usesSGBFunctions;
	public int romSize;
	public int romVersion;
	
	public GameCartridge(byte[] data) throws InvalidCartridgeException {
		// Read start address
		startAddress = (data[0x102] & 0xFF) | (data[0x103] << 8);
		if (startAddress < 0 || startAddress >= data.length) {
			throw new InvalidCartridgeException("start address out of bounds: " + startAddress);
		}
		
		// Verify Nintendo graphic
		CRC32 crc = new CRC32();
		crc.update(data, 0x104, 0x133 - 0x103);
		
		if (crc.getValue() != NINTENDO_GRAPHIC_CRC32) {
			throw new InvalidCartridgeException("Nintendo graphic crc32 invalid: " + crc.getValue() + ", expected: " + NINTENDO_GRAPHIC_CRC32);
		}
		
		title = new String(data, 0x134, 12).trim();
		cgbCompatibility = CGBCompatibility.forCode(data[0x134]);
		makerCode = new String(data, 0x144, 2);
		usesSGBFunctions = data[0x146] == 3;
		romSize = (0x40000 << data[0x148]) / 8;
		
		if (romSize > data.length) {
			throw new InvalidCartridgeException("rom size (" + romSize + ") is bigger than actual program bytes: " + data.length);
		}
		
		romVersion = data[0x14C] & 0xFF;
		
		byte complement = 0x19;
		for (int i=0x134; i<=0x14C; i++) {
			complement += data[i];
		}
		complement += data[0x14D];
		
		if (complement != 0) {
			throw new InvalidCartridgeException("invalid complement check: " + complement + ", '0' is required");
		}
	}

}
