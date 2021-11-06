package Assignment2;
import java.util.Scanner;
public class Menu {	
	private Scanner scan;
	private TravelTour[] travelTours;
	private Customer customer;
	private Pay pay;
	private int choice=0;
	public Menu(TravelTour[] travelTours) {
		this.scan = new Scanner(System.in);
		this.travelTours = travelTours;
		}
	
	
	public void run() {
		for(int i=0;true;i++) {
			System.out.println();
			System.out.print("YOUR MEMU: \n");
			System.out.print("1. Add a new passenger to a travel tour (FR-3)\n");
			System.out.print("2. Allow a passenger to make their payment (FR-4)\n");
			System.out.print("3. Display details of a travel tour (FR-5)\n");
			System.out.print("4. Mark a particular travel tour as now departed (FR-6)\n");
			choice = scan.nextInt();	
			if(choice==1) {
				AddTravelDetails();

			}
			else if(choice==2) {
				AllowCustomerPay();

			}
			else if(choice==3) {
				displayTravelDetails();
			
			}
			else if(choice==4) {
				SpecificTravel();
				
			}
			else{
				
				System.out.print("Error");
			}	
		}
	}
	
	
	public void AddTravelDetails() {
		String name;
		String requirement;
		int age;
		System.out.println("Please enter the name of the passenger: ");
		scan.nextLine();
		name = scan.nextLine();
		System.out.println("Please enter the age of Tim Morrison: ");
		age = scan.nextInt();
		System.out.print("Please enter any dietary requirements of Tim Morrison: \n");
		scan.nextLine();
		requirement = scan.nextLine();
		customer = new Customer(name, age, requirement);		
		System.out.println("The following travel tours are available: ");
		for (int i = 0; i < travelTours.length; i++) {
			System.out.print("\t " + (i+1) + ". " + travelTours[i].getRoute());
		}
		System.out.print("Enter selection of which travel tour to add Tim Morrison to: ");
		choice = scan.nextInt();
		if (choice > travelTours.length || choice < 1) {
			System.out.println("Error");
			return ;
		}		
		pay = new Pay(customer);
		travelTours[choice].addPay(pay);
		System.out.println("Tim Morrison has been added to the travel tour: " + travelTours[choice].getRoute());
		System.out.println("and needs to pay " + travelTours[choice].getPrice(customer.getAge()) + " to confirm the booking on this travel tour.");		
	}
	
	
	public void AllowCustomerPay() {
		System.out.println("The following travel tours are available: ");
		for (int i = 0; i < travelTours.length; i++) {
			System.out.println("\t " + (i+1) + ". " + travelTours[i].getRoute());
		}
		System.out.print("Select the route booked by the passenger: ");
		choice = scan.nextInt();
		if (choice > travelTours.length || choice < 1) {
			System.out.println("Invalid input");
			return ;
		}		
		System.out.println();
		System.out.println("The list of passengers who are paying for this tour: ");
		System.out.println(" number \t name \t age \t cost:");
		Pay[] travelPays = travelTours[choice].getPays();
		for (int i = 0; i < travelTours[choice].getPayIndex(); i++) {
			if (!travelPays[i].isPay()) {
				System.out.printf(" %d \t %s \t %s \t %.0f \n",i+1,travelPays[i].getCustomer().getName(),travelPays[i].getCustomer().getAge(),travelTours[choice].getPrice(travelPays[i].getCustomer().getAge()));
			}
		}
		System.out.print("Select a specific passenger for payment: ");
		int t = scan.nextInt();
		if (t > travelTours.length || t < 1) {
			System.out.println("Invalid input");
			return ;
		}
		pay = travelPays[t-1];
		System.out.println();
		if (!pay.isPay()) {
			System.out.println("Please confirm whether to make payment (Y or y)");
			if (scan.next().trim().equalsIgnoreCase("y")) {
				pay.setPay(true);
				System.out.println("Confirm payment success");
			}
		} else {
			System.out.println("It has been skipped and cannot be modified. Please choose another route or passenger");
		}	
	}
	
	
	public void displayTravelDetails() {

		System.out.println("Please select the number you want to view");
		choice = scan.nextInt();	

		if (choice > travelTours.length || choice < 1) {
			System.out.println("Invalid input");
			return ;
		}
		System.out.println("Travel tour journey: " + travelTours[choice].getRoute() + " ("+ travelTours[choice].getDuration() + " days days)");
		if (travelTours[choice].isStart()) {
			System.out.println("This travel tour has begun");
		}else {
			System.out.println("This travel tour has not yet begun");
		}
		System.out.println("There are "+travelTours[choice].getPayNumber()+" confirmed bookings and "+(travelTours[choice].getPayIndex()-travelTours[choice].getPayNumber())+" unconfirmed bookings");
		System.out.println("The following passengers are confirmed:");
		System.out.println("  Name       Age     Diet Requirements:");
		Pay[] travelPays = travelTours[choice].getPays();
		double cost = 0;
		for (int i = 0; i < travelTours[choice].getPayIndex(); i++) {
			cost += travelTours[choice].getPrice(travelPays[i].getCustomer().getAge());
			System.out.printf(" %s \t %d \t %s \n",travelPays[i].getCustomer().getName(),
					travelPays[i].getCustomer().getAge(),travelPays[i].getCustomer().getDietaryRequirements());
		}
		System.out.printf("Total receipts from confirmed bookings: %.0f \n", cost);
	}
	
	
	public void SpecificTravel() {
		System.out.println("Please select a specific travel itinerary that will be set to depart");
		int input = scan.nextInt();
		if (input > travelTours.length || input < 1) {
			System.out.println("Invalid input");
			return ;
		}
		input--;
		
		if (travelTours[input].getPayNumber() == 0) {
			System.out.println("Passengers found to have not paid for this selected trip cannot be changed to departure  ");
			return;
		}
		
		if (travelTours[input].isStart()) {
			System.out.println("Unable to operate, the selected journey has already started");
			return;
		}
		
		travelTours[input].setStart(true);
		System.out.println("itinerary\t time(by days)");
		System.out.printf("%s \t %d \n",travelTours[input].getRoute(),travelTours[input].getDuration());
		
		Pay[] travelPays = travelTours[input].getPays();
		System.out.println("List of all passengers on the trip: ");
		for (int i = 0; i < travelTours[input].getPayIndex(); i++) {
			if (travelPays[i].isPay()) {
				System.out.printf(" %s \t %d \t %s \n",travelPays[i].getCustomer().getName(),
					travelPays[i].getCustomer().getAge(),travelPays[i].getCustomer().getDietaryRequirements());
			}
		}
		System.out.println("All other lists of scheduled unit payments: ");
		for (int i = 0; i < travelTours[input].getPayIndex(); i++) {
			if (!travelPays[i].isPay()) {
				System.out.printf(" %s \t %d \t %s \n",travelPays[i].getCustomer().getName(),
					travelPays[i].getCustomer().getAge(),travelPays[i].getCustomer().getDietaryRequirements());
			}
		}
	}
}
	

