/**
 * 
 * @author Dumitrache Daniela Andreea
 *         <p>
 *         Interfata folosita pentru design pattern-ul de visitor. Contine
 *         declaratia metodelor visit pentru nodurile de tip OpNode si IdNode.
 *
 */
public interface NodeVisitor {
	public void visit(OpNode node);

	public void visit(IdNode node);
}
