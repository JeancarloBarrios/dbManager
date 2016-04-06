/**********************
Derek Olsson 13207
Jeancarlo Barrios 14652

Database Project 1
**********************/

/*
Iteradora para correr las tablas
*/

//package database;


public class TableIterator {

    int currentInd;
    Table table;

    public TableIterator(Table t, int i){
        table = t;
        currentInd =i;

    }
    // Regresar todos los valores del indice actual
    public ArrayList<Object> getValues(){
        return table.tuples.get(currentInd).values;
    }

    // Regresar valor de columna en indice especifico
    public Object getValueFromColumn(int colInd){
        if(table.tuples.isEmpty()){
          return null;
        }

        return table.tuples.get(currentInd).values.get(colInd);
    }

    //Borrar valor actual
    public void deleteValue(){
        table.tuples.remove(currentInd);
    }

    //Incrementar currentInd
    public void next(){
        currentInd++;
    }

}
