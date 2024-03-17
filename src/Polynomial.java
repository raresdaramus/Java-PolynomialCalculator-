import java.util.*;

public class Polynomial {
    private Map<Integer, Double> terms;

    public Polynomial() {
        terms = new HashMap<>();
    }

    public Polynomial(Map<Integer, Double> terms) {
        this.terms = new HashMap<>(terms);
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
        return terms;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        // Sort the terms by exponent in descending order
        TreeMap<Integer, Double> sortedTerms = new TreeMap<>(Comparator.reverseOrder());
        sortedTerms.putAll(terms);

        for (Map.Entry<Integer, Double> term : sortedTerms.entrySet()) {
            int exponent = term.getKey();
            double coefficient = term.getValue();

            if (coefficient == 0.0)
                result.append("");
            else {
                if (result.length() > 0) {
                    if (coefficient >= 0) {
                        result.append(" + ");
                    } else {
                        result.append(" - ");
                        coefficient = Math.abs(coefficient);
                    }
                }

                result.append(coefficient);

                if (exponent > 0) {
                    result.append("x^").append(exponent);
                }
            }
        }

        return result.toString();
    }



}
