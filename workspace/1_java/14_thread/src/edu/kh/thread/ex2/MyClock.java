package edu.kh.thread.ex2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyClock implements Runnable {

	@Override
	public void run() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH시 mm분 ss초");  	
		
		while(true) {
		
		Date date = new Date();
		System.out.println("현재 시간 : " + sdf.format(date));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 시간 출력 후 1초 일시 정지
		
		// 19시 15분 24초 
		}
		
	}

}
