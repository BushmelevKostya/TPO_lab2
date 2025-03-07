import itmo.trigonometry.Cos;
import itmo.trigonometry.Sec;
import itmo.trigonometry.Sin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SinTest {
	private final double EPSILON = 0.0001;
	private final int accuracy = 6;
	
	@Test
	public void testSin() {
		double value1 = - Math.PI / 4;
		double value2 = - 5 * Math.PI / 3;
		
		Sin sinFunc = new Sin();
		
		assertEquals(-0.70711, sinFunc.calculate(value1), EPSILON);
		assertEquals(0.86603, sinFunc.calculate(value2), EPSILON);
	}
}
