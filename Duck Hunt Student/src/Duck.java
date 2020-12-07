import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Duck implements MouseListener{
	private int x = 0,y = 180;
	private int vx, vy;
	private Image img; // image of the frog
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	private boolean dead = false;
	public Duck() {
		img = getImage("duck.gif"); //load the image for Tree
		init(x, y); 				//initialize the location of the image
		vx = (int)(Math.random()*(5)+1);
		vy = (int)(Math.random()*(-5)-1);
	}
	
	public void paint(Graphics g) {
		
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		tx.setToTranslation(x,y);
		
		
		g2.drawImage(img, tx, null);   
		
		if (x > 760 || x < 0) {
			vx *= -1;
		}
		if (y > 600 || y < 0) {
			
			resetDuck();
			
		}
		
		y += vy;
		x += vx;
	}
	public void setX (int xCoord) {
		x = xCoord;
	}
	public boolean collide(double clickedX, double clickedY) {
		System.out.println(clickedX + ": " + clickedY);
		
		Rectangle a = new Rectangle(x, y, 100, 100);
		
		//represent the duck as a rectangle object;
		
		//check if mouse x, y is in the rectangle
		if(a.contains(clickedX, clickedY)) {
			System.out.println("ouch");
		}
		if (clickedX > x && clickedX <= x + 75 && clickedY > y && clickedY > y+50) {
			x = 450;
			y = 300;
			return true;
			
		} else {
			return false;
		}
	}
	
	public void resetDuck() {
		x= 450;
		y = 300;
		vx = (int)(Math.random()*(5)+2);
		vy = (int)(Math.random()*(-5)-2);
		if(vx % 2 == 0) {
			vx *= -1;
		}
	}
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Duck.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ouch");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
