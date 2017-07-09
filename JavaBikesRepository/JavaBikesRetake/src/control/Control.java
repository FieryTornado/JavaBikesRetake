package control;

import java.io.*;
import java.util.*;

import database.ReadAndWrite;
import model.*;
import view.*;

public class Control {
	
	private ArrayList<Customer>CustomerArrayList = new ArrayList<Customer>();
	
	static WelcomeView welcomeV = new WelcomeView();
	static CustomerView customerView = new CustomerView();

	//Method to print welcomeMenu
	public void printwelcomeMenu() {
		System.out.println("Welcome to Java Bikes! Choose one of the numbers to continue");
		System.out.println("|1| Create an account" );
		System.out.println("|2| Login" );
		System.out.println("|3| Browse bikes" );
		System.out.println("|4| End Session" );
		
	}

	//Method to print switch text for creating customer
	public void printCreateCustomer() 
	{
		System.out.println("\nEnter 1 to create your account with Java Bikes. ") ;
	}

	// Method to create customer account
	public Customer createCustomer() throws FileNotFoundException, IOException
	{
		Scanner input = new Scanner (System.in);
		String details;
		Customer customer = new Customer();
		
		do
		{
			System.out.println("Enter your First Name: ");
			details = input.nextLine();
			
			if (details.matches("[a-zA-Z]+"))
			{
				customer.setFirstName(details);
			}
			else 
			{
				System.out.println("You must use Latin Characters");
				details = null;
			}
		}
		
		while (details == null);
		
		do 
		{
			System.out.println("Enter your Last Name: ");
			details = input.nextLine();
			
			if (details.matches("[A-Za-z]+"))
			{
				customer.setLastName(details);
			}
			else 
			{
				System.out.println("You must use Latin Characters");
				details = null;
			}
		}
		
		while (details == null);
		
		System.out.println("Enter a username: Must be at least 5 letters: ");
		details = checkusername(input);
		customer.setUsername(details);
		
		do
		{
			System.out.println("Enter a password: Must be at least 4 characters and contain at least 1 letter and number ");
			details = input.nextLine();
			//regex expression to ensure that password has both letters and numbers
			if (details.matches("([A-Za-z0-9]).{4,}")) 
			{
				customer.setPassword(details);
			}
			else
			{
				System.out.println("Wrong password format. Pls try again. ");
				details = null;
			}
		}
		while (details == null);
		System.out.println("Congratulations! Your account has been created: Enter 2 to login");
	
		return customer;
	}

	public String checkusername(Scanner input) 
	{
		String username = input.nextLine();
		
		for (int i=0; i<CustomerArrayList.size(); i++)
			
		if(!CustomerArrayList.get(i).getUsername().equals(username) || username.length() < 5)
		{
		System.out.println("Username not accepted");
		return checkusername(input);
		}
		return username;
	}
	
	public void reloadCustomerDabase() {
		CustomerArrayList = ReadAndWrite.getAllCustomerDetails();
	}

	public CreditCard createNewCreditCard() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Method to login as customer
	public void printCustomerLogin() {
		System.out.println("\n|1| Log in" + "\n|2| Return to Welcome Screen");		
	}

	public void loginAsCustomer() {
		Scanner input = new Scanner(System.in);
		String username;
		String password;
		
		int attempt = 0;
		if (attempt == 2)
		{
			System.out.println("You have attempted 3 logins in a row. Log in has been closed. Try again later");
			System.exit(0);
		}
		
		boolean loggedIn = false;
		do
		{
			attempt++;
			
			System.out.println("Enter your username ");
			username = input.next();
			
			System.out.println("Enter your password ");
			password = input.next();
			
			for (int i = 0; i < CustomerArrayList.size() && !loggedIn; i++)
			{
				if(username.equalsIgnoreCase(CustomerArrayList.get(i).getUsername()) &&
						password.equalsIgnoreCase(CustomerArrayList.get(i).getPassword()))
				{
					System.out.println("You have slogged in. Welcome " + username + ".");
					loggedIn = true;
				}
			}
			if(!loggedIn)
			{
				System.out.println("Wrong username or password. Please Try again");
			}
		}
		while (attempt < 3 && !loggedIn);
		customerView.customerMenu();


	}

	public void browseProducts() {
		// TODO Auto-generated method stub
		
	}

	public void printProducts() {
		// TODO Auto-generated method stub
		
	}
}