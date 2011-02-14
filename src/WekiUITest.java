import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import processing.core.PApplet;
import wekinator.controller.WekinatorManager;


public class WekiUITest extends PApplet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int TRAINING = 0;
	public static final int TRAINING_IN_PROGRESS = 0;
	public static final int PERFORMING = 0;
	
	public int state = TRAINING;
	

	public static void main(String args[]) {
		  PApplet.main(new String[] {  "--present", "WekiUITest" });  
	} 
	
	
	WekinatorManager wekidude;
	double out1 = 10, out2 = 10;
	
	public WekiUITest() {
		wekidude = new WekinatorManager(2,2);
	}
	
	@Override
	public void mouseMoved(MouseEvent evt) {
		if (state == TRAINING) {
			wekidude.addToTrain(new double[] {evt.getX(), evt.getY()}, new double[] {evt.getX()/10, evt.getY() });
		}
		if (state == PERFORMING) {
			double[] stuff = wekidude.classify(new double[] {evt.getX(), evt.getY()});
			out1 = stuff[0];
			out2 = stuff[1];
		}
	}
	
	@Override
	public void keyPressed(KeyEvent evt) {
		switch (evt.getKeyChar()) {
		case 't':
			state = TRAINING;
			break;
		case 'p':
			wekidude.train();
			state = PERFORMING;
			break;
		}
	}
	
	
	
	/**
	 * if you haven't worked with processing: This is called at setup
	 */
	public void setup() {
		size(1024,768, JAVA2D);  //we can go with JAVA2D if we don't like OPENGL
		hint( ENABLE_OPENGL_4X_SMOOTH );
		frameRate(30);
		
	}

	/**
	 * This should obviously call a draw manager or something, but for now
	 * it'll draw a cute rectangle. that moves.
	 */
	public void draw() {
		background(30);
		
		this.fill(150);
		this.stroke(200);
		this.rectMode(PApplet.CORNER);
		this.rect(30, 200, 20, (float) out1);
		this.rect(60, 200, 20, (float) out2);

	}

	

}
