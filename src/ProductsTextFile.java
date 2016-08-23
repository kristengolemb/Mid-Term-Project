import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ProductsTextFile {
	ArrayList<String> productsList = new ArrayList<String>();

	public ProductsTextFile() {
	}

	public void addProducts(String addition) throws IOException {
		System.out.println(addition);
		Path productsPath = Paths.get("./GroceryList.txt");
		File productsFile = productsPath.toFile();
		FileWriter out = new FileWriter(productsFile, true);
		PrintWriter outzoom = new PrintWriter(out);

		outzoom.println(addition);
		outzoom.close();
	}

//	public String readProducts() throws IOException {
//		Path productsPath = Paths.get("GroceryList.txt");
//		File productsFile = productsPath.toFile();
//		FileReader fileRdr = new FileReader(productsFile);
//		BufferedReader br = new BufferedReader(fileRdr);
//		String line = br.readLine();
//		while (line != null) {
//			System.out.println(line);
//
//			line = br.readLine();
//		}
//		return line;
//	}
		/////////////////////////////////////
	
	public ArrayList<Product> getProductList() {
		Path productsPath = Paths.get("./GroceryList.txt");
		//System.out.println(productsPath.toAbsolutePath());
		File productsFile = productsPath.toFile();
		
		ArrayList<Product> productList = new ArrayList<Product> ();
		
		try {            
		    FileReader fileRdr = new FileReader(productsFile);
		    BufferedReader bufferedRdr = new BufferedReader( fileRdr);
		    String line = bufferedRdr.readLine();
	    		while (line !=null)
	    		{
	        		//System.out.println(line);
	        		String[] details = line.split("\t");
	        		
	        		//System.out.println();
	        		//take the String, parse it as a double, then store it
	        		//line below built into second const.
//	        		double price = Double.parseDouble(details[2]);
	        		//create a new instance with this info
//	        		Product temp = new Product(details[0], details[1], details[2], details[3]);
	        		Product temp = new Product(details[0], details[1], details[2]);
	        		//add this instance into the list
	        		productList.add(temp);
	        		
	        		//read the next line for the next loop
	        		line = bufferedRdr.readLine();
	    		}
	    		bufferedRdr.close();
		 }  catch (IOException e) {
		        System.out.println(e); 
		 } 
		
		//output everything
		for (Product p: productList) {
			System.out.println(p);//implicit call to toString(); //name, category, price
		}
		return productList;
	}
		/**
		 * 
		 * @param product	//ArrayList from productList
		 * @param i 		//int from user to choose item
		 */
		public void getProductDesc(ArrayList<Product> product, int i) {
			System.out.println(product.get(i).getName() + ": "+ product.get(i).getDescription());  //.get(i) is ArrayList method that gets the element at index i
		}
		
		
		
	

}

