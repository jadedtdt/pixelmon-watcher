package pixelmon;

import java.awt.HeadlessException;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;

public class PixelmonHelper {

	// our constants
	private static String DIRECTORY = "C:\\Users\\Gene\\AppData\\Roaming\\.pixelmon-beta\\profiles\\1\\logs";
	private static String FILE_NAME = "latest.log";

	// our private data members
	String myRecentEvents = "";
	static boolean isRunning = true;

	// getClipboard
	// gets the contents of the clipboard
	public static String getClipboard() {
		String data = null;
		try {
			data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedFlavorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	// searchIVs
	// searches for any perfect (31) IVs
	public static String searchIVs(String input) {
		return input;

	}

	// isRecentLegendary
	// scrapes our string for any text matching text belonging to a legendary spawning
	public static boolean isRecentLegendary(String input) {
		long yourmilliseconds = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date resultdate = new Date(yourmilliseconds);
		String printableDate = sdf.format(resultdate);
		System.out.println(printableDate);

		boolean isRecent = (input.contains(printableDate) ? true : false);
		return isRecent;
	}

	// loadFile()
	// loads our log file; hopefully it only has to do this once per script run
	public static BufferedReader loadFile() {
		String fileName = DIRECTORY + "\\" + FILE_NAME;
		System.out.println("Our filename is: " + fileName);

		FileReader fReader = null;
		BufferedReader bufReader = null;

		// open file
		try {
			fReader = new FileReader(fileName);
			//System.out.println(fReader.toString());
			bufReader = new BufferedReader(fReader);
			//System.out.println(fReader.toString());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("File not found! Concurrent access violation? :(");
			e.printStackTrace();
		}

		return bufReader;

	}

	// getRecentEvents(BufferedReader)
	// looks at the lines in the log file with the past two minutes to see if anything important has happened
	public static String getRecentEvents(BufferedReader inFile) {

		if (inFile == null) {
			System.err.println("Input file is null in getRecentEvents!");
		}
		// else

		return null;
	}

	// toggleRunState()
	// toggles our run state, usually performed when clicking Start/Stop button
	public static void toggleRunState() {
		isRunning = !isRunning;
	}
	
	// getRunState()
	// returns our run state to determine if we should run our pixelmon script or just display our GUI
	public static boolean getRunState() {
		return isRunning;
	}
}
