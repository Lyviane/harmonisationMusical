package projet;

public class Tenor extends Note {

	public Tenor(String nomNote) throws NoteException{
		super(nomNote);
		if (noteValide(noteStringEnNoteInt(nomNote), 7, 19))
			note = noteStringEnNoteInt(nomNote);
		else
			throw new NoteException();
	}
	
	public Tenor(String nomNote, int temps) throws NoteException{
		super(nomNote, temps);
		if (noteValide(noteStringEnNoteInt(nomNote), 7, 19))
			note = noteStringEnNoteInt(nomNote);
		else
			throw new NoteException();
	}
	
	public Tenor(int nom) throws NoteException{
		super(nom);
		if (noteValide(nom, 7, 19))
			note = nom;
		else
			throw new NoteException();
	}
	
	public Tenor(int nom, int temps) throws NoteException{
		super(nom, temps);
		if (noteValide(nom, 7, 19))
			note = nom;
		else
			throw new NoteException();
	}

}
