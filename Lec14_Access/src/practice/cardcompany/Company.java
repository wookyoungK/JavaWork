package practice.cardcompany;

public class Company {
	
	private static Company instance = null;
	
	private int CardNumber = 10000;
	
	private Company() {}
	
	public static Company getInstance() {
		if (instance == null) {
			instance = new Company(); // 인스턴스생성
		} // 하나만생성하게 하도록 만든다.
		return instance;
	}

	public Card createCard() {
		CardNumber++;
		Card a = new Card(CardNumber);

		
		return a;
	}


} // end class
