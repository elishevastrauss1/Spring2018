package dataStructures;

import java.util.Scanner;

public class Strings {

	public static void main(String[] args) {
		System.out.println("Enter a sentence to convert to pig latin:");
		Scanner input = new Scanner(System.in);
		String sentence=input.nextLine();//scan in sentence to convert
		input.close();
		
		final int LENGTH=sentence.length();//store length of sentence
		
		
		int counter=0, temp=0;
		String words[]=new String[LENGTH];//set up array of words
		String punctuation=sentence.substring(LENGTH-1,LENGTH);//store the last letter or punctuation and 
																//later tests to see if is punctuation
		
		
		//find how many words are in the sentence and store them
		for(int i=0;i<LENGTH;i++) {
			if (sentence.substring(i, i+1).equals(" ")){//if letter is a space or the last word 
				words[counter]=sentence.substring(temp, i);//put the word into array
				temp=i+1;//set temp variable to after next space
				counter++;
			}
			else if (i==LENGTH-1) {
				if (punctuation.equals(".")||punctuation.equals("!")||punctuation.equals("?")) {//tests to see if is punctuation
					words[counter]=sentence.substring(temp, i);//put the word into array
				}
				else{
					words[counter]=sentence.substring(temp, i+1);//put the word into array
					punctuation="";
				}
				counter++;
			}
		}
		
		final int WORDS=counter-1;//stores number of words
		
		//alters words to make them into pig latin
		counter=0;
		while(counter<=WORDS) {
			switch(words[counter].substring(0, 1).toLowerCase()) {//finds the first letter of the word
			//if the word begins with a vowel
			case "a":case "e":case "i":case "o":case "u":
				words[counter]=words[counter]+"ay";
				counter++;
				break;
			//if the word begins with a c then checks to see if it's a ch
			case "c":
				if (words[counter].substring(1, 2).equals("h")) {
					words[counter]=words[counter].substring(2, words[counter].length())+"chay";
				}
				//if it's not ch then saves it as plain c
				else {
					words[counter]=words[counter].substring(1, words[counter].length())+"cay";
				}
				counter++;
				break;
			case "g":
				if (words[counter].substring(1, 2).equals("h")) {
					words[counter]=words[counter].substring(2, words[counter].length())+"ghay";
				}
				else {
					words[counter]=words[counter].substring(1, words[counter].length())+"g";
				}
				counter++;
				break;
			case "p":
				if (words[counter].substring(1, 2).equals("h")) {
					words[counter]=words[counter].substring(2, words[counter].length())+"phay";
				}
				else {
					words[counter]=words[counter].substring(1, words[counter].length())+"pay";
				}
				counter++;
				break;
			case "q":
				if (words[counter].substring(1, 2).equals("u")) {
					words[counter]=words[counter].substring(2, words[counter].length())+"quay";
				}
				else {
					words[counter]=words[counter].substring(1, words[counter].length())+"qay";
				}
				counter++;
				break;
			case "s":
				if (words[counter].substring(1, 2).equals("h")) {
					words[counter]=words[counter].substring(2, words[counter].length())+"shay";
				}
				else if (words[counter].substring(1, 3).equals("ch")) {
					words[counter]=words[counter].substring(3, words[counter].length())+"schay";
				}
				else {
					words[counter]=words[counter].substring(1, words[counter].length())+"say";
				}
				counter++;
				break;
			case "t":
				if (words[counter].substring(1, 2).equals("h")) {
					words[counter]=words[counter].substring(2, words[counter].length())+"thay";
				}
				else {
					words[counter]=words[counter].substring(1, words[counter].length())+"tay";
				}
				counter++;
				break;
			//if none of the options above then puts the first letter of the word at the end followed by ay
			default:
				words[counter]=words[counter].substring(1, words[counter].length())+words[counter].substring(0, 1)+"ay";
				counter++;
			}
		}
		
		
		
		//output pig latin
		for (String i:words) {
			if (i!=null) {//until no more words
				System.out.print(i + " ");
			}
		}
		System.out.print(punctuation);//adds punctuation if there is one, otherwise punctuation is just ""
		
		

	}

}
