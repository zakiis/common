package com.zakiis.common;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

import com.zakiis.common.constants.CommonConstants;

public class TraceIdUtil {
	
	static String prefix = "";
	
	public static void init(String traceIdPrefix) {
		if (traceIdPrefix != null) {
			TraceIdUtil.prefix = traceIdPrefix;
		}
	}

	public static void set(String traceId) {
		if (StringUtils.isBlank(traceId)) {
			traceId = generateTraceId();
		}
		ContextUtil.put(CommonConstants.TRACE_ID, traceId);
		MDC.put(CommonConstants.TRACE_ID, traceId);
	}
	
	public static String get() {
		String traceId = ContextUtil.get(CommonConstants.TRACE_ID, String.class);
		if (StringUtils.isBlank(traceId)) {
			traceId = generateTraceId();
			MDC.put(CommonConstants.TRACE_ID, traceId);
		}
		return traceId;
	}
	
	public static void clear() {
		ContextUtil.clear();
		MDC.clear();
	}
	
	private static String generateTraceId() {
		return prefix + System.currentTimeMillis() + RandomStringUtils.randomAlphabetic(8);
	}
}
