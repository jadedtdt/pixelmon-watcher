package pixelmon;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PixelmonHelper {

	// our constants
	private static String DIRECTORY = "C:\\Users\\Gene\\AppData\\Roaming\\.pixelmon-beta\\profiles\\1\\logs";
	private static String FILE_NAME = "latest.log";
	private static List<String> listLegendaryMessages;

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
			e.printStackTrace();
		} catch (UnsupportedFlavorException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
	// scrapes our string for the time stamps to decide how recent the string is
	// spawning
	public static boolean isRecentString(String input) {
		
		if (input == null) {
			System.err.println("Input string is null!");
			return false;
		}
		//else
		
		// gets current time, formats it in a legible way, and then looks
		long yourmilliseconds = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date resultdate = new Date(yourmilliseconds);
		String printableDate = sdf.format(resultdate);

		// TODO allow for 5min buffer before current time
		// if the string has our time (this hr/minute) it's recent
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
			// System.out.println(fReader.toString());
			bufReader = new BufferedReader(fReader);
			// System.out.println(fReader.toString());

		} catch (FileNotFoundException e) {
			System.err.println("File not found! Concurrent access violation? :(");
			e.printStackTrace();
		}

		return bufReader;

	}

	// getRecentEvents(BufferedReader)
	// looks at the lines in the log file with the past two minutes to see if
	// anything important has happened
	public static String getRecentEvents(BufferedReader inFile) {
		
		if (inFile == null) {
			System.err.println("Input file is null in getRecentEvents!");
		}
		// else
		
		String strEvents = "";

		// TODO fix up hardcoded biomes
		// takes our lines in the txt
		List<String> goodStrings = inFile.lines()
				// filters out people faking the message (unless they're really clever), gets biomes we want, and avoids messages we've seen
				.filter(x -> x.contains("dPixelmon") && (x.contains("Ocean") || x.contains("Beach")) && (!listLegendaryMessages.contains(x)))
				// stores in a list for us so we can iterate through it
				.collect(Collectors.toList());

		// loops through our list and updates our info
		for (String s : goodStrings) {
			strEvents += s + "\n";
			System.out.println(s);
		}

		return strEvents;
	}

	// toggleRunState()
	// toggles our run state, usually performed when clicking Start/Stop button
	public static void toggleRunState() {
		isRunning = !isRunning;
	}

	// getRunState()
	// returns our run state to determine if we should run our pixelmon script
	// or just display our GUI
	public static boolean isRunning() {
		return isRunning;
	}
}
