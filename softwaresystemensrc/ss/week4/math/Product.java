package ss.week4.math;

public class Product implements Function {
	
	private Function f1;
	private Function f2;
	
	public Product(Function f1, Function f2) {
		this.f1 = f1;
		this.f2 = f2;
	}
	
	public double apply(double argument) {
		return f1.apply(argument) * f2.apply(argument);
	}
	
	public Function derivative() {
		return new Sum(new Product(f1.derivative(), f2), new Product(f2.derivative(), f1));
	}
	
	public String toString() {
		return "(" + f1.toString() + "*" + f2.toString() + ")";
	}
}