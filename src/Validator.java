import java.util.Scanner;

public class Validator {
	public static String isValidPaymentMethod(Scanner scan) {

		String caseSwitch = null;
		switch (caseSwitch) {
		case "cash":
			return "cash";

		case "check":
			return "check";

		case "credit":
			return "credit";
		}
		System.out.println("That's not a valid payment method.");
		return caseSwitch;
	}

	public static String isValidCashPayment(Scanner scan) {
		//takes total from POSTerminal
		String change = "$" + (cashEntered - orderTotal);
		//if cash entered > total, return change
		//else if cash entered < total, print that it's not enough to cover the bill.
		System.out.println("Your change is " + change);
	}
	public static int isValidCreditCardNumber(Scanner scan) {
		int cardNumber = scan.nextInt();
		int length = (int) Math.log10(cardNumber) + 1;
		if (length == 16) {
			String lastFourDigits = new Integer(cardNumber).toString(14, 17);			
			//take cardNumber and parse out last 4 digits
			//return last 4 digits
		}
		else System.out.println("That's not a valid card number.");
		return length;
	}

	public static int isValidProductChoice(Scanner scan) {
		int productSelection = scan.nextInt();
		if (productSelection > 1 && productSelection < 16) {
		}
		else System.out.println("That's not a valid product.");
		return productSelection;

	}
}
