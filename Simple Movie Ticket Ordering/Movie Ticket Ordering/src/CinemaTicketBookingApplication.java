import java.util.InputMismatchException;
import java.util.Scanner;

public class CinemaTicketBookingApplication
{
	//scan for user keyboard input
	static Scanner keyInput = new Scanner(System.in);
	//array of movies with their rating
	static Film[] films = { new Film("Ant-Man", Rating.PARENTALGUIDANCE),  new Film("Minions", Rating.PARENTALGUIDANCE),
			new Film("Jurassic World", Rating.MATURE),  new Film("Inside Out", Rating.GENERAL)};
	static int NUMBER_OF_FILMS = 4;
	
	//main function
	public static void main(String[] args)
	{
		//instantiate variables
		Customer customer = null;
		Film film = null;
		Ticket ticket = null;
		
		//print welcome message
		System.out.println("Welcome to the Cinema Ticket Purchasing System");
		
		//obtain customer details, movie to watch, number of tickets, costs etc....
		while(true)
		{
			customer = customerDetailsInput();
			film = filmSelection();
			ticket = issueTicket(customer, film);
			if(ticket != null)
			{
				System.out.println(ticket.toString());
			}
			else
			{
				System.out.println("Sorry, cannot issue ticket for age restricted film");
			}
			
			//prompt to enquire for another purchase, regardless to if previous one is issued or  not
			System.out.println("Issue another ticket? (Y/N)");
			if(keyInput.hasNext())
			{
				String input = keyInput.nextLine();
				input = keyInput.nextLine();
				//break from this loops if user prompt N, No, NO, or empty reply
				if(input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no"))
				{
					break;
				}
			}
		}
	}
	
	//method for getting customer's detail
	private static Customer customerDetailsInput()
	{
		//instantiate local variables
		String name = "";
		int age = 0;
		boolean isStudent = false;
		boolean ok = false;
		
		System.out.println("Please enter your name: ");
		if(keyInput.hasNext())
		{
			//passing keyboard input to name
			String input = keyInput.nextLine();
			name = input;
			
			//passing keyboard input to age, after converting string to integer using Integer.parseInt()
			//use try-catch to catch exceptions that input is not a integer number
			while (!ok)
			{
				try
				{
					System.out.println("Please enter your age: ");
					Scanner scnr = new Scanner(System.in);
					int ageinput;
					ageinput = scnr.nextInt();
					age = ageinput;
					ok = true;
					scnr.close();
				}
				catch(InputMismatchException e)
				{
					System.out.println("Invalid input.  Interget only");
				}
			}
			
			//passing if customer is student or not for further discounts
			//keep prompting to ask if user a student, until either Y or N is typed in
			System.out.println("Are you a student? (Y/N)");
			input = keyInput.nextLine();
			while(!((input.equalsIgnoreCase("y")) || (input.equalsIgnoreCase("yes")) || (input.equalsIgnoreCase("n")) || (input.equalsIgnoreCase("no"))))
			{
				System.out.println("Are you a student? (Y/N)");
				input = keyInput.nextLine();
			}
			
			if(input.equalsIgnoreCase("y") || (input.equalsIgnoreCase("yes")))
			{
				isStudent = true;
			}
			else
			{
				isStudent = false;
			}
		}
		
		Customer customer = new Customer(name, age, isStudent);
		return customer;
	}
	
	//method for holding what film customer want to see
	private static Film filmSelection()
	{
		System.out.println("Which film would you like to watch: ");
		//print all available films stored in array
		for(int i = 0; i < NUMBER_OF_FILMS; i++)
		{
			System.out.print((i+1) + " " + films[i].toString());
		}
		
		int filmPosition = 0;
		boolean ok = false;
		if(keyInput.hasNext())
		{
			while(!ok)
			{
				try
				{
					int input = keyInput.nextInt();
					//just in case user input an integer number that is our of range
					if(input <= 0 || input > NUMBER_OF_FILMS)
					{
						String s = String.format("Input out of bounds, must be between %i to %i, please try again.", 1, NUMBER_OF_FILMS);
						System.out.println(s);
					}
					else
					{
						filmPosition = input - 1;
						ok = true;
					}
				}
				catch(InputMismatchException e)
				{
					System.out.println("Invalid input.  Interget only");
					//keyInput.hasNextInt();
				}
			}


		}
		
		return films[filmPosition];
	}
	
	//issue ticket with correct prices
	public static Ticket issueTicket(Customer customer, Film film)
	{
		int customerAge = customer.getAge();
		Rating filmRating = film.getRating();
		Ticket ticket = null;
		if(filmRating == Rating.GENERAL)
		{
			System.out.println("Your Ticket is ready to be collected! ");
			ticket = new Ticket(customer, film);
		}
		else if(filmRating == Rating.PARENTALGUIDANCE)
		{
			if(customerAge >= 12)
			{
				System.out.println("Your Ticket is ready to be collected! ");
				ticket = new Ticket(customer, film);
			}
			else
			{
				System.out.println("Underage!");
			}
		}
		else
		{
			if (customerAge >= 18) 
			{
				System.out.println("Your ticket is ready to be collected!");
				ticket = new Ticket(customer, film);
			}
			else
			{
				System.out.println("Underage!");
			}
		}
		
		return ticket;
	}
}