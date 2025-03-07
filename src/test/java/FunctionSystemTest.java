import itmo.FunctionSystem;
import itmo.logarithm.Ln;
import itmo.logarithm.Log;
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
	public void testFunctionSystemLogAndLnMock() {
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
		
		
		assertEquals(38895.1454524, functionSystem.calculate(value1, log10Func, log3Func, log2Func), EPSILON);
		assertEquals(3542.2961591, functionSystem.calculate(value2, log10Func, log3Func, log2Func), EPSILON);
	}
	
	@Test
	public void testFunctionSystemLogMock() {
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
		
		assertEquals(38895.1454524, functionSystem.calculate(value1, log10Func, log3Func, log2Func), EPSILON);
		assertEquals(3542.2961591, functionSystem.calculate(value2, log10Func, log3Func, log2Func), EPSILON);
	}
	
	@Test
	public void testFunctionSystem() {
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
		
		assertEquals(38895.1454524, functionSystem.calculate(value1, log10Func, log3Func, log2Func), EPSILON);
		assertEquals(3542.2961591, functionSystem.calculate(value2, log10Func, log3Func, log2Func), EPSILON);
	}
}
