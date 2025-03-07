import itmo.FunctionSystem;
import itmo.logarithm.Ln;
import itmo.logarithm.Log;
import itmo.trigonometry.Cos;
import itmo.trigonometry.Cot;
import itmo.trigonometry.Sec;
import itmo.trigonometry.Sin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
	
	@Test
	public void testFunctionSystemPositive() {
		functionSystem = new FunctionSystem();
		
		double value1 = Math.pow(econst, 3);
		double value2 = 10;
		int base1 = 10;
		int base2 = 3;
		int base3 = 2;
		
		Ln lnFunc = new Ln(accuracy);
		Log log10Func = new Log(base1, lnFunc);
		Log log3Func = new Log(base2, lnFunc);
		Log log2Func = new Log(base3, lnFunc);
		
		assertEquals(38895.1454524, functionSystem.calculatePositive(value1, log10Func, log3Func, log2Func), EPSILON);
		assertEquals(3542.2961591, functionSystem.calculatePositive(value2, log10Func, log3Func, log2Func), EPSILON);
	}
	
	@Test
	public void testFunctionSystemCotAndSecMock() {
		functionSystem = new FunctionSystem();
		
		double value1 = - Math.PI / 4;
		double value2 = - 5 * Math.PI / 3;
		
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
		
		double value1 = - Math.PI / 4;
		double value2 = - 5 * Math.PI / 3;
		
		when(cosMock.calculate(value1)).thenReturn(0.70711);
		when(cosMock.calculate(value2)).thenReturn(0.50000);
		when(sinMock.calculate(value1)).thenReturn(-0.70711);
		when(sinMock.calculate(value2)).thenReturn(0.86603);

		Cot cotFunc = new Cot(sinMock, cosMock);
		Sec secFunc = new Sec(cosMock);
		
		assertEquals(-1.41421, functionSystem.calculateNegative(value1, cotFunc, secFunc), EPSILON);
		assertEquals(1.15470, functionSystem.calculateNegative(value2, cotFunc, secFunc), EPSILON);
	}
	
	@Test
	public void testFunctionSystemNegative() {
		functionSystem = new FunctionSystem();
		
		Sin sinFunc = new Sin(accuracy);
		Cos cosFunc = new Cos(sinFunc);
		
		double value1 = - Math.PI / 4;
		double value2 = - 5 * Math.PI / 3;
		
		Cot cotFunc = new Cot(sinFunc, cosFunc);
		Sec secFunc = new Sec(cosFunc);
		
		assertEquals(-1.41421, functionSystem.calculateNegative(value1, cotFunc, secFunc), EPSILON);
		assertEquals(1.15470, functionSystem.calculateNegative(value2, cotFunc, secFunc), EPSILON);
	}}
