package projet;

public class RegleLocal {
		
	//r�gle 2
	public boolean differenceDeHauteurValide(Note soprano, Note alto, Note tenor, Note basse){
		if (soprano.superieur(alto) && alto.superieur(tenor) && tenor.superieur(basse))
			return true;
		return false;
	}
	
}
