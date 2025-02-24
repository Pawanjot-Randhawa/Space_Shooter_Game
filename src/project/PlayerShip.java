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
	
	//the constructor set up our player with all the basic values we need 
	public PlayerShip(Gamescreen g, KeysHandle k){
		goodbullets = new LinkedList<Bullets>();
		badbullets = EnemyShip.getBadBulletBorder();
		gs = g;
		key = k;
		x = 500;
		y = 500;
		speed = 20;		
	}
	/*
	 * Input:Bullets instance
	 * Output:addition to the linked list
	 * Process:Adds to the players bullets
	 */
	public void addBullet(Bullets e) {
		goodbullets.add(e);
	}
	/*
	 * Input:Bullets instance
	 * Output:remove a bullet from the linked list
	 * Process:Removes a player bullet
	 */
	public void deleteBullet(Bullets e) {
		goodbullets.remove(e);
	}
	/*
	 * Input:N/a
	 * Output:the player bullet linked list
	 * Process:returns the players bullets so that the enemy class can see them
	 */
	public static LinkedList<Bullets> getGoodBulletBorder(){
		return goodbullets;
	}
	/*
	 * Input:N/a
	 * Output:returns a border around the player
	 * Process:makes a rectangle around the player
	 */
	public Rectangle PlayerBounds() {
		return new Rectangle(x, y, 36, 36);
	}
	/*
	 * Input:N/a
	 * Output:N/a
	 * Process:Takes the border of enemy bullets and check if the collide with the player
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

	/*
	 * Input:N/a
	 * Output:N/a
	 * Process:Updates player location which allows for movement, checks for collisions, and allows player to shoot
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
	/*
	 * Input:N/a
	 * Output:N/a
	 * Process:Draws both our player and the players bullets
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