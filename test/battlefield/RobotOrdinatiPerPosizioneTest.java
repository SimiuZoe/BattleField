package battlefield;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.*;

public class RobotOrdinatiPerPosizioneTest {

	private Battlefield field;

	@Before
	public void setUp() throws Exception {
		this.field = new Battlefield(2);
	}

	@Test
	public void testQuattroRobot() {
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
		List<Robot> lista = new LinkedList<Robot>();
		lista = field.getRobotOrdinatiPerPosizione();
		assertSame(r, lista.get(0));
		assertSame(r3, lista.get(1));
		assertSame(r1, lista.get(2));
		assertSame(r2, lista.get(3));
	}

	@Test 
	public void TestVuoto() {
		//		List<Robot> lista = new LinkedList<Robot>();
		//		lista = field.getRobotOrdinatiPerPosizione();
		assertEquals(0,field.getRobotOrdinatiPerPosizione().size());
	}

	@Test
	public void TestUnRobot() {
		Position p= new Position(0, 0);
		Robot r = new Walker(p);
		field.addRobot(r);
		List<Robot> lista1 = new LinkedList<Robot>();
		lista1 = field.getRobotOrdinatiPerPosizione();
		assertSame(r, lista1.get(0));
	}

	@Test
	public void Test2RobotXdiverse() {
		Position p= new Position(0, 0);
		Position p1 = new Position(1,0);
		Robot r = new Walker(p);
		Robot r1 = new Walker(p1);
		field.addRobot(r1);
		field.addRobot(r);
		List<Robot> lista = new LinkedList<Robot>();
		lista = field.getRobotOrdinatiPerPosizione();
		assertSame(r, lista.get(0));
		assertSame(r1, lista.get(1));
	}

	@Test
	public void TestXugualiYdiverse() {
		Position p= new Position(0, 0);
		Position p3 = new Position(0,1);
		Robot r = new Walker(p);
		Robot r3 = new Chaser(p3);
		field.addRobot(r3);
		field.addRobot(r);
		List<Robot> lista = new LinkedList<Robot>();
		lista = field.getRobotOrdinatiPerPosizione();
		assertSame(r, lista.get(0));
		assertSame(r3, lista.get(1));
	}


}
