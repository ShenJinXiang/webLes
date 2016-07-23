package com.shenjinxiang.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Demo4 {

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new DemoTask(), 0, 1000);
	}
}

class DemoTask extends TimerTask {

	@Override
	public void run() {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		Date d = new Date();
		System.out.println(sdf.format(d));
	}
	
}
