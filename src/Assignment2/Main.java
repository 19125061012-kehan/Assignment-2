package Assignment2;

public class Main {

	public static void main(String[] args) {

		TravelTour[] travelTours = new TravelTour[4];
		travelTours[0] = new TravelTour("Guangzhou -> Chongqing -> Guangzhou\n", 1200, 980, 14);
		travelTours[1] = new TravelTour("Beijing -> Jinan\n", 400, 320, 5);
		travelTours[2] = new TravelTour("Shenyang ->  Harbin -> Shenyang\n", 780, 650, 8);
		travelTours[3] = travelTours[0];
		
		Menu Menu = new Menu(travelTours);
		Menu.run();

	}

}
