/**********************
Derek Olsson 13207
Jeancarlo Barrios 14652

Database Project 1
**********************/

/*
MetaData de tablas
*/

import java.io.Serializable;

import java.util.ArrayList;

public class TableMetaData implements Serializable{
    String name;
    int numRecords;
    ArrayList<ColumnMetaData> columns;
    ArrayList<ConstraintMetaData> constraints;

    public TableMetaData(String s,ArrayList<ColumnMetaData>cols, ArrayList<ConstraintMetaData> cons){
        name = s;
        numRecords =0;
        columns = cols;
        constraints= cons;

    }

    public String toString(){
        String s ="TABLA: "+name+" \n\r";
        s+="CANTIDAD DE REGISTROS: "+numRecords+"\n\r";
        for(ColumnMetaData s1: columns){
            s+= s1.toString()+",  ";
        }
        s+="\n\r";
        s+="CONSTRAINTS: \n\r";
        for(ConstraintMetaData s2:constraints){

            s+=s2.toString()+" \n\r ";
        }
        s+="\n\r";
        return s;
    }

}
