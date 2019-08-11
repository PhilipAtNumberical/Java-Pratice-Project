public class Ticket
{
	//final variables only instantiate once
	private final Customer customer; //make a object called customer using the Customer class
	private final Film film; //make a object called film using the Film class
		
	//initialise the variables
	public Ticket(Customer customer, Film film)
	{
		this.customer = customer;
		this.film = film;
	}
	
	//method for calculating the cost of ticket(s)
	public double cost()
	{
		int customerAge = this.customer.getAge();
		double cost = 0;
		if(customerAge >= 18)
		{
			cost = 10;
		}
		else
		{
			cost = 7;
		}
		
		boolean isStudent = this.customer.isStudent();
		if(isStudent)
		{
			//if age is between 8~20 (inclusive) and student, give 20% discount
			if((customerAge >= 8) && (customerAge <= 20))
			{
				cost = cost * 0.8;
			}
			//if age is above 25 and student, give 7% discount
			else if(customerAge >= 25)
			{
				cost = cost * 0.93;
			}
			else
			{
				//no further discount
			}
		}
		//if age is 70 and above and not student, give 5% discount.
		else
		{
			if(customerAge >= 70)
			{
				cost = cost * 0.95;
			}
		}
		
		return cost;
	}
	
	public Film getFilm()
	{
		return this.film;
	}
	
	public Customer getCustomer()
	{
		return this.customer;
	}
	
	public String toString()
	{
		String printReceipt = "----------------------------------------- \n";
		printReceipt = printReceipt + "FILM TICKET for: " + this.film.toString();
		printReceipt = printReceipt + "CUSTOMER DETAILS: " + this.customer.toString();
		printReceipt = printReceipt + "TOTAL COST: " + String.format("%.1f", this.cost()) + "\n";
		printReceipt = printReceipt +  "----------------------------------------- \n";
		return printReceipt;
	}
}