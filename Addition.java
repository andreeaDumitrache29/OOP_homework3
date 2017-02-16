/**
 * 
 * @author Dumitrache Daniela Andreea Aceasta clasa este folosita pentru
 *         realizarea operatiei de adunare
 *
 */
public class Addition {
	public Addition() {

	}

	/**
	 * 
	 * @param node
	 *            un nod ce contine o operatie de efectuat
	 * @return rezultatul operatiei dintre fii nodului
	 *         <p>
	 *         Metoda realizeaza adunarea a doi operatori atunci cand stim ca
	 *         primul dintre acestia(fiul din stanga al nodului) este un int. Se
	 *         verifica intai daca fiul din stanga este NaN, caz in care
	 *         rezultatul operatiei de adunare este tot NaN. Altfel, se
	 *         realizeaza conversia la Integer a fiului din stanga. Se afla
	 *         tipul fiului din dreapta si se verifica daca acesta este NaN.
	 *         Daca oricare din cei doi fii este NaN se va face conversia
	 *         rezultatului la tipul corespunzator si se va returna NaN. Altfel,
	 *         se va realiza corespunzator operatia de adunare in functie de
	 *         tipul fiului din dreapta: in cazul in care acesta este int sau
	 *         double se va declara o variabila de tipul respectiv, se va
	 *         efectua adunarea celor doua, si se va transmite mai departe
	 *         rezultatul folosint metoda toString din clasele Integer,
	 *         respectiv Double. In cazul in care fiul din dreapta este String
	 *         se va efectua concatenarea dintre cei doi fii. In acest caz, fiul
	 *         din stanga poate fii si NaN
	 */
	public String additionLeftInt(OpNode node) {
		/**
		 * Stringul rezultat, res Integer-ul reprezentand fiul din stanga, a
		 * variabila ok devine 1 daca fiul din stanga este NaN, folosita pentru
		 * a propaga rezultatele de NaN mai departe
		 */
		String res = "";
		Integer a = 0;
		int ok = 0;
		/**
		 * verificam daca fiul din stanga e NaN
		 */
		if (node.getLeft().getVar().value().contentEquals("NaN")) {
			ok = 1;
		} else {
			a = Integer.parseInt(node.getLeft().getVar().value());
		}
		/**
		 * int + int -> int
		 */
		if (node.getRight().getVar().type().contentEquals("int")) {
			/**
			 * Verificam daca si fiul din dreapta este NaN
			 */
			if (node.getRight().getVar().value().contentEquals("NaN") || ok == 1) {
				res += "NaN";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("int");
				return res;
			}
			int b = Integer.parseInt(node.getRight().getVar().value());
			/**
			 * calculam rezultatul si il suprascriem in campul value din campul
			 * val al parintelui
			 */
			Integer c = a + b;
			res += c.toString();
			node.getVar().setVal(res);
			node.getVar().setTypeNode("int");
		} else if (node.getRight().getVar().type().contentEquals("double")) {
			/**
			 * int + double -> double
			 */
			if (node.getRight().getVar().value().contentEquals("NaN") || ok == 1) {
				res += "NaN";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("double");
				return res;
			}
			/**
			 * calculam rezultatul aduarii si suprascriem corespunzator campul
			 * value din campul var al parintelui
			 */
			double b = Double.parseDouble(node.getRight().getVar().value());
			Double c = b + a;
			res += c.toString();
			node.getVar().setVal(res);
			node.getVar().setTypeNode("double");
		} else if (node.getRight().getVar().type().contentEquals("String")) {
			/**
			 * int + String -> String se va realiza concatenarea dintre fiul din
			 * stanga si fiul din dreapta al nodului si se va suprascrie
			 * rezultatul in campul value al variabilei din parinte.
			 */
			String b = node.getRight().getVar().value();
			res += a;
			res += b;
			node.getVar().setVal(res);
			node.getVar().setTypeNode("String");
		}
		return res;
	}

	/**
	 * 
	 * @param node
	 *            un nod ce contine o operatie de efectuat
	 * @return rezultatul operatiei dintre fii nodului
	 *         <p>
	 *         Metoda realizeaza adunarea a doi operatori atunci cand stim ca
	 *         primul dintre acestia(fiul din stanga al nodului) este un double.
	 *         <p>
	 *         Se verifica intai daca fiul din stanga este NaN, caz in care
	 *         rezultatul operatiei de adunare este tot NaN. Altfel, se
	 *         realizeaza conversia la Double a fiului din stanga.
	 *         <p>
	 *         Se afla tipul fiului din dreapta si se verifica daca acesta este
	 *         NaN. Daca oricare din cei doi fii este NaN se va face conversia
	 *         rezultatului la tipul corespunzator si se va returna NaN Altfel,
	 *         se va realiza corespunzator operatia de adunare in functie de
	 *         tipul fiului din dreapta: in cazul in care acesta este int sau
	 *         double se va declara o variabila de tipul respectiv, se va
	 *         efectua adunarea celor doua, si se va transmite mai departe
	 *         rezultatul folosind metoda toString din clasa Double, deoarece
	 *         int + double este double si double + double este double. In cazul
	 *         in care fiul din dreapta este String se va efectua concatenarea
	 *         dintre cei doi fii., efectuandu-se in prealabil rotunjirea
	 *         variabilei de tip double. In acest caz, fiul din stanga poate fii
	 *         si NaN
	 */
	public String additionLeftDouble(OpNode node) {
		String res = "";
		int ok = 0;
		Double a = 0.0;
		/**
		 * se verifica daca fiul din stanga e NaN
		 */
		if (node.getLeft().getVar().value().contentEquals("NaN")) {
			ok = 1;
		} else {
			a = Double.parseDouble(node.getLeft().getVar().value());
		}
		/**
		 * double + int -> double
		 */
		if (node.getRight().getVar().type().contentEquals("int")) {
			/**
			 * verificam daca unul dintre cei doi fii este NaN, caz i ncare
			 * rezultatul adunarii este tot NaN
			 */
			if (node.getRight().getVar().value().contentEquals("NaN") || ok == 1) {
				res += "NaN";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("double");
				return res;
			}
			/**
			 * efecutam adunarea si surpascriem campul value din cadrul campului
			 * var al parintelui
			 */
			int b = Integer.parseInt(node.getRight().getVar().value());
			Double c = a + b;
			res += c.toString();
			node.getVar().setVal(res);
			node.getVar().setTypeNode("double");
		} else if (node.getRight().getVar().type().contentEquals("double")) {
			/**
			 * double + double => double Verificam intai daca unul dintre fii
			 * este NaN
			 */
			if (node.getRight().getVar().value().contentEquals("NaN") || ok == 1) {
				res += "NaN";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("double");
				return res;
			}
			/**
			 * efecuam adunarea si surpascriem campul value din cadrul campului
			 * var al parintelui
			 */
			double b = Double.parseDouble(node.getRight().getVar().value());
			Double c = b + a;
			res += c.toString();
			node.getVar().setVal(res);
			node.getVar().setTypeNode("double");
		} else if (node.getRight().getVar().type().contentEquals("String")) {
			/**
			 * double + String => String Se va rotunji intai primul fiu la doua
			 * zecimale, apoi se va concatena cu cel de-al doilea si se va
			 * surpascrie campul value din cadrul campului var al parintelui
			 */
			String b = node.getRight().getVar().value();
			a = Math.round(a * 100) / 100.0;
			res += a;
			res += b;
			node.getVar().setVal(res);
			node.getVar().setTypeNode("String");
		}
		return res;
	}

	/**
	 * 
	 * @param node
	 *            nod ce contine operatia de efectuat
	 * @return String-ul rezultat in urma adunarii
	 *         <p>
	 *         Aceasta metoda realizeaza adunarea a doi termeni, atunci cand
	 *         primul este de tip String. In acest caz, se va realiza mereu
	 *         concatenarea celor doi fii ai nodului, indifierent de tipul celui
	 *         de-al doilea fiu, iar rezultatul va fi mereu de tip String.
	 *         <p>
	 *         Daca acesta este de tip Double, intai se va aproxima la 2
	 *         zecimale folosind Math.round, apoi de vor concatena la rezultat
	 *         primul, respectiv al doilea fiu, folosind metoda toString, se va
	 *         suprascrie valoarea din campul value al opertorului var din nodul
	 *         curent. Daca al doiela fiu este NaN, atunci rezultatul este tot o
	 *         concatenare. Verificarea o realizez pentru a fii sigura ca pot
	 *         face conversia la double a valorii din primul fiu, pentru a face
	 *         aproximarea.
	 *         <p>
	 *         Daca fiul din dreapta este de tip String, atunci rezultatul va
	 *         consta direct in concatenarea celor doi fii.
	 *         <p>
	 *         Daca al doilea fiu este de tip int, atunci se va proceda similar
	 *         cazului double, exceptand aproximarea: se concateneaza la
	 *         rezultat primul fiu. Apoi se verifica daca al doilea fiul este
	 *         NaN, pentru a se putea realiza conversia la Integer. Daca da, se
	 *         concateneaza direct NaN la rezultat si se suprascrie campul value
	 *         din operatorul var din cadrul nodului. Altfel, se face conversia
	 *         Integer-ului reprezentand al doileafiu la String folosind metoda
	 *         toString, se concateneaza la. rezultat, si se suprascie campul
	 *         value din operatorul var din cadrul nodului
	 */
	public String additionLeftString(OpNode node) {
		String res = "";
		String a = node.getLeft().getVar().value();
		/**
		 * String + String -> String
		 */
		if (node.getRight().getVar().type().contentEquals("String")) {
			res += a;
			res += node.getRight().getVar().value();
		} else if (node.getRight().getVar().type().contentEquals("int")) {
			/**
			 * String + int -> String
			 */
			String b = node.getRight().getVar().value();
			res += a;
			if (b.contentEquals("NaN")) {
				/**
				 * verificam pentru a putea realiza conversia
				 */
				res += b;
			} else {
				Integer c = Integer.parseInt(b);
				res += c.toString();
			}

		} else if (node.getRight().getVar().type().contentEquals("double")) {
			/**
			 * String + double -> String
			 */
			res += a;
			if (node.getRight().getVar().value().contentEquals("NaN")) {
				/**
				 * verificam pentru a putea realiza conversia
				 */
				res += "NaN";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("String");
				return res;
			}
			Double b = Double.parseDouble(node.getRight().getVar().value());
			/**
			 * rotunjim valoarea din al doilea fiu inainte de a o concatena la
			 * rezultat
			 */
			b = Math.round(b * 100) / 100.0;
			res += b;
		}
		node.getVar().setVal(res);
		node.getVar().setTypeNode("String");
		return res;
	}
}
