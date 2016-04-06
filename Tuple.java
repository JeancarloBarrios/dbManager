/**********************
Derek Olsson 13207
Jeancarlo Barrios 14652

Database Project 1
**********************/

/*
Clase de tuplas
*/

//package database;

import java.io.Serializable;
import java.util.ArrayList;

public class Tuple implements Serializable{
  //Containing table
  Table table;
  ArrayList<Object> values;

  public Tuple(){
    //NADA
  }

  public Tuple(Table t){
    table = t;
    values = new ArrayList<Object>();
  }

  public Tuple(Table t, ArrayList<Object> arr){
    table = t;
    values = arr;
  }

  public String toString(){
    String s = "";
    for (Object v: values){
      if (v == NULL){
        s += "NULL , ";
      }
      else{
        s += v.toString() + " , ";
      }
    }
    return s;
  }
  
}
