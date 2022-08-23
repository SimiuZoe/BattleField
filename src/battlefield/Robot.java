package battlefield;

public abstract class Robot implements Comparable<Robot> {
	private Position posizione;
	private int longevita;
	
	public Robot(Position p) {
		this.posizione = p;
		this.longevita = 0 ;
	}
	public Position getPosizione() {
		return this.posizione;
	}
	
	public int incrementaLongevita() {
		return ++this.longevita;
	}
	
	public int getLongevita() {
		return this.longevita;
	}
	
	public abstract void passo(Battlefield field);
	
	public int hashCode() {
		return posizione.hashCode()+this.getLongevita();
	}
	
	public boolean equals(Object o) {
		if(o==null || this.getClass()!=o.getClass()) {
			return false;
		}
		Robot r =(Robot)o;
		return this.getPosizione().equals(r.getPosizione()) && this.getLongevita()==r.getLongevita();
	}
	public int compareTo(Robot r) {
		if(this.getLongevita()==r.getLongevita()) {
			if(this.getPosizione().getX()== r.getPosizione().getX()) {
				return this.getPosizione().getY()-r.getPosizione().getY(); 
			} else {
				return this.getPosizione().getX()-r.getPosizione().getX();
			}
		}else {
		return this.getLongevita()-r.getLongevita();
		}
	}
}

