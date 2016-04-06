/**********************
Derek Olsson 13207
Jeancarlo Barrios 14652

Database Project 1
**********************/

/*
DBMSMetaData
*/

//package database;

import java.util.ArrayList;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.Writer;


public class DBMSMetaData implements Serializable{

  ArrayList<DBMetaData> dbmd;

  public DBMSMetaData(){
    dbmd = new ArrayList<DBMetaData>();
  }

  //Return all tables from matching database
  public ArrayList<String> allTables(String s){
    ArrayList<String> results = new ArrayList<String>();
    for (DBMetaData d : dbmd){
      if(d.nameDB.equals(s)){
        results = d.allTables();
        break;
      }
    }
    return results;
  }

  public void writeMetaData(){
    Writer writer = null;
    String currentDir = System.getProperty("user.dir");
    //Erase old md
    try{
      PrintWriter writer1 = new PrintWriter(new OutputStreamWriter(
      new FileOutputStream(currentDir + "/DBMS/master.dat"),"utf-8"));

      writer1.print("");
      writer1.close();

      //write new md
      writer = new BufferedWriter(new OutputStreamWriter(
      new FileOutputStream(currentDir + "/DBMS/master.dat"), "utf-8"));

      writer.write(this.toString());
    }

    catch(IOException e){
      System.out.println("ERROR: writeMetaData failed");
    }

    finally{
      try {
        writer.close();
      }
      catch(Exception ex){
        //NADA
      }
    }

    //recursive call for each db
    for (DBMetaData d : dbmd){
      d.writeMetaData();
    }
  }

  public DBMetaData getDB(String s){
    for (DBMetaData d : dbmd){
      if (d.nameDB.equalsIgnoreCase(s)){
        return d;
      }
    }
    return null;
  }

  //Name of each DB and # of tables each has
  @Override
  public String toString(){
    String s = "MASTER \n\r";
    for (DBMetaData d: dbmd){
      s += "DB Name:     " + d.nameDB + "\n\r";
      s += "No. Tables:  " + d.tables.size() + "\n\r";
    }
    return s;
  }

}
