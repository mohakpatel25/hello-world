import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener {
	
	//Objects that need to be drawn on the JFrame in the paint method.
//1. write the code to create a Ground object as one of your instance variables
	Ground foreground = new Ground();
	
// 2. try the same thing with the tree class
	Tree tree = new Tree();
	Duck duck = new Duck();
	Dog dog = new Dog();
	
	
	Music bang = new Music("bang.wav", false);
	Music missed = new Music("missed.wav", false);
	Music thud = new Music("thud.wav", false);
	Music welcome = new Music("Welcome.wav", false);
	
	
	public void paint(Graphics g) {
		super.paintComponent(g);
foreground.paint(g);
tree.paint(g);
duck.paint(g);
dog.paint(g);
	}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	public Frame() {
		JFrame f = new JFrame("Duck Hunt");
		f.setSize(new Dimension(900, 600));
		f.setBackground(Color.blue);
		f.add(this);
		f.addMouseListener(this);
		f.setResizable(false);
		
		Timer t = new Timer(16, this);
	
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		thud.play();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		missed.play();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		double clickedX = arg0.getX();
		double clickedY =arg0.getY();
		//send mouse x and y to the duck object's collision codes
		duck.collide(clickedX, clickedY);
		
		bang.play();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

}
