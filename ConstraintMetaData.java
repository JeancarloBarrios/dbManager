/**********************
Derek Olsson 13207
Jeancarlo Barrios 14652

Database Project 1
**********************/

/*
MetaData de Constraints
*/


//package database;

import java.io.Serializable;

public class ConstraintMetaData implements Serializable{
  String name;
  String type;
  String desc;

  public ConstraintMetaData(String n, String t, String d){
    name = n;
    type = t;
    desc = d;
  }

  public ConstraintMetaData(String n, String t){
    name = n;
    type = t;
    desc = " ";
  }

  public String toString(){
    return desc;
  }

}
