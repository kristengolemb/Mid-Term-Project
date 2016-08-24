import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Payments {
	public static void main(String[] args) {
		Payments payment = new Payments();
		String result = payment.paymentMethod("cash");
		
		System.out.println(result);
		
	}
	Scanner scan = new Scanner(System.in);
	InputValidator valid = new InputValidator();
	double cashPayment = 0;
	double cashReturned = 0;
	
	//double grandTotal = 15.93;
	
	public void paymentMethod(double grandTotal) {
	BigDecimal change = null;
	
			//System.out.print("Please enter the amount to pay.");
			//cashPayment = scan.nextDouble();
			cashPayment = valid.getDouble(scan, "Please enter payment amount: $", 0, 10000);
			double returnChange = cashPayment - grandTotal;
			if (returnChange < 0){
				grandTotal = 0 - returnChange;
				System.out.println("You owe " + grandTotal);
			 
				
			}
			else {
				System.out.println("Your change is $" + returnChange);
			}
			//change = new BigDecimal(returnChange);
			//change = change.setScale(2, RoundingMode.HALF_UP);
			
		
		
	
	
		//return "$" + change;
	}
	
	public void paymentCredit(int payment){
		
		if (payment.equalsIgnoreCase("credit card")) {
			System.out.println("Please enter your 16-digit card number.");
			int creditCardNumber = scan.nextInt();
			
		System.out.println("Credit Card payment for " + grandTotal + "has been received. ");
			//validate that it's 16 digits
			//take expiration and cvv
			//later, return last 4 digits
			//validCard = line.substring (14, 17);
			//System.out.println("Your card ending in " + validCard + " has been charged.")
		}
	}
	public void paymentCheck(int payment){
		if (payment.equalsIgnoreCase("check")) {
			System.out.println("Please enter the check number.");
			int checkPayment = scan.nextInt();
			System.out.println("Thanks. Your payment with check " 
			+ checkPayment + " has been received.");
		}
	}
}
