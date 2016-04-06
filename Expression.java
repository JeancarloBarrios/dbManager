////package database;

/**********************
Derek Olsson 13207
Jeancarlo Barrios 14652

Database Project 1
**********************/

/*
Sirve come base para expresiones
*/


import java.io.Serializable;

public abstract class Expression implements Serializable {

  Expression left;
  Expression right;

  public Expression(){
    left=null;
    right=null;
  }

  public Expression(Expression l, Expression r){
    left = l;
    right = r;
  }

  public abstract Boolean isTrue() throws Exception;
}
