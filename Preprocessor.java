import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class Preprocessor {
	
	private String filePath;

	public Preprocessor(String _filePath) {
		this.filePath = _filePath;
	}
	public void preprocess() {
		File file = new File(this.filePath);
		FileReader input;
		BufferedReader reader;
		FileWriter writer;
		try {
			int i = 0;
			input = new FileReader(file);
			reader = new BufferedReader(input);
			try {
				String line;
				writer = new FileWriter("in1.txt");
				while ((line = reader.readLine()) != null) {
					if (line.trim().isEmpty() || line.contains("/*") || line.contains("//") || line.contains("import"))
						continue;
					line = line.trim().replaceAll("\\s+", " ");   //here '\\s+' is a regular expression which matches one or more whitespace characters (including spaces, tabs, and line breaks). besides \s is used to find whitespace
					i = line.lastIndexOf(" ");   //get index of the last space
					if (i >= 0 && i == line.length() - 2) //if lastIndex() function returns -1 then there is no space at all and check if the space is between the last two characters
					{
						line = line.substring(0, i) + line.substring(i+1);  //concatenate substrings going from first character to the character before the space between last two characters and the last character
					}
					writer.write(line);  //write line by line
					writer.write(System.lineSeparator());     //get writer to next line
				}
				reader.close();
				writer.close();
				
			} catch (IOException e) {
				System.out.println("Unable To Read");
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Failed To Opened");
			e.printStackTrace();
			System.exit(0);
		}

	}
}
