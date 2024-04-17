import java.util.ArrayList;
import java.util.Random;

public class Quiz {
    private ArrayList<Question> questions;
//    private ArrayList<Question> randomQuestion;
    public static final int MIN_QUESTION = 5;
    public static final int MAX_QUESTION = 16;
    private int maxQuestion;
    private int userScore;

    String userQuizInput;

    public Quiz (){
        this.maxQuestion = MAX_QUESTION;
        this.userScore = 0;
        questions = new ArrayList<>();
        initializeQuestions();
    }

    public int getUserScore () {
        return this.userScore;
    }

    public void setMaxQuestion(int newMaxQuestion) {
        this.maxQuestion = newMaxQuestion;
    }

    public ArrayList<Question> getQuestions() {
        return this.questions;
    }

    public String getUserQuizInput() {
        return this.userQuizInput;
    }

    public void setUserQuizInput(String newUserQuizInput) {
        this.userQuizInput = newUserQuizInput;
    }

    public void setUserScore (int newUserScore) {
        this.userScore = newUserScore;
    }

    public ArrayList<Question> randomQuizQuestions (ArrayList<Question> questions) {
        ArrayList<Question> randomQuestions = new ArrayList<>();
        Random random = new Random();
        int totalQuestions = questions.size();
        int[] randomArray = new int[maxQuestion];
        boolean[] selected = new boolean[totalQuestions];

        for (int i = 0; i < maxQuestion; i++) {
            int randomIndex;
            do {
                randomIndex = random.nextInt(totalQuestions);
            } while (selected[randomIndex]);

            randomArray[i] = randomIndex;
            selected[randomIndex] = true;
        }

        for (int index : randomArray) {
            randomQuestions.add(questions.get(index));
        }
        return randomQuestions;
    }



    private void initializeQuestions() {
        Question question1 = new Question("When was the NHL founded?");
        question1.addChoice(new Choice("November 26, 1901", false));
        question1.addChoice(new Choice("November 26, 1917", true));
        question1.addChoice(new Choice("November 26, 1924", false));
        questions.add(question1);

        Question question2 = new Question("What was the first team from the United States to join the NHL?");
        question2.addChoice(new Choice("Boston Bruins", true));
        question2.addChoice(new Choice("New York Rangers", false));
        question2.addChoice(new Choice("Chicago Black Hawks", false));
        question2.addChoice(new Choice("Detroit Red Wings", false));
        questions.add(question2);

        Question question3 = new Question("Who holds the NHL record for the most career points?");
        question3.addChoice(new Choice("Mario Lemieux", false));
        question3.addChoice(new Choice("Jaromir Jagr", false));
        question3.addChoice(new Choice("Wayne Gretzky", true));
        questions.add(question3);

        Question question4 = new Question("Which team has won the most Stanley Cup championships?");
        question4.addChoice(new Choice("Montreal Canadiens", true));
        question4.addChoice(new Choice("Boston Bruins", false));
        question4.addChoice(new Choice("Toronto Maple Leafs", false));
        question4.addChoice(new Choice("Detroit Red Wings", false));
        questions.add(question4);

        Question question5 = new Question("Which team from below is among original six? (*multiple correct answers)");
        question5.addChoice(new Choice("Montreal Canadiens", true));
        question5.addChoice(new Choice("Boston Bruins", true));
        question5.addChoice(new Choice("Toronto Maple Leafs", true));
        question5.addChoice(new Choice("Detroit Red Wings", true));
        question5.addChoice(new Choice("New York Rangers", true));
        question5.addChoice(new Choice("Chicago Black Hawks", true));
        questions.add(question5);

        Question question6 = new Question("Who was the first American team to win the Stanley Cup?");
        question6.addChoice(new Choice("Boston Bruins", true));
        question6.addChoice(new Choice("Detroit Red Wings", false));
        question6.addChoice(new Choice("New York Rangers", false));
        question6.addChoice(new Choice("Chicago Black Hawks", false));
        questions.add(question6);

        Question question7 = new Question("Which team has won the Stanley Cup three years in a row? (* multiple correct answers)");
        question7.addChoice(new Choice("Montreal Canadiens", true));
        question7.addChoice(new Choice("Detroit Red Wings", false));
        question7.addChoice(new Choice("New York Rangers", false));
        question7.addChoice(new Choice("New York Islanders", true));
        question7.addChoice(new Choice("Toronto Maple Leads", true));
        questions.add(question7);

        Question question8 = new Question("Which arena has the most Stanley Cup championships won on its ice?");
        question8.addChoice(new Choice("The Boston Garden in Boston, MA", true));
        question8.addChoice(new Choice("Madison Square Garden in New York City", false));
        question8.addChoice(new Choice("The Bell Centre in Montreal, Quebec", false));
        questions.add(question8);

        Question question9 = new Question("Who is the majority owner of the NHL's Boston Bruins?");
        question9.addChoice(new Choice("Rocky Wirtz", false));
        question9.addChoice(new Choice("Daryl Katz", false));
        question9.addChoice(new Choice("Ron Burkle and Mario Lemieux", false));
        question9.addChoice(new Choice("Jeremy Jacobs", true));
        questions.add(question9);

        Question question10 = new Question("Who is the NHL's all-time leader in wins by a goaltender? (691 wins) ");
        question10.addChoice(new Choice("Dominik Hasek", false));
        question10.addChoice(new Choice("Ron Hextall", false));
        question10.addChoice(new Choice("Martin Brodeur", true));
        question10.addChoice(new Choice("Patrick Roy", false));
        questions.add(question10);

        Question question11 = new Question("Who is the goaltender who set the record for the longest shutout streak in NHL history?");
        question11.addChoice(new Choice("Ed Belfour", false));
        question11.addChoice(new Choice("Brian Boucher", true));
        question11.addChoice(new Choice("Martin Brodeur", false));
        question11.addChoice(new Choice("Patrick Roy", false));
        questions.add(question11);

        Question question12 = new Question("Who is the player to reach more than 100 goal assists in single season? (* more correct answers)");
        question12.addChoice(new Choice("Wayne Gretzky", true));
        question12.addChoice(new Choice("Bobby Orr", true));
        question12.addChoice(new Choice("Mario Lemieux", true));
        question12.addChoice(new Choice("Connor MacDavid", true));
        questions.add(question12);

        Question question13 = new Question("Who holds the record for most career points by a defenseman in the NHL?");
        question13.addChoice(new Choice("Ray Bourque", true));
        question13.addChoice(new Choice("Al MacInnish", false));
        question13.addChoice(new Choice("Brian Leetch", false));
        questions.add(question13);

        Question question14 = new Question("Who holds the record for most consecutive Stanley Cup championships by a team in the NHL?");
        question14.addChoice(new Choice("Montreal Canadiens", true));
        question14.addChoice(new Choice("Toronto Maple Leafs", false));
        question14.addChoice(new Choice("Detroit Red Wings", false));
        questions.add(question14);

        Question question15 = new Question("Which NHL team has won the Stanley Cup 5 or more times? (* more correct answers)");
        question15.addChoice(new Choice("Boston Bruins", true));
        question15.addChoice(new Choice("Edmonton Oilers", true));
        question15.addChoice(new Choice("New York Islanders", false));
        question15.addChoice(new Choice("New York Rangers", false));
        question15.addChoice(new Choice("Chicago Black Hawks", true));
        question15.addChoice(new Choice("Pittsburgh Penguins", true));
        questions.add(question15);

        Question question16 = new Question("Which NHL team has never won the Stanley Cup? (* more correct answers)");
        question16.addChoice(new Choice("Florida Panthers", true));
        question16.addChoice(new Choice("Nashville Predators", true));
        question16.addChoice(new Choice("Tampa Bay Lightning", false));
        question16.addChoice(new Choice("Anaheim Ducks", false));
        question16.addChoice(new Choice("Carolina Hurricanes", false));
        question16.addChoice(new Choice("Vancouver Canucks", true));
        questions.add(question16);
    }
}
