package edu.gz.CSVtoMidi;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;

public interface MidiEventFactory {
	MidiEvent createNoteOn() throws InvalidMidiDataException;
	MidiEvent createNoteOff() throws InvalidMidiDataException;
}
