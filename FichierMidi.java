package projet;

import java.io.*;
import java.util.LinkedList;

import javax.sound.midi.*;

public class FichierMidi {
	private static final int VELOCITY = 64;

	public int convertionNoteMidi(Note n) {
		switch (n.getNote()){
		case 0:
			return 36;
		case 1:
			return 38;
		case 2:
			return 40;
		case 3:
			return 41;
		case 4:
			return 43;
		case 5:
			return 45;
		case 6:
			return 47;
		case 7:
			return 48;
		case 8:
			return 50;
		case 9:
			return 52;
		case 10:
			return 53;
		case 11:
			return 55;
		case 12:
			return 57;
		case 13:
			return 59;
		case 14:
			return 60;
		case 15:
			return 62;
		case 16:
			return 64;
		case 17:
			return 65;
		case 18:
			return 67;
		case 19:
			return 69;
		case 20:
			return 71;
		case 21:
			return 72;
		case 22:
			return 74;
		case 23:
			return 76;
		case 24:
			return 77;
		case 25:
			return 79;
		case 26:
			return 81;
		case 27:
			return 83;
		default:
			return -1;
		}
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
					if (n.getNote() != 28){
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
