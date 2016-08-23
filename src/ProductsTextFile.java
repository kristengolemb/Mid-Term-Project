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

	public void addProducts(String addition) throws IOException {
		System.out.println(addition);
		Path productsPath = Paths.get("products.txt");  //this will need to match the text file Rob created
		File productsFile = productsPath.toFile();
		FileWriter out = new FileWriter(productsFile, true);
		PrintWriter outzoom = new PrintWriter(out);

		outzoom.println(addition);
		outzoom.close();

	}

	public String readProducts() throws IOException {
		Path productsPath = Paths.get("products.txt");
		File productsFile = productsPath.toFile();
		FileReader fileRdr = new FileReader(productsFile);
		BufferedReader br = new BufferedReader(fileRdr);
		String line = br.readLine();
		while (line != null) {
			System.out.println(line);

			line = br.readLine();

		}
		return line;
	}

}
}
