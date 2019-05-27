Marilize Pires
// Assignment 5
//F17 CS F001A OBJ-ORIENTED JAVA FALL 2017

import javax.swing.*;
import java.util.*;
import java.text.*;
import java.awt.*;
import java.awt.event.*;

public class ControlsFrame extends JFrame {
	private JComboBox combo;
	private JButton userinput;
	private JTextField widthinput;
	private JTextField heightinput;
	private JLabel width;
	private JLabel height;
	JFrame jframe;
	ImageDisplay imageDisplay;

	public ControlsFrame() {
		imageDisplay = new ImageDisplay();
		String[] movies = { "The Avengers", "Batman", "Deadpool", "The Godfather", "Godzilla", "Jaws",
				"Planet Of The Apes", "Terminator", "The Winter Soldier", "The Mask Of Zorro" };
		jframe = new JFrame();
		jframe.add(imageDisplay);
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 20);
		setLayout(layout);
		combo = new JComboBox(movies);
		width = new JLabel("Width");
		widthinput = new JTextField(4);
		height = new JLabel("Height");
		heightinput = new JTextField(4);
		userinput = new JButton("Set Size");
		jframe.setSize(600, 900);
		jframe.setVisible(true);
		jframe.setTitle("Choose a poster from the dropdown.");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(combo);
		add(width);
		add(widthinput);
		add(height);
		add(heightinput);
		add(userinput);
		combo.addItemListener(new Listener());
		userinput.addActionListener(new displaypic());
	}

	class Listener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			updateDisplay();
		}
	}

	class displaypic implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			jframe.setSize(Integer.parseInt(widthinput.getText()), Integer.parseInt(heightinput.getText()));
		}
	}

	public void updateDisplay() {
		int realityState = combo.getSelectedIndex();
		switch (realityState) {
		case 0:
			imageDisplay.setImagePath("avengers.jpg");
			break;
		case 1:
			imageDisplay.setImagePath("batman.jpg");
			break;
		case 2:
			imageDisplay.setImagePath("deadpool.jpg");
			break;
		case 3:
			imageDisplay.setImagePath("godfather.jpg");
			break;
		case 4:
			imageDisplay.setImagePath("godzilla.jpg");
			break;
		case 5:
			imageDisplay.setImagePath("jaws.jpg");
			break;
		case 6:
			imageDisplay.setImagePath("planetapes.jpg");
			break;
		case 7:
			imageDisplay.setImagePath("terminator.jpg");
			break;
		case 8:
			imageDisplay.setImagePath("wintersoldier.jpg");
			break;
		case 9:
			imageDisplay.setImagePath("zorro.jpg");
			break;
		}
	}
}
