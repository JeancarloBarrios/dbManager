/**********************
Derek Olsson 13207
Jeancarlo Barrios 14652

Database Project 1
**********************/

/*
Clase de Columnas
*/


//package database;

import java.io.Serializable;

public class Column implements Serializable{

  //Declarar diferentes tipos de columnas
  static final int INT_COLUMN = 0;
  static final int FLOAT_COLUMN = 1;
  static final int CHAR_COLUMN = 2;
  static final int DATE_COLUMN = 3;

  /*************************
  type es tipo
  size es cantidad de char
  name es nombre
  table es tabla
  **************************/

  int type;
  int size;
  String name;
  String table;

//Para char
  public Column(String n,int t,int s, String tbl ){
    name = n;
    type = t;
    size = s;
    table = tbl;
  }

//Para non char (no tiene tamaño)
  public Column(String n, int t, String tbl){
    name = n;
    type = t;
    size = -1;
    table = tbl;
  }

//Return tipo como String
  public String getTypeString(int i){
    String s = "";
    switch(i){
      case 0:
          s="INT";
          break;
      case 1:
          s="FLOAT";
          break;
      case 2:
          s="CHAR("+size+")";
          break;
      case 3:
          s="DATE";
          break;
      }
    return s;
    }

  public String toString(){
    String s = "";

    switch(type){
      case 0:
        s="INT";
        break;
      case 1:
        s = "FLOAT";
        break;
      case 2:
        s = "CHAR("+size+")";
        break;
      case 3:
        s = "DATE";
        break;
      }

    String str = name + " TYPE: " + s + ",";
    return str;
    }
}
