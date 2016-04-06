////package database;

/**********************
Derek Olsson 13207
Jeancarlo Barrios 14652

Database Project 1
**********************/

/*
Expresion de AND
*/


import java.io.Serializable;

public class AndExpression extends Expression implements Serializable {

  // Si no es Booleano, que super lo maneja
  public AndExpression(Expression l, Expression r){
    super(l,r);
  }

  public Boolean isTrue() throws Exception{
    Boolean left = this.left.isTrue();
    Boolean right = this.right.isTrue();

    if (left == null || right == null){
      return null;
    }

    else{
      return left && right;
    }

  }
}
