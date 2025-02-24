package project;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import project.GUI;

import javax.swing.*;
/*
 * This class is the actual game screen.
 * It is responsible for everything that happens on the game screen itself.
 */
public class Gamescreen extends JPanel implements Runnable{
	
	boolean running;//used to see if the game should run
	int difficulty;//used to modify the difficulty
	int FPS = 60;//used to control our game loop
	KeysHandle Key = new KeysHandle();//instance of our key input class
	Thread Game;//a new thread for the actual game
	PlayerShip player;//player object
	EnemyShip enemy;//enemy object
	
	//the constructor sets up our screen settings and makes it so that our game will run
	public Gamescreen() {
		running = true;
		this.setBounds(0, 0, 1000, 950);
		this.setBackground(Color.black);	
		this.setVisible(true);
		this.addKeyListener(Key);		
	}
	/*
	 * Input:difficulty modifier
	 * Output: starts game
	 * Process: The method takes in the difficulty modifier and sets the class variable to the same value.
	 * It also starts our game thread
	 */
	public void startGame(int modifier) {
		this.difficulty = modifier;
		Reset();
		Game = new Thread(this);
		Game.start();
	}
	/*
	 * Input:N/A
	 * Output:N/A
	 * Process:this method does not output or input anything, and it just responsible for looping our other 2 methods which do all the screen work.
	 * The method also contains our game loop.
	 */
	@Override
	public void run() {
		//These variables below are used to control the rate at which some methods are run
		//We only want our methods to run 60 times per second, as any faster will break all of our code, and slower would look bad on the screen	
		double DInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while(running!=false) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / DInterval;			
			lastTime = currentTime;		
			if(delta >= 1) {
				//this is the most important part of the loop, as the loop trigger these 2 methods 60 times per second
				update();
				repaint();
				//System.out.println("Check");
				delta--;
			}		
		}			
		}
	/*
	 * Input: N/A
	 * Output: Updates our objects and game variables
	 * Process: This method calls the update methods for all other objects, while also checking to see if the game should keep running
	 */
	public void update() {
		//objects updating
		player.update();
		enemy.update();
		
		//conditions for the game to end
		if(enemy.alive==false) {//players wins
			running=false;
			this.setVisible(false);
			GUI.Death(1, getDifficulty());
		}
		if(player.alive==false) {//player losses
			running=false;
			this.setVisible(false);
			GUI.Death(2, getDifficulty());
		}
		// System.out.println("Check");
	}
	/*
	 * Input: N/A
	 * Output: Updates all graphics on the screen
	 * Process: This method call on the graphics methods for all objects, while also drawing out the health bars
	 */
	public void paintComponent(Graphics g) {	
		super.paintComponent(g);//paints out all our previously added components
		Graphics2D g2 = (Graphics2D)g;//allows for 2d graphics, which gives better functionality for this game
		//objects draw methods
		player.draw(g2);
		enemy.draw(g2);
		//the rest of the code bellow is responsible for creating the enemy and player health values
		g2.setFont(new Font("TimesRoman", Font.PLAIN, 18)); 
		
		g2.setColor(Color.red);
		g2.fillRect(920, 855, 50, 50);
		g2.drawString("Enemy", 920, 850);
		
		g2.setColor(Color.green);
		g2.fillRect(10, 855, 50, 50);
		g2.drawString("Player", 10, 850);
		
		g2.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		
		g2.setColor(Color.white);
		
		g2.drawString(""+player.health, 15, 890);
		g2.drawString(""+enemy.health, 925, 890);

		g2.dispose();
		
	}
	/*
	 * Input:N/A
	 * Output:rests all values to default
	 * Process:This method resets all objects whenever a new game is created, while also modifying the enemy based on difficulty
	 */
	public void Reset() {
		running = true;
		player = new PlayerShip(this, Key);
		if (difficulty==1){
			enemy = new EnemyShip(20, 20, 50, 5, difficulty);
		}else if (difficulty==2){
			enemy = new EnemyShip(20, 20, 70, 5, difficulty);
		}else if (difficulty==3){
			enemy = new EnemyShip(20, 20, 100, 5, difficulty);
		}else if (difficulty==4){
			enemy = new EnemyShip(20, 20, 130, 10, difficulty);
		}		
	}
	/*
	 * Input:N/A
	 * Output:returns if the game is running
	 * Process:returns if the game is running
	 */
	public boolean getRunning() {
		return running;
	}
	/*
	 * Input:N/A
	 * Output:returns the difficulty
	 * Process:returns the difficulty
	 */
	public String getDifficulty() {
		if(difficulty==1) {
			return"Easy";
		}if(difficulty==2) {
			return"Meduim";
		}if(difficulty==3) {
			return"Hard";
		}if(difficulty==4) {
			return"Impossible";
		}else {
			return "";
		}
	}
}
