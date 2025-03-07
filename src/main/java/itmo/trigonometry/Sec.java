package itmo.trigonometry;

public class Sec {
	private final Cos cosFunc;
	
	public Sec(Cos cosFunc) {
		this.cosFunc = cosFunc;
	}
	
	public double calculate(double x) {
		return 1 / cosFunc.calculate(x);
	}
}
