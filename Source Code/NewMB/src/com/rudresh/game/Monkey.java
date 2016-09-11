package com.rudresh.game;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;

public class Monkey {

	private Image image;
	private int xCordinate;
	private int yCordinate;
	private State Currentstate;
	
	private int MonkeyWidth = Wonderland.STEP_SIZE;
	private int MonkeyHeight = Wonderland.STEP_SIZE;
	
	private int dx;
    private int dy;

	// Other getter setter methods 
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getxCordinate() {
		return xCordinate;
	}

	public void setxCordinate(int xCordinate) {
		this.xCordinate = xCordinate;
	}

	public int getyCordinate() {
		return yCordinate;
	}

	public void setyCordinate(int yCordinate) {
		this.yCordinate = yCordinate;
	}

	// Simple getter Setter Methods Ends here!
	
	
	
	// Initialisation of State Instance variables!
//	MonkeyMovement moveL;
//	MonkeyMovement moveR;
//	MonkeyMovement moveU;
//	MonkeyMovement moveD;
//	MonkeyMovement moveIdle;
	
//	MonkeyMovement currentMonkeyState;
	
	public Monkey() {
		
//		moveL = new MonkeyMoveLeft(this);
//		moveR = new MonkeyMoveRight(this);
//		moveU = new MonkeyMoveUp(this);
//		moveD = new MonkeyMoveDown(this);
//		moveIdle = new MonkeyIdleState(this);
		
//		currentMonkeyState = moveIdle; 
		
		Currentstate = new MonkeyIdle();
		initialiseMonkey();
	}
	
	private void initialiseMonkey() {
		
		ImageIcon MonkeyImage = new ImageIcon("/Users/IRON-MAN/Documents/workspace/NewMB/src/com/rudresh/game/Monkey.png");
		image = MonkeyImage.getImage();
		
		Random random = new Random();
		xCordinate = random.nextInt(Wonderland.GRID_COUNT)* Wonderland.STEP_SIZE;
		yCordinate = random.nextInt(Wonderland.GRID_COUNT)* Wonderland.STEP_SIZE;
		
	}
	
	 public void move() {
	    	int tempx = xCordinate+dx;
	    	int tempy = yCordinate+dy;
	        if(tempx >= 0 && tempx<=(Wonderland.SCREEN_WIDTH-MonkeyWidth)) xCordinate += dx;
	        if(tempy >= 0 && tempy<=(Wonderland.SCREEN_HEIGHT-MonkeyHeight)) yCordinate += dy;
	    }
		
	
	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public int getMonkeyWidth() {
		return MonkeyWidth;
	}

	public void setMonkeyWidth(int monkeyWidth) {
		MonkeyWidth = monkeyWidth;
	}

	public int getMonkeyHeight() {
		return MonkeyHeight;
	}

	public void setMonkeyHeight(int monkeyHeight) {
		MonkeyHeight = monkeyHeight;
	}
	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		Currentstate = Currentstate.KeyReleased(e,this);
		
	}


	public void keyPressed(KeyEvent e) {
		Currentstate = Currentstate.keyPressed(e,this);
	} 
	
}
