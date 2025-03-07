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

public class SecTest {
	private Cos cosMock;
	private Sec secFunc;
	private final double EPSILON = 0.001;
	
	
	@Test
	public void testSecWithCosMock() {
		double value1 = - Math.PI / 4;
		double value2 = - 5 * Math.PI / 3;
		
		cosMock = mock(Cos.class);
		
		when(cosMock.calculate(value1)).thenReturn(0.70711);
		when(cosMock.calculate(value2)).thenReturn(0.50000);
		
		secFunc = new Sec(cosMock);
		
		assertEquals(1.41421, secFunc.calculate(value1), EPSILON);
		assertEquals(2.00000, secFunc.calculate(value2), EPSILON);
	}
	
	@Test
	public void testSec() {
		double value1 = - Math.PI / 4;
		double value2 = - 5 * Math.PI / 3;
		
		Cos cosFunc = new Cos();
		
		secFunc = new Sec(cosFunc);
		
		assertEquals(1.41421, secFunc.calculate(value1), EPSILON);
		assertEquals(2.00000, secFunc.calculate(value2), EPSILON);
	}
}
