package com.rj.research.uiuc.gesturesound.ui;

public class Controller {
	View view;
	
	public void setView(View v) {
		view = v;
	}
	
	/**
	 * The controllers don't actually have a tree, it's just the views.
	 * @param c
	 */
	public void addChildController(Controller c) {
		if (view != null && c.view != null) {
			view.addChild(c.view);
		}
	}
	
}
