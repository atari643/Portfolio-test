package com.example;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.easymock.EasyMock;
import org.junit.Test;


public class PortfolioLineTest {
	private Stock stock1;
	public static final double VALUE_STOCK = 12.6;
	
	@Test
	public void testerGetValue() {
		stock1 = EasyMock.createMock(Stock.class);
		getValueTest(stock1, 1, VALUE_STOCK);
	}
	
	private void getValueTest(Stock stock, int qte, double price) {
		// TODO
	}
	
}
	
