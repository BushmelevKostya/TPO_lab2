package itmo;

import itmo.logarithm.Log;
import itmo.trigonometry.Cot;
import itmo.trigonometry.Sec;

import static java.lang.Math.pow;

public class FunctionSystem {
	public double calculatePositive(double x, Log logFunc10, Log logFunc3, Log logFunc2) {
		return pow(pow(((logFunc10.calculate(x) * logFunc3.calculate(x)) * logFunc3.calculate(x)) + logFunc2.calculate(x), 2), 2);
	}
	
	public double calculateNegative(double x, Cot cotFunc, Sec secFunc) {
		return cotFunc.calculate(x) * secFunc.calculate(x);
	}
}
