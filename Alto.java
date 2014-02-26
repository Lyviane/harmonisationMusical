package projet;

public class Alto extends Note {
	
	public Alto(String nomNote) throws NoteException{
		super(nomNote);
		if (noteValide(noteStringEnNoteInt(nomNote), 11, 22))
			note = noteStringEnNoteInt(nomNote);
		else
			throw new NoteException();
	}
	
	public Alto(String nomNote, int temps) throws NoteException{
		super(nomNote, temps);
		if (noteValide(noteStringEnNoteInt(nomNote), 11, 22))
			note = noteStringEnNoteInt(nomNote);
		else
			throw new NoteException();
	}
	
	public Alto(int nom) throws NoteException{
		super(nom);
		if (noteValide(nom, 11, 22))
			note = nom;
		else
			throw new NoteException();
	}
	
	public Alto(int nom, int temps) throws NoteException{
		super(nom, temps);
		if (noteValide(nom, 11, 22))
			note = nom;
		else
			throw new NoteException();
	}
}
