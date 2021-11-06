package Assignment2;

public class Customer {
	
	private String name;
	private int age;
	private String dietaryRequirements;
	

	public Customer(String name, int age, String dietaryRequirements) {
		setName(name);
		setAge(age);
		setDietaryRequirements(dietaryRequirements);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age > 0) {
			this.age = age;
		}
	}

	public String getDietaryRequirements() {
		return dietaryRequirements;
	}

	public void setDietaryRequirements(String dietaryRequirements) {
		this.dietaryRequirements = dietaryRequirements;
	}
}
