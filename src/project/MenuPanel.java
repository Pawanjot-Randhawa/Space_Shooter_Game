package project;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel{

    //title
    JLabel title = new JLabel("Space");

    //buttons
    JButton InstructionB = new JButton("Instructions");
    JButton Play = new JButton("PLAY");

    //radio buttons
    JRadioButton Easy = new JRadioButton("Easy");
    JRadioButton Meduim = new JRadioButton("Medium");
    JRadioButton Hard = new JRadioButton("Hard");
    JRadioButton Impossible = new JRadioButton("Impossible");

    //radio button group
    ButtonGroup difficulty = new ButtonGroup();

    public MenuPanel() {
        //panel settings
        setBounds(0, 0, 1000, 950);//sets the size of the panels
        setBackground(Color.gray);//sets the color
        setLayout(null);//allows me to place all other components wherever i want

        //title settings
        title.setFont(new Font("yes", Font.PLAIN, 140));
        title.setBounds(300, 150, 400, 200);

        //<editor-fold desc="button settings">
        InstructionB.setBounds(50, 650, 100, 60);//setting the size and location
        InstructionB.setFocusable(false);//removes a border behind the buttons
        //InstructionB.addActionListener(this);//allows the buttons to receive input

        Play.setBounds(450, 650, 100, 50);
        Play.setFocusable(false);
        //Play.addActionListener(this);

        Easy.setBounds(700, 650, 100, 100);
        Easy.setFocusable(false);
        Easy.setContentAreaFilled(false);
        //Easy.addActionListener(this);

        Meduim.setBounds(800, 650, 100, 100);
        Meduim.setFocusable(false);
        Meduim.setContentAreaFilled(false);
        //Meduim.addActionListener(this);

        Hard.setBounds(900, 650, 100, 100);
        Hard.setFocusable(false);
        Hard.setContentAreaFilled(false);
        //Hard.addActionListener(this);

        Impossible.setBounds(700, 750, 100, 100);
        Impossible.setFocusable(false);
        Impossible.setContentAreaFilled(false);
        //Impossible.addActionListener(this);
        //</editor-fold>

        //adding buttons to group
        difficulty.add(Easy);
        difficulty.add(Meduim);
        difficulty.add(Hard);
        difficulty.add(Impossible);

        //adding swing parts
        add(InstructionB);
        add(Play);
        add(Easy);
        add(Meduim);
        add(Hard);
        add(title);
        add(Impossible);


    }
}
