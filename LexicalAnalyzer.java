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
			FileReader fr = new FileReader(this._filePath);
			int i;
			
			boolean flag = false;    //used to check if the previous character read was a punctuator
			boolean flag1 = false;   // 
			int j = 0;
			int k;
			int totalNumOfchars = 0;
			int charsRead = 0;
			
			while ((k = fr.read()) != (int) '$') { //read the characters until you hit $ and ultimately count the number of chars
				totalNumOfchars++;
			}
			fr.close();
			System.out.print("Lexeme: ");
			int countToCheckIfIncrement = 0;
			while ((i = fileReader.read()) != (int) '$') {    //read char by char
				charsRead++;
				
	
				     //parenthesis: ()         curly brackets: {}    spaces   semi-colon :    comma ,     square brackets[]      period .
				if ((i > 39 && i < 42) || (i == 123 || i == 125) || i == 32 || i == 59 || i ==  44   || i == 91 || i == 93    || i == 46) {     //trying to check for all punctuators
					countToCheckIfIncrement = 0;
					if (i != 32) {  // if it's not a space
						
						if (flag) {  //count to check if the previous character printed was a punctuator
							j++;
						}
						
						
						 
						if ((flag && j>0) || flag1) {   // if the previous character read was also punctuator i.e j>0 or the previous character was a space....
							System.out.println((char) i);   //print punctuators given that the previous charcter that was printed was also a punctuator
						}
						
						
						else {
							System.out.println("\nLexeme: "+(char) i);   //print punctuators given that the previous charcter that was printed was not a punctuator
						}
						flag = true;
						flag1 = false;
					}
						
					else {  //if there is space in the file
						
						if (!flag) {  
							System.out.println();
						}
						
						flag1 = true;
						flag = false;
						j = 0;
					}
					
					if ((flag1 || flag) && charsRead<totalNumOfchars)
						System.out.print("Lexeme: ");
					
				}
				
				else { //print the character of a string lexeme char by char
					
					flag = false;
					flag1 = false;
					j = 0;
					
					if ((char) i == '+' || (char) i == '-') {
						if (countToCheckIfIncrement == 1) {
							System.out.print("\nLexeme: "+(char) i+(char) i);
							continue;
						}
						
						else {
							countToCheckIfIncrement++;
							continue;
						}
							
						
					}
					
					
	
					System.out.print((char) i);
					
				}
				
				
			}
			fileReader.close();
		} catch (IOException e) {
			System.out.println("Failed Reading The File");
			e.printStackTrace();
			System.exit(0);
		}
	}

}
