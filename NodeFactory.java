/**
 * 
 * @author Dumitrache Daniela Andreea
 *         <p>
 *         Clasa folosita pentru pattern-ul de Factory, necesar in creerea
 *         nodurilor arborelui.
 *
 */
public class NodeFactory {
	/**
	 * instanta clasei, specifica pattern-ului de singleton
	 */
	private static NodeFactory instance = null;

	/**
	 * constructor de baza privat, folosit pentru a nu se putea invoca
	 * constructorul explicit.
	 */
	private NodeFactory() {
	}

	/**
	 * 
	 * @return instanta de factory deja existenta, daca aceasta a mai fost
	 *         creata. Altfel, se creeaza o noua instanta de factory si se
	 *         returneaza aceasta.
	 */
	public static NodeFactory getInstance() {
		if (instance == null) {
			instance = new NodeFactory();
		}
		return instance;
	}

	/**
	 * 
	 * @param var
	 *            un operator sau un Identificator
	 * @return un nod de tipul OpNode sau IdNode, in functie de variabila
	 *         primita
	 *         <p>
	 *         Metoda verifica daca parametrul primit, de tipul interfetei
	 *         Variable, este defapt o instanta de Operator sau de Identifier si
	 *         returneaza, in mod corespunzator, un nod de tipul OpNode sau
	 *         IdNode.
	 */
	public Node createNode(Variable var) {
		if (var instanceof Operator)
			return new OpNode((Operator) var);
		else
			return new IdNode((Identifier) var);
	}
}
