import java.awt.*;
import java.util.ArrayList;

public class Question {

    private String questionText;
    private ArrayList<Choice> choices;

    public Question(String initQuestionText) {
        this.questionText = initQuestionText;
        this.choices = new ArrayList<>();
    }

    public String getQuestionText() {
        return this.questionText;
    }

    public ArrayList<Choice> getChoices() {
        return choices;
    }


    public void addChoice (Choice choice) {
        choices.add(choice);
    }


    public ArrayList<Choice> getCorrectChoices() {
        ArrayList<Choice> correctChoices = new ArrayList<>();
        for (Choice choice : choices) {
            if (choice.isCorrect()) {
                correctChoices.add(choice);
            }
        }
        return correctChoices;
    }

}
