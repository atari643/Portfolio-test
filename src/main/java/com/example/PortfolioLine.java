package com.example;

public class PortfolioLine {
	Stock myStock;
	int quantity;
	
	public PortfolioLine(){}
	public PortfolioLine(String name, int price, int quantity) 
			throws IllegalArgumentException {
		if  (quantity < 0) throw new IllegalArgumentException();
		this.myStock = new Stock(name, price)	;
		this.quantity = quantity;
	}
	
	public PortfolioLine(Stock stock, int quantity) throws IllegalArgumentException  {
		// System.out.println("PortefolioLine ("+stock+") "+quantity);
		if  (quantity <= 0) throw new IllegalArgumentException();
		if  (stock == null) throw new IllegalArgumentException();
		this.myStock = stock;
		this.quantity = quantity;
	}
	
	public Stock getStock() {
		//System.out.println("PortefolioLine getStock "+myStock);
		return myStock;
	}
	public int getQuantity() {
		return quantity;
	}
	
	public double getValue() {
		return myStock.getPrice()*quantity;
	}
	
	public void setQuantity(int quantity) throws IllegalArgumentException {
		// System.out.println("setQuantity ("+myStock+") "+quantity);
		if (quantity <= 0) throw new IllegalArgumentException();
		this.quantity = quantity;
	}
	
}

