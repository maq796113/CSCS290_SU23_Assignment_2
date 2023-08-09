import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Preprocessor {
	private String blank_lines;
	private String tabs_spaces;
	private String comments;
	private String imports;
	private String annotations;
	private String filePath;

	public Preprocessor(String _filePath) {
		this.filePath = _filePath;
	}
	public void preprocess() {
		File file = new File(this.filePath);
		FileReader input;
		BufferedReader reader;
		try {
			int i = 0;
			input = new FileReader(file);
			reader = new BufferedReader(input);
			try {
				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
				}
				
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
