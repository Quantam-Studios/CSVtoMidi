package edu.gz.CSVtoMidi;

/**
 * This class implements a strategy for modifying the pitch of a MIDI note by decreasing it.
 * It subtracts 2 to the given note value, representing a shift to a lower pitch.
 */
public class LowerPitchStrategy {

    /**
     * Modifies the pitch of the given MIDI note by decreasing it by 2.
     *
     * @param note The original MIDI note value.
     * @return The modified MIDI note value, decreasing by 2.
     */
    public int modifyPitch(int note) {
        note -= 2;
        return note;
    }
}
