package battlefield;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/* Modificare la classe Position affinche' 
 * il primo test abbia successo (vedi DOMANDA 1) 
 */
public class BattlefieldTest {
	
	private Battlefield field;
	
	@Before
	public void setUp() throws Exception {
		this.field = new Battlefield(2);
	}

	@Test
	public void testAddRobot() {
		assertEquals(0, this.field.getAllRobots().size());
		this.field.addRobot(new Walker(new Position(0,0)));
		assertEquals(1, this.field.getAllRobots().size());
	}
	
	@Test
	public void testRaggruppaRobotDiDueTipiDiversi() {
		Position p= new Position(0, 0);
		Position p1 = new Position(1,0);
		Position p2 = new Position(1,1);
		Position p3 = new Position(0,1);
		Robot r = new Walker(p);
		Robot r1 = new Walker(p1);
		Robot r2 = new Chaser(p2);
		Robot r3 = new Chaser(p3);
		field.addRobot(r3);
		field.addRobot(r2);
		field.addRobot(r1);
		field.addRobot(r);
//		Map<Class, Set<Robot>> m = new HashMap<Class, Set<Robot>>();
//		m=field.raggruppaRobotPerTipo();
//		assertEquals(2,m.keySet().size());
////		for(Class c : m.keySet()) {
////		System.out.println(c);
////	}
////		for(Robot rb: m.get(r.getClass())) {
////
////		}
//		assertEquals(2,m.get(r.getClass()).size());
//		assertEquals(1,m.get(r2.getClass()).size());
		List<Robot> lista = new LinkedList<Robot>();
		lista = field.getRobotOrdinatiPerPosizione();
		assertSame(r, lista.get(0));
		assertSame(r3, lista.get(1));
		assertSame(r1, lista.get(2));
		assertSame(r2, lista.get(3));
	}

}
