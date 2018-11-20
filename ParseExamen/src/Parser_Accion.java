public class Parser_Accion {

	public static void main(String[] args) {
		
		Parser parser = new Parser();
		parser.parseFicheroXml("asdf.xml");
		parser.parseDocument();
		parser.print();
	}

}
