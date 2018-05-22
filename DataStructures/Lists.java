//Elisheva Strauss

package homework;

import java.util.Scanner;

public class Lists {

	static Scanner input=new Scanner(System.in);
	static String array[]=new String[20];

	public static void main(String[] args) {
		for (int i=0;i<20;i++) {//initialize array
			array[i]="##";//fill with preidentified values
		}
		do{//do at least once
			int choice=choices();//displays the choices
			if (choice==1){//add to the list
		        System.out.println("What whould you like to add?");
		        String inp=input.next();//takes in the what the user wants to add
		        add(inp);
			}
			else if (choice==2){//delete element
				System.out.println("What whould you like to delete?");
			    String inp=input.next();
		        delete(inp);
			}
			else if (choice==3){//replace element
				System.out.println("What do you want to replace?");
			    String inp=input.next();
			    System.out.println("What are you replacing with?");
		        String inp2=input.next();
		        change(inp,inp2);
			}
			else if (choice==4){//find element
		        System.out.println("What do you want to find?");
		        String inp=input.next();
		        int index;
		        index=find(inp);//returns index of element, -1 if doesn't exist
		        if (index==-1) {
		        	System.out.println("Item not found");
		        }
		        else {
		        	System.out.println("Item found");
		        }
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

		int choice=input.nextInt();//scans in the choice
		return choice;
	}
	public static void add(String inp) {//add elements to the list
		for (int i=0;i<20;i++) {
			if (array[i]=="##") {//adds to the first empty spot in the list
				array[i]=inp;
				break;
			}
		}
	}
	public static void delete(String inp) {//delete elements in the list
		int index=find(inp);
		if (index!=-1) {//if it is -1 then the element doesn't exist
			for (int i=0;i<20;i++) {
				if (i==index) {//if element in the list, inserts null value instead of previous value
					array[i]="##";
					break;
				}
			}
		}
		else {//element doesn't exist because index is -1
			System.out.println("No such element in the array");
		}
		
	}
	public static void change(String remove, String add) {//removes a value and replaces with an updated value
		array[find(remove)]=add;//calls the find() method which returns the index of a specified element and then replaces with 'add';
	}
	public static int find(String inp) {//finds elements in the list and returns their index
		for (int i=0;i<20;i++) {
			int index;
			if (array[i].equals(inp)){//if the element is equal to element that searching for, save index
				index=i;
				return index;
			}
		}
		return (-1);//returns -1 if element doesn't exist
	}
	public static void output() {//output the elements in the array
		for(String element:array) {
			if (element!="##") {//if is null then don't output
				System.out.println(element);
			}
		}
	}
	


}
