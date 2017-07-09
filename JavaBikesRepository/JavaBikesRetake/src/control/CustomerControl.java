package control;

import java.io.*;
import java.util.*;
import database.*;
import model.*;
import view.*;

public class CustomerControl {
	
	private ArrayList<Customer>CustomerArrayList = new ArrayList<Customer>();
	
	WelcomeView welcomeView = new WelcomeView();
	CustomerDB customerDB = new CustomerDB();
	Control controllerClass = new Control();
	
	CustomerView cView;
	
	public CustomerControl() {
		CustomerArrayList = ReadAndWrite.getAllCustomerDetails();
	}
}