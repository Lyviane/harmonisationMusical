package projet;

public class Soprano extends Note{
	
	public Soprano(String nomNote) throws NoteException{
		super(nomNote);
		if (noteValide(noteStringEnNoteInt(nomNote), 14, 26))
			note = noteStringEnNoteInt(nomNote);
		else
			throw new NoteException();
	}
	
	public Soprano(String nomNote, int temps) throws NoteException{
		super(nomNote, temps);
		if (noteValide(noteStringEnNoteInt(nomNote), 14, 26))
			note = noteStringEnNoteInt(nomNote);
		else
			throw new NoteException();
	}
	
	public Soprano(int nom) throws NoteException{
		super(nom);
		if (noteValide(nom, 14, 26))
			note = nom;
		else
			throw new NoteException();
	}
	
	public Soprano(int nom, int temps) throws NoteException{
		super(nom, temps);
		if (noteValide(nom, 14, 26))
			note = nom;
		else
			throw new NoteException();
	}
}
