import itmo.trigonometry.Cos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CosTest {
	private final double EPSILON = 0.0001;
	private final int accuracy = 6;
	
	@Test
	public void testCos() {
		double value1 = - Math.PI / 4;
		double value2 = - 5 * Math.PI / 3;
		
		Cos cosFunc = new Cos();
		
		assertEquals(-0.70711, cosFunc.calculate(value1), EPSILON);
		assertEquals(0.86603, cosFunc.calculate(value2), EPSILON);
	}
}
