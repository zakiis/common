package com.zakiis.algorithm;

import java.text.SimpleDateFormat;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonUtil {
	
	static ObjectMapper mapper = new ObjectMapper();
	static Logger logger = LoggerFactory.getLogger(JsonUtil.class);
	
	static {
		mapper
			//.setVisibility(PropertyAccessor.ALL, Visibility.NONE)
			//.setVisibility(PropertyAccessor.FIELD, Visibility.ANY)
			.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA))
			.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	public static String toJson(Object obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			logger.error("to json error.", e);
		}
		return null;
	}
	
	public static <T> T toObject(String content, Class<T> valueType) {
		try {
			return mapper.readValue(content, valueType);
		} catch (JsonProcessingException e) {
			logger.error("to object error.", e);
		}
		return null;
	}
	
	public static <T> T toObject(String content, TypeReference<T> valueTypeRef) {
		try {
			return mapper.readValue(content, valueTypeRef);
		} catch (JsonProcessingException e) {
			logger.error("to object error.", e);
		}
		return null;
	}

}
