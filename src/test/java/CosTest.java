import itmo.trigonometry.Cos;
import itmo.trigonometry.Sin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CosTest {
	private final double EPSILON = 0.0001;
	private final int accuracy = 6;
	
	@Test
	public void testCos() {
		double value1 = - Math.PI / 4;
		double value2 = - 5 * Math.PI / 3;
		double value3 = Math.PI / 2; //Проверка критической точки знак косинуса
		
		Sin sinFunc = new Sin(accuracy);
		Cos cosFunc = new Cos(sinFunc);
		
		assertEquals(0.70711, cosFunc.calculate(value1), EPSILON);
		assertEquals(0.50000, cosFunc.calculate(value2), EPSILON);
		assertEquals(0.0, cosFunc.calculate(value3), EPSILON);
	}
}
