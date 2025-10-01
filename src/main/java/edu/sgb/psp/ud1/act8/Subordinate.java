package edu.sgb.psp.ud1.act8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subordinate {
    public static void main(String[] args) {
        Object result = mayor(args);
        if (result != null) {
            System.out.println(result);
        }
        System.out.println(mayor(args));
    }

    static public Object mayor(String[] listaNumeros){
        if (listaNumeros.length==0){
            System.out.println("La lista esta vacía");
            return null;
        }
        int mayor=Integer.parseInt(listaNumeros[0]);
        for(String elemento: listaNumeros){
            if(Integer.parseInt(elemento)>mayor){
                mayor=Integer.parseInt(elemento);
            }
        }
        return mayor;
    }
}