
public class Driver {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("Usage: java ClassName <input_file>");
			System.exit(0);
		}
		
		String input_file = args[0];
		
		Preprocessor pp = new Preprocessor(input_file);
		pp.preprocess();
		Processor p = new Processor("out1.txt");
		p.process();
		
		LexicalAnalyzer la = new LexicalAnalyzer("out2.txt");
		la.analyze();

	}

}
