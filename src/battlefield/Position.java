package battlefield;


/*
 * Da sistemare. Vedi PositionTest.
 * (vedi DOMANDA 1)
 */
public class Position {
	
	private int x, y;

	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
		
	public String toString() {
		return this.x+"-"+this.y;
	}
	
	public boolean equals(Object o) {
		if(o.getClass()==null || this.getClass()!=o.getClass()) {
			return false;
		}
		Position p =(Position) o;
		return this.getX()==p.getX() && this.getY()==p.getY();
	}
	
	public int hashCode() {
		return this.getX()+this.getY();
	}
}