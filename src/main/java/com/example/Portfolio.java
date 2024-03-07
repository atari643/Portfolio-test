package com.example;

/**
 *
 * @author cjohnen - adaptation du code tutorialPoint
 */
import java.util.ArrayList;
import java.util.List;

public class Portfolio {
   private List<PortfolioLine> stocks;

    public Portfolio() {  stocks = new ArrayList<>();  }

   public double getMarketValue() {
      	double marketValue = 0.0;  
      	for (PortfolioLine stock : stocks){  
			marketValue += stock.getValue();  }
     	 return marketValue;  }
   
   public void addStock(Stock s, int q ) throws IllegalArgumentException {
	 //  System.out.println("addStock  ("+s+") "+q);
	   if (s == null) throw new IllegalArgumentException ();
	   if (q < 0) throw new IllegalArgumentException ();
	   if (q == 0) return;
	   for (PortfolioLine line : stocks) {
		   if (s.equals(line.getStock())) {
			  int newQuantity =line.getQuantity() +  q;
			  line.setQuantity(newQuantity); 
			  return;   }   }
	   stocks.add(new PortfolioLine(s, q));     }
	   
   public void removeStock(Stock s, int q) throws IllegalArgumentException {
	//   System.out.println("removeStock  ("+s+") "+q);
	   if (q < 0) throw new IllegalArgumentException ();
	   if (s == null) throw new IllegalArgumentException ();
	   if(q == 0) return;
	   for (PortfolioLine line : stocks) {
		   if (s.equals(line.getStock())) {
			  int newQuantity = line.getQuantity()- q;
			  if (newQuantity == 0) {stocks.remove(line); return;}
			  line.setQuantity(newQuantity); return;  }   }
	   throw new IllegalArgumentException ();    }
   
   public int getQuantity(Stock s) {
	 //  System.out.println("getQuantity  ("+s+") ");
	   if (s == null) return 0;
	   for (PortfolioLine line : stocks) {
		   if (s.equals(line.getStock())) return line.getQuantity();
	    }
	   return 0;
   }
   
   public void add(PortfolioLine l) {
	 stocks.add(l); 
	}
}

