package dataStructures;

import java.util.Scanner;

public class Tree {

	public static void main(String[] args) {

		Scanner input=new Scanner(System.in);
		int left[]=new int[20];
		int value[]=new int[20];
		int right[]=new int[20];
		
		for (int i=0;i<20;i++) {
			value[i]=-1;
			left[i]=-1;
			right[i]=-1;
		}
		
		System.out.println("Enter numbers to sort (-10 to stop)");
		
		value[0]=input.nextInt();//place first value into first space
		
		int nextFree=1, counter=0;
		value[nextFree]=input.nextInt();//place next value into free space
		
		
		while(value[nextFree]!=-10) {//do until user enters a -10
			counter=0;//reset counter
			while(counter!=-1) {
				if (value[counter]>value[nextFree]) {//new value is less than old value
					if (left[counter]==-1) {//left array of last node should point to next value
						left[counter]=nextFree;
						counter=-1;
					}
					else{//otherwise continue trying to find last node
						counter=left[counter];
					}
					
				}
				else {//new value is greater than old value
					if (right[counter]==-1) {//if found last node then replace -1
						right[counter]=nextFree;
						counter=-1;
					}
					else {//continue trying to find last node
						counter=right[counter];
					}
					
				}
			}
			
			nextFree++;//update available spaces
			value[nextFree]=input.nextInt();//input next value
		}
		input.close();//close scanner
		
		//print out sorted
		int store[]=new int[20];//stores index of value to print
		counter=-1;
		int temp=0;

		while (value[temp]!=-10) {//no more values
			if (value[temp]!=-2) {//going down tree because when push from stack replace value with -2
				while (left[temp]!=-1) {//check to see if there is a lower value
					counter++;//if there is a lower value
					store[counter]=temp;//put index onto the stack
					temp=left[temp];//continue searching for lower values
				}
				System.out.print(value[temp] + " ");
			}
				
			if (right[temp]!=-1){//if no value lower but there is a value higher
				temp=right[temp];//make that value the new temp so that can search to see if there is a lower value
			}
			else {//if no value lower or higher
				if (counter==-1) {//if finished outputting the stack
					break;
				}
				temp=store[counter];//set temp to top value of stack inorder to output it
				System.out.print(value[temp] + " ");//output stack
				value[temp]=-2;//set outputed values to -2
				counter--;//get rid of top value in stack
			}
		}
		
				
		}
}
