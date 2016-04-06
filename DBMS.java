/**********************
Derek Olsson 13207
Jeancarlo Barrios 14652

Database Project 1
**********************/

/*
DBMS upper functions
*/

//package database;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


public class DBMS{
  static String currentDB;
  static DBMSMetaData metaData;

  public DBMS(){

    String currentDir = System.getProperty("user.dir");
    File f = new File(currentDir+"/DBMS/master.dat");

    //If file exists, load and set to static var
    if (f.exists() && !f.isDirectory()){
      try{
        FileInputStream fileIn = new FileInputStream(currentDir + "/DBMS/master.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);

        metaData = (DBMSMetaData) in.readObject();
        in.close();
        fileIn.close();
      }

      catch(Exception e){
        e.printStackTrace();
        return;
      }
    }

    //If it doesnt exist, create metadata and serialze
    else{
      FileInputStream fileIn;
      DBMSMetaData dbms = new DBMSMetaData();
      //write DBMSMetaData
      dbms.writeMetaData();
      metaData = dbms;

      //Serialize it
      try{
        FileOutputStream fileOut = new FileOutputStream(currentDir + "/DBMS/master.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(dbms);
      }

      catch(IOException e){
          Logger.getLogger(DBMS.class.getName()).log(level.SEVERE, null, e);
      }

    }
  }

  public static void save(){
    String currentDir = System.getProperty("user.dir");

      //Serialize
    try{
      FileOutputStream fileOut = new FileOutputStream(currentDir + "/DBMS/master.ser");
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(metaData);
    }

    catch(IOException e){
      Logger.getLogger(DBMS.class.getName()).log(level.SEVERE, null, e);
    }
  }

  public void executeQuery(String s){
    JDSQLLexer lexer = new JDSQLLexer(new ANTLRInputStream(s));
    lexer.removeErrorListeners();

    TokenStream tokenStream = new CommonTokenStream(lexer);
    JDSQLParser parser = new JDSQLParser(tokenStream);
    parser.removeErrorListeners();

    ParseTree tree = parser.query();
    Loader loader = new Loader(this);
    loader.visit(tree);
  }

}
