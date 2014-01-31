package HarmonieMusical;

public class Note {
	private String nom;
	private int numOctave;
	
	public Note(String nom, int num) throws NoteException {
		if((! nom.equals("do"))&&(! nom.equals("ré"))&&(! nom.equals("mi"))&&(! nom.equals("fa"))&&(! nom.equals("sol"))
				&&(! nom.equals("la"))&&(! nom.equals("si"))){
			throw new NoteException();
		}
		else {
			this.nom = nom;
			try{
				this.numOctave = num;
			} catch(NumberFormatException e){
				System.out.println("Octave de 1 à 4");
			}
		}
	}
	public Note(String nom) throws NoteException {
		if((! nom.equals("do"))&&(! nom.equals("ré"))&&(! nom.equals("mi"))&&(! nom.equals("fa"))&&(! nom.equals("sol"))
				&&(! nom.equals("la"))&&(! nom.equals("si"))){
			throw new NoteException();
		} else {
			this.nom = nom;
		}
	}
}
