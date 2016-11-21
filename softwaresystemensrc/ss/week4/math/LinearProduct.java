package ss.week4.math;

public class LinearProduct extends Product implements Integradable {
	
	private Function f1;
	private Function f2;
	
	public LinearProduct(Function f1, Function f2) {
		super(f1, f2);
		this.f1 = f1;
		this.f2 = f2;
	}
	public Function derivative(){
		return new LinearProduct(f1.derivative(), f2.derivative());
	}
	
	public Function Integrad() {
		if (f1 instanceof Integradable && f2 instanceof Constant) {
			return new LinearProduct(((Integradable) f1).Integrad(), (Constant) f2);
		}
		return null;
	}
}