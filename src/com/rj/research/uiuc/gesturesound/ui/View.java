package com.rj.research.uiuc.gesturesound.ui;

import java.util.ArrayList;

import processing.core.PApplet;

import com.rj.research.uiuc.multitouch.Cursor;
import com.rj.research.uiuc.multitouch.TouchListener;

public class View implements TouchListener {
	protected PApplet papplet;
	protected ArrayList<View> children;
	protected ArrayList<TouchListener> touchListeners;
	
	public View(PApplet papplet) {
		this.papplet = papplet;
		this.children = new ArrayList<View>();
		this.touchListeners = new ArrayList<TouchListener>();
		
	}
	
	public void addChild(View v) {
		if (v != null && children != null)
			children.add(v);
	}
	public void removeChild(View v) {
		if (v != null && children != null)
			children.remove(v);
	}
	
	
	public void addTouchListener(TouchListener c) {
		if (c != null && touchListeners != null) 
			touchListeners.add(c);
	}
	public void removeTouchListener(TouchListener c) {
		if (c != null && touchListeners != null) 
			touchListeners.remove(c);
	}
	
	
	/**
	 * please call super.touchDown(c) on these methods!! the'll be lonely otherwise.
	 */
	public void touchDown(Cursor c) {
		for (TouchListener l : touchListeners) l.touchDown(c);
	}
	public void touchUp(Cursor c) {
		for (TouchListener l : touchListeners) l.touchUp(c);
	}
	public void touchMoved(Cursor c) {
		for (TouchListener l : touchListeners) l.touchMoved(c);
	}

	
	
	
	public void draw(PApplet p) {
		p.pushMatrix();
		p.pushStyle();
				
		drawElement(p);
		
		for (View v : children) 
			v.draw(p);
		
		p.popMatrix();
		p.popStyle();
	}
	
	public void drawElement(PApplet p) {
		
	}


}
