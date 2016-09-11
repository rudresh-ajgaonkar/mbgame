package com.rudresh.game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.rudresh.game.Banana;
import com.rudresh.game.Monkey;


public class Wonderland extends JPanel {
	
	public static final int SCREEN_WIDTH = 700;
    public static final int SCREEN_HEIGHT = 700;
    
    public static final int OUTER_HEIGHT = 800;
    public static final int GRID_COUNT = 32;
	public static final int STEP_SIZE = SCREEN_WIDTH/GRID_COUNT;
	
	private Monkey monkey;
	
	private Timer timer;
	private final int DELAY = 10;
	private Banana banana;
	private int eatCount = 15;

	private JLabel statusbar;
	private JPanel topPanel;
	
	private JLabel timeLabel;
	private JPanel bottomPanel; 
	int bananaTime = 0;
	private int gameVar = 0;
	Image backImage;
	 
	
	public Wonderland() {
		// Constructor to Start Initialise the GUI 
    	addKeyListener(new TAdapter()); 
        setFocusable(true);
        setPreferredSize(new Dimension(SCREEN_WIDTH, OUTER_HEIGHT));
        InitialiseGame();
	}

	public int getEatCount() {
		return eatCount;
	}


	public void setEatCount(int eatCount) {
		this.eatCount = eatCount;
	}

	
	private void InitialiseGame() {
		// This method will start the game and the timer that is required for the Game.
		monkey = new Monkey();
		banana = new Banana();
		ImageIcon backImageIcon = new ImageIcon(this.getClass().getResource("/com/rudresh/game/grass.jpg"));
		backImage = backImageIcon.getImage();
		setLayout(new BorderLayout());
		topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(600, 50));
		
		statusbar = new JLabel("Banana Left:"+eatCount);
		timeLabel = new JLabel("Time Left");
		
		topPanel.add(statusbar);
		topPanel.add(timeLabel);
		add(topPanel, BorderLayout.SOUTH);
		
	

		// timer to take care of CountDown!
		Timer timer1 = new Timer(1000, new ActionListener() {
		    public int count = 60;
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        if(eatCount == 0 && count>0){
		        	timeLabel.setText("You have won the match!");
		        	((Timer)e.getSource()).stop();
		        	gameVar = 1;
		        	repaint();
		        }else if(count<=0 && eatCount!=0){
		        	 timeLabel.setText("You Lost the Game!" );
		        	 ((Timer)e.getSource()).stop();
		        	 gameVar = 2;
		        	 repaint();
		        }else {
		            timeLabel.setText(" Time Left "+Integer.toString(count));
		            count--;
		            bananaTime++;
		            resetBananaAfterPredefinedTime();
		        }
		    }
			private void resetBananaAfterPredefinedTime() {
				
				if (bananaTime == 7){
					banana.positionBananaRandomly();
					repaint();
					bananaTime = 0;
				}else{
					// do nothing
				}
				
			}
		});
		timer1.start();
	}


	@Override
	protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;
	if (gameVar == 0){
		drawGraphics(g);	
	}else if (gameVar == 1){
		gameFinished(g2d,gameVar);
	}else if (gameVar == 2){
		gameFinished(g2d,gameVar);
	}
	
	Toolkit.getDefaultToolkit().sync();
	}
	

	private void drawGraphics(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(backImage, 0, 0, 700, 700, this);
		g2d.drawImage(monkey.getImage(), monkey.getxCordinate(), monkey.getyCordinate(), this);
		g2d.setColor(Color.BLACK);
		g2d.drawImage(banana.getBananaImage(), banana.getxCordinateBanana(), banana.getyCordinateBanana(), this);
		g2d.setBackground(Color.BLUE);
	}

	private void checkForCollision() {
		Rectangle r1 = new Rectangle(monkey.getxCordinate(), monkey.getyCordinate(), monkey.getMonkeyWidth(),monkey.getMonkeyHeight());
		Rectangle r2 = new Rectangle(banana.getxCordinateBanana(), banana.getyCordinateBanana(), banana.getBananaWidth(),banana.getBananaHeight());
		if(r1.intersects(r2)) {
			eatCount--;
			System.out.println(eatCount + "\n");
			statusbar.setText("Banana Remaining to Eat " + getEatCount());
			banana.positionBananaRandomly();
			bananaTime = 0;
		}
		
	}
	
	private void gameFinished(Graphics2D g2d, int gameVar2) {

		if (gameVar2 == 1){
			finalScreenDisplay("You Win ! Your score is "+(15-eatCount) , g2d);
		}else {
			finalScreenDisplay("You Lost ! Your score is "+(15-eatCount), g2d);
		}
	   
	}

	private void finalScreenDisplay(String string, Graphics2D g2d) {
		// TODO Auto-generated method stub
		 Font font = new Font("Verdana", Font.BOLD, 18);
		    FontMetrics metr = this.getFontMetrics(font); 
		    g2d.setColor(Color.BLACK);
		    g2d.setFont(font);
		    g2d.drawString(string,
		            (SCREEN_WIDTH - metr.stringWidth(string)) / 2,
		            SCREEN_HEIGHT / 2);
		    statusbar.setText("");
//		    
//		
	}

	/* Control of the keyboard Keys are kept in this anonymous Class!
	** This is only to control the Monkey!
	*/
	 private class TAdapter extends KeyAdapter {
	        @Override
	        public void keyReleased(KeyEvent e) {
	            	monkey.keyReleased(e);
	            	checkForCollision();
	            	repaint();
	        }
	        @Override
	        public void keyPressed(KeyEvent e) {
	            monkey.keyPressed(e);
	            checkForCollision();
	            repaint();
	        }
	          
	    }

}



