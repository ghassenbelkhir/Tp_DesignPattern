package refactoring;


import java.util.Vector;
import java.util.Enumeration;

public class Customer {

	private String _name;
	private Vector<Rental> _rentals = new Vector<Rental>();

	public Customer(String name) {
		_name = name;
	}

	public String getName() {
		return _name;
	}

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}


	public Enumeration<Rental> getRentals() {
		// TODO Auto-generated method stub
		return _rentals.elements();
	}

	private double getTotalCharge() {
		double result=0;
		Enumeration<Rental> rentals = _rentals.elements();
		while(rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result  += each.getCharge();
		}
		return result;
	}
	private int getTotalFrequentRenterPoints() {
		int result=0;
		Enumeration<Rental> rentals = _rentals.elements();
		while(rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result  += each.frequentRenterPoints();
		}
		return result;

	}

	public String statement() {
		return new TextStatement().value(this);

	}

	public String htmlStatement() {
		return new HtmlStatement().value(this);
	}	


	abstract class  Statement{
		public String value(Customer aCustomer) {
			Enumeration<Rental> rentals = aCustomer.getRentals();
			String result = headerString(aCustomer);
			while (rentals.hasMoreElements()) {
				Rental each =  rentals.nextElement();
				result+= eachRentalString(each);
			}

			return result;
		}
		abstract String headerString(Customer aCustomer);
		abstract String eachRentalString (Rental aRental);
		abstract String footerString (Customer aCustomer);

	}

	class TextStatement extends Statement{

		String headerString(Customer aCustomer) {
			return "--\nRental Record for " +  aCustomer.getName() + "\n";
		}

		String eachRentalString(Rental aRental) {
			return  "\t" + aRental.getDaysRented() +
					"\t" + aRental.getMovie().getTitle() +
					"\t" + String.valueOf(aRental.getCharge()) + "\n";	
		}

		String footerString(Customer aCustomer) {
			return  "Amount owed is " + String.valueOf(getTotalCharge()) + "\n" +
					"You earned " +  String.valueOf(getTotalFrequentRenterPoints()) +
					" frequent renter points\n";
		}
	}

	class HtmlStatement extends Statement{


		String headerString(Customer aCustomer) {
			return  "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
		}

		String eachRentalString(Rental aRental) {
			return  aRental.getMovie().getTitle()+ ": " +
					String.valueOf(aRental.getCharge()) + "<BR>\n";	
		}

		String footerString(Customer aCustomer) {
			return   "<P>You owe <EM>" + String.valueOf(getTotalCharge()) +
					"</EM><P>\n"
					+ "On this rental you earned <EM>" +
					String.valueOf(getTotalFrequentRenterPoints()) +
					"</EM> frequent renter points<P>";
		}
	}





}


