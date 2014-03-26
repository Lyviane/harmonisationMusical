package projet;

import java.util.LinkedList;

import org.junit.Test;

public class VoixTest {

	@Test
	public void test() {
		LinkedList<Integer> liste = new LinkedList<Integer>();
		liste.add(14);
		liste.add(15);
		liste.add(16);
		liste.add(15);
		Voix v = new Voix(liste);
		System.out.println(v.toString());
	}
	
	@Test
	public void testUnCheminf(){//qui fonctionne
		LinkedList<Integer> liste = new LinkedList<Integer>();
		liste.add(14);
		liste.add(15);
		liste.add(16);
		liste.add(15);
		Voix v = new Voix(liste);
		LinkedList<Integer> alto;
		try {
			alto = v.unChemin(0,0,liste.size());
			for(int a : alto){
				System.out.print(a+",");
			}
		} catch (HarmonisationException e) {
			System.err.println(e);
		}
		
	}
	
	@Test
	public void testUnChemin(){//qui sort une erreur
		LinkedList<Integer> liste = new LinkedList<Integer>();
		liste.add(14);
		liste.add(15);
		liste.add(16);
		liste.add(17);
		Voix v = new Voix(liste);
		LinkedList<Integer> alto;
		try {
			alto = v.unChemin(0,0,liste.size());
			for(int a : alto){
				System.out.print(a+",");
			}
		} catch (HarmonisationException e) {
			System.err.println(e);
		}
		
	}

}
