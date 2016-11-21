package ss.week4.math;

public class Exponent implements Function, Integradable {
	private double exp;
	
	public Exponent (double exp) {
		this.exp = exp;
		
	}
	
	public double apply(double x) {
		double result = 1.0;
		for (int i = 1; i <= exp; i++){
			result = result * x;
		}
		return result;
	}

	public Function derivative() {
		return new LinearProduct(new Exponent(exp-1), new Constant(exp));
	}
	
	public String toString() {
		return "(x^" + exp + ")";
	}

	public Function Integrad() {
		return new LinearProduct(new Exponent(exp+1), new Constant(1/(exp+1)));
	}
}