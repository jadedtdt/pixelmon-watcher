package pixelmon;

import java.awt.Toolkit;
import java.io.BufferedReader;
import pixelmon.PixelmonHelper;

public class Driver {

	public static void main(String[] args) throws InterruptedException {

		BufferedReader inFile = PixelmonHelper.loadFile();
		// String clip board = PixelmonHelper.getClipboard();
		String strRecentEvents = PixelmonHelper.getRecentEvents(inFile);

		// String ivString = PixelmonHelper.searchIVs(strRecentEvents);

		if (PixelmonHelper.isRecentLegendary(strRecentEvents) == true) {
			System.out.println("A LEGENDARY HAS SPAWNED!");

			for (int i = 0; i < 5; i++) {
				Toolkit.getDefaultToolkit().beep();
				Thread.sleep(100);
			}
		}
	}
}
