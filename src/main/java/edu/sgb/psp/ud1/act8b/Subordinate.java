package edu.sgb.psp.ud1.act8b;

import java.util.List;

public class Subordinate {
    public static void main(String[] args) {

        if(args.length==0){
            System.out.println("No has introducido ningun numero");
        }else{
            try {
                int mayor = Integer.parseInt(args[0]);

                String[] arrayWords = args;
                for (String e : arrayWords) {
                    if (Integer.parseInt(e) > mayor) {
                        mayor = Integer.parseInt(e);
                    }
                }
                System.out.println(mayor);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
