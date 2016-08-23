import java.util.Scanner;

public class Payments {
	Scanner scan = new Scanner(System.in);

	public String paymentMethod(String payment) {
		if (payment.equalsIgnoreCase("cash")) {
			System.out.println("Please enter the amount to pay.");
			int cashPayment = scan.nextInt();
			//cast from int to a double
			double cashMoney = cashPayment;
			//code to do the math
			//return the change formatted as $0.00
//			String change = 
//		}
//		return String change;
//	}
		if (payment.equalsIgnoreCase("check")) {
			System.out.println("Please enter the check number.");
			int checkPayment = scan.nextInt();
			System.out.println("Thanks. Your payment with check " 
			+ checkPayment + " has been received.");
		}
		if (payment.equalsIgnoreCase("credit card")) {
			System.out.println("Please enter your 16-digit card number.");
			int creditCardNumber = scan.nextInt();
			//validate that it's 16 digits
			//take expiration and cvv
			//later, return last 4 digits
			//validCard = line.substring (14, 17);
			//System.out.println("Your card ending in " + validCard + " has been charged.")
		}
}
}
}