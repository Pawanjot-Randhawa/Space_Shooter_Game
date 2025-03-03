package project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class Bullets {
	// Location and movement speed values
	private int x;
	private int y;
	private int xspeed;
	private int yspeed;
	
	// Size values
	private int height;
	private int width;
	
	// Damage value
	private int damage;

	/**
	 * Constructor to initialize bullet properties.
	 * @param x      x-coordinate of the bullet
	 * @param y      y-coordinate of the bullet
	 * @param height height of the bullet
	 * @param width  width of the bullet
	 * @param xspeed speed of the bullet along the x-axis
	 * @param yspeed speed of the bullet along the y-axis
	 * @param damage damage value of the bullet
	 */
	public Bullets(int x, int y, int height, int width, int xspeed, int yspeed, int damage){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;		
		this.xspeed = xspeed;
		this.yspeed = yspeed;
		this.damage = damage;
	}
	/**
	 * Sets speed in x-axis direction
	 * @param speed the speed of bullet on the x-axis
	 */
	public void setXspeed(int speed) {
		xspeed = speed;
	}
	/**
	 * Returns the bullets x-coordinate
	 * @return x-coordinate of the bullet
	 */
	public int getX() {
		return x;
	}
	/**
	 * Return the bullets y-coordinate
	 * @return y-coordinate of the bullet
	 */
	public int getY() {
		return y;
	}
	/**
	 * Returns the damage value of the bullet
	 * @return damage value of the bullet
	 */
	public int getDamage() {
		return damage;
	}
	/**
	 * Makes a Rectangle Object identical to the bullet and returns it
	 * @return Rectangle
	 */
	public Rectangle bulletBounds() {
		return new Rectangle (x, y, height, width);
	}
	/**
	 * Updates all values associated with bullet movement
	 */
	public void update() {
		x += xspeed;
		y += yspeed;	
	}
	/**
	 * Draws the bullet on screen based on bullet properties
	 * @param g2 the graphics object
	 * @param color the color of this bullet
	 */
	public void draw(Graphics2D g2, Color color) {
		g2.setColor(color);
		g2.fillRect(x, y, width, height);
		
	}	
}
