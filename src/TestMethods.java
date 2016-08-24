import java.util.ArrayList;

public class TestMethods {

	public static void main(String[] args) {
		ProductsTextFile textFile = new ProductsTextFile();
		
		ArrayList<Product> productList = textFile.getProductList();
		
		textFile.displayProductList(productList);
//		textFile.getProductDesc(textFile.getProductList(), 1);
//		System.out.println();
//		System.out.println(textFile.getProductPrice(textFile.getProductList(), 1));
		
		
		
	}

}
