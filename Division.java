/**
 * 
 * @author Dumitrache Daniela Andreea
 *         <p>
 *         Clasa folosita pentru a efectua impartirea dintre fii unui nod dat
 *
 */
public class Division {
	/**
	 * 
	 * @param node
	 *            nodul intre ai carui fii se va efectua impartirea
	 * @return rezultatul imparitirii
	 *         <p>
	 *         Metoda realizeaza impartirea dintre fii unui nod dat atunci cand
	 *         fiul din stanga este de tip int.
	 *         <p>
	 *         Intai se verifica daca fiul din stanga este NaN. daca da, atunci
	 *         ok devine 1, altfel, se intantieaza un Integer cu valoarea din
	 *         fiul stang.
	 *         <p>
	 *         Daca fiul din dreapta este int: se verifica intai daca unul
	 *         dintre cei doi fii este NaN sau daca al doilea fiu este 0(nu
	 *         putem impartii la 0), caz in care rezultatul operatiei de
	 *         impartire este NaN. Altfel, se declara un Integer cu valoarea
	 *         fiului din dreapta si un Integer c care va contine rezultatul
	 *         impartirii valorilor din cei doi fii. Acesta va fi concatenat
	 *         rezultatului folosind metoda toString. Se va suprascrie valoarea
	 *         din variabila din nodul parinte cu noul rezultat si tipul
	 *         acestuia cu int si se va transmite rezultatul.
	 *         <p>
	 *         Daca fiul din dreapta este double: se verifica intai daca unul
	 *         dintre cei doi fii este NaN sau daca al doilea fiu este 0(nu
	 *         putem impartii la 0), caz in care rezultatul operatiei de
	 *         impartire este NaN. Altfel, se declara un Double cu valoarea
	 *         fiului din dreapta si un Double c care va contine rezultatul
	 *         impartirii valorilor din cei doi fii. Acesta va fi concatenat
	 *         rezultatului folosind metoda toString. Se va suprascrie valoarea
	 *         din variabila din nodul parinte cu noul rezultat si tipul
	 *         acestuia cu double si se va transmite rezultatul.
	 *         <p>
	 *         Daca fiul din dreapta este String: se verifica intai daca unul
	 *         dintre cei doi fii este NaN sau daca lungimea valorii celui de-al
	 *         doilea fiu este 0(nu putem impartii la 0), caz in care rezultatul
	 *         operatiei de impartire este NaN. Altfel, se declara un Integer cu
	 *         lungimea valoarii fiului din dreapta si un Integer c care va
	 *         contine rezultatul impartirii lungimii valorilor din cei doi fii.
	 *         Acesta va fi concatenat rezultatului folosind metoda toString. Se
	 *         va suprascrie valoarea din variabila din nodul parinte cu noul
	 *         rezultat si tipul acestuia cu int si se va transmite rezultatul.
	 */
	public String divLeftInt(OpNode node) {
		String res = "";
		Integer a = 0;
		int ok = 0;
		/**
		 * verificare fiu stanga NaN
		 */
		if (node.getLeft().getVar().value().contentEquals("NaN")) {
			ok = 1;
		} else {
			a = Integer.parseInt(node.getLeft().getVar().value());
		}
		if (node.getRight().getVar().type().contentEquals("int")) {
			/**
			 * int / int -> int se verifica daca unul dintre fii este NaN sau
			 * daca al doilea fiu este 0 in acest caz rezultatul e NaN
			 */
			if (node.getRight().getVar().value().contentEquals("NaN") || ok == 1
					|| Integer.parseInt(node.getRight().getVar().value()) == 0) {
				res += "NaN";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("int");
				return res;
			}
			/**
			 * se calculeaza rezultatul impartirii
			 */
			Integer b = Integer.parseInt(node.getRight().getVar().value());
			Integer c = a / b;
			res += c.toString();
			node.getVar().setVal(res);
			node.getVar().setTypeNode("int");
			return res;
		} else if (node.getRight().getVar().type().contentEquals("double")) {
			/**
			 * int / double -> double
			 */
			if (node.getRight().getVar().value().contentEquals("NaN") || ok == 1
					|| Double.parseDouble(node.getRight().getVar().value()) == 0) {
				/**
				 * int / int -> int se verifica daca unul dintre fii este NaN
				 * sau daca al doilea fiu este 0 in acest caz rezultatul e NaN
				 */
				res += "NaN";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("double");
				return res;
			}
			/**
			 * se calculeaza rezultatul impartirii
			 */
			Double b = Double.parseDouble(node.getRight().getVar().value());
			Double c = a / b;
			res += c.toString();
			node.getVar().setVal(res);
			node.getVar().setTypeNode("double");
			return res;
		} else {
			/**
			 * int / String -> int se va converti sirul la un int cu valoarea
			 * egala cu dimensiunea sirului se verifica daca unul dintre fii
			 * este NaN sau daca al doilea fiu este 0 in acest caz rezultatul e
			 * NaN
			 */
			if (node.getRight().getVar().value().contentEquals("NaN") || ok == 1
					|| node.getRight().getVar().value().length() == 0) {
				res += "NaN";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("int");
				return res;
			}
			/**
			 * se calculeaza rezultatul impartirii
			 */
			Integer b = node.getRight().getVar().value().length();
			Integer c = a / b;
			res += c.toString();
			node.getVar().setVal(res);
			node.getVar().setTypeNode("int");
			return res;
		}
	}

	/**
	 * 
	 * @param node
	 *            nodul intre ai carui fii se va efectua impartirea
	 * @return rezultatul imparitirii
	 *         <p>
	 *         Metoda realizeaza impartirea dintre fii unui nod dat atunci cand
	 *         fiul din stanga este de tip double.
	 *         <p>
	 *         Intai se verifica daca fiul din stanga este NaN. daca da, atunci
	 *         ok devine 1, altfel, se intantieaza un Double cu valoarea din
	 *         fiul stang.
	 *         <p>
	 *         Daca fiul din dreapta este int: se verifica intai daca unul
	 *         dintre cei doi fii este NaN sau daca al doilea fiu este 0(nu
	 *         putem impartii la 0), caz in care rezultatul operatiei de
	 *         impartire este NaN. Altfel, se declara un Integer cu valoarea
	 *         fiului din dreapta si un Double c care va contine rezultatul
	 *         impartirii valorilor din cei doi fii. Acesta va fi concatenat
	 *         rezultatului folosind metoda toString. Se va suprascrie valoarea
	 *         din variabila din nodul parinte cu noul rezultat si tipul
	 *         acestuia cu double si se va transmite rezultatul.
	 *         <p>
	 *         Daca fiul din dreapta este double: se verifica intai daca unul
	 *         dintre cei doi fii este NaN sau daca al doilea fiu este 0(nu
	 *         putem impartii la 0), caz in care rezultatul operatiei de
	 *         impartire este NaN. Altfel, se declara un Double cu valoarea
	 *         fiului din dreapta si un Double c care va contine rezultatul
	 *         impartirii valorilor din cei doi fii. Acesta va fi concatenat
	 *         rezultatului folosind metoda toString. Se va suprascrie valoarea
	 *         din variabila din nodul parinte cu noul rezultat si tipul
	 *         acestuia cu double si se va transmite rezultatul.
	 *         <p>
	 *         Daca fiul din dreapta este String: se verifica intai daca unul
	 *         dintre cei doi fii este NaN sau daca lungimea valorii celui de-al
	 *         doilea fiu este 0(nu putem impartii la 0), caz in care rezultatul
	 *         operatiei de impartire este NaN. Altfel, se declara un Integer cu
	 *         lungimea valoarii fiului din dreapta si un Double c care va
	 *         contine rezultatul impartirii lungimii valorilor din cei doi fii.
	 *         Acesta va fi concatenat rezultatului folosind metoda toString. Se
	 *         va suprascrie valoarea din variabila din nodul parinte cu noul
	 *         rezultat si tipul acestuia cu double si se va transmite
	 *         rezultatul.
	 */
	public String divLeftDouble(OpNode node) {
		String res = "";
		Double a = 0.0;
		int ok = 0;
		/**
		 * verificam daca primul fiu e NaN
		 */
		if (node.getLeft().getVar().value().contentEquals("NaN")) {
			ok = 1;
		} else {
			a = Double.parseDouble(node.getLeft().getVar().value());
		}
		if (node.getRight().getVar().type().contentEquals("int")) {
			/**
			 * double / int -> double
			 */
			if (node.getRight().getVar().value().contentEquals("NaN") || ok == 1
					|| Integer.parseInt(node.getRight().getVar().value()) == 0) {
				/**
				 * verificam daca unul dintre cei doi fii e NaN sau al doilea
				 * fiu 0 Rezultatul in acest caz e NaN, iar tipul rezultatului
				 * este double
				 */
				res += "NaN";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("double");
				return res;
			}
			/**
			 * realizam impartirea
			 */
			Integer b = Integer.parseInt(node.getRight().getVar().value());
			Double c = a / b;
			res += c.toString();
			node.getVar().setVal(res);
			node.getVar().setTypeNode("double");
			return res;
		} else if (node.getRight().getVar().type().contentEquals("double")) {
			/**
			 * double / double -> double
			 */
			if (node.getRight().getVar().value().contentEquals("NaN") || ok == 1
					|| Double.parseDouble(node.getRight().getVar().value()) == 0) {
				/**
				 * verificam daca unul dintre cei doi fii e NaN sau al doilea
				 * fiu 0 Rezultatul in acest caz e NaN, iar tipul rezultatului
				 * este double
				 */
				res += "NaN";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("double");
				return res;
			}
			/**
			 * realizam impartirea
			 */
			Double b = Double.parseDouble(node.getRight().getVar().value());
			Double c = a / b;
			res += c.toString();
			node.getVar().setVal(res);
			node.getVar().setTypeNode("double");
			return res;
		} else {
			/**
			 * double / String -> double se va converti Stringul la un int cu
			 * valoarea egala cu dimensiunea String-ului
			 */
			if (node.getRight().getVar().value().contentEquals("NaN") || ok == 1
					|| node.getRight().getVar().value().length() == 0) {
				/**
				 * verificam daca unul dintre cei doi fii e NaN sau al doilea
				 * fiu 0 Rezultatul in acest caz e NaN, iar tipul rezultatului
				 * este double
				 */
				res += "NaN";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("double");
				return res;
			}
			/**
			 * realizam impartirea
			 */
			Integer b = node.getRight().getVar().value().length();
			Double c = a / b;
			res += c.toString();
			node.getVar().setVal(res);
			node.getVar().setTypeNode("double");
			return res;
		}
	}

	/**
	 * 
	 * @param node
	 *            nodul intre ai carui fii se va efectua impartirea
	 * @return rezultatul imparitirii
	 *         <p>
	 *         Metoda realizeaza impartirea dintre fii unui nod dat atunci cand
	 *         fiul din stanga este de tip String.
	 *         <p>
	 *         Intai se verifica daca fiul din stanga este NaN. Daca da, atunci
	 *         ok devine 1. Se intantieaza un String a cu valoarea din fiul
	 *         stang.
	 *         <p>
	 *         Daca fiul din dreapta este int: se verifica intai daca fiul din
	 *         dreapta este NaN sau daca al doilea fiu este mai mic decat 0, caz
	 *         in care rezultatul operatiei de impartire este string-ul a.
	 *         Altfel, se declara un Integer b cu valoarea fiului din dreapta si
	 *         string-ul res devine string-ul a, fara ultimele lungimea lui a /
	 *         b caractere. Acesta va fi concatenat rezultatului folosind metoda
	 *         toString. Se va suprascrie valoarea din variabila din nodul
	 *         parinte cu noul rezultat si tipul acestuia cu String si se va
	 *         transmite rezultatul.
	 *         <p>
	 *         Daca fiul din dreapta este double: se verifica intai daca unul
	 *         dintre cei doi fii este NaN sau daca al doilea fiu este 0(nu
	 *         putem impartii la 0), caz in care rezultatul operatiei de
	 *         impartire este NaN. Altfel, se declara un Double b cu valoarea
	 *         fiului din dreapta si un Double c care va contine rezultatul
	 *         impartirii lungimii lui a la b. Acesta va fi concatenat
	 *         rezultatului folosind metoda toString. Se va suprascrie valoarea
	 *         din variabila din nodul parinte cu noul rezultat si tipul
	 *         acestuia cu double si se va transmite rezultatul.
	 *         <p>
	 *         Daca fiul din dreapta este String: se verifica intai daca unul
	 *         dintre cei doi fii este NaN sau daca lungimea valorii celui de-al
	 *         doilea fiu este 0(nu putem impartii la 0), caz in care rezultatul
	 *         operatiei de impartire este NaN. Altfel, se declara un Integer cu
	 *         lungimea valorii fiului din dreapta si un Integer c care va
	 *         contine rezultatul impartirii lungimii valorilor din cei doi fii.
	 *         Acesta va fi concatenat rezultatului folosind metoda toString. Se
	 *         va suprascrie valoarea din variabila din nodul parinte cu noul
	 *         rezultat si tipul acestuia cu Integer si se va transmite
	 *         rezultatul.
	 */
	public String divLeftString(OpNode node) {
		String res = "";
		String a = node.getLeft().getVar().value();
		int ok = 0;
		if (a.contentEquals("NaN")) {
			ok = 1;
		}
		if (node.getRight().getVar().type().contentEquals("int")) {
			/**
			 * String / int -> String
			 */
			if (node.getRight().getVar().value().contentEquals("NaN")
					|| Integer.parseInt(node.getRight().getVar().value()) <= 0) {
				/**
				 * verificam daca fiul din dreapta e NaN sau al doilea fiu e <0.
				 * Rezultatul in acest caz e NaN, iar tipul rezultatului este
				 * String.
				 */
				res += a;
				node.getVar().setVal(res);
				node.getVar().setTypeNode("String");
				return res;
			}
			/**
			 * Realizam impartirea
			 */
			Integer b = Integer.parseInt(node.getRight().getVar().value());
			res += a.substring(0, (int) a.length() / b);
			node.getVar().setTypeNode("String");
			node.getVar().setVal(res);
			return res;
		} else if (node.getRight().getVar().type().contentEquals("double")) {
			/**
			 * String / double -> double
			 */
			if (node.getRight().getVar().value().contentEquals("NaN") || ok == 1
					|| Double.parseDouble(node.getRight().getVar().value()) == 0) {
				/**
				 * verificam daca unul dintre cei doi fii e NaN sau al doilea
				 * fiu 0. Rezultatul in acest caz e NaN, iar tipul rezultatului
				 * este double
				 */
				res += "NaN";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("double");
				return res;
			}
			/**
			 * Realizam impartirea
			 */
			Double b = Double.parseDouble(node.getRight().getVar().value());
			Double c = a.length() / b;
			res += c.toString();
			node.getVar().setVal(res);
			node.getVar().setTypeNode("double");
			return res;
		} else {
			/**
			 * String / String -> int se va converti fiecare String la un int cu
			 * valoarea egala cu dimensiunea String-ului respectiv
			 */
			if (node.getRight().getVar().value().contentEquals("NaN") || ok == 1
					|| node.getRight().getVar().value().length() == 0) {
				/**
				 * verificam daca unul dintre cei doi fii e NaN sau al lungimea
				 * valorii celui de-al doilea fiu 0. Rezultatul in acest caz e
				 * NaN, iar tipul rezultatului este int
				 */
				res += "NaN";
				node.getVar().setVal(res);
				node.getVar().setTypeNode("int");
				return res;
			}
			/**
			 * Realizam impartirea
			 */
			Integer b = node.getRight().getVar().value().length();
			Integer c = a.length() / b;
			res += c.toString();
			node.getVar().setVal(res);
			node.getVar().setTypeNode("int");
			return res;
		}
	}
}
