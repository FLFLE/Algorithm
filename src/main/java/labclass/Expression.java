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

    //建立每种符号到对应的优先级的映射
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
        /*用两个StringBuilder对象分别保存连续的后缀表达式和用空格分隔的后缀表达式
         连续的表达式供显示输出，空格分隔的表达式供计算使用
         */
        StringBuilder[] postOrderExpressions = new StringBuilder[2];
        postOrderExpressions[0] = new StringBuilder();
        postOrderExpressions[1] = new StringBuilder();
        Stack<String> operatorStack = new Stack<>();
        for (String s : expression) {
            //左括号直接入栈，直到遇到与之匹配的右括号才弹出
            if (s.equals("(")) {
                operatorStack.push("(");
            //遇到右括号时，将栈内剩下的操作符弹出，直到弹出左括号
            } else if (s.equals(")")) {
                temp = operatorStack.pop();
                while (!temp.equals("(")) {
                    postOrderExpressions[0].append(temp);
                    postOrderExpressions[1] = postOrderExpressions[0].append(" ");
                    temp = operatorStack.pop();
                }
            //当遇到数字时，直接添加到后序表达式中
            } else if (!isOperator(s)) {
                postOrderExpressions[0].append(s);
                postOrderExpressions[1] = postOrderExpressions[0].append(" ");
            //遇到操作符时，按照操作符的优先级，判断时候压栈或入栈或添加到后序表达式
            } else if (isOperator(s)) {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(s);
                } else if (!operatorStack.isEmpty()) {
                    int rank1 = rankMap.get(operatorStack.peek());
                    int rank2 = rankMap.get(s);
                    /*栈顶操作符优先级比当前操作符高，将栈顶元素依次出栈并添加到后序表达式中
                      直至栈顶元素操作符优先级低于当前操作符，并将当前操作符入栈*/
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

    //根据后序表达式计算结果
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
