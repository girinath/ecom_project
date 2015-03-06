package scripts;

import java.util.ArrayList;

public class ArrayDel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int[] array = {2, 5, 9};
		/*
		 * String[] array = {"aa","cc","giri"}; int index =
		 * Arrays.asList(array).indexOf("giri"); System.out.println(index);
		 */

		// create an empty array list with an initial capacity
		ArrayList<String> arrlist = new ArrayList<String>();
		
		System.out.println("Size of list: " + arrlist.size());

		// use add() method to add values in the list
		arrlist.add("G");
		arrlist.add("E");
		arrlist.add("F");
		arrlist.add(2, "giri");
		arrlist.add("M");

		System.out.println("Size of list: " + arrlist.size());
		
		showitems(arrlist);

		int retval = arrlist.indexOf("E");
		System.out.println("The element E is at index " + retval);

		arrlist.set(2, "nath");
		
		System.out.println("The element nath added at position 2");
		
		showitems(arrlist);
		
		arrlist.remove(retval);
		System.out.println("The element E is removed");
		
		showitems(arrlist);
		
		int retval1 = arrlist.indexOf("nath");
		System.out.println("The element nath is at index " + retval1);
		
		System.out.println("Size of list: " + arrlist.size());
	}
	
	static void showitems(ArrayList<String> arrlist)
	{
		for (String value : arrlist) {
			System.out.println("Value = " + value);
		}
	}

}
