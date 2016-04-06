/**********************
Derek Olsson 13207
Jeancarlo Barrios 14652

Database Project 1
**********************/

/*
Expresion OR
*/

//package database;

import java.io.Serializable;

public class OrExpression extends Expression implements Serializable{

  public OrExpression(Expression l, Expression r){
    super(l,r);
  }

  @Override
  public Boolean isTrue() throws Exception{
    Boolean left = this.left.isTrue();
    Boolean right = this.right.isTrue();

    //caso null
    if (left == null && right == null){
      return null;
    }
    //right null
    else if (left == null && right == true){
      return true;
    }
    //left null
    else if (left == true && right == null){
      return true;
    }
    //caso normal
    else{
      return left || right;
    }
  }
  
}
