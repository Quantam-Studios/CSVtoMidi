package edu.gz.CSVtoMidi;

import javax.sound.midi.*;

/**
 * A factory class for creating standard MIDI events such as Note On and Note Off.
 */
public class StandardMidiEventFactory implements MidiEventFactory {

    /**
     * Creates a MIDI Note On event.
     *
     * @param tick     The timestamp (in MIDI ticks) when the event occurs.
     * @param note     The MIDI note number (0-127), where 60 represents middle C.
     * @param velocity The velocity (0-127), representing the intensity of the note.
     * @param channel  The MIDI channel (0-15) on which the event is sent.
     * @return A {@link MidiEvent} representing the Note On message.
     * @throws InvalidMidiDataException If the provided MIDI data is invalid.
     */
    @Override
    public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
        ShortMessage message = new ShortMessage();
        message.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
        
        return new MidiEvent(message, tick);
    }

    /**
     * Creates a MIDI Note Off event.
     *
     * @param tick    The timestamp (in MIDI ticks) when the event occurs.
     * @param note    The MIDI note number (0-127), where 60 represents middle C.
     * @param channel The MIDI channel (0-15) on which the event is sent.
     * @return A {@link MidiEvent} representing the Note Off message.
     * @throws InvalidMidiDataException If the provided MIDI data is invalid.
     */
    @Override
    public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
        ShortMessage message = new ShortMessage();
        message.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);
        
        return new MidiEvent(message, tick);
    }
}
