package edu.gz.CSVtoMidi;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

/**
 * A MIDI event factory that creates staccato (short and detached) note events.
 * The Note Off event occurs 120 ticks earlier than usual to introduce a gap
 * before the next Note On event.
 */
public class StacattoMidiEventFactory implements MidiEventFactory {
    
	/**
     * Creates a MIDI Note On event.
     *
     * @param tick     The timestamp (in MIDI ticks) when the event occurs.
     * @param note     The MIDI note number.
     * @param velocity The velocity representing the intensity of the note.
     * @param channel  The MIDI channel on which the event is sent.
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
     * Creates a MIDI Note Off event for staccato effect.
     * The Note Off event occurs 120 ticks earlier than the original duration.
     *
     * @param tick    The timestamp (in MIDI ticks) when the original Note Off event would occur.
     * @param note    The MIDI note number.
     * @param channel The MIDI channel on which the event is sent.
     * @return A {@link MidiEvent} representing the Note Off message.
     * @throws InvalidMidiDataException If the provided MIDI data is invalid.
     */
    @Override
    public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
        ShortMessage message = new ShortMessage();
        message.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);
        
        return new MidiEvent(message, tick - 120);
    }
}
