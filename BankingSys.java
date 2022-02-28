package atm;

public class BankingSys extends User {
	User users;
	public BankingSys(String lastName, String firstName, int pin, int totalBalance, int accountNumber) {
	        super(lastName, firstName, pin, totalBalance, accountNumber);
	}
	        
	public int withdrawlMoney(int moneyWithdrawn){
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
		
	}
}
