//Elisheva Strauss
package fileIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class StudentListFileReader implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		ObjectInputStream fileIn;
		StudentList studentList;
		String filename="StudentLists.txt";

		try {
			fileIn = new ObjectInputStream(new FileInputStream(filename));
			studentList = (StudentList)fileIn.readObject();
			studentList.display();
			studentList=(StudentList)fileIn.readObject();
			studentList.display();
			studentList=(StudentList)fileIn.readObject();
			studentList.display();
			fileIn.close();
		}
		catch (IOException e) {
			System.out.println("IO Error: " + e.getMessage());
		}
		catch (ClassNotFoundException e) {
			System.out.println("ClassNotFound " + e.getMessage());
		}

	}

}
