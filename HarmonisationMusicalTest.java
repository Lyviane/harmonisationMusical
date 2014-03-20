package projet;

import java.util.LinkedList;

import org.junit.Test;

public class HarmonisationMusicalTest {

	@Test
	public void testVoixSoprano() {
		LinkedList<Note> l = HarmonisationMusical.chargerFichierChant("fichier.chant");
		LinkedList<Integer> liste = HarmonisationMusical.voixSoprano(l);
		for(int a : liste){
			System.out.print(a+",");
		}
	}

}
