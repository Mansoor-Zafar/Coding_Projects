package fpg;

public class Main {
	public static void main(String[] args)
	{

    //Use an existing User
		User user = new User("Swiper", "thefox", 1000, "swipy@thefox.ca");
		ATM atm = new ATM(user);
		atm.menu();

    //use a new user:
		ATM at = new ATM();
		at.menu();
	}
}
