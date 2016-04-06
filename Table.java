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

  public boolean containsValue(ArrayList<Object> values, ArrayList<Integer> colInds){
    for(Tuple t : tuples){
      for (int i = 0; i <values.size() ; i++){
        Object v = t.values.get(colInd);
        int colInd =  colInds.get(i);
        Object val = t.values.get(colInd);
        //Integers
        if (val instanceof Integer){
          int val2 = (Integer) val;
          int val3 = (Integer) v;
          if (val2 == val3){
            return true;
          }
        }

        //Floats
        else if (val instanceof Float){
          float val2 = (Float) val;
          float val3 = (Float) v;
          if (val2 == val3){
            return true;
          }
        }

        //Strings
        else if (val instanceof String){
          String val2 = (String) val.toString();
          String val3 = (String) v.toString();
          if (val2.equals(val3)){
            return true;
          }
        }

        //Dates
        else if (val instance of LocalDateTime){
          LocalDate val2 = (LocalDate) val;
          LocalDate val3 = (LocalDate) v;
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


  public boolean isDuplicate(ArrayList<Object> vals, ArrayList<Integer> colInds, int exceptIndex){
  int count =0;
  int index =0;
  for(Tuple t:this.tuples){
      if(index==exceptIndex){
          index++;
          continue;

      }
      boolean result = true;
      for(int i =0;i<vals.size();i++){
          Object v1 = vals.get(i);
          int colInd = colInds.get(i);
          Object v2 = t.values.get(colInd);
          if(v2 instanceof Integer){
              int v2c = (Integer) v2;
              int valorc = (Integer) v1;
              if(v2c!=valorc){
                  result = false;
                  break;
              }
           }
           else if( v2 instanceof Float){
               if(v2 instanceof Float){
                   float v2c = (Float) v2;
                   float valorc = (Float) v1;
                   if(v2c != valorc){
                       result = false;
                       break;
                   }

               }
           }

           else if (v2 instanceof String){
               String v2c = (String) v2.toString();
               String valorc = v1.toString();
               if(!v2c.equals(valorc)){
                   result = false;
                   break;
               }

           }

           else if(v2 instanceof LocalDateTime){
               LocalDate v2c = (LocalDate) v2;
               LocalDate valorc = (LocalDate) v1;
               if(!v2c.equals(valorc)){
                   result = false;
                   break;
               }

           }
      }
      if(result){
          count++;
          result =  true;
      }

      index++;
    }
    if(count>=1){
        return true;
    }
    else{
      return false;
    }

  }


  public boolean isDuplicate(ArrayList<Object> vals, ArrayList<Integer> iColumnas){
        int ocurrencias =0;
        for(Tupla t:this.tuplas){
            boolean result = true;
            for(int i =0;i<vals.size();i++){
                Object v1 = vals.get(i);
                int colInd = iColumnas.get(i);
                Object v2 = t.values.get(colInd);
                if(v2 instanceof Integer){
                    int v2c = (Integer) v2;
                    int valorc = (Integer) v1;
                    if(v2c!=valorc){
                        result = false;
                        break;
                    }
                 }
                 else if( v2 instanceof Float){
                     if(v2 instanceof Float){
                         float v2c = (Float) v2;
                         float valorc = (Float) v1;
                         if(v2c != valorc){
                             result = false;
                             break;
                         }

                     }
                 }

                 else if (v2 instanceof String){
                     String v2c = (String) v2.toString();
                     String valorc = v1.toString();
                     if(!v2c.equals(valorc)){
                         result = false;
                         break;
                     }

                 }

                 else if(v2 instanceof LocalDateTime){
                     LocalDate v2c = (LocalDate) v2;
                     LocalDate valorc = (LocalDate) v1;
                     if(!v2c.equals(valorc)){
                         result = false;
                         break;
                     }

                 }
            }
            if(result){
                ocurrencias++;
                result =  true;
            }


        }
        if(ocurrencias>=2){
            return true;
        }
        else{return false;}

    }


  public Constraint containsPKWithColumn(Column col){
    for (Constraint c : constraints){
      if (c.type == Constraint.PK){
        for (Column col1 : c.columnPKs){
          if (col1.name.equalsIgnoreCase(col.name)){
            return c;
          }
        }
      }
    }
    return null;
  }

  public void updateTuple(ArrayList<Object> vals, ArrayList<Integer> colInds, int noTuple){
    ArrayList<Object> oldValues = tuples.get(noTuple).values;
    for (int i; i < colInds.size() ; i++){
      int currentInd = colInds.get(i);
      Object currentVal = values.get(i);
      oldValues.set(currentInd, currentVal);
    }
  }


}
