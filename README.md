Assignment 9: Chapter 16

This assignment will give you practice updating an existing class with new methods.  You will update the LinkedIntList.java class your four new methods below. You will create your own Assignment9.java file to test your new methods just like Assignment7 and Assignment8.  Make sure you have preconditions and postconditions for all your methods and well commented code.

#1) 

Write a method lastIndexOf that accepts an integer value as a parameter and that returns the index in the list of the last occurrence of that value, or -1 if the value is not found in the list. For example, if a variable list stores the following sequence of values, then the call of list.lastIndexOf(18) should return 6 because that is the index of the last occurrence of 18:

[1, 18, 2, 7, 18, 39, 18, 40]

If the call had instead been list.lastIndexOf(3), the method would return -1 because 3 does not appear in the list. You may not call any other methods of the class to solve this problem.

Assume that you are adding this method to the LinkedIntList class as defined below:

public class LinkedIntList {

    private ListNode front;   // null for an empty list

    ...

}

#2) 

 

Write a method countDuplicates that returns the number of duplicates in a sorted list. The list will be in sorted order, so all of the duplicates will be grouped together. For example, if a variable list stores the sequence of values below, the call of list.countDuplicates() should return 7 because there are 2 duplicates of 1, 1 duplicate of 3, 1 duplicate of 15, 2 duplicates of 23 and 1 duplicate of 40:

[1, 1, 1, 3, 3, 6, 9, 15, 15, 23, 23, 23, 40, 40]

Remember that you may assume that the list is in sorted order, so any duplicates would occur consecutively.

Assume that you are adding this method to the LinkedIntList class as defined below:

public class LinkedIntList {

    private ListNode front;   // null for an empty list

    ...

}

#3) 

Write a method hasTwoConsecutive that returns whether or not a list of integers has two adjacent numbers that are consecutive integers (true if such a pair exists and false otherwise). For example, if a variable list stores the following sequence of values, then the call list.hasTwoConsecutive() should return true because the list contains the adjacent numbers (7, 8) which are a pair of consecutive numbers:

[1, 18, 2, 7, 8, 39, 18, 40]

If the list had stored the following sequence of values, then the method should return false:

[1, 18, 17, 2, 7, 39, 18, 40, 8]

This sequence contains some pairs of numbers that could represent consecutive integers (e.g., 1 and 2, 7 and 8, 39 and 40), but those pairs of numbers are not adjacent in the sequence. The list also has a pair of adjacent numbers (18, 17) that are not in the right order to be considered consecutive. You may not make any assumptions about how many elements are in the list.

Assume that you are adding this method to the LinkedIntList class as defined below:

public class LinkedIntList {

    private ListNode front;   // null for an empty list

    ...

}

 

#4) 

 

Write a method deleteBack that deletes the last value (the value at the back of the list) and returns the deleted value. If the list is empty, your method should throw a NoSuchElementException.

Assume that you are adding this method to the LinkedIntList class as defined below:

public class LinkedIntList {

    private ListNode front;   // null for an empty list

    ...

}

 

Deliverables: Submit your updated LinkedIntList.java file with your four new methods above added. 2) Assignment9.java that you will create to test your methods 3) QA Document showing screenshots of your working methods. 
