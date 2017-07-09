package view;

import java.io.IOException;
import java.util.*;
import model.*;
import control.Control;

public class WelcomeView {
	
	Scanner input = new Scanner(System.in);
	
	Control controllerClass = new Control();
	Customer customerClass = new Customer();
	CreditCard creditCardClass = new CreditCard();
	
	public void welcomeMenu() throws IOException {
		
		//Method to print welcomeMenu
		controllerClass.printwelcomeMenu();
		
		//try catch so the app still runs even with wrong input
		do
		{
			try
			{
				int selectwelcomeMenu = input.nextInt();
				switch (selectwelcomeMenu) 
				{
				case 1:
				controllerClass.printCreateCustomer();
				
				//inner switch
				int selectCreateNewCustomer = input.nextInt();
				switch (selectCreateNewCustomer) 
				{
				case 1:
					Customer customer = new Customer();
					customer = controllerClass.createCustomer();
					
					//write details to file
					String details = customer.getFirstName() + ";" + customer.getLastName()
					+ ";" + customer.getUsername() + ";" + customer.getPassword() + ";";
					
					customerClass.writeToFile(details);
					
					//Loading welcome menu to avoid getting stuck
					welcomeMenu();
					break;
					
				case 2:
					//calling welcome menu
					welcomeMenu();
					break;
 				}
				
				case 2:
					//print method for customer login
					controllerClass.printCustomerLogin();
					
					//inner switch
					int selectCustomerLogin = input.nextInt();
					switch (selectCustomerLogin) 
					{
					
					case 1:
						controllerClass.loginAsCustomer();
						break;
						
					case 2:
						welcomeMenu();
						break;						
					}
					
				case 3:
					//method to browse products
					controllerClass.browseProducts();
					
					//method to print products
					controllerClass.printProducts();
					
					//inner switch
					int selectProductMenu = input.nextInt();
					switch (selectProductMenu) 
					{
					case 1:
						//loading welcome menu
						welcomeMenu();
						break;					
					}
					
				case 4:
					//closing the app
					System.out.println("The Program will now shut down");
					System.exit(0);
					break;
					
					default:
						System.out.println("\nChoose a number from 1 to 4: ");
						input.next();
						break;
				}				
			} 
			
			catch (InputMismatchException e) 
			{
				System.out.println("\nChoose a number from 1 to 4: ");
				input.next();
				break;
			}
		}
		while (true);
	}
}