package ss.week4.math;

public class Constant implements Function, Integradable {
    
    private double value;
    
    public Constant(double value) {
        this.value = value;
    }

    public double apply(double argument) {
        return value;
    }

    public Function derivative() {
        return new Constant(0);
    }
    
    public String toString() {
        return Double.toString(value);
    }
    
	public Function Integrad() {
		return new LinearProduct(new Exponent(1), this);
	}
}

