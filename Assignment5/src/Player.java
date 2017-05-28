/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: The Player class creates a Player object with a name and a score. It has methods to set the name and score,
 * as well as methods to get the name and score. Finally it has a toString() method to display name and score.
 * Due Date: 10/14/2015
 * Name: Sebastian Kleinerman
 * File Name: Player.java
 * Assignment #5
 */

public class Player 
{
	private String name;
	private int score;
	
	//Constructor for Player
	public Player(String playerName, int playerScore)
	{
		name = playerName;
		score = playerScore;
	}
	
	//Overridden constructor of Player
	public Player(String playerName)
	{
		name = playerName;
	}
	
	//Method to set a player's name 
	public void setPlayerName(String playerName)
	{
		name = playerName;
	}
	
	//Method to set a player's score
	public void setPlayerScore(int playerScore)
	{
		score = playerScore;
	}
	
	//Method to get a player's name
	public String getPlayerName()
	{
		return name;
	}
	
	//Method to get a player's score
	public int getPlayerScore()
	{
		return score;
	}
	
	//Method to display name and score of a player
	public String toString()
	{
		String result;
		
	    result = "\t" + score + " " + name;
	      
	    return result;
	}
}
