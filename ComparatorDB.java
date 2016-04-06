/**********************
Derek Olsson 13207
Jeancarlo Barrios 14652

Database Project 1
**********************/

/*
Metodos para ordenar base de datos
*/


//package database;

import java.time.LocalDate;


public class ComparatorDB {
    int typeToCompare;
    Tuple t1;
    Tuple t2;
    int columnWorked;
    String orderType;

    public ComparatorDB(int type, Tuple t1, Tuple t2, int c, String s){
        typeToCompare = type;
        this.t1 = t1;
        this.t2 = t2;
        columnWorked = c;
        orderType = s;
    }

    //1 es t1 primero
    //-1 es t2 primero
    //0 si son iguales
    public int getNewOrder(){
        switch(typeToCompare){
            case(0):
                int compare1 = (int) t1.values.get(columnWorked);
                int compare2 = (int) t2.values.get(columnWorked);
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
                float compareF1 = (float) t1.values.get(columnWorked);
                float compareF2 = (float) t2.values.get(columnWorked);
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
