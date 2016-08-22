
public class Product {
	private String name;
	private String category;
	private double price;
	private String description;
	
	public Product(String name, String category, double price, String description){
		this.name = name;
		this.category = category;
		this.price = price;
		this.setDescription(description);
	}

	public Product(String name, String category, String price){
		this.name = name;
		this.category = category;
		this.price = Double.parseDouble(price);
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

	public String toString() {
		return name + "(" + category + ") $" + price;
	}
}
