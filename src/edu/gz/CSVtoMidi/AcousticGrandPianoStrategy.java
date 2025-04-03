package edu.gz.CSVtoMidi;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

/**
 * Applies the Acoustic Grand Piano Strategy instrument to the specified MIDI track and channel.
 *
 * @param track The MIDI track to which the instrument change should be applied.
 * @param channel The MIDI channel to apply the instrument change.
 */
public class AcousticGrandPianoStrategy {
	void applyInstrument(Track track, int channel) {
		try {
			ShortMessage message = new ShortMessage();
			message.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 0, 0);
			
			MidiEvent event = new MidiEvent(message, 0);
			
			track.add(event);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}
}
