import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(" * * * * * * * * * *   N H L   Q U I Z   * * * * * * * * * *");
        System.out.println();
        System.out.println("*** Welcome to the NHL Quiz program. Lets test ourselves and have fun! ***");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        Quiz quiz = new Quiz();
        String userInput;
        userInput = "";

        while (!userInput.equalsIgnoreCase("q")) {
            startSelection();

            System.out.print("Please enter user selection: ");
            userInput = scanner.nextLine();

            checkStartSelection(userInput, scanner, quiz);
        }

    }

    public static void quizProgram (Scanner scanner, Quiz quiz) {
        String userQuizInput;
        int userMaxQuestion;
        do {
            System.out.println("______________________________________");
            System.out.println("User entry for quiz question number.");
            System.out.println("The question number must be number in interval from " + Quiz.MIN_QUESTION + " to " + Quiz.MAX_QUESTION + ".");
            System.out.print("Enter user value for number of quiz question: ");
            userMaxQuestion = scanner.nextInt(); // condition to check user input not yet implemented
            scanner.nextLine();
        } while (userMaxQuestion < Quiz.MIN_QUESTION || userMaxQuestion > Quiz.MAX_QUESTION);

        quiz.setMaxQuestion(userMaxQuestion);


        ArrayList<Question> quizQuestions = quiz.randomQuizQuestions(quiz.getQuestions());

        int questionID = 1;
        int userScore = quiz.getUserScore();
        String inputToQuiz = "";
        System.out.println(" * * * * * * * * *   Q U I Z  S T A R T S   * * * * * * * * *");
        System.out.println();

        for (Question question : quizQuestions) {
            System.out.println("Q" + questionID + ": " + question.getQuestionText());
            questionID++;
            boolean userEntryStatus = true;
            char choiceID = 'a';
            HashMap<Character, Boolean> choiceMap = new HashMap<>();
            for (Choice choice : question.getChoices()) {
                System.out.println(choiceID + ". " + choice.getChoiceText());
                System.out.println();
                choiceMap.put(choiceID, choice.isCorrect());
                choiceID++;
            }
                do {
                    int choicesSize = question.getChoices().size();
                    System.out.println("____________________________");
                    System.out.print("Please select your answer(s): ");
                    userQuizInput = scanner.nextLine();
                    quiz.setUserQuizInput(userQuizInput);
                    inputToQuiz = quiz.getUserQuizInput();
                    userEntryStatus = validateQuizInput(inputToQuiz, choicesSize);
                } while (userEntryStatus);

            boolean countStatus = Validation.validation(inputToQuiz, choiceMap);
            if (countStatus) {
                userScore++;
                quiz.setUserScore(userScore);
            }
        }
        finalResults(userScore, userMaxQuestion);
    }

    private static void finalResults(int userScore, int userMaxQuestion) {
        double finalScore = ((double) userScore / userMaxQuestion) * 100;

                if (finalScore > 80) {
                    System.out.println("You reached final score = " + finalScore + "%, you are real NHL expert!");
                } else if (finalScore > 60 && finalScore <= 80) {
                    System.out.println("You reached final score = " + finalScore + "%, that's good result!");
                } else if (finalScore > 40 && finalScore <= 60) {
                    System.out.println("You reached final score = " + finalScore + "%, could be better, hm? :)");
                } else {
                    System.out.println("You reached final score = " + finalScore + "%, oh yeah, NHL is just not your thing.");
                }
    }

    public static boolean validateQuizInput (String inputToQuiz, int choicesSize) {
        boolean isAlphabetic = true;

        for (char c : inputToQuiz.toCharArray()) {
            int index = c - 'a';
            if (index < 0 || index >= choicesSize) {
                isAlphabetic = false;
                break;
            }
        }

        if (inputToQuiz.isBlank() || inputToQuiz.isEmpty()) {
            System.out.println("Blank or empty user input to quiz is not allowed. Please enter your selection again.");
            return true;
//            break;

        } else if (inputToQuiz.length() > choicesSize) {
            System.out.println("User entered too many inputs, user input exceeds available choices. Please eneter your selection again.");
            return true;
//            break;

        } else if (!isAlphabetic) {
            System.out.println("Invalid input. Either non-alphabetic character, or character out of possible options entered. Please enter your selection again.");
            return true;
//            break;

        } else {
            System.out.println("User input accepted and passed to score counter.");
            System.out.println();
            return false;
        }
    }

    public static void checkStartSelection (String userInput, Scanner scanner, Quiz quiz) {
        if (userInput.equalsIgnoreCase("q")) {
            System.out.println("The program will quit.");

        } else if (userInput.length() != 1) {
            System.out.println("User shall enter only one character. Size of entered characters does not match program requirement.");

        } else if (!userInput.equalsIgnoreCase("s")) {
            System.out.println("Invalid input. User shall enter only values 'S' or 'Q' for function selection.");

        } else {
            quizProgram(scanner, quiz);
        }
    }

    public static void startSelection() {
        System.out.println("________________________________");
        System.out.println("Program selection options: ");
        System.out.println("   S - Start the NHL quiz");
        System.out.println("   Q - Exit the program");
        System.out.println();
    }
}
