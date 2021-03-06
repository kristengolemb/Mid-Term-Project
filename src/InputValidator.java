import java.util.Scanner;

public class InputValidator {

	public static String getString(Scanner sc, String prompt) {
		System.out.print(prompt);
		String s = sc.nextLine(); // read user entry
		// sc.nextLine(); // discard any other data entered on the line
		return s;
	}

	public static String getStringWord(Scanner sc, String prompt) {
		System.out.print(prompt);
		String s = sc.next(); // read user entry
		sc.nextLine(); // discard any other data entered on the line
		return s;
	}

	public static int getInt(Scanner sc, String prompt) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			} else {
				System.out.println("Error! Invalid integer value. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return i;
	}

	public static int getInt(Scanner sc, String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			i = getInt(sc, prompt); // automatically runs getInt method but with
									// additional conditions
			if (i < min)
				System.out.println("Error! Number must be greater than " + min + ".");
			else if (i > max)
				System.out.println("Error! Number must be less than " + max + ".");
			else
				isValid = true;
		}
		return i;
	}

	public static double getDouble(Scanner sc, String prompt) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				d = sc.nextDouble();
				isValid = true;
			} else {
				System.out.println("Error! Invalid decimal value. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return d;
	}

	public static double getDouble(Scanner sc, String prompt, double min, double max) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			d = getDouble(sc, prompt);
			if (d < min)
				System.out.println("Error! Number must be greater than " + min + ".");
			else if (d >= max)
				System.out.println("Error! Number must be less than " + max + ".");
			else
				isValid = true;
		}
		return d;
	}
	
	public static long getLong(Scanner sc, String prompt) {
		long l = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextLong()) {
				l = sc.nextLong();
				isValid = true;
			} else {
				System.out.println("Error! Invalid long value. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return l;
	}

	public static String isValidCreditCardNumber(Scanner scan, String prompt) {
		String lastFourDigits = "";
		boolean condition = true;
		while (condition) {
			System.out.println(prompt);
			long cardNumber = getLong(scan, "");
			int length = String.valueOf(cardNumber).length();
			if (length == 16) {
				lastFourDigits = new Long(cardNumber).toString(12, 15);
				// take cardNumber and parse out last 4 digits
				// return last 4 digits
				condition = false;
			} else
				System.out.println("That's not a valid card number. Try again.");
		}
		return lastFourDigits;
	}
	
	public static void isValidCreditCardDate(Scanner scan, String prompt) {
//		String lastFourDigits = "";
		boolean condition = true;
		while (condition) {
			System.out.println(prompt);
			long cardNumber = getLong(scan, "");
			int length = String.valueOf(cardNumber).length();
			if (length == 4) {
//				lastFourDigits = new Long(cardNumber).toString(14, 17);
				// take cardNumber and parse out last 4 digits
				// return last 4 digits
				condition = false;
			} else
				System.out.println("That's not a valid expiration date. Try again.");
		}
	}
	
	public static void isValidCreditCardCVV(Scanner scan, String prompt) {
//		String lastFourDigits = "";
		boolean condition = true;
		while (condition) {
			System.out.println(prompt);
			long cardNumber = getLong(scan, "");
			int length = String.valueOf(cardNumber).length();
			if (length == 3) {
//				lastFourDigits = new Integer(cardNumber).toString(14, 17);
				// take cardNumber and parse out last 4 digits
				// return last 4 digits
				condition = false;
			} else
				System.out.println("That's not a valid CVV number. Try again.");
		}
	}

	public static String isValidRoutingNumber (Scanner scan, String prompt) {
		System.out.println(prompt);
	String routingNumber = scan.nextLine();
	if(routingNumber.length()<9||routingNumber.length()>9)
		System.out.println("Invalid routing number.");
		return routingNumber;
	}

	public static String isValidCheckNumber(Scanner scan, String prompt) {
		System.out.println(prompt);
		String checkNumber = scan.nextLine();
		if (checkNumber.length() < 4 || checkNumber.length() > 4)
			System.out.println("Invalid check number.");
		return checkNumber;
	}
		
	public static String isValidAccountNumber(Scanner scan, String prompt) {
		System.out.println(prompt);
		String accountNumber = scan.nextLine();
		if (accountNumber.length() < 14 || accountNumber.length() > 14)
			System.out.println("Invalid account number.");
		return accountNumber;
	}
}
