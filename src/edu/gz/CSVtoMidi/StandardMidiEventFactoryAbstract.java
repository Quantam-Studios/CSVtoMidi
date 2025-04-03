package edu.gz.CSVtoMidi;

public class StandardMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	/**
	 * Creates and returns a new instance of {@code StandardMidiEventFactory}.
	 * 
	 * @return A new {@code StandardMidiEventFactory} instance.
	 */
	@Override
	public StandardMidiEventFactory createFactory() {
	    return new StandardMidiEventFactory();
	}
}
