// BIT115 Fall 2015
// Assignment 4 ADVANCED: Guessing Game
// The 'METHODS' File

import java.util.Scanner;
import java.util.Random;

public class GuessingGame extends Object {

	int secretNumber;
	int playAgain;
	int userGuess;
	boolean win = false;
	final static int maxNumberGuesses = 5;
	Random rand = new Random();
	Scanner keyboard = new Scanner(System.in);
	
	int numberOfpreviourGuesses = 0;
	
	int[] guess = new int[maxNumberGuesses]; // will need a loop to walk into the array
	

	public int getRandomNumber() {
		secretNumber = rand.nextInt(16);
		return secretNumber;
	}

	public void Welcome() {
		System.out.println("Welcome, new player! Let’s play the guessing game!" + "\n");
		System.out.println("Rules of the guessing game:");
		System.out.println("1. You’ve got 5 guesses to guess my secret number.");
		System.out.println("2. The number is a whole number that’s between 0 and 15 (inclusive at both ends).");
		System.out.println("3. I’ll give you hints about the number, if you don’t guess right." + "\n");
		System.out.println("Ok, I just thought of a new number for you to guess.");
	}

	public void isGuessNum() {

		do {
			userGuess = keyboard.nextInt();
			if (userGuess < 0 || userGuess > 15) {
				System.out.println("Please, type a number between 0 and 15.");

			if (userGuess == secretNumber) {
				win = true;
				System.out.println("Great guess! That’s my number! Winner!" + "\n"
						+ "Would you like to play again? 1 for YES. 2 for NO. ");
				if (keyboard.hasNextInt()) {
					playAgain = keyboard.nextInt();
					if (playAgain == 2) {
						System.out.println("Thank you for playing. Bye!");
						if (playAgain == 1) {
							
						}
					}
				}
			}

			else if (userGuess < secretNumber) {
				System.out.println("I’m sorry, but my secret number is not " + userGuess + "\n"
						+ "My secret number is more than " + userGuess);
				System.out.println("So far, you’ve guessed: " + userGuess + ",");
				System.out.println("You have " + (5 - numberOfpreviourGuesses) + "guesses left.");
				System.out.println("Your next guess?");
				numberOfpreviourGuesses++;
			}

			else if (userGuess > secretNumber) {
				System.out.println("I’m sorry, but my secret number is not " + userGuess + "\n"
						+ "My secret number is more than " + userGuess);
				System.out.println("So far, you’ve guessed: " + userGuess + ",");
				System.out.println("You have " + (5 - numberOfpreviourGuesses) + "guesses left.");
				System.out.println("Your next guess?");
				numberOfpreviourGuesses++;
			}

			else if (userGuess == userGuess) { // check the guesses arrays 
				System.out.println("You’ve already guessed " + userGuess);
				System.out.println("So far, you’ve guessed: " + guess + ",");
				System.out.println("You have " + (5 - numberOfpreviourGuesses) + "guesses left");
				System.out.println("Your next guess?");
				numberOfpreviourGuesses++;
			}

			else {
				System.out.println("Sorry, you lost.");
				System.out.println("The right number was " + secretNumber);
			}
			}
		} while (win == false);

	}
	// You may want to create a method to print the user's previous guess

	// You may want to create a boolean method to check that the user's guess is
	// within range (between 0 and 15)
	// and will return true if it is

	// You may want to create a boolean method to see if the number has been guessed
	// previously
	// and will return true if it has

	// You may want to create a method to store the user's guesses in the 5 elements
	// of the array


	// You might call and capture results from method (e.g., playGame) to see if
	// user wants to play again and if
	// so return it. Example: int playAgain = this.playGame();

	//

	// return; // if you want to end the game early & go directly back to main,
	// you can use a "return;" statement like this one (e.g., return playAgain;)
}
