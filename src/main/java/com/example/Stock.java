package com.example;

import java.util.Objects;

/**
 *
 * @author cjohnen - copie du code tutorialPoint
 */
public class Stock {
   private String name;	
   private double price;

   public Stock (String name, double price) {
      this.name = name;		
      this.price = price;   }
 
   public String getName() {    return name;  }

   public double getPrice() {   return price;    }
   
   public Stock getStock() { return this; }
  @Override
  public  String toString() {
	   return name+"  "+price;
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == this) return true;
      if (obj == null) return false;
      if (this.getClass() != obj.getClass()) return false;
      Stock other = (Stock) obj;
      return Objects.equals(this.name, other.name);
   }
   
   @Override
   public int hashCode() {
      return Objects.hashCode(this.name);
   }
   

}
