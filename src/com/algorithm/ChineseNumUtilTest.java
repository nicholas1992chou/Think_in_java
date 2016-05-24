package com.algorithm;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ChineseNumUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testChineseNumToArabic() {
		System.out.println(ChineseNumUtil.chineseNumToArabic("ÆßÇ§"));;
	}

	
}
