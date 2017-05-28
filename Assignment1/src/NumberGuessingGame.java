/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: This program generates a random number, asks the user to input integer guesses, and displays whether the random number is higher or lower than the guess.
 * Due Date: 09/09/2015
 * Name: Sebastian Kleinerman
 * File Name: NumberGuessingGame.java
 * Assignment #1
 */

import java.util.*;
import java.text.DecimalFormat;

public class NumberGuessingGame 
{
	public static void main(String[] args)
	{
		//Variables and a constant are initialized
		int randomNum = 0;                                                            
		int userInput = 0;
		int min = 1;
		final int MAX = 100;
		double totalGuess = 0;
		double gameCount = 0;
		char userAnswer = 0;
		
		//Creates two Decimal Format objects. One to round to the hundredths place, and the other to the ones place so no decimals.
		DecimalFormat twoDec = new DecimalFormat("###.00");
		DecimalFormat noDec = new DecimalFormat("###");
		
		
		//Creates Scanner object
		Scanner enter = new Scanner(System.in);
		
		//Introduction to game
		System.out.println("This program allows you to play a guessing game.\n"
					+ "I will think of a number between 1 and 100 and will allow you to guess until you get it.\n"
					+ "For each guess, I will tell you whether the right answer is higher or lower than your guess.");
		System.out.println();
		
		//Starts the first do-while loop which asks the user to guess a number which this program generates randomly between 1 and 100.
		do
		{
			//variable guessCount is initialized to count the number of guesses each time the user plays.
			int guessCount = 0;
			//gameCount will keep track of how many times the user decides to play the game.
			gameCount++;
			
			System.out.println("I'm thinking of a number...");
			System.out.print("Your Guess? ");
			userInput = enter.nextInt();
				
			Random rand = new Random();   
			randomNum = rand.nextInt(MAX-min) + min;
			
			//This nested do-while loop checks to see if the number guessed is greater or less than the random number 
			do
			{	
				//In this case, the user's number is lower than the random number so the program tells him/her to go higher
				if(randomNum > userInput)
				{
					System.out.println("higher");
					System.out.print("Your Guess? ");
					userInput = enter.nextInt();
					
					guessCount++;
					totalGuess++;
				}
				//In this case,the user's number is higher than the random number so the program tells him/her to go lower
				if(randomNum < userInput)
				{
					System.out.println("lower");
					System.out.print("Your Guess? ");
					userInput = enter.nextInt();
					
					guessCount++;
					totalGuess++;
				}
			}
			while(userInput != randomNum);
			
			//When the user's number is the same as the random number, the program will tell the user he/she got it right and then proceed to ask if they want to play again.
			if(randomNum == userInput)
			{
				guessCount++;
				totalGuess++;
				
				System.out.print("You got it right in " + guessCount + " guesses!\n"
					+ "Do you want to play again? ");
				System.out.println();
			}
			
			userAnswer = enter.next().charAt(0);
			
			//When the user enters N, n, No, no, or NO, then the program will display the overall statistics of the whole program
			if(userAnswer == 'N' || userAnswer == 'n')
			{
				System.out.println("Overall results:"); 
				System.out.println("  total games = " + noDec.format(gameCount));
				System.out.println("  total guesses = " + noDec.format(totalGuess));
				System.out.println("  guesses/game = " + twoDec.format(totalGuess/gameCount));
				System.out.println("  max guesses = " + guessCount);
				System.out.println("Programmed by Sebastian Kleinerman");
				System.exit(0);
			}
		}
		while(userAnswer == 'Y' || userAnswer == 'y');
		//As long as the user keeps entering y, Y, Yes, YES or yes, the program will keep creating a new random number for the user to keep guessing.
			
			
	}
}

