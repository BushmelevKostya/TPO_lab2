package itmo.trigonometry;

public class Cot {
	private final Sin sinFunc;
	private final Cos cosFunc;
	
	public Cot(Sin sinFunc, Cos cosFunc) {
		this.sinFunc = sinFunc;
		this.cosFunc = cosFunc;
	}
	
	public double calculate(double x) {
		double res1 = cosFunc.calculate(x);
		double res2 = sinFunc.calculate(x);
		if (res2 == 0.0) {
			throw new ArithmeticException("Invalid argument");
		}
		return res1 / res2;
	}
}
