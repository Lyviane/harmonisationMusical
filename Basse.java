package projet;

public class Basse extends Note {

	public Basse(String nomNote) throws NoteException{
		super(nomNote);
		if (noteValide(noteStringEnNoteInt(nomNote), 3, 15))
			note = noteStringEnNoteInt(nomNote);
		else
			throw new NoteException();
	}
	
	public Basse(String nomNote, int temps) throws NoteException{
		super(nomNote, temps);
		if (noteValide(noteStringEnNoteInt(nomNote), 3, 15))
			note = noteStringEnNoteInt(nomNote);
		else
			throw new NoteException();
	}
	
	public Basse(int nom) throws NoteException{
		super(nom);
		if (noteValide(nom, 3, 15))
			note = nom;
		else
			throw new NoteException();
	}
	
	public Basse(int nom, int temps) throws NoteException{
		super(nom, temps);
		if (noteValide(nom, 3, 15))
			note = nom;
		else
			throw new NoteException();
	}

}
