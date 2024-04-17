import java.util.ArrayList;

public class Choice {

    private String choiceText;
    private boolean isCorrect;

    public Choice(String initChoiceText, boolean initIsCorrect) {
        this.choiceText = initChoiceText;
        this.isCorrect = initIsCorrect;
    }

    public String getChoiceText() {
        return this.choiceText;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

}
