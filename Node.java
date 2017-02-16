/**
 * 
 * @author Dumitrache Daniela Andreea Clasa folosita pentru a reprezenta
 *         nodurile din arbore
 *
 */
public abstract class Node {
	/**
	 * fiul stang al nodului
	 */
	protected Node left;
	/**
	 * fiul drept al nodului
	 */
	protected Node right;
	/**
	 * variabila poate fi un identificator sau o operatie, in functie de scopul
	 * nodului
	 */
	protected Variable var;
	/**
	 * valoare booleana pentru a stii, in timpul parcurgerii, daca nodul a mai
	 * fost sau nu vizitat.
	 */
	protected boolean visited;

	/**
	 * constructor implicit
	 */
	public Node() {

	}

	/**
	 * Constructor
	 * 
	 * @param left
	 *            fiu stang
	 * @param right
	 *            fiu drept
	 *            <p>
	 *            se intitalizeaza cei doi fii ai nodului
	 */
	public Node(Node left, Node right) {
		this.left = left;
		this.right = right;
	}

	/**
	 * 
	 * @return fiul stang
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * 
	 * @param left
	 *            noul fiu stang
	 */
	public void setLeft(Node left) {
		this.left = left;
	}

	/**
	 * 
	 * @return fiul drept
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * 
	 * @param right
	 *            noul fiu drept
	 */
	public void setRight(Node right) {
		this.right = right;
	}

	/**
	 * 
	 * @return daca nodul a mai fost sau nu vizitat
	 */
	public boolean isVisited() {
		return visited;
	}

	/**
	 * 
	 * @param visited
	 *            noua valoare a campului visited
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	/**
	 * 
	 * @return variabila din nod(operator sau identificator)
	 */
	public Variable getVar() {
		return var;
	}

	/**
	 * 
	 * @param var
	 *            noua variabila a nodului
	 */
	public void setVar(Variable var) {
		this.var = var;
	}

	/**
	 * 
	 * @param visitor
	 *            functia de accept pentru visitor
	 */
	public abstract void accept(NodeVisitor visitor);
}
