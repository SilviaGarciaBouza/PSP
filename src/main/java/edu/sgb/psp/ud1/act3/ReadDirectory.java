package edu.sgb.psp.ud1.act3;

import java.io.File;
import java.util.Scanner;

public class ReadDirectory {
    public static void main(String[] args) {
        //Solicite al usuario la ruta absoluta de un directorio del que quiere consultar su contenido. Ejemplo C:\Users
        Scanner sc= new Scanner(System.in);
        System.out.println("Escribe una ruta absoluta de un directorio: ");
        String path= sc.nextLine();
        /* Muestre el contenido de dicho directorio en la consola del IDE */
      /*try(){
                ProcessBuilder p= new ProcessBuilder("ls", path);


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
*/
    }
}
