import java.util.HashMap;
import java.util.Stack;

/**
 * 
 * @author Dumitrache Daniela Andreea
 *         <p>
 *         Clasa folosita pentru a reprezenta arborele de parsare al expresiilor
 */
public class ParseTree {
	/**
	 * radacina
	 */
	private Node root;
	/**
	 * operatorii care se pot intalni in expresii
	 */
	private HashMap<String, Operator> operators;
	/**
	 * identificatorii care se pot intalni in expresii
	 */
	private HashMap<String, Identifier> identifiers;

	/**
	 * constructor
	 */
	public ParseTree() {
	}

	/**
	 * constructor
	 * 
	 * @param root
	 *            radacina
	 */
	public ParseTree(Node root) {
		this.setRoot(root);
	}

	/**
	 * 
	 * @return radacina arborelui
	 */
	public Node getRoot() {
		return root;
	}

	/**
	 * @param root
	 *            noua radacina
	 */
	public void setRoot(Node root) {
		this.root = root;
	}

	/**
	 * 
	 * @return HashMap-ul cu operatorii din arbore
	 */
	public HashMap<String, Operator> getOperators() {
		return operators;
	}

	/**
	 * 
	 * @param operators
	 *            noul HashMap cu operatorii din arbore
	 */
	public void setOperators(HashMap<String, Operator> operators) {
		this.operators = operators;
	}

	/**
	 * 
	 * @return HashMap-ul cu identificatorii din arbore
	 */
	public HashMap<String, Identifier> getIdentifiers() {
		return identifiers;
	}

	/**
	 * 
	 * @param identifiers
	 *            HashMap cu identificatorii din arbore
	 */
	public void setIdentifiers(HashMap<String, Identifier> identifiers) {
		this.identifiers = identifiers;
	}

	/**
	 * @param stack
	 *            stiva in care se vor tine nodurile de adaugat in arbore
	 *            (simuleaza optput queue din algoritmul dat)
	 * @param s
	 *            string pe baza caruia se va cauta un operator sau
	 *            identificator in operators sau identifiers: reprezentat de
	 *            simbol in cazul operatorilor si numele in cazul
	 *            idetificatorilor
	 *            <p>
	 *            metoda primeste o stiva, pe care se afla alte noduri, si un
	 *            string. pe baza string-ului, se va identifica un operator sau
	 *            identificator. Folosind acesta vom crea un nou nod, folosind
	 *            factory-ul de noduri, avand drept fii primele doua elemente de
	 *            pe stiva. Nodul nou creat este reintrodus in stiva
	 *            <p>
	 *            adaugam operatorii ramasi in stiva de operatori in arbore
	 *            folosind stivade noduri
	 *            <p>
	 *            radacina arborelui va fi nodul din varful stivei de noduri
	 */
	public void addNode(Stack<Node> stack, String s) {
		/**
		 * fii se extrag in ordine inversa datorita ordinii in care se face push
		 * pe stiva
		 */
		Node right = stack.pop();
		Node left = stack.pop();
		Variable var;
		/**
		 * instantiem variabila var cu un operator sau un identifier, in functie
		 * de string-ul dat
		 */
		if (operators.containsKey(s)) {
			var = operators.get(s);
		} else {
			var = identifiers.get(s);
		}
		/**
		 * creem noul nod, avand astfel si legaturile cu nodurile anterior
		 * create
		 */
		Node n = NodeFactory.getInstance().createNode(var);
		n.setLeft(left);
		n.setRight(right);
		stack.push(n);

	}

	/**
	 * 
	 * @param s
	 *            string reprezentand expresia de evaluat
	 * @return nodul radacina la arborelui
	 *         <p>
	 *         Metoda construieste arborele si returneaza radacina conform
	 *         algoritmului shunting yard:
	 *         <p>
	 *         daca se deschide o paranteza, deci o adaugam in stiva de
	 *         operatori
	 *         <p>
	 *         daca se intalneste un identificator, adaugam o frunza in stiva de
	 *         noduri
	 *         <p>
	 *         daca se inchide o paranteza: extragem elemente din stiva de
	 *         operatori si le punem in arbore folosind stiva de noduri pana
	 *         intalnim o paranteza deschisa
	 *         <p>
	 *         daca intalnim un operator: Extragem elemente de pe stiva cat timp
	 *         elementul din varf are prioritate mai mare sau egala cu
	 *         operatorul curent si adaugam ce am extras in arbore folosind
	 *         stiva de noduri La final, se adauga operatorul curent in stiva de
	 *         operatori.
	 * 
	 */
	public Node createTree(String s) {
		/**
		 * stiva pentru operatori
		 */
		Stack<String> opStack = new Stack<>();
		/**
		 * stiva cu care se va crea arborele
		 */
		Stack<Node> nodeStack = new Stack<>();
		/**
		 * impartim sirul cu expresia de evaluat in cuvinte dupa spatiu
		 */
		String[] tokens = s.split(" ");
		String k;

		for (String c : tokens) {
			switch (c) {
			case "(":
				/**
				 * se deschide o paranteza, deci o adaugam in stiva de operatori
				 **/
				opStack.push(c);
				break;
			case ")":
				/**
				 * se inchide o paranteza. extragem elemente din stiva de
				 * operatori si le punem in arobre folosind stiva de noduri pana
				 * intalnim o paranteza deschisa
				 */
				while (opStack.isEmpty() == false) {
					k = opStack.pop();
					/**
					 * analizam pe rand elementele din stiva de operatori. cand
					 * s-a gasit o paranteza deschisa, s-a terminat expresia
					 */
					if (k.contentEquals("(")) {
						break;
					}
					/**
					 * altfel, construieste un nou nod cu operatorul curent
					 * extras de pe stiva de operatori si adauga-l in arbore
					 * folosind stiva de noduri
					 */
					else {
						addNode(nodeStack, k);
					}
				}
				break;
			default:
				if (identifiers.containsKey(c)) {
					/**
					 * S-a citit un idetificator se adauga un nou nod(frunza
					 * reprezentand identificatorul) in stiva de noduri
					 */
					Identifier identifier = identifiers.get(c);
					nodeStack.push(new IdNode(null, null, identifier));
				}
				if (operators.containsKey(c)) {
					/**
					 * s-a citit un operator Cautam corespondentul simbolului
					 * citit in HashMap-ul operators. Extragem elemente de pe
					 * stiva cat timp elementul din varf are prioritate mai mare
					 * sau egala cu operatorul curent si adaugam ce am extras in
					 * arbore folosind stiva de noduri La final, se adauga
					 * operatorul curent in stiva de operatori.
					 */
					Operator o1 = operators.get(c);
					Operator o2;
					while (!opStack.isEmpty() && null != (o2 = operators.get(opStack.peek()))) {
						if (o1.ComparePriority(o2) == 0 || o1.ComparePriority(o2) == -1) {
							String s2 = "";
							s2 += opStack.pop();
							addNode(nodeStack, s2);
						} else
							break;
					}
					opStack.push(c);
				}
			}
		}
		while (!opStack.isEmpty()) {
			/**
			 * adaugam operatorii ramasi in stiva de operatori in arbore
			 * folosind stivade noduri
			 */
			addNode(nodeStack, opStack.pop());
		}
		return nodeStack.pop();
	}

	/**
	 * 
	 * @param root
	 *            radacina arborelui
	 *            <p>
	 * 			Evalueaza expresia retinuta in arbore folosind visitor. Acesta
	 *            va efectua operatia corespunzatoare(daca exista) intre fii
	 *            nodului curent si va suprascrie rezultatul in parinte
	 *
	 */
	public void eval(Node root) {
		/**
		 * visitor pentru evaluarea expresiei
		 */
		Visitor visitor = new Visitor();
		/**
		 * apelam functia pentru fiul stang, daca nu este vizitat
		 */
		if (root.getLeft() != null && root.getLeft().isVisited() == false) {
			eval(root.getLeft());
		}
		/**
		 * apelam functia pe fiul drept, daca nu este deja vizitat
		 */
		if (root.getRight() != null && root.getRight().isVisited() == false) {
			eval(root.getRight());
		}
		/**
		 * apelam functia accept, care va efectua operatia corespunzatoare(daca
		 * exista) intre fii nodului curent si va suprascrie rezultatul in
		 * parinte
		 */
		root.accept(visitor);
		root.setVisited(true);
	}
	/**
	 * 
	 * @param root radacina arborelui
	 * <p>face toate nodurile nevizitate
	 */
	public void remake(Node root) {
		root.setVisited(false);
		if (root.getLeft() != null && root.getLeft().isVisited() == true) {
			remake(root.getLeft());
		}
		if (root.getRight() != null && root.getRight().isVisited() == true) {
			remake(root.getRight());
		}
	}
}
