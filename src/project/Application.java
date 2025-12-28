package project;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainException;

public class Application {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
			
			try {
				System.out.println("Enter account data: ");
				
				System.out.print("Number: ");
				int numberAccount = sc.nextInt();
				
				
				System.out.print("Holder: ");
				String holder = sc.next();
				
				sc.nextLine();
				
				System.out.print("Initial balance: ");
				double balance = sc.nextDouble();
				
				System.out.print("Withdraw Limit: ");
				double withdrawLimit = sc.nextDouble();
				
				Account account = new Account(numberAccount, holder, balance, withdrawLimit);
				
				System.out.println("");
				
				System.out.print("Enter amount for withdraw: ");
				double amount = sc.nextDouble();
				
				account.withdraw(amount);
				
				System.out.println(account.toString());
				
			}
			catch(DomainException exception){
				System.out.println(exception.getMessage());
			}
			sc.close();
	}
	
}
