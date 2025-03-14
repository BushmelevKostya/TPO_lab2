import itmo.FunctionSystem;
import itmo.logarithm.Ln;
import itmo.logarithm.Log;
import itmo.trigonometry.Cos;
import itmo.trigonometry.Cot;
import itmo.trigonometry.Sec;
import itmo.trigonometry.Sin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FunctionSystemTest {
	FunctionSystem functionSystem;
	private final double econst = Math.E;
	private final double EPSILON = 0.1;
	private final int accuracy = 7;
	
	@Test
	public void testFunctionSystemLogMock() {
		functionSystem = new FunctionSystem();
		
		double value1 = Math.pow(econst, 3);
		double value2 = 10;
		
		Log log10Func = mock(Log.class);
		Log log3Func = mock(Log.class);
		Log log2Func = mock(Log.class);
		
		when(log10Func.calculate(value1)).thenReturn(1.30288);
		when(log10Func.calculate(value2)).thenReturn(1.00000);
		when(log3Func.calculate(value1)).thenReturn(2.73072);
		when(log3Func.calculate(value2)).thenReturn(2.09590);
		when(log2Func.calculate(value1)).thenReturn(4.32809);
		when(log2Func.calculate(value2)).thenReturn(3.32192);
		
		
		assertEquals(38895.1454524, functionSystem.calculatePositive(value1, log10Func, log3Func, log2Func), EPSILON);
		assertEquals(3542.2961591, functionSystem.calculatePositive(value2, log10Func, log3Func, log2Func), EPSILON);
	}
	
	@Test
	public void testFunctionSystemLnMock() {
		functionSystem = new FunctionSystem();
		
		Ln lnMock = mock(Ln.class);
		
		double value1 = Math.pow(econst, 3);
		double value2 = 10;
		int base1 = 10;
		int base2 = 3;
		int base3 = 2;
		
		when(lnMock.calculate(value1)).thenReturn(3D);
		when(lnMock.calculate(value2)).thenReturn(4.60517);
		when(lnMock.calculate(base1)).thenReturn(2.30259);
		when(lnMock.calculate(base2)).thenReturn(1.09861);
		when(lnMock.calculate(base3)).thenReturn(0.69315);
		Log log10Func = new Log(base1, lnMock);
		Log log3Func = new Log(base2, lnMock);
		Log log2Func = new Log(base3, lnMock);
		
		assertEquals(38895.1454524, functionSystem.calculatePositive(value1, log10Func, log3Func, log2Func), EPSILON);
		assertEquals(3542.2961591, functionSystem.calculatePositive(value2, log10Func, log3Func, log2Func), EPSILON);
	}
	
	@ParameterizedTest
	@CsvSource({
			"0, 1",
			"0.00036, 1.1",
			"0.00054, 0.9",
			"3542.3, 0.1",
			"6.533, 0.4",
			"0.0794, 0.7",
			"1.573, 2",
			"3542.3, 10",
			"38370.9, 20",
	})
	public void testFunctionSystemPositive(double expected, double param) {
		functionSystem = new FunctionSystem();
		
		int base1 = 10;
		int base2 = 3;
		int base3 = 2;
		
		Ln lnFunc = new Ln(accuracy);
		Log log10Func = new Log(base1, lnFunc);
		Log log3Func = new Log(base2, lnFunc);
		Log log2Func = new Log(base3, lnFunc);
		
		assertEquals(expected, functionSystem.calculatePositive(param, log10Func, log3Func, log2Func), EPSILON);
	}
	
	@Test
	public void testFunctionSystemCotAndSecMock() {
		functionSystem = new FunctionSystem();
		
		double value1 = -Math.PI / 4;
		double value2 = -5 * Math.PI / 3;
		
		Cot cotFunc = mock(Cot.class);
		Sec secFunc = mock(Sec.class);
		
		when(cotFunc.calculate(value1)).thenReturn(-1.00000);
		when(cotFunc.calculate(value2)).thenReturn(0.57735);
		when(secFunc.calculate(value1)).thenReturn(1.41421);
		when(secFunc.calculate(value2)).thenReturn(2.00000);
		
		assertEquals(-1.41421, functionSystem.calculateNegative(value1, cotFunc, secFunc), EPSILON);
		assertEquals(1.15470, functionSystem.calculateNegative(value2, cotFunc, secFunc), EPSILON);
	}
	
	@Test
	public void testFunctionSystemCosAnsSinMock() {
		functionSystem = new FunctionSystem();
		
		Cos cosMock = mock(Cos.class);
		Sin sinMock = mock(Sin.class);
		
		double value1 = -Math.PI / 4;
		double value2 = -5 * Math.PI / 3;
		
		when(cosMock.calculate(value1)).thenReturn(0.70711);
		when(cosMock.calculate(value2)).thenReturn(0.50000);
		when(sinMock.calculate(value1)).thenReturn(-0.70711);
		when(sinMock.calculate(value2)).thenReturn(0.86603);
		
		Cot cotFunc = new Cot(sinMock, cosMock);
		Sec secFunc = new Sec(cosMock);
		
		assertEquals(-1.41421, functionSystem.calculateNegative(value1, cotFunc, secFunc), EPSILON);
		assertEquals(1.15470, functionSystem.calculateNegative(value2, cotFunc, secFunc), EPSILON);
	}
	
	@ParameterizedTest
	@CsvSource({
			"2, -3.66519",
			"3.8637, -9.68718",
			"5.75877, -15.88249",
			"-2, -0.52359",
			"-3.8637, -6.54498",
			"-5.75877, -12.74090",
			"1.1547, -5.23598",
			"2, -12.04277",
			"2.9238, -18.50049",
			"-1.1547, -2.09439",
			"-2, -8.90117",
			"-2.9238, -15.35889"
	})
	public void testFunctionSystemNegative(double expected, double param) {
		functionSystem = new FunctionSystem();
		
		Sin sinFunc = new Sin(accuracy);
		Cos cosFunc = new Cos(sinFunc);
		
		Cot cotFunc = new Cot(sinFunc, cosFunc);
		Sec secFunc = new Sec(cosFunc);
		
		assertEquals(expected, functionSystem.calculateNegative(param, cotFunc, secFunc), EPSILON);
	}
	
	@ParameterizedTest
	@ValueSource(doubles = {- Math.PI / 2, 3 * Math.PI / 2, - Math.PI, - 3 * Math.PI, 0})
	public void testFunctionSystemNegativeErrors(double param) {
		functionSystem = new FunctionSystem();
		
		Sin sinFunc = new Sin(accuracy);
		Cos cosFunc = new Cos(sinFunc);
		
		Cot cotFunc = new Cot(sinFunc, cosFunc);
		Sec secFunc = new Sec(cosFunc);
		
		assertThrows(ArithmeticException.class, () -> functionSystem.calculateNegative(param, cotFunc, secFunc));
	}
}
