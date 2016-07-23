package com.shenjinxiang.demo;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Demo1 {

	public static void main(String[] args) {
		Frame f = new Frame();
		f.setSize(400, 400);
		f.setVisible(true);
		
		f.addWindowListener(new MyListener());
	}
}

class MyListener implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		Frame f = (Frame) e.getSource();
		System.out.println("closeing...");
		f.dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}
	
}
