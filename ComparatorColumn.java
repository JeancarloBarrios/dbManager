/**********************
Derek Olsson 13207
Jeancarlo Barrios 14652

Database Project 1
**********************/

/*
Metodos para ordenar columnas
*/


//package database;

import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;


public class ComparatorColumn {

  Table table;
  ArrayList<Orders> orderBy;
  ArrayList<Tuple> toSort;
  int indexCol;
  int typeToSort;
  ArrayList<ArrayList<Integer>> indexOfSame;
  ArrayList<ArrayList<Tuple>> myTuples;


  public ComparatorColumn(Table t, ArrayList<Orders> o){
    table = t;
    orderBy = o;
    indexOfSame = new ArrayList();
    myTuples = new ArrayList();
    toSort  = new ArrayList();
  }


//Ordenar columnas de manera ascendente
  public void order(){
    //Copiar a una tabla nueva
    Tabla tempTable = table;
    toSort = tempTable.tuples;
    int min = 0;
    int max = toSort.size() - 1;

    String currentColumn = orderBy.get(0).column;
    String orderDir = orderBy.get(0).order;

    indexColumn = tempTable.getIndexColumn(currentColumn);
    typeToSort = tempTable.columns.get(indexColumn).type;
    quickSortTuple(toSort,min,max);

  //Si esta de manera descendente, solo hacer un reverse
    if (orderDir.equals("DESC")){
      Collections.reverse(toSort);
    }

  //Revisar otras maneras de sort
    if(orderBy.size() > 1){
      for(int i = 1; i < orderBy.size(); i++){
        findRepetitions(toSort);
        buildRepeatTable();
        currentColumn = orderBy.get(i).column;
        orderDir = orderBy.get(i).order;
        indexColumn = tempTable.getIndexColumn(currentColumn);
        typeToSort = tempTable.columns.get(indexColumn).tipo;

        for(ArrayList<Tuple> tt: myTuples){
          int mindex = 0;
          int maxdex = tt.size()-1;
          quickSortTuple(tt,mindex,maxdex);
          if(orderDir.equals("DESC")){
            Collections.reverse(tt);
          }

          //poner tt en toSort
          for(int j = 0; j < tt.size(); j++){
            int upNext = indexOfSame.get(0).get(j);
            toSort.set(upNext, tt.get(j));
          }
          //quitar de indexOfSame
          indexOfSame.remove(0);
        }
        indexOfSame = new ArrayList();
      }
    }
    table.tuples = new ArrayList();
    table.tuples.addAll(toSort);
  }

  public void findRepetitions(ArrayList<Tuple> toSearch){
    if(indexOfSame != null){
      indexOfSame = new ArrayList();
    }
    ArrayList<Integer> temp = new ArrayList();
    for (int i = 0; i<toSearch.size()-1; i++){
      Tuple compare1 = toSearch.get(i);
      Tuple compare2 = toSearch.get(i+1);
      int resultVal = getNewOrder(typeToSort, compare1, compare2, indexColumn, "ASC");

      if (resultVal == 0){
        temp.add(i);
        temp.add(i+1);
      }

      else{
        if(temp.size()!=0){
          indexOfSame.add(temp);
          temp = new ArrayList();
          }
      }
    }
    if(!temp.isEmpty()){
      indexOfSame.add(temp);
    }
  }

  public void buildRepeatTable(){

        //Correr lista de repeticiones
        for(ArrayList<Integer> arrI : indexOfSame){
            ArrayList<Tuple> temp = new ArrayList();
            for(int num : arrI){
                temp.add(toSort.get(num));
            }
            myTuples.add(temp);
        }
    }


    //Realizar quicksort sobre tuple entre i y j
    public void quickSortTuple(ArrayList<Tuple> toSort, int i, int j){

        if(toSort == null || toSort.size() == 0){
            return;
        }

        if(i >= j){
            return;
        }

        int indexLow = i;
        int indexHigh = j;
        int pivotIndex = IndexLow+(IndexHigh-IndexLow)/2;
        Tuple pivot = toSort.get(pivotIndex);
        while(IndexLow <= IndexHigh){

            while(getNewOrder(typeToSort, toSort.get(IndexLow), pivot, indexColumn,"ASC") > 0){
                IndexLow++;
            }

            while(getNewOrder(typeToSort, pivot, toSort.get(IndexHigh), indexColumn,"ASC")>0){
                IndexHigh--;
            }
            if(IndexLow<= IndexHigh){
                Tuple temp = toSort.get(IndexLow);
                toSort.set(IndexLow, toSort.get(IndexHigh));
                toSort.set(IndexHigh, temp);
                IndexLow++;
                IndexHigh--;
            }
        }
        if(i < IndexHigh){
            quickSortTuple(toSort, i, IndexHigh);
        }
        if(j > IndexLow){
            quickSortTuple(toSort, IndexLow,j);
        }
    }


    //metodo de apoyo del quickSortTuple
    //1 es t1 primero
    //-1 es t2 primero
    //0 si son iguales
    public int getNewOrder(int typeToCompare, Tuple t1, Tuple t2, int columnWorked, String orderType){
        switch(typeToCompare){
            case(0):
                Integer compare1 = (Integer) t1.values.get(columnWorked);
                Integer compare2 = (Integer) t2.values.get(columnWorked);
                if(compare1 == null && compare2!=null)
                {
                    if(orderType.equals("ASC")){
                        return 1;
                    }
                    else if(orderType.equals("DESC")){
                        return -1;
                    }
                }
                else if(compare2 == null && compare1 != null){
                    if(orderType.equals("ASC")){
                        return -1;
                    }
                    else if(orderType.equals("DESC")){
                        return 1;
                    }
                }
                else if(compare2==null && compare1 == null){
                    return 0;
                }
                int result = compare1 - compare2;
                if (orderType.equals("ASC")){
                    if(result > 0){
                        return -1;
                    }
                    else if(result < 0){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else if(orderType.equals("DESC")){
                    if(result < 0){
                        return -1;
                    }
                    else if(result > 0){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                break;
            case (1):
                Float compareF1 = (Float) t1.values.get(columnWorked);
                Float compareF2 = (Float) t2.values.get(columnWorked);
                if(compareF1 == null && compareF2!=null)
                {
                    if(orderType.equals("ASC")){
                        return 1;
                    }
                    else if(orderType.equals("DESC")){
                        return -1;
                    }
                }
                else if(compareF2 == null && compareF1 != null){
                    if(orderType.equals("ASC")){
                        return -1;
                    }
                    else if(orderType.equals("DESC")){
                        return 1;
                    }
                }
                else if(compareF2==null && compareF1 == null){
                    return 0;
                }
                float resultF = compareF1 - compareF2;
                if (orderType.equals("ASC")){
                    if(resultF > 0){
                        return -1;
                    }
                    else if(resultF < 0){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else if(orderType.equals("DESC")){
                    if(resultF < 0){
                        return -1;
                    }
                    else if(resultF > 0){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                break;
            case (2):
                String compareS1 = (String) t1.values.get(columnWorked);
                String compareS2 = (String) t2.values.get(columnWorked);
                if(compareS1 == null && compareS2!=null)
                {
                    if(orderType.equals("ASC")){
                        return 1;
                    }
                    else if(orderType.equals("DESC")){
                        return -1;
                    }
                }
                else if(compareS2 == null && compareS1 != null){
                    if(orderType.equals("ASC")){
                        return -1;
                    }
                    else if(orderType.equals("DESC")){
                        return 1;
                    }
                }
                else if(compareS2==null && compareS1 == null){
                    return 0;
                }
                int resultS = compareS1.compareTo(compareS2);
                if (orderType.equals("ASC")){
                    if(resultS > 0){
                        return -1;
                    }
                    else if(resultS < 0){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else if(orderType.equals("DESC")){
                    if(resultS < 0){
                        return -1;
                    }
                    else if(resultS > 0){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                break;
            case(3):
                LocalDate compareD1 = (LocalDate) t1.values.get(columnWorked);
                LocalDate compareD2 = (LocalDate) t2.values.get(columnWorked);
                if(compareD1 == null && compareD2!=null)
                {
                    if(orderType.equals("ASC")){
                        return 1;
                    }
                    else if(orderType.equals("DESC")){
                        return -1;
                    }
                }
                else if(compareD2 == null && compareD1 != null){
                    if(orderType.equals("ASC")){
                        return -1;
                    }
                    else if(orderType.equals("DESC")){
                        return 1;
                    }
                }
                else if(compareD2==null && compareD1 == null){
                    return 0;
                }
                int resultD = compareD1.compareTo(compareD2);
                if (orderType.equals("ASC")){
                    if(resultD > 0){
                        return -1;
                    }
                    else if(resultD < 0){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else if(orderType.equals("DESC")){
                    if(resultD < 0){
                        return -1;
                    }
                    else if(resultD > 0){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                break;
            default:
                break;
        }
        return 12321;
    }
}
