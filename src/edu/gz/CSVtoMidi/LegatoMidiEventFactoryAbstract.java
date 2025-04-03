package edu.gz.CSVtoMidi;

public class LegatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	/**
	 * Creates and returns a new instance of {@code LegatoMidiEventFactory}.
	 * 
	 * @return A new {@code LegatoMidiEventFactory} instance.
	 */
	@Override
	public LegatoMidiEventFactory createFactory() {
	    return new LegatoMidiEventFactory();
	}
}
