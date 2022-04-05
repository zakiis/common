package com.zakiis.common;

import java.util.HashMap;
import java.util.Map;

public class ContextUtil {
	
	private final static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>() {

		@Override
		protected Map<String, Object> initialValue() {
			return new HashMap<String, Object>();
		}
		
	};

	@SuppressWarnings("unchecked")
	public static <T> T get(String key, Class<?> clazz) {
		return (T)threadLocal.get().get(key);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T put(String key, T value) {
		T oldValue = (T)threadLocal.get().get(key);
		threadLocal.get().put(key, value);
		return oldValue;
	}
	
	public static void clear() {
		threadLocal.remove();
	}
}
