import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.awt.*;

/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: The TextStats.java class contains a window with a scrolling text box and a stats box. 
 * The stats box contains a button that, when pressed, recomputes the number of words and the average 
 * word length for the current contents of the text field.
 * Due Date: 11/18/2015
 * Name: Sebastian Kleinerman
 * File Name: TextStats.java
 * Assignment #8
 */

public class TextStats extends JFrame
{	
	private final int WIDTH = 600;
	private final int HEIGHT = 300;	
	private JPanel panel;
	private JTextArea textArea;
	private JButton statButton;
	
	private JLabel[] stats;
	public static final String[] statLabels =
	{
		"Number of Words: ",
	    "Average Word Length: "
	};
		
	//Constructor
	public TextStats()
	{			
		setTitle("Text Statistics");	
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        
        //Creates a Container object and sets its borders and background color
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.setBackground(Color.BLACK);
		
		//Creates JTextArea object and adds it to the contentPane with a border.
		textArea = new JTextArea();
		contentPane.add(textArea, BorderLayout.NORTH);
		
		//Creates a JScrollPane object so the text field can be scrolled if necessary.
		JScrollPane scroll = new JScrollPane(textArea);
		contentPane.add(scroll, BorderLayout.CENTER);
		
		//Creates JPanel object and sets its background color and borders.
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		
		//Creates JButton object to compute the statistics for the contents of the text field.
		statButton = new JButton("Compute Statistics");
		statButton.addActionListener(new ButtonListener());
		statButton.setActionCommand("S");
		panel.add(statButton, BorderLayout.CENTER);		
	    contentPane.add(panel, BorderLayout.SOUTH, SwingConstants.CENTER);
		
	    //Sets initial words for text field, sets foreground color, and makes sure it is editable by user.
		textArea.setText("Java Software Solutions Lewis/Loftus");
		textArea.setForeground(Color.BLACK);
		textArea.setEditable(true); 
		setVisible(true);
		
		 int n = statLabels.length;
		 panel.add(statButton);
	     stats = new JLabel [n];
	     
	     for(int i = 0; i < n; ++i)
	     {
	    	 JLabel label1 = new JLabel(statLabels[i]);
	    	 panel.add(label1);
	    	 stats [i] = new JLabel ();
	    	 panel.add(stats [i]);
	     }
	     
	}
	
	/*
	 * Nested class in order to call the updateStatistics method to recompute the statistics for the current contents of the text field
	 */
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
	    {
	        Object source = event.getSource();
	        if(source == statButton)
	        {
	            updateStatistics();
	        }
	    }
	 
	    private void updateStatistics()
	    {
	        String text = textArea.getText();
	        String[] words = text.split(" ");
	        DecimalFormat format = new DecimalFormat("##.###");
	        stats[0].setText(String.valueOf(words.length));
	        stats[1].setText(String.valueOf(format.format(getAverageCharLength(text))));
	    }
	}

	//Method to calculate the average of the length of the words in the text field
	public static double getAverageCharLength(String str) 
	{
	    String words[] = str.split(" ");
	    double numWords = words.length;
	    double totalCharacters = 0;
	    for(int i = 0; i < numWords; i++)
	    {
	    	totalCharacters = totalCharacters + words[i].length();
	    	
	    }
	    double average = totalCharacters/numWords;
	    return average;
	}
	
	//Main method to create a TextStats object and display the desired window with scrolling text box and stats box
	public static void main(String[] args)
	{
		new TextStats();
	}
}
