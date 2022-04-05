package com.matic.common.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.zakiis.common.ContextUtil;

public class ContextUtilTest {

	@Test
	public void test() {
		ContextUtil.put("key1", "hello");
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				ContextUtil.put("key1", "world");
				String value = ContextUtil.get("key1", String.class);
				assertEquals(value, "world");
			}
		}).start();
		String value = ContextUtil.get("key1", String.class);
		assertEquals(value, "hello");
		ContextUtil.clear();
		assertNull(ContextUtil.get("key1", String.class));
	}

}
