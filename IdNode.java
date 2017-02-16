/**
 * 
 * @author Dumitrache Daniela Andreea Clasa folosita pentru a reprezenta
 *         nodurile ale caror variabile sunt de tip Identifier. Aceste nodurie
 *         reprezinta nodurile ca codifica valori precum: a, b, c etc
 *
 */
public class IdNode extends Node {
	/**
	 * Constructor
	 * 
	 * @param id
	 *            Identifier-ul nodului
	 */
	public IdNode(Identifier id) {
		this.var = new Identifier(id.getType(), id.getValue(), id.getName());
	}

	/**
	 * Constructor
	 * 
	 * @param left
	 *            fiu stang
	 * @param right
	 *            fiu drept
	 * @param id
	 *            Identifier-ul nodului
	 */
	public IdNode(Node left, Node right, Identifier id) {
		super(left, right);
		this.var = new Identifier(id.getType(), id.getValue(), id.getName());
	}

	/**
	 * metoda accept pentru visitor
	 */
	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}
}
