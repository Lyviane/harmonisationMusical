package projet;

import org.junit.Test;

public class HarmonieTest {

	@Test
	public void test() {
		Harmonie h = new Harmonie(22, 2);
		System.out.println(h.toString());
		System.out.println("");
		h = new Harmonie(22, 5);
		System.out.println(h.toString());
	}

}
