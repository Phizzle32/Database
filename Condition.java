public class Condition{
  public String leftOperand; // used with sel
  public String leftDataType; // num, str, col - used with sel
  public String operator; // used with sel
  public String rightOperand; // used with sel
  public String rightDataType; // num, str, col - used with sel

  public Condition(String l,String ld,String o,String r,String rd){
    leftOperand = l;
    leftDataType = ld;
    operator = o;
    rightOperand = r;
    rightDataType = rd;
  }
  
  public Condition(){
  }

  public String getLeftOperand(){
    return leftOperand;
  }
   
  public String getLeftDataType(){
    return leftDataType;
  }

  public String getOperator(){
    return operator;
  }

  public String getRightOperand(){
    return rightOperand;
  }

  public String getRightDataType(){
    return rightDataType;
  }

  public void setLeftOperand(String l){
    leftOperand = l;
  }
   
  public void setLeftDataType(String l){
    leftDataType = l;
  }

  public void setOperator(String l){
    operator = l;
  }

  public void setRightOperand(String l){
    rightOperand = l;
  }

  public void setRightDataType(String l){
    rightDataType = l;
  }
  
  public String toString(){
    return leftOperand+operator+rightOperand;
  }
}
