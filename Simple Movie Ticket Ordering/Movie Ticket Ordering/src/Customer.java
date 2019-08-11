public class Customer
{
	private String customerName;
	private int customerAge;
	private boolean customerIsStudent;
	
	//default Customer constructor, details is encapsulated
	public Customer()
	{
		//instantiate variables and initiate initial value 
		this.customerName = "";
		this.customerAge = 0;
		this.customerIsStudent = false;
	}
	
	//Constructor for obtaining customer details
	public Customer(String name, int age, boolean isStudent)
	{
		this.customerName = name;
		this.customerAge = age;
		this.customerIsStudent = isStudent;
	}
	
	//method for returning inputs to customer object
	public String toString()
	{
		String customerDetail = "";
		customerDetail = customerDetail + this.customerName;
		customerDetail = customerDetail + " age: " + Integer.toString(this.customerAge);
		customerDetail = customerDetail + " Student?";
		if(customerIsStudent)
		{
			customerDetail = customerDetail + " Yes \n";
		}
		else
		{
			customerDetail = customerDetail + " No \n";
		}
		
		return customerDetail;
	}
	
	//constructor for getting customer's name
	public String getName()
	{
		return this.customerName;
	}
	
	//constructor for setting customer's name
	public void setName(String name)
	{
		this.customerName = name;
	}
	
	//constructor for getting customer's age
	public int getAge()
	{
		return this.customerAge;
	}
	
	//constructor for setting customer's age
	public void setAge(int age)
	{
		this.customerAge=age;
	}
	
	//constructor for checking is customer a student or not
	public boolean isStudent()
	{
		return this.customerIsStudent;
	}
	
	//constructor for setting is customer a student or not
	public void setStudent(boolean isStudent)
	{
		this.customerIsStudent = isStudent;
	}
}