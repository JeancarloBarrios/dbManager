/**********************
Derek Olsson 13207
Jeancarlo Barrios 14652

Database Project 1
**********************/

/*
Creacion y manejo de bases de Datos
*/
//package database;

import java.util.ArrayList;

import java.awt.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

public class DB{
  String name;
  ArrayList<Table> tables;
  String dir;

  public DB(String s) throws Exception{
    name = s;
    tables = new ArrayList<Table>();

    //crear nuevo db en carpeta del mismo nombre
    String currentDir = System.getProperty("user.dir");
    System.out.println(currentDir);
    dir = currentDir + "/DBMS/" + s;
    File directory = new File(dir);
    dir += "/";

    //si dir no existe
    if (!directory.exists()){
      boolean success = false;
      Debug.add("Creating new directory " + s + "...\n");

      try{
        directory.mkdir();
        success = true;

        //Actualizar DBMD
        DBMetaData dbmd = new DBMetaData(name);
        //Agregarlo al DBMS
        DBMS.metaData.dbs.add(dbmd);
        DBMS.guardar();
        //write DBMS otra vez
        DBMS.metaData.writeMetaData();

        Debug.add("Updating metadata... \n");
      }

      catch(SecurityException secExc){
        System.out.println("ERROR: You do not have permissions to create the directory  " + s);
        if (!Frame.activateVerbose){
          Frame.jTextArea2.setText("ERROR: You do not have permissions to create the directory " + s);
        }
      }
      if (success){
        Debug.add("Directory successfully created at " + directory.getAbsolutePath());
      }
    }

    //Si ya existe....
    else{
      throw new Exception("ERROR: Database " + s + " already exists...");
    }
  }

  public boolean dropDB(String nombre){
    String currentDir = System.getProperty("user.dir");
    File directory  = new File(currentDir+"/DBMS/"+name);
    boolean exists = directorio.exists();
    if(exists){
      Debug.add("Searching database...");
      DBMetaData db = DBMS.metaData.getDB(nombre);

      //if it not empty
      if (db != null){
        //get # records
        int records = countRecords(nombre);
        //verify
        int input = JOptionPane.showConfirmDialog((Component) null,
         "Delete database " + nombre + " with " + records + " records?",
         "alert", JOptionPane.OK_CANCEL_OPTION);

        //If yes
        if (input == JOptionPane.OK_OPTION){
          //Do eeeet
          Debug.add("Dropping DB....");
          deleteFolder(directory);
          //Update metadata
          Debug.add("Updating metadata...");
          DBMS.metaData.dbs.remove(db);
          DBMS.save();
          DBMS.metaData.writeMetaData();

          Debug.add("Database dropped.");
          if(!Frame.activateVerbose){
            Frame.jTextArea2.setText("Database " + nombre + " dropped.");
          }
        }
      }
      else {
        Frame.jTextArea2.setText("ERROR: MetaData not found....");
      }
      return true;
    }

    else {
      return false;
    }
  }

  public static boolean renameDB(String oldName, String newName){
    //find db metadata
    DBMetaData db =DBMS.metaData.getDB(oldName);
    if (db != null){
      db.nameDB = oldName;
      if (Frame.activateVerbose){
        Debug.add( "Renaming folder...");
      }
      renameFolder(oldName, newName);
      //Fix .dat file
      String currentDir = System.getProperty("user.dir");
      File directory = new File(currentDir+"/DBMS/"+newName+"/"+oldName+".dat");
      directory.delete();
      DBMS.guardar();

      Debug.add("Rewriting metadata....");
      DBMS.metaData.writeMetaData();

      Debug.add(oldName + " renamed to " + newName +".");

      if (!Frame.activateVerbose){
        Frame.jTextArea2.setText("" + oldName + " renamed to " + newName + ".");
      }

      return true;
    }

    //If cant find it, throw ERROR
    else{
      Debug.add("ERROR: No metadata found for " + oldName);
      if (!Frame.activateVerbose){
        Frame.jTextArea2.setText("ERROR: No metadata found for " + oldName);
      }
    }
  }

  private static boolean renameFolder(String oldName, String newName){
    String currentDir = System.getProperty("user.dir");
    File directory = new File(currentDir + "/DBMS/" + oldName);

    if (directory.exists()){
      File f = new File(currentDir + "/DBMS/" + newName);
      directory.renameTo(f);
      return true;
    }

    else{
      return false;
    }
  }

  private static void deleteFolder(File f){
    File[] files = folder.listFiles();
    if (files != null){
      for (File f2 : files){
        if (f2.isDirectory()){
          deleteFolder(f2);
        }
        else{
          f2.delete();
        }
      }
    }
    f.delete();
  }

  private static int countRecords(DBMetaData dbmd){
    int count = 0;
    for (TableMetaData t: dbmd.tables){
      count += t.numRecords;
    }
    return count;
  }

  public String toString(){
    String s =  " DB: " + name;
    s += "\n TABLES: \n";
    for (int i;  i < tables.size(); i++){
      //Nombre tabla
      s += "\n   " + tables.get(i) + "\n";
      //Datos tabla
      s += tables.get(i).toString();
    }
    return s;
  }

}
