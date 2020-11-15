package labclass;

import javax.naming.InsufficientResourcesException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author zengfanyu
 * @date 2020/11/12 15:37
 */
public class Calculate {
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
                    postOrderExpression.append(temp);
                    temp = operatorStack.pop();
                }
            } else if (!isOperator(s)) {
                postOrderExpression.append(s);
            } else if (isOperator(s)) {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(s);
                } else if (!operatorStack.isEmpty()) {
                    int rank1 = rankMap.get(operatorStack.peek());
                    int rank2 = new Operator(s).getRank();
                    if (rank1 >= rank2) {
                        while (rank1 >= rank2 && !operatorStack.isEmpty()) {
                            postOrderExpression.append(operatorStack.pop());
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
            postOrderExpression.append(operatorStack.pop());
        }
        StringBuilder result = new StringBuilder();
        String[] str = postOrderExpression.toString().split("[()]");
        for (String s : str) {
            result.append(s);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        System.out.println("中序表达式：");
        String str = calculate.getPostOrderExpression("a + b * c + ( d * e + f ) * g");
        System.out.println(str);
    }
}
