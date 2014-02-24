package projet;

import java.io.*;
import java.util.LinkedList;

import javax.sound.midi.*;

public class FichierMidi {
	private static final int VELOCITY = 64;

	public int convertionNoteMidi(Note n) {
		int note = 0, octave = n.getNumeroOctave();
		String nom = n.getNomNote();

		switch (nom) {
		case "do":
			if (octave == 1)
				note = 36;
			else if (octave == 2)
				note = 48;
			else if (octave == 3)
				note = 60;
			else
				note = 72;
			break;
		case "re":
			if (octave == 1)
				note = 38;
			else if (octave == 2)
				note = 50;
			else if (octave == 3)
				note = 62;
			else
				note = 74;
			break;
		case "mi":
			if (octave == 1)
				note = 40;
			else if (octave == 2)
				note = 52;
			else if (octave == 3)
				note = 64;
			else
				note = 76;
			break;
		case "fa":
			if (octave == 1)
				note = 41;
			else if (octave == 2)
				note = 53;
			else if (octave == 3)
				note = 65;
			else
				note = 77;
			break;
		case "sol":
			if (octave == 1)
				note = 43;
			else if (octave == 2)
				note = 55;
			else if (octave == 3)
				note = 67;
			else
				note = 79;
			break;
		case "la":
			if (octave == 1)
				note = 45;
			else if (octave == 2)
				note = 57;
			else if (octave == 3)
				note = 69;
			else
				note = 81;
			break;
		case "si":
			if (octave == 1)
				note = 47;
			else if (octave == 2)
				note = 59;
			else if (octave == 3)
				note = 71;
			else
				note = 83;
			break;
		}

		return note;
	}

	public void sauvegarderEnMidi(LinkedList<Note> soprano, LinkedList<Note> alto, LinkedList<Note> tenor, LinkedList<Note> basse, String fichier) {
		File outputFile = new File(fichier);
		try {
			Sequence sequence = new Sequence(Sequence.PPQ, 1, 4);
			Track track = sequence.createTrack();
			track = ajouterNoteMidi(soprano, "soprano", track);
			track = ajouterNoteMidi(alto, "alto", track);
			track = ajouterNoteMidi(tenor, "tenor", track);
			track = ajouterNoteMidi(basse, "basse", track);
			MidiSystem.write(sequence, 1, outputFile);
		} catch (InvalidMidiDataException | IOException e) {
			e.printStackTrace();
		}
	}

	private Track ajouterNoteMidi(LinkedList<Note> note, String voie, Track track) {
		int temps = 0, v = 0;
		Note n;
		try{
			if (voie == "soprano"){
				track.add(instrument(73, 1));// flute
				v = 1;
			}
			else if (voie == "alto"){
				track.add(instrument(11,2)); // vibraphone
				v = 2;
			}
			else if (voie == "tenor"){
				track.add(instrument(12,3)); // mariba
				v = 3;
			}
			else{
				track.add(instrument(32,4)); // bass
				v = 4;
			}
		
			{
				for (int i = 0; i < note.size(); i++) {
					n = note.get(i);
					if (n.getNomNote() != "-"){
						track.add(noteOn(convertionNoteMidi(n), temps, v));
						temps = temps + n.getDuree();
						track.add(noteOff(convertionNoteMidi(n), temps, v));
					}
					else{
						temps = temps + n.getDuree();
					}
				}
			}
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
		
		return track;
	}

	private MidiEvent noteOn(int nKey, long lTick, int canal)
			throws InvalidMidiDataException {
		return createNoteEvent(ShortMessage.NOTE_ON, nKey, VELOCITY, lTick,
				canal);
	}

	private MidiEvent noteOff(int nKey, long lTick, int canal)
			throws InvalidMidiDataException {
		return createNoteEvent(ShortMessage.NOTE_OFF, nKey, 0, lTick, canal);
	}

	private  MidiEvent instrument(int instrument, int canal)
			throws InvalidMidiDataException {
		return createNoteEvent(ShortMessage.PROGRAM_CHANGE, instrument, 0, 0,
				canal);
	}

	private MidiEvent createNoteEvent(int nCommand, int nKey,
			int nVelocity, long lTick, int canal)
			throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
		message.setMessage(nCommand, canal, nKey, nVelocity);
		return new MidiEvent(message, lTick);
	}
}
