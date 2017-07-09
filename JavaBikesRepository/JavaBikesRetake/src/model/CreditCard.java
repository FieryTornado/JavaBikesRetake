package model;

import database.ReadAndWrite;

public class CreditCard {
	
	private String cardHolder;
	private int cardNumber, monthExp, yearExp, cvc;
	
	//File to write Credit Card details to
		public void writeToFile(String details) {
			ReadAndWrite.writeDetails("CreditCard.txt", details);
		}
	
	//Getters and Setters
	public String getCardHolder() {
		return cardHolder;
	}
	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getMonthExp() {
		return monthExp;
	}
	public void setMonthExp(int monthExp) {
		this.monthExp = monthExp;
	}
	public int getYearExp() {
		return yearExp;
	}
	public void setYearExp(int yearExp) {
		this.yearExp = yearExp;
	}
	public int getCvc() {
		return cvc;
	}
	public void setCvc(int cvc) {
		this.cvc = cvc;
	} 
}