/**
 * 
 * @author Dumitrache Daniela Andreea
 *         <p>
 *         Clasa pentru a efectua operatia de scadere
 *
 */
public class Subtraction {
	/**
	 * 
	 * @param node
	 *            un nod ce contine o operatie de efectuat
	 * @return rezultatul operatiei dintre fii nodului
	 *         <p>
	 *         Metoda realizeaza scaderea a doi operatori atunci cand stim ca
	 *         primul dintre acestia(fiul din stanga al nodului) este un int.
	 *         <p>
	 *         Se verifica intai daca fiul din stanga este NaN, caz in care
	 *         rezultatul operatiei de scadere este tot NaN. Altfel, se
	 *         realizeaza conversia la Integer a fiului din stanga.
	 *         <p>
	 *         Se afla tipul fiului din dreapta si se verifica daca acesta este
	 *         NaN. Daca oricare din cei doi fii este NaN se va face conversia
	 *         rezultatului la tipul corespunzator si se va returna NaN. Altfel,
	 *         se va realiza corespunzator operatia de scadere in functie de
	 *         tipul fiului din dreapta:
	 *         <p>
	 *         in cazul in care acesta este int: se va declara o variabila de
	 *         tipul Integer avand valoarea egala cu valoarea din al doilea fiu,
	 *         se va efectua scaderea celor doua variabile, si se va transmite
	 *         mai departe rezultatul folosind metoda toString.Se va suprascrie
	 *         campul value din variabila var a nodului parinte, iar tipul din
	 *         variabila var se va suprascrie cu int
	 *         <p>
	 *         in cazul in care acesta este double: se va declara o variabila de
	 *         tipul Double avand valoarea egala cu valoarea celui de-al al
	 *         doilea fiu, se va efectua scaderea celor doua variabile, si se va
	 *         transmite mai departe rezultatul folosind metoda toString.Se va
	 *         suprascrie campul value din variabila var a nodului parinte, iar
	 *         tipul din variabila var se va suprascrie cu double
	 *         <p>
	 *         In cazul in care fiul din dreapta este String se va efectua
	 *         conversia acestuia la un Integer, reprezentand lungimea sirului.
	 *         Se va efectua scaderea celor doua variabile, si se va transmite
	 *         mai departe rezultatul folosind metoda toString.Se va suprascrie
	 *         campul value din variabila var a nodului parinte, iar tipul din
	 *         variabila var se va suprascrie cu int
	 */
	public String subLeftInt(OpNode node) {
		String res = "";
		Integer a = 0;
		int ok = 0;
		/**
		 * verificam daca primul fiu este NaN
		 */
		if (node.getLeft().getVar().value().contentEquals("NaN")) {
			ok = 1;
		} else {
			a = Integer.parseInt(node.getLeft().getVar().value());
		}
		/**
		 * int - int -> int
		 */
		if (node.getRight().getVar().type().contentEquals("int")) {
			if (node.getRight().getVar().value().contentEquals("NaN") || ok == 1) {
				/**
				 * Daca unul dintre fii este NaN, atunci rezultatul scaderii
				 * este NaN
				 */
				res += "NaN";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("int");
				return res;
			}
			/**
			 * Efectuam scaderea
			 */
			Integer b = Integer.parseInt(node.getRight().getVar().value());
			Integer c = a - b;
			res += c.toString();
			node.getVar().setVal(res);
			node.getVar().setTypeNode("int");
		} else if (node.getRight().getVar().type().contentEquals("double")) {
			/**
			 * int - double -> double
			 */
			if (node.getRight().getVar().value().contentEquals("NaN") || ok == 1) {
				/**
				 * Daca unul dintre fii este NaN, atunci rezultatul scaderii
				 * este NaN
				 */
				res += "NaN";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("double");
				return res;
			}
			/**
			 * Efectuam scaderea
			 */
			Double b = Double.parseDouble(node.getRight().getVar().value());
			Double c = a - b;
			res += c.toString();
			node.getVar().setVal(res);
			node.getVar().setTypeNode("double");
		} else if (node.getRight().getVar().type().contentEquals("String")) {
			/**
			 * int - String -> int se face conversia sirului la un int
			 * reprezentand lungimea sirului
			 */
			if (node.getRight().getVar().value().contentEquals("NaN") || ok == 1) {
				/**
				 * Daca unul dintre fii este NaN, atunci rezultatul scaderii
				 * este NaN
				 */
				res += "NaN";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("int");
				return res;
			}
			/**
			 * Efectuam scaderea
			 */
			Integer b = node.getRight().getVar().value().length();
			Integer c = a - b;
			res += c.toString();
			node.getVar().setVal(res);
			node.getVar().setTypeNode("int");
		}

		return res;
	}

	/**
	 * 
	 * @param node
	 *            un nod ce contine o operatie de efectuat
	 * @return rezultatul operatiei dintre fii nodului
	 *         <p>
	 *         Metoda realizeaza scaderea a doi operatori atunci cand stim ca
	 *         primul dintre acestia(fiul din stanga al nodului) este un double.
	 *         <p>
	 *         Se verifica intai daca fiul din stanga este NaN, caz in care
	 *         rezultatul operatiei de scadere este tot NaN. Altfel, se
	 *         realizeaza conversia la Double a fiului din stanga.
	 *         <p>
	 *         Se afla tipul fiului din dreapta si se verifica daca acesta este
	 *         NaN. Daca oricare din cei doi fii este NaN se va face conversia
	 *         rezultatului la tipul corespunzator si se va returna NaN. Altfel,
	 *         se va realiza corespunzator operatia de scadere in functie de
	 *         tipul fiului din dreapta:
	 *         <p>
	 *         in cazul in care acesta este int: se va declara o variabila de
	 *         tipul Integer avand valoarea egala cu valoarea din al doilea fiu,
	 *         se va efectua scaderea celor doua variabile, si se va transmite
	 *         mai departe rezultatul folosind metoda toString.Se va suprascrie
	 *         campul value din variabila var a nodului parinte, iar tipul din
	 *         variabila var se va suprascrie cu double
	 *         <p>
	 *         in cazul in care acesta este double: se va declara o variabila de
	 *         tipul Double avand valoarea egala cu valoarea celui de-al al
	 *         doilea fiu, se va efectua scaderea celor doua variabile, si se va
	 *         transmite mai departe rezultatul folosind metoda toString.Se va
	 *         suprascrie campul value din variabila var a nodului parinte, iar
	 *         tipul din variabila var se va suprascrie cu double
	 *         <p>
	 *         In cazul in care fiul din dreapta este String se va efectua
	 *         conversia acestuia la un Integer, reprezentand lungimea sirului.
	 *         Se va efectua scaderea celor doua variabile, si se va transmite
	 *         mai departe rezultatul folosind metoda toString.Se va suprascrie
	 *         campul value din variabila var a nodului parinte, iar tipul din
	 *         variabila var se va suprascrie cu double
	 */
	public String subLeftDouble(OpNode node) {
		String res = "";
		Double a = 0.0;
		int ok = 0;
		/**
		 * verificam daca fiul stang e NaN
		 */
		if (node.getLeft().getVar().value().contentEquals("NaN")) {
			ok = 1;
		} else {
			a = Double.parseDouble(node.getLeft().getVar().value());
		}
		/**
		 * double - int -> double
		 */
		if (node.getRight().getVar().type().contentEquals("int")) {
			if (node.getRight().getVar().value().contentEquals("NaN") || ok == 1) {
				/**
				 * Daca unul dintre fii este NaN, atunci rezultatul scaderii
				 * este NaN
				 */
				res += "NaN";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("double");
				return res;
			}
			/**
			 * Efectuam scaderea
			 */
			Integer b = Integer.parseInt(node.getRight().getVar().value());
			Double c = a - b;
			res += c.toString();
			node.getVar().setVal(res);
			node.getVar().setTypeNode("double");
		} else if (node.getRight().getVar().type().contentEquals("double")) {
			/**
			 * double - double -> double
			 */
			if (node.getRight().getVar().value().contentEquals("NaN") || ok == 1) {
				/**
				 * Daca unul dintre fii este NaN, atunci rezultatul scaderii
				 * este NaN
				 */
				res += "NaN";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("double");
				return res;
			}
			/**
			 * Efectuam scaderea
			 */
			Double b = Double.parseDouble(node.getRight().getVar().value());
			Double c = a - b;
			res += c.toString();
			node.getVar().setVal(res);
			node.getVar().setTypeNode("double");
		} else if (node.getRight().getVar().type().contentEquals("String")) {
			/**
			 * double - String -> double se face conversia sirului la un int
			 * reprezentand lungimea sirului
			 */
			if (node.getRight().getVar().value().contentEquals("NaN") || ok == 1) {
				/**
				 * Daca unul dintre fii este NaN, atunci rezultatul scaderii
				 * este NaN
				 */
				res += "NaN";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("double");
				return res;
			}
			/**
			 * Efectuam scaderea
			 */
			Integer b = node.getRight().getVar().value().length();
			Double c = a - b;
			res += c.toString();
			node.getVar().setVal(res);
			node.getVar().setTypeNode("double");
		}

		return res;
	}

	/**
	 * 
	 * @param node
	 *            un nod ce contine o operatie de efectuat
	 * @return rezultatul operatiei dintre fii nodului
	 *         <p>
	 *         Metoda realizeaza scaderea a doi operatori atunci cand stim ca
	 *         primul dintre acestia(fiul din stanga al nodului) este un string.
	 *         <p>
	 *         Se declara un String a egal cu valoarea din fiul stang. Se
	 *         verifica intai daca fiul din stanga este NaN si ok devine 1.
	 *         <p>
	 *         in cazul in care acesta este int: se verifica daca vreounul
	 *         dintre fii este NaN, caz in cae rezultatul este String-ul a.
	 *         Altfel, se declara un Integer b avand valoarea fiului din
	 *         dreapta. Daca este mai mare decat lungimea lui a, atunci
	 *         rezultatul e sirul vid. Daca b e negativ, atunci rezultatul va fi
	 *         a , urmat de caracterul # scris de b ori. Atfel, rezultatul este
	 *         a, fara ultimele b caractere. Se va suprascrie campul value din
	 *         variabila var a nodului parinte, iar tipul din variabila var se
	 *         va suprascrie cu String.
	 *         <p>
	 *         in cazul in care acesta este double: se va declara o variabila de
	 *         tipul Double b avand valoarea egala cu valoarea celui de-al al
	 *         doilea fiu, se va efectua scaderea dintre lungimea lui a si b, si
	 *         se va transmite mai departe rezultatul folosind metoda
	 *         toString.Se va suprascrie campul value din variabila var a
	 *         nodului parinte, iar tipul din variabila var se va suprascrie cu
	 *         double
	 *         <p>
	 *         In cazul in care fiul din dreapta este String se va efectua
	 *         conversia acestuia la un Integer, reprezentand lungimea sirului.
	 *         Se va efectua scaderea celor doua lungimi, si se va transmite mai
	 *         departe rezultatul folosind metoda toString.Se va suprascrie
	 *         campul value din variabila var a nodului parinte, iar tipul din
	 *         variabila var se va suprascrie cu int
	 */
	public String subLeftString(OpNode node) {
		String res = "";
		String a = node.getLeft().getVar().value();
		int ok = 0;
		if (a.contentEquals("NaN")) {
			ok = 1;
		}
		/**
		 * String - int -> String
		 */
		if (node.getRight().getVar().type().contentEquals("int")) {
			if (node.getRight().getVar().value().contentEquals("NaN") || ok == 1) {

				res += a;
			} else {
				Integer b = Integer.parseInt(node.getRight().getVar().value());
				if (b > a.length()) {
					res = "";
				} else if (b < 0) {
					res += a;
					for (int i = 0; i < Math.abs(b); i++) {
						res += "#";
					}
				} else {
					res += a.substring(0, a.length() - b);
				}
			}
			node.getVar().setVal(res);
			node.getVar().setTypeNode("String");
		} else if (node.getRight().getVar().type().contentEquals("double")) {
			/**
			 * String - double -> double se face conversia sirului la un int
			 * reprezentand lungimea sirului
			 */
			if (node.getRight().getVar().value().contentEquals("NaN") || ok == 1) {
				/**
				 * Daca unul dintre fii este NaN, atunci rezultatul scaderii
				 * este NaN
				 */
				res += "NaN";
			} else {
				/**
				 * Efectuam scaderea
				 */
				Double b = Double.parseDouble(node.getRight().getVar().value());
				Double c = a.length() - b;
				res += c.toString();
			}
			node.getVar().setVal(res);
			node.getVar().setTypeNode("double");
		} else if (node.getRight().getVar().type().contentEquals("String")) {
			/**
			 * String - String -> int se face conversia sirurilor la cate un int
			 * reprezentand lungimea fiecarui sirului
			 */
			if (node.getRight().getVar().value().contentEquals("NaN") || ok == 1) {
				/**
				 * Daca unul dintre fii este NaN, atunci rezultatul scaderii
				 * este NaN
				 */
				res += "NaN";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("int");
				return res;
			}
			/**
			 * Efectuam scaderea dintre lungimi
			 */
			Integer b = node.getRight().getVar().value().length();
			Integer c = a.length() - b;
			res += c.toString();
			node.getVar().setVal(res);
			node.getVar().setTypeNode("int");
		}

		return res;
	}

}
