//Elisheva Strauss
package fileIO;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentList implements Serializable {
	
	private static final long serialVersionUID = 1L;
	ArrayList<String> students = new ArrayList<String>();
	
	public StudentList(String[] names) {
		for (int i=0; i<names.length; i++) {
			students.add(names[i]);
		}
	}
	
	public void display() {
		for (int i=0; i<students.size(); i++) {
			System.out.print(students.get(i) + " ");
		}
		System.out.println();
	}
	
	public void removeStudent(int index) {
		try{
			students.remove(index);
		}
		catch (Exception e){
			System.out.println("Error: " + e.getMessage());
		}
	}
}
