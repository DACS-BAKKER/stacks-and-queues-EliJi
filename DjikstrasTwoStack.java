/* *****************************************************************************
 *  Name:    Eli Ji
 *  Date: 10-15-19
 *  Description: This class evaluates arithmetic expressions using
 *  Djikstras Two Stack Algorithm
 **************************************************************************** */

public class DjikstrasTwoStack {

    private Stack<Integer> operands = new Stack<Integer>();
    private Stack<Character> operators = new Stack<Character>();

    //Works with only single digit numbers
    private double evaluate(String expression){
        for (char c: expression.toCharArray()) {
            if(c == '(');
            else if (c == '+') operators.push(c);
            else if (c == '-') operators.push(c);
            else if (c == '*') operators.push(c);
            else if (c == '/') operators.push(c);
            else if (c == ')'){
                char currentOperator = operators.pop();
                int currentOperand = operands.pop();
                if (currentOperator == '+') currentOperand = currentOperand + operands.pop();
                else if (currentOperator == '-') currentOperand = currentOperand - operands.pop();
                else if (currentOperator == '*') currentOperand = currentOperand * operands.pop();
                else if (currentOperator == '/') currentOperand = currentOperand / operands.pop();
                operands.push(currentOperand);
            }
            else operands.push(Character.getNumericValue(c));
        }
        return operands.pop();
    }



    public static void main(String[] args) {
        DjikstrasTwoStack myDTS = new DjikstrasTwoStack();
        System.out.println("This program evaluates arithmetic expressions using Djikstras Two Stack Algorithm.");
        while(true) {
            System.out.println("Expression to evaluate?");
            String e = StdIn.readString();
            System.out.println(myDTS.evaluate(e));
        }
    }
}
