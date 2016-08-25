import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
//		listOfProducts.getProductList();
		
		Product prod = new Product();
		MyCart cart = new MyCart(prod.getName(), prod.getPrice(), prod.getQuantity());
		ArrayList<Product> MyCartList = new ArrayList<Product>();

		System.out.println("Welcome to the General Store.");
		
		// do-while loop can start here...
//		BigDecimal subtotal = new BigDecimal(0.0);
//		subtotal = subtotal.setScale(2,  RoundingMode.HALF_UP);
		
		boolean condition = true;
		do {
			BigDecimal subtotal = new BigDecimal(0.0);
			MyCartList.clear(); //clears the arraylist
			
			boolean valid = true;
			while (valid) {
				System.out.println("\nWhat do you want to do?" + "\n 1 - See the list of products" + "\n 2 - Add to cart"
						+ "\n 3 - See cart" + "\n 4 - Checkout" + "\n 5 - Leave Store");
		
				int choice = validate.getInt(scan, "Enter a number: ", 1, 5);
				
				switch (choice) {
				case 1: {
					listOfProducts.displayProductList(listOfProducts.getProductList());
					break;
				}

				case 2: {
					String response;
					do {
						int productChoice = validate.getInt(scan, "Enter a product number: ", 1, 15) - 1;
						prod = listOfProducts.getProduct(productChoice);
						System.out.println(prod);

						int quantity = validate.getInt(scan, "How many would you like? (Max 100): ", 0, 100);
						prod.setQuantity(quantity);

						if (quantity > 0) {
							MyCartList = cart.addToMyCartList(prod, prod.getQuantity());
						}

						System.out.println("\nYour cart contains: ");
						cart.displayMyCartList(MyCartList);

						subtotal = subtotal.add(new BigDecimal(prod.getPrice() * prod.getQuantity()));
						subtotal = subtotal.setScale(2, RoundingMode.HALF_UP);

						System.out.println("Your subtotal: $" + subtotal);
						System.out.print("\nWould you like to buy something else? (yes/no) ");
						response = scan.nextLine();
					} while (response.equals("yes"));

					break;
				}
				//see cart
				case 3: {
					System.out.println("\nYour cart contains: ");
					cart.displayMyCartList(MyCartList);
					System.out.println("Your subtotal: $" + subtotal);
					break;
				}
				case 4: { //Checkout
					System.out.println("\nHow would you like to pay?" + "\n1 - Cash" + "\n2 - Credit Card"
							+ "\n3 - Check\n" + "4 - Go Back\n");
					int choice2 = validate.getInt(scan, "Enter a Number: ", 1, 4);
					switch (choice2) {
					case 1 : 
						String tender = payment.paymentCash(subtotal.doubleValue());
						System.out.println("\n\nFinal Receipt:");
						cart.displayMyCartList(MyCartList);
						System.out.println("\nSubtotal: $" + subtotal);
						System.out.println("Tax: $0.00");
						System.out.println("Total: $" + subtotal);
						System.out.println(tender);
						System.out.println("\nYour transaction is complete.  Thank you.");
						valid = false;
						break;
					

					case 2 :
						String creditNum = payment.paymentCredit(subtotal.doubleValue());
						System.out.println("\n\nFinal Receipt:");
						cart.displayMyCartList(MyCartList);
						System.out.println("\nSubtotal: $" + subtotal);
						System.out.println("Tax: $0.00");
						System.out.println("Total: $" + subtotal);
						System.out.println("\nCredit Accepted!");
						System.out.println("\nYour transaction is complete.  Thank you.");
						valid = false;
						break;

							
					case 3 : 
						String checkNum = payment.paymentCheck(subtotal.doubleValue());
						System.out.println("\n\nFinal Receipt:");
						cart.displayMyCartList(MyCartList);
						System.out.println("\nSubtotal: $" + subtotal);
						System.out.println("Tax: $0.00");
						System.out.println("Total: $" + subtotal);
						System.out.println("Check #: " + checkNum + "\nCheck Payment Accepted!");
						System.out.println("\nYour transaction is complete.  Thank you.");
						valid = false;
						break;
									
					case 4:
						valid = false;
						break;
					}
					
					break;
				} // end of case 4 - Checkout
				
				case 5: { //Leave the Store
					System.out.println("Thank you for shopping.  Have a nice day.");
					valid = false;
					condition = false;
					break;
				}

				}
			}
			
		} while (condition);
	}
}
