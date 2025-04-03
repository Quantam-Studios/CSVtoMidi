package edu.gz.CSVtoMidi;

/**
 * This class implements a strategy for modifying the pitch of a MIDI note by increasing it.
 * It adds 2 to the given note value, representing a shift to a higher pitch.
 */
public class HigherPitchStrategy implements PitchStrategy {

    /**
     * Modifies the pitch of the given MIDI note by increasing it by 2.
     *
     * @param note The original MIDI note value.
     * @return The modified MIDI note value, increased by 2.
     */
	@Override
    public int modifyPitch(int note) {
        note += 2;
        return note;
    }
}
