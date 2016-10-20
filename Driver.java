package pixelmon;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.BufferedReader;
import pixelmon.PixelmonHelper;

public class Driver {

	public static void main(String[] args) throws InterruptedException {

		BufferedReader inFile = PixelmonHelper.loadFile();
		// String clip board = PixelmonHelper.getClipboard();
		String strRecentEvents = PixelmonHelper.getRecentEvents(inFile);

		// String ivString = PixelmonHelper.searchIVs(strRecentEvents);
		

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		while (PixelmonHelper.isRunning()) {

			strRecentEvents = PixelmonHelper.getRecentEvents(inFile);

			if (PixelmonHelper.isRecentLegendary(strRecentEvents) == true) {
				System.out.println("A LEGENDARY HAS SPAWNED!");

				for (int i = 0; i < 5; i++) {
					Toolkit.getDefaultToolkit().beep();
					Thread.sleep(100);
				}
			} else {
				Thread.sleep(5000);
			}
		}
		
		System.err.println("Exiting program...");

	}
}
