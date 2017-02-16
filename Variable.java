/**
 * 
 * @author Dumitrache Daniela Andreea
 *         <p>
 *         Interfata folosita ca tip generic pentru operator si identificatori
 *         <p>
 *         utilizata in nodurile arborelui pentru a putea avea un singur tip
 *         general de nod in arbore
 *         <p>
 *         variabila = identifier sau operator, in functie de caz
 * 
 */
public interface Variable {
	/**
	 * Operatorii pot ajunge sa aiba si ei tip in urma operatiilor din cadrul
	 * evaluarii, prin salvarea in parinte a rezultatului operatiei dintre
	 * copii, asa ca acesta este un tip comun atat pentru operatori, cat si
	 * pentru identificatori
	 * 
	 * @return tipul variabilei
	 */
	public String type();

	/**
	 * Operatorii pot ajunge sa aiba si ei valoare in urma operatiilor din
	 * cadrul evaluarii, prin salvarea in parinte a rezultatului operatiei
	 * dintre copii, asa ca acesta este un tip comun atat pentru operatori, cat
	 * si pentru identificatori
	 * 
	 * @return valoarea variabilei
	 */
	public String value();

	/**
	 * 
	 * @param s
	 *            noul tip al variabilei
	 */
	public void setTypeNode(String s);

	/**
	 * 
	 * @param s
	 *            noua valoare a variabilei
	 */
	public void setVal(String s);

	/**
	 * Simbol: +,-,*,/ in cazul operatorilor, sirul vid in cazul
	 * identificatorilor. Folosit pentru a stii ce operatie avem de efecuat
	 * 
	 * @return simbolul variabilei
	 */
	public String symbol();
}
