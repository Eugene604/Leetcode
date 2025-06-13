package Problems;

import java.util.*;

//time: Beats 99.05%, memory: Beats 93.34%
public class Prob150 {

	public static void test() {
		String[] tokens1 = { "2", "1", "+", "3", "*" };
		String[] tokens2 = { "4", "13", "5", "/", "+" };
		String[] tokens3 = { "2", "1", "+", "3", "*" };
		String[] tokens4 = { "10","6","9","3","+","-11","*","/","*","17","+","5","+" };
		Solution150 solObj = new Solution150();

		String[] tokens;

		/*

		
		tokens = tokens3;
		System.out.println("tokens:¡@" + Arrays.toString(tokens));
		System.out.println("ans=" + solObj.evalRPN(tokens));

		// */

		tokens = tokens4;
		System.out.println("tokens:¡@" + Arrays.toString(tokens));
		System.out.println("ans=" + solObj.evalRPN(tokens));

	}// end method

	public static void main(String[] args) {
		test();

	}// end method

}

class Solution150 {
	
	public static final class RPN {
		public static final int PLUS = -1000;
		public static final int MINUS = -2000;
		public static final int MULTIPLY = -3000;
		public static final int DIVIDE = -4000;

		/**
		 * try convert a given string to number or operator
		 * assume str is not null and either a valid integer or operator symbol
		 * 
		 * @param str - string, assume not null and first character is the operator symbol if it is operator
		 * @return int, the value of the string, if it's operator, value will equal to the constants of this class
		 */
		public static int tryConvert(String str) {
			if (str.length()>1) {
				return Integer.parseInt(str);
			}//fi
			switch (str.charAt(0)) {
			case '+':
				return PLUS;
			case '-':
				return MINUS;
			case '*':
				return MULTIPLY;
			case '/':
				return DIVIDE;
			default:
				return Integer.parseInt(str);
			}//end method
		}//end method
		
		/**
		 * precondition: 
		 * assume str is not null and first character is the operator symbol
		 * @param str - string, assume not null and first character is the operator symbol
		 * @return true if it's an operator
		 */
		public static boolean isOperator(String str) {
			switch (str.charAt(0)) {
			case '+':
			case '-':
			case '*':
			case '/':
				return true;
			default:
				return false;
			}//end method
		}//end method
		
		/**
		 * check if given integer belongs to operator code
		 * @param val - int
		 * @return true if it's an operator
		 */
		public static boolean isOperator(int val) {
			switch (val) {
			case PLUS:
			case MINUS:
			case MULTIPLY:
			case DIVIDE:
				return true;
			default:
				return false;
			}//end method
		}//end method
		
		/**
		 * evaluate the equation 
		 * @param leftOperand - int
		 * @param operator - int
		 * @param rightOperand - int
		 * @return int, resulting value
		 */
		public static int eval(int leftOperand, int operator, int rightOperand) {
			
			int result = 0;
			switch (operator) {
			case PLUS:
				result = leftOperand + rightOperand;
				break;
			case MINUS:
				result = leftOperand - rightOperand;
				break;
			case MULTIPLY:
				result = leftOperand * rightOperand;
				break;
			case DIVIDE:
				result = leftOperand / rightOperand;
				break;
			}// end switch
			//System.out.println("eval: " + leftOperand + " : " + operator + " : " + rightOperand + " Result: " + result);
			return result;			
		}//end method
	}//end class

	public int evalRPN(String[] tokens) {

		
		ArrayDeque<Integer> expStk = new ArrayDeque<>();
		int tmpResult = 0;
		int leftOperand, rightOperand, operator;
		for (String token:tokens) {
			//System.out.print("try add:  " + token);
			expStk.push(RPN.tryConvert(token));
			if (RPN.isOperator(expStk.peek())){
				operator = expStk.pop();
				rightOperand = expStk.pop();
				leftOperand = expStk.pop();
				tmpResult = RPN.eval(leftOperand, operator, rightOperand);
				expStk.push(tmpResult);
			}//fi
			//System.out.println(expStk.toString());
		}//rof
		
		return expStk.pop();
	}// end method

}// end class
