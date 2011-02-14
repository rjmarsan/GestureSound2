import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import processing.core.PApplet;
import wekinator.controller.WekinatorManager;


public class GestureSound2 extends PApplet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static void main(String args[]) {
		  PApplet.main(new String[] {  "--present", "GestureSound2" });  
	} 
	
	
	public GestureSound2() {
	}
	
	@Override
	public void mouseMoved(MouseEvent evt) {
	}
	
	@Override
	public void keyPressed(KeyEvent evt) {
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
	}

	

}
