package database;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import model.Customer;

public class ReadAndWrite 
{

	public static Customer getCustomer(String line) 
	{
		
		Customer customerFromFile = new Customer();
		//Looks for every ";" and changes into string
		String[] values= line.split(";");
		
		//Changes String type into corrtect format
		customerFromFile.setFirstName(values[0]);
		customerFromFile.setLastName(values[1]);
		customerFromFile.setUsername(values[2]);
		customerFromFile.setPassword(values[3]);
		
	return customerFromFile;
	}
	
	//method to write details to file
	public static void writeDetails(String file, String input) 
	{
		try {
			FileWriter fwriter = new FileWriter (file, true);
			PrintWriter output = new java.io.PrintWriter(fwriter);
			
			output.println(input);
			output.close();
		}
		catch (IOException ex) 
		{
			System.out.println("Error writing to the file" + file + ".");
		}		
	}

	public static ArrayList<Customer> getAllCustomerDetails() 
	{
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		Scanner input = readDetails("Customer.txt");
		
		while (input.hasNextLine()) 
		{
			customerList.add(getCustomer(input.nextLine()));
		}
		
		return customerList;
	}

	//Method to read customer details
	public static Scanner readDetails(String file) 
	{
		Scanner input = new Scanner (System.in);
		
		try 
		{
			java.io.File ReadFile = new java.io.File(file);
			input = new Scanner(ReadFile);
		}
		catch (FileNotFoundException ex) 
		{
			System.out.println("Error reading the file" + file + ".");
		}
		return input;
	}
}