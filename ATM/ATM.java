package fpg;
import java.util.Scanner;
public class ATM {

	User user = null;
	int pin;
	boolean enteredPin = false;
	
	
	//@Constructor
	public ATM()
	{
		this.user = new User();
		this.pin = 0;
		this.enteredPin = false;
	}
	
	
	//@Constructor
	public ATM(User user)
	{
		this.user = user;
		this.pin = 0;
		this.enteredPin = false;
	}
	
	
	
	
	public void menu()
	{
		printHeader();
		
		System.out.print("> ");
		Scanner scan = new Scanner(System.in);
		String choice = scan.nextLine();
		choice = choice.toLowerCase();
		
		while(  !"1".equals(choice) && !"2".equals(choice) 
			 && !"3".equals(choice) && !"4".equals(choice) && 
				!"5".equals(choice))
		{
			System.out.print("Invalid Selection Please Choose from\n"
					+ "1. Withdraw\n"
					+ "2. Check Balance\n"
					+ "3. Transfer\n"
					+ "4. Deposit\n"
					+ "5. Exit\n"
					+ "> ");
			choice = scan.nextLine();
			choice = choice.toLowerCase();
		}
		switch(choice)
		{
		case "1": withdraw(); break;
		case "2": checkBal(); break;
		case "3": transfer(); break;
		case "4":  deposit(); break;
		default: System.out.println("--------\nGoodbye!\n--------\n"); return;
		}
		
		System.out.println("Please Choose to go back to the Main Menu or Exit\n"
				+ "(E)xit\n"
				+ "(M)ain Menu");
		System.out.print("> ");
		choice = scan.nextLine();
		choice = choice.toLowerCase();
		while(!"e".equals(choice) && !"m".equals(choice))
		{
			System.out.println("Invalid Choice..."
					+ "\nPlease Choose to go back to the Main Menu or Exit\n"
					+ "(E)xit\n"
					+ "(M)ain Menu");
			System.out.print("> ");
			choice = scan.nextLine();
			choice = choice.toLowerCase();
		}
		
		if(choice.equals("e"))
			return;
		
		this.menu();
	}
	
	
	
	private void enterPin(Scanner scan)
	{
		System.out.println("\n--------------");
		System.out.println("Please Enter your pin");
		System.out.print("> ");
		
		try
		{
			String x = scan.next();
			this.pin = Integer.parseInt(x);
			if(pin < 1000 || pin > 9999)
			{
				System.out.println("ERROR: INVALID PIN");
				enterPin(scan);
			}
			else
			{
				System.out.println("--------------\n");
				this.enteredPin = true;
			}
			
		}catch(Exception e)
		{
			System.out.println("ERROR: INVALID PIN");
			enterPin(scan);
		}
		
	}
	
	
	
	private void checkBal()
	{
		Scanner scan = new Scanner(System.in);
		if(!this.enteredPin)
			enterPin(scan);
		
		System.out.println("You're current balance is : $" + this.user.bal());
		System.out.println("-------------------------------------------------\n");
	}
	
	
	
	private void transfer()
	{
		System.out.println("\n-------------------------------------------------");
		
		Scanner scan = new Scanner(System.in);
		if(!this.enteredPin)
			enterPin(scan);
		
		String recipient = null;
		System.out.print("Enter the email of the recipient\n"
				+ "> ");
		recipient = scan.nextLine();
		
		
		System.out.print("How much would you like to send?\n"
				+ "> ");
		String tmp;
		double amount = -1;
		while(amount < 0)
		{
			try
			{
				tmp = scan.next();
				amount = Double.parseDouble(tmp);
				
			}catch (Exception e)
			{
				System.out.print("Invalid Input...\nTry again"
						+ "\n> ");
			}
		}
		
		
		
		if(this.user.getMail().equals(recipient))
		{
			System.out.println("Sending to yourself? Alright");
			System.out.println("Sent.... ok");
			return;
		}
		
		this.user.setBal(this.user.bal() - amount);
		
		System.out.println("Sent $" + amount + " to " + recipient);
		
		System.out.println("-------------------------------------------------\n");
	}
	
	
	
	private void deposit()
	{
		Scanner scan = new Scanner(System.in);
		if(!this.enteredPin)
			enterPin(scan);
		
		System.out.print("How much would you like to Deposit?\n"
				+ "> ");
		String tmp;
		double amount = -1;
		while(amount < 0)
		{
			try
			{
				tmp = scan.next();
				amount = Double.parseDouble(tmp);
				if(amount < 0)
				{
					System.out.print("Amount must be > 0\n"
							+ "> ");
				}
				
			}catch (Exception e)
			{
				System.out.print("Invalid Input...\nTry again"
						+ "\n> ");
			}
		}
		
		this.user.setBal(this.user.bal() + amount);
		
		
		System.out.println("deposit");
	}
	
	
	
	
	private void withdraw()
	{
		
		Scanner scan = new Scanner(System.in);
		if(!this.enteredPin)
			enterPin(scan);
		
		
		if(this.user.bal() < 0)
		{
			System.out.println("Sorry, you are in debt\n"
					+ "Pay off your current debt of : $" + this.user.bal() + " first.");
			return;
		}
		
		System.out.println("Withdraw \t\tHello, " + this.user.getUsername());
		System.out.print("Select an account:\n"
				+ "1. Checking\n"
				+ "2. Savings\n"
				+ "3. Credit Card\n"
				+ "> ");
		String choice = scan.next();
		while(!"1".equals(choice) && !"2".equals(choice) && !"3".equals(choice))
		{
			System.out.println("\nInvalid Choice, try again...\n");
			System.out.print("Select an account:\n"
					+ "1. Checking\n"
					+ "2. Savings\n"
					+ "3. Credit Card\n"
					+ "> ");
			choice = scan.next();
		}
		switch(choice)
		{
		case "1": choice="Checking"; 	break;
		case "2": choice="Saving"; 		break;
		default:  choice="Credit Card"; break;
		}
		System.out.println("Withdraw \t\tFrom: " + choice);
		System.out.print("How much would you like to withdraw?\n"
				+ "> ");
		
		String tmp;
		double amount = -1;
		while(amount < 0)
		{
			try
			{
				tmp = scan.next();
				amount = Double.parseDouble(tmp);
				
			}catch (Exception e)
			{
				System.out.print("Invalid Input...\nTry again"
						+ "\n> ");
			}
		}
		
		if(this.user.bal() - amount < 0)
		{
			System.out.print("Do you wish to continue?\nYou account will be in debt if you continue\n"
					+ "You will not be able to take out money until you've paid off your debt\n"
					+ "(Y)es to continue\n"
					+ "Anything else to abort\n"
					+ "> ");
			choice = scan.next();
			if(!"y".equalsIgnoreCase(choice))
			{
				return;
			}
		}
		this.user.setBal(this.user.bal() - amount);
	}
	
	
	
	private void printHeader()
	{
		System.out.println(
				"|---------------------------------------------------------------|\n" +
						"|			    COMPANY				|\n" +
						"|								|\n" +
						"|			    WELCOME				|\n" +
						"|								|\n" +
						"|		    What would you like to do?		  	|\n" +
						"|								|\n" + 
						"|								|\n" + 
						"|	1. Withdraw						|\n" +
						"|								|\n" + 
						"|	2. Check Balance					|\n" +
						"|								|\n" +
						"|	3. Transfer 						|\n" +
						"|								|\n" + 
						"|	4. Deposit						|\n" +
						"|								|\n" +	
						"|	5. Exit							|\n" +	
						"|---------------------------------------------------------------|\n");
	}
}
