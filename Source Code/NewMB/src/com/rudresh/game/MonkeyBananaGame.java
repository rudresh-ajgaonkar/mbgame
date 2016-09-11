package com.rudresh.game;

import java.awt.EventQueue;

import javax.swing.JFrame;

/*
 * This is the intial Class from where the Game Begins!
 * 
 * 
 */
public class MonkeyBananaGame extends JFrame{

	// Constructor class
	public MonkeyBananaGame() {
		inititialiseGUI();
	}

	private void inititialiseGUI() {
		// TODO Auto-generated method stub
			add(new Wonderland());
			setResizable(false);
			pack();
		    setTitle("Monkey Banana Game");
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// Always good to start the JFrame on the Thread.
		EventQueue.invokeLater(new Runnable() {
		
			@Override
			public void run() {
				// TODO Auto-generated method stub
				JFrame frame = new MonkeyBananaGame();
				frame.setVisible(true);				
			}
		});
	}
}
