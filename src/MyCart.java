import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.math.BigDecimal;

public class MyCart {
	private String name;
	private double price;
	private int quantity;
	private double x;
	
	public MyCart(String name, double price, int quantity){
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public MyCart(){
		;
	}
	
	ArrayList<Product> purchaseList = new ArrayList<Product>();
	
	public ArrayList<Product> addToMyCartList(Product product, double lineTotal) {
		purchaseList.add(product);
		
		return purchaseList;
	}
	
	public void displayMyCartList (ArrayList<Product> ALProduct){
		for (Product p: ALProduct) {
			System.out.println(p.getName() + "\t$" + p.getPrice() + " X " + p.getQuantity() + " = $" + p.getLineTotal().toString());
			//implicit call to toString(); //name, category, price
		}
	}

	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getQuantity(int quantity) {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
//	
//	public double getSubtotal(ArrayList<Product> ALProduct) {
//		double subtotal = 0;
//		for (Product p: ALProduct) {
//		double lineTotal = p.getLineTotal().doubleValue();
//		subtotal = subtotal + lineTotal; 
//		
//		}
//		return subtotal;
//	}
	
	
	public BigDecimal getSubtotal(ArrayList<Product> ALProduct) {
		BigDecimal subtotal = new BigDecimal(x);
//		double subtotal = 0;
		for (Product p: ALProduct) {
		BigDecimal lineTotal = p.getLineTotal();
		subtotal = subtotal.add(lineTotal); 
		
		}
		return subtotal;
	}

	public String toString() {
		return name + "($" + price + ") $" + quantity;
	}

}
