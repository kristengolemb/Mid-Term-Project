import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Product {
	private String name;
	private String category;
	private double price;
	private String description;
	private int quantity;
	private BigDecimal lineTotal;
	

	public Product(String name, String category, double price, String description){
		this.name = name;
		this.category = category;
		this.price = price;
		this.setDescription(description);
	}

	public Product(String name, String category, String price, String description){
		this.name = name;
		this.category = category;
		this.price = Double.parseDouble(price);
		this.setDescription(description);
	}
	
	public Product(String name, String category, String price){
//		DecimalFormat df = new DecimalFormat("#.00");
		this.name = name;
		this.category = category;
//		this.price = Double.parseDouble(df.format(price));
		this.price = Double.parseDouble(price);
	}
	
	public Product(){
		
	}
	
	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * @return the lineTotal
	 */
	public BigDecimal getLineTotal() {
		lineTotal = new BigDecimal(getQuantity());
		lineTotal = lineTotal.multiply(new BigDecimal (getPrice()));
		lineTotal = lineTotal.setScale(2, RoundingMode.HALF_UP);
		
		return lineTotal;
	}

	public String toString() {
		return name + "(" + category + ") $" + price;
	}
}
