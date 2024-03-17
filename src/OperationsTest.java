import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class OperationsTest {

    @Test
    public void testAddPolynomials() {
        Map<Integer, Double> terms1 = Map.of(2, 3.0, 1, 2.0, 0, -5.0); // 3x^2 + 2x - 5
        Map<Integer, Double> terms2 = Map.of(2, 1.0, 1, -2.0, 0, 5.0); // x^2 - 2x + 5
        Map<Integer, Double> expectedResult = Map.of(2, 4.0, 1, 0.0, 0, 0.0); // 4x^2

        Map<Integer, Double> actualResult = Operations.addPolynomials(terms1, terms2);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSubtractPolynomials() {
        Map<Integer, Double> terms1 = Map.of(2, 3.0, 1, 2.0, 0, -5.0); // 3x^2 + 2x - 5
        Map<Integer, Double> terms2 = Map.of(2, 1.0, 1, -2.0, 0, 5.0); // x^2 - 2x + 5
        Map<Integer, Double> expectedResult = Map.of(2, 2.0, 1, 4.0, 0, -10.0); // 2x^2 + 4x - 10

        Map<Integer, Double> actualResult = Operations.subtractPolynomials(terms1, terms2);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testMultiplyPolynomials() {
        Map<Integer, Double> terms1 = Map.of(2, 3.0, 1, 2.0, 0, -5.0); // 3x^2 + 2x - 5
        Map<Integer, Double> terms2 = Map.of(2, 1.0, 1, -2.0, 0, 5.0); // x^2 - 2x + 5
        Map<Integer, Double> expectedResult = Map.of(4, 3.0, 3, -4.0, 2, 6.0, 1, 20.0, 0, -25.0); // 3x^4 - 6x^3 + 7x^2 - 4x - 25

        Map<Integer, Double> actualResult = Operations.multiplyPolynomials(terms1, terms2);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testDerivative() {
        Map<Integer, Double> terms = Map.of(2, 3.0, 1, 2.0, 0, -5.0); // 3x^2 + 2x - 5
        Map<Integer, Double> expectedResult = Map.of(1, 6.0, 0, 2.0); // 6x + 2

        Map<Integer, Double> actualResult = Operations.derivative(terms);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIntegration() {
        Map<Integer, Double> terms = Map.of(2, 2.0, 1, 3.0); // 2x^2 + 3x
        Map<Integer, Double> expectedResult = Map.of(3, 0.666666666666666666, 2, 1.5); //0.(6)x^3 + 1.5x^2

        Map<Integer, Double> actualResult = Operations.integrate(terms);

        assertEquals(expectedResult, actualResult);
    }
}
