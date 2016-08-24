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
		Payments payment = new Payments();
		
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

		int choice = validate.getInt(scan, "Enter a number: ", 1, 4);
		double subtotal = 0;

		switch (choice) {
		case 1: {
			listOfProducts.displayProductList(listOfProducts.getProductList());
			break;
		}

		case 2: { // make a purchase
					// ask for item number
			String response;
			do {
			int productChoice = validate.getInt(scan, "Enter a product number: ", 1, 15) - 1;
			prod = listOfProducts.getProduct(productChoice);
			System.out.println(prod);
			
			int quantity = validate.getInt(scan, "How many would you like? (Max 100): ", 0, 100);
			prod.setQuantity(quantity);
			
			if (quantity > 0){
				MyCartList = cart.addToMyCartList(prod, prod.getQuantity());
			}
			
			System.out.println("\nYour cart contains: ");
			cart.displayMyCartList(MyCartList);
			subtotal = subtotal + cart.getSubtotal(MyCartList).doubleValue();
			System.out.print("\nWould you like to buy something else?");
			response = scan.nextLine();
			} while (response.equals("yes"));
			break;
		}
			//see cart
		case 3: {
			System.out.println("Your cart contains: ");
			cart.displayMyCartList(MyCartList);
			System.out.println("Your subtotal: $" + subtotal);
			break;
		}
		case 4: {
			System.out.println("\nHow would you like to pay?" + "\n 1 - Cash" + "\n 2 - Credit Card"
					+ "\n 3 - Check\n" + "4 - Go Back\n");
			int choice2 = validate.getInt(scan, "Enter a Number: ", 1, 4);
			switch(choice2){
			case 1 : payment.paymentCash(subtotal);
				break;
				
//			case 2 : payment.paymentCredit(subtotal);
//			
//			case 3 : 
//				
//			case 4 : 
				
			}
			break;
		 }

		}
	} while (valid);
	}
}
