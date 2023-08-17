//Shakir Tempelman
package myLibrary;

import java.util.Scanner;
public class MyLibrary 
{
	private static double fee;
	
	//Method 1
	public static double CalcFee(int c) throws CreditException
	{
		//Check for exception
		if(c < 1 || c > 33)
			throw new CreditException();
		
		//Calculate fee
		if(c >= 12)
			fee = (110 * 12) + 50 + 20;
		else
			fee = (110 * c) + 50;
		
		//Return fee
		return fee;
	}
	
	//Method 2
	public static long fac(int n) throws FacException
	{
		//Check for exception
		if(n < 0 || n > 20)
			throw new FacException();
		
		//Calculate factorial
		if(n == 0 || n == 1)
			return 1;
		else
			return n * fac(n - 1);
	}
	
	//Method 3
	public static int locate(double[] d, double sVal) throws ArrayException
	{
		//Check for exception
		if(d == null || d.length == 0)
			throw new ArrayException();
		
		//Locate first instance of double value
		for(int i = 0; i < d.length; i++)
			if(d[i] == sVal)
				return i;
		
		//Return -1 if double value not found
		return -1;
	}
	
	//Method 4
	public int getInteger()
	{
		//Initialize variables
		Scanner in = new Scanner(System.in);
		boolean checker = false;
		int num = 0;
		String input = "";
		
		while(checker == false)
		{
			//Get user input
			System.out.println("Please enter an integer value: ");
			input = in.nextLine();
			
			//Check to see if string entered is a number
			try
			{
				num = Integer.parseInt(input);
				checker = true;
			}
			catch(NumberFormatException e)
			{
				System.out.println("Invalid input.");
				checker = false;
			}
		}
		
		//Return string entered as an int value
		return num;
	}
	
	//Method 5
	public String substitute(String s, char replaceable, char replacer) throws InvalidStringException
	{
		//Initialize variable
		String finalString = "";
		
		//Check for exception
		if(s == null || s == "")
			throw new InvalidStringException();
		
		//Look for the value to be replaced and replace it
		for(int i = 0; i < s.length(); i++)
			if(s.charAt(i) == replaceable)
				finalString = finalString + replacer;
			else
				finalString = finalString + s.charAt(i);
		
		//Return the final string after chars have been replaced
		return finalString;
	}
	
	//Method 6
	public double sine(double radians, int numTerms) throws AngleException, FacException
	{
		//Initialize variables
		double sin = radians;
		boolean alternator = false;
		
		//Check for exception
		if(radians < 0 || radians >= (2 * 3.14))
			throw new AngleException();
		
		//try...catch block for facException
		try
		{
			//Check exception because 0 is in the parameter range of the fac() method and is not in the parameter range for the sine() method:
			if(numTerms <= 0)
				throw new FacException();
			
			//Calculate sine
			for(int i = 2; i <= numTerms; i++)
			{
				if(!alternator)
				{
					sin = sin - (Math.pow(sin, (i * 2) - 1) / fac((i * 2) - 1));
					alternator = true;
				}
				else
				{
					sin = sin + (Math.pow(sin, (i * 2) - 1) / fac((i * 2) - 1));
					alternator = false;
				}
			}
			
			//Returnd calculated sine
			return sin;
		}
		catch(FacException wrngNum)
		{
			throw new FacException();
		}
	}
}
