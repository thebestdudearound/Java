import java.util.*;
/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: The PlayersList class creates an array of Players. It includes methods to add a player, to print all players,
 * to look up a certain player, and to remove a player.
 * Due Date: 10/14/2015
 * Name: Sebastian Kleinerman
 * File Name: PlayersList.java
 * Assignment #5
 */

public class PlayersList 
{
	private String name;
	private int score;
	private int playerCount = 0;
	Player[] playerList = new Player[10];
	Scanner scan = new Scanner(System.in);
	
	//Method to add a player to the list of players
	public void addPlayer()
	{
		System.out.println("Enter name: ");
		name = scan.next();
		System.out.println("Enter score: ");
		score = scan.nextInt();
		
		for(int index = playerCount; index < (playerList.length - 1); index++)
		{
			Player player = new Player(name, score);
			playerList[index] = player;
		}
		
		playerCount++;
	}
	
	//Method to print all players from the list of players
	public void printPlayers()
	{
		System.out.print("\tScore " + "Name\n");
		for(int index = 0; index < playerCount; index++)
		{
			System.out.println(playerList[index].toString());
		}
	}
	
	//Method to look up a certain player from the list of players
	public void lookupPlayer()
	{
		System.out.println("Enter name to look up. ");
		String playerName = scan.next();
		
		for(int index = 0; index < playerCount; index++)
		{
			if(playerName.equalsIgnoreCase(playerList[index].getPlayerName()))
			{
				System.out.println("");
				System.out.println(playerList[index].getPlayerName() + "'s score = " + playerList[index].getPlayerScore());
			} 
	
		}
		
		if(!(playerName.equalsIgnoreCase(playerList[playerCount-1].getPlayerName())))
		{
			System.out.println("Name not found.");
		}
		
	}
	
	//Method to remove a player from the list of players
	public void removePlayer()
	{
		System.out.println("Enter name to remove.");
		String playerName = scan.next();
		
		for(int index = 0; index < playerCount; index++)
		{		
			if(playerName.equalsIgnoreCase(playerList[index].getPlayerName()))
			{
				for (int i = index; i < playerList.length - 1 ; i++ )
				{
				      playerList[i] = playerList[i+1];
				}
				playerCount--;
				System.out.println(playerName + " removed.");
			}
			else if(!(playerName.equalsIgnoreCase(playerList[playerCount-1].getPlayerName())))
			{
				System.out.println("Name not found.");
			}
		}
		
	}
}

