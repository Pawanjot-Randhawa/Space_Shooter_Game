package project;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
/*
 * This class is responsible for the all of the screens outside of the actual game.
 * This class is also what takes everything and put it together.
 */
public class GUI extends JFrame implements ActionListener {
	//private varibles used for creating our PanelSwitcher
	private JPanel SwitchPanel;
	private CardLayout cl;
	//These are the different panels or screens that are in the game
	JPanel Main = new JPanel();
	JPanel Instructions = new JPanel();
	static JPanel Deathscreen = new JPanel();
	//the Gamescreen class is also a panel
	Gamescreen Game = new Gamescreen();
	
	//These are all the texts fields that are in the screens
	JLabel title = new JLabel("Space");
	JLabel end = new JLabel("End.");
	JLabel I1 = new JLabel("The Objective in this game is to kill the red enemy by shooting them with your bullets.");
	JLabel I2 = new JLabel("While atempting to kill the enemy, you must also avoid their bullet in order to stay alive.");
	JLabel I3 = new JLabel("Bullet can not destroy each other, so dodging is the only way to avoid damage.");
	JLabel I4 = new JLabel("In terms of damage, all enemy bullet deal 20 damage while the Player has only 100 health.");
	JLabel I5 = new JLabel("All player bullets deal 10 damage, and enemy health depends on difficulty.");
	JLabel I6 = new JLabel("The amount of enemy bullet also change with diffuclty. The infomration is listed below:");
	JLabel I7 = new JLabel("Easy: 50 Health, 1 Bullet");
	JLabel I8 = new JLabel("Meduim: 70 Health, 2 Bullets");
	JLabel I9 = new JLabel("Hard: 100 Health, 3 Bullets");
	JLabel I10 = new JLabel("Impossible: 130 Health, 6 Bullets");
	JLabel I11 = new JLabel("You can use either WASD or arrows keys to move, and hit the SPACE BAR to shoot");
	
	//These are all the various buttons in the program
	JButton InstructionB = new JButton("Instructions");
	JButton Play = new JButton("PLAY");
	JButton back = new JButton("BACK");
	static JButton back3 = new JButton("BACK");
	
	//These are the difficulty option button
	JRadioButton Easy = new JRadioButton("Easy");
	JRadioButton Meduim = new JRadioButton("Medium");
	JRadioButton Hard = new JRadioButton("Hard");
	JRadioButton Impossible = new JRadioButton("Impossible");
	
	//This is just a group for the difficulty buttons
	ButtonGroup difficulty = new ButtonGroup();
	
	//The constructor just makes the settings for all the different components
	public void makeGUI(){
	
		//Setting up our GUI
		setSize(1000,950);//sets the size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//closes the program when you hit the x in the top right
		setResizable(false);//makes it so that the program is unable to be resized
		setLayout(null);//allows me to place all other components wherever i want
		setLocationRelativeTo(null);//opens program in the center
		
		//Setting up all the various panels

		cl = new CardLayout();
		SwitchPanel = new JPanel(cl);

		Main.setBounds(0, 0, 1000, 950);//sets the size of the panels
		Main.setBackground(Color.gray);//sets the color
		Main.setLayout(null);//allows me to place all other components wherever i want
		
		Instructions.setBounds(0, 0, 1000, 950);
		Instructions.setBackground(Color.gray);
		Instructions.setLayout(null);

		
		Deathscreen.setBounds(0, 0, 1000, 950);
		Deathscreen.setBackground(Color.red);
		Deathscreen.setLayout(null);
		
		Game.setLayout(null);
		
		//button settings
		InstructionB.setBounds(50, 650, 100, 60);//setting the size and location
		InstructionB.setFocusable(false);//removes a border behind the buttons
		InstructionB.addActionListener(this);//allows the buttons to receive input
		
		Play.setBounds(450, 650, 100, 50);
		Play.setFocusable(false);
		Play.addActionListener(this);
		
		Easy.setBounds(700, 650, 100, 100);
		Easy.setFocusable(false);
		Easy.setContentAreaFilled(false);
		Easy.addActionListener(this);
		
		Meduim.setBounds(800, 650, 100, 100);
		Meduim.setFocusable(false);
		Meduim.setContentAreaFilled(false);
		Meduim.addActionListener(this);
		
		Hard.setBounds(900, 650, 100, 100);
		Hard.setFocusable(false);
		Hard.setContentAreaFilled(false);
		Hard.addActionListener(this);
		
		Impossible.setBounds(700, 750, 100, 100);
		Impossible.setFocusable(false);
		Impossible.setContentAreaFilled(false);
		Impossible.addActionListener(this);
		
		back.setBounds(50, 50, 100, 50);
		back.setFocusable(false);
		back.addActionListener(this);

		back3.setBounds(50, 50, 100, 50);
		back3.setFocusable(false);
		back3.addActionListener(this);
		
		//label settings
		I1.setFont(new Font("Times New Roman", Font.PLAIN, 23));//sets the font
		I1.setBounds(50, 100, 900, 50);//setting the size and location
		
		I2.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		I2.setBounds(50, 140, 900, 50);
		
		I3.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		I3.setBounds(50, 180, 900, 50);
		
		I4.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		I4.setBounds(50, 220, 900, 50);
		
		I5.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		I5.setBounds(50, 260, 900, 50);
		
		I6.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		I6.setBounds(50, 300, 900, 50);
		
		I7.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		I7.setBounds(50, 350, 900, 50);
		
		I8.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		I8.setBounds(50, 400, 900, 50);
		
		I9.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		I9.setBounds(50, 450, 900, 50);
		
		I10.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		I10.setBounds(50, 500, 900, 50);
		
		I11.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		I11.setBounds(50, 700, 900, 50);
			
		title.setFont(new Font("yes", Font.PLAIN, 140));
		title.setBounds(300, 150, 400, 200);
		
		end.setFont(new Font("yes", Font.PLAIN, 150));
		end.setBounds(300, 150, 400, 200);
			
		//adding all components
		difficulty.add(Easy);//.add() lets you add a component like a button to something
		difficulty.add(Meduim);
		difficulty.add(Hard);
		difficulty.add(Impossible);
		
		Instructions.add(back);
		Instructions.add(I1);
		Instructions.add(I2);
		Instructions.add(I3);
		Instructions.add(I4);
		Instructions.add(I5);
		Instructions.add(I6);
		Instructions.add(I7);
		Instructions.add(I8);
		Instructions.add(I9);
		Instructions.add(I10);
		Instructions.add(I11);
		
		Deathscreen.add(back3);
		Deathscreen.add(end);
		
		Main.add(InstructionB);
		Main.add(Play);
		Main.add(Easy);
		Main.add(Meduim);
		Main.add(Hard);
		Main.add(title);
		Main.add(Impossible);

		SwitchPanel.add(Main, "Main");
		SwitchPanel.add(Instructions, "Instructions");
		SwitchPanel.add(Game, "Game");
		SwitchPanel.add(Deathscreen, "Deathscreen");
				
		add(Main);
		add(Instructions);
		add(Deathscreen);
		add(Game);
			
		Main.setVisible(true);
		Instructions.setVisible(false);
		Deathscreen.setVisible(false);
		Game.setVisible(false);
		setVisible(true);
	}
/*
 * 	Input:gets input from buttons
 * 	Output:changes what you can see on the GUI
 * 	Process:Takes in a button input, and based on the input set certain screens to visible and invisble
 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==InstructionB) {
			Main.setVisible(false);
			Instructions.setVisible(true);
			Game.setVisible(false);
		}
		if (e.getSource()==back||e.getSource()==back3){
			Main.setVisible(true);
			Instructions.setVisible(false);	
			Game.setVisible(false);
			back3.setVisible(false);
		}
		//These 4 if statements start the game with a different setting based on what difficulty was selected
		if (e.getSource()==Play&&Easy.isSelected()==true) {
			Main.setVisible(false);
			Instructions.setVisible(false);	
			Game.setVisible(true);		
			Game.setFocusable(true);
			Game.requestFocusInWindow();
			Game.startGame(1);										
		}
		if (e.getSource()==Play&&Meduim.isSelected()==true) {
			Main.setVisible(false);
			Instructions.setVisible(false);	
			Game.setVisible(true);		
			Game.setFocusable(true);
			Game.requestFocusInWindow();
			Game.startGame(2);										
		}
		if (e.getSource()==Play&&Hard.isSelected()==true) {
			Main.setVisible(false);
			Instructions.setVisible(false);	
			Game.setVisible(true);		
			Game.setFocusable(true);
			Game.requestFocusInWindow();
			Game.startGame(3);										
		}
		if (e.getSource()==Play&&Impossible.isSelected()==true) {
			Main.setVisible(false);
			Instructions.setVisible(false);	
			Game.setVisible(true);		
			Game.setFocusable(true);
			Game.requestFocusInWindow();
			Game.startGame(4);										
		}
	}
	/*
	 * Input: an integer telling if the user won or lost, and a string stating the difficulty
	 * Output:write to a file while also changing visibility
	 * Process: First it sets the deathscreen to be visible as this method on triggers once the player has died.
	 * The program also writes information regarding if the player won or lost a round on what diffculty into a file.
	 * The program always writes the last occurrence of the game.
	 */
	public static void Death(int x, String difficulty){
		Deathscreen.setVisible(true);
		back3.setVisible(true);
		
		File stats = new File("stats.txt");
		
		//this structure just writes information to a file
		try {
			if (stats.exists()){
				FileWriter Fwriter = new FileWriter(stats);
				BufferedWriter bw = new BufferedWriter(Fwriter);
				if(x==1) {
					bw.write("The user has won on "+difficulty+" mode.");
					bw.newLine();
					bw.close();
				}if (x==2) {
					bw.write("The user has lost on "+difficulty+" mode.");
					bw.newLine();
					bw.close();
				}
				bw.close();
			
			}else {
				stats.createNewFile();
				FileWriter Fwriter = new FileWriter(stats);
				BufferedWriter bw = new BufferedWriter(Fwriter);
				if(x==1) {
					bw.write("The user has won on "+difficulty+" mode.");
					bw.newLine();
					bw.close();
				}if(x==2) {
					bw.write("The user has lost on "+difficulty+" mode.");
					bw.newLine();
					bw.close();
				}
				bw.close();
			}
		}catch(Exception e) {
			
		}

	}
	public void switchTo(String panelName) {
		cl.show(SwitchPanel, panelName);
	}
}