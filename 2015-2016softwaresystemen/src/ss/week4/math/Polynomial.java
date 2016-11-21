package ss.week4.math;

import ss.week4.math.Function;
import ss.week4.math.Integradable;
import ss.week4.math.Sum;

public class Polynomial implements Function, Integradable {

	private double[] func;
	private Function[] functions;
	
	public Polynomial(double[] func){
		this.func = func;
	}
	public Polynomial(Function[] func1){
		this.functions = func1;
	}	
	
	public double apply(double argument) {
		double result = 0;
		for(int a=func.length-1, n=0; a<func.length && n<func.length; a= a-1, n= n+1){
			result = result + (func[a] * new Exponent(n).apply(argument));
		}
		return result;
	}
	
	public Function derivative() {
		Function sum = new Sum(functions[functions.length-1], new Constant(1.0));
		for(int a=functions.length-1, n=2; a<functions.length && n<functions.length; a= a-1, n= n+1){
			sum = new Sum(sum, new LinearProduct(new LinearProduct(functions[a], functions[n-2]), new Exponent(n-1)));
		}
		return sum;
	}

	public Function Integrad() {
		Function inte = new Constant(0.0);
		for (int i = 0; i < func.length; i++) {
			inte = new Sum(inte, new LinearProduct(new Constant(func[i]/(i+1)), new Exponent(i+1)));
			
		}
		return inte;
	}
}