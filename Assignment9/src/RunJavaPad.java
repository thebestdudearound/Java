import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: RunJavaPad is the class that runs JavaPad, a word processing program.
 * Due Date: 11/30/2015
 * Name: Sebastian Kleinerman
 * File Name: RunJavaPad.java
 * Assignment #9
 */

public class RunJavaPad extends JavaPad
{
	public static void main(String[] args)
	{
		new JavaPad();
	}
	
	public void saveWindowSaveButton() throws FileNotFoundException
	{
		try
		{
		PrintStream writtenText = new PrintStream(saveWindowField.getText());
		writtenText.print(textArea.getText());
		communityWindow.dispose();
		}
		finally
		{
			JOptionPane.showConfirmDialog(battleWindow, "Could not access file hardcode.txt", "I/O Error", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void loadWindowOpenButtonClicked() throws FileNotFoundException
	{
		try
		{
			Scanner enter = new Scanner(new File(loadWindowField.getText()));
			String savedText = "";
			while (enter.hasNextLine())
			{
				savedText += (enter.nextLine());
				textArea.setText(savedText);
				battleWindow.dispose();
			}
		}
		finally
		{
			JOptionPane.showConfirmDialog(battleWindow, "Could not access file hardcode.txt", "I/O Error", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	public void quitWindowYesClicked() throws FileNotFoundException
	{		
		try
		{
			PrintStream writtenText = new PrintStream("hardcode.txt");
			writtenText.print(textArea.getText());
			System.exit(0);
		}
		finally
		{
			JOptionPane.showConfirmDialog(battleWindow, "Could not access file hardcode.txt", "I/O Error", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
		}
	}
}
