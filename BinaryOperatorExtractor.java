import java.util.ArrayList;
import java.util.List;

public class BinaryOperatorExtractor {
    public BinaryOperatorExtractor() {}

    public List<Character> extractBinaryOperators(String expression) {
        List<Character> listOfBinaryOperators = new ArrayList<Character>();

        for (int i = 0; i < expression.length(); i++) {
            switch (expression.charAt(i)) {
                case '+':
                    listOfBinaryOperators.add('+');
                    break;
                case '-':
                    listOfBinaryOperators.add('-');
                    break;
                case '*':
                    listOfBinaryOperators.add('*');
                    break;
                case '/':
                    listOfBinaryOperators.add('/');
                    break;
            }
        }

        return listOfBinaryOperators;
    }
}
