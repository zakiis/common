package com.zakiis.common.test;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zakiis.common.TraceIdUtil;

public class TraceIdUtilTest {
	
	Logger log = LoggerFactory.getLogger(TraceIdUtilTest.class);
	
	@Test
	public void test() {
		TraceIdUtil.init("zakiis_");
		String traceId = TraceIdUtil.get();
		log.info("test1 function start");
		log.info("test1 function end, you could see the traceId equals {}", traceId);
		TraceIdUtil.clear();
		log.info("there is no traceId");
		traceId = "APP_NAME_" + System.currentTimeMillis();
		TraceIdUtil.set(traceId);
		log.info("change traceId to {}", traceId);
	}

}
