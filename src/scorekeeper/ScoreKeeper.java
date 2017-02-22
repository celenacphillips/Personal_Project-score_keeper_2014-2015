package scorekeeper;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//@author: Celena Williams
//Last edited: February 22, 2017

//Code may be kept and modified, so long as my name stays the creator.
//Parts of code may be used without documentation if code is understood.

public class ScoreKeeper extends JFrame implements ActionListener {
    JLabel player1, player2;
    JButton minus1, minus2, plus1, plus2;
    JTextArea scoreField1, scoreField2;
    JPanel northPanel, centerPanel;
    
    int score1 = 0, score2 = 0;
    String pl1, pl2;
    
    public static void main (String[] args) {
        ScoreKeeper application = new ScoreKeeper ();
        application.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    }//END public static void main (String[] args)
    
    //Creates and adds content to the window.
    public ScoreKeeper () {
        northPanel = new JPanel ();
        centerPanel = new JPanel ();
        
        setLayout (new BorderLayout ());
        northPanel.setLayout (new FlowLayout ());
        centerPanel.setLayout (new FlowLayout ());
        
        pl1 = JOptionPane.showInputDialog ("What is player 1's name?");
        pl2 = JOptionPane.showInputDialog ("What is player 2's name?");
        
        //If the user doesn't input a name, set the name to the text.
        if (pl1.equals ("") || pl1.equals (null))
            pl1 = "Player 1";
        
        if (pl2.equals ("") || pl2.equals (null))
            pl2 = "Player 2";
        
        player1 = new JLabel (pl1);
        player2 = new JLabel (pl2);
        
        minus1 = new JButton ("-");
        minus1.addActionListener (this);
        minus1.setActionCommand ("minus1");
        
        minus2 = new JButton ("-");
        minus2.addActionListener (this);
        minus2.setActionCommand ("minus2");
        
        plus1 = new JButton ("+");
        plus1.addActionListener (this);
        plus1.setActionCommand ("plus1");
        
        plus2 = new JButton ("+");
        plus2.addActionListener (this);
        plus2.setActionCommand ("plus2");
        
        scoreField1 = new JTextArea (score1 + "");
        scoreField1.setEditable (false);
        scoreField2 = new JTextArea (score2 + "");
        scoreField2.setEditable (false);
        
        add (northPanel, BorderLayout.NORTH);
        add (centerPanel, BorderLayout.CENTER);
        
        northPanel.add (minus1);
        northPanel.add (player1);
        northPanel.add (plus1);
        northPanel.add (minus2);
        northPanel.add (player2);
        northPanel.add (plus2);
        centerPanel.add (scoreField1);
        centerPanel.add (scoreField2);
        
        setSize (300, 300);
        setVisible (true);
    }//END public ScoreKeeper ()

    @Override
    public void actionPerformed (ActionEvent e) {
        String args = e.getActionCommand ();
        
        //Change the store based on the button pressed.
        if (args.equals ("minus1"))
            score1--;
            
        if (args.equals ("minus2"))
            score2--;
                
        if (args.equals ("plus1"))
            score1++;
                    
        if (args.equals ("plus2"))
            score2++;

        //Display the scores.
        scoreField1.setText (score1 + "");
        scoreField2.setText (score2 + "");
    }//public void actionPerformed (ActionEvent e)
}//END public class ScoreKeeper