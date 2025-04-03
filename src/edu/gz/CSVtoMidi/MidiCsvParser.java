package edu.gz.CSVtoMidi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Parses a CSV file containing MIDI event data and converts it into a list of MidiEventData objects.
 */
public class MidiCsvParser {

    /**
     * Parses a CSV file and converts each row into a MidiEventData object.
     *
     * @param filePath the path to the CSV file
     * @return a list of MidiEventData objects parsed from the file
     * @throws FileNotFoundException if the file is not found
     */
    public static List<MidiEventData> parseCsv(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        List<MidiEventData> midiEventDataList = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");

                MidiEventData midiData = new MidiEventData(
                        Integer.parseInt(values[0]),  
                        Integer.parseInt(values[4]),  
                        Integer.parseInt(values[3]),  
                        Integer.parseInt(values[2]),  
                        Integer.parseInt(values[5]),  
                        getNoteOnOff(values[1])
                );

                midiEventDataList.add(midiData);
            }
        }

        return midiEventDataList;
    }

    /**
     * Determines whether a MIDI event represents a "Note On" or "Note Off" event.
     *
     * @param note the string representing either "Note_on_c" or "Note_off_c"
     * @return 1 if the event is "Note_on_c", 0 if "Note_off_c", or -1 if unknown
     */
    private static int getNoteOnOff(String note) {
        if ("Note_on_c".equals(note)) {
            return 1;
        } else if ("Note_off_c".equals(note)) {
            return 0;
        }

        return -1;
    }
}
