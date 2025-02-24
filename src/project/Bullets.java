package project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class Bullets {
	//location and movement speed values
	private int x;
	private int y;
	private int xspeed;
	private int yspeed;
	
	//size values
	private int height;
	private int width;
	
	//damage value
	private int damage;
	
	//the constructor gives all the variables a value
	public Bullets(int x, int y, int height, int width, int xspeed, int yspeed, int damage){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;		
		this.xspeed = xspeed;
		this.yspeed = yspeed;
		this.damage = damage;
	}
	/*
	 * Input:x value
	 * Output:sets xspeed value
	 * Process:sets xspeed value
	 */
	public void setXspeed(int x) {
		xspeed = x;
	}
	/*
	 * Input:N/a
	 * Output:return x value
	 * Process:return x value
	 */
	public int getX() {
		return x;
	}
	/*
	 * Input:N/a
	 * Output:return damage value
	 * Process:return damage value
	 */
	public int getDamage() {
		return damage;
	}
	/*
	 * Input:N/a
	 * Output:returns a border around the bullet
	 * Process:makes a rectangle around the bullet
	 */
	public Rectangle bulletBounds() {
		return new Rectangle (x, y, height, width);
	}
	/*
	 * Input:N/a
	 * Output:return y value
	 * Process:return y value
	 */
	public int getY() {
		return y;
	}
	/*
	 * Input:N/a
	 * Output:N/a
	 * Process:updates the bullets location using the speed values
	 */
	public void update() {
		x += xspeed;
		y += yspeed;	
	}
	/*
	 * Input:N/a
	 * Output:image
	 * Process:draws the bullets
	 */
	public void draw(Graphics2D g2, Color color) {
		//these 2 lines draw the bullet
		g2.setColor(color);
		g2.fillRect(x, y, width, height);
		
	}	
}
