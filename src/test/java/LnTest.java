import itmo.logarithm.Ln;
import itmo.logarithm.Log;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LnTest {
	private Ln lnFunc;
	private final double econst = Math.E;
	private final double EPSILON = 0.01;
	private final int accuracy = 4;
	
	@Test
	public void testLn() {
		double value1 = Math.pow(econst, 3);
		double value2 = 10;
		
		lnFunc = new Ln(accuracy);
		
		assertEquals(3, lnFunc.calculate(value1), EPSILON);
		assertEquals(2.303, lnFunc.calculate(value2), EPSILON);
	}
}
