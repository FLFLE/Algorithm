package labclass;

import java.util.HashMap;

/**
 * @author zengfanyu
 * @date 2020/11/17 21:31
 */
public class Expression {
    private static boolean isOperator(String str) {
        return str.equals("+")
                || str.equals("-")
                || str.equals("*")
                || str.equals("/");
    }

    private HashMap<String, Integer> rankMap = new HashMap<>() {
        {
            put("+", 1);
            put("-", 1);
            put("*", 2);
            put("/", 2);
            put("(", 0);
            put(")", 0);
        }
    };

    //得到中序表达式对应的后序表达式
    public StringBuilder[] getPostOrderExpression(String middleOrderExpression) {
        String temp;
        String[] expression = middleOrderExpression.split(" ");
        StringBuilder[] postOrderExpressions = new StringBuilder[2];
        postOrderExpressions[0] = new StringBuilder();
        postOrderExpressions[1] = new StringBuilder();
        Stack<String> operatorStack = new Stack<>();
        for (String s : expression) {
            if (s.equals("(")) {
                operatorStack.push("(");
            } else if (s.equals(")")) {
                temp = operatorStack.pop();
                while (!temp.equals("(")) {
                    postOrderExpressions[0].append(temp);
                    postOrderExpressions[1] = postOrderExpressions[0].append(" ");
                    temp = operatorStack.pop();
                }
            } else if (!isOperator(s)) {
                postOrderExpressions[0].append(s);
                postOrderExpressions[1] = postOrderExpressions[0].append(" ");
            } else if (isOperator(s)) {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(s);
                } else if (!operatorStack.isEmpty()) {
                    int rank1 = rankMap.get(operatorStack.peek());
                    int rank2 = rankMap.get(s);
                    if (rank1 >= rank2) {
                        while (rank1 >= rank2 && !operatorStack.isEmpty()) {
                            postOrderExpressions[0].append(operatorStack.pop());
                            postOrderExpressions[1] = postOrderExpressions[0].append(" ");
                            if (!operatorStack.isEmpty()) {
                                rank1 = rankMap.get(operatorStack.peek());
                            } else break;
                        }
                    }
                    operatorStack.push(s);
                }
            }
        }
        while (!operatorStack.isEmpty()) {
            postOrderExpressions[0].append(operatorStack.pop());
            postOrderExpressions[1] = postOrderExpressions[0].append(" ");
        }
        return postOrderExpressions;
    }

    public String calculate(String expression) {
        Stack<Double> numbers = new Stack<>();
        double middleResult;
        double tempTop;
        String[] temp = expression.split(" ");
        for (String str : temp) {
            if (!isOperator(str)) {
                numbers.push(Double.parseDouble(str));
            } else {
                switch (str) {
                    case "+":
                        tempTop = numbers.pop();
                        middleResult = numbers.pop() + tempTop;
                        numbers.push(middleResult);
                        break;
                    case "-":
                        tempTop = numbers.pop();
                        middleResult = numbers.pop() - tempTop;
                        numbers.push(middleResult);
                        break;
                    case "*":
                        tempTop = numbers.pop();
                        middleResult = numbers.pop() * tempTop;
                        numbers.push(middleResult);
                        break;
                    case "/":
                        tempTop = numbers.pop();
                        middleResult = numbers.pop() / tempTop;
                        numbers.push(middleResult);
                        break;
                }
            }
        }
        return String.valueOf(numbers.pop());
    }

}
