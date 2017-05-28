/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: JavaPad is a word processing program that has 4 buttons on a top panel that clear, save, and load whatever is unput in the text area, as well as a quit button that prompts to save. 
 * There are two additional buttons to change the text color, as well as to change the font size.
 * Due Date: 11/30/2015
 * Name: Sebastian Kleinerman
 * File Name: JavaPad.java
 * Assignment #9
 */

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.awt.*;

public class JavaPad extends JFrame
{	
	protected JFrame communityWindow, battleWindow;
	protected JTextField saveWindowField, loadWindowField;
	protected JTextArea textArea;
	
	private JFrame changeColorWindow;
	private JPanel buttonPanel, changeColorPanel;
	public JPanel windowPanel, communityWindowPanel, battleWindowPanel;
	private JButton battleButton, communityButton, shopButton, machineButton, loadWindowOpen, friendsButton, optionsButton;
	private JButton communityWindowTeamButton, communityWindowPowerUpButton, communityWindowEvoButton, communityWindowSellButton, communityWindowPurchaseButton, communityWindowBoxButton;
	private JButton battleWindowSpecialButton, battleWindowTrippyButton, battleWindowNormalButton;
	private JButton black, blue, cyan, darkGray, gray, green, lightGray, magenta, orange, pink, red, white, yellow;
	public JLabel windowLabel = new JLabel("");
		
	//Constructor
	public JavaPad()
	{			
		setTitle("Macrosoft JavaPad XP");	
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(0, 0);
        
        Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.setBackground(Color.WHITE);
		
		createWindowPanel();
		contentPane.add(windowPanel, BorderLayout.NORTH, SwingConstants.CENTER);
		
		createButtonPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH, SwingConstants.CENTER);	
		
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		setSize(800, 500);
		setVisible(true);
		
	}
	
	public void setWindowLabel(String selection)
	{
		windowPanel.remove(windowLabel);
		windowLabel = new JLabel(selection);
		windowPanel.add(windowLabel, BorderLayout.WEST, SwingConstants.CENTER);
	}
	
	public JLabel getWindowLabel()
	{
		return windowLabel;
	}
	
	private void createWindowPanel()
	{
		windowPanel = new JPanel();
		
		optionsButton = new JButton("Options");
		optionsButton.addActionListener(new ButtonListener());
		
	    windowPanel.add(optionsButton, BorderLayout.EAST, SwingConstants.CENTER);
		windowPanel.add(getWindowLabel(), BorderLayout.WEST, SwingConstants.CENTER);
	}
	
	private void createButtonPanel()
	{
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.BLACK);
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
		
		battleButton = new JButton("Battle");
		battleButton.addActionListener(new ButtonListener());
	    buttonPanel.add(battleButton, BorderLayout.NORTH);
	    
	    communityButton = new JButton("Community");
	    communityButton.addActionListener(new ButtonListener());
	    buttonPanel.add(communityButton, BorderLayout.NORTH);
	    
	    shopButton = new JButton("Shop");
	    shopButton.addActionListener(new ButtonListener());
	    buttonPanel.add(shopButton, BorderLayout.NORTH);
	    
	    machineButton = new JButton("Machine");
	    machineButton.addActionListener(new ButtonListener());
	    buttonPanel.add(machineButton, BorderLayout.NORTH);
	    
	    friendsButton = new JButton("Friends");
	    friendsButton.addActionListener(new ButtonListener());
	    buttonPanel.add(friendsButton, BorderLayout.NORTH);
	    
	}
	
	private class ButtonListener implements ActionListener
	{
	 public void actionPerformed(ActionEvent event)
	 {
		 Object source = event.getSource();
	     if (source == battleButton)
	     {
	    	 setWindowLabel("Battle");
	    	 
	    	 battleWindow = new JFrame();
	    	 battleWindowPanel = new JPanel();
	    	 
	    	 battleWindowSpecialButton = new JButton("Special Battles");
	    	 battleWindowSpecialButton.addActionListener(this);
	    	 battleWindowPanel.add(battleWindowSpecialButton);
	    	 
	    	 battleWindowTrippyButton = new JButton("Trippy Battles");
	    	 battleWindowTrippyButton.addActionListener(this);
	    	 battleWindowPanel.add(battleWindowTrippyButton);
	    	 
	    	 battleWindowNormalButton = new JButton("Normal Battles");
	    	 battleWindowNormalButton.addActionListener(this);
	    	 battleWindowPanel.add(battleWindowNormalButton);
	    	 
	    	 battleWindow.setSize(new Dimension(200, 300));
	    	 battleWindow.setTitle("Battles");
	    	 battleWindow.setLayout(new BorderLayout());
	    	 battleWindow.setLocation(300, 100);
	    	 battleWindow.add(battleWindowPanel);
	    	 battleWindow.setVisible(true);
	    	
	     }
	     else if(source == communityButton)
	     {
	    	 setWindowLabel("Community");
	    	 
	    	 communityWindow = new JFrame();
	    	 
	    	 communityWindowPanel = new JPanel();
	    	
	         communityWindowTeamButton = new JButton("Edit Teams");
	         communityWindowTeamButton.setSize(250, 50);
	         communityWindowTeamButton.addActionListener(this);
	         communityWindowPanel.add(communityWindowTeamButton, BorderLayout.WEST);
	         
	         communityWindowPowerUpButton = new JButton("Power-Up Fusion");
	         communityWindowPowerUpButton.addActionListener(this);
	         communityWindowPanel.add(communityWindowPowerUpButton, BorderLayout.WEST);
	         
	         communityWindowEvoButton = new JButton("Evolution");
	         communityWindowEvoButton.addActionListener(this);
	         communityWindowPanel.add(communityWindowEvoButton, BorderLayout.WEST);
	         
	         communityWindowSellButton = new JButton("Sell Shit");
	         communityWindowSellButton.addActionListener(this);
	         communityWindowPanel.add(communityWindowSellButton, BorderLayout.WEST);
	         
	         communityWindowPurchaseButton = new JButton("Purchase Shit");
	         communityWindowPurchaseButton.addActionListener(this);
	         communityWindowPanel.add(communityWindowPurchaseButton, BorderLayout.WEST);
	         
	         communityWindowBoxButton = new JButton("ALL YO SHIT");
	         communityWindowBoxButton.addActionListener(this);
	         communityWindowPanel.add(communityWindowBoxButton, BorderLayout.WEST);
	        
	         communityWindow.setSize(new Dimension(200, 300));
	    	 communityWindow.setTitle("Community");
	    	 communityWindow.setLayout(new BorderLayout());
	    	 communityWindow.setLocation(300, 100);
	         communityWindow.add(communityWindowPanel);
	         communityWindow.setVisible(true);
	         
	         
	     }
	     else if(source == communityWindowTeamButton)
	     {
				communityWindow.dispose();
	     }
	     else if(source == shopButton)
	     {
	    	 battleWindow = new JFrame();
	    	 battleWindow.setSize(new Dimension(400, 70));
	    	 battleWindow.setTitle("Load");
	    	 battleWindow.setLayout(new BorderLayout());
	    	 loadWindowField = new JTextField("hardcode.txt");
	    	 battleWindow.add(loadWindowField, BorderLayout.CENTER);
	    	 loadWindowOpen = new JButton("Open");
	    	 loadWindowOpen.addActionListener(this);
	    	 battleWindow.add(loadWindowOpen, BorderLayout.EAST);
	    	 battleWindow.setVisible(true);
	     }
	     else if(source == loadWindowOpen)
	     {
	    	Scanner scanner = null;
			try 
			{
				scanner = new Scanner(new File(loadWindowField.getText()));
				String savedText = "";
		 		while (scanner.hasNextLine())
		 		{
		 			savedText += (scanner.nextLine());
		 		}
		 		textArea.setText(savedText);
		 		battleWindow.dispose();
			}
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
	     }
	     else if(source == machineButton)
	     {
	    	 int dialogResult = JOptionPane.showConfirmDialog(machineButton, "Quitting; Save?", "Quit", JOptionPane.YES_NO_OPTION);
	    	 if(dialogResult == 0) 
	    	 {
	    		PrintStream writtenText = null;
				try 
				{
					writtenText = new PrintStream("hardcode.txt");
					writtenText.print(textArea.getText());
		    		System.exit(0);
				}
				catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				}
	    	 }
	    	 else 
	    	 {
	    		 System.exit(0);
	    	 } 
	     }
	     else if(source == friendsButton)
	     {
	    	 changeColorWindow = new JFrame();
	    	 changeColorWindow.setSize(new Dimension(250, 300));
	    	 changeColorWindow.setTitle("Select a new text color.");
	    	 changeColorWindow.setLayout(new BorderLayout());
	    	 changeColorPanel = new JPanel();
	    	 
	    	 black = new JButton("Black");
	    	 black.addActionListener(new ColorButtonListener());
	    	 changeColorPanel.add(black, BorderLayout.CENTER);
	    	 
	    	 blue = new JButton("Blue");
	    	 blue.addActionListener(new ColorButtonListener());
	    	 changeColorPanel.add(blue, BorderLayout.CENTER);
	    	 
	    	 cyan = new JButton("Cyan");
	    	 cyan.addActionListener(new ColorButtonListener());
	    	 changeColorPanel.add(cyan, BorderLayout.CENTER);
	    	 
	    	 darkGray = new JButton("Dark Gray");
	    	 darkGray.addActionListener(new ColorButtonListener());
	    	 changeColorPanel.add(darkGray, BorderLayout.CENTER);
	    	 
	    	 gray = new JButton("Gray");
	    	 gray.addActionListener(new ColorButtonListener());
	    	 changeColorPanel.add(gray, BorderLayout.CENTER);
	    	 
	    	 green = new JButton("Green");
	    	 green.addActionListener(new ColorButtonListener());
	    	 changeColorPanel.add(green, BorderLayout.CENTER);
	    	 
	    	 lightGray = new JButton("Light Gray");
	    	 lightGray.addActionListener(new ColorButtonListener());
	    	 changeColorPanel.add(lightGray, BorderLayout.CENTER);
	    	 
	    	 magenta = new JButton("Magenta");
	    	 magenta.addActionListener(new ColorButtonListener());
	    	 changeColorPanel.add(magenta, BorderLayout.CENTER);
	    	 
	    	 orange = new JButton("Orange");
	    	 orange.addActionListener(new ColorButtonListener());
	    	 changeColorPanel.add(orange, BorderLayout.CENTER);
	    	 
	    	 pink = new JButton("Pink");
	    	 pink.addActionListener(new ColorButtonListener());
	    	 changeColorPanel.add(pink, BorderLayout.CENTER);
	    	 
	    	 red = new JButton("Red");
	    	 red.addActionListener(new ColorButtonListener());
	    	 changeColorPanel.add(red, BorderLayout.CENTER);
	    	 
	    	 white = new JButton("White");
	    	 white.addActionListener(new ColorButtonListener());
	    	 changeColorPanel.add(white, BorderLayout.CENTER);
	    	 
	    	 yellow = new JButton("Yellow");
	    	 yellow.addActionListener(new ColorButtonListener());
	    	 changeColorPanel.add(yellow, BorderLayout.CENTER);
	    	 
	    	 changeColorWindow.add(changeColorPanel);
	    	 changeColorWindow.setVisible(true);
	     }
	     else if(source == optionsButton)
	     {
	    	 String selection = JOptionPane.showInputDialog(null,"Enter a new font size.", "New Font Size : ", JOptionPane.OK_CANCEL_OPTION);
	    	 int fontSize = Integer.parseInt(selection);
	    	 Font fontType = new Font("Lucida Grande", fontSize, fontSize);
	    	 textArea.setFont(fontType); 
	     }
	  }
	}
	
	private class ColorButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Object source = event.getSource();
			if(source == black)
			{
				textArea.setForeground(Color.BLACK);
				changeColorWindow.dispose();
			}
			else if(source == blue)
			{
				textArea.setForeground(Color.BLUE);
				changeColorWindow.dispose();
			}
			else if(source == cyan)
			{
				textArea.setForeground(Color.CYAN);
				changeColorWindow.dispose();
			}
			else if(source == darkGray)
			{
				textArea.setForeground(Color.DARK_GRAY);
				changeColorWindow.dispose();
			}
			else if(source == gray)
			{
				textArea.setForeground(Color.GRAY);
				changeColorWindow.dispose();
			}
			else if(source == green)
			{
				textArea.setForeground(Color.GREEN);
				changeColorWindow.dispose();
			}
			else if(source == lightGray)
			{
				textArea.setForeground(Color.LIGHT_GRAY);
				changeColorWindow.dispose();
			}
			else if(source == magenta)
			{
				textArea.setForeground(Color.MAGENTA);
				changeColorWindow.dispose();
			}
			else if(source == orange)
			{
				textArea.setForeground(Color.ORANGE);
				changeColorWindow.dispose();
			}
			else if(source == pink)
			{
				textArea.setForeground(Color.PINK);
				changeColorWindow.dispose();
			}
			else if(source == red)
			{
				textArea.setForeground(Color.RED);
				changeColorWindow.dispose();
			}
			else if(source == white)
			{
				textArea.setForeground(Color.WHITE);
				changeColorWindow.dispose();
			}
			else if(source == yellow)
			{
				textArea.setForeground(Color.YELLOW);
				changeColorWindow.dispose();
			}
		}
	}
}
