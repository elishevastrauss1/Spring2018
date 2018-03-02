//Elisheva Strauss
package fileIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StudentListFileWriter implements Serializable{

	private static final long serialVersionUID = 1L;

	public static void main(String[] args){
		
		String filename="StudentLists.txt";
		
		String[] names = {"Caleb", "Izumi", "Mary", "Usha"};
		StudentList studentList = new StudentList(names);
		
		String[] names2 = {"Caleb", "Izumi", "Mary", "Usha", "Elisheva"};
		StudentList studentList2 = new StudentList(names2);
		

		try {
			ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream(filename));
			fileOut.writeObject(studentList);
			fileOut.writeObject(studentList2);
			studentList2.removeStudent(1);
			fileOut.reset();
			fileOut.writeObject(studentList2);
			fileOut.close();
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
