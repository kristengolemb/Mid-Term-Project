import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Payments {
	public Payments() {
		
		
	}
	Scanner scan = new Scanner(System.in);
	InputValidator valid = new InputValidator();
	double cashPayment = 0;
	double cashReturned = 0;
	
	//double grandTotal = 15.93;
	
public String paymentCash(double grandTotal) {
		
		cashPayment = valid.getDouble(scan, "Please enter payment amount: $", 0, 10000);
		BigDecimal returnChange = new BigDecimal (cashPayment - grandTotal);
		returnChange = returnChange.setScale(2,  RoundingMode.HALF_UP);
		
		boolean condition = false;
		while (!condition) {
			if (returnChange.doubleValue() < 0) {
				grandTotal = 0 - returnChange.doubleValue();
				System.out.println("You owe " + grandTotal);
				cashPayment = valid.getDouble(scan, "Please tender more cash: $", 0, 10000);
				returnChange = new BigDecimal (cashPayment - grandTotal);
				returnChange = returnChange.setScale(2,  RoundingMode.HALF_UP);
			} else{
				condition = true;
			}
		}
		
		return "Tendered cash: $" + cashPayment + "\nChange: $" + returnChange.doubleValue() + "\n";
	}
	
	public String paymentCredit(double grandTotal){
		
		String lastFourDigits = valid.isValidCreditCardNumber(scan, "Please enter your 16-digit card number.");
		valid.isValidCreditCardDate(scan, "Please enter your 4-digit expiration date.");
		valid.isValidCreditCardCVV(scan, "Please enter your 3-digit CVV number.");
//		System.out.println("Your card " + lastFourDigits + " has been charged ");
//		System.out.println("Credit Card payment for " + grandTotal + "has been received. ");
		
		return lastFourDigits;
			//validate that it's 16 digits
			//take expiration and cvv
			//later, return last 4 digits
			//validCard = line.substring (14, 17);
			//System.out.println("Your card ending in " + validCard + " has been charged.")
		
	}
	public String paymentCheck(double grandTotal){
	String routingNumber = valid.isValidRoutingNumber(scan, "Please enter your 9-digit routing number");
	
	String accountNumber = valid.isValidAccountNumber(scan, "Please enter your 14-digit account number.");
	
	String checknumber = valid.isValidCheckNumber(scan, "Please enter your 4-digit check number.");
	
	
	return checknumber;
		}
//	System.out.println("Thanks. Your payment with check " 
//			+ checkNumber + " has been received.");
		
	}
