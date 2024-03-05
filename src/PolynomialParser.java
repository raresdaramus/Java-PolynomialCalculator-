import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolynomialParser {

    public static Polynomial parse(String input) {
        Polynomial polynomial = new Polynomial();

        // Remove spaces and normalize the input string
        String normalizedInput = input.replaceAll("\\s", "");

        // Use regular expression to match terms in the polynomial
        Matcher matcher = Pattern.compile("([-+]?(\\d+(\\.\\d*)?|\\.\\d+)?x(\\^(\\d+))?|[-+]?(\\d+(\\.\\d*)?|\\.\\d+))").matcher(normalizedInput);

        while (matcher.find()) {
            // Parse the matched term
            double coefficient = (matcher.group(2) != null && !matcher.group(2).isEmpty()) ?
                    Double.parseDouble(matcher.group(2)) : (normalizedInput.startsWith("-") ? -1.0 : 1.0);
            int exponent = (matcher.group(5) != null && !matcher.group(5).isEmpty()) ?
                    Integer.parseInt(matcher.group(5)) : 1;

            // Add the term to the polynomial
            polynomial.addTerm(exponent, coefficient);
        }

        return polynomial;
    }
}
