package battlefield;

import java.util.Comparator;

public class ComparaPosizione implements Comparator<Robot> {
	public int compare(Robot r1, Robot r2) {
		if(r1.getPosizione().getX()== r2.getPosizione().getX()) {
			return r1.getPosizione().getY()-r2.getPosizione().getY(); 
		} else {
			return r1.getPosizione().getX()-r2.getPosizione().getX();
		}
	}

}
