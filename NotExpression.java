/**********************
Derek Olsson 13207
Jeancarlo Barrios 14652

Database Project 1
**********************/

/*
Expresion NOT
*/

//package database;

import java.io.Serializable;

public class NotExpression extends Expression implements Serializable{

  public NotExpression(Expression e){
    super(e, null);
  }

  @Override
  public Boolean isTrue() throws Exception{
    Boolean left = this.left.isTrue();
    if (left==null){
      return null;
    }
    else{
      return !left;
    }
  }

}
