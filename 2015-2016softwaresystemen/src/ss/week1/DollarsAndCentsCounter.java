package ss.week1;

public class DollarsAndCentsCounter {
	private int dollars;
	private int cents;
	
	public int dollars() {
		return dollars;
	}
	public int cents() {
		return cents;
	}

	public DollarsAndCentsCounter () {
		dollars = 0 ;
		cents = 0 ;
	}
	public void add (int Dol, int Cen) {
		dollars = (dollars + Dol) + ((cents + Cen) / 100);
		cents = ((cents + Cen) % 100) ;
	}
	
	public void reset () {
		dollars = 0;
		cents = 0;
	}
	
	public static void main(String[] args) {
	}

}
