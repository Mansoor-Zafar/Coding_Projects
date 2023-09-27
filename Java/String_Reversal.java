package test;
/*
 * Project Name: String Reversal 
 * -------------
 * TECHNICAL
 * -------------
 * This project will return the inverse of a String
 * -------------
 * NON-TECHNICAL
 * -------------
 * The user will enter some text and the output will be in reverse
*/
import java.util.Scanner;
class compiler {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // Initialize the scanner
		System.out.println("Please Enter a String of Text: ");
		String str = scan.nextLine(); // get user input and assign it to String "str"
		String result = "";
		for(int i = str.length()-1; i >= 0; i--) {
			//loop for the entirety of the string's length
			result += str.substring(i, i+1); // add on the last character of the word onto a new string
			//System.out.println(str.substring(i, i+1));
		}
		System.out.println(str + " backwords is : " + result);
	}
}
