package hi;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
	public static void main(String[] args) throws FileNotFoundException {
		String inputFileName = args[0];

		FileReader reader = new FileReader(inputFileName);
		Scanner in = new Scanner(reader);
		ArrayList<Student> al = new ArrayList<Student>();

		while (in.hasNext()) {
			String o = in.nextLine();
			String[] name = o.split(",");
			al.add(new Student(name[0], name[1], name[2], name[3]));
		}

		for (int i = 0; i < al.size(); i++) {
			System.out.println("====");
			System.out.println("Name: " + al.get(i).getName() + "\nMatriculation number: " + al.get(i).getMatricno() + "\nGender: " + al.get(i).getGender() + "\nCourse: " + al.get(i).getCoursename());
			System.out.println("====");
		}
	}
}

