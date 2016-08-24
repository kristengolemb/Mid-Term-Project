import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MyCart {
	private String name;
	private double price;
	private int quantity;
	
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
			System.out.println(p.getName() + "\t$" + p.getPrice() + " X " + p.getQuantity() + " = $" + p.getLineTotal());//implicit call to toString(); //name, category, price
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
	

	public String toString() {
		return name + "($" + price + ") $" + quantity;
	}

}
