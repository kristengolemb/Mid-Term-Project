import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class POSTerminal {
	// double subTotal = 0;
	// double finalTotal = 0;
	// final double SALESTAX = 0.06;

	public static void main(String[] args) {
		InputValidator validate = new InputValidator();
		Scanner scan = new Scanner(System.in);
		
		ProductsTextFile listOfProducts = new ProductsTextFile();	// creates
																	// ArrayList
																	// of
																	// Products
		Product prod = new Product();
		MyCart cart = new MyCart(prod.getName(), prod.getPrice(), prod.getQuantity());
		ArrayList<Product> MyCartList = new ArrayList<Product>();
		ArrayList<Product> purchasedProducts = new ArrayList<Product>();

		System.out.println("Welcome to the General Store.");
		
		// do-while loop can start here...
		boolean valid = true;
		do {
		

		System.out.println("\nWhat do you want to do?" + "\n 1 - See the list of products" + "\n 2 - Add to cart"
				+ "\n 3 - See cart" + "\n 4 - Checkout");

		int choice = Validator.isValidOption(scan);
		

		switch (choice) {
		case 1: {

			listOfProducts.displayProductList(listOfProducts.getProductList());
			break;
		}

		case 2: { // make a purchase
					// ask for item number
			String response;
			do {
//			int productChoice = scan.nextInt();
			int productChoice = validate.getInt(scan, "Enter a product number: ", 1, 15) - 1;
			prod = listOfProducts.getProduct(productChoice);
			System.out.println(prod);
			
//			int quantity = scan.nextInt();
			int quantity = validate.getInt(scan, "How many would you like? (Max 100): ", 0, 100);
			prod.setQuantity(quantity);
			
			if (quantity > 0){
				MyCartList = cart.addToMyCartList(prod, prod.getQuantity());
			}
			
			System.out.println("\nYour cart contains: ");
			cart.displayMyCartList(MyCartList);
			System.out.print("\nWould you like to buy something else?");
			response = scan.nextLine();
			} while (response.equals("yes"));
			// cart.displayMyCartList(MyCart);

			// "Would like to add another product?"

			// store purchased items in an array list
		}

		case 3: {// see cart
			// MyCart cart = new MyCart(prod.getName(), prod.getPrice(),
			// prod.getQuantity());
			// MyCart = cart.addToMyCartList(prod, prod.getQuantity());
			System.out.println("Your cart contains: ");
			cart.displayMyCartList(MyCartList);
			System.out.println("Your subtotal: $" + cart.getSubtotal(MyCartList));
		
			// list all products, quantities, totals in current cart
			// have input for escaping / moving to checkout
		}
		// case 4: {
		// System.out.println("How would you like to pay? Please enter cash,
		// card, or check.");
		// String paymentMethod = Validator.isValidPaymentMethod(scan);
		// }
		// switch statement or if/if else/else statement for payment types
		// appropriate methods based on payment selection

		}
	} while (valid);
	}
}
