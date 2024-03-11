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
        EasyMock.expect(stock.getPrice()).andReturn(price);
        EasyMock.replay(stock);
        PortfolioLine line = new PortfolioLine(stock, qte);
        assertEquals(qte * price, line.getValue(), 0.001);
        EasyMock.verify(stock);
    }

    @Test
    public void testSetQuantity() {
        PortfolioLine portfolioLine = new PortfolioLine();
        int quantity = 10;
        try {
            portfolioLine.setQuantity(quantity);
            assertEquals(quantity, portfolioLine.getQuantity());
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown");
        }
    }
    @Test
    public void testRemoveStock() {
        Portfolio portfolio = new Portfolio();
        Stock stock = new Stock("stock", 100);
        portfolio.addStock(stock, 10);
        portfolio.removeStock(stock, 5);
        assertEquals(5, portfolio.getQuantity(stock));
    }
}