package edu.gz.CSVtoMidi;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

/**
 * A MIDI event factory that creates legato (smooth and connected) note events.
 * This implementation ensures minimal gaps between notes by extending the 
 * duration of each note. The Note Off event is delayed by 80 ticks to achieve
 * a legato effect.
 */
public class LegatoMidiEventFactory implements MidiEventFactory {

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
     * Creates a MIDI Note Off event with an extended duration for legato effect.
     * The Note Off event is delayed by 80 ticks to ensure smooth and connected notes.
     *
     * @param tick    The timestamp (in MIDI ticks) when the original Note Off event would occur.
     * @param note    The MIDI note number (0-127), where 60 represents middle C.
     * @param channel The MIDI channel (0-15) on which the event is sent.
     * @return A {@link MidiEvent} representing the Note Off message.
     * @throws InvalidMidiDataException If the provided MIDI data is invalid.
     */
    @Override
    public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
        ShortMessage message = new ShortMessage();
        message.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);
        return new MidiEvent(message, tick + 80);
    }
}
