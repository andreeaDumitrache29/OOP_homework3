/**
 * 
 * @author Dumitrache Daniela Andreea Clasa care reprezinta
 *         identificatorii(variabilele din operatii. exemple: a, b, ana etc)
 */
public class Identifier implements Variable {
	/**
	 * tipul de data al vvariabilei
	 */
	private String type;
	/**
	 * numele variabilei
	 */
	private String name;
	/**
	 * valoarea variabilei
	 */
	private String value;

	/**
	 * 
	 * @return tipul variabilei
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 *            noul tip al variabilei
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return valoarea variabilei
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 
	 * @param value
	 *            noua valoare a variabilei
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 
	 * @return numele variabilei
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            noul nume al variabilei
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Constructor
	 * 
	 * @param type
	 *            tipul identificatorului
	 * @param value
	 *            valoarea identificatorului
	 * @param name
	 *            numele identificatorului
	 */
	public Identifier(String type, String value, String name) {
		super();
		this.name = name;
		this.type = type;
		this.value = value;
	}

	/**
	 * returneaza tipul identificatorului
	 */
	@Override
	public String type() {
		return type;
	}

	/**
	 * returneaza valoarea identificatorului
	 */
	@Override
	public String value() {
		return value;
	}

	/**
	 * seteaza tipul identificatorului
	 */
	@Override
	public void setTypeNode(String s) {
		this.setType(s);
	}

	/**
	 * seteaza valoarea identificatorului
	 */
	@Override
	public void setVal(String s) {
		this.setValue(s);
	}

	/**
	 * returneaza simbolul identificatorlui Folosit pentru a sti ca nodul din
	 * care va face parte identificatorul contine un identificator, nu un
	 * operator
	 */
	@Override
	public String symbol() {
		return "";
	}
}
