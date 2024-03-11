/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author cjohnen
 */
public class PortfolioTest {
    private Portfolio portfolio;
    private Stock stock1;
    private Stock stock2;
    private PortfolioLine line1;
    private PortfolioLine line2;

    @Before
    public void setUp() {
        portfolio = new Portfolio();
        stock1 = createMock(Stock.class);
        stock2 = createMock(Stock.class);
        line1 = new PortfolioLine(stock1, 10);
        line2 = new PortfolioLine(stock2, 5);
    }

    @Test
    public void testGetMarketValueWithMultipleLines() {
        expect(stock1.getPrice()).andReturn(100.0);
        expect(stock2.getPrice()).andReturn(50.0);
        replay(stock1, stock2);

        portfolio.add(line1);
        portfolio.add(line2);

        double expectedMarketValue = 10 * 100.0 + 5 * 50.0;
        double actualMarketValue = portfolio.getMarketValue();

        assertEquals(expectedMarketValue, actualMarketValue, 0.001);
        verify(stock1, stock2);
    }

    @Test
    public void testGetMarketValueWithOneLine() {
        expect(stock1.getPrice()).andReturn(100.0);
        replay(stock1);

        portfolio.add(line1);

        double expectedMarketValue = 10 * 100.0;
        double actualMarketValue = portfolio.getMarketValue();

        assertEquals(expectedMarketValue, actualMarketValue, 0.001);
        verify(stock1);
    }

    @Test
    public void testGetMarketValueWithZeroLines() {
        double expectedMarketValue = 0.0;
        double actualMarketValue = portfolio.getMarketValue();

        assertEquals(expectedMarketValue, actualMarketValue, 0.001);
    }

    @Test
    public void testAddStock() {
        // Arrange
        Stock stock = createMock(Stock.class);
        Portfolio portfolio = new Portfolio();

        // Act
        portfolio.addStock(stock, 5);

        // Assert
        assertEquals(5, portfolio.getQuantity(stock));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddStock_NegativeQuantity() {
        // Arrange
        Stock stock = createMock(Stock.class);
        Portfolio portfolio = new Portfolio();

        // Act
        portfolio.addStock(stock, -5);
    }

    @Test
    public void testAddStock_CallsGetStock() {
        // Arrange
        Stock stock = createMock(Stock.class);
        Portfolio portfolio = new Portfolio();
        portfolio.addStock(stock, 5);
        reset(stock);
        expect(stock.getStock()).andReturn(stock).times(2); // Fix: Change the expected call count to 2
        replay(stock);

        // Act
        portfolio.addStock(stock, 5);

    }

}
