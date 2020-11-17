package labclass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculate {
    Expression expression = new Expression();
    String str = ""; //文本框的内容
    JFrame frame;
    JTextField textField;
    JPanel panel1, panel2, panel3;
//    String[] History = new String[5];
//    int count_H = 0;//按下 历史记录 的次数
//    int count_equ = 0;//按下 = 的次数

    public Calculate() {

        frame = new JFrame("Calculator");
        frame.setLayout(new BorderLayout());
        frame.setLocation(300, 200);      //窗口在屏幕出现位置
        frame.setSize(500, 350);  //窗口默认尺寸

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置文本框长度
        textField = new JTextField(40);
        textField.setHorizontalAlignment(JTextField.RIGHT);//右对齐
        textField.setEditable(false);//文本框禁止编辑

        //向组件3中添加按钮
        panel3 = new JPanel();
        panel3.setLayout(new GridLayout(1, 4, 0, 0));
        //左右括号，清除，以及后序表达式
        JButton AC = new JButton("AC");
        JButton postOrderExpression = new JButton("后序表达式");
        JButton leftBrackets = new JButton("(");
        JButton rightBrackets = new JButton(")");
        panel3.add(leftBrackets);
        panel3.add(rightBrackets);
        panel3.add(AC);
        panel3.add(postOrderExpression);
        //置底
        frame.add(panel3, BorderLayout.SOUTH);

        panel1 = new JPanel();  //数字和运算符组件
        panel2 = new JPanel();  //文本框的组件
        panel1.setLayout(new GridLayout(4, 4, 0, 0));//4*4网格布局
        panel2.setLayout(new BorderLayout());//边界布局
        panel2.add(textField);//文本框置于panel2组件中

        //为AC按钮添加清除功能（清空str）
        AC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                str = "";
                textField.setText(str);
            }
        });

        //为左括号按钮添加功能
        leftBrackets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                str = str + "(" + " ";
            }
        });

        //为右括号按钮添加功能
        rightBrackets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                str = str + ")" + " ";
            }
        });

        postOrderExpression.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                str = expression.getPostOrderExpression(str)[0].toString();
                textField.setText(str);
                str = "";
            }
        });

        String[] buttonName = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", ".", "0", "=", "/"};
        for (String s : buttonName) {
            JButton button = new JButton(s);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String actionButton = e.getActionCommand();
                    int flag = 1;
                    if (actionButton.equals("+") || actionButton.equals("-") || actionButton.equals("*") || actionButton.equals("/")) {
                        str = str + " " + actionButton + " ";
                    } else if (actionButton.equals("=")) {
                        str = expression.calculate(expression.getPostOrderExpression(str)[1].toString());
                        textField.setText(str);
                        str = "";
                        flag = 0;
                    } else {
                        str = str + actionButton;
                    }
                    if (flag == 1) {
                        textField.setText(str);
                    }
                }

            });
            panel1.add(button);
        }
        frame.add(panel2, BorderLayout.NORTH);//置于顶部
        frame.add(panel1, BorderLayout.CENTER);
        //框体可视化
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Calculate();
    }
}