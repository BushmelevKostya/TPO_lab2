package itmo;

import itmo.logarithm.Ln;
import itmo.logarithm.Log;

import static java.lang.Math.pow;

public class FunctionSystem {
	public double calculate(double x, Log logFunc10, Log logFunc3, Log logFunc2) {
		double ans = 0;
		if (x > 0) {
			ans = pow(pow(((logFunc10.calculate(x) * logFunc3.calculate(x)) * logFunc3.calculate(x)) + logFunc2.calculate(x), 2), 2);
		}
		return ans;
	}
}
