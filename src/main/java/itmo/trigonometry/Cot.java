package itmo.trigonometry;

public class Cot {
	private final Sin sinFunc;
	private final Cos cosFunc;
	
	public Cot(Sin sinFunc, Cos cosFunc) {
		this.sinFunc = sinFunc;
		this.cosFunc = cosFunc;
	}
	
	public double calculate(double x) {
		return cosFunc.calculate(x) / sinFunc.calculate(x);
	}
}
