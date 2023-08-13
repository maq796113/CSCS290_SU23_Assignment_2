import java.io.FileReader;
import java.io.IOException;

public class LexicalAnalyzer {
	
	String _filePath;
	public LexicalAnalyzer(String filePath) {
		this._filePath = filePath;
		// TODO Auto-generated constructor stub
	}
	
	public void analyze() {
		try {
			
			FileReader fileReader = new FileReader(this._filePath);
			int i;
			int j = 0;
			

			char[] buffer = new char[100];
			System.out.print("Lexeme: ");
			while ((i = fileReader.read()) != -1) {    //read char by char
//				if ((char) i != ' ' && (char) i != '\0' && (char) i != '{' && (char) i != '(' && (char) i != '}' && (char) i != ')' && (char) i != ';') {
//			
//					buffer[j] = (char) i;
//					j++;
//				}
//				
//				else {
//					j = 0;
//					String lexeme = new String(buffer);
//					lexeme = lexeme.replace("\0", "");
//					System.out.println(lexeme);
//				}
				     //parenthesis: ()         curly brackets: {}    spaces   semi-colon
				
				if ((i > 39 && i < 42) || (i == 123 || i == 125) || i == 32 || i == 59) {     //trying to get all the separators
					if (i != 32) {
						System.out.println("\nLexeme: "+(char) i);
						System.out.print("Lexeme: ");
					}
						
					else {
						System.out.println();
						System.out.print("Lexeme: ");
					}
						
					
					}
				
				else
					System.out.print((char) i);
				
			}
			fileReader.close();
		} catch (IOException e) {
			System.out.println("Failed Reading The File");
			e.printStackTrace();
			System.exit(0);
		}
	}

}
