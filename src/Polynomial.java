import java.util.*;

public class Polynomial {
    private Map<Integer, Double> terms;

    public Polynomial() {
        terms = new HashMap<>();
    }

    public void addTerm(int exponent, double coefficient) {
        // If the exponent already exists, add the coefficients
        if (terms.containsKey(exponent)) {
            coefficient += terms.get(exponent);
        }

        // Update the result polynomial with the new coefficient
        terms.put(exponent, coefficient);
    }

    public Map<Integer, Double> getTerms() {
        // Sort the terms by exponent in descending order
        TreeMap<Integer, Double> sortedTerms = new TreeMap<>(Comparator.reverseOrder());
        sortedTerms.putAll(terms);
        return sortedTerms;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Map<Integer, Double> sortedTerms = getTerms();

        for (Map.Entry<Integer, Double> term : sortedTerms.entrySet()) {
            int exponent = term.getKey();
            double coefficient = term.getValue();
            result.append(coefficient).append("x^").append(exponent).append(" + ");
        }

        if (result.length() > 0) {
            result.delete(result.length() - 3, result.length()); // Remove the trailing " + "
        }

        return result.toString();
    }
}
