package week3HW;
import java.util.Arrays;
import java.util.*;

public class Week3 {

	public static void main(String[] args) {
		
		int[] ages = {3, 9, 23, 64, 2, 8, 28, 93};
		String[] names = {"Sam", "Tommy", "Tim", "Sally", "Buck", "Bob"};
		double[] doubleArray1 = {1.0, 4.3333, 6.888998, 5444.0003, 5};
		double[] doubleArray2 = {1.0, 4.3333, 6.888998, 5444.0003, 5, 8.34, 10.4444, 300000, -300000};
		boolean isHotOutside = false;
		double moneyInPocket = 15.55;
		Calendar today = Calendar.getInstance();
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.add(Calendar.DATE, 1);
		int dayOfMonthToday = today.get(Calendar.DAY_OF_MONTH);
		int dayOfMonthTomorrow = tomorrow.get(Calendar.DAY_OF_MONTH);
		System.out.println("today's date " + dayOfMonthToday + " tomorrow's date " + dayOfMonthTomorrow);
		Scanner s = new Scanner(System.in);
		
		
		ageOperations(ages);
		
		System.out.println();
		
		nameOperations(names);
		
		System.out.println();
		
		System.out.println("Please enter a word you would like to see multiple times: ");
		String word = s.nextLine();
		System.out.println("Please enter how many times you would like to see your word printed: ");
		int n = Integer.parseInt(s.nextLine());
		System.out.println(wordNTimes(word,n));
		
		System.out.println();
		
		System.out.println("Please enter your first name: ");
		String firstName = s.nextLine();
		System.out.println("Please enter your last name: ");
		String lastName = s.nextLine();
		System.out.println("Hello " + fullName(firstName, lastName) + ", so very nice to meet you!");
		
		System.out.println();
		
		System.out.println("The statement: \"The sum of all the integers in the given array is larger than 100\" is " + larger100(ages) + ".");
		
		System.out.println();
		
		System.out.println("The average of all the doubles in the first array is " + averageDoubleArray(doubleArray1));
		
		System.out.println();
		
		System.out.println("The statement: \"The average of the first array is higher than the average "
				+ "of the second array\" is " + averageComparison(doubleArray1, doubleArray2));
		
		System.out.println();
		
		System.out.println("The statement: \"I will buy a drink today\" is " + willBuyDrink(isHotOutside, moneyInPocket));
		
		System.out.println();
		
		System.out.println("I can only water the lawn on even numbered days.");
		System.out.println("Today is day " + dayOfMonthToday + " of the current month.");
		System.out.println("Can I water the lawn today?");
		System.out.println(waterLawn(dayOfMonthToday, dayOfMonthTomorrow));
	}
	

	//uses given array of ages and subtracts ages from each other 
	//as well as finds the average of the ages
	public static void ageOperations(int[] ages) {
				
		System.out.println("Last age minus first age is equal to " + subtractFirstLast(ages));
		
		ages = Arrays.copyOf(ages, ages.length + 1);
	    ages[ages.length - 1] = 32;
	    
	    System.out.println("After adding another age, the last age minus first age is now equal to " + subtractFirstLast(ages));
	    
	    System.out.println("The average age is " + averageIntArray(ages));
	}
	
	//finds the result when we subtract the first age from the last age
	public static int subtractFirstLast (int[] arr) {
		return (arr[arr.length - 1] - arr[1]);
	}
	
	//finds the average of an int array
	public static double averageIntArray(int[] array) {
		double sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum/array.length;	
	}

	//uses given string array and finds the average string length
	//shows how to get the first and last elements of a string
	//creates new int array where each element represents the length of each 
	//string of the corresponding element in the string array 
	public static void nameOperations(String[] names) {
		int[] nameLengths = getLengths(names);
		System.out.println("The average length of the names is " + averageIntArray(nameLengths) + " letters.");
		
		String lastElement = names[names.length -1];
		System.out.println("The last element of the names array is " + lastElement);
		System.out.println("To get the last element of an array use the following index: array.length -1.");
		
		String firstElement = names[0];
		System.out.println("The first element of the names array is " + firstElement);
		System.out.println("To get the first element use the index of 0.");
		System.out.println();
			
		elementsAndSum(names);		
	}

	//creates an int array where each item represents the length of each string from a string array
	public static int[] getLengths(String[] strings) {
		int[] stringLengths = new int[strings.length];
		for (int i = 0; i < strings.length ; i++) {
			stringLengths[i] = strings[i].length();
		}
		return stringLengths;
	}
	
	//prints out all the elements in a String array and gives the sum of all the string lengths
	public static void elementsAndSum(String[] array) {
		int sum = 0;
		int[] stringLengths = getLengths(array);
		System.out.println("All the elements in this array: ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
			sum += stringLengths[i];
		}
		System.out.println();
		System.out.println("The sum of all the letters in this array is "+ sum);
		
	}
	
	//returns a word n times after each other
	public static String wordNTimes (String word, int n) {
		if (n > 0) {
			String longWord = word;
			for (int i = 1; i < n; i++) {
				longWord += word;
			}
			return longWord;
		} else if (n == 0) {
			return "Nothing to display here.";
		}
		return "Cannot show " + word + " a negative number of times.";
	}
	
	//concatenates two strings to create one
	public static String fullName (String firstName, String lastName) {
		return(firstName + " " + lastName);
	}
	
	//determines whether the sum of all the elements in an int array is larger than 100
	public static boolean larger100(int[] array) {
		int sum = 0;
		for (int element:array) {
			sum += element;
		}
		if (sum > 0) {
			return true;
		}
		return false;
	}
	
	//finds the average of an double array
	public static double averageDoubleArray(double[] array) {
		double sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum/array.length;	
	}

	//compares the average of two double arrays, will return true if the average of array1 is larger than the average of array2
	public static boolean averageComparison(double[] array1, double[]array2) {
		return averageDoubleArray(array1) > averageDoubleArray(array2);
	}
	
	public static boolean willBuyDrink(boolean isHotOutside, double moneyInPocket) {
		return (isHotOutside == true && moneyInPocket > 10.5);
	}
	
	public static String waterLawn (int dayOfMonthToday, int dayOfMonthTomorrow) {
		if (dayOfMonthToday % 2 == 1) {
			if (dayOfMonthTomorrow % 2 == 1) {
				return "No, not today. You will have to wait two days before you can water the lawn, on the 2nd of the next month";
			}
			return "No, not today. You may water the lawn tomorrow.";
		}
		return "Yes! You may water the lawn today";
	}

}
