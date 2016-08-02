package com.shenjinxiang.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Demo1 {

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
				System.out.println(sdf.format(new Date()));
			}
		}, 0, 1000);
	}
}
