import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 * 
 * @author Dumitrache Daniela Andreea Clasa folosita pentru citirea din fisier,
 *         constructia arborelui si evaluarea expresiilor din arbore
 *
 */
public class Construct {
	/**
	 * reader pentru citirea din fisier
	 */
	private BufferedReader reader;
	/**
	 * writer pentru screirea in fisier
	 */
	private BufferedWriter writer;

	/**
	 * 
	 * @param tree
	 *            arborele care va fii creat
	 * @param in_file
	 *            fisierul de intrare
	 * @param out_file
	 *            fisierul de iesire
	 * @throws IOException
	 *             in caz ca apar erori la scriere
	 *             <p>
	 *             Metoda citeste linie cu linie din fisierul de intrare si
	 *             construieste arborele asociat operatiilor citite.
	 *             <p>
	 *             Clasa ParseTree, care reprezinta arborele are doua campuri,
	 *             operators si identifiers, care contin cate un HashMap cu
	 *             operatorii si identificatorii ce se pot gasii in arbore. In
	 *             cadrul metodei se creeaza si aceste campuri: Operatorii sunt
	 *             mereu aceeasi, deci HashMap-ul corespunzator acestora este
	 *             creat la inceput, si pastrat constant. HashMap-ul pentru
	 *             campul identifiers este mereu actualizat atunci cand se
	 *             intalneste o declaratie de variabila.
	 *             <p>
	 *             In functie de linia curenta:
	 *             <p>
	 *             se declara un nou Identifier daca se citeste o declarare de
	 *             variabila, completat crespunzator cu datele citite, apoi se
	 *             introduce in HashMap-ul hash2, cu care va fi intializat
	 *             campul identifiers din arbore
	 *             <p>
	 *             se da o expresie de evaluat: Intai, folosim metoda createTree
	 *             pentru a creea un arbore corespunzator expresiei curente.
	 *             Initializam apoi radacina arborelui si apelam functia eval pe
	 *             aceasta. Rezultatul expresiei este intors in campul value al
	 *             variabilei var din radacina.
	 */
	public void evaluateExpression(ParseTree tree, FileReader in_file, FileWriter out_file) throws IOException {
		/**
		 * intializea reader si writer
		 */
		reader = new BufferedReader(in_file);
		writer = new BufferedWriter(out_file);
		/**
		 * creem operatorii ce vor reprezenta operatiile pe care le avem de
		 * efectuat
		 */
		Operator o1 = new Operator("+", 1);
		Operator o2 = new Operator("-", 1);
		Operator o3 = new Operator("*", 2);
		Operator o4 = new Operator("/", 2);

		/**
		 * introducem operatorii in hash1 si initializam acmpul operators din
		 * arbore cu hash1
		 */
		HashMap<String, Operator> hash1 = new HashMap<>();
		hash1.put("+", o1);
		hash1.put("-", o2);
		hash1.put("*", o3);
		hash1.put("/", o4);
		tree.setOperators(hash1);

		String s = reader.readLine();
		String tokens[] = null;
		Identifier identifier = null;
		HashMap<String, Identifier> hash2 = new HashMap<>();
		String str = "";
		String res = "";
		Double a;
		Node root = null;

		while (s != null) {
			if (s.contentEquals("")) {
				break;
			} else if (s.startsWith("int")) {
				/**
				 * s-a declarat o variabila int impartim linia in cuvinte dupa
				 * spatiu creem un identifier corespunzator: tipul int - primul
				 * cuvant, numele - al doilea cuvant valoarea variabilei date -
				 * al patrulea cuvant,(al treilea este = ) fara ultimul caracter
				 * (;)
				 */
				tokens = s.split(" ");
				identifier = new Identifier(tokens[0], tokens[3].substring(0, tokens[3].length() - 1), tokens[1]);
				hash2.put(tokens[1], identifier);
			} else if (s.startsWith("double")) {
				/**
				 * s-a declarat o variabila double impartim linia in cuvinte
				 * dupa spatiu creem un identifier corespunzator: tipul double -
				 * primul cuvant, numele - al doilea cuvant valoarea variabilei
				 * date - al patrulea cuvant,(al treilea este = ) fara ultimul
				 * caracter (;)
				 */
				tokens = s.split(" ");
				identifier = new Identifier(tokens[0], tokens[3].substring(0, tokens[3].length() - 1), tokens[1]);
				hash2.put(tokens[1], identifier);
			} else if (s.startsWith("string")) {
				/**
				 * s-a declarat o variabila int impartim linia in cuvinte dupa
				 * spatiu creem un identifier corespunzator: tipul int - primul
				 * cuvant, numele - al doilea cuvant valoarea variabilei date -
				 * de la al patrulea cuvant pana la ultimul. Se vor exclude
				 * primul caracter, ", si ultimele 2, " si ;
				 */
				tokens = s.split(" ");
				for (int i = 3; i < tokens.length; i++) {
					str += tokens[i];
					str += " ";
				}
				str = str.substring(1, str.length() - 3);
				identifier = new Identifier("String", str, tokens[1]);
				hash2.put(tokens[1], identifier);
				str = "";
			} else {
				/**
				 * trebuie sa evaluam expresia, reprezentata de sirul str
				 */
				str = s.substring(5, s.length() - 1);
				/**
				 * setam campul de identifiers din arbore
				 */
				tree.setIdentifiers(hash2);
				/**
				 * folosim metoda createTree din clasa ParseTree pentru a obtine
				 * noua radacina a arborelui corespunzator expresiei date
				 */
				root = tree.createTree(str);
				tree.setRoot(root);
				/**
				 * evaluam expresia rezultatul va fii in campul value al
				 * variabilei var din radacina
				 */
				tree.eval(tree.getRoot());
				res = tree.getRoot().getVar().value();
				/**
				 * intai verifican daca rezultatul este NaN si il afisa ca atare
				 */
				if (res.contentEquals("NaN")) {
					writer.write(res);
					writer.write("\n");
				} else if (root.getVar().type().contentEquals("double")) {
					/**
					 * daca rezultatul este de tip double trebuie intai
					 * aproximat la 2 zecimale, paoi afisat
					 */
					a = Double.parseDouble(res);
					a = Math.round(a * 100) / 100.0;
					res = a.toString();
					writer.write(res);
					writer.write("\n");
				} else {
					/**
					 * se afiseaza rezultatul asa cum este
					 */
					writer.write(res);
					writer.write("\n");
				}

				/**
				 * refacem campurile de visited in arbore, pentru a nu avea
				 * probleme la o parcurgere ulterioara
				 */
				tree.remake(tree.getRoot());
				res = "";
				str = "";
			}
			s = reader.readLine();
		}
		writer.close();
		reader.close();
	}
}
