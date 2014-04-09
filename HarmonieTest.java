package projet;

import org.junit.Test;

public class HarmonieTest {

	@Test
	public void test() {
		Harmonie h = new Harmonie(22, 5);
		System.out.println(h.toString());
		h = new Harmonie(22, 2);
		System.out.println(h.toString());
		
		h = new Harmonie(22, 7);
		System.out.println(h.toString());
	}

}
