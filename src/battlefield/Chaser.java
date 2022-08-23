package battlefield;

public class Chaser extends Robot{

//	private Position posizione;
//	private int longevita;
	
	public Chaser(Position p) {
		super(p);
	}
	
//	public Position getPosizione() {
//		return this.posizione;
//	}
//	
//	public int incrementaLongevita() {
//		return ++this.longevita;
//	}
//	
//	public int getLongevita() {
//		return this.longevita;
//	}
	@Override
	public void passo(Battlefield field) {
		Position nuova = this.decidiMossa(field);
		if (nuova!=null) {
			Robot clone = new Chaser(nuova);
			field.addRobot(clone);
		}
		this.incrementaLongevita();
	}
	
	public Position decidiMossa(Battlefield field) {
		Robot inseguito = cercaAvversario(field);
		if (inseguito==null) 
			return null; /* nessuno da inseguire: stai fermo */
		else return inseguito.getPosizione();
	}

	private Robot cercaAvversario(Battlefield field) {
		for(Position p : field.adiacenti(this.getPosizione())) {
			Robot vicino = field.getRobot(p);
			if (isAvversario(vicino)) {
				return vicino;
			}
		}
		return null;
	}

	private boolean isAvversario(Object avvistato) {
		return true ; /* è sicuramente un Walker??? per ora SI! */
	}

}

