import itmo.logarithm.Ln;
import itmo.logarithm.Log;
import itmo.trigonometry.Cos;
import itmo.trigonometry.Cot;
import itmo.trigonometry.Sin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CotTest {
	private Sin sinMock;
	private Cos cosMock;
	private Cot cotFunc;
	private final double EPSILON = 0.001;
	
	
	@Test
	public void testCotWithSinAndCosMock() {
		double value1 = - Math.PI / 4;
		double value2 = - 5 * Math.PI / 3;
		
		sinMock = mock(Sin.class);
		cosMock = mock(Cos.class);
		
		when(sinMock.calculate(value1)).thenReturn(-0.70711);
		when(sinMock.calculate(value2)).thenReturn(0.86603);
		when(cosMock.calculate(value1)).thenReturn(0.70711);
		when(cosMock.calculate(value2)).thenReturn(0.50000);
		
		cotFunc = new Cot(sinMock, cosMock);
		
		assertEquals(-1.00000, cotFunc.calculate(value1), EPSILON);
		assertEquals(0.57735, cotFunc.calculate(value2), EPSILON);
	}
	
	@Test
	public void testCot() {
		double value1 = - Math.PI / 4;
		double value2 = - 5 * Math.PI / 3;
		
		Sin sinFunc = new Sin();
		Cos cosFunc = new Cos();
		
		cotFunc = new Cot(sinFunc, cosFunc);
		
		assertEquals(-1.00000, cotFunc.calculate(value1), EPSILON);
		assertEquals(0.57735, cotFunc.calculate(value2), EPSILON);
	}
}
