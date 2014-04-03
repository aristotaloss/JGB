package nl.bartpelle.jgb;

import java.io.File;
import java.nio.file.Files;

public class JGB {

	public static void main(String[] args) throws Exception {
		GameCartridge card = new GameCartridge(Files.readAllBytes(new File("pokemon_red.gb").toPath()));
		System.out.println(card.romVersion);
	}

}
