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
      cmd.add(new ColumnMetaData(c.name, c.getTypeString(c.type)));
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
      else if (val instanceof LocalDateTime){
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
        else if (val instanceof LocalDateTime){
          LocalDate val2 = (LocalDate) val;
          LocalDate val3 = (LocalDate) v;
          if (val2.equals(val3)){
            return true;
          }
        }
      }
    return false;
    }
  }


  //Recursive to find null values
  public boolean hasNullValues(ArrayList<Integer> colInds){
    for (Tuple t : tuples){
      if (hasNullValues(colInds, t)){
        return true;
      }
    }
    return false;
  }

  public boolean hasNullValues(ArrayList<Integer> colInds, Tuple t){
    for (int i : colInds){
      Object value = t.values.get(i);
      if (value == null){
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
      if (v instanceof Integer){
        int v2 = (Integer) v;
        int v3 = (Integer) val;
        if (v2 == v3){
          dups++;
        }
      }

      //Float...
      if (v instanceof Float){
        float v2 = (Float) v;
        float v3 = (Float) val;
        if (v2 == v3){
          dups++;
        }
      }

      //Strings
      if (v instanceof String){
        String v2 = (String) v.toString();
        String v3 = (String) val.toString();
        if (v2.equals(v3)){
          dups++;
        }
      }

      //Dates...
      if (v instanceof LocalDateTime){
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
          else if (v2 instanceof Float){
            float v2c = (Float) v2;
            float valorc = (Float) v1;
            if(v2c != valorc){
              result = false;
              break;
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


  public boolean isDuplicate(ArrayList<Object> vals, ArrayList<Integer> colInds){
        int count =0;
        for(Tuple t:this.tuples){
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


        }
        if(count>=2){
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

  public int getColumnIndex(String colName){
    int i = 0;
    boolean b = false;
    for (Column c : this.columns){
      if (c.name.equalsIgnoreCase(colName)){
        f = true;
        break;
      }
      i++;
    }
    if (b){
      return i;
    }
    else{
      return -1;
    }
  }

  public void saveTable(){
    //Serialize Table....
    String currentDir = System.getProperty("user.dir");
    FileOutputStream fileOut;
    try {
      fileOut = new FileOutputStream(currentDir+"/DBMS/"+DBMS.currentDB+"/"+name+".ser");
      ObjectOutputStream out;
      out = new ObjectOutputStream(fileOut);
      out.writeObject(this);
      out.close();
      }
    catch (Exception ex) {
      Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
    }

    //Then columns....
    try {
      fileOut = new FileOutputStream(currentDir+"/DBMS/"+DBMS.currentDB+"/"+name+"_cols.ser");
      ObjectOutputStream out;
      out = new ObjectOutputStream(fileOut);
      out.writeObject(this.columns);
      out.close();
    }
    catch (Exception ex) {
      Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
    }

    //then constraints....
    try {
      fileOut = new FileOutputStream(currentDir+"/DBMS/"+DBMS.currentDB+"/"+name+"_constraints.ser");
      ObjectOutputStream out;
      out = new ObjectOutputStream(fileOut);
      out.writeObject(this.constraints);
      out.close();
    }
    catch (Exception ex) {
      Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public static Table loadTable(String tableName){
    String currentDir = System.getProperty("user.dir");
    File f = new File(currentDir + "/DBMS/" + DBMS.currentDB + "/" + tableName + ".ser");
    if (f.exists() && !f.isDirectory()){
      try{
        FileInputStream fileIn = new FileInputStream(currentDir + "/DBMS/" + DBMS.currentDB + "/" + tableName + ".ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Table result = (Table) in.readObject();
        in.close();
        fileIn.close();
        return result;
      }
      catch(Exception e){
        i.printStackTrace();
        return null;
      }
    }

    else{
      return null;
    }
  }

  public void deleteOldFilesWithName(String oldName){
    String currentDir = System.getProperty("user.dir");
    //Tag em...
    File dir = new File(currentDir + "/DBMS/" + DBMS.currentDB + "/" + oldName + ".ser");
    if (dir.exists()){
      File f1  = new File(currentDir+"/DBMS/"+DBMS.currentDB+"/"+oldName+"_constraints.ser");
      File f2  = new File(currentDir+"/DBMS/"+DBMS.currentDB+"/"+oldName+"_cols.ser");
      //And bag em
      f1.delete();
      f2.delete();
      dir.delete();
    }
  }

  public void renameTo(String newName){
    //change name
    String oldName = this.name;
    this.name = newName;

    //update columns and constraints
    for (Column c : this.columns){
      c.table = newName;
    }
    for (Constraint con : constraints){
      con.table = newName;
    }

    //get rid of old name for good
    this.deleteOldFilesWithName(oldName);
    this.saveTable();
  }


  public void dropConstraint(String constraintName){
    int i=0;
    boolean b = false;
    for (Constraint con : this.constraints){
      if (con.name.equalsIgnoreCase(constraintName)){
        b = true;
        break;
      }
      i++;
    }

    if(b){
      this.constraints.remove(i);
    }

    //Fix metadeta
    DBMetaData d = DBMS.metaData.getDB(DBMS.currentDB);
    TableMetaData t = d.getTable(this.name);

    i=0;
    b = false;

    for (ConstraintMetaData cmd : t.constraints){
      if (cmd.name.equalsIgnoreCase(constraintName)){
        b=true;
        break;
      }
      i++;
    }
    if (f){
      t.constraints.remove(i);
    }
  }

  public void dropColumn(Column col){
    int i =0;
    boolean b = false;
    for(Column c: this.columns){
    //Find and remove column, saving index
      if(c.name.equalsIgnoreCase(col.name) && c.table.equalsIgnoreCase(col.table)){
        b = true;
        break;
      }
      i++;
    }

    if(b){
      this.columns.remove(i);
    }


    //Remove tuples at index
    for(Tuple t: this.tuples){
            t.values.remove(i);
    }

    //Delete any primary key
    String n=" ";
    for(Constraint constr: this.constraints){
      for(Column colCons: constr.columnPKs){
        if(colCons.name.equalsIgnoreCase(col.name)){
            n = constr.name;
            break;
        }
      }
    }
    dropConstraint(n);

    //Fix metadata
    DBMetaData d = DBMS.metaData.getDB(DBMS.currentDB);
    TablaMetaData t = d.getTable(this.name);
    i =0;
    b = false;
    for(ColumnMetaData cm: t.columns){
      if(cm.name.equalsIgnoreCase(col.name)){
        b = true;
        break;
      }
      i++;
    }

    if(b){
      t.columns.remove(i);
    }

  }


  public static ArrayList<Column> loadColumns(String tableName){

    String currentDir = System.getProperty("user.dir");
    File f = new File(currentDir+"/DBMS/"+DBMS.currentDB+"/"+tableName+"_cols.ser");
    if (f.exists() && !f.isDirectory()) {

      //Deserialize
      try{
        FileInputStream fileIn = new FileInputStream(currentDir+"/DBMS/"+DBMS.currentDB+"/"+tableName+"_cols.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ArrayList<Column> ret = (ArrayList<Column>) in.readObject();

        in.close();
        fileIn.close();
        return ret;
      }
      catch(Exception e){
        e.printStackTrace();
        return null;
      }
    }

    else{
      return null;
    }

  }

  public static ArrayList<Constraint> loadConstraints(String tableName){
    String currentDir = System.getProperty("user.dir");
    File f = new File(currentDir+"/DBMS/"+DBMS.currentDB+"/"+tableName+"_constraints.ser");
    if(f.exists() && !f.isDirectory()) {

      //Deserializing
      try{
        FileInputStream fileIn = new FileInputStream(currentDir+"/DBMS/"+DBMS.currentDB+"/"+tableName+"_constraints.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ArrayList<Constraint> ret = (ArrayList<Constraint>) in.readObject();
        in.close();
        fileIn.close();
        return ret;
      }
      catch(Exception e){
        e.printStackTrace();
        return null;
      }
    }
    else{
      return null;
    }
  }

  public Table(String n, ArrayList<Column> cols, ArrayList<Constraint> cons){
    this.name = n;
    columns = cols;
    constraints = cons;
    this.tuples = new ArrayList<Tuple>();

    //Create Metadata
    //First columns....
    ArrayList<ColumnMetaData> mcols = new ArrayList<ColumnMetaData>();
    for(Column c: columns){
      mcols.add(new ColumnMetaData(c.name,c.getStringType(c.tipo)));
    }

    //Then constraints
    ArrayList<ConstraintMetaData> mcons = new ArrayList<ConstraintMetaData>();
    for(Constraint c: constraints){
      mcons.add(new ConstraintMetaData(c.name,c.getStringType(c.tipo),c.toString()));
    }

    //Finally constraints
    TablaMetaData t = new TablaMetaData(name,mcols,mcons);
    DBMetaData d = DBMS.metaData.findDB(DBMS.currentDB);
    d.tables.add(t);
    DBMS.save();
    DBMS.metaData.writeMetadata();
    saveTable();
  }



}
