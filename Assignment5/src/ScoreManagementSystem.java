import java.util.Scanner;
/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: The ScoreManagementSystem class is used to test and display Player and PlayersList according to what the user decides to do.
 * Due Date: 10/14/2015
 * Name: Sebastian Kleinerman
 * File Name: ScoreManagementSystem.java
 * Assignment #5
 */

public class ScoreManagementSystem{
public static void main(String[] args)
	{
		Scanner input;
        PlayersList highScores = new PlayersList();
        input = new Scanner(System.in);
		String choice = "";

		// Main menu
		do
		{
			System.out.println();
			System.out.println();
			System.out.println("Score Management System");
			System.out.println("Choose:");
			System.out.println();
			System.out.println("A)dd new player");
			System.out.println("P)rint all players");
			System.out.println("L)ookup a player's score");
			System.out.println("R)emove a player");
			System.out.println("Q)uit");
			System.out.println();
			choice = input.next();
		   input.nextLine(); // Discard newline
			
         if (choice.equalsIgnoreCase("A"))
				highScores.addPlayer();
			else if (choice.equalsIgnoreCase("P"))
				highScores.printPlayers();
			else if (choice.equalsIgnoreCase("L"))
				highScores.lookupPlayer();
			else if (choice.equalsIgnoreCase("R"))
				highScores.removePlayer();
			System.out.println();
         
		} while (!choice.equalsIgnoreCase("q"));
	}
   }