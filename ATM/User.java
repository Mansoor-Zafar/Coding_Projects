package fpg;
import java.util.Scanner;

public class User {
	
	private String username;
	private String password;
	private double balance;
	private String mail;
	//Constructors
	public User()
	{
		createUser();
	}
	
	public User(String username, String password, double balance, String mail)
	{
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.mail = mail;
	}
	
	public User(User user)
	{
		this.username = user.username;
		this.password = user.password;
		this.balance = user.balance;
		this.mail = user.mail;
	}
	
	private void createUser()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Hello new user!\n"
				+ "Enter a username to go by!\n"
				+ "> ");
		this.username = scan.nextLine();
		System.out.print("Enter a password that you'll remember!\n"
				+ "> ");
		this.password = scan.nextLine();
		
		
		System.out.print("Enter your mail!\n"
				+ "> ");
		this.mail = scan.nextLine();
		
		System.out.print("Enter your current balance!\n"
				+ "> ");
		
		try
		{
			String tmp = scan.next();
			this.balance = Double.parseDouble(tmp);
		}catch(Exception e)
		{
			System.out.println("ERROR: INVALID INPUT");
			createUser();
		}
	}
	
	public String getUsername()
	{
		return this.username;
	}
	
	public double bal()
	{
		return this.balance;
	}
	
	public void setBal(double value)
	{
		this.balance = value;
	}
	
	public String getMail()
	{
		return this.mail;
	}
  
}
