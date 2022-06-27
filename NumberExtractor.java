import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberExtractor {
    public NumberExtractor() {}

    public List<Double> extractNumbers(String expression) {
        List<Double> listOfNumbers = new ArrayList<Double>();
        Pattern numberPattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        Matcher matcher = numberPattern.matcher(expression);

        while (matcher.find()) {
            listOfNumbers.add(Double.valueOf(matcher.group()));
        }

        if (listOfNumbers.size() > 0) {
            for (int i = 1; i < listOfNumbers.size(); i++) {
                if (listOfNumbers.get(i) < 0) {
                    listOfNumbers.set(i, (listOfNumbers.get(i) * (-1)));
                }
            }
        }

        return listOfNumbers;
    }
}
