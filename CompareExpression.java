/**********************
Derek Olsson 13207
Jeancarlo Barrios 14652

Database Project 1
**********************/

/*
Realizar comparaciones
Validos:
  Entre mismo tipo
  Date y String
  Float y Int
*/


//package database;

import java.util.Date;
import java.io.Serializable;

public class CompareExpression extends Expression implements Serializable{
    String operation;
    Term left;
    Term right;

    public CompareExpression(Term l, Term r, String op){
        left = l;
        right = r;
        operation = op;

    }

    @Override
    public Boolean isTrue() throws Exception{

        switch(operation){
            //igual
            case "=":
                //caso null
                if(left.getValue()==null || right.getValue() == null){
                    return null;
                }
                //Enteros
                else if(left.getValue() instanceof Integer && right.getValue() instanceof Integer){
                    int intL = (int)left.getValue();
                    int intR = (int)right.getValue();
                    return intL==intR;
                }
                //Strings
                else if(left.getValue() instanceof String && right.getValue() instanceof String){
                    String l = (String) left.getValue();
                    String r = (String) right.getValue();
                    return l.equalsIgnoreCase(r);
                }
                //Float
                else if(left.getValue() instanceof Float && right.getValue() instanceof Float){
                    float l = (float) left.getValue();
                    float r = (float) right.getValue();
                    return l==r;
                }
                //Date
                else if(left.getValue() instanceof Date && right.getValue() instanceof Date){
                    Date l = (Date) left.getValue();
                    Date r= (Date) right.getValue();
                    int result = l.compareTo(r);
                    if(result ==0){
                      return true;
                    }
                    else{
                      return false;
                    }
                }
                //String = Date
                else if(left.getValue() instanceof String && right.getValue() instanceof Date){
                    String l = left.getValue().toString();
                    String r = right.getValue().toString();
                    if(l.equalsIgnoreCase(r)){
                        return true;
                    }
                    else{
                      return false;
                    }
                }
                //Date = String
                else if(left.getValue() instanceof Date && right.getValue() instanceof String){
                    String l = left.getValue().toString();
                    String r = right.getValue().toString();
                    if(l.equalsIgnoreCase(r)){
                        return true;
                    }
                    else{
                      return false;
                    }
                }
                //Float = Int
                else if(left.getValue() instanceof Float && right.getValue() instanceof Integer){
                    float l = (float)left.getValue();
                    int r = (int)right.getValue();
                    return l==r;
                }
                //Int = Float
                else if(left.getValue() instanceof Integer && right.getValue() instanceof Float){
                    int l = (int)left.getValue();
                    float r = (float)right.getValue();
                    return l==r;
                }
                //Otros que no sean comparables
                else{
                    String s="ERROR: Valores "+left.getValue().toString()+", "+right.getValue().toString()+" no son comparables.";
                    throw new Exception(s);
                }

            //no iguales
            case "<>":
                if(left.getValue()==null || right.getValue() == null){
                    return null;
                }


                if(left.getValue() instanceof Integer && right.getValue() instanceof Integer){
                    int l = (int)left.getValue();
                    int r = (int)right.getValue();
                    return l != r;
                }

                else if(left.getValue() instanceof String && right.getValue() instanceof String){
                    String l = (String) left.getValue();
                    String r = (String) right.getValue();
                    return !l.equalsIgnoreCase(r);
                }

                else if(left.getValue() instanceof Float && right.getValue() instanceof Float){
                    Float l = (Float) left.getValue();
                    Float r = (Float) right.getValue();
                    return l!=r;
                }

                else if(left.getValue() instanceof Date && right.getValue() instanceof Date){
                    Date l = (Date) left.getValue();
                    Date r= (Date) right.getValue();
                    int result = l.compareTo(r);
                    if(result !=0){
                      return true;
                    }
                    else{
                      return false;
                    }
                }

                else if(left.getValue() instanceof String && right.getValue() instanceof Date){
                    String l = left.getValue().toString();
                    String r = right.getValue().toString();
                    if(l.equalsIgnoreCase(r)){
                        return false;
                    }
                    else{
                      return true;
                    }
                }

                else if(left.getValue() instanceof Date && right.getValue() instanceof String){
                    String l = left.getValue().toString();
                    String r = right.getValue().toString();
                    if(l.equalsIgnoreCase(r)){
                        return false;
                    }
                    else{
                      return true;
                    }
                }

                else if(left.getValue() instanceof Float && right.getValue() instanceof Integer){
                    Float l = (Float)left.getValue();
                    int r = (int)right.getValue();
                    return l!=r;
                }

                else if(left.getValue() instanceof Integer && right.getValue() instanceof Float){
                    int l = (int)left.getValue();
                    Float r = (Float)right.getValue();
                    return l!=r;
                }

                else{
                    String s="ERROR: Valores "+left.getValue().toString()+", "+right.getValue().toString()+" no son comparables.";
                    throw new Exception(s);
                }

            //Mayor que
            case ">":

                if(left.getValue()==null || right.getValue() == null){
                    return null;
                }

                if(left.getValue() instanceof Integer && right.getValue() instanceof Integer){
                    int l = (int)left.getValue();
                    int r = (int)right.getValue();
                    return l>r;
                }

                else if(left.getValue() instanceof String && right.getValue() instanceof String){
                    String l = (String) left.getValue();
                    String r = (String) right.getValue();
                    int compare = l.compareToIgnoreCase(r);
                    if(compare>0){
                      return true;
                    }
                    else{
                      return false;
                    }
                }

                else if(left.getValue() instanceof Float && right.getValue() instanceof Float){
                    Float l = (Float) left.getValue();
                    Float r = (Float) right.getValue();
                    return l>r;
                }

                else if(left.getValue() instanceof Date && right.getValue() instanceof Date){
                    Date l = (Date) left.getValue();
                    Date r= (Date) right.getValue();
                    int compare = l.compareTo(r);
                    if(compare >0){
                      return true;
                    }
                    else{
                      return false;
                    }
                }

               else if(left.getValue() instanceof String && right.getValue() instanceof Date){
                    String l = left.getValue().toString();
                    String r = right.getValue().toString();
                    int compare = l.compareToIgnoreCase(r);
                    if(compare>0){
                        return true;
                    }
                    else{
                      return false;
                    }
                }

                else if(left.getValue() instanceof Date && right.getValue() instanceof String){
                    String l = left.getValue().toString();
                    String r = right.getValue().toString();
                    int compare = l.compareToIgnoreCase(r);
                    if(compare>0){
                        return true;
                    }
                    else{
                      return false;
                    }
                }

                else if(left.getValue() instanceof Float && right.getValue() instanceof Integer){
                    float l = (float)left.getValue();
                    int r = (int)right.getValue();
                    return l>r;
                }

                else if(left.getValue() instanceof Integer && right.getValue() instanceof Float){
                    int l = (int)left.getValue();
                    Float r = (Float)right.getValue();
                    return l>r;
                }

                else{
                    String s="ERROR: Valores "+left.getValue().toString()+", "+right.getValue().toString()+" no son comparables.";
                    throw new Exception(s);
                }


            //Mayor o igual
            case ">=":

                if(left.getValue()==null || right.getValue() == null){
                    return null;
                }

                if(left.getValue() instanceof Integer && right.getValue() instanceof Integer){
                    int l = (int)left.getValue();
                    int r = (int)right.getValue();
                    return l>=r;
                }

                else if(left.getValue() instanceof String && right.getValue() instanceof String){
                    String l = (String) left.getValue();
                    String r = (String) right.getValue();
                    int compare = l.compareToIgnoreCase(r);
                    if(compare>0||compare==0){
                      return true;
                    }
                    else{
                      return false;
                    }
                }

                else if(left.getValue() instanceof Float && right.getValue() instanceof Float){
                    Float l = (Float) left.getValue();
                    Float r = (Float) right.getValue();
                    return l>=r;
                }

                else if(left.getValue() instanceof Date && right.getValue() instanceof Date){
                    Date l = (Date) left.getValue();
                    Date r= (Date) right.getValue();
                    int compare = l.compareTo(r);
                    if(compare >0||compare==0){
                      return true;
                    }
                    else{
                      return false;
                    }
                }

               else if(left.getValue() instanceof String && right.getValue() instanceof Date){
                    String l = left.getValue().toString();
                    String r = right.getValue().toString();
                    int compare = l.compareToIgnoreCase(r);
                    if(compare>0||compare==0){
                        return true;
                    }
                    else{
                      return false;
                    }
                }

                else if(left.getValue() instanceof Date && right.getValue() instanceof String){
                    String l = left.getValue().toString();
                    String r = right.getValue().toString();
                    int compare = l.compareToIgnoreCase(r);
                    if(compare>0||compare==0){
                        return true;
                    }
                    else{
                      return false;
                    }
                }

                else if(left.getValue() instanceof Float && right.getValue() instanceof Integer){
                    Float l = (Float)left.getValue();
                    int r = (int)right.getValue();
                    return l>=r;
                }

                else if(left.getValue() instanceof Integer && right.getValue() instanceof Float){
                    int l = (int)left.getValue();
                    Float r = (Float)right.getValue();
                    return l>=r;
                }

                else{
                    String s="ERROR: Valores "+left.getValue().toString()+", "+right.getValue().toString()+" no son comparables.";
                    throw new Exception(s);
                }



            //Menor que
            case "<":

                if(left.getValue()==null || right.getValue() == null){
                    return null;
                }

                if(left.getValue() instanceof Integer && right.getValue() instanceof Integer){
                    int l = (int)left.getValue();
                    int r = (int)right.getValue();
                    return l<r;
                }

                else if(left.getValue() instanceof String && right.getValue() instanceof String){
                    String l = (String) left.getValue();
                    String r = (String) right.getValue();
                    int compare = l.compareToIgnoreCase(r);
                    if(compare<0){
                      return true;
                    }
                    else{
                      return false;
                    }
                }

                else if(left.getValue() instanceof Float && right.getValue() instanceof Float){
                    Float l = (Float) left.getValue();
                    Float r = (Float) right.getValue();
                    return l<r;
                }

                else if(left.getValue() instanceof Date && right.getValue() instanceof Date){
                    Date l = (Date) left.getValue();
                    Date r= (Date) right.getValue();
                    int compare = l.compareTo(r);
                    if(compare <0){
                      return true;
                    }
                    else{
                      return false;
                    }
                }

               else if(left.getValue() instanceof String && right.getValue() instanceof Date){
                    String l = left.getValue().toString();
                    String r = right.getValue().toString();
                    int compare = l.compareToIgnoreCase(r);
                    if(compare<0){
                        return true;
                    }
                    else{
                      return false;
                    }
                }

                else if(left.getValue() instanceof Date && right.getValue() instanceof String){
                    String l = left.getValue().toString();
                    String r = right.getValue().toString();
                    int compare = l.compareToIgnoreCase(r);
                    if(compare<0){
                        return true;
                    }
                    else{
                      return false;
                    }
                }

                else if(left.getValue() instanceof Float && right.getValue() instanceof Integer){
                    Float l = (Float)left.getValue();
                    int r = (int)right.getValue();
                    return l<r;
                }

                else if(left.getValue() instanceof Integer && right.getValue() instanceof Float){
                    int l = (int)left.getValue();
                    Float r = (Float)right.getValue();
                    return l<r;
                }

                else{
                    String s="ERROR: Valores "+left.getValue().toString()+", "+right.getValue().toString()+" no son comparables.";
                    throw new Exception(s);
                }



            //Menor o igual que
            case "<=":

                if(left.getValue()==null || right.getValue() == null){
                    return null;
                }

                if(left.getValue() instanceof Integer && right.getValue() instanceof Integer){
                    int l = (int)left.getValue();
                    int r = (int)right.getValue();
                    return l<=r;
                }

                else if(left.getValue() instanceof String && right.getValue() instanceof String){
                    String l = (String) left.getValue();
                    String r = (String) right.getValue();
                    int compare = l.compareToIgnoreCase(r);
                    if(compare<0|| compare==0){
                      return true;
                    }

                    else{
                      return false;
                    }
                }

                else if(left.getValue() instanceof Float && right.getValue() instanceof Float){
                    Float l = (Float) left.getValue();
                    Float r = (Float) right.getValue();
                    return l<=r;
                }

                else if(left.getValue() instanceof Date && right.getValue() instanceof Date){
                    Date l = (Date) left.getValue();
                    Date r= (Date) right.getValue();
                    int compare = l.compareTo(r);
                    if(compare <0||compare==0){
                      return true;
                    }
                    else{
                      return false;
                    }
                }

               else if(left.getValue() instanceof String && right.getValue() instanceof Date){
                    String l = left.getValue().toString();
                    String r = right.getValue().toString();
                    int compare = l.compareToIgnoreCase(r);
                    if(compare<0||compare==0){
                        return true;
                    }
                    else{
                      return false;
                    }
                }

                else if(left.getValue() instanceof Date && right.getValue() instanceof String){
                    String l = left.getValue().toString();
                    String r = right.getValue().toString();
                    int compare = l.compareToIgnoreCase(r);
                    if(compare<0||compare==0){
                        return true;
                    }
                    else{
                      return false;
                    }
                }

                else if(left.getValue() instanceof Float && right.getValue() instanceof Integer){
                    Float l = (Float)left.getValue();
                    int r = (int)right.getValue();
                    return l<r;
                }

                else if(left.getValue() instanceof Integer && right.getValue() instanceof Float){
                    int l = (int)left.getValue();
                    Float r = (Float)right.getValue();
                    return l<r;
                }

                else{
                    String s="ERROR: Valores "+left.getValue().toString()+", "+right.getValue().toString()+" no son comparables.";
                    throw new Exception(s);
                }

                
        }

        //Si la comparacion no es valido
        throw new Exception("ERROR: Comparacion invalido");
    }

}
