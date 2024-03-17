import java.util.HashMap;
import java.util.Map;

public class Operations {

    public static Map<Integer, Double> addPolynomials(Map<Integer, Double> polyMap1, Map<Integer, Double> polyMap2) {
        Map<Integer, Double> result = new HashMap<>(polyMap1);

        for (Map.Entry<Integer, Double> entry : polyMap2.entrySet()) {
            int exponent = entry.getKey();
            double coefficient = entry.getValue();

            result.merge(exponent, coefficient, Double::sum);
        }

        return result;
    }

    public static Map<Integer, Double> subtractPolynomials(Map<Integer, Double> polyMap1, Map<Integer, Double> polyMap2) {
        Map<Integer, Double> result = new HashMap<>(polyMap1);

        for (Map.Entry<Integer, Double> entry : polyMap2.entrySet()) {
            int exponent = entry.getKey();
            double coefficient = entry.getValue();

            result.merge(exponent, -coefficient, Double::sum);
        }

        return result;
    }

    public static Map<Integer, Double> multiplyPolynomials(Map<Integer, Double> polyMap1, Map<Integer, Double> polyMap2) {
        Map<Integer, Double> result = new HashMap<>();

        for (Map.Entry<Integer, Double> term1 : polyMap1.entrySet()) {
            for (Map.Entry<Integer, Double> term2 : polyMap2.entrySet()) {
                int exponent = term1.getKey() + term2.getKey();
                double coefficient = term1.getValue() * term2.getValue();

                result.merge(exponent, coefficient, Double::sum);
            }
        }

        return result;
    }



    public static Map<Integer, Double> derivative(Map<Integer, Double> polyMap) {
        Map<Integer, Double> result = new HashMap<>();

        for (Map.Entry<Integer, Double> entry : polyMap.entrySet()) {
            int exponent = entry.getKey();
            double coefficient = entry.getValue();

            if (exponent > 0) {
                result.put(exponent - 1, exponent * coefficient);
            }
        }

        return result;
    }

    public static Map<Integer, Double> integrate(Map<Integer, Double> polyMap) {
        Map<Integer, Double> result = new HashMap<>();

        for (Map.Entry<Integer, Double> entry : polyMap.entrySet()) {
            int exponent = entry.getKey();
            double coefficient = entry.getValue();

            if (exponent == 0) {
                // For the constant term, the integral is the coefficient times x
                result.put(1, coefficient);
            } else {
                // For non-constant terms, increase the exponent by 1 and divide the coefficient by the new exponent
                result.put(exponent + 1, coefficient / (double)(exponent + 1));
            }
        }

        return result;
    }


    //implement division
}
