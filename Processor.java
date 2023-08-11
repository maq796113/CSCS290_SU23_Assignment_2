import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Processor{
	String _filePath;
	public Processor(String filePath) {
		this._filePath = filePath;
		// TODO Auto-generated constructor stub
	}

	public void process() {
		try {
			boolean isnewline = false;  
			FileReader fileReader = new FileReader(this._filePath);
			FileWriter writer = new FileWriter("out2.txt");
			int i;
			while ((i = fileReader.read()) != -1) {    //read char by char
				if ((char) i == '\n' || (char) i == '\r')   //check if there is a newline return character or carriage return char
					isnewline = true;
				else
					writer.write(i);   //write char by char in the new file
			}
			writer.write((int) '$');
			fileReader.close();
			writer.close();
		} catch (IOException e) {
			System.out.println("Failed Reading The File");
			e.printStackTrace();
			System.exit(0);
		}
	}
	

}
