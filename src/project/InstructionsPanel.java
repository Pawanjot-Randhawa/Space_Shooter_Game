package project;

import javax.swing.*;
import java.awt.*;

public class InstructionsPanel extends JPanel{

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



    public InstructionsPanel() {
        //settings
        this.setBounds(0, 0, 1000, 950);
        this.setBackground(Color.gray);
        this.setLayout(null);

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

        //adding the labels
        this.add(I1);
        this.add(I2);
        this.add(I3);
        this.add(I4);
        this.add(I5);
        this.add(I6);
        this.add(I7);
        this.add(I8);
        this.add(I9);
        this.add(I10);
        this.add(I11);
    }
}
