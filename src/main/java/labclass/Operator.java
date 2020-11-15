package labclass;

/**
 * @author zengfanyu
 * @date 2020/11/12 17:52
 */
public class Operator {
    private String operator;
    private int rank;
    public Operator(String operator) {
        if(operator.equals("+") || operator.equals("-")){
            this.rank = 1;
        }
        else if(operator.equals("*") || operator.equals("/")){
            this.rank = 2;
        }
        else if(operator.equals("(") || operator.equals(")")){
            this.rank = 0;
        }
        this.operator = operator;
    }
    public int getRank(){
        return rank;
    }
    public String getOperator(){
        return operator;
    }
}
