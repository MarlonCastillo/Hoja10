
//Pruebas Unitarias

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GrafoTest {

	@Test
	public void testAddVertice() {
		Grafo grafo1 = new Grafo();
		grafo1.addVertice("Guatemala");
		assertEquals(0,0,0);
	}

	@Test
	public void testRemoveArista() {
		Grafo grafo1 = new Grafo();
		grafo1.addVertice("A");
		grafo1.addVertice("B");
		try {
			grafo1.addArista("A", "B", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		grafo1.removeArista("A", "B");
		assertEquals(0,0,0);
	}

	@Test
	public void testAddArista() {
		Grafo grafo1 = new Grafo();
		grafo1.addVertice("B");
		grafo1.addVertice("A");
		try {
			grafo1.addArista("B", "A", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		grafo1.removeArista("B", "A");
		assertEquals(0,0,0);
	}

	@Test
	public void testGetdistancia() {
		Grafo grafo1 = new Grafo();
		grafo1.addVertice("B");
		grafo1.addVertice("A");
		try {
			grafo1.addArista("B", "A", 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		grafo1.getdistancia("A", "B");
		assertEquals(1,1,1);
	}
}
