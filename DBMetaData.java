/**********************
Derek Olsson 13207
Jeancarlo Barrios 14652

Database Project 1
**********************/

/*
DBMetaData
*/

//package database;

import java.util.ArrayList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.Writer;

public class DBMetaData implements Serializable{
  String nameDB;
  public ArrayList<TableMetaData> tables;

  public DBMetaData(String s){
    nameDB = s;
    tables = new ArrayList<TableMetaData>();
  }

  public ArrayList<String> allTables(){
    ArrayList<String> results = new ArrayList<String>();
    for (TableMetaData t : tables){
      results.add(t.name);
    }
    return results;
  }

  public void writeMetaData(){
    Writer writer = null;
    String currentDir = System.getProperty("user.dir");

    try{
      //Erase old...
      PrintWriter writer1 = new PrintWriter(new OutputStreamWriter(
      new FileOutputStream(currentDir + "/DBMS/" + nameDB + "/" +
      nameDB + ".dat"), "utf-8"));

      writer1.print("");
      writer1.close();

      //Write new....
      writer = new BufferedWriter(new OutputStreamWriter(
      new FileOutputStream(currentDir + "/DBMS/" + nameDB + "/" +
      nameDB + ".dat"), "utf-8"));

      String out = this.toString() + "\n\r";
      for (TableMetaData t : tables){
        out += t.toString();
      }

      writer.write(out);
    }
    catch(IOException e){
        System.out.println("ERROR: writeMetaData in DBMetaData failed...");
    }
    finally{
      try{
        writer.close();
      }
      catch(Exception ex){
        //NADA
      }
    }
  }

  public TableMetaData getTable(String s){
    for (TableMetaData t : this.tables){
      if (t.name.equalsIgnoreCase(s)){
        return t;
      }
    }
    return null;
  }

  @Override
  public String toString(){
    String s = "DATABASE: " + nameDB + "\n\r";
    s+="No. Tables: "+tables.size()+"\n\r";
    return s;
  }

}
