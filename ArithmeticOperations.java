import java.util.List;

public class ArithmeticOperations {
    public ArithmeticOperations () {}

    public List<Double> additionAndSubtraction(List<Double> listOfNumbers, List<Character> listOfBinaryOperators) {
        for (int i = 0; i < listOfBinaryOperators.size(); i++) {
            switch (listOfBinaryOperators.get(i)) {
                case '+':
                    listOfNumbers.set(i, listOfNumbers.get(i) + listOfNumbers.get(i + 1));
                    listOfNumbers.remove(i + 1);
                    listOfBinaryOperators.remove(i);
                    i--;
                    break;
                case '-':
                    listOfNumbers.set(i, listOfNumbers.get(i) - listOfNumbers.get(i + 1));
                    listOfNumbers.remove(i + 1);
                    listOfBinaryOperators.remove(i);
                    i--;
                    break;
            }
        }

        return listOfNumbers;
    }

    public List<Double> multiplicationAndDivision(List<Double> listOfNumbers, List<Character> listOfBinaryOperators) {
        for (int i = 0; i < listOfBinaryOperators.size(); i++) {
            switch (listOfBinaryOperators.get(i)) {
                case '*':
                    listOfNumbers.set(i, listOfNumbers.get(i) * listOfNumbers.get(i + 1));
                    listOfNumbers.remove(i + 1);
                    listOfBinaryOperators.remove(i);
                    i--;
                    break;
                case '/':
                    listOfNumbers.set(i, listOfNumbers.get(i) / listOfNumbers.get(i + 1));
                    listOfNumbers.remove(i + 1);
                    listOfBinaryOperators.remove(i);
                    i--;
                    break;
            }
        }

        return listOfNumbers;
    }
}
