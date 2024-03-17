import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolynomialParser {


    public static Polynomial parse(String input) {
        // Remove all whitespace characters from the input
        input = input.replaceAll("\\s", "");

        Polynomial polynomial = new Polynomial();

        // Use regular expression to match terms in the polynomial
        Matcher matcher = Pattern.compile("([-+]?(\\d+(\\.\\d*)?|\\.\\d+)?x(\\^(\\d+))?|[-+]?(\\d+(\\.\\d*)?|\\.\\d+))").matcher(input);

        while (matcher.find()) {
            // Parse the matched term

            double coefficient;
            if (matcher.group(2) != null && !matcher.group(2).isEmpty()) {
                coefficient = Double.parseDouble(matcher.group(2));

                // Check if the term has a negative sign
                if (matcher.group(1).startsWith("-")) {
                    coefficient *= -1.0;
                }
            } else {
                // If no coefficient is specified, default to -1.0 or 1.0 based on the presence of a leading "-"
                coefficient = (matcher.group().startsWith("-")) ? -1.0 : 1.0;
            }

            int exponent = (matcher.group(5) != null && !matcher.group(5).isEmpty()) ?
                    Integer.parseInt(matcher.group(5)) : 1;


            polynomial.addTerm(exponent, coefficient);
        }

        return polynomial;
    }
}
