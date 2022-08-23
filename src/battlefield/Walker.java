package battlefield;


public class Walker extends Robot{

//	private Position posizione;
//	private int longevita;
	
	public Walker(Position p) {
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
		Position nuova = this.decidiDoveAndare(field);
		if (nuova!=null) {
			Walker clone = new Walker(nuova);
			field.addRobot(clone);
		}
		this.incrementaLongevita();
	}
	
	public Position decidiDoveAndare(Battlefield field) {
		Position corrente = this.getPosizione();
		Position libera = field.posizioneLiberaVicino(corrente);
		return libera; // verso una posizione libera
					   // tutto occupato: fermo
	}
}

