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

        for (Map.Entry<Integer, Double> entry1 : polyMap1.entrySet()) {
            for (Map.Entry<Integer, Double> entry2 : polyMap2.entrySet()) {
                int exponent = entry1.getKey() + entry2.getKey();
                double coefficient = entry1.getValue() * entry2.getValue();

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

            result.put(exponent + 1, coefficient / (exponent + 1));
        }

        return result;
    }
}
