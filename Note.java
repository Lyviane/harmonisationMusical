package projet;

public class Note {
	private String nomNote;
	private int numeroOctave;
	public Note(String nomNote) throws NoteException{
		if((! nomNote.equals("do"))&&(! nomNote.equals("r�"))&&(! nomNote.equals("mi"))&&(! nomNote.equals("fa"))&&(! nomNote.equals("sol"))&&(! nomNote.equals("la"))&&(! nomNote.equals("si"))){
			throw new NoteException();
		}
		else{ 
			this.nomNote = nomNote;
		}
	}
	public Note(String nomNote, int num) throws NoteException, NumberException{
		if((! nomNote.equals("do"))&&(! nomNote.equals("r�"))&&(! nomNote.equals("mi"))&&(! nomNote.equals("fa"))&&(! nomNote.equals("sol"))&&(! nomNote.equals("la"))
				&&(! nomNote.equals("si"))){
			throw new NoteException();
		}else {
			this.nomNote = nomNote;
		}
		if((num<1)||(num>4)){
			throw new NumberException();
		} else {
			numeroOctave = num;
		}
	}
	
	public String getNomNote() {
		return nomNote;
	}

	public void setNomNote(String nomNote) {
		this.nomNote = nomNote;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public int getNumeroOctave() {
		return numeroOctave;
	}

	public void setNumeroOctave(int numeroOctave) {
		this.numeroOctave = numeroOctave;
	}
	public String toString(){
		return nomNote+numeroOctave;
	}

}
