package edu.gz.CSVtoMidi;

public class StaccatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	/**
	 * Creates and returns a new instance of {@code StaccatoMidiEventFactory}.
	 * 
	 * @return A new {@code StaccatoMidiEventFactory} instance.
	 */
	@Override
	public StaccatoMidiEventFactory createFactory() {
	    return new StaccatoMidiEventFactory();
	}
}
