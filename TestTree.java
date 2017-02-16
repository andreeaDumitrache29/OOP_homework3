import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Dumitrache Daniela Andreea
 *         <p>
 *         Clasa pentru testare
 *         <p>
 *         se creeaza fisierele de intrare si iesire, se creeaza un arbore nul
 *         si se instantieaza clasa construct, care va prelucra arborele si
 *         expresiile ccnform fisieruluide intrare si va scrie rezultatele in
 *         fisierul de iesire
 *
 */
public class TestTree {
	public static void main(String[] args) throws IOException {
		ParseTree tree = new ParseTree();
		FileReader in = new FileReader("arbore.in");
		FileWriter out = new FileWriter("arbore.out");
		Construct constr = new Construct();
		constr.evaluateExpression(tree, in, out);
		out.close();
		in.close();
	}
}
