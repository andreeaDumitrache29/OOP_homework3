/**
 * 
 * @author Dumitrache Daniela Andreea
 *         <p>
 *         Clasa folosita pentru a efectua operatia de inmultire dintre doua
 *         noduri
 *
 */
public class Multiplication {
	/**
	 * 
	 * @param node
	 *            nodul intre ai carui fii se va efectua inmultirea
	 * @return rezultatul inmultirii
	 *         <p>
	 *         Metoda realizeaza inmultirea dintre fiul stang is fiul drept al
	 *         noului primit ca parametru, atunci cand fiul stang este de tip
	 *         int.
	 *         <p>
	 *         Intai se verifica daca fiul stang este NaN daca da, se retine
	 *         acest lucru transformand valoarea variabilei ok in 1, altfel, se
	 *         instantieaza un Integer avand valoarea fiului stang.
	 *         <p>
	 *         Daca fiul drept este de tip int: se verifica daca acesta este NaN
	 *         sau daca ok == 1, caz in care rezultatul este NaN. Altfel, se
	 *         instantieaza un integer cu valoarea fiului drept, se retine
	 *         rezultatul inmultirii celor doi fii in INteger-ul c, si se va
	 *         suprascrie rezultatul folosind metoda toString. Se suprascrie
	 *         campul value din variabila din nodul parinte, se seteaza tipul
	 *         acestuia ca fiind int si se returneaza rezultatul.
	 *         <p>
	 *         Daca fiul drept este de tip double: se verifica daca acesta este
	 *         NaN sau daca ok == 1, caz in care rezultatul este NaN. Altfel, se
	 *         instantieaza un Double cu valoarea fiului drept, se retine
	 *         rezultatul inmultirii celor doi fii in Double-ul c, si se va
	 *         suprascrie rezultatul folosind metoda toString. Se suprascrie
	 *         campul value din variabila din nodul parinte, se seteaza tipul
	 *         acestuia ca fiind double si se returneaza rezultatul.
	 *         <p>
	 *         Daca fiul drept este de tip String: se verifica daca fiul stang
	 *         este NaN sau mai mic sau egal cu zero, caz in care rezultatul
	 *         intors este sirul vid. Altfel, se va concatena la rezultat
	 *         String-ul din fiul drept de valoarea din fiul stang ori.In final
	 *         se suprascrie campul value din variabila din nodul parinte, se
	 *         seteaza tipul acestuia ca fiind String si se returneaza
	 *         rezultatul.
	 */
	public String multLeftInt(OpNode node) {
		String res = "";
		int ok = 0;
		Integer a = 0;
		/**
		 * verificam daca fiul stang este NaN pentru a putea efectua conversia
		 */
		if (node.getLeft().getVar().value().contentEquals("NaN")) {
			ok = 1;
		} else {
			a = Integer.parseInt(node.getLeft().getVar().value());
		}
		if (node.getRight().getVar().type().contentEquals("int")) {
			/**
			 * int * int -> int Verficam daca fiul stang a fost sau daca fiul
			 * drept este NaN Daca da, rezultatul este NaN Altfel, realizam
			 * inmultirea si suprascriem campul value si tipul din variabila din
			 * nodul parinte
			 */
			if (node.getRight().getVar().value().contentEquals("NaN") || ok == 1) {
				res += "NaN";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("int");
				return res;
			}
			Integer b = Integer.parseInt(node.getRight().getVar().value());
			Integer c = a * b;
			res += c.toString();
			node.getVar().setVal(res);
			node.getVar().setTypeNode("int");
			return res;
		} else if (node.getRight().getVar().type().contentEquals("double")) {
			/**
			 * int * double -> double Verficam daca fiul stang a fost sau daca
			 * fiul drept este NaN Daca da, rezultatul este NaN Altfel, realizam
			 * inmultirea si suprascriem campul value si tipul din variabila din
			 * nodul parinte
			 */
			if (node.getRight().getVar().value().contentEquals("NaN") || ok == 1) {
				res += "NaN";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("double");
				return res;
			}
			Double b = Double.parseDouble(node.getRight().getVar().value());
			Double c = a * b;
			res += c.toString();
			node.getVar().setVal(res);
			node.getVar().setTypeNode("double");
			return res;
		} else {
			/**
			 * int * String -> String
			 */
			if (ok == 1 || a <= 0) {
				/**
				 * fiul stang e NaN sau <= 0 Rezultatul este sirul vid
				 */
				res = "";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("String");
				return res;
			}
			/**
			 * se multiplica valoarea fiului din dreapta e valoarea fiului din
			 * stanga ori si se suprascrie valoarea si tipul din variabila var a
			 * nodului parinte cu noul rezultat
			 */
			String b = node.getRight().getVar().value();
			for (int i = 0; i < a; i++) {
				res += b;
			}
			node.getVar().setVal(res);
			node.getVar().setTypeNode("String");
			return res;
		}
	}

	/**
	 * 
	 * @param node
	 *            nodul intre ai carui fii se va efectua inmultirea
	 * @return rezultatul inmultirii
	 *         <p>
	 *         Metoda realizeaza inmultirea dintre fiul stang si fiul drept al
	 *         noului primit ca parametru, atunci cand fiul stang este de tip
	 *         double.
	 *         <p>
	 *         Intai se verifica daca fiul stang este NaN daca da, se retine
	 *         acest lucru transformand valoarea variabilei ok in 1, altfel, se
	 *         instantieaza un Double a avand valoarea fiului stang.
	 *         <p>
	 *         Daca fiul drept este de tip int: se verifica daca acesta este NaN
	 *         sau daca ok == 1, caz in care rezultatul este NaN. Altfel, se
	 *         instantieaza un integer cu valoarea fiului drept, se retine
	 *         rezultatul inmultirii celor doi fii in Double-ul c, si se va
	 *         suprascrie rezultatul folosind metoda toString. Se suprascrie
	 *         campul value din variabila din nodul parinte, se seteaza tipul
	 *         acestuia ca fiind double si se returneaza rezultatul.
	 *         <p>
	 *         Daca fiul drept este de tip double: se verifica daca acesta este
	 *         NaN sau daca ok == 1, caz in care rezultatul este NaN. Altfel, se
	 *         instantieaza un Double cu valoarea fiului drept, se retine
	 *         rezultatul inmultirii celor doi fii in Double-ul c, si se va
	 *         suprascrie rezultatul folosind metoda toString. Se suprascrie
	 *         campul value din variabila din nodul parinte, se seteaza tipul
	 *         acestuia ca fiind double si se returneaza rezultatul.
	 *         <p>
	 *         Daca fiul drept este de tip String: se verifica daca fiul drept
	 *         este NaN sau daca ok == 1, caz in care rezultatul intors este
	 *         NaN. Altfel, se declara un Iteger b reprezantand lungimea sirului
	 *         si un Double c, reprezentand rezultatul inmultirii dintre b si a.
	 *         Acesta se va concatena la rezultat folosind metoda toString. Se
	 *         suprascrie campul value din variabila din nodul parinte, se
	 *         seteaza tipul acestuia ca fiind double si se returneaza
	 *         rezultatul.
	 */
	public String multLeftDouble(OpNode node) {
		String res = "";
		Double a = 0.0;
		int ok = 0;
		/**
		 * verificam daca fiul stang este NaN
		 */
		if (node.getLeft().getVar().value().contentEquals("NaN")) {
			ok = 1;
		} else {
			a = Double.parseDouble(node.getLeft().getVar().value());
		}
		if (node.getRight().getVar().type().contentEquals("int")) {
			/**
			 * double - int -> double Verificam daca unul dintre fii este NaN
			 */
			if (node.getRight().getVar().value().contentEquals("NaN") || ok == 1) {
				res += "NaN";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("double");
				return res;
			}
			/**
			 * realizam inmultirea dintre fii si suprascriem rezultatul
			 */
			Integer b = Integer.parseInt(node.getRight().getVar().value());
			Double c = a * b;
			res += c.toString();
			node.getVar().setVal(res);
			node.getVar().setTypeNode("double");
			return res;
		} else if (node.getRight().getVar().type().contentEquals("double")) {
			/**
			 * double - double -> double Verificam daca unul dintre fii este NaN
			 */
			if (node.getRight().getVar().value().contentEquals("NaN") || ok == 1) {
				res += "NaN";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("double");
				return res;
			}
			/**
			 * realizam inmultirea dintre fii si suprascriem rezultatul
			 */
			Double b = Double.parseDouble(node.getRight().getVar().value());
			Double c = a * b;
			res += c.toString();
			node.getVar().setVal(res);
			node.getVar().setTypeNode("double");
			return res;
		} else {
			/**
			 * double - String -> double
			 */
			if (node.getRight().getVar().value().contentEquals("NaN") || ok == 1) {
				res += "NaN";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("double");
				return res;
			}
			/**
			 * sirul se converteste la un int de valoare egala cu lungimea sa
			 * realizam inmultirea dintre fii si suprascriem rezultatul
			 */
			Integer b = node.getRight().getVar().value().length();
			Double c = a * b;
			res += c.toString();
			node.getVar().setVal(res);
			node.getVar().setTypeNode("double");
			return res;
		}
	}

	/**
	 * 
	 * @param node
	 *            nodul ai carui fii vor fii inmultiti
	 * @return rezultatul inmultirii
	 *         <p>
	 *         Metoda realizeaza inmultirea fiilor nodului primit ca parametru
	 *         atunci cand primul dintre acestia este de tip String.
	 *         <p>
	 *         Se verifica daca primul fiu este NaN si se actualizeaza ok. Se
	 *         declara un sir a = valoarea din primul fiu.
	 *         <p>
	 *         Daca al doilea fiu este de tip int: se verifica daca fiul drept
	 *         este NaN sau mai mic sau egal cu zero, caz in care rezultatul
	 *         intors este sirul vid. Altfel, se va concatena la rezultat
	 *         String-ul din fiul stang de valoarea din fiul drept ori.In final
	 *         se suprascrie campul value din variabila din nodul parinte, se
	 *         seteaza tipul acestuia ca fiind String si se returneaza
	 *         rezultatul.
	 *         <p>
	 *         Daca al doilea fiu este de tip double:se verifica daca fiul drept
	 *         este NaN sau daca ok == 1, caz in care rezultatul intors este
	 *         NaN. Altfel, se declara un Double b, reprezentand valoarea fiului
	 *         drept si un Double c reprezentand rezultatul inmultirii dintre b
	 *         si lungimea sirului a. Aceste se va concatena la rezultat
	 *         folosind metoda toString. Se suprascrie campul value din
	 *         variabila din nodul parinte, se seteaza tipul acestuia ca fiind
	 *         double si se returneaza rezultatul.
	 *         <p>
	 *         Daca al doilea fiu este String: se verifica daca fiul drept este
	 *         NaN sau daca ok == 1, caz in care rezultatul intors este NaN.
	 *         Atfel, se declara int a si int b reprezentand lungimile valorilor
	 *         fiului stang, respectiv fiului drept. In Integer c se salveaza
	 *         rezultatul inmultirii lui a cu b.Aceste se va concatena la
	 *         rezultat folosind metoda toString. Se suprascrie campul value din
	 *         variabila din nodul parinte, se seteaza tipul acestuia ca fiind
	 *         int si se returneaza rezultatul.
	 * 
	 */
	public String multLeftString(OpNode node) {
		String res = "";
		int ok = 0;
		String a = node.getLeft().getVar().value();
		/**
		 * se verifica daca primul fiu este NaN
		 */
		if (a.contentEquals("NaN")) {
			ok = 1;
		}
		if (node.getRight().getVar().type().contentEquals("int")) {
			/**
			 * String * int -> String se va multiplica string-ul de valoarea
			 * fiului din dreapta ori
			 */
			if (node.getRight().getVar().value().contentEquals("NaN")) {
				/**
				 * unul dintre fii este NaN Rezultatul inmultirii este NaN
				 */
				node.getVar().setVal(res);
				node.getVar().setTypeNode("String");
				return res;
			}
			Integer b = Integer.parseInt(node.getRight().getVar().value());
			if (b <= 0) {
				node.getVar().setVal(res);
				node.getVar().setTypeNode("String");
				return res;
			}
			for (int i = 0; i < b; i++) {
				res += a;
			}

			node.getVar().setVal(res);
			node.getVar().setTypeNode("String");
			return res;

		} else if (node.getRight().getVar().type().contentEquals("double")) {
			/**
			 * String * double -> double
			 */
			if (node.getRight().getVar().value().contentEquals("NaN") || ok == 1) {
				/**
				 * unul dintre fii este NaN Rezultatul inmultirii este NaN
				 */
				res += "NaN";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("double");
				return res;
			}
			Double b = Double.parseDouble(node.getRight().getVar().value());
			Double c = b * a.length();
			res += c.toString();
			node.getVar().setVal(res);
			node.getVar().setTypeNode("double");
			return res;

		} else {
			/**
			 * String * String -> int Se va realiza inmultirea dintre lungimile
			 * celor doua siruri
			 */
			String b = node.getRight().getVar().value();
			if (ok == 1 || b.contentEquals("NaN")) {
				res += "NaN";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("int");
				return res;
			}
			int x = a.length();
			int y = b.length();
			Integer c = x * y;
			res += c.toString();
			node.getVar().setVal(res);
			node.getVar().setTypeNode("int");
			return res;
		}
	}
}
