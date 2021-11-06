package Assignment2;

public class Pay {
	private Customer customer;
	private boolean isPay;
	public Pay(Customer customer) {
		this.setCustomer(customer);
		setPay(false);
	}
	public Customer getCustomer() {
		return customer;
		
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public boolean isPay() {
		return isPay;
	}
	public void setPay(boolean isPay) {
		this.isPay = isPay;
	}
}
