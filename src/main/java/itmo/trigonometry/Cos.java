package itmo.trigonometry;

import static java.lang.Math.*;

public class Cos {
	private final Sin sinFunc;
	
	public Cos(Sin sinFunc) {
		this.sinFunc = sinFunc;
	}
	
	public double calculate(double x) {
		double sinValue = sinFunc.calculate(x);
		double cosValue = sqrt(1 - pow(sinValue, 2));
		
		if ((x % (2 * Math.PI)) > Math.PI / 2 && (x % (2 * Math.PI)) < 3 * Math.PI / 2) {
			cosValue = -cosValue;
		}
		
		return cosValue;
	}
}
