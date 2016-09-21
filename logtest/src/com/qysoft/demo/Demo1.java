package com.qysoft.demo;

import org.apache.log4j.Logger;

public class Demo1 {
	
	private static Logger logger = Logger.getLogger(Demo1.class);

	public static void main(String[] args) {
		 // 记录debug级别的信息  
        logger.debug("This is debug message.");  
        // 记录info级别的信息  
        logger.info("This is info message.");  
        // 记录error级别的信息  
        logger.error("This is error message.");  
        
        logger.warn("warn message.");
        
        logger.info("-----------------------------------------------------");
        logger.info("ddddd水电费是垃圾分类dd看的十分");
		System.out.println("hehe");
	}
	
}
