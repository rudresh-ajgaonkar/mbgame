package com.rudresh.game;

import java.awt.event.KeyEvent;

public class MonkeyMove extends State {
	
	private MonkeyMove instance;
	
	public State getInstance(KeyEvent e){
		return instance;
	}

	@Override
	public State KeyReleased(KeyEvent e, Monkey monkey) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            monkey.setDx(0);
        }

        if (key == KeyEvent.VK_RIGHT) {
            monkey.setDx(0);
        }

        if (key == KeyEvent.VK_UP) {
            monkey.setDy(0);
        }

        if (key == KeyEvent.VK_DOWN) {
            monkey.setDy(0);
        }
		
		return new MonkeyIdle();
	}

	@Override
	public State keyPressed(KeyEvent e, Monkey monkey) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            monkey.setDx(-Wonderland.STEP_SIZE); monkey.setDy(0);
        }

        if (key == KeyEvent.VK_RIGHT) {
        	monkey.setDx(Wonderland.STEP_SIZE); monkey.setDy(0);
            
        }

        if (key == KeyEvent.VK_UP) {
        	
            monkey.setDy(-Wonderland.STEP_SIZE); monkey.setDx(0);
        }

        if (key == KeyEvent.VK_DOWN) {
        	monkey.setDy(Wonderland.STEP_SIZE); monkey.setDx(0);
        }		
        monkey.move();		
		
		
		return new MonkeyMove();
	}



}
