import java.util.*;
import java.util.concurrent.*;

class Question {
    String questionText;
    List<String> options;
    int correctOptionIndex;

    public Question(String questionText, List<String> options, int correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }
}

public class QuizApplication {

    private static final int TIME_LIMIT_SECONDS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Question> questions = Arrays.asList(
                new Question("What is the capital of France?", Arrays.asList("Berlin", "Paris", "Rome", "Madrid"), 1),
                new Question("What is 5 + 3?", Arrays.asList("5", "8", "10", "12"), 1),
                new Question("Which planet is known as the Red Planet?",
                        Arrays.asList("Earth", "Mars", "Jupiter", "Venus"), 1),
                new Question("What is the largest mammal in the world?",
                        Arrays.asList("Elephant", "Blue Whale", "Great White Shark", "Giraffe"), 1),
                new Question("Who wrote 'Romeo and Juliet'?",
                        Arrays.asList("Charles Dickens", "William Shakespeare", "Mark Twain", "Jane Austen"), 1),
                new Question("What is the square root of 64?", Arrays.asList("6", "7", "8", "9"), 2),
                new Question("Which country is known as the Land of the Rising Sun?",
                        Arrays.asList("China", "Japan", "South Korea", "Thailand"), 1),
                new Question("What is the chemical symbol for water?", Arrays.asList("H2O", "O2", "CO2", "HO"), 0),
                new Question("Who painted the Mona Lisa?",
                        Arrays.asList("Vincent van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Claude Monet"), 2),
                new Question("What is the capital of Australia?",
                        Arrays.asList("Sydney", "Canberra", "Melbourne", "Brisbane"), 1));

        int score = 0;

        for (Question question : questions) {
            System.out.println("\n" + question.questionText);
            for (int i = 0; i < question.options.size(); i++) {
                System.out.println((i + 1) + ". " + question.options.get(i));
            }

            System.out.println("You have " + TIME_LIMIT_SECONDS + " seconds to answer.");

            ExecutorService executor = Executors.newSingleThreadExecutor();
            Future<Integer> future = executor.submit(() -> {
                System.out.print("Enter your answer (1-4): ");
                return scanner.nextInt() - 1;
            });

            int userAnswer = -1;
            try {
                userAnswer = future.get(TIME_LIMIT_SECONDS, TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                System.out.println("\nTime's up! Moving to the next question.");
                future.cancel(true);
            } catch (Exception e) {
                System.out.println("\nInvalid input! Moving to the next question.");
                future.cancel(true);
            } finally {
                executor.shutdownNow();
            }

            if (userAnswer == question.correctOptionIndex) {
                System.out.println("Correct!");
                score++;
            } else if (userAnswer != -1) {
                System.out.println("Wrong! Correct answer is: " + question.options.get(question.correctOptionIndex));
            }
        }

        System.out.println("\nQuiz Over!");
        System.out.println("Your final score is: " + score + " / " + questions.size());

        scanner.close();
    }
}
