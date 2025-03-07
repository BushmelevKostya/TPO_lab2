package itmo.trigonometry;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class Sin {
	private final int accuracy;
	
	public Sin(int accuracy) {
		this.accuracy = accuracy;
	}
	
	public Double calculate(double x) {
		x = x % (2 * Math.PI);
		if (abs(x % Math.PI) < 1e-10) {
			return 0.0;
		}
		
		double ans = 0;
		double temp;
		int k = 0;
		do {
			temp = pow(-1, k) * pow(x, 2 * k + 1) / factorial(2 * k + 1);
			if (Double.isInfinite(temp)) break;
			ans += temp;
			k++;
		} while (abs(temp) >= pow(10, -this.accuracy));
		return ans;
	}
	
	private double factorial(int n) {
		if (n < 0) throw new IllegalArgumentException("n должен быть неотрицательным");
		double result = 1.0;
		for (int i = 2; i <= n; i++) {
			result *= i;
			if (Double.isInfinite(result)) {
				throw new ArithmeticException("Переполнение факториала");
			}
		}
		return result;
	}
}
