package labclass;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author zengfanyu
 * @date 2020/11/12 15:37
 */
public class CalculateDemo {

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

    public String getPostOrderExpression(String middleOrderExpression) {
        String temp;
        String[] expression = middleOrderExpression.split(" ");
        StringBuilder postOrderExpression = new StringBuilder();
        Stack<String> operatorStack = new Stack<>();
        for (String s : expression) {
            if (s.equals("(")) {
                operatorStack.push("(");
            } else if (s.equals(")")) {
                temp = operatorStack.pop();
                while (!temp.equals("(")) {
                    postOrderExpression.append(temp).append(" ");
                    temp = operatorStack.pop();
                }
            } else if (!isOperator(s)) {
                postOrderExpression.append(s).append(" ");
            } else if (isOperator(s)) {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(s);
                } else if (!operatorStack.isEmpty()) {
                    int rank1 = rankMap.get(operatorStack.peek());
                    int rank2 = rankMap.get(s);
                    if (rank1 >= rank2) {
                        while (rank1 >= rank2 && !operatorStack.isEmpty()) {
                            postOrderExpression.append(operatorStack.pop()).append(" ");
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
            postOrderExpression.append(operatorStack.pop()).append(" ");
        }
        return postOrderExpression.toString();
    }

    public Double calculate(String expression) {
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
        return numbers.pop();
    }

    public static void main(String[] args) {
        CalculateDemo calculate = new CalculateDemo();
//        calculate.getPostOrderExpression("a + b * ( c + d ) * ( m / n + f )");
//        System.out.println(calculate.getPostOrderExpression("a + b * ( c + d )"));
        String expression;
        Scanner in = new Scanner(System.in);
        System.out.println("中序表达式：");
        expression = in.nextLine();
        System.out.println("后序表达式：" + calculate.getPostOrderExpression(expression));
        System.out.println("结果：" + calculate.calculate(calculate.getPostOrderExpression(expression)));

    }
}