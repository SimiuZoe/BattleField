package battlefield;

import java.util.*;

public class Battlefield {

	static final private Class<?>[] TIPOLOGIE = { Walker.class, Chaser.class } ;

	static final private int NUMERO_TIPOLOGIE = TIPOLOGIE.length;

	static final private double OCCUPAZIONE_INIZIALE = 0.01d; // 1%

	private int dim;

	private Random random;
	
	private Map<Position, Robot> posizione2robot;
//	private Map<Position, Chaser> posizione2chaser;

	public Battlefield(int dimensione) {
		this.dim = dimensione;
		this.posizione2robot = new HashMap<>();
//		this.posizione2chaser = new HashMap<>();
		this.random = new Random();
	}

	public void addRobot(Robot r) {
		posizione2robot.put(r.getPosizione(), r);
	}

//	public void addChaser(Chaser c) {
//		posizione2chaser.put(c.getPosizione(), c);
//	}

	public Robot getRobot(Position p) {
		return posizione2robot.get(p);
	}

//	public Chaser getChaser(Position p) {
//		return posizione2chaser.get(p);
//	}

	public Collection<Robot> getAllRobots() {
		return this.posizione2robot.values();
	}
//
//	public Collection<Chaser> getAllChasers() {
//		return this.posizione2chaser.values();
//	}

	@SuppressWarnings("rawtypes")
	public Map<Class, Set<Robot>> raggruppaRobotPerTipo() {
		Map<Class, Set<Robot>> mappa = new HashMap<Class,Set<Robot>>();
		for(Robot r:posizione2robot.values()) {
		if(mappa.containsKey(r.getClass())) {
			mappa.get(r.getClass()).add(r);
		} else {
			Set<Robot> insieme = new HashSet<Robot>();
			insieme.add(r);
			mappa.put(r.getClass(), insieme);
		}
		}
		
		return mappa;
	}
	
	public List<Robot> getRobotOrdinatiPerPosizione() {
		// (vedi DOMANDA 4)
		List<Robot> robotOrdinati = new LinkedList<Robot>();
		for(Robot r : posizione2robot.values()) {
			robotOrdinati.add(r);
		}
		Collections.sort(robotOrdinati, new ComparaPosizione());
		
		return robotOrdinati;
	}
	
	public SortedSet<Robot> getRobotOrdinatiPerLongevita() {
		// (vedi DOMANDA 6)
		SortedSet<Robot> robotOrdinati = new TreeSet<Robot>();
		for(Robot r: posizione2robot.values()) {
					robotOrdinati.add(r);
				}
//		Collections.sort(robotOrdinati);
		return robotOrdinati;
	}
	
	public List<Position> adiacenti(Position perno) {
		final List<Position> adiacenti = new LinkedList<>();
		int x = perno.getX();
		int y = perno.getY();

		for(int i = -1; i<2; i++) {
			for(int j = -1; j<2; j++) {
				Position adiacente = new Position(x+i, y+j);
				if (inCampo(adiacente))
					adiacenti.add(adiacente);
			}
		}
		adiacenti.remove(perno);  // coincidono: quindi non sono adiacenti
		
		Collections.shuffle(adiacenti); /* ordine casuale */
		return adiacenti;
	}

	private boolean inCampo(Position p) {
		return  p.getX()>=0 && p.getX()<this.dim && 
				p.getY()>=0 && p.getY()<this.dim  ;
				
	} 

	public Position posizioneLiberaVicino(Position posizione) {
		for(Position p : this.adiacenti(posizione)) {
			if (this.isLibera(p)) {
				return p;
			}
		}
		return null;
	}

	public boolean isLibera(Position posizione) {
		return ( this.getRobot(posizione)==null);
	}

	public int getDimensione() {
		return this.dim;
	}

	public void riempi() {
		long numeroIniziale = Math.round(OCCUPAZIONE_INIZIALE * dim * dim);
		for(int i=0 ; i<numeroIniziale; i++) {
			int x = this.random.nextInt(this.dim);
			int y = this.random.nextInt(this.dim);
			Position posizione = new Position(x, y);
			if (this.isLibera(posizione)) {
				switch (this.random.nextInt(NUMERO_TIPOLOGIE)) {
				case 0: Robot chaser = new Chaser(posizione);
						this.addRobot(chaser);
				break;
				case 1: Robot walker = new Walker(posizione);
						this.addRobot(walker);
				break;
				//case: NUMERO_TIPOLOGIE-1...
				default: throw new IllegalStateException();
				} 
			}
		}
	}

}
