// Student: Natalia Reeck Zanini
// Course: CS 211
// Assignment #9
// June 2nd, 2022


// This file contains the code required to test the methods:
// lastIndexOf
// countDuplicates	
// hasTwoConsecutive
// deleteBack

public class Assignment9{

	public static void main(String[] args) {
		
		System.out.println("Testing Methods:");
		System.out.println();

		int arr[] = {1, 18, 2, 7, 18, 39, 18, 40};

		int list2 = LinkedIntList.lastIndexOf(arr, 3);
		
		System.out.println("Output for the lastIndexOf method:");
		System.out.println(list2);
		System.out.println();
		

		int arr1[] = {1, 1, 1, 3, 3, 6, 9, 15, 15, 23, 23, 23, 40, 40};

		LinkedIntList list3 = new LinkedIntList(arr1);

		System.out.println("Output for the countDuplicates method:");
		System.out.println(list3.countDuplicates());
		System.out.println();

		int arr2[] = {1, 18, 2, 7, 8, 39, 18, 40};

		LinkedIntList list4 = new LinkedIntList(arr2);

		System.out.println("First output for the hasTwoConsecutive method:");
		System.out.println(list4.hasTwoConsecutive());
		System.out.println();
		
		int arr3[] = {1, 18, 17, 2, 7, 39, 18, 40, 8};

		LinkedIntList list5 = new LinkedIntList(arr3);

		System.out.println("Second output for the hasTwoConsecutive method:");
		System.out.println(list5.hasTwoConsecutive());
		System.out.println();

		
		int arr4[] = {1, 18, 17, 2, 7, 39, 18, 40, 8};
		LinkedIntList list6 = new LinkedIntList(arr4);
		
		System.out.println("Outputs for the deleteBack method:");
		
		System.out.println();
		System.out.println("If the list is: " + list6);
		System.out.println();
		System.out.println("The deleted value is: " + list6.deleteBack());
		System.out.println();
		
		int arr5[] = {};
		LinkedIntList list7 = new LinkedIntList(arr5);
		
		System.out.println("If the list is empty:");
		System.out.println(list7.deleteBack());
		

		
		
		

	
	}
}


