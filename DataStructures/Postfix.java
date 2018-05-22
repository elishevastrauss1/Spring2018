package dataStructures;

import java.util.Scanner;

public class Postfix {

	public static void main(String[] args) {
		//Take in the input equation
		Scanner input=new Scanner(System.in);
		String string=input.nextLine();
		input.close();
		
		//instantiate variables and pushdown to use
		int N=string.length();//size of string equation
		int I=0;//keep track of which variable in equation program is up to
		int J=-1;//keep track of pushdown
		String S[]=new String[N];//array to store equation
		String STORE[]=new String[20];//pushdown
		
		//put each part of equation into array 
		for (int i=0;i<N;i++) {
			S[i]=string.substring(i,i+1);
		}
		
		//go through all variables of array
		while (I<N) {
			//if variable equals "(" then put in pushdown
			if (S[I].equals("(")) {
				J+=1;//increase pushdown by 1 so as not to override past entries
				STORE[J]="(";
			}
			
			//if variable equals ")" then output pushdown
			else if(S[I].equals(")")) {
				while(STORE[J]!="("){
					System.out.print(STORE[J]);
					J--;
				}
				J--;
			}
			
			//if variable equals an operator
			else if(S[I].equals("-") || S[I].equals("+") || S[I].equals("*") || S[I].equals("/") || S[I].equals("^")) {
				//if this operator priority is lower than pushdown, output pushdown 
				if (P(S[I])<=P(STORE[J])) {
					System.out.print(STORE[J]);
					J--;
					
					//if operator was not outputed and needs to be saved on pushdown
					if (S[I]!=")") {
						J++;
						STORE[J]=S[I];
					}
				}
				//if this operator priority is greater then store in pushdown
				else {
					J++;
					STORE[J]=S[I];
				}
				
			}
			
			//if variable is a letter then output
			else {
				System.out.print(S[I]);
			}
			
			//increase I by 1 to continue to next letter
			I++;
		}
		//output rest of pushdown
		while (J>0) {
			System.out.print(STORE[J]);
		}
		}
	
	//priority function
	public static int P(String S) {
		if (S.equals("(")||S.equals(")")){
			return 0;
		}
		else if (S.equals("+")||S.equals("-")){
			return 1;
		}
		else if (S.equals("*")||S.equals("/")){
			return 2;
		}
		else if (S.equals("^")){
			return 3;
		}
		else {
			return -1;
		}
	}

}
