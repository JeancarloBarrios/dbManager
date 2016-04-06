/**********************
Derek Olsson 13207
Jeancarlo Barrios 14652

Database Project 1
**********************/

/*
Meta deta de columnas
*/


//package database;

import java.io.Serializable;

public class ColumnMetaData implements Serializable{

  String name;
  String type;

  public ColumnMetaData(String n, String t){
    name = n;
    type = t;
  }

  public String toString(){
    String s = name + " TYPE: " + type;
    return s;
  }
}
