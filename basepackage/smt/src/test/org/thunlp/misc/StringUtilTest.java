package org.thunlp.misc;

import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

public class StringUtilTest extends TestCase {
	public void testSplit() {
		String text = " a b   c d ";
		List<String> tokens = new LinkedList<String>();
		StringUtil.split(text, ' ', tokens);
		Assert.assertEquals(4, tokens.size());
		Assert.assertEquals("a b c d", StringUtil.join(tokens, " "));
	}
}
