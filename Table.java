/**********************
Derek Olsson 13207
Jeancarlo Barrios 14652

Database Project 1
**********************/

/*
Table functions
*/

//package database;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.Writer;

import java.awt.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

//import static database.DB.deleteFolder;
//import static database.DBMS.metaData;


public class Table implements Serializable{
  String name;
  ArrayList<Column> columns;
  ArrayList<Constraint> constraints;
  ArrayList<Tuple> tuples;

  public Table(){
    columns = new ArrayList<Column>();
    constraints = new ArrayList<Constraint>();
    tuples = new ArrayList<Tuple>();
  }

  public Table(String s, ArrayList<Column> c){
    name = s;
    columns = c;
    constraints = new ArrayList<Constraint>();
    tuples = new ArrayList<Tuple>();

    ArrayList<ColumnMetaData> cmd = new ArrayList<ColumnMetaData>();
    for (Column c : columns){
      cmd.add(new ColumnMetaData(c.name, c.getTypeString(c.type))),
    }

    TableMetaData t = new TableMetaData(name, cmd, new ArrayList<ConstraintMetaData>());
    DBMetaData d = DBMS.metaData.getDB(DBMS.currentDB);
    d.tables.add(t);
    DBMS.save();

    DBMS.metaData.writeMetaData();
    saveTable();
  }

  public boolean containsValue(Object value, int colInd){
    for(Tuple t : tuples){
      Object val = t.values.get(colInd);

      //Integers
      if (val instanceof Integer){
        int val2 = (Integer) val;
        int val3 = (Integer) value;
        if (val2 == val3){
          return true;
        }
      }

      //Floats
      else if (val instanceof Float){
        float val2 = (Float) val;
        float val3 = (Float) value;
        if (val2 == val3){
          return true;
        }
      }

      //Strings
      else if (val instanceof String){
        String val2 = (String) val.toString();
        String val3 = (String) value.toString();
        if (val2.equals(val3)){
          return true;
        }
      }

      //Dates
      else if (val instance of LocalDateTime){
        LocalDate val2 = (LocalDate) val;
        LocalDate val3 = (LocalDate) value;
        if (val2.equals(val3)){
          return true;
        }
      }
    }
    return false;
  }

  //Recursive to find null values
  public boolean hasNullValues(ArrayList<Integer> colInds){
    for (Tuple t : tuples){
      if (hasNullValues(colInds), t){
        return true;
      }
    }
    return false;
  }

  public boolean hasNullValues(ArrayList<Integer> colInds, Tuple t){
    for (int i : colInds){
      Object value = t.values.get(i);
      if (valor == null){
        return true;
      }
    }
    return false;
  }

  public boolean checkDuplicates(ArrayList<Integer> colInds){
    int i = 0;
    for (Tuple t : tuples){
      //Get values from tuples
      ArrayList<Object> vals = new ArrayList<Object>();
      for (int j : colInds){
        Object v = t.values.get(j);
        vals.add(v);
      }

      //Check for Duplicates
      boolean dup = isDuplicate(vals, colInds, i);
      if (dup){
        return true;
      }
      i++;
    }
    return false;
  }

  public boolean isDuplicate(Object val, int colInd){
    int dups = 0;
    for (Tuple t : tuples){
      Object v= t.values.get(colInd);

      //Integer...
      if (v instance of Integer){
        int v2 = (Integer) v;
        int v3 = (Integer) val;
        if (v2 == v3){
          dups++;
        }
      }

      //Float...
      if (v instance of Float){
        float v2 = (Float) v;
        float v3 = (Float) val;
        if (v2 == v3){
          dups++;
        }
      }

      //Strings
      if (v instance of String){
        String v2 = (String) v.toString();
        String v3 = (String) val.toString();
        if (v2.equals(v3)){
          dups++;
        }
      }

      //Dates...
      if (v instance of LocalDateTime){
        LocalDate v2 = (LocalDate) v;
        LocalDate v3 = (LocalDate) val;
        if (v2.equals(v3)){
          dups++;
        }
      }
    }
    if (dups > 1){
      return true;
    }
    else{
      return false;
    }
  }

  public boolean containsPKWithColumn(Column col){
    
  }


}
