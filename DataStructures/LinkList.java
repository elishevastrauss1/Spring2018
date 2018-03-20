package dataStructures;

import java.util.InputMismatchException;
import java.util.Scanner;

//Elisheva Strauss
public class LinkList {

	public final int MAXSIZE=20;
	public final static int FREE_LIST_START=100;
	
	
	private static Scanner input=new Scanner(System.in);
	
	public static int myListStart=0;
	private static int freeListStart=2;
	private static int indexMyListEnd=1;
	private static String[] bigData = new String[100];
	private static int[] bigIndex = new int[100];
	
	public static void main(String[] args) {
		//Set variables
		bigData[0]="@";
		bigIndex[indexMyListEnd]=-1;//myListEnd
		bigData[99]="@";
		bigIndex[99]=-1;
		
		//changing variables
		bigIndex[myListStart]=indexMyListEnd;
		
		do{//do at least once
			int choice=choices();//displays the choices
			
			if (choice==1){//add to the list
				add();
			}
			else if (choice==2){//delete element
				delete();
			}
			else if (choice==3){//replace element
				replace();
			}
			else if (choice==4){//find element
		        findMethod();
			}
			else if (choice==5){//output list
				output();
			}
			else if (choice!=6) {//everything other than the choices or 6 is invalid
		        System.out.println("Invalid choice");
			}
		    else {//only other option is 6 which will make the program stop
		        break;
		    }
		}while (true);


	}
	public static int choices() {//displays choices to the user
		System.out.println("Choose\r\n" + 
				"        1-Add an item\r\n" + 
				"        2-Delete a specified item\r\n" + 
				"        3-Change an item\r\n" + 
				"        4-See if something exists in the array\r\n" + 
				"        5-Output the list\r\n" + 
				"        6-Quit");

		try{
			int choice=input.nextInt();//scans in the choice
			return choice;
		}
		catch (InputMismatchException e) {
			System.out.println("Invalid Input");
			return -1;
		}
		
	}
	public static void add() {
		int choice2=addChoices();
		String inp="";
		if (choice2==1 ||choice2==2 ||choice2==3) {
			System.out.println("What would you like to add?");
			inp=input.next();//takes in the what the user wants to add
        }
        
		if (choice2==1) {//add to beginning of myList
        	bigData[freeListStart]=inp;//places the data in the next available node
     
        	bigIndex[freeListStart]=bigIndex[myListStart];//index of new node is old index of 1st item
        	bigIndex[myListStart]=freeListStart;//index of first item now points to new item
        	freeListStart++;//moves freeListStart down one
        }
        else if (choice2==2) {//add to end of myList
        	bigData[freeListStart]=inp;
        	
        	for (int i=0;i<freeListStart;i++) {//goes through the list
        		if (bigIndex[i]==indexMyListEnd) {//where bigIndex is pointing to 1 which is where myListEnd is, then
        			bigIndex[i]=freeListStart;		//make that node point to the new last item in the list
        			bigIndex[freeListStart]=indexMyListEnd; //makes the new item, point to end
        		}
        	}
        	freeListStart++;//moves freeListStart down one
        }
        else if (choice2==3) {
        	System.out.println("After which item?");
        	int index=find();//find the specified item
        	if (index==-1) {//If not found
        		System.out.println("Item not found");
        	}
        	else {
        		bigData[freeListStart]=inp;//add item to beginning of freeList
        		bigIndex[freeListStart]=bigIndex[index];//set index of new node
        		bigIndex[index]=freeListStart;//makes new item point to next item
        		freeListStart++;
        	}
        }
	}
	public static int addChoices() {
		System.out.println("Choose\r\n" +
				"		 1-The beginning\r\n" +
				" 		 2-The end\r\n" +
				"		 3-A specified value");
		try{
			int choice=input.nextInt();//scans in the choice
			return choice;
		}
		catch (InputMismatchException e) {
			System.out.println("Invalid Input");
			return -1;
		}
	}
	public static void delete() {
		System.out.println("What would you like to delete?");
	    int index=find();
	    if (index!=-1) {
	    	bigData[index]="**";
		    for (int i=0;i<freeListStart;i++) {
		    	if (bigIndex[i]==index) {
		    		bigIndex[i]=bigIndex[index];//the node that points to the deleted node now points to the node that the deleted node used to point to
		    	}
		    }
	    }
	}
	public static void replace() {
		System.out.println("What do you want to replace?");
		int index=find();
		if (index!=-1) {
		    System.out.println("What are you replacing with?");
	        String inp2=input.next();//takes in user input
	        bigData[index]=inp2;//replaces data
		}
	}
	public static void findMethod() {
		System.out.println("What do you want to find?");
        int index;
        index=find();//returns index of element, -1 if doesn't exist
        if (index!=-1) {
        	System.out.println("Item found");
        }
	}
	public static int find() {
		String inp=input.next();
    	for (int i=2;i<freeListStart;i++) {
    		if (bigData[i].equals(inp)) {
    			return i;
    		}
    	}
    	System.out.println("Item not found");
    	return -1;
    	
	}
	public static void output() {
		int next=bigIndex[myListStart];//sets next to point to the first item
		while(bigIndex[next]!=-1) {//when bigIndex[next]==-1 then the list has reached the end
			System.out.println(bigData[next]);//print the item
			next=bigIndex[next];//change next to point to next node
		}
	}
}
