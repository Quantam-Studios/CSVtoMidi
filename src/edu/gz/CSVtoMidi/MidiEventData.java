package edu.gz.CSVtoMidi;

/**
 * Represents a MIDI event with various attributes such as timing, velocity, note, channel, instrument, and event type.
 */
public class MidiEventData {
    private int startEndTick, velocity, note, channel, noteOnOff;
    private int instrument;

    /**
     * Constructs a {@code MidiEventData} object with the specified attributes.
     *
     * @param startEndTick the start or end tick of the MIDI event
     * @param velocity     the velocity of the MIDI note
     * @param note         the MIDI note value
     * @param channel      the MIDI channel
     * @param instrument   the instrument associated with the event
     * @param noteOnOff    the note-on or note-off status (1 for "Note_on_c", 0 for "Note_off_c")
     */
    public MidiEventData(int startEndTick, int velocity, int note, int channel, int instrument, int noteOnOff) {
        this.startEndTick = startEndTick;
        this.velocity = velocity;
        this.note = note;
        this.channel = channel;
        this.instrument = instrument;
        this.noteOnOff = noteOnOff;
    }

    /**
     * Gets the start or end tick of the MIDI event.
     *
     * @return the start or end tick value
     */
    public int getStartEndTick() {
        return startEndTick;
    }

    /**
     * Gets the velocity of the MIDI note.
     *
     * @return the velocity value
     */
    public int getVelocity() {
        return velocity;
    }

    /**
     * Gets the MIDI note value.
     *
     * @return the MIDI note
     */
    public int getNote() {
        return note;
    }

    /**
     * Gets the MIDI channel of the event.
     *
     * @return the channel number
     */
    public int getChannel() {
        return channel;
    }

    /**
     * Gets the instrument associated with the event.
     *
     * @return the instrument number
     */
    public int getInstrument() {
        return instrument;
    }

    /**
     * Gets the note-on or note-off status.
     *
     * @return 1 if the event is "Note_on_c", 0 if "Note_off_c"
     */
    public int getNoteOnOff() {
        return noteOnOff;
    }

    /**
     * Sets the start or end tick of the MIDI event.
     *
     * @param startEndTick the start or end tick value
     */
    public void setStartEndTick(int startEndTick) {
        this.startEndTick = startEndTick;
    }

    /**
     * Sets the velocity of the MIDI note.
     *
     * @param velocity the velocity value
     */
    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    /**
     * Sets the MIDI note value.
     *
     * @param note the MIDI note
     */
    public void setNote(int note) {
        this.note = note;
    }

    /**
     * Sets the MIDI channel of the event.
     *
     * @param channel the channel number
     */
    public void setChannel(int channel) {
        this.channel = channel;
    }

    /**
     * Sets the instrument associated with the event.
     *
     * @param instrument the instrument number
     */
    public void setInstrument(int instrument) {
        this.instrument = instrument;
    }

    /**
     * Sets the note-on or note-off status.
     *
     * @param noteOnOff 1 for "Note_on_c", 0 for "Note_off_c"
     */
    public void setNoteOnOff(int noteOnOff) {
        this.noteOnOff = noteOnOff;
    }
}
