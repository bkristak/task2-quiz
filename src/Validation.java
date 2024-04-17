import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Validation {

    public static boolean validation (String inputToQuiz, HashMap<Character, Boolean> choiceMap) {
        StringBuilder correctAnswerBuilder = new StringBuilder();
        for (Map.Entry<Character, Boolean> entry : choiceMap.entrySet()) {
            char choiceID = entry.getKey();
            boolean isCorrect = entry.getValue();
            if (isCorrect) {
                correctAnswerBuilder.append(choiceID);
            }
        }

        if (correctAnswerBuilder.length() == inputToQuiz.length()) {
            int countCorrect = 0;
            for (int i = 0; i < correctAnswerBuilder.length(); i++) {
                char indexI = correctAnswerBuilder.charAt(i);
                for (int j = 0; j < inputToQuiz.length(); j++) {
                    char indexJ = inputToQuiz.charAt(j);
                    if (indexI == indexJ) {
                        countCorrect++;
                        break;
                    }
                }
            }
            return correctAnswerBuilder.length() == countCorrect;
        } else {
            return false;
        }

    }
}
