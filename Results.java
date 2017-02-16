/**
 * 
 * @author Dumitrache Daniela Andreea
 *         <p>
 *         Clasa folosita pentru a efectua operatiile dintre noduri
 *
 */
public class Results {
	/**
	 * constructor
	 */
	public Results() {

	}

	/**
	 * <p>
	 * Metoda verifica simbolul din variabila nodului si apeleaza metoda de
	 * rezolvare corespunzatoare: addition, subtraction, multiplication sau
	 * division
	 * 
	 * @param node
	 *            nodul intre ai carui fii se vor efectua operatiile
	 */
	public void solve(OpNode node) {
		switch (node.getVar().symbol()) {
		case "+":
			solveAddition(node);
			break;
		case "-":
			solveSubtraction(node);
			break;
		case "*":
			solveMultiplication(node);
			break;
		case "/":
			solveDivision(node);
			break;
		}
	}

	/**
	 * <p>
	 * Avem de executat o adunare.
	 * <p>
	 * se instantieaza clasa addition si in functie de tipul fiului stang se
	 * apeleaza metoda corespunzatoare din cadrul acesteia: additionLeftInt,
	 * additionLeftDouble sau additionLeftString
	 * 
	 * @param node
	 *            nodul intre ai carui fii se va efectua adunarea
	 */
	public void solveAddition(OpNode node) {
		Addition ad = new Addition();
		if (node.getLeft().getVar().type().contentEquals("int")) {
			ad.additionLeftInt(node);
		} else if (node.getLeft().getVar().type().contentEquals("double")) {
			ad.additionLeftDouble(node);
		} else {
			ad.additionLeftString(node);
		}
	}

	/**
	 * <p>
	 * Avem de executat o scadere.
	 * <p>
	 * se instantieaza clasa subtraction si in functie de tipul fiului stang se
	 * apeleaza metoda corespunzatoare din cadrul acesteia: subLeftInt,
	 * subLeftDouble sau subLeftString
	 * 
	 * @param node
	 *            nodul intre ai carui fii se va efectua scaderea
	 */
	public void solveSubtraction(OpNode node) {
		Subtraction sub = new Subtraction();
		if (node.getLeft().getVar().type().contentEquals("int")) {
			sub.subLeftInt(node);
		} else if (node.getLeft().getVar().type().contentEquals("double")) {
			sub.subLeftDouble(node);
		} else {
			sub.subLeftString(node);
		}
	}

	/**
	 * <p>
	 * Avem de executat o inmultire.
	 * <p>
	 * se instantieaza clasa multiplication si in functie de tipul fiului stang
	 * se apeleaza metoda corespunzatoare din cadrul acesteia: multLeftInt,
	 * multLeftDouble sau multLeftString
	 * 
	 * @param node
	 *            nodul intre ai carui fii se va efectua inmultirea
	 */
	public void solveMultiplication(OpNode node) {
		Multiplication mul = new Multiplication();

		if (node.getLeft().getVar().type().contentEquals("int")) {
			mul.multLeftInt(node);
		} else if (node.getLeft().getVar().type().contentEquals("double")) {
			mul.multLeftDouble(node);
		} else {
			mul.multLeftString(node);
		}
	}

	/**
	 * <p>
	 * Avem de executat o impartirea.
	 * <p>
	 * se instantieaza clasa division si in functie de tipul fiului stang se
	 * apeleaza metoda corespunzatoare din cadrul acesteia: divLeftInt,
	 * divLeftDouble sau divLeftString
	 * 
	 * @param node
	 *            nodul intre ai carui fii se va efectua impartirea
	 */
	public void solveDivision(OpNode node) {
		Division div = new Division();
		if (node.getLeft().getVar().type().contentEquals("int")) {
			div.divLeftInt(node);
		} else if (node.getLeft().getVar().type().contentEquals("double")) {
			div.divLeftDouble(node);
		} else {
			div.divLeftString(node);
		}
	}

}
