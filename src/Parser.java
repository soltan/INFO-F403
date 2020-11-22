import java.util.ArrayList;


/**
 * Parser Class
 */
public class Parser {

	private StackWrapper variableStack;
	private ActionTable acTab;
	private SymbolQueue symQue;

	/**
	 * Public constructor of the parser
	 * @param arr , the list of symbol generated by the scanner
	 */
	public Parser(ArrayList<Symbol> arr){
		variableStack = new StackWrapper();
		acTab = new ActionTable();
		symQue = new SymbolQueue(arr);
	}

	/**
	 * Public method starting the parsing
	 * @throws SyntaxException
	 */
	public void parseSequence() throws SyntaxException {
		variableStack.pushVar(new Variable(Variable.Type.V_PROGRAM)); // push initial state on the stack
		while (!(symQue.read().getType().equals(LexicalUnit.EOS))){
			System.out.println("look-ahead = "+ new Variable(symQue.read()).getType());
			System.out.println("top stack = " + variableStack.readLast().getType());
			acTab.getRule(variableStack.readLast(),new Variable(symQue.read())).action(variableStack,symQue);
		}
	}
}