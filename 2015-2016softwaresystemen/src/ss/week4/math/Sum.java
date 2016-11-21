package ss.week4.math;

public class Sum implements Function, Integradable {
	
	private Function f1;
	private Function f2;
	
	public Sum(Function f1, Function f2) {
		this.f1 = f1;
		this.f2 = f2;
	}
	
	public double apply(double argument) {
		return f1.apply(argument) + f2.apply(argument);
	}
	
	public Sum derivative() {
		return new Sum(f1.derivative(), f2.derivative());
	}
	
	public String toString() {
		return "(" + f1.toString() + "+" + f2.toString() + ")";
	}
	public Function Integrad() {
		if (f1 instanceof Integradable && f2 instanceof Integradable) {
			return new Sum(((Integradable) f1).Integrad(), ((Integradable) f2).Integrad());
		}
		return null;
	}
}
