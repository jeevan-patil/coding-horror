package xyz.jeevan.code.problems;

import java.util.Stack;
import java.util.logging.Logger;

/**
 * Reverse Polish Notation Calculator.
 *
 * Parses expressions like "1 2 3 + -" = -4
 */
public class ReversePolishNotationCalculator {

  private static Logger log = Logger.getLogger("ReversePolishNotationCalculator");

  public static void main(String[] args) {
    final String expression = "6 3 /";
    log.info(expression + " => " + new ReversePolishNotationCalculator().evaluate(expression));
  }

  public double evaluate(final String expression) {
    if (expression == null || expression.trim().length() == 0) {
      return 0;
    }

    Stack<Double> operands = new Stack<>();

    String[] tokens = expression.split("\\s+");
    for (String token : tokens) {

      switch (token) {
        case "+":
          operands.push(operands.pop() + operands.pop());
          break;
        case "-":
          operands.push(-operands.pop() + operands.pop());
          break;
        case "/":
          double divisor = operands.pop();
          operands.push(operands.pop() / divisor);
          break;
        case "*":
          operands.push(operands.pop() * operands.pop());
          break;
        default:
          operands.push(Double.parseDouble(token));
          break;
      }
    }

    return operands.pop();
  }
}
