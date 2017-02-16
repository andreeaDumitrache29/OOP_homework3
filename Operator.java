/**
 * 
 * @author Dumitrache Daniela Andreea
 *         <p>
 *         clasa folosita pentru a reprezenta un operator
 */
public class Operator implements Variable {
	/**
	 * simbolul operatorului: +,-,*,/
	 */
	private String symbol;
	/**
	 * prioritatea operatorului
	 */
	private int priority;
	/**
	 * tipul operatorului; initial vid, se va modifica in timpul evaluarii
	 * deoarece in parinte se va retine rezultatul operatiei dintre copii
	 */
	private String type = "";
	/**
	 * valoarea operatorului; initial vid, se va modifica in timpul evaluarii
	 * deoarece in parinte se va retine rezultatul operatiei dintre copii
	 */
	private String value = "";

	/**
	 * 
	 * @return prioritatea operatorului
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * 
	 * @param priority
	 *            noua prioritate a operatorului
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * 
	 * @return simbolul operatorului
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * noul simbol al operatorului
	 * 
	 * @param symbol
	 *            simbolul operatorului
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * 
	 * @return tipul operatorului
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 *            noul tip al operatorului
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return valoarea operatorului
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 
	 * @param value
	 *            noua valoare a operatorlui
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 
	 * @param other
	 *            un alt operator
	 * @return 1, daca operatorul curent are prioritate mai mare decat
	 *         operatorul other 0, daca operatorul curent are prioritate egala
	 *         decat operatorul other -1, daca operatorul curent are prioritate
	 *         mai mica decat operatorul other
	 */
	public int ComparePriority(Operator other) {
		return priority > other.getPriority() ? 1 : other.getPriority() == priority ? 0 : -1;
	}

	/**
	 * 
	 * @param symbol
	 *            simbol
	 * @param priority
	 *            prioritate
	 *            <p>
	 *            constructor
	 */
	public Operator(String symbol, int priority) {
		super();
		this.symbol = symbol;
		this.priority = priority;
	}

	/**
	 * tipul operatorului
	 */
	@Override
	public String type() {
		return type;
	}

	/**
	 * valoarea operatorului
	 */
	@Override
	public String value() {
		return value;
	}

	/**
	 * setarea noii valori pentru tipul operatorului
	 */
	@Override
	public void setTypeNode(String s) {
		this.setType(s);
	}

	/**
	 * setarea noii valori pentru valoarea operatorului
	 */
	@Override
	public void setVal(String s) {
		this.setValue(s);
	}

	/**
	 * simbolul operatorului
	 */
	@Override
	public String symbol() {
		return this.symbol;
	}
}
