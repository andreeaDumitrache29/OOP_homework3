/**
 * 
 * @author Dumitrache Daniela Andreea
 *         <p>
 *         clasa folosita pentru a reprezenta nodurile ce au ca variabila un
 *         operator
 *
 */
public class OpNode extends Node {
	/**
	 * 
	 * @param op
	 *            operatorul care va reprezenta variabila var nodului
	 *            <p>
	 *            constructor
	 */
	public OpNode(Operator op) {
		var = new Operator(op.getSymbol(), op.getPriority());
	}

	/**
	 * 
	 * @param left
	 *            fiul stang
	 * @param right
	 *            fiul drept
	 * @param op
	 *            operatorul care va reprezenta variabila var nodului
	 *            <p>
	 *            constructor
	 */
	public OpNode(Node left, Node right, Operator op) {
		super(left, right);
		var = new Operator(op.getSymbol(), op.getPriority());
	}

	/**
	 * functia accept pentru visitor
	 */
	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

}
