package refactoring;
public class Movie {

	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String _title;

	private Price _price;

	public Movie(String title, Price price) {
		_title = title;
		_price = price;
	}

	public int getPriceCode() {
		return _price.getPriceCode();
	}

	public double getCharge(int daysRented) {

		return _price.getCharge(daysRented);

	}

	public String getTitle() {
		return _title;
	}



	public int frequentRenterPoints(int daysRented) {	
		if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
			return 1;
		else return 0;
	}


	abstract class Price{
		abstract int getPriceCode();
		abstract double getCharge(int daysRented); }

	class childrensPrice extends Price {

		@Override
		int getPriceCode() {
			return Movie.CHILDRENS;
		}
		@Override
		double getCharge(int daysRented) {
			double result = 1.5;
			if (daysRented > 3)
				result += (daysRented - 3) * 1.5;
			return result;
		}
	}
	class newReleasePrice extends Price {

		int getPriceCode() {
			return Movie.NEW_RELEASE;
		}

		@Override
		double getCharge(int daysRented) {
			return daysRented * 3;
		}
	}
	class RegularPrice extends Price {
		int getPriceCode() {
			return Movie.REGULAR;
		}

		@Override
		double getCharge(int daysRented) {
			double result = 2;
			if (daysRented > 2)
				result += (daysRented - 2) * 1.5;
			return result;
		}
	}


}
