package edu.gz.CSVtoMidi;

import javax.sound.midi.*;
import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) throws MidiUnavailableException, InterruptedException {    	
        try {
            List<MidiEventData> midiEvents = null;
            try {
                String filePath = new File("src/edu/gz/CSVtoMidi/mystery_song.csv").getAbsolutePath();
                midiEvents = MidiCsvParser.parseCsv(filePath);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }

            if (midiEvents == null || midiEvents.isEmpty()) {
                System.out.println("No MIDI events loaded.");
                return;
            }

            Sequence sequence = new Sequence(Sequence.PPQ, 384);
            Track track = sequence.createTrack();

            MidiEventFactoryAbstract factoryAbstract = new StandardMidiEventFactoryAbstract();
            MidiEventFactory factory = factoryAbstract.createFactory();

            // Set instruments
            InstrumentStrategy instrumentStrategy = new ElectricBassGuitarStrategy();
            instrumentStrategy.applyInstrument(track, 0);

            instrumentStrategy = new TrumpetStrategy();
            instrumentStrategy.applyInstrument(track, 1);

            // Set pitch
            PitchStrategy pitchStrategy = new HigherPitchStrategy();

            // Add events
            for (MidiEventData event : midiEvents) {
                int modifiedNote = pitchStrategy.modifyPitch(event.getNote());
                modifiedNote = pitchStrategy.modifyPitch(modifiedNote);

                if (modifiedNote < 0) modifiedNote = 0;
                if (modifiedNote > 127) modifiedNote = 127;

                int velocity = Math.max(event.getVelocity(), 50); // Ensure it's audible

                if (event.getNoteOnOff() == ShortMessage.NOTE_ON) {
                    track.add(factory.createNoteOn(event.getStartEndTick(), modifiedNote, velocity, event.getChannel()));
                } else {
                    track.add(factory.createNoteOff(event.getStartEndTick(), modifiedNote, event.getChannel()));
                }
            }

            System.out.println("Track size: " + track.size());
            if (track.size() == 0) {
                System.out.println("No notes were added. Check your MIDI processing logic.");
                return;
            }

            // Play MIDI
            Sequencer sequencer = MidiSystem.getSequencer(false);
            if (sequencer == null) {
                System.out.println("No MIDI sequencer available.");
                return;
            }

            Synthesizer synthesizer = MidiSystem.getSynthesizer();
            if (synthesizer == null) {
                System.out.println("No MIDI synthesizer available.");
                return;
            }

            synthesizer.open();
            Receiver receiver = synthesizer.getReceiver();
            sequencer.getTransmitter().setReceiver(receiver);
            sequencer.open();
            
            sequencer.setSequence(sequence);
            sequencer.start();

            // Keep it playing until done
            while (sequencer.isRunning()) {
                Thread.sleep(100);
            }

            Thread.sleep(500);
            sequencer.close();
            synthesizer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
