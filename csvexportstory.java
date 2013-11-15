import java.io.*;
import java.util.*;
import java.io.FileWriter;

public class csvexportstory {

	public static void main(String[] args) throws IOException {
		//private static String excelFile = Common.dataDir + "test.csv";

		String excelFile = "test.csv";

		String inputFileName = args[0]; // dictionary
		FileReader reader = new FileReader(inputFileName);
		FileWriter writer = new FileWriter("test.csv");
		Scanner in = new Scanner(reader);
		ArrayList<String> csv = new ArrayList();
		String tempWord;
		System.out.println("HIHIHIH");
			System.out.println("HIHIHIH");
		while (in.hasNext())
		{
			tempWord = in.nextLine();
			for (String str: tempWord.split(",")){
				writer.append(str);
				writer.append(',');
			}	
			writer.append('\n');
      		}
		writer.flush();
		writer.close();
		for (int i = 0; i< csv.size(); i++){
				System.out.println(csv.get(i));
		}
		
	}
}
