import java.text.DecimalFormat;
import java.util.List;

public class ExpressionParser {
    private String expression;
    private List<Double> listOfNumbers;
    private List<Character> listOfBinaryOperators;
    private BinaryOperatorExtractor binaryOperatorExtractor = new BinaryOperatorExtractor();
    private NumberExtractor numberExtractor = new NumberExtractor();
    private ArithmeticOperations arithmeticOperations = new ArithmeticOperations();

    public ExpressionParser() {}

    private String computeAnswer() {
        DecimalFormat decimalFormat = new DecimalFormat("0.######");
        String answer;

        listOfBinaryOperators = binaryOperatorExtractor.extractBinaryOperators(expression);
        listOfNumbers = numberExtractor.extractNumbers(expression);

        if (expression.charAt(0) == '-') {
            listOfBinaryOperators.remove(0);
        }

        arithmeticOperations.multiplicationAndDivision(listOfNumbers, listOfBinaryOperators);
        arithmeticOperations.additionAndSubtraction(listOfNumbers, listOfBinaryOperators);

        answer = String.valueOf(decimalFormat.format(listOfNumbers.get(0)));

        if (listOfNumbers.get(0) < 0) {
            return "-" + answer.substring(1, answer.length());
        }
        else {
            return answer;
        }
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getAnswer() {
        return computeAnswer();
    };
}
