package itmo.logarithm;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class Ln {
	private final int accuracy;
	
	public Ln(int accuracy) {
		this.accuracy = accuracy;
	}
	
	public double calculate(double x) {
		if (x <= 0) throw new IllegalArgumentException("x must be positive");
		else if (x == 1) return 0;
		double ans = 0;
		double temp;
		int k = 0;
		do {
			temp = 2 * pow(x - 1, 2 * k + 1) / (2 * k + 1) / pow(x + 1, 2 * k + 1);
			if (Double.isNaN(x) || Double.isInfinite(x)) throw new IllegalArgumentException("Too big accuracy with too big argument");
			ans += temp;
			k++;
		} while (abs(temp) >= pow(10, -this.accuracy));
		return ans;
	}
}
