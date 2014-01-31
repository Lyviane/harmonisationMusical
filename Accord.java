package projet;

public class Accord {
	private Note tonique, tierce, quinte;
	private String nomA;
	
	public Accord(String accord) throws NomAccordException {
		if((! accord.equals("I"))&&(! accord.equals("II"))&&(! accord.equals("III"))&&(! accord.equals("IV"))&&(! accord.equals("IVb"))
				&&(! accord.equals("VI"))&&(! accord.equals("VII"))&&(! accord.equals("V"))){
			throw new NomAccordException();
		}
		else{
			if((accord.equals("I"))){
				nomA = accord;
				try {
					tonique = new Note("do");
					tierce = new Note("mi");
					quinte = new Note("sol");
				} catch (NoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if((accord.equals("II"))){
				nomA = accord;
				try {
					tonique = new Note("ré");
				} catch (NoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					tierce = new Note("fa");
				} catch (NoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					quinte = new Note("mi");
				} catch (NoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}if(accord.equals("III")){
				nomA = accord;
				try {
					tonique = new Note("mi");
				} catch (NoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					tierce = new Note("sol");
				} catch (NoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					quinte = new Note("si");
				} catch (NoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if((accord.equals("IV"))||(accord.equals("IVb"))){
				nomA = accord;
				try {
					tonique = new Note("fa");
				} catch (NoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					tierce = new Note("la");
				} catch (NoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					quinte = new Note("do");
				} catch (NoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(accord.equals("V")){
				nomA = accord;
				try {
					tonique = new Note("sol");
				} catch (NoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					tierce = new Note("si");
				} catch (NoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					quinte = new Note("ré");
				} catch (NoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(accord.equals("VI")){
				nomA = accord;
				try {
					tonique = new Note("la");
				} catch (NoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					tierce = new Note("ré");
				} catch (NoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					quinte = new Note("fa");
				} catch (NoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(accord.equals("VII")){
				nomA = accord;
				try {
					tonique = new Note("si");
				} catch (NoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					tierce = new Note("ré");
				} catch (NoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					quinte = new Note("fa");
				} catch (NoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public Note getTonique() {
		return tonique;
	}

	public void setTonique(Note tonique) {
		this.tonique = tonique;
	}

	public Note getTierce() {
		return tierce;
	}

	public void setTierce(Note tierce) {
		this.tierce = tierce;
	}

	public Note getQuinte() {
		return quinte;
	}

	public void setQuinte(Note quinte) {
		this.quinte = quinte;
	}

	public String getNomA() {
		return nomA;
	}

	public void setNomA(String nomA) {
		this.nomA = nomA;
	}
	public String toString(){
		return nomA;
	}
}
