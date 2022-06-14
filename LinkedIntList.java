// Student: Natalia Reeck Zanini
// Course: CS 211
// Assignment #9
// June 2nd, 2022

// I have updated this ArrayIntList.java file with the methods requested on 
// Assignment #9:
// lastIndexOf
// countDuplicates	
// hasTwoConsecutive
// deleteBack 

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// A LinkedIntList object can be used to store a list of integers.
public class LinkedIntList {
    private ListNode front;   // node holding first value in list (null if empty)
    private String name = "front";   // string to print for front of list
    
    // Constructs an empty list.
    public LinkedIntList() {
        front = null;
    }
    
    // Constructs a list containing the given elements.
    // For quick initialization via Practice-It test cases.
    public LinkedIntList(int... elements) {
        this("front", elements);
    }
    
    public LinkedIntList(String name, int... elements) {
        this.name = name;
        if (elements.length > 0) {
            front = new ListNode(elements[0]);
            ListNode current = front;
            for (int i = 1; i < elements.length; i++) {
                current.next = new ListNode(elements[i]);
                current = current.next;
            }
        }
    }
    
    // Constructs a list containing the given front node.
    // For quick initialization via Practice-It ListNode test cases.
    private LinkedIntList(String name, ListNode front) {
        this.name  = name;
        this.front = front;
    }
    
    // Appends the given value to the end of the list.
    public void add(int value) {
        if (front == null) {
            front = new ListNode(value, front);
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            } 
            current.next = new ListNode(value);
        }
    }
    
    // Inserts the given value at the given index in the list.
    // Precondition: 0 <= index <= size
    public void add(int index, int value) {
        if (index == 0) {
            front = new ListNode(value, front);
        } else {
            ListNode current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            } 
            current.next = new ListNode(value, current.next);
        }
    }
    
    public boolean equals(Object o) {
        if (o instanceof LinkedIntList) {
            LinkedIntList other = (LinkedIntList) o;
            return toString().equals(other.toString());   // hackish
        } else {
            return false;
        }
    }
    
    // Returns the integer at the given index in the list.
    // Precondition: 0 <= index < size
    public int get(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    // Removes the value at the given index from the list.
    // Precondition: 0 <= index < size
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            ListNode current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
    }
    
    // Returns the number of elements in the list.
    public int size() {
        int count = 0;
        ListNode current = front;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    // Returns a text representation of the list, giving
    // indications as to the nodes and link structure of the list.
    // Detects student bugs where the student has inserted a cycle
    // into the list.
    public String toFormattedString() {
        ListNode.clearCycleData();
        
        String result = this.name;
        
        ListNode current = front;
        boolean cycle = false;
        while (current != null) {
            result += " -> [" + current.data + "]";
            if (current.cycle) {
                result += " (cycle!)";
                cycle = true;
                break;
            }
            current = current.__gotoNext();
        }

        if (!cycle) {
            result += " /";
        }
        
        return result;
    }
    
    // Returns a text representation of the list.
    public String toString() {
        return toFormattedString();
    }
    
    // Returns a shorter, more "java.util.LinkedList"-like text representation of the list.
    public String toStringShort() {
        ListNode.clearCycleData();
        
        String result = "[";
        
        ListNode current = front;
        boolean cycle = false;
        while (current != null) {
            if (result.length() > 1) {
				result += ", ";
			}
            result += current.data;
            if (current.cycle) {
                result += " (cycle!)";
                cycle = true;
                break;
            }
            current = current.__gotoNext();
        }

        if (!cycle) {
            result += "]";
        }
        
        return result;
    }
    

    // ListNode is a class for storing a single node of a linked list.  This
    // node class is for a list of integer values.
    // Most of the icky code is related to the task of figuring out
    // if the student has accidentally created a cycle by pointing a later part of the list back to an earlier part.

    public static class ListNode {
        private static final List<ListNode> ALL_NODES = new ArrayList<ListNode>();
        
        public static void clearCycleData() {
            for (ListNode node : ALL_NODES) {
                node.visited = false;
                node.cycle = false;
            }
        }
        
        public int data;          // data stored in this node
        public ListNode next;     // link to next node in the list
        public boolean visited;   // has this node been seen yet?
        public boolean cycle;     // is there a cycle at this node?

        // post: constructs a node with data 0 and null link
        public ListNode() {
            this(0, null);
        }

        // post: constructs a node with given data and null link
        public ListNode(int data) {
            this(data, null);
        }

        // post: constructs a node with given data and given link
        public ListNode(int data, ListNode next) {
            ALL_NODES.add(this);
            this.data = data;
            this.next = next;
            this.visited = false;
            this.cycle = false;
        }
        
        public ListNode __gotoNext() {
            return __gotoNext(true);
        }
        
        public ListNode __gotoNext(boolean checkForCycle) {
            if (checkForCycle) {
                visited = true;
                
                if (next != null) {
                    if (next.visited) {
                        // throw new IllegalStateException("cycle detected in list");
                        next.cycle = true;
                    }
                    next.visited = true;
                }
            }
            return next;
        }
    }


	// YOUR CODE GOES HERE

	// #1) This method returns the index in the list of the last occurrence
	// of that value, or -1 if the value is not found in the list:

	public static int lastIndexOf(int[] arr, int num) {
		// Initiating index to -1:
		int index = -1;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				index = i;
			}
		}
		return index;
	}

	// #2)This method returns the number of duplicates in a sorted list:

	public int countDuplicates() {

		//If the list is empty, returns zero:

		if (front == null) {
			return 0;
		}

		int count = 0;
		int curr = front.data;

		//Looping through remaining nodes:
		for (ListNode n = front.next; n != null; n = n.next) {
			if (n.data == curr) {
				count++;
			} 
			else {
				curr = n.data;

			}
		}

		return count;

	}

	// #3) This method will return whether or not a list of integers has two 
	// adjacent numbers that are consecutive integers:

	public boolean hasTwoConsecutive() {

		//Here if the list is empty/has only one element it will returning false:
		if (front == null || front.next == null) {
			return false;
		}

		ListNode n = front;
		//The loop will continue until n.next is null.
		while (n.next != null) {
			// Comparing n and n.next
			if (n.data == (n.next.data - 1)) {
				//If consecutive is found:
				return true;
			}

			//If not, it will advance to next node:
			n = n.next;
		}

		//In case it is not found:
		return false;

	}

	// #4)This method deletes and returns the last value. 
	// If the list is empty, then it throws NoSuchElementException error.

	public int deleteBack() {
		if(front == null)
			// If list is empty throws NoSuchElementException.
			throw new NoSuchElementException();

		int data;
		// If front is the last node it will remove the front.
		if(front.next == null) {
			data = front.data;
			front = null;
			// Will return the value.
			return data;
		}

		// The loop will continue until n.next is the last node.
		ListNode n = front;
		while(n.next.next != null)
			n = n.next;
		data = n.next.data;
		//removing n.next
		n.next = null;
		return data;
	}
}

