package projet;

public class Alto implements Voix {
	private Note note;
	@Override
	public Note noteMin() {
		// TODO Auto-generated method stub
		try {
			note = new Note("do", 3);
		} catch (NoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return note;
	}

	@Override
	public Note noteMax() {
		// TODO Auto-generated method stub
		try {
			note = new Note("la", 4);
		} catch (NoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return note;
	}

}
