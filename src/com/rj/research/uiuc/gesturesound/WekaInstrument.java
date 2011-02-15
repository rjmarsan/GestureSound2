package com.rj.research.uiuc.gesturesound;

import java.io.File;

import processing.core.PApplet;
import wekinator.controller.WekinatorManager;

import com.rj.research.uiuc.gesturesound.audio.AudioManager;
import com.rj.research.uiuc.gesturesound.audio.instruments.InstrumentManager;
import com.rj.research.uiuc.gesturesound.canvas.CanvasController;
import com.rj.research.uiuc.gesturesound.extractors.ExtractorManager;
import com.rj.research.uiuc.gesturesound.hid.HIDController;
import com.rj.research.uiuc.gesturesound.ui.Controller;
import com.rj.research.uiuc.gesturesound.views.WekaInstrumentView;
import com.rj.research.uiuc.multitouch.Cursor;
import com.rj.research.uiuc.multitouch.TouchListener;

public class WekaInstrument extends Controller implements TouchListener  {
	public final static int NOTHING = 0;
	public final static int PERFORMING = 1;
	public final static int RECORDING = 2;
	public final static int TRAINING = 3;
	
	public int mode = NOTHING;
	
	/** The core components of a WekaInstrument **/
	/** all of these are UI independent (hopefully) **/
	public WekinatorManager wekamanager;
	public AudioManager audiomanager;
	public ExtractorManager extractormanager;
	public InstrumentManager instrument;
	
	
	/** this is UI dependent **/
	public CanvasController canvas;
	public HIDController hid;
	public WekaInstrumentView wekaview;
	
	
	
	public void setupUI(PApplet p) {
		wekaview = new WekaInstrumentView(p);
		this.setView(wekaview);
		wekaview.addTouchListener(this);
		
		canvas = new CanvasController();
		addChildController(canvas);
		hid = new HIDController();
		addChildController(hid);
	}
	
	
	public void loadFromFile(File f) {
		
	}
	
	public void saveToFile(File f) {
		
	}
	
	
	/**
	 * Set the global state of the WekaInstrument.   
	 * This is about the only time I found it necessary to forward a child object's functions through us.
	 * mainly because this is what the program's all about.
	 */
	public void perform() {
		this.mode = PERFORMING;
	}
	public void record() {
		this.mode = RECORDING;
	}
	public void train() {
		this.mode = TRAINING;
		//we actually need to train things at this point.
	}
	public void doNothing() {
		this.mode = NOTHING;
	}
	public int mode() {
		return this.mode;
	}
	
	
	/**
	 * These get forwarded to the ExtractionManager and start that input chain.
	 * basically:
	 * TouchEvent -> WekaInstrument vv
	 *                       ExtractionManager vv-> Canvas -> visuals
	 *                                     WekinatorManager vv
	 *                                             InstrumentManager vv-> InstrumentView 
	 *                                                             SOUND!
	 */
	public void touchDown(Cursor c) {
		
	}
	public void touchUp(Cursor c) {
		
	}
	public void touchMoved(Cursor c) {
		
	}
	
	
	
}
