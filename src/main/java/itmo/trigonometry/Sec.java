package itmo.trigonometry;

public class Sec {
	private final Cos cosFunc;
	private static final double EPSILON = 0.001;
	
	public Sec(Cos cosFunc) {
		this.cosFunc = cosFunc;
	}
	
	public double calculate(double x) {
		double cosValue = cosFunc.calculate(x);
		if (Math.abs(cosValue) < EPSILON) {
			throw new ArithmeticException("Значение косинуса равно 0");
		}
		
		return 1 / cosValue;
	}
}
