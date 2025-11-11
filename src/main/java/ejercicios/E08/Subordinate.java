package ejercicios.E08;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subordinate {
    public static int main(String[] args) {
int max = Integer.MIN_VALUE;
       if(args.length ==0){
           System.out.println("no hsy numeros");
       }else{
           for(String e : args){
               try{
                   if (Integer.parseInt(e)>max){
                       max=Integer.parseInt(e);
                   }
               }catch (NumberFormatException ex){

               }
           }
       }
    return max;
    }
}
