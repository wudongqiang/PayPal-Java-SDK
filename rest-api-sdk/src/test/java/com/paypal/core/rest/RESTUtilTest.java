package com.paypal.core.rest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RESTUtilTest {
	
	@Test
	public void testFormatURIPathForNull() {
		String nullString = RESTUtil.formatURIPath(null, null);
		Assert.assertNull(nullString);
	}
	
	@Test
	public void testFormatURIPathNoPattern() {
		String pattern = "/a/b/c";
		String uriPath = RESTUtil.formatURIPath(pattern, null);
		Assert.assertEquals(uriPath, pattern);
	}
	
	@Test
	public void testFormatURIPathNoQS() {
		String pattern = "/a/b/{0}";
		Object[] parameters = new Object[] {"replace"};
		String uriPath = RESTUtil.formatURIPath(pattern, parameters);
		Assert.assertEquals(uriPath, "/a/b/replace");
	}
	
	@Test
	public void testFormatURIPath() {
		String pattern = "/a/b/{0}?name={1}";
		Object[] parameters = new Object[] {"replace", "nameValue"};
		String uriPath = RESTUtil.formatURIPath(pattern, parameters);
		Assert.assertEquals(uriPath, "/a/b/replace?name=nameValue");
	}
	
	@Test
	public void testFormatURIPathWithNull() {
		String pattern = "/a/b/{0}?name={1}&age={2}";
		Object[] parameters = new Object[] {"replace", "nameValue", null};
		String uriPath = RESTUtil.formatURIPath(pattern, parameters);
		Assert.assertEquals(uriPath, "/a/b/replace?name=nameValue");
	}
	
	@Test
	public void testFormatURIPathWithEmpty() {
		String pattern = "/a/b/{0}?name={1}&age=";
		Object[] parameters = new Object[] {"replace", "nameValue", null};
		String uriPath = RESTUtil.formatURIPath(pattern, parameters);
		Assert.assertEquals(uriPath, "/a/b/replace?name=nameValue");
	}
	
	@Test
	public void testFormatURIPathTwoQS() {
		String pattern = "/a/b/{0}?name={1}&age={2}";
		Object[] parameters = new Object[] {"replace", "nameValue", "1"};
		String uriPath = RESTUtil.formatURIPath(pattern, parameters);
		Assert.assertEquals(uriPath, "/a/b/replace?name=nameValue&age=1");
	}

}
