package projet;

import java.util.LinkedList;

import org.junit.Test;

public class VoixTest {

	@Test
	public void test() {
		LinkedList<Integer> liste = new LinkedList<Integer>();
		liste.add(21);
		liste.add(22);
		liste.add(23);
		Voix v = new Voix(liste);
		System.out.println(v.toString());
	}

}
