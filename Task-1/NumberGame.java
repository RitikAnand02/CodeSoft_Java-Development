package CodSoft_Intern;

import java.util.Scanner;
import java.util.Random;

public class NumberGame 
{
	public static void main(String[] args) 
	{
		        Scanner scanner = new Scanner(System.in);
		        Random random = new Random();
		        int totalRounds = 0;
		        int totalScore = 0;

		        System.out.println("Welcome to the Number Guessing Game!");

		        boolean playAgain;
		        do 
		        {
		            totalRounds++;
		            System.out.println("\n--- Round " + totalRounds + " ---");
		            int number = random.nextInt(100) + 1; 
		            int maxAttempts = 7;
		            int attempts = 0;
		            boolean guessedCorrectly = false;

		            System.out.println("I'm thinking of a number between 1 and 100.");
		            System.out.println("You have " + maxAttempts + " attempts to guess it.");

		            while (attempts < maxAttempts) 
		            {
		                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
		                int guess;

		               
		                try 
		                {
		                    guess = Integer.parseInt(scanner.nextLine());
		                } 
		                catch (NumberFormatException e) 
		                {
		                    System.out.println("Please enter a valid number.");
		                    continue;
		                }

		                attempts++;
		                if (guess < number) 
		                {
		                    System.out.println("Too low!");
		                } 
		                else if (guess > number) 
		                {
		                    System.out.println("Too high!");
		                } 
		                else 
		                {
		                    System.out.println("Congratulations! You guessed the number!");
		                    totalScore += maxAttempts - attempts + 1;
		                    guessedCorrectly = true;
		                    break;
		                }
		            }

		            if (!guessedCorrectly) 
		            {
		                System.out.println("Sorry, you've used all your attempts. The number was " + number + ".");
		            }

		            System.out.println("Your score: " + totalScore);

		           
		            System.out.print("Do you want to play another round? (yes/no): ");
		            String response = scanner.nextLine().trim().toLowerCase();
		            playAgain = response.equals("yes");

		        } 
		        while (playAgain);

		        System.out.println("\nThank you for playing!");
		        System.out.println("Total rounds played: " + totalRounds);
		        System.out.println("Your final score: " + totalScore);

		        scanner.close();
		    }
		

	}


