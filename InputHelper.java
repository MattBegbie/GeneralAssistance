/*
 * Assessment: None
 * Student Name: Matt Begbie
 * This is my custom made input helper, it makes inputs easier for projects, and organises recieveing different keyboard inputs
 * handles input exceptions and keeps them consistent
 * originally made for OOP, in march 2022, last updated may 2022
 * DECLARATION: I declare this is entirely my work, and is free from plagerism
 */


import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Helper class for receiving inputs, does not crash when wrong input is given.
 * @author Matt Begbie
 * @version 2.0
 * @since 1.8
 */
public class InputHelper {
	/**
	 * receives a scanner instance, and two strings, then returns the number that user inputed
	 * 
	 * @param input Scanner used for reading input (Scanner)
	 * @param message initial prompt to recieve number (String)
	 * @param failMessage prompt informing user the input is incorrect (String)
	 * @return num (int)
	 */
	public static int getInt(Scanner input, String message) {
		/*
		 * loop prompting for any int, if a different input type is given, 
		 * it will call an exception, print failMessage, 
		 * and then re-prompt if int is given, return
		 */
		int num = 0;
		while (true) {
			try {
				System.out.printf(message);
				num = input.nextInt();
				break;
			} catch(InputMismatchException e) {
				System.out.printf("\nIncorrect data type entered...\n");
			}catch(Exception e){
				System.out.printf("\nUnknown Error Occured...\n\n");
			} finally {
				input.nextLine();
			}
		}
		return num;
	}//end of getInt() method
	/**
	 * receives a scanner intance, an range of ints (inclusive), and two messages (prompt and fail)
	 * @param input Scanner used for reading input (Scanner) 
	 * @param bottom lowest int allowed (int)
	 * @param top highest int allowed (int)
	 * @param message initial prompt to recieve number (String)
	 * @param failMessage prompt informing user the input is incorrect (String)
	 * @return num (int)
	 */
	public static int getIntInRange(Scanner input, int bottom, int top, String message)  {
		/*
		 * similar structure to above getInt() 
		 * however there is a secondary check to make sure it is in range as well, 
		 * otherwise there will be a reprompt
		 */
		int num = 0;
		while (true) {
			try {
				System.out.printf(message);
				num = input.nextInt();
				if (num <= top && num >= bottom) {
					break;
				}
				System.out.printf("\nInput a number between %d and %d: ", bottom, top);
			} catch(InputMismatchException e) {
				System.out.printf("\nIncorrect data type entered...\nInput a number between %d and %d: ", bottom, top);
			}catch(Exception e){
				System.out.printf("\nUnknown Error Occured...\nInput a number between %d and %d: ");
			} finally {
				input.nextLine();
			}
		}
		return num;
	} //end of getIntInRange() method
	
	/**
	 * receives a scanner instance, and two strings, then returns the number that user inputed
	 * @param input Scanner used for reading input (Scanner)
	 * @param message initial prompt to recieve number (String)
	 * @param failMessage prompt informing user the input is incorrect (String)
	 * @return num (double)
	 */
	public static double getDouble(Scanner input, String message) {
		/*
		 * loop prompting for any double, if a different input type is given, 
		 * it will call an exception, print failMessage, 
		 * and then re-prompt if double is given, return
		 */
		double num = 0;
		while (true) {
			try {
				System.out.printf(message);
				num = input.nextDouble();
				break;
			} catch(InputMismatchException e) {
				System.out.printf("\nIncorrect data type entered...\n\n");
			}catch(Exception e){
				System.out.printf("\nUnknown Error Occured...\n\n");
			}finally {
				input.nextLine();
			}
		}
		return num;
	}
	
	
	/**
	 * method for getting string, with a prompts
	 * @param input Scanner input for recieving string (Scanner)
	 * @param message prompt for string (String)
	 * @return s
	 */
	public static String getString(Scanner input, String message) {
		//this method is just for consistency/redundancy, not necessary
		String s = "";
		System.out.printf(message);
		s = input.nextLine();
		return s;
	}
	
	/**
	 * Method for getting a float number without crashing program
	 * @param input
	 * @param message
	 * @return float that user inputed
	 */
	public static float getFloat(Scanner input, String message) {
		/*
		 * loop prompting for any double, if a different input type is given, 
		 * it will call an exception, print failMessage, 
		 * and then re-prompt if double is given, return
		 */
		float num = 0;
		while (true) {
			try {
				System.out.printf(message);
				num = input.nextFloat();
				break;
			} catch(InputMismatchException e) {
				System.out.printf("\nIncorrect data type entered...\n\n");
			}catch(Exception e){
				System.out.printf("\nUnknown Error Occured...\n\n");
			} finally {
				input.nextLine();
			}
		}
		return num;
	}
	
	/**
	 * Method for getting a float number in a range without crashing the program
	 * @param input
	 * @param bottom
	 * @param top
	 * @param message
	 * @return number within specified range
	 */
	public static float getFloatInRange(Scanner input, float bottom, float top, String message) {
		float num = 0;
		while (true) {
			try {
				System.out.printf(message);
				num = input.nextFloat();
				if (num <= top && num >= bottom) {
					break;
				}
				System.out.printf("\nInput a number between %f and %f: ", bottom, top);
			} catch(InputMismatchException e) {
				System.out.printf("\nIncorrect data type entered...\nInput a number between %f and %f: ", bottom, top);
			}catch(Exception e){
				System.out.printf("\nUnknown Error Occured...\nInput a number between %f and %f: ");
			} finally {
				input.nextLine();
			}
		}
		return num;
	}
	
	
	/**
	 * Method for gathering a char from a list of valid Chars, if user gives a string, then the first character is chosen
	 * @param input - for input (Scanner) 
	 * @param message - user message (String)
	 * @param validChar - vararg of valid characters (char)
	 * @return a valid Char
	 */
	public static char getSpecificChar(Scanner input, String message, char... validChar) 
	{	//gets a char that is one of the specified selections
		String letters;
		char letter = ' ';
		boolean isValid = false;
		while (!isValid) 
		{	//while no valid option has been selected this loop will continue	
				System.out.printf(message);
				letters = input.nextLine();
				//use the letter at the first index of the user input
				letter = letters.charAt(0);
				for (int i = 0; i < validChar.length; i++) 
				{	//check if the userInputed char is the same as any of the valid chars
					if (validChar[i] != letter) 
					{	//not valid letter
					} 
					else 
					{	//if it is valid set a flag that one of them has been found
						isValid = true;
					}
				}
				if (isValid == false) 
				{ //if no valid chars found, print statement and reget a new letter
					System.out.printf("Letter not found... Try a new one\n");
				}
		}
		return letter;
	} //end of getSpecificChar Method
}//end of InputHelper Class
