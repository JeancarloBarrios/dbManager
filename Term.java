/**********************
Derek Olsson 13207
Jeancarlo Barrios 14652

Database Project 1
**********************/

/*
Clase de terminos indivuales
*/

//package database;

import java.io.Serializable;
import java.util.Date;
import java.time.LocalDate;

public class Term implements Serializable{
  //Static ints para cada posibilidad
  public static final int INT_TYPE=0;
  public static final int FLOAT_TYPE=1;
  public static final int CHAR_TYPE=2;
  public static final int DATE_TYPE=3;
  public static final int NULL_TYPE= -1;

  private Object value;
  int type;
  boolean isColumn;
  Column column;

  //Integer
  public Term(int i){
    value = i;
    type = INT_TYPE;
    isColumn = false;
  }

  //Float
  public Term(float f){
    value = f;
    type = FLOAT_TYPE;
    isColumn = false;
  }

  //Char
  public Term(String s){
    value = s;
    type = CHAR_TYPE;
    isColumn = false;
  }

  //Date
  public Term(Date d){
    value = d;
    type = DATE_TYPE;
    isColumn= false;
  }

  //NULL
  public Term(){
    value = null;
    type = NULL_TYPE;
    isColumn = false;
  }

  //columna de valores
  public Term(Column c){
    column = c;
    value = null;
    type = c.type;
    isColumn = true;
  }

  //getValue
  //Si !isColumn, regresar valor
  //Si isColumn, usar iteradora para cargar valor actual
  public Object getValue(){
    if (!isColumn){
      return value;
    }

    else{
      Table t = Loader.iterator.table;
      int index = t.getIndexColumn(column.name);
      Object v = Loader.iterator.getValueFromColumn(index);
      return v;
    }
  }

}
