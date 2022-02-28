package atm;

import java.awt.EventQueue;

public class User {
	public int pin;
    public String firstName;
    public String lastName;
    public int totalBalance;
    public int accountNumber;
    
    public User(String firstName, String lastName, int pin, int totalBalance, int accountNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
        this.totalBalance = totalBalance;
        this.accountNumber = accountNumber;
    }
    
    public void setPin(int pin) {
        int length = String.valueOf(pin).length();
        if (length != 4) {
            throw new IllegalArgumentException();
        }
        this.pin = pin;
    }
    
    public int getPin() {
        return pin;
    }
    
    public void setFirstName(String firstName) {
        int d = Integer.parseInt(firstName);
        int length = String.valueOf(d).length();
        if (firstName == null || firstName.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (length >= 0) {
            throw new IllegalArgumentException();
        }
        if (firstName == null) {
            throw new IllegalArgumentException();
        }
        this.firstName = firstName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setLastName(String lastName) {
        int d = Integer.parseInt(lastName);
        int length = String.valueOf(d).length();
        if (lastName == null || lastName.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (length >= 0) {
            throw new IllegalArgumentException();
        }
        this.lastName = lastName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setTotalBalance(int totalBalance) {
        if (totalBalance < 0) {
            throw new IllegalArgumentException();
        }
        this.totalBalance = totalBalance;
    }
    
    public int getTotalBalance() {
        return totalBalance;
    }
    
    public void setAccountNumber(int accountNumber) {
        int length = String.valueOf(accountNumber).length();
        if (length != 10) {
            throw new IllegalArgumentException();
        }
        this.accountNumber = accountNumber;
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }
    
    //logic for banking system
    public int withdrawlMoney(int moneyWithdrawn){
    	if(moneyWithdrawn > this.totalBalance) {
    		throw new IllegalArgumentException();
    	}
        this.totalBalance = this.totalBalance - moneyWithdrawn;
        return totalBalance;
    }
    
    public int depositMoney(int moneyDeposited) {
        this.totalBalance = this.totalBalance + moneyDeposited;
        return totalBalance;
    }
    
    public boolean correctLogin(int accountNumber, int pin) {
	if (this.accountNumber == accountNumber && this.pin == pin) {
		return true;
    }
        return false;
    }

    public static void main(String[] args) {
    	//User user1 = new User("Caleb", "Roe", 1111, 1400, 1001);
    }
}
	


