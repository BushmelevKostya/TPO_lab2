import itmo.logarithm.Ln;
import itmo.logarithm.Log;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LnTest {
	private Ln lnMock;
	private Log log;
	private final double econst = Math.E;
	private final double EPSILON = 0.001;


	@Test
	public void testLog10() {
		int base = 10;
		double value1 = Math.pow(econst, 3);
		double value2 = 100;
		
		lnMock = mock(Ln.class);
		when(lnMock.calculate(value1)).thenReturn(3D);
		when(lnMock.calculate(value2)).thenReturn(4.60517);
		when(lnMock.calculate(base)).thenReturn(2.30259);
		log = new Log(base, lnMock);
		
		assertEquals(1.303, log.calculate(value1), EPSILON);
		assertEquals(2, log.calculate(value2), EPSILON);
	}
}
