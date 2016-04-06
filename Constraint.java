/**********************
Derek Olsson 13207
Jeancarlo Barrios 14652

Database Project 1
**********************/

/*
Clase base de constraints:
  CK = Check
  PK = Primary Key
  FK = Foreign Key

*/


//package database;

import java.io.Serializable;
import java.util.ArrayList;

public class Constraint implements Serializable{
  //ints para cada tipo
  final static int CH=0;
  final static int PK=1;
  final static int FK=2;

  String table;
  String name;
  int type;
  ArrayList<Column> columnPKs;
  ArrayList<Column> localFKs;
  ArrayList<Column> refKeys;
  String foreignTable;
  String exprTxt;
  Expression expr;

//With primary key
  public Constraint(String s, int i, ArrayList<Column> pk, String t){
    name = s;
    type = i;
    columnPKs = pk;
    table = t;
    }

//With foreign key
  public Constraint(String s, int i, ArrayList<Column> loc, ArrayList<Column> ref, String forTab, String t){
    name = s;
    type = i;
    localFKs = loc;
    refKeys = ref;
    foreignTable = forTab;
    table = t;
  }

  //With Check
  public Constraint(String s, int i, Expression e, String t, String exp){
    name = s;
    type = i;
    expr = e;
    table = t;
    exprTxt = exp;
  }

  public String getTypeString(int i){
    String s = "";
    switch(type){
      case 0:
        s="CHECK";
        break;

      case 1:
        s="PK";
        break;

      case 2:
        s="FK";
        break;
    }

    return s;
  }

  public String toString(){
    String s = "CONSTRAINT: "+name+" ";
    String t = "";

    switch(type){
      case 0:
        t = "CHECK ( ";
        s += t;
        s += " "+ exprTxt + " )";
        break;

      case 1:
        t = "PK ( ";
        s += t;
        for(Column c:columnPKs){
          s += c.name + ", ";
        }
        s += " ) ";
        break;

      case 2:
        t = "FK ( ";
        s += t;
        for(Column c:localFKs){
          s += c.name + ", ";
        }
        s += "REFERENCES " + foreignTable + " (";
        for (Column c:refKeys){
          s += c.name + ", ";
        }
        s += ") ";
        break;

    }
    return s;
  }

}
