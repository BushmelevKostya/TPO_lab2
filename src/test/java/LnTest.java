import itmo.logarithm.Ln;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LnTest {
	private Ln lnFunc;
	private final double econst = Math.E;
	private final double EPSILON = 0.0001;
	private final int accuracy = 6;
	
	@Test
	public void testLn() {
		double value1 = Math.pow(econst, 3);
		double value2 = 10;
		double value3 = -5;
		
		lnFunc = new Ln(accuracy);
		
		assertEquals(3, lnFunc.calculate(value1), EPSILON);
		assertEquals(2.30259, lnFunc.calculate(value2), EPSILON);
		assertThrows(IllegalArgumentException.class, () -> lnFunc.calculate(value3)); // проверка критической точки ln(x) > 0
	}
}
