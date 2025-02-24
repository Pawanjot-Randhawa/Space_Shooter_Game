package project;
import java.awt.event.*;


public class KeysHandle implements KeyListener{
	
	public boolean up, down, left, right, topl;//booleans to see which direction is pressed
	
	public int shoot;//boolean to see if the user wants to shoot
	//unused method(its needs to be here or else it causes an error)
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	/*
	 * Input:Key input
	 * Output:N/a
	 * Process:Sets the movement values for a direction to true when a key is pressed
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_D||e.getKeyCode()==KeyEvent.VK_RIGHT) {
			right = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_A||e.getKeyCode()==KeyEvent.VK_LEFT) {
			left = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_S||e.getKeyCode()==KeyEvent.VK_DOWN) {
			down = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_W||e.getKeyCode()==KeyEvent.VK_UP) {
			up = true;
		}
	}
	/*
	 * Input:Key input
	 * Output:N/a
	 * Process:Sets the movement values for a direction to false when a key is released,
	 * and adds to the shoot value when the space bar is released
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_D||e.getKeyCode()==KeyEvent.VK_RIGHT) {
			right = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_A||e.getKeyCode()==KeyEvent.VK_LEFT) {
			left = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_S||e.getKeyCode()==KeyEvent.VK_DOWN) {
			down = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_W||e.getKeyCode()==KeyEvent.VK_UP) {
			up = false;
		}if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			shoot+=1;
		}
		
	}
	

}
