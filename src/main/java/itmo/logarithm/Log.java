package itmo.logarithm;

public class Log {
	private final int base;
	private final Ln lnFunc;
	
	public Log(int base, Ln lnFunc) {
		this.base = base;
		this.lnFunc = lnFunc;
	}
	
	public double calculate(double x) {
		return lnFunc.calculate(x) / lnFunc.calculate(base);
	}
}
