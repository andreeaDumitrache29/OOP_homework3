/**
 * 
 * @author Dumitrache Daniela Andreea
 *         <p>
 *         Clasa ce implementeaza interfata NodeVisitor
 *         <p>
 *         folosita pentru a evalua expresiile din arbore
 *
 */
public class Visitor implements NodeVisitor {

	/**
	 * Instantieaza o variabila de tip Results si apeleaza metoda solve pe nodul
	 * curent din parcurgere, care evalueaza expresia curenta: realizeaza
	 * operatia indicata intre fii nodului si salveaza rezultatul si tipul
	 * rezultat in cadrul variabilei var din nodul parinte.
	 */
	@Override
	public void visit(OpNode node) {
		Results res = new Results();
		res.solve(node);
	}

	/**
	 * metoda primeste un Nod ce contine un identificator, deci acesta ramane
	 * neschimbat
	 */
	@Override
	public void visit(IdNode node) {
	}

}
