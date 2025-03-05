package project;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class PlayerShip{
	//location and movement speed values
	private int x;
	private int y;
	private int speed;
	
	//health value
	public int health=100;
	
	Color blue = new Color(0, 0, 255);//creates a color
	
	//Creates and instance of our bullets, while also making a linked list for our Player bullets and enemy bullets
	Bullets tempbullet;
	static LinkedList<Bullets> goodbullets;
	private LinkedList<Bullets> badbullets;
	public boolean alive = true;//players alive status
	//instances of our game and key inputs
	Gamescreen gs;
	KeysHandle key;

	/**
	 * Constructor to initialize enemy object.
	 * @param g the gamescreen the player will be on
	 * @param k the keyhandler that will control this player
	 */
	public PlayerShip(Gamescreen g, KeysHandle k){
		goodbullets = new LinkedList<Bullets>();
		badbullets = EnemyShip.getBadBulletBorder();
		gs = g;
		key = k;
		x = 500;
		y = 500;
		speed = 20;		
	}
	/**
	 * Adds bullet to the player-bullets list
	 * @param e the bullet to be added
	 */
	public void addBullet(Bullets e) {
		goodbullets.add(e);
	}
	/**
	 * Deletes bullet from the player-bullets list
	 * @param e the bullet to be deleted
	 */
	public void deleteBullet(Bullets e) {
		goodbullets.remove(e);
	}
	/**
	 * Returns the player-bullets list
	 * @return this objects bullet list
	 */
	public static LinkedList<Bullets> getGoodBulletBorder(){
		return goodbullets;
	}
	/**
	 * Returns a Rectangle object created around the player object. Can be used as the player's hitbox.
	 * @return Rectangle objects around this enemy
	 */
	public Rectangle PlayerBounds() {
		return new Rectangle(x, y, 36, 36);
	}
	/**
	 * Checks if any enemy bullets have collided with this player.
	 * On collision decreases the player's health; if the health after this operation
	 * is less than or equal to zero, the alive flag is set to false.
	 */
	public void Collison() {
		//cycling through enemy bullets
		for(int i=0; i<badbullets.size();i++) {
			//checking if the borders of the bullet and player intersect
			if(PlayerBounds().intersects(badbullets.get(i).bulletBounds())){
				//decreases our health and removes the bullet
				health -= badbullets.get(i).getDamage();
				badbullets.remove(i);
			}
			//if our health is zero, the player is dead
			if(health<=0) {
				alive = false;
			}
		}			
	}

	/**
	 * Updates player position.
	 * Adds this player's bullets based on x location.
	 * Removes this player's bullets based on y position.
	 */
	public void update() {
		//this if structure checks variables in our key input class to see if the player shooting or moving
		if(key.shoot>0) {
			//adds bullets to linked list is player is moving
			addBullet(new Bullets(this.x, this.y, 24, 24, 0, -10, 10));
			key.shoot-=1;
		}
		if(key.left==true) {
			//adds to player position if they are inputing a movement
			x-=speed;
		}else if(key.right==true) {
			x+=speed;
		}else if(key.up==true) {
			y-=speed;
		}else if (key.down==true) {
			y+=speed;
		}
		//calls collision method to check for collision
		Collison();
		//this for loop delete the players bullets if they go past the game border
		for(int i=0; i<goodbullets.size(); i++) {
			tempbullet = goodbullets.get(i);		
			tempbullet.update();
			if(tempbullet.getY()<20) {
				deleteBullet(tempbullet);
				
			}
		}
	}
	/**
	 * Draws the enemy on screen, also calls the draw method of each bullet in this enemy's bullet-list.
	 * @param g2 the graphics object
	 */
	public void draw(Graphics2D g2) {
		//this for loop calls the draw method of every player bullet to draw it
		for(int i=0; i<goodbullets.size(); i++) {
			tempbullet = goodbullets.get(i);
			
			tempbullet.draw(g2, blue);
		}
		//the next 2 statements draw the player
		g2.setColor(Color.green);
		g2.fillRect(x, y, 36, 36);
		//this if structure set borders so that the player can not move infinitely
		if(x<1) {
			x = 1;
		}
		if(x>950) {
			x=950;
		}
		if(y<90) {
			y=90;
		}
		if(y>800) {
			y=800;
		}
		
	}
}