package com.kaishengit.dao;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jTestCase {

	Logger logger = LoggerFactory.getLogger(Log4jTestCase.class);
	
	@Test
	public void logTest(){
		logger.trace("trace message");
		logger.debug("debug message");
		logger.info("{},{},login","jack","localhost");
		logger.warn("warn message");
		logger.error("error message");
//		logger.fatal("fatal message"); slf4j没有fatal级别
		
	}
	
}
