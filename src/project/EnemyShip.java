package project;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.*;


public class EnemyShip {
	//location and movement speed values
	private int x, y;
	private int speed;
	
	//health value
	public int health;
	Color red = new Color(225, 0, 0);//makes a color
	
	//Creates and instance of our bullets, while also making a linked list for player bullets and our enemy bullets
	static LinkedList<Bullets> enemybullets = new LinkedList<Bullets>();
	private LinkedList<Bullets> playerbullets = PlayerShip.getGoodBulletBorder();
	Bullets tempbullet;
	
	public boolean alive;//enemy alive status
	int difficulty;//difficulty modifier
	
	//the constructor set up our enemy with all the basic values we need 
	public EnemyShip(int x, int y, int health, int speed, int modifier) {
		this.x=x;
		this.y=y;
		this.health = health;
		this.speed = speed;
		difficulty = modifier;
		alive = true;		
	}
	/*
	 * Input:Bullets instance
	 * Output:addition to the linked list
	 * Process:Adds to the enemy bullets
	 */
	public void addBullet(Bullets e) {
		enemybullets.add(e);
	}
	/*
	 * Input:Bullets instance
	 * Output:remove a bullet from the linked list
	 * Process:Removes a enemy bullet
	 */
	public void deleteBullet(Bullets e) {
		enemybullets.remove(e);
	}
	/*
	 * Input:N/a
	 * Output:the player bullet linked list
	 * Process:returns the enemys bullets so that the player class can see them
	 */
	public static LinkedList<Bullets> getBadBulletBorder(){
		return enemybullets;
	}
	/*
	 * Input:N/a
	 * Output:returns a border around the enemy
	 * Process:makes a rectangle around the enemy
	 */
	public Rectangle Enemybounds() {
		return new Rectangle(x, y, 36, 36);
	}
	/*
	 * Input:N/a
	 * Output:N/a
	 * Process:Takes the border of player bullets and check if the collide with the enemy
	 */
	public void Collison() {
		//cycling through player bullets
		for(int i=0; i<playerbullets.size();i++) {
			//checking if the borders of the bullet and enemy intersect
			if(Enemybounds().intersects(playerbullets.get(i).bulletBounds())){
				//decreases our health and removes the bullet
				health -= playerbullets.get(i).getDamage();
				playerbullets.remove(i);	
			//if our health is zero, the enemy is dead	
			}if(health<=0) {
				alive = false;
			}
		}	
	}
	
	/*
	 * Input:N/a
	 * Output:N/a
	 * Process:Updates enemy location automatically based on the difficulty's speed value, 
	 * checks for collisions, and sets a number of bullets with different speeds based on difficulty,
	 * and lastly removes bullets past the border while also letting them bounds of the sides
	 */
	public void update() {
		//moves the enemy
		x+=speed;
		//if structure add bullets based on difficulty
		if(x==100||x==200||x==300||x==400||x==500||x==600||x==700||x==800||x==900) {
			if(difficulty==1) {
				addBullet(new Bullets(this.x, this.y, 24, 24, 0, 5,20));
			}else if (difficulty==2) {			
				addBullet(new Bullets(this.x, this.y, 24, 24, 10, 10,20));
				addBullet(new Bullets(this.x, this.y, 24, 24, -10, 10,20));	
			}else if (difficulty==3) {
				addBullet(new Bullets(this.x, this.y, 24, 24, 0, 10,20));
				addBullet(new Bullets(this.x, this.y, 24, 24, 10, 10,20));
				addBullet(new Bullets(this.x, this.y, 24, 24, -10, 10,20));	
			}else if (difficulty==4) {
				addBullet(new Bullets(this.x, this.y, 24, 24, 0, 10,20));
				addBullet(new Bullets(this.x, this.y, 24, 24, 0, 20,20));
				addBullet(new Bullets(this.x, this.y, 24, 24, 10, 10,20));
				addBullet(new Bullets(this.x, this.y, 24, 24, -10, 10,20));
				addBullet(new Bullets(this.x, this.y, 24, 24, 20, 20,20));
				addBullet(new Bullets(this.x, this.y, 24, 24, -20, 20,20));
			}
		}
		//checks for collisions
		Collison();
		//this for loop cycles through our bullets and lets them bounce or get deleted if there past the border
		for(int i=0; i<enemybullets.size(); i++) {
			tempbullet = enemybullets.get(i);	
			tempbullet.update();
			if(tempbullet.getX()<0) {
				tempbullet.setXspeed(10);
			}
			if(tempbullet.getX()>950) {
				tempbullet.setXspeed(-10);
			}
			if(tempbullet.getY()>820) {
				deleteBullet(tempbullet);		
			}
		}	
	}
	/*
	 * Input:N/a
	 * Output:N/a
	 * Process:Draws both our enemy and the enemy bullets
	 */
	public void draw(Graphics2D g2) {
		//this for loop calls the draw method of every enemy bullet to draw it
		for(int i=0; i<enemybullets.size(); i++) {
			tempbullet = enemybullets.get(i);	
			tempbullet.draw(g2, red);
		}
		//the next 2 statements draw the enemy
		g2.setColor(Color.red);
		g2.fillRect(x, y, 36, 36);
		//the if structure sets the border for the enemy based on difficulty
		if(x<0) {
			if(difficulty==1||difficulty==2||difficulty==3) {
				speed = 5;
			}
			if(difficulty==4) {
				speed = 10;
			}
			
		}
		if(x>950) {
			if(difficulty==1||difficulty==2||difficulty==3) {
				speed = -5;
			}if(difficulty==4) {
				speed = -10;
			}
		}		
	}
}