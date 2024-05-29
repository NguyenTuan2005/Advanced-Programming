package Bai24_25;

import javax.swing.*;

public class Frame extends JFrame {

	public Frame() {
		setTitle("My Paint");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel MainPanel = new MainPanel();
		getContentPane().add(MainPanel);
		JMenuBar menuBar = new MenuBar();
		setJMenuBar(menuBar);

		setFocusable(true);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Frame();
	}
}
