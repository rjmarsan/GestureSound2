package com.rj.research.uiuc.gesturesound.ui;

import processing.core.PApplet;

public class View {
	
	public void draw(PApplet p) {
		p.pushMatrix();
		p.pushStyle();
				
		drawElement(p);
		
		p.popMatrix();
		p.popStyle();
	}
	
	public void drawElement(PApplet p) {
		
	}
	
}
