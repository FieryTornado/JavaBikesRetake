package main;

import java.io.IOException;
import view.WelcomeView;

public class MainMethod {
	
	//Initializing View
	static WelcomeView welcomeV = new WelcomeView();

	//Main Method of Program
	public static void main(String[] args) throws IOException {
		
		welcomeV.welcomeMenu();
	}
}