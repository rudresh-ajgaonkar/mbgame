package com.rudresh.game;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

import com.rudresh.game.Wonderland;


public class Banana {
	
	private Image bananaImage;
	private int xCordinateBanana;
	private int yCordinateBanana;
	private final int RAND_SAMPLE = 600;
	private int BananaWidth = Wonderland.STEP_SIZE;
	private int BananaHeight = Wonderland.STEP_SIZE;
	
	public Banana() {
		initialiseBanana();
	}
		
	public int getBananaWidth() {
		return BananaWidth;
	}

	public void setBananaWidth(int bananaWidth) {
		BananaWidth = bananaWidth;
	}

	public int getBananaHeight() {
		return BananaHeight;
	}

	public void setBananaHeight(int bananaHeight) {
		BananaHeight = bananaHeight;
	}
	
	// banana Constructor

	private void initialiseBanana() {
		ImageIcon MonkeyImage = new ImageIcon(this.getClass().getResource("/com/rudresh/game/Banana.png"));
		bananaImage = MonkeyImage.getImage();	
		positionBananaRandomly();
	}

	public void positionBananaRandomly() {
		// Method to position banana Randomly!
		Random random = new Random();
		xCordinateBanana = random.nextInt(Wonderland.GRID_COUNT)* Wonderland.STEP_SIZE;
		yCordinateBanana = random.nextInt(Wonderland.GRID_COUNT)* Wonderland.STEP_SIZE;
	}

	public Image getBananaImage() {
		return bananaImage;
	}

	public void setBananaImage(Image bananaImage) {
		this.bananaImage = bananaImage;
	}

	public int getxCordinateBanana() {
		return xCordinateBanana;
	}

	public void setxCordinateBanana(int xCordinateBanana) {
		this.xCordinateBanana = xCordinateBanana;
	}

	public int getyCordinateBanana() {
		return yCordinateBanana;
	}

	public void setyCordinateBanana(int yCordinateBanana) {
		this.yCordinateBanana = yCordinateBanana;
	}
	
}
