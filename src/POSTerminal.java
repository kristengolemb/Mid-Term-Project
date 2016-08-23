import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class POSTerminal {
	// double subTotal = 0;
	// double finalTotal = 0;
	// final double SALESTAX = 0.06;

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to the General Store.");
		// do-while loop can start here...
		ArrayList<Product> purchasedProducts = new ArrayList<Product>();

		System.out.println(
				"What do you want to do?" 
						+ "\n 1 - See the list of products" 
						+ "\n 2 - See cart" 
						+ "\n 3 - Checkout");

		int choice = Validator.isValidOption(scan);

		switch (choice) {
		case 1: {
			ProductsTextFile listOfProducts = new ProductsTextFile();
			listOfProducts.readProducts();
			break;
		}

		case 2: { // make a purchase
					// ask for item number
			System.out.println("Enter a product number");
			int productChoice = scan.nextInt();
			
			//use that product number to grab price
			
			// ask for quantity
			System.out.println("How many would you like? (Max 100)");
			int quantity = scan.nextInt();
			
			//formula to multiply price by quantity
			//store purchased items in an array list
		}

		case 3: // see cart
				// list all products, quantities, totals in current cart
				// have input for escaping / moving to checkout

		case 4: {
			System.out.println("How would you like to pay? Please enter cash, card, or check.");
			String paymentMethod = Validator.isValidPaymentMethod(scan);
		}
		// switch statement or if/if else/else statement for payment types
		// appropriate methods based on payment selection

		}
	}
}
