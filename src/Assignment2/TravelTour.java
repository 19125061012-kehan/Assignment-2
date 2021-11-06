package Assignment2;

public class TravelTour {
	private static int count=0;
	
	private int tour;
	private String route;
	private double Adultprice;
	private double Concessionprice;
	private int duration;
	
	private Pay[] Pays;
	private int payIndex = 0;	
	private int payNumber = 0;	
	
	private boolean isStart;	
	
	public TravelTour(String route, double Adultprice, double Concessionprice, int duration) {
		tour = ++count;
		this.route = route;
		this.Adultprice = Adultprice;
		this.Concessionprice = Concessionprice;
		this.duration = duration;
		
		this.Pays = new Pay[20];
	}
	
	public double getPrice(int age) {
		return (age<18||age>65) ? Concessionprice : Adultprice;
	}
	
	

	public void addPay(Pay Pay) {
		if (Pay != null && this.payIndex < this.Pays.length) {
			this.Pays[this.payIndex++] = Pay;
		}
	}
	

	public void updateLastPay(Pay Pay) {
		if (Pay != null && this.payIndex > 0) {
			this.setPayNumber(this.getPayNumber() + 1);
			this.Pays[this.payIndex-1] = Pay;
		}
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		TravelTour.count = count;
	}

	public int getTour() {
		return tour;
	}

	public void setTour(int tour) {
		this.tour = tour;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public double getAdultprice() {
		return Adultprice;
	}

	public void setAdultprice(double adultprice) {
		Adultprice = adultprice;
	}

	public double getConcessionprice() {
		return Concessionprice;
	}

	public void setConcessionprice(double concessionprice) {
		Concessionprice = concessionprice;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Pay[] getPays() {
		return Pays;
	}

	public void setPays(Pay[] pays) {
		Pays = pays;
	}

	public int getPayIndex() {
		return payIndex;
	}

	public void setPayIndex(int payIndex) {
		this.payIndex = payIndex;
	}

	public int getPayNumber() {
		return payNumber;
	}

	public void setPayNumber(int payNumber) {
		this.payNumber = payNumber;
	}

	public boolean isStart() {
		return isStart;
	}

	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}

}
